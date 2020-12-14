package net.iesmaestrojuancalero.gesties.backend.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.iesmaestrojuancalero.gesties.backend.data.model.Author;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDto {
    @NotNull
    @NotBlank
    private String firstName;
    private String lastName;

    public AuthorDto(Author author) {
        BeanUtils.copyProperties(author, this);
    }

    public static AuthorDto ofFirstName(Author author) {
        return AuthorDto.builder().firstName(author.getFirstName()).build();
    }

    public void doDefault() {
        if (Objects.isNull(lastName)) {
            lastName = "";
        }
    }

    public Author toAuthor() {
        this.doDefault();
        Author author = new Author();
        BeanUtils.copyProperties(this, author);
        return author;
    }
}
