package markup;

import java.util.List;

public abstract class MarkupList implements ListItemElement{
    List<ListItem> elements;

    public MarkupList(List<ListItem> elements){
        this.elements = elements;
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        sb.append(bbCodeOpenTag());
        for (BBCodeElement element: elements){
            element.toBBCode(sb);
        }
        sb.append(bbCodeCloseTag());
    }

    protected abstract String bbCodeOpenTag();

    protected abstract String bbCodeCloseTag();
}
