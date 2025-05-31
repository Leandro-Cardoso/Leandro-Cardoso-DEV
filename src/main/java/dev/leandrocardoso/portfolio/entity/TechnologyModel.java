package dev.leandrocardoso.portfolio.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_technologies")
@Getter
@Setter
public class TechnologyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Builder
    public TechnologyModel(String name) {
        this.name = name;
    }

}
