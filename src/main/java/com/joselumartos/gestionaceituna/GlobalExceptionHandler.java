package com.joselumartos.gestionaceituna;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public String manejarNoEncontrado(EntityNotFoundException ex, Model model) {
        model.addAttribute("mensaje", ex.getMessage());
        return "error/404";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String manejarArgumentoIlegal(IllegalArgumentException ex, Model model) {
        model.addAttribute("mensaje", ex.getMessage());
        return "error/404";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String manejarNoEncontrado(MethodArgumentNotValidException ex, Model model) {
        model.addAttribute("mensaje", ex.getMessage());
        return "error/404";
    }
}
