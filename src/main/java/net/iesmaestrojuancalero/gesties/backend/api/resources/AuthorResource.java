package net.iesmaestrojuancalero.gesties.backend.api.resources;

import net.iesmaestrojuancalero.gesties.backend.api.dtos.AuthorDto;
import net.iesmaestrojuancalero.gesties.backend.domain.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Stream;

//@PreAuthorize("hasRole('ADMIN') or hasRole('OFFICE')")
@RestController
@RequestMapping(AuthorResource.AUTHORS)
public class AuthorResource {
    public static final String AUTHORS = "/authors";

    public static final String ID = "/{id}";
    public static final String SEARCH = "/search";

    private final AuthorService authorService;

    @Autowired
    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public void createUser(@Valid @RequestBody AuthorDto creationAuthorDto) {
        this.authorService.createAuthor(creationAuthorDto.toAuthor());
    }

    @GetMapping(ID)
    public AuthorDto readAuthor(@PathVariable String id) {
        return new AuthorDto(this.authorService.readById(id));
    }

    @GetMapping
    public Stream< AuthorDto > readAll() {
        return this.authorService.readAll().map(AuthorDto::ofFirstName);
    }

    @GetMapping(value = SEARCH)
    public Stream< AuthorDto > findByFirstNameAndLastName(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return this.authorService.findByFirstNameAndLastName(firstName, lastName)
                .map(AuthorDto::ofFirstName);
    }

}
