package dev.leandrocardoso.portfolio.domain.project;

import dev.leandrocardoso.portfolio.domain.tech.Tech;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_projects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    private String description;

    private String version;

    private String platform;

    @Column(name = "imgurl")
    private String imgUrl;

    @Column(name = "projecturl")
    private String projectUrl;

    private Date date;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_projects_techs",
            joinColumns = @JoinColumn(name = "project_id"), // Coluna na tabela de junção que referencia o ProjectModel
            inverseJoinColumns = @JoinColumn(name = "tech_id") // Coluna na tabela de junção que referencia o TechnologyModel
    )
    private List<Tech> techs;

}
