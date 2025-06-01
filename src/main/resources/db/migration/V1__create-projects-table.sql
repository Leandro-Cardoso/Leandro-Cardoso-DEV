CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_projects (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(300) NOT NULL,
    version VARCHAR(100) NOT NULL,
    platform VARCHAR(100) NOT NULL,
    imgUrl VARCHAR(100) NOT NULL,
    projectUrl VARCHAR(100) NOT NULL,
    date TIMESTAMP NOT NULL
);
