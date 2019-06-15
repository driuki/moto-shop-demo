-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema myDemoShopDataBase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema myDemoShopDataBase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `myDemoShopDataBase` DEFAULT CHARACTER SET utf8 COLLATE utf8_lithuanian_ci ;
USE `myDemoShopDataBase` ;

-- -----------------------------------------------------
-- Table `myDemoShopDataBase`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myDemoShopDataBase`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myDemoShopDataBase`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myDemoShopDataBase`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `firstName` VARCHAR(50) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `roleId` INT NOT NULL DEFAULT 1,
  `email` VARCHAR(50) NOT NULL,
  `address` VARCHAR(150) NOT NULL,
  `userImg` VARCHAR(150) NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`roleId` ASC),
  CONSTRAINT `id`
    FOREIGN KEY (`roleId`)
    REFERENCES `myDemoShopDataBase`.`role` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myDemoShopDataBase`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myDemoShopDataBase`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `year` INT NOT NULL,
  `engine` INT NOT NULL,
  `price` INT NOT NULL,
  `product_Img` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myDemoShopDataBase`.`cart_id`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myDemoShopDataBase`.`cart_id` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`user_id` ASC),
  CONSTRAINT `id_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `myDemoShopDataBase`.`users` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myDemoShopDataBase`.`cart_content`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myDemoShopDataBase`.`cart_content` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `price` INT NOT NULL,
  `total` VARCHAR(45) NOT NULL,
  `cart_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cart_id_f_idx` (`cart_id` ASC),
  INDEX `product_id_f_idx` (`product_id` ASC),
  CONSTRAINT `cart_id_f`
    FOREIGN KEY (`cart_id`)
    REFERENCES `myDemoShopDataBase`.`cart_id` (`id`),
  CONSTRAINT `product_id_f`
    FOREIGN KEY (`product_id`)
    REFERENCES `myDemoShopDataBase`.`product` (`id`))
ENGINE = InnoDB;

INSERT INTO `role` VALUES
			(1, 'customer'),
            (2, 'manager'),
            (3, 'admin'),
            (4, 'employee');
            
INSERT INTO `product` VALUES 
			(1, 'Yamaha', 'R1', 2018, 998, 19199, 'yamaha_r1.jpg'),
            (2, 'Suzuki', 'GSX-R1000', 2017, 998, 11900, 'Suzuki_GSX-R1000.jpg'),
            (3, 'Yamaha', 'R1M', 2018, 998, 25199, 'Yamaha-R1M.jpg'),
            (4, 'Hona', 'CBR 1000RR', 2016, 998, 18299, 'Hona_CBR1000RR_Fireblade.jpg'),
            (5, 'Ducati', 'V4', 2018, 1103, 30000, 'ducati-panigale-v4.jpg'),
            (6, 'Aprilia', 'Tuono V4', 2018, 998, 28199, 'Aprilia-Tuono-V4.jpg'),
            (7, 'BMW', 'S 1000RR', 2019, 998, 19199, 'BMW_S_1000_RR.jpg'),
            (8, 'Kawasaki', 'Ninija ZX-10R', 2018, 998, 17199, 'Kawasaki_NinjaZX-10R.jpg'),
            (9, 'Yamaha', 'R6', 2018, 600, 14499, 'Yamaha-YZF-R6.jpg'),
            (10, 'Kawasaki', 'Ninija ZX-6R', 2015, 600, 14500, 'kawasaki-ninja-zx-6r.jpg');            

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
