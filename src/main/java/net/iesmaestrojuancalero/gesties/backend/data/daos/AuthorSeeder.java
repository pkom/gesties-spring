package net.iesmaestrojuancalero.gesties.backend.data.daos;

import net.iesmaestrojuancalero.gesties.backend.data.model.Author;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class AuthorSeeder {

    private final DatabaseStarting databaseStarting;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorSeeder(AuthorRepository authorRepository, DatabaseStarting databaseStarting) {
        this.authorRepository = authorRepository;
        this.databaseStarting = databaseStarting;
    }

    public void deleteAllAndInitializeAndSeedDataBase() {
        this.deleteAllAndInitialize();
        this.seedDataBase();
    }

    public void deleteAllAndInitialize() {
        this.authorRepository.deleteAll();
        LogManager.getLogger(this.getClass()).warn("------- Deleted All -----------");
        this.databaseStarting.initialize();
    }

    private void seedDataBase() {
        LogManager.getLogger(this.getClass()).warn("------- Initial Load from JAVA -----------");
        Author[] authors = {
                Author.builder().firstName("Author 1 First Name").lastName("Author 1 Last Name").build(),
                Author.builder().firstName("Author 2 First Name").lastName("Author 2 Last Name").build(),
                Author.builder().firstName("Author 3 First Name").lastName("Author 3 Last Name").build(),
                Author.builder().firstName("Author 4 First Name").lastName("Author 4 Last Name").build(),
                Author.builder().firstName("Author 5 First Name").lastName("Author 5 Last Name").build(),
                Author.builder().firstName("Author 6 First Name").lastName("Author 6 Last Name").build(),
                Author.builder().firstName("Author 7 First Name").lastName("Author 7 Last Name").build(),
        };
        this.authorRepository.saveAll(Arrays.asList(authors));
        LogManager.getLogger(this.getClass()).warn("        ------- authors");
    }

}
