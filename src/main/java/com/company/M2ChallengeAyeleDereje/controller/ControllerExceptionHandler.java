package com.company.M2ChallengeAyeleDereje.controller;
import com.company.M2ChallengeAyeleDereje.model.CustomErrResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<List<CustomErrResponse>> newResponseErrors(MethodArgumentNotValidException e) {

        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrs = result.getFieldErrors();

        List<CustomErrResponse> errorResponseList = new ArrayList<>();

        for (FieldError fieldErr : fieldErrs) {
            CustomErrResponse errResponse = new CustomErrResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), fieldErr.getDefaultMessage());
            errResponse.setTimestamp(LocalDateTime.now());
            errResponse.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
            errorResponseList.add(errResponse);
        }
        ResponseEntity<List<CustomErrResponse>> responseEntity = new ResponseEntity<>(errorResponseList, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrResponse> outOfRangeException(IllegalArgumentException e) {
        CustomErrResponse err = new CustomErrResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), e.getMessage());
        err.setTimestamp(LocalDateTime.now());
        err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        ResponseEntity<CustomErrResponse> responseEntity = new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrResponse> notIntegerException(HttpMessageNotReadableException e) {
        CustomErrResponse error = new CustomErrResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), e.getMessage());
        error.setStatus((HttpStatus.UNPROCESSABLE_ENTITY.value()));
        error.setTimestamp(LocalDateTime.now());
        ResponseEntity<CustomErrResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

}
