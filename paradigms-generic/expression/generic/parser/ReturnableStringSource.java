package expression.generic.parser;

public class ReturnableStringSource extends StringSource implements ReturnableCharSource {
    public ReturnableStringSource(String data) {
        super(data);
    }

    public void back() {
        back(1);
    }

    public void back(int delta) {
        pos -= delta;
    }
}
