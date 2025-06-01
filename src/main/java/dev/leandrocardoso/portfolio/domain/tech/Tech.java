package dev.leandrocardoso.portfolio.domain.tech;

import dev.leandrocardoso.portfolio.domain.project.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_techs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tech {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String imgUrl;

    @ManyToMany
    @JoinColumn(name = "project_id")
    private List<Project> projects;

}
