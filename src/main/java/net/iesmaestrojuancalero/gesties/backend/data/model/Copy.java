package net.iesmaestrojuancalero.gesties.backend.data.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "copies")
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    private String barcode;
    @Enumerated(EnumType.STRING)
    private CopyStatus status;

    @ManyToOne
    private Book book;

}
