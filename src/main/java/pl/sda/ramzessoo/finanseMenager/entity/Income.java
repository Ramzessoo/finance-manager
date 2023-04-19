package pl.sda.ramzessoo.finanseMenager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "income_ddl.sql")
@NoArgsConstructor
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

    public Income(Long quota, LocalDate addDate, String comment) {
        this.quota = quota;
        this.addDate = addDate;
        this.comment = comment;
    }
}
