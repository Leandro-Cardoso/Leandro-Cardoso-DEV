package dev.leandrocardoso.portfolio.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_projects")
@Getter
@Setter
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "technologies", nullable = false)
    private List<TechnologyModel> technologies;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "repository")
    private String repository;

    @Builder
    public ProjectModel(String name, LocalDate date, List<TechnologyModel> technologies, String description, String repository) {
        this.name = name;
        this.date = date;
        this.technologies = technologies;
        this.description = description;
        this.repository = repository;
    }

}
