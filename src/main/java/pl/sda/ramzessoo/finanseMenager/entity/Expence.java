package pl.sda.ramzessoo.finanseMenager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "expence")
@AllArgsConstructor
@Getter
@Setter
public class Expence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quota")
    private long quota;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category categotyId;

    @Column(name = "add_date")
    private LocalDate addDate;

    @Column(name = "comment")
    private String comment;
}
