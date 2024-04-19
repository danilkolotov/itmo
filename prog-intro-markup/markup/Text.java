package markup;


public class Text extends MarkupElement{
    private final String text;
    public Text(String text){
        this.text = text;
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        sb.append(text);
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        sb.append(text);
    }


    @Override
    protected String markdownTag() {
        return "";
    }

    @Override
    protected String bbCodeOpenTag() {
        return "";
    }

    @Override
    protected String bbCodeCloseTag() {
        return "";
    }
}
