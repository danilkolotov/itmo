package markup;

import java.util.List;
import java.util.ArrayList;

public abstract class MarkupElement implements MarkdownElement, BBCodeElement {
    List<MarkupElement> elements;

    public MarkupElement(List<MarkupElement> elements) {
        this.elements = elements;
    }

    public MarkupElement() {
        this.elements = new ArrayList<>();
    }

    protected abstract String markdownTag();

    protected abstract String bbCodeOpenTag();

    protected abstract String bbCodeCloseTag();

    @Override
    public void toMarkdown(StringBuilder sb) {
        sb.append(markdownTag());
        for (MarkdownElement element : elements) {
            element.toMarkdown(sb);
        }
        sb.append(markdownTag());
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        sb.append(bbCodeOpenTag());
        for (BBCodeElement element : elements) {
            element.toBBCode(sb);
        }
        sb.append(bbCodeCloseTag());
    }
}
