package hello.exception.exhandler.advice;

import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * // Target all Controllers annotated with @RestController
 * @ControllerAdvice(annotations = RestController.class)
 *
 * // Target all Controllers within specific packages
 * @ControllerAdvice("org.example.controllers")
 *
 * // Target all Controllers assignable to specific classes
 * @ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})
 */
@Slf4j
@RestControllerAdvice
//@RestControllerAdvice(basePackages = "hello.exception.api")
public class ExControllerAdvice {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public ErrorResult illegalExHandle(IllegalArgumentException e) {
    log.error("[exceptionHandle] ex", e);
    return new ErrorResult("BAD", e.getMessage());
  }

  @ExceptionHandler
  public ResponseEntity<ErrorResult> userExHandle(UserException e) {
    log.error("[exceptionHandle] ex", e);
    ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
    return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler
//  @ExceptionHandler({AException.class, BException.class})
  public ErrorResult exHandle(Exception e) {
    log.error("[exceptionHandle] ex", e);
    return new ErrorResult("EX", "내부 오류");
  }

}
