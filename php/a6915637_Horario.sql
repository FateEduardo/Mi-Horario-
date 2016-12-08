
-- phpMyAdmin SQL Dump
-- version 2.11.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 06, 2016 at 02:33 AM
-- Server version: 5.1.57
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `a6915637_Horario`
--

-- --------------------------------------------------------

--
-- Table structure for table `ALUMNOS`
--

CREATE TABLE `ALUMNOS` (
  `matricula` int(11) unsigned NOT NULL,
  `name` varchar(30) NOT NULL,
  `app` varchar(30) NOT NULL,
  `apm` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `carrera` varchar(20) NOT NULL,
  `semestre` int(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ALUMNOS`
--

INSERT INTO `ALUMNOS` VALUES(47, 'Josue Daniel', 'Jimenez ', 'Hermosillo', 'Josue.Jimenez@dogo.edu.mx', 'computacion', 8, 'perro22');
INSERT INTO `ALUMNOS` VALUES(335127, 'Samuel', 'Parra', 'Salas', 'parra.salas@uabc.edu.mx', 'Computacion', 7, 'samuelito');
INSERT INTO `ALUMNOS` VALUES(338747, 'Jorge', 'Alcazar', 'Diaz', 'jorge.alcazar@uabc.edu.mx', 'Ingenieria en comput', 7, '123');
INSERT INTO `ALUMNOS` VALUES(335136, 'alejandro', 'sumuano', 'gonzales', 'asumuano@uabc.edu.mx', 'ingenieria en comput', 7, '123');

-- --------------------------------------------------------

--
-- Table structure for table `HORARIO`
--

CREATE TABLE `HORARIO` (
  `id_Horario` int(11) NOT NULL AUTO_INCREMENT,
  `clave` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `hora_in` time NOT NULL,
  `hora_fin` time NOT NULL,
  PRIMARY KEY (`id_Horario`),
  KEY `fk_HORARIO_clave` (`clave`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=31 ;

--
-- Dumping data for table `HORARIO`
--

INSERT INTO `HORARIO` VALUES(0, 12144, 1, '14:00:00', '15:00:00');
INSERT INTO `HORARIO` VALUES(1, 12116, 1, '15:00:00', '16:00:00');
INSERT INTO `HORARIO` VALUES(2, 12116, 1, '16:00:00', '17:00:00');
INSERT INTO `HORARIO` VALUES(3, 12140, 1, '17:00:00', '18:00:00');
INSERT INTO `HORARIO` VALUES(4, 12140, 1, '18:00:00', '19:00:00');
INSERT INTO `HORARIO` VALUES(5, 12112, 1, '21:00:00', '22:00:00');
INSERT INTO `HORARIO` VALUES(6, 12112, 2, '14:00:00', '15:00:00');
INSERT INTO `HORARIO` VALUES(7, 12112, 2, '15:00:00', '16:00:00');
INSERT INTO `HORARIO` VALUES(8, 12116, 2, '16:00:00', '17:00:00');
INSERT INTO `HORARIO` VALUES(9, 12116, 2, '17:00:00', '18:00:00');
INSERT INTO `HORARIO` VALUES(10, 12140, 2, '18:00:00', '19:00:00');
INSERT INTO `HORARIO` VALUES(11, 12140, 2, '19:00:00', '20:00:00');
INSERT INTO `HORARIO` VALUES(12, 12143, 3, '14:00:00', '15:00:00');
INSERT INTO `HORARIO` VALUES(13, 12143, 3, '15:00:00', '16:00:00');
INSERT INTO `HORARIO` VALUES(14, 12118, 3, '16:00:00', '17:00:00');
INSERT INTO `HORARIO` VALUES(15, 12118, 3, '17:00:00', '18:00:00');
INSERT INTO `HORARIO` VALUES(16, 12144, 3, '18:00:00', '19:00:00');
INSERT INTO `HORARIO` VALUES(17, 12147, 3, '19:00:00', '20:00:00');
INSERT INTO `HORARIO` VALUES(18, 12147, 3, '20:00:00', '21:00:00');
INSERT INTO `HORARIO` VALUES(19, 12148, 4, '14:00:00', '15:00:00');
INSERT INTO `HORARIO` VALUES(20, 12148, 4, '15:00:00', '16:00:00');
INSERT INTO `HORARIO` VALUES(21, 12118, 4, '17:00:00', '18:00:00');
INSERT INTO `HORARIO` VALUES(22, 12118, 4, '18:00:00', '19:00:00');
INSERT INTO `HORARIO` VALUES(23, 12147, 4, '19:00:00', '20:00:00');
INSERT INTO `HORARIO` VALUES(24, 12147, 4, '20:00:00', '21:00:00');
INSERT INTO `HORARIO` VALUES(25, 12148, 5, '14:00:00', '15:00:00');
INSERT INTO `HORARIO` VALUES(26, 12148, 5, '15:00:00', '16:00:00');
INSERT INTO `HORARIO` VALUES(27, 12144, 5, '16:00:00', '17:00:00');
INSERT INTO `HORARIO` VALUES(28, 12144, 5, '17:00:00', '18:00:00');
INSERT INTO `HORARIO` VALUES(29, 12143, 5, '19:00:00', '20:00:00');
INSERT INTO `HORARIO` VALUES(30, 12143, 5, '20:00:00', '21:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `HORARIOPERSONALIZADO`
--

CREATE TABLE `HORARIOPERSONALIZADO` (
  `matricula` int(11) NOT NULL,
  `clave` int(11) NOT NULL,
  `dia_alta` date NOT NULL,
  KEY `matricula` (`matricula`),
  KEY `clave` (`clave`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `HORARIOPERSONALIZADO`
--

INSERT INTO `HORARIOPERSONALIZADO` VALUES(47, 12144, '2016-12-03');
INSERT INTO `HORARIOPERSONALIZADO` VALUES(47, 12116, '2016-12-03');
INSERT INTO `HORARIOPERSONALIZADO` VALUES(47, 12140, '2016-12-03');
INSERT INTO `HORARIOPERSONALIZADO` VALUES(47, 12112, '2016-12-03');
INSERT INTO `HORARIOPERSONALIZADO` VALUES(47, 12143, '2016-12-03');
INSERT INTO `HORARIOPERSONALIZADO` VALUES(47, 12118, '2016-12-03');
INSERT INTO `HORARIOPERSONALIZADO` VALUES(47, 12147, '2016-12-03');
INSERT INTO `HORARIOPERSONALIZADO` VALUES(47, 12148, '2016-12-03');
INSERT INTO `HORARIOPERSONALIZADO` VALUES(56, 12144, '2016-12-03');
INSERT INTO `HORARIOPERSONALIZADO` VALUES(335127, 12144, '2016-12-03');

-- --------------------------------------------------------

--
-- Table structure for table `MATERIA`
--

CREATE TABLE `MATERIA` (
  `clave` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `descripcion` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `tipo` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `cedulaProfesor` int(11) NOT NULL,
  PRIMARY KEY (`clave`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `MATERIA`
--

INSERT INTO `MATERIA` VALUES(12144, 'Computo Movil y Ubicuo', 'Free credits', 'Presencial', 85700);
INSERT INTO `MATERIA` VALUES(12116, 'Automatización y Control', 'Automatizacion', 'Presencial', 85100);
INSERT INTO `MATERIA` VALUES(12140, 'Microprocesadores Avanzados', 'Automatizacion', 'Presencial', 85300);
INSERT INTO `MATERIA` VALUES(12112, 'Tópicos de Manejo Financiero', 'Etapa Terminal', 'Semi-Presencial', 85000);
INSERT INTO `MATERIA` VALUES(12143, 'Aplicaciones  Distribuidas', 'Ingeniería de Software', 'Semi-Presencial', 85400);
INSERT INTO `MATERIA` VALUES(12118, 'Diseño de Redes de Computadoras', 'Redes de Computadoras', 'Presencial', 85200);
INSERT INTO `MATERIA` VALUES(12147, 'Ingeniería de Requerimientos', 'Etapa Terminal', 'Online', 85500);
INSERT INTO `MATERIA` VALUES(12148, 'Administración de Proyectos de Software', 'Etapa Terminal', 'Presencial', 85600);

-- --------------------------------------------------------

--
-- Table structure for table `PROFESORES`
--

CREATE TABLE `PROFESORES` (
  `cedulaProfesor` int(11) NOT NULL,
  `name` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `app` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `apm` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `telefono` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `ubicacion` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `especialidad` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`cedulaProfesor`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `PROFESORES`
--

INSERT INTO `PROFESORES` VALUES(85000, 'Miguel Angel', 'Adame', 'Montreal', '6461234245', 'NA', 'Contabilidad/Finanzas');
INSERT INTO `PROFESORES` VALUES(85100, 'Miguel Angel', 'Murillo', 'Escobar', '6461234823', 'NA', 'Computacion/Automatizacion');
INSERT INTO `PROFESORES` VALUES(85200, 'Manuel', 'Jimenez', 'Orozco', '6461543131', 'E34', 'Computacion/Redes');
INSERT INTO `PROFESORES` VALUES(85300, 'Aram', 'Hawa', 'Calvo', '6461763431', 'NA', 'Computacion/Electronica');
INSERT INTO `PROFESORES` VALUES(85400, 'Lourdes Estela', 'Sanchez', 'Moreno', '6461564324', 'NA', 'Computacion');
INSERT INTO `PROFESORES` VALUES(85500, 'Mabel', 'Vazquez', 'Briseno', '6461938432', 'Direccion', 'Computacion/Redes');
INSERT INTO `PROFESORES` VALUES(85600, 'Luis Angel', 'Monge', 'De La Cruz', '6462834828', 'NA', 'Computacion');
INSERT INTO `PROFESORES` VALUES(85700, 'Christian Xavier', 'Navarro', 'Gonzalez', '6461834753', 'E1', 'Computacion');
