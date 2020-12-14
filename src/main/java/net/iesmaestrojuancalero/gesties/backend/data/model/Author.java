package net.iesmaestrojuancalero.gesties.backend.data.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    @Column(unique = true, nullable = false)
    private String firstName;
    @NonNull
    @Column(unique = true, nullable = false)
    private String lastName;

}
