package com.joselumartos.gestionaceituna;

import com.joselumartos.gestionaceituna.model.Almazara;
import com.joselumartos.gestionaceituna.repository.AlmazaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.*;

import java.util.List;

@SpringBootApplication
public class GestionAceitunaApplication implements CommandLineRunner {

    @Autowired
    AlmazaraRepository almazaraRepo;

    public static void main(String[] args) {
        SpringApplication.run(GestionAceitunaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Almazara almazara1 = Almazara.builder()
                .nombre("Aceites del Sur")
                .direccion("Ctra. Córdoba s/n")
                .telefono("953000111")
                .capacidadToneladasDiarias(50)
                .build();

        Almazara almazara2 = Almazara.builder()
                .nombre("Cooperativa La Verde")
                .direccion("Polígono Los Olivares")
                .telefono("953000222")
                .capacidadToneladasDiarias(120)
                .build();

        Almazara almazara3 = Almazara.builder()
                .nombre("Almazara Virgen del Valle")
                .direccion("Camino del Río 4")
                .telefono("953000333")
                .capacidadToneladasDiarias(30)
                .build();

        // Insertamos una única instancia de la entidad Almazara
        almazara1 = almazaraRepo.save(almazara1);

        // Insertamos múltiples instancias a la vez
        List<Almazara> almazarasInsertadas = almazaraRepo.saveAll(List.of(almazara2, almazara3));

        // Nos aseguramos de que todas las entidades son realmente guardadas en la BBDD
        almazaraRepo.flush();

        // actualizamos almazara2 y almazara3 para que tengan una capacidad de 999 toneladas diarias en la BBDD
        for (Almazara almazara : almazarasInsertadas) {
            almazara.setCapacidadToneladasDiarias(999);
            almazaraRepo.save(almazara);
        }

        System.out.println("TODAS LAS ALMAZARAS EN ORDEN DESCENDIENTE SEGÚN ID");
        // Obtenemos todas las almazaras en orden descendiente e imprimimos toString() en la consola
        almazaraRepo.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(System.out::println);

        // Las obtenemos todas utilizando un ejemplo
        System.out.println("ENCONTRARLAS TODAS USANDO EXAMPLE");
        almazaraRepo.findAll(Example.of(
                // Almazara de sondeo para encontrar coincidencias
                Almazara.builder().capacidadToneladasDiarias(999).build(),
                // Pide a la BBDD que devuelva los registros que coincidan con cualquiera de los campos de la sonda
                ExampleMatcher.matchingAny())

        ).forEach(System.out::println);

        // Crear una petición de página para paginar a través de estas tres almazaras.
        // Notar que la primera página se indica usando 0
        PageRequest pageRequest = PageRequest.of(0, 2);

        System.out.println("PRIMERA PÁGINA");
        // Obtener la primera página
        Page<Almazara> page = almazaraRepo.findAll(pageRequest);
        page.getContent().forEach(System.out::println);

        System.out.println("SEGUNDA PÁGINA");
        // Obtener la segunda página
        page = almazaraRepo.findAll(pageRequest.next());
        page.getContent().forEach(System.out::println);

        // Borrar las 3 almazaras en bloque
        almazaraRepo.deleteAllInBatch();
    }
}

/*
('Aceites del Sur', 'Ctra. Córdoba s/n', '953000111', 50),
('Cooperativa La Verde', 'Polígono Los Olivares', '953000222', 120),
('Almazara Virgen del Valle', 'Camino del Río 4', '953000333', 30);
 */