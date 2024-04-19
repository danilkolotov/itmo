package markup;

import java.util.List;

public class Paragraph implements MarkdownElement, BBCodeElement, ListItemElement {
    List<MarkupElement> elements;

    public Paragraph(List<MarkupElement> elements) {
        this.elements = elements;
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        for (MarkupElement el : elements) {
            el.toMarkdown(sb);
        }
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        for (MarkupElement el : elements) {
            el.toBBCode(sb);
        }
    }
}
