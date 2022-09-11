SET @@global.time_zone = '-3:00';
CREATE USER cadastroProduto@localhost IDENTIFIED BY 'cadastroProduto';
CREATE DATABASE cadastroProduto CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON cadastroProduto.* TO cadastroProduto@localhost;

USE cadastroProduto;

CREATE TABLE IF NOT EXISTS cadastroProduto (
  idProduto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(50) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  descricao TEXT NOT NULL,
  resumo VARCHAR(200) NOT NULL,
  quantidade INT NOT NULL)
ENGINE = InnoDB;

INSERT INTO cadastroProduto (tipo, 
nome, 
descricao, 
resumo, 
quantidade)
VALUES ("Smartphone", 
"Poco X3 Pro", 
"O Poco X3 Pro é um smartphone Android avançado e abrangente em todos os pontos 
de vista com algumas características excelentes. Tem uma grande tela de 6.67 polegadas com uma resolução de 2400x1080
pixels. As funcionalidades oferecidas pelo Poco X3 Pro são muitas e inovadoras. Começando pelo LTE 4G que permite a 
transferência de dados e excelente navegação na internet. Enfatizamos a excelente memória interna de 128 GB com a 
possibilidade de expansão.", 
"O Poco X3 Pro é um celular intermediário da Xiaomi que traz tela de 120 Hz, processador 
Snapdragon 860 e câmera de 64 MP.", 
1);
    

