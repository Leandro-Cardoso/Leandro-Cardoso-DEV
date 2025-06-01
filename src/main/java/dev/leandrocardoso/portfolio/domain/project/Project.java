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

    private String imgUrl;

    private String projectUrl;

    private Date date;

    @ManyToMany
    @JoinColumn(name = "tech_id")
    private List<Tech> techs;

}
