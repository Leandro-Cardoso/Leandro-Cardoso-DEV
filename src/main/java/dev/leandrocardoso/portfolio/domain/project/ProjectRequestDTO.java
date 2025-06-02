package dev.leandrocardoso.portfolio.domain.project;

import dev.leandrocardoso.portfolio.domain.tech.Tech;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record ProjectRequestDTO(
        String title,
        String description,
        String version,
        String platform,
        MultipartFile image,
        String projectUrl,
        Long date,
        List<Tech> techs
) {
}
