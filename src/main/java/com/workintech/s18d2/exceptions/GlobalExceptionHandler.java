package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlantException.class)
    public ResponseEntity<String> handlePlantException(PlantException ex) {
        log.error("PlantException yakalandı: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        log.error("Beklenmeyen bir hata yakalandı: ", ex); 
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Beklenmeyen bir hata oluştu: " + ex.getMessage());
    }
}
