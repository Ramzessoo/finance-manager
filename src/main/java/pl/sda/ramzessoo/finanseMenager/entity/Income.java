package pl.sda.ramzessoo.finanseMenager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "income")
@AllArgsConstructor
@Getter
@Setter


public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guota")
    private Long quota;
    @Column(name = "add_date")
    private LocalDate addDate;
    @Column(name = "comment")
    private String comment;
}
