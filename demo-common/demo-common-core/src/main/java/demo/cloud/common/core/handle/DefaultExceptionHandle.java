package demo.cloud.common.core.handle;


import demo.cloud.common.core.response.Resp;
import demo.cloud.common.core.response.RespEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class DefaultExceptionHandle {

    //validate 错误的返回
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public Resp<String> methodArgumentNotValidExceptionHandler(Exception e) {
        log.error("methodArgumentNotValidExceptionHandler", e);
        List<FieldError> fieldErrors = null;
        if (e instanceof MethodArgumentNotValidException) {
            fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
        }
        if (e instanceof BindException) {
            fieldErrors = ((BindException) e).getBindingResult().getFieldErrors();
        }
        if (fieldErrors == null) {
            return
                    Resp.fail(RespEnum.METHOD_ARGUMENT_NOT_VALID);
        }

        List<String> defaultMessages = new ArrayList<>(fieldErrors.size());
        for (FieldError fieldError : fieldErrors) {
            defaultMessages.add(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        }
        return Resp.fail(RespEnum.METHOD_ARGUMENT_NOT_VALID, defaultMessages.get(0));
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public Resp<String> illegalArgumentExceptionHandle(Exception e) {
        return Resp.fail( e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Resp<Object>> exceptionHandler(Exception e) {
        log.error("exceptionHandler", e);
//        log.info("RootContext.getXID(): " + RootContext.getXID());
//        if (StringUtils.isNotBlank(RootContext.getXID())) {
//            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
//        }
        return ResponseEntity.status(HttpStatus.OK).body(Resp.fail(RespEnum.EXCEPTION));
    }
}
