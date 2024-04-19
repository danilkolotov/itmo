package markup;

import java.util.List;

public class Emphasis extends MarkupElement{
    public Emphasis(List<MarkupElement> elements) {
        super(elements);
    }

    @Override
    protected String markdownTag() {
        return "*";
    }

    @Override
    protected String bbCodeOpenTag() {
        return "[i]";
    }

    @Override
    protected String bbCodeCloseTag() {
        return "[/i]";
    }
}
