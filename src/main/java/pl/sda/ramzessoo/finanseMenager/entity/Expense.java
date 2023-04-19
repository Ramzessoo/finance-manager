package pl.sda.ramzessoo.finanseMenager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "expense")
@NoArgsConstructor
@Getter
@Setter
public class Expense {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quota")
    private long quota;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @Column(name = "add_date")
    private LocalDate addDate;

    @Column(name = "comment")
    private String comment;

    public Expense(long quota, Category categoryId, LocalDate addDate, String comment) {
        this.quota = quota;
        this.categoryId = categoryId;
        this.addDate = addDate;
        this.comment = comment;
    }
}
