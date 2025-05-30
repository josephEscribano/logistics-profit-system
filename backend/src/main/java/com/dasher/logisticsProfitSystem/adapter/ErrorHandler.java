package com.dasher.logisticsProfitSystem.adapter;

import com.dasher.logisticsProfitSystem.adapter.rest.exception.ShipmentIllegalArgumentException;
import com.dasher.logisticsProfitSystem.adapter.rest.exception.ShipmentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

@ControllerAdvice
@Slf4j
public class ErrorHandler {
  private static ResponseEntity<Problem> handlerError(
      HttpStatus httpStatus, String typeException, Exception exception, Status status) {
    return ResponseEntity.status(httpStatus)
        .body(
            Problem.builder()
                .withTitle(typeException)
                .withDetail(exception.getMessage())
                .withStatus(status)
                .build());
  }

  @ExceptionHandler({ShipmentNotFoundException.class})
  public ResponseEntity<Problem> entityNotFoundHandleException(final Exception exception) {
    log.error(exception.getMessage());
    return handlerError(HttpStatus.NOT_FOUND, "Not Found", exception, Status.NOT_FOUND);
  }

  @ExceptionHandler({ShipmentIllegalArgumentException.class})
  public ResponseEntity<Problem> badRequestHandleException(final Exception exception) {
    log.error(exception.getMessage());
    return handlerError(HttpStatus.BAD_REQUEST, "Bad Request", exception, Status.BAD_REQUEST);
  }
}
