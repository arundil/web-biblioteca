-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 06-06-2015 a las 20:16:30
-- Versión del servidor: 5.6.24
-- Versión de PHP: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `BIBLIOTECA`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Asociacion_Usuario_Libro`
--

CREATE TABLE IF NOT EXISTS `Asociacion_Usuario_Libro` (
  `id_asociacion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Libro`
--

CREATE TABLE IF NOT EXISTS `Libro` (
  `id_libro` int(10) unsigned NOT NULL,
  `nombre_libro` mediumtext,
  `autor` varchar(100) DEFAULT NULL,
  `editorial` varchar(100) DEFAULT NULL,
  `edicion` varchar(100) DEFAULT NULL,
  `anio_publicacion` varchar(100) DEFAULT NULL,
  `ubicacion` varchar(100) DEFAULT NULL,
  `disponible` varchar(2) NOT NULL DEFAULT 'SI'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Libro`
--

INSERT INTO `Libro` (`id_libro`, `nombre_libro`, `autor`, `editorial`, `edicion`, `anio_publicacion`, `ubicacion`, `disponible`) VALUES
(0, 'La Guerra de los Mundos', 'Herbert George Wells', 'El libro Feliz', '3', '1898', 'Planta 1, seccion H', 'SI'),
(1, 'Harry Potter y la piedra filosofal', 'J. K. Rowling', 'Salamandra', '3', '2001', 'Planta 1, seccion J', 'SI'),
(2, 'El Señor de los Anillos, La trilogía', 'JRR Tolkien', 'Las Páginas de Erebor', '15', '1925', 'Planta 1, seccion H', 'SI'),
(3, 'La Catedral de Mar', 'Ildefonso Falcones', 'La caprichosa', '4', '2005', 'Planta 1, seccion H', 'SI'),
(4, 'La templanza', 'Maria dueñas', 'SM', '1', '2013', 'Planta 1, seccion H', 'SI'),
(5, 'El resplandor', 'Stephen King', 'El libro Feliz', '20', '1980', 'Planta 1, seccion H', 'SI'),
(6, 'Steve Jobs. La biografía definitiva', 'Walter Isaacson', 'Ventanas en ingles', '3', '2012', 'Planta 1, seccion H', 'SI'),
(7, 'Viaje al optimismo', 'Eduardo Punset', 'La célula', '10', '2012', 'Planta 1, seccion H', 'SI'),
(8, 'Aleph', 'Paulo Coello', 'Los 40 imprescindibles', '3', '2012', 'Planta 1, seccion H', 'SI'),
(9, 'Canción de hielo y fuego', 'George R. R. Martin', 'Kalesi', '15', '2011', 'Planta 1, seccion H', 'SI'),
(10, 'Eragon', 'Christopher Paolini', 'El dragón comilon', '5', '2006', 'Planta 1, seccion H', 'SI'),
(11, 'Crepúsculo', 'Stephenie Meyer', 'Amanecer', '3', '2003', 'Planta 1, seccion H', 'SI'),
(12, 'El código Da Vinci', 'Dan Brown', 'Altruista ediciones', '5', '2006', 'Planta 1, seccion H', 'SI'),
(13, 'EL LAPIZ DE ROSALIA ', 'ANTON CORTIZAS AMADO', 'El barco de Vapor', '5', '1988', 'Planta 1, seccion H', 'SI'),
(14, 'La fraternidad de Eihwaz', 'Cesar Mayorquí', 'Black opium', '6', '2000', 'Planta 1, seccion H', 'SI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE IF NOT EXISTS `Usuario` (
  `id_usuario` int(10) unsigned NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `dni` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`id_usuario`, `nombre`, `apellidos`, `dni`) VALUES
(1, 'Marc', 'Bayón', '48816052R'),
(2, 'Omar', 'Hassani', '12345678R'),
(3, 'Roberto', 'Moriyón', '98765432T');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Asociacion_Usuario_Libro`
--
ALTER TABLE `Asociacion_Usuario_Libro`
  ADD PRIMARY KEY (`id_asociacion`);

--
-- Indices de la tabla `Libro`
--
ALTER TABLE `Libro`
  ADD PRIMARY KEY (`id_libro`),
  ADD UNIQUE KEY `id_libro` (`id_libro`),
  ADD KEY `id_libro_2` (`id_libro`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Asociacion_Usuario_Libro`
--
ALTER TABLE `Asociacion_Usuario_Libro`
  MODIFY `id_asociacion` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id_usuario` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
