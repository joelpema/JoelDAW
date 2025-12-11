-- 🚮 1. BORRAR LA BASE DE DATOS (LIMPIEZA COMPLETA)
DROP DATABASE IF EXISTS empresa_db;

-- 🧱 2. CREAR LA BASE DE DATOS
CREATE DATABASE empresa_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE empresa_db;

-- 🏢 3. TABLA EMPRESAS (UUID)
CREATE TABLE empresas (
  id VARCHAR(36) NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- 👨‍💼 4. TABLA EMPLEADOS (UUID + FK)
CREATE TABLE empleados (
  id VARCHAR(36) NOT NULL,
  empresa_id VARCHAR(36) NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  edad INT,
  PRIMARY KEY (id),
  INDEX idx_empleados_empresa_id (empresa_id),
  CONSTRAINT fk_empleados_empresas
    FOREIGN KEY (empresa_id)
    REFERENCES empresas(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
) ENGINE=InnoDB;


-- 🧪 5. INSERTS SIN UUID (Spring Boot los generará automáticamente)
-- Solo contienen los campos que tú rellenas

-- EMPRESAS
INSERT INTO empresas (id, nombre) VALUES
(UUID(), 'Empresa A'),
(UUID(), 'Empresa B');

-- ATENCIÓN:
-- Usamos UUID() de MySQL SOLO PARA CREAR DATOS DE PRUEBA.
-- En tu aplicación real, los IDs los generará Spring con UUID.randomUUID()

-- EMPLEADOS (usa los IDs reales que acaban de crearse)
-- Recupera los ID en Workbench y sustitúyelos aquí:

-- SELECT * FROM empresas;

-- Ejemplo genérico:
-- INSERT INTO empleados (id, empresa_id, nombre, apellido, edad) VALUES
-- (UUID(), '<ID_EMPRESA_A>', 'Juan', 'Pérez', 30),
-- (UUID(), '<ID_EMPRESA_B>', 'Ana', 'López', 27);
