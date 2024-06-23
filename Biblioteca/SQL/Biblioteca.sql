-- MySQL Workbench Forward Engineering


-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS biblioteca;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`autores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`autores` (
  `nomeautor` VARCHAR(45) NOT NULL,
  `nacionalidade` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`nomeautor`))
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`editora` (
  `nomeeditora` VARCHAR(45) NOT NULL,
  `enderecoeditora` VARCHAR(45) NULL DEFAULT NULL,
  `telefoneeditora` VARCHAR(11) NULL DEFAULT NULL,
  PRIMARY KEY (`nomeeditora`))
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`leitores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`leitores` (
  `matriculaleitores` INT(5) UNSIGNED ZEROFILL NOT NULL,
  `nomeleitores` VARCHAR(45) NOT NULL,
  `telefoneleitores` VARCHAR(11) NOT NULL,
  `emailleitores` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matriculaleitores`))4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`funcionarios` (
  `matriculafuncionario` INT(6) UNSIGNED ZEROFILL NOT NULL,
  `nomefuncionario` VARCHAR(45) NOT NULL,
  `enderecofuncionario` VARCHAR(45) NOT NULL,
  `telefonefuncionario` VARCHAR(11) NOT NULL,
  `emailfuncionario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matriculafuncionario`))
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`emprestimos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`emprestimos` (
  `idemprestimos` INT(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `tomboemprestimo` INT NOT NULL,
  `dataemprestimo` DATE NOT NULL,
  `dataretorno` DATE NOT NULL,
  `leitor` INT(5) UNSIGNED ZEROFILL NOT NULL,
  `funcionario` INT(6) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`idemprestimos`, `leitor`, `funcionario`),
  CONSTRAINT `fk_emprestimos_leitores1`
    FOREIGN KEY (`leitor`)
    REFERENCES `biblioteca`.`leitores` (`matriculaleitores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimos_funcionarios1`
    FOREIGN KEY (`funcionario`)
    REFERENCES `biblioteca`.`funcionarios` (`matriculafuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`generos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`generos` (
  `nomegenero` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nomegenero`))
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`livros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`livros` (
  `tombo` INT(4) UNSIGNED ZEROFILL NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `editora_nomeeditora` VARCHAR(45) NOT NULL,
  `isbn` VARCHAR(45) NULL DEFAULT NULL,
  `genero` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tombo`, `editora_nomeeditora`),
  CONSTRAINT `fk_livros_editora1`
    FOREIGN KEY (`editora_nomeeditora`)
    REFERENCES `biblioteca`.`editora` (`nomeeditora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


-- -----------------------------------------------------
-- Table `biblioteca`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`reserva` (
  `idreserva` INT(10) UNSIGNED ZEROFILL NOT NULL,
  `tomboreserva` INT NOT NULL,
  `funcionario` INT NOT NULL,
  `leitores_matriculaleitores` INT(5) UNSIGNED ZEROFILL NOT NULL,
  `datareserva` DATE NOT NULL,
  PRIMARY KEY (`idreserva`),
  CONSTRAINT `fk_reserva_leitores1`
    FOREIGN KEY (`leitores_matriculaleitores`)
    REFERENCES `biblioteca`.`leitores` (`matriculaleitores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_funcionarios1`
    FOREIGN KEY (`funcionario`)
    REFERENCES `biblioteca`.`funcionarios` (`matriculafuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`livros_has_autores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`livros_has_autores` (
  `livros_tombo` INT(4) UNSIGNED ZEROFILL NOT NULL,
  `autores_nomeautor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`livros_tombo`, `autores_nomeautor`),
  CONSTRAINT `fk_livros_has_autores_livros`
    FOREIGN KEY (`livros_tombo`)
    REFERENCES `biblioteca`.`livros` (`tombo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livros_has_autores_autores1`
    FOREIGN KEY (`autores_nomeautor`)
    REFERENCES `biblioteca`.`autores` (`nomeautor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


-- -----------------------------------------------------
-- Table `biblioteca`.`livros_has_generos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`livros_has_generos` (
  `livros_tombo` INT(4) UNSIGNED ZEROFILL NOT NULL,
  `livros_editora_nomeeditora` VARCHAR(45) NOT NULL,
  `generos_nomegenero` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`livros_tombo`, `livros_editora_nomeeditora`, `generos_nomegenero`),
  CONSTRAINT `fk_livros_has_generos_livros1`
    FOREIGN KEY (`livros_tombo` , `livros_editora_nomeeditora`)
    REFERENCES `biblioteca`.`livros` (`tombo` , `editora_nomeeditora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livros_has_generos_generos1`
    FOREIGN KEY (`generos_nomegenero`)
    REFERENCES `biblioteca`.`generos` (`nomegenero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


-- -----------------------------------------------------
-- Table `biblioteca`.`livros_has_reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`livros_has_reserva` (
  `livros_tombo` INT(4) UNSIGNED ZEROFILL NOT NULL,
  `livros_editora_nomeeditora` VARCHAR(45) NOT NULL,
  `reserva_idreserva` INT(10) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`livros_tombo`, `livros_editora_nomeeditora`, `reserva_idreserva`),
  CONSTRAINT `fk_livros_has_reserva_livros1`
    FOREIGN KEY (`livros_tombo` , `livros_editora_nomeeditora`)
    REFERENCES `biblioteca`.`livros` (`tombo` , `editora_nomeeditora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livros_has_reserva_reserva1`
    FOREIGN KEY (`reserva_idreserva`)
    REFERENCES `biblioteca`.`reserva` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

