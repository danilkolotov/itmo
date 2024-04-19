package expression.generic.parser;
public interface ReturnableCharSource extends CharSource {
    void back();
    void back(int delta);

}
