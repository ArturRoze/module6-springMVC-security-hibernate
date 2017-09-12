-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_for_spring
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_for_spring
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_for_spring` DEFAULT CHARACTER SET utf8 ;
USE `db_for_spring` ;

-- -----------------------------------------------------
-- Table `db_for_spring`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_for_spring`.`products` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NULL DEFAULT NULL,
  `vendor` VARCHAR(45) NULL DEFAULT NULL,
  `cost` DECIMAL(10,0) NULL DEFAULT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_for_spring`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_for_spring`.`users` (
  `login` VARCHAR(64) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `registration_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role` VARCHAR(45) NULL DEFAULT 'USER',
  PRIMARY KEY (`login`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
