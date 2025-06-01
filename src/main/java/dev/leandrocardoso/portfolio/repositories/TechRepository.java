package dev.leandrocardoso.portfolio.repositories;

import dev.leandrocardoso.portfolio.domain.tech.Tech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechRepository extends JpaRepository<Tech, UUID> {
}
