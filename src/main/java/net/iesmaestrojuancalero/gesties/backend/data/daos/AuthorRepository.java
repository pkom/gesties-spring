package net.iesmaestrojuancalero.gesties.backend.data.daos;

import net.iesmaestrojuancalero.gesties.backend.data.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

    @Query("select a from Author a where " +
            "(?1 is null or a.firstName like concat('%',?1,'%')) and " +
            "(?2 is null or lower(a.lastName) like lower(concat('%',?2,'%')))")
    List<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
