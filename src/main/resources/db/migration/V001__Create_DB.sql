CREATE TABLE IF NOT EXISTS cliente(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS contaspagar(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data DATE NOT NULL,
    datavencimento DATE NOT NULL,
    idcliente INT NOT NULL,
    valor DECIMAL(12,2) NOT NULL
);

ALTER TABLE contaspagar ADD CONSTRAINT fk_constaspagar_cliente FOREIGN KEY(idcliente) REFERENCES cliente(id);

INSERT INTO cliente(nome) VALUES ("Cléber"), ("João"), ("Lucas");

INSERT INTO contaspagar(data, datavencimento, idcliente, valor) VALUES
("2024/03/29", "2025/01/23", 1, 52.50),
("2022/02/04", "2022/12/29", 2, 37.97),
("2023/05/19", "2024/07/12", 3, 1230.45);