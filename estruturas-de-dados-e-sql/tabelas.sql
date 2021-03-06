-- MySQL Script generated by MySQL Workbench
-- Mon Feb 14 22:03:20 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`ALUNO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ALUNO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DISCIPLINA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DISCIPLINA` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PROFESSOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PROFESSOR` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TURMA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TURMA` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dia_da_semana` VARCHAR(45) NULL,
  `horario` VARCHAR(45) NULL,
  `PROFESSOR_id` INT NOT NULL,
  `DISCIPLINA_id` INT NOT NULL,
  `ALUNO_id` INT NOT NULL,
  PRIMARY KEY (`id`, `PROFESSOR_id`, `DISCIPLINA_id`, `ALUNO_id`),
  INDEX `fk_TURMA_PROFESSOR_idx` (`PROFESSOR_id` ASC) VISIBLE,
  INDEX `fk_TURMA_DISCIPLINA1_idx` (`DISCIPLINA_id` ASC) VISIBLE,
  CONSTRAINT `fk_TURMA_PROFESSOR`
    FOREIGN KEY (`PROFESSOR_id`)
    REFERENCES `mydb`.`PROFESSOR` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TURMA_DISCIPLINA1`
    FOREIGN KEY (`DISCIPLINA_id`)
    REFERENCES `mydb`.`DISCIPLINA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ALUNO_TURMA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ALUNO_TURMA` (
  `ALUNO_id` INT NOT NULL,
  `TURMA_id` INT NOT NULL,
  PRIMARY KEY (`ALUNO_id`, `TURMA_id`),
  INDEX `fk_ALUNO_TURMA_TURMA1_idx` (`TURMA_id` ASC) VISIBLE,
  CONSTRAINT `fk_ALUNO_TURMA_ALUNO1`
    FOREIGN KEY (`ALUNO_id`)
    REFERENCES `mydb`.`ALUNO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ALUNO_TURMA_TURMA1`
    FOREIGN KEY (`TURMA_id`)
    REFERENCES `mydb`.`TURMA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
