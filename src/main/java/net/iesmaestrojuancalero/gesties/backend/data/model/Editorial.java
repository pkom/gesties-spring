package net.iesmaestrojuancalero.gesties.backend.data.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Builder
@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "editorials")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "editorial")
    private List< Book> books;

}
