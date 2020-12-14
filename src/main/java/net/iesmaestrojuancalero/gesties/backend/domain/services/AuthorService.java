package net.iesmaestrojuancalero.gesties.backend.domain.services;

import net.iesmaestrojuancalero.gesties.backend.data.daos.AuthorRepository;
import net.iesmaestrojuancalero.gesties.backend.data.model.Author;
import net.iesmaestrojuancalero.gesties.backend.domain.exceptions.ConflictException;
import net.iesmaestrojuancalero.gesties.backend.domain.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void createAuthor(Author author) {
        this.noExistByFirstNameAndLastName(author.getFirstName(), author.getLastName());
        this.authorRepository.save(author);
    }

    public Stream< Author > readAll() {
        return this.authorRepository.findAll().stream();
    }

    private void noExistByFirstNameAndLastName(String firstName, String lastName) {
        if (this.authorRepository.findByFirstNameAndLastName(firstName, lastName).stream().findFirst().isPresent()) {
            throw new ConflictException("The author already exists: " + lastName + ", " + firstName);
        }
    }

    public Stream< Author > findByFirstNameAndLastName(
            String firstName, String lastName) {
        return this.authorRepository.findByFirstNameAndLastName(firstName, lastName).stream();
    }

    public Author readById(String id) {
        return this.authorRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFoundException("The author doesn't exist: " + id));
    }
}
