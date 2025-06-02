package dev.leandrocardoso.portfolio.controller;

import dev.leandrocardoso.portfolio.domain.project.Project;
import dev.leandrocardoso.portfolio.domain.project.ProjectRequestDTO;
import dev.leandrocardoso.portfolio.domain.tech.Tech;
import dev.leandrocardoso.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Project> create(@RequestParam("title") String title,
                                          @RequestParam(value = "description", required = false) String description,
                                          @RequestParam("version") String version,
                                          @RequestParam("platform") String platform,
                                          @RequestParam(value = "image", required = false) MultipartFile image,
                                          @RequestParam("projectUrl") String projectUrl,
                                          @RequestParam("date") Long date,
                                          @RequestParam("techs") List<Tech> techs) {
        ProjectRequestDTO projectRequestDTO = new ProjectRequestDTO(title, description, version, platform, image, projectUrl, date, techs);
        Project newProject = this.projectService.createProject(projectRequestDTO);
        return ResponseEntity.ok(newProject);
    }

}
