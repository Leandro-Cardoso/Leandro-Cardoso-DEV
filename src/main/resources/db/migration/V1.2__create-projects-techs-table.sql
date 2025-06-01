CREATE TABLE tb_projects_techs (
    project_id UUID NOT NULL,
    tech_id UUID NOT NULL,
    PRIMARY KEY (project_id, tech_id),
    FOREIGN KEY (project_id) REFERENCES tb_projects(id) ON DELETE CASCADE,
    FOREIGN KEY (tech_id) REFERENCES tb_techs(id) ON DELETE CASCADE
);
