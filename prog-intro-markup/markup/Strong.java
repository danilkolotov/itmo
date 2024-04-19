package markup;

import java.util.List;

public class Strong extends MarkupElement{

    public Strong(List<MarkupElement> elements) {
        super(elements);
    }

    @Override
    protected String markdownTag() {
        return "__";
    }

    @Override
    protected String bbCodeOpenTag() {
        return "[b]";
    }

    @Override
    protected String bbCodeCloseTag() {
        return "[/b]";
    }
}
