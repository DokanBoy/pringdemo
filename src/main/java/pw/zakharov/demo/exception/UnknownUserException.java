package pw.zakharov.demo.exception;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 17:27
 */
public class UnknownUserException extends Exception {

    public UnknownUserException(String s) {
        super(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
