package org.musalasoft.controlltower.config;

import org.musalasoft.controlltower.domain.excepion.ServiceLevelException;
import org.musalasoft.libs.response.ErrorResponseBody;
import org.musalasoft.libs.response.RESTResponse;
import org.musalasoft.libs.response.RESTResponseManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisorConfig extends ResponseEntityExceptionHandler {

    /**
     * Custom Exception handling
     * Prepare conventional error response
     * This responses can be change
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = ServiceLevelException.class)
    protected ErrorResponseBody handleConflict(ServiceLevelException ex, WebRequest request) {
        return RESTResponseManager.headerBuilder(HttpStatus.CONFLICT)
                .errorBodyBuilder()
                .setError("Service level exception")
                .setPath(request.getContextPath())
                .setMessage(ex.getMessage())
                .build();
    }

    /**
     * Original method overriding for conventional error response
     *
     * @param ex
     * @param request
     * @return
     */
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    protected ErrorResponseBody handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
//        List<String> messages = new ArrayList<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String errorMessage = error.getDefaultMessage();
//            messages.add(errorMessage);
//        });
//
//        return RESTResponseManager.headerBuilder(HttpStatus.BAD_REQUEST)
//                .errorBodyBuilder()
//                .setError("Request not accepted")
//                .setPath(request.getContextPath())
//                .setMessage(messages.toString())
//                .build();
//    }
}
