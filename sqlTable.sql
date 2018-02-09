
CREATE DATABASE `ventas` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ventas`; 

CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(200) NOT NULL,
  `apellidos` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`)
);






