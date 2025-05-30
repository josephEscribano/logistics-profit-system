package com.dasher.logisticsProfitSystem.adapter.rest.exception;

public class ShipmentNotFoundException extends RuntimeException {
  public ShipmentNotFoundException(String message) {
    super(message);
  }
}
