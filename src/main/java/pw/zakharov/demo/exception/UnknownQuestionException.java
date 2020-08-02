package pw.zakharov.demo.exception;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 31.07.2020 16:01
 */
public class UnknownQuestionException extends Exception{

    public UnknownQuestionException(String s) {
        super(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
