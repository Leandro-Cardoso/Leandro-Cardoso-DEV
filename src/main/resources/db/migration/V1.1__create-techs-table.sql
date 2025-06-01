CREATE TABLE tb_techs (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    imgUrl VARCHAR(100) NOT NULL
);
