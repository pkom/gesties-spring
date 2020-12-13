package net.iesmaestrojuancalero.gesties.backend.models;

import lombok.Data;
import net.iesmaestrojuancalero.gesties.backend.repositories.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true)
    private String name;
    private String description;

    private @CreatedDate
    LocalDateTime createdDate;
    private @LastModifiedDate
    LocalDateTime lastModifiedDate;

    public Course() {}

    public Course(String name, String description) {

        this.name = name;
        this.description = description;
    }

}

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CourseRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Course("2020/2021", "Curso 2020/2021")));
            log.info("Preloading " + repository.save(new Course("2021/2022", "Curso 2021/2022")));
        };
    }
}

