package net.iesmaestrojuancalero.gesties.backend.data.daos;

import net.iesmaestrojuancalero.gesties.backend.data.model.Author;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DatabaseStarting {

    private final AuthorRepository authorRepository;

    @Autowired
    public DatabaseStarting(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.initialize();
    }

    void initialize() {
        LogManager.getLogger(this.getClass()).warn("------- Running DatabaseStarting initialize method -----------");
        LogManager.getLogger(this.getClass()).warn("------- finished running DatabaseStarting initialize method -----------");
    }

}
