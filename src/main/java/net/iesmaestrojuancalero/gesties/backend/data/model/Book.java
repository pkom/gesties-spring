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
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    @Column(unique = true, nullable = false)
    private String title;
    @Column(unique = true, nullable = false)
    private String isbn;
    @Column(unique = true)
    private String barcode;
    private int year;
    private int stock;
    private boolean active;

    @OneToMany
    private List< Author > authors;

    @ManyToOne
    private Level level;

    @ManyToOne
    private Editorial editorial;


    @OneToMany(mappedBy = "book")
    private List< Copy > copies;

}
