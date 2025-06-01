package dev.leandrocardoso.portfolio.repositories;

import dev.leandrocardoso.portfolio.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
