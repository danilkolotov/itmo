package markup;

import java.util.List;

public class ListItem implements BBCodeElement{
    List<ListItemElement> elements;

    public ListItem(List<ListItemElement> elements){
        this.elements = elements;
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        sb.append("[*]");
        for (BBCodeElement element: elements){
            element.toBBCode(sb);
        }
    }

}
