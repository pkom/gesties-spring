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
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    @Column(unique = true, nullable = false)
    private String level;
    @Column(unique = true, nullable = false)
    private String description;

    @OneToMany(mappedBy = "level")
    private List< Book > books;

}
