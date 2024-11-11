package com.example.onlineticketing.comms.exceptionhandler;

import com.example.onlineticketing.comms.helper.HelperUtil;
import com.example.onlineticketing.controller.PatientsController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class CustomExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(PatientsController.class);
    @ExceptionHandler(RestException.class)
    public ResponseEntity<Map<String, String>> handelRestException(RestException ex) {
        LOG.info("Rest exception :: {}", String.valueOf(ex));
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("code", ex.getCode());
        errorResponse.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        LOG.info("Method argument not valid exception :: {}", String.valueOf(exception));
//        List<String> errors = exception.getBindingResult().getFieldErrors().stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.toList());
        Map<String, String> detailErrorMessages = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(message->detailErrorMessages.put(message.getField(), message.getDefaultMessage()));
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", "Request body not valid.");
        errorResponse.put("code", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("timeStamp", HelperUtil.getLocalDateTimeOfUTC());
        errorResponse.put("detailMessage", detailErrorMessages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, String>> handelAccessDenied(AccessDeniedException ex) {
        LOG.info("Access denied exception :: {}", String.valueOf(ex));
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handelRuntimeException(RuntimeException ex) {
        ex.printStackTrace();
        LOG.info("Runtime exception :: {}", String.valueOf(ex));
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
