package markup;

import java.util.List;

public class OrderedList extends MarkupList{

    public OrderedList(List<ListItem> elements) {
        super(elements);
    }


    @Override
    protected String bbCodeOpenTag() {
        return "[list=1]";
    }

    @Override
    protected String bbCodeCloseTag() {
        return "[/list]";
    }


}
