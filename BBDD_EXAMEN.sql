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
CREATE SCHEMA IF NOT EXISTS `valdecilladaw` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema valdecilladaw
-- -----------------------------------------------------
USE `valdecilladaw` ;

-- -----------------------------------------------------
-- Table `mydb`.`TipoConsulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `valdecilladaw`.`TipoConsulta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Tipo_UNIQUE` (`Tipo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `valdecilladaw`.`Paciente` (
  `dni` VARCHAR(10) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellidos` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `valdecilladaw`.`Doctor` (
  `num_colegiado` VARCHAR(25) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellidos` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `fecha_alta` DATE NOT NULL,
  `TipoConsulta_id` INT NOT NULL,
  PRIMARY KEY (`num_colegiado`, `TipoConsulta_id`),
  UNIQUE INDEX `dni_UNIQUE` (`num_colegiado` ASC) VISIBLE,
  INDEX `fk_Doctor_TipoConsulta_idx` (`TipoConsulta_id` ASC) VISIBLE,
  CONSTRAINT `fk_Doctor_TipoConsulta`
    FOREIGN KEY (`TipoConsulta_id`)
    REFERENCES `valdecilladaw`.`TipoConsulta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `valdecilladaw`.`Consulta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Observaciones` TEXT NOT NULL,
  `fecha` DATE NOT NULL,
  `TipoConsulta_id` INT NOT NULL,
  `Paciente_dni` VARCHAR(10) NOT NULL,
  `Doctor_num_colegiado` VARCHAR(25) NOT NULL,
  `Doctor_TipoConsulta_id` INT NOT NULL,
  PRIMARY KEY (`id`, `TipoConsulta_id`, `Paciente_dni`, `Doctor_num_colegiado`, `Doctor_TipoConsulta_id`),
  INDEX `fk_Consulta_TipoConsulta1_idx` (`TipoConsulta_id` ASC) VISIBLE,
  INDEX `fk_Consulta_Paciente1_idx` (`Paciente_dni` ASC) VISIBLE,
  INDEX `fk_Consulta_Doctor1_idx` (`Doctor_num_colegiado` ASC, `Doctor_TipoConsulta_id` ASC) VISIBLE,
  CONSTRAINT `fk_Consulta_TipoConsulta1`
    FOREIGN KEY (`TipoConsulta_id`)
    REFERENCES `valdecilladaw`.`TipoConsulta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Consulta_Paciente1`
    FOREIGN KEY (`Paciente_dni`)
    REFERENCES `valdecilladaw`.`Paciente` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Consulta_Doctor1`
    FOREIGN KEY (`Doctor_num_colegiado` , `Doctor_TipoConsulta_id`)
    REFERENCES `valdecilladaw`.`Doctor` (`num_colegiado` , `TipoConsulta_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- Insertar 10 tipos de consulta
INSERT INTO TipoConsulta (Tipo) VALUES
('Pediatría'), ('Cardiología'), ('Neurología'), ('Dermatología'), ('Ginecología'),
('Psiquiatría'), ('Traumatología'), ('Oftalmología'), ('Otorrinolaringología'), ('Endocrinología');

-- Insertar 10 pacientes
INSERT INTO Paciente (dni, Nombre, Apellidos, Telefono, Direccion, Email) VALUES
('11111111A', 'Laura', 'González', '612345678', 'Calle A 1', 'laura@mail.com'),
('11111111B', 'Manuel', 'Fernández', '612345679', 'Calle B 2', 'manuel@mail.com'),
('11111111C', 'Carmen', 'López', '612345680', 'Calle C 3', 'carmen@mail.com'),
('11111111D', 'Antonio', 'Sánchez', '612345681', 'Calle D 4', 'antonio@mail.com'),
('11111111E', 'Isabel', 'Díaz', '612345682', 'Calle E 5', 'isabel@mail.com'),
('11111111F', 'David', 'Pérez', '612345683', 'Calle F 6', 'david@mail.com'),
('11111111G', 'Lucía', 'Martín', '612345684', 'Calle G 7', 'lucia@mail.com'),
('11111111H', 'José', 'Gómez', '612345685', 'Calle H 8', 'jose@mail.com'),
('11111111I', 'Elena', 'Ruiz', '612345686', 'Calle I 9', 'elena@mail.com'),
('11111111J', 'Miguel', 'Torres', '612345687', 'Calle J 10', 'miguel@mail.com');

-- Insertar 10 doctores
INSERT INTO Doctor (num_colegiado, Nombre, Apellidos, Telefono, Direccion, Email, fecha_alta, TipoConsulta_id) VALUES
('COL001', 'Ana', 'Ramírez', '622345678', 'Calle Doc 1', 'ana.ramirez@mail.com', '1990-01-01', 1),
('COL002', 'Javier', 'Moreno', '622345679', 'Calle Doc 2', 'javier.moreno@mail.com', '2000-05-05', 2),
('COL003', 'Sofía', 'Herrera', '622345680', 'Calle Doc 3', 'sofia.herrera@mail.com', '1987-11-25', 3),
('COL004', 'Carlos', 'Gil', '622345681', 'Calle Doc 4', 'carlos.gil@mail.com', '2015-06-23', 4),
('COL005', 'Marta', 'Iglesias', '622345682', 'Calle Doc 5', 'marta.iglesias@mail.com', '2005-10-28', 5),
('COL006', 'Raúl', 'Cano', '622345683', 'Calle Doc 6', 'raul.cano@mail.com', '1999-03-24', 6),
('COL007', 'Teresa', 'Molina', '622345684', 'Calle Doc 7', 'teresa.molina@mail.com', '1998-08-11', 7),
('COL008', 'Pablo', 'Ortega', '622345685', 'Calle Doc 8', 'pablo.ortega@mail.com', '1974-4-7', 8),
('COL009', 'Nuria', 'Serrano', '622345686', 'Calle Doc 9', 'nuria.serrano@mail.com', '1986-12-12', 9),
('COL010', 'Hugo', 'Delgado', '622345687', 'Calle Doc 10', 'hugo.delgado@mail.com', '2023-01-30', 10);

-- Insertar 10 consultas
INSERT INTO Consulta (Observaciones, fecha, TipoConsulta_id, Paciente_dni, Doctor_num_colegiado, Doctor_TipoConsulta_id) VALUES
('Consulta general', '2014-06-23', 1, '11111111A', 'COL001', 1),
('Chequeo cardíaco', '2005-10-28', 2, '11111111B', 'COL002', 2),
('Pruebas neurológicas', '2020-10-28', 3, '11111111C', 'COL003', 3),
('Revisión de piel', '2025-05-20', 4, '11111111D', 'COL004', 4),
('Control ginecológico', '2010-10-03', 5, '11111111E', 'COL005', 5),
('Sesión psiquiátrica', '1978-09-28', 6, '11111111F', 'COL006', 6),
('Revisión de huesos', '1984-02-28', 7, '11111111G', 'COL007', 7),
('Prueba de visión', '1991-07-05', 8, '11111111H', 'COL008', 8),
('Consulta de oídos', '1999-08-12', 9, '11111111I', 'COL009', 9),
('Chequeo endocrino', '2000-01-01', 10, '11111111J', 'COL010', 10);


Select * from paciente;
SELECT * FROM Doctor;

select c.*, d.*, p.*, t.Tipo
from Consulta c
Join Doctor d ON d.TipoConsulta_id = c.Doctor_TipoConsulta_id
join Paciente p ON p.dni = c.Paciente_dni
join TipoConsulta t ON t.id = c.TipoConsulta_id
