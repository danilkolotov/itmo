package markup;

import java.util.List;

public class Strikeout extends MarkupElement{
    public Strikeout(List<MarkupElement> elements) {
        super(elements);
    }

    @Override
    protected String markdownTag() {
        return "~";
    }

    @Override
    protected String bbCodeOpenTag() {
        return "[s]";
    }

    @Override
    protected String bbCodeCloseTag() {
        return "[/s]";
    }
}
