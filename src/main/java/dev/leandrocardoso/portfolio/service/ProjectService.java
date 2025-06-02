package dev.leandrocardoso.portfolio.service;

import com.amazonaws.services.s3.AmazonS3;
import dev.leandrocardoso.portfolio.domain.project.Project;
import dev.leandrocardoso.portfolio.domain.project.ProjectRequestDTO;
import dev.leandrocardoso.portfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProjectService {

    @Value("${aws.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
    private ProjectRepository repository;

    public Project createProject(ProjectRequestDTO data) {
        String imgUrl = null;

        if (data.image() != null) {
            imgUrl = this.uploadImg(data.image());
        }

        Project newProject = new Project();
        newProject.setTitle(data.title());
        newProject.setDescription(data.description());
        newProject.setVersion(data.version());
        newProject.setPlatform(data.platform());
        newProject.setImgUrl(imgUrl);
        newProject.setProjectUrl(data.projectUrl());
        newProject.setDate(new Date(data.date()));
        newProject.setTechs(data.techs());

        repository.save(newProject);

        return newProject;
    }

    private String uploadImg(MultipartFile multipartFile) {
        String filename = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        try {
            File file = this.convertMultipartToFile(multipartFile);
            s3Client.putObject(bucketName, filename, file);
            file.delete();
            return s3Client.getUrl(bucketName, filename).toString();
        } catch (Exception e) {
            System.out.println("erro ao subir arquivo");
            return "";
        }
    }

    private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();

        return convFile;
    }

}
