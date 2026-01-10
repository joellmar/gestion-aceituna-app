package com.joselumartos.gestionaceituna;

import com.joselumartos.gestionaceituna.model.*;
import com.joselumartos.gestionaceituna.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class GestionAceitunaApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestionAceitunaApplication.class, args);
    }

}

/*
('Aceites del Sur', 'Ctra. Córdoba s/n', '953000111', 50),
('Cooperativa La Verde', 'Polígono Los Olivares', '953000222', 120),
('Almazara Virgen del Valle', 'Camino del Río 4', '953000333', 30);
 */