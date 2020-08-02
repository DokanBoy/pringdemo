package pw.zakharov.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 17:29
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UnknownUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UnknownUserException unknownUserException(UnknownUserException exception) {
        return exception;
    }

    @ExceptionHandler(UnknownQuestionException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UnknownQuestionException unknownUserException(UnknownQuestionException exception) {
        return exception;
    }
}
