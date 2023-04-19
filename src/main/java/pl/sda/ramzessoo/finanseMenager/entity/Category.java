package pl.sda.ramzessoo.finanseMenager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
