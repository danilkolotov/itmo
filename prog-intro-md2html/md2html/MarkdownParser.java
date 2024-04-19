package md2html;

import java.util.*;

public class MarkdownParser {
    private static class Tag {
        final String mdOpen, mdClose, html;

        public Tag(String md, String html) {
            this.mdOpen = md;
            this.mdClose = md;
            this.html = html;
        }

        public Tag(String mdOpen, String mdClose, String html) {
            this.mdOpen = mdOpen;
            this.mdClose = mdClose;
            this.html = html;
        }

        public String getMdOpen() {
            return mdOpen;
        }

        public String getMdClose() {
            return mdClose;
        }

        public String getHtml() {
            return html;
        }
    }

    private final static List<Tag> tags = new ArrayList<>(List.of(
            new Tag("*", "em"),
            new Tag("_", "em"),
            new Tag("__", "strong"),
            new Tag("**", "strong"),
            new Tag("--", "s"),
            new Tag("`", "code"),
            new Tag("<<", ">>", "ins"),
            new Tag("}}", "{{", "del")
    ));
    private final static Map<Character, String> special = Map.of(
            '<', "&lt;",
            '>', "&gt;",
            '&', "&amp;"
    );
    private final static List<String> allTags;

    static {
        allTags = new ArrayList<>();
        for (Tag tag : tags) {
            allTags.add(tag.getMdOpen());
            if (!tag.getMdOpen().equals(tag.getMdClose())) {
                allTags.add(tag.getMdClose());
            }
        }
        tags.sort((t1, t2) -> -Integer.compare(t1.getMdOpen().length(), t2.getMdOpen().length()));
        allTags.sort((s1, s2) -> -Integer.compare(s1.length(), s2.length()));

    }

    private static void parse(String string, Map<String, NavigableSet<Integer>> occurrences, StringBuilder result) {
        Stack<Integer> closePositions = new Stack<>();
        Stack<Tag> foundTags = new Stack<>();
        int i = 0;
        while (i < string.length()) {
            if (string.charAt(i) == '\\') {
                i++;
                if (i < string.length()) {
                    add(result, string.charAt(i));
                }
                i++;
                continue;
            }
            if (!closePositions.empty() && closePositions.peek() == i) {
                result.append("</").append(foundTags.peek().getHtml()).append(">");
                i += foundTags.peek().getMdClose().length();
                closePositions.pop();
                foundTags.pop();
                continue;
            }
            boolean find = false;
            for (Tag tag : tags) {
                String open = tag.getMdOpen();
                String close = tag.getMdClose();
                String html = tag.getHtml();
                if (occurrences.get(open).contains(i)) {
                    Integer pos = nearestClose(i + open.length(), (closePositions.empty() ? string.length() : closePositions.peek()), occurrences.get(close));
                    if (pos != null) {
                        result.append("<").append(html).append(">");
                        closePositions.push(pos);
                        foundTags.push(tag);
                        find = true;
                        i += open.length();
                        break;
                    }
                }
            }
            if (!find) {
                add(result, string.charAt(i));
                i++;
            }
        }
    }

    public static String parseParagraph(String paragraph) {
        StringBuilder result = new StringBuilder();
        int headingLevel = getHeadingLevel(paragraph);
        Map<String, NavigableSet<Integer>> occurrences = new HashMap<>();
        for (String tag : allTags) {
            occurrences.put(tag, new TreeSet<>());
        }
        int i = 0;
        int start = (headingLevel == 0) ? 0 : (headingLevel + 1);
        while (i < paragraph.length()) {
            if (paragraph.charAt(i) == '\\') {
                i += 2;
                continue;
            }
            for (String tag : allTags) {
                StringBuilder candidate = new StringBuilder();
                if (i + tag.length() > paragraph.length()) {
                    continue;
                }
                for (int j = 0; j < tag.length(); j++) {
                    candidate.append(paragraph.charAt(i + j));
                }
                if (candidate.toString().equals(tag)) {
                    occurrences.get(tag).add(i - start);
                    i += tag.length() - 1;
                    break;
                }
            }
            i++;
        }
        parse(paragraph.substring(start), occurrences, result);
        makeParagraph(result, headingLevel);
        return result.toString();
    }

    private static void makeParagraph(StringBuilder result, int headingLevel) {
        String tag = (headingLevel == 0) ? "p" : ("h" + headingLevel);
        result.insert(0, "<" + tag + ">");
        result.append("</").append(tag).append(">").append(System.lineSeparator());
    }

    private static int getHeadingLevel(String paragraph) {
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) != '#') {
                if (i > 0 && Character.getType(paragraph.charAt(i)) != Character.SPACE_SEPARATOR) return 0;
                return i;
            }
        }
        return 0;
    }

    private static void add(StringBuilder sb, char c) {
        sb.append(special.getOrDefault(c, Character.toString(c)));
    }

    private static Integer nearestClose(int l, int r, NavigableSet<Integer> set) {
        Integer pos = set.higher(l);
        if (pos != null && pos < r) {
            return pos;
        }
        return null;
    }
}
