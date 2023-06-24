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
