package expression.generic.parser;


public class ReturnableBaseParser extends BaseParser{
    protected final ReturnableCharSource source;

    protected ReturnableBaseParser(final ReturnableCharSource source) {
        super(source);
        this.source = source;
    }

    public boolean checkString(String s) {
        int cnt = 0;
        while (cnt < s.length() && take(s.charAt(cnt))) {
            cnt++;
        }
        if (cnt == s.length()) return true;
        source.back(cnt + 1);
        ch = source.next();
        return false;
    }
}
