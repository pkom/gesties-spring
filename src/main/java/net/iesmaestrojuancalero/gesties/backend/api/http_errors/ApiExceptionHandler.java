package net.iesmaestrojuancalero.gesties.backend.api.http_errors;

import net.iesmaestrojuancalero.gesties.backend.domain.exceptions.BadRequestException;
import net.iesmaestrojuancalero.gesties.backend.domain.exceptions.ConflictException;
import net.iesmaestrojuancalero.gesties.backend.domain.exceptions.ForbiddenException;
import net.iesmaestrojuancalero.gesties.backend.domain.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({
            UnauthorizedException.class,
            org.springframework.security.access.AccessDeniedException.class
    })
    @ResponseBody
    public void unauthorizedRequest() {
        //Empty. Nothing to do
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            NotFoundException.class
    })
    @ResponseBody
    public net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage notFoundRequest(Exception exception) {
        return new net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage(exception, HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.dao.DuplicateKeyException.class,
            org.springframework.web.HttpRequestMethodNotSupportedException.class,
            org.springframework.web.bind.MethodArgumentNotValidException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class
    })
    @ResponseBody
    public net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage badRequest(Exception exception) {
        return new net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage(exception, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            ConflictException.class
    })
    @ResponseBody
    public net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage conflict(Exception exception) {
        return new net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage(exception, HttpStatus.CONFLICT.value());
    }


    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({
            ForbiddenException.class
    })
    @ResponseBody
    public net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage forbidden(Exception exception) {
        return new net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage(exception, HttpStatus.FORBIDDEN.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            Exception.class
    })
    @ResponseBody
    public net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage exception(Exception exception) { // The error must be corrected
        exception.printStackTrace();
        return new net.iesmaestrojuancalero.gesties.backend.api.http_errors.ErrorMessage(exception, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
