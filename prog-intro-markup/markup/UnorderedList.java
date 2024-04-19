package markup;

import java.util.List;

public class UnorderedList extends MarkupList {
    public UnorderedList(List<ListItem> elements) {
        super(elements);
    }

    @Override
    protected String bbCodeOpenTag() {
        return "[list]";
    }

    @Override
    protected String bbCodeCloseTag() {
        return "[/list]";
    }

}
