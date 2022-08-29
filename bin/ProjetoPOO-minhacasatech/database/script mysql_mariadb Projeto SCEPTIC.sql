-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SCEPTIC
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SCEPTIC
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SCEPTIC` DEFAULT CHARACTER SET utf8 ;
USE `SCEPTIC` ;

-- -----------------------------------------------------
-- Table `SCEPTIC`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SCEPTIC`.`pessoa` (
  `id_pes` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `tele` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id_pes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SCEPTIC`.`responsaveis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SCEPTIC`.`responsaveis` (
  `id_res` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `tipo` INT NOT NULL,
  `pessoa_id_pes` BIGINT NOT NULL,
  PRIMARY KEY (`id_res`),
  INDEX `fk_responsaveis_pessoa1_idx` (`pessoa_id_pes` ASC) VISIBLE,
  CONSTRAINT `fk_responsaveis_pessoa1`
    FOREIGN KEY (`pessoa_id_pes`)
    REFERENCES `SCEPTIC`.`pessoa` (`id_pes`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SCEPTIC`.`locais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SCEPTIC`.`locais` (
  `id_loc` BIGINT NOT NULL AUTO_INCREMENT,
  `nome_loc` VARCHAR(45) NOT NULL,
  `nome_comp_loc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_loc`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SCEPTIC`.`equipamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SCEPTIC`.`equipamentos` (
  `id_eq` BIGINT NOT NULL AUTO_INCREMENT,
  `nome_eq` VARCHAR(50) NOT NULL,
  `peso_eq` FLOAT NOT NULL,
  `num_serie_eq` INT NOT NULL,
  `preco_eq` DECIMAL(5,2) NOT NULL,
  `quant_eq` INT NOT NULL,
  `responsaveis_id_res` BIGINT NOT NULL,
  `locais_id_loc` BIGINT NOT NULL,
  PRIMARY KEY (`id_eq`),
  INDEX `fk_equipamentos_responsaveis_idx` (`responsaveis_id_res` ASC) VISIBLE,
  INDEX `fk_equipamentos_locais1_idx` (`locais_id_loc` ASC) VISIBLE,
  CONSTRAINT `fk_equipamentos_responsaveis`
    FOREIGN KEY (`responsaveis_id_res`)
    REFERENCES `SCEPTIC`.`responsaveis` (`id_res`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipamentos_locais1`
    FOREIGN KEY (`locais_id_loc`)
    REFERENCES `SCEPTIC`.`locais` (`id_loc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SCEPTIC`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SCEPTIC`.`clientes` (
  `id_cli` BIGINT NOT NULL AUTO_INCREMENT,
  `cpf_cli` INT(11) NOT NULL,
  `dt_cadastro` DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pessoa_id_pes` BIGINT NOT NULL,
  PRIMARY KEY (`id_cli`),
  INDEX `fk_clientes_pessoa1_idx` (`pessoa_id_pes` ASC) VISIBLE,
  CONSTRAINT `fk_clientes_pessoa1`
    FOREIGN KEY (`pessoa_id_pes`)
    REFERENCES `SCEPTIC`.`pessoa` (`id_pes`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SCEPTIC`.`equipamentos_has_clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SCEPTIC`.`equipamentos_has_clientes` (
  `equipamentos_id_eq` BIGINT NOT NULL,
  `clientes_id_cli` BIGINT NOT NULL,
  PRIMARY KEY (`equipamentos_id_eq`, `clientes_id_cli`),
  INDEX `fk_equipamentos_has_clientes_clientes1_idx` (`clientes_id_cli` ASC) VISIBLE,
  INDEX `fk_equipamentos_has_clientes_equipamentos1_idx` (`equipamentos_id_eq` ASC) VISIBLE,
  CONSTRAINT `fk_equipamentos_has_clientes_equipamentos1`
    FOREIGN KEY (`equipamentos_id_eq`)
    REFERENCES `SCEPTIC`.`equipamentos` (`id_eq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipamentos_has_clientes_clientes1`
    FOREIGN KEY (`clientes_id_cli`)
    REFERENCES `SCEPTIC`.`clientes` (`id_cli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
