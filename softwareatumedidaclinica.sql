-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.21-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para softwareatumedidaclinica
CREATE DATABASE IF NOT EXISTS `softwareatumedidaclinica` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `softwareatumedidaclinica`;

-- Volcando estructura para tabla softwareatumedidaclinica.c_especialidad
CREATE TABLE IF NOT EXISTS `c_especialidad` (
  `CEspecialidadId` int(11) NOT NULL,
  `CEspecialidadIdDes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CEspecialidadId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.c_especialidad: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `c_especialidad` DISABLE KEYS */;
INSERT INTO `c_especialidad` (`CEspecialidadId`, `CEspecialidadIdDes`) VALUES
	(1, 'Medico Internista'),
	(2, 'Nefrologo'),
	(3, 'Transplante Renal'),
	(4, 'Urgenciologo');
/*!40000 ALTER TABLE `c_especialidad` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.c_estado
CREATE TABLE IF NOT EXISTS `c_estado` (
  `CEstadoId` int(11) NOT NULL,
  `CEstadoDes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CEstadoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tratamiento, alta o traslado';

-- Volcando datos para la tabla softwareatumedidaclinica.c_estado: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `c_estado` DISABLE KEYS */;
INSERT INTO `c_estado` (`CEstadoId`, `CEstadoDes`) VALUES
	(1, 'Internamiento'),
	(2, 'Alta'),
	(3, 'Traslado');
/*!40000 ALTER TABLE `c_estado` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.c_estadopaciente
CREATE TABLE IF NOT EXISTS `c_estadopaciente` (
  `CEstadoPacienteId` int(11) NOT NULL,
  `CEstadoDes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CEstadoPacienteId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Grave delicado estable';

-- Volcando datos para la tabla softwareatumedidaclinica.c_estadopaciente: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `c_estadopaciente` DISABLE KEYS */;
INSERT INTO `c_estadopaciente` (`CEstadoPacienteId`, `CEstadoDes`) VALUES
	(1, 'Grave'),
	(2, 'Delicado'),
	(3, 'Estable');
/*!40000 ALTER TABLE `c_estadopaciente` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.c_prioridad
CREATE TABLE IF NOT EXISTS `c_prioridad` (
  `CPrioridadId` int(11) NOT NULL,
  `CPrioridadDes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CPrioridadId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Prioridad TRIAGE';

-- Volcando datos para la tabla softwareatumedidaclinica.c_prioridad: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `c_prioridad` DISABLE KEYS */;
INSERT INTO `c_prioridad` (`CPrioridadId`, `CPrioridadDes`) VALUES
	(1, 'I'),
	(2, 'II'),
	(3, 'III');
/*!40000 ALTER TABLE `c_prioridad` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.c_tipoestudio
CREATE TABLE IF NOT EXISTS `c_tipoestudio` (
  `CTipoEstudioId` int(11) NOT NULL,
  `CTipoDes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CTipoEstudioId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Estudios de laboratorio o de gabinete ';

-- Volcando datos para la tabla softwareatumedidaclinica.c_tipoestudio: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `c_tipoestudio` DISABLE KEYS */;
INSERT INTO `c_tipoestudio` (`CTipoEstudioId`, `CTipoDes`) VALUES
	(1, 'Laboratorio'),
	(2, 'Gabinete');
/*!40000 ALTER TABLE `c_tipoestudio` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.c_tipoingreso
CREATE TABLE IF NOT EXISTS `c_tipoingreso` (
  `CTipoIngresoId` int(11) NOT NULL,
  `CTipoIngresoDes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CTipoIngresoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='como llego el paciente al hospital puede omitirse';

-- Volcando datos para la tabla softwareatumedidaclinica.c_tipoingreso: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `c_tipoingreso` DISABLE KEYS */;
INSERT INTO `c_tipoingreso` (`CTipoIngresoId`, `CTipoIngresoDes`) VALUES
	(1, 'Propios medios'),
	(2, 'Ambulancia'),
	(3, 'Particular'),
	(4, 'Aseguradora'),
	(5, 'Convenio');
/*!40000 ALTER TABLE `c_tipoingreso` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.c_tipousuario
CREATE TABLE IF NOT EXISTS `c_tipousuario` (
  `CTusuarioId` int(11) NOT NULL,
  `CTusuarioDes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CTusuarioId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.c_tipousuario: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `c_tipousuario` DISABLE KEYS */;
INSERT INTO `c_tipousuario` (`CTusuarioId`, `CTusuarioDes`) VALUES
	(1, 'Administrador'),
	(2, 'Medico'),
	(3, 'Capturista'),
	(4, 'Visitante');
/*!40000 ALTER TABLE `c_tipousuario` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.diagnostico
CREATE TABLE IF NOT EXISTS `diagnostico` (
  `RxId` int(11) NOT NULL,
  `PacienteId` int(11) DEFAULT NULL,
  `UsuarioUsr` varchar(100) DEFAULT NULL,
  `RxFecHora` date DEFAULT NULL,
  `RxPacienteAcompañante` varchar(100) DEFAULT NULL,
  `RxParentesco` varchar(45) DEFAULT NULL,
  `CTipoIngresoId` int(11) DEFAULT NULL,
  `RxMConsulta` varchar(100) DEFAULT NULL,
  `CPrioridadId` int(11) DEFAULT NULL,
  `CEstadoPacienteId` int(11) DEFAULT NULL,
  `RxFC` varchar(40) DEFAULT NULL,
  `RxFR` varchar(40) DEFAULT NULL,
  `RxTemp` char(10) DEFAULT NULL,
  `RxInterconsulta` varchar(100) DEFAULT NULL,
  `RxExploracionFisica` varchar(200) DEFAULT NULL,
  `RxDiagnostico` varchar(200) DEFAULT NULL,
  `RxIndicacionesMedicas` varchar(200) DEFAULT NULL,
  `CEstadoId` int(11) DEFAULT NULL,
  `RxFechaEgreso` date DEFAULT NULL,
  PRIMARY KEY (`RxId`),
  KEY `FK_DiagnosticoExpediente_idx` (`PacienteId`),
  KEY `FK_DiagnosticoPersonal_idx` (`UsuarioUsr`),
  KEY `FK_DiagnosticoTIngreso_idx` (`CTipoIngresoId`),
  KEY `FK_DiagnosticoCEdoPaciente_idx` (`CEstadoPacienteId`),
  KEY `FK_DiagnosticoEstado_idx` (`CEstadoId`),
  KEY `FK_DiagnosticoPrioridad_idx` (`CPrioridadId`),
  CONSTRAINT `FK_DiagnosticoEdoPaciente` FOREIGN KEY (`CEstadoPacienteId`) REFERENCES `c_estadopaciente` (`CEstadoPacienteId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DiagnosticoEstado` FOREIGN KEY (`CEstadoId`) REFERENCES `c_estado` (`CEstadoId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DiagnosticoExpediente` FOREIGN KEY (`PacienteId`) REFERENCES `expediente` (`PacienteId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DiagnosticoPersonal` FOREIGN KEY (`UsuarioUsr`) REFERENCES `personal` (`UsuarioUsr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DiagnosticoPrioridad` FOREIGN KEY (`CPrioridadId`) REFERENCES `c_prioridad` (`CPrioridadId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DiagnosticoTIngreso` FOREIGN KEY (`CTipoIngresoId`) REFERENCES `c_tipoingreso` (`CTipoIngresoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.diagnostico: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `diagnostico` DISABLE KEYS */;
INSERT INTO `diagnostico` (`RxId`, `PacienteId`, `UsuarioUsr`, `RxFecHora`, `RxPacienteAcompañante`, `RxParentesco`, `CTipoIngresoId`, `RxMConsulta`, `CPrioridadId`, `CEstadoPacienteId`, `RxFC`, `RxFR`, `RxTemp`, `RxInterconsulta`, `RxExploracionFisica`, `RxDiagnostico`, `RxIndicacionesMedicas`, `CEstadoId`, `RxFechaEgreso`) VALUES
	(1, 1, 'MiUser', '2018-11-09', 'Sin Acompañante', 'S/P', 1, NULL, 3, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL);
/*!40000 ALTER TABLE `diagnostico` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `EmpresaId` int(11) NOT NULL,
  `EmpresaNombre` varchar(100) DEFAULT NULL,
  `EmpresaRFC` varchar(45) DEFAULT NULL,
  `EmpresaFecConstitucion` date DEFAULT NULL,
  `EmpresaDomicilio` varchar(100) DEFAULT NULL,
  `EmpresaMision` varchar(200) DEFAULT NULL,
  `EmpresaVision` varchar(200) DEFAULT NULL,
  `EmpresaEntidadFed` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`EmpresaId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.empresa: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`EmpresaId`, `EmpresaNombre`, `EmpresaRFC`, `EmpresaFecConstitucion`, `EmpresaDomicilio`, `EmpresaMision`, `EmpresaVision`, `EmpresaEntidadFed`) VALUES
	(1, 'Hospital Privado Anahuac', 'HPA2501200Y2', '2005-09-10', 'Ignacio Ramírez #74 - Col. Cuauhtémoc Sur - C.P. 39060', 'Mision', 'Vision', 'Chilpancingo de los Bravo, Gro.');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.especialidad
CREATE TABLE IF NOT EXISTS `especialidad` (
  `UsuarioUsr` varchar(100) NOT NULL,
  `EspecialidadId` varchar(45) NOT NULL,
  `CEspecialidadId` int(11) DEFAULT NULL,
  `EspecialidadCedula` varchar(45) DEFAULT NULL,
  `EspecialidadInstitucion` varchar(100) DEFAULT NULL,
  `EspecialidadInsDomicilio` varchar(100) DEFAULT NULL,
  `EspecialidadInsTelefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UsuarioUsr`,`EspecialidadId`),
  KEY `FK_EspecialidadCEspecialidad_idx` (`CEspecialidadId`),
  CONSTRAINT `FK_EspecialidadCEspecialidad` FOREIGN KEY (`CEspecialidadId`) REFERENCES `c_especialidad` (`CEspecialidadId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_EspecialidadPersonal` FOREIGN KEY (`UsuarioUsr`) REFERENCES `personal` (`UsuarioUsr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.especialidad: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` (`UsuarioUsr`, `EspecialidadId`, `CEspecialidadId`, `EspecialidadCedula`, `EspecialidadInstitucion`, `EspecialidadInsDomicilio`, `EspecialidadInsTelefono`) VALUES
	('MiUser', '1', 4, '213132', 'fsgfdgdf', 'dfssdfs', '45646');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.estudio
CREATE TABLE IF NOT EXISTS `estudio` (
  `EstudioId` int(11) NOT NULL,
  `RxId` int(11) DEFAULT NULL,
  `UsuarioUsr` int(11) DEFAULT NULL,
  `CTipoEstudioId` int(11) DEFAULT NULL,
  `EstudioDescripcion` varchar(100) DEFAULT NULL,
  `EstudioImagen` blob,
  PRIMARY KEY (`EstudioId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.estudio: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `estudio` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudio` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.expediente
CREATE TABLE IF NOT EXISTS `expediente` (
  `PacienteId` int(11) NOT NULL,
  `PacienteNombre` varchar(100) DEFAULT NULL,
  `PacientePApellido` varchar(100) DEFAULT NULL,
  `PacienteSApellido` varchar(100) DEFAULT NULL,
  `PacienteCurp` varchar(45) DEFAULT NULL,
  `PacienteRFC` varchar(45) DEFAULT NULL,
  `PacienteEmail` varchar(45) DEFAULT NULL,
  `PacienteFNacimiento` date DEFAULT NULL,
  `PacienteSexo` char(1) DEFAULT NULL,
  `PacienteECivil` varchar(10) DEFAULT NULL,
  `PacienteTelCel` varchar(45) DEFAULT NULL,
  `PacienteTelFijo` varchar(45) DEFAULT NULL,
  `PacienteLNacimiento` varchar(100) DEFAULT NULL,
  `PacienteRadica` varchar(100) DEFAULT NULL,
  `ExpedienteFecAlta` date DEFAULT NULL,
  PRIMARY KEY (`PacienteId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.expediente: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `expediente` DISABLE KEYS */;
INSERT INTO `expediente` (`PacienteId`, `PacienteNombre`, `PacientePApellido`, `PacienteSApellido`, `PacienteCurp`, `PacienteRFC`, `PacienteEmail`, `PacienteFNacimiento`, `PacienteSexo`, `PacienteECivil`, `PacienteTelCel`, `PacienteTelFijo`, `PacienteLNacimiento`, `PacienteRadica`, `ExpedienteFecAlta`) VALUES
	(1, 'Hilario Martin', 'Herrera', 'Maya', 'HEMH851020HGRRYL01', 'HEMH851020', 'javaprogramer1985@gmail.com', '1985-10-20', 'M', 'Casado', '7471331758', NULL, 'Cd. Altamirano, Gro.', 'Chilpancingo, Gro.', NULL);
/*!40000 ALTER TABLE `expediente` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `MenuCodigo` tinyint(4) NOT NULL,
  `MenuNombre` varchar(50) NOT NULL,
  `MenuTipo` enum('S','I') NOT NULL,
  `MenuTipoUsuario` enum('1','2') NOT NULL,
  `MenuCodigoSubmenu` tinyint(4) DEFAULT NULL,
  `MenuEstado` bit(1) DEFAULT NULL,
  `MenuUrl` varchar(150) DEFAULT NULL,
  `MenuIcon` varchar(50) DEFAULT NULL,
  `MenuSeleccionado` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MenuCodigo`),
  KEY `FKCodigoSubMenu` (`MenuCodigoSubmenu`),
  CONSTRAINT `FKCodigoSubMenu` FOREIGN KEY (`MenuCodigoSubmenu`) REFERENCES `menu` (`MenuCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.menu: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`MenuCodigo`, `MenuNombre`, `MenuTipo`, `MenuTipoUsuario`, `MenuCodigoSubmenu`, `MenuEstado`, `MenuUrl`, `MenuIcon`, `MenuSeleccionado`) VALUES
	(1, 'Principal', 'I', '1', NULL, b'1', 'home.softwareatumedida', 'fas fa-home', 'mdl-navigation__link--current'),
	(2, 'Medico', 'I', '1', NULL, b'1', 'medico.softwareatumedida', 'fas fa-user-md', ' '),
	(3, 'Agendar cita', 'I', '1', NULL, b'1', 'cita.softwareatumedida', 'fas fa-calendar-alt', ' '),
	(4, 'Crear expediente', 'I', '1', NULL, b'1', 'expediente.softwareatumedida', 'fas fa-folder-minus', ' '),
	(5, 'Menu', 'I', '1', NULL, b'1', 'utileria/menu.softwareatumedida', 'fas fa-bars', ' '),
	(6, 'Usuario', 'I', '1', NULL, b'1', 'utileria/testForm.softwareatumedida', 'fas fa-users', ' ');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.personal
CREATE TABLE IF NOT EXISTS `personal` (
  `UsuarioUsr` varchar(100) NOT NULL,
  `UsuarioPass` varchar(100) DEFAULT NULL,
  `UsuarioNombre` varchar(100) DEFAULT NULL,
  `UsuarioApellido` varchar(100) DEFAULT NULL,
  `UsuarioFecAlta` date DEFAULT NULL,
  `UsuarioEstado` tinyint(4) DEFAULT NULL,
  `UsuarioFecBaja` date DEFAULT NULL,
  `CTusuarioId` int(11) DEFAULT NULL,
  `UsuarioDomicilio` varchar(100) DEFAULT NULL,
  `UsuaroEmail` varchar(100) DEFAULT NULL,
  `UsuarioTel1` varchar(45) DEFAULT NULL,
  `UsuarioTel2` varchar(45) DEFAULT NULL,
  `UsuarioTel3` varchar(45) DEFAULT NULL,
  `UsuarioTel4` varchar(45) DEFAULT NULL,
  `EmpresaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`UsuarioUsr`),
  KEY `FK_TipoUsuario_idx` (`CTusuarioId`),
  KEY `FK_Empresa_idx` (`EmpresaId`),
  CONSTRAINT `FK_Empresa` FOREIGN KEY (`EmpresaId`) REFERENCES `empresa` (`EmpresaId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_TipoUsuario` FOREIGN KEY (`CTusuarioId`) REFERENCES `c_tipousuario` (`CTusuarioId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacena el personal que hay en una empresa y sus claves de acceso al sistema	';

-- Volcando datos para la tabla softwareatumedidaclinica.personal: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` (`UsuarioUsr`, `UsuarioPass`, `UsuarioNombre`, `UsuarioApellido`, `UsuarioFecAlta`, `UsuarioEstado`, `UsuarioFecBaja`, `CTusuarioId`, `UsuarioDomicilio`, `UsuaroEmail`, `UsuarioTel1`, `UsuarioTel2`, `UsuarioTel3`, `UsuarioTel4`, `EmpresaId`) VALUES
	('MiUser', 'MiPass', 'Emiliano', 'Herrera Naya', '2018-11-09', 1, '1753-01-01', 2, 'Av. Insurgentes Num. 45 ', 'email@gmail.com', 'Tel1', 'Tel2', 'Tel3', 'Tel4', 1);
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.prescripcion
CREATE TABLE IF NOT EXISTS `prescripcion` (
  `PrescripcionId` int(11) NOT NULL,
  `RecetaId` int(11) DEFAULT NULL,
  `PrescripcionMedicamento` varchar(100) DEFAULT NULL,
  `PrescripcionFrecDuracion` varchar(100) DEFAULT NULL,
  `PrescripcionInstrucciones` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`PrescripcionId`),
  KEY `FK_PrescripcionReceta_idx` (`RecetaId`),
  CONSTRAINT `FK_PrescripcionReceta` FOREIGN KEY (`RecetaId`) REFERENCES `receta` (`RecetaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.prescripcion: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `prescripcion` DISABLE KEYS */;
INSERT INTO `prescripcion` (`PrescripcionId`, `RecetaId`, `PrescripcionMedicamento`, `PrescripcionFrecDuracion`, `PrescripcionInstrucciones`) VALUES
	(1, 1, 'Omeprazol 500mg', 'Tomar c/8 horas durante 1 mes', NULL);
/*!40000 ALTER TABLE `prescripcion` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.receta
CREATE TABLE IF NOT EXISTS `receta` (
  `RecetaId` int(11) NOT NULL,
  `UsuarioUsr` varchar(100) DEFAULT NULL,
  `RxId` int(11) DEFAULT NULL,
  `RecetaFecExpedicion` date DEFAULT NULL,
  `RecetaTa` varchar(45) DEFAULT NULL,
  `RecetaPeso` varchar(45) DEFAULT NULL,
  `RecetaTalla` varchar(45) DEFAULT NULL,
  `RecetaImc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`RecetaId`),
  KEY `FK_RecetaDiagnostico_idx` (`RxId`),
  KEY `FK_RecetaPersonal_idx` (`UsuarioUsr`),
  CONSTRAINT `FK_RecetaDiagnostico` FOREIGN KEY (`RxId`) REFERENCES `diagnostico` (`RxId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_RecetaPersonal` FOREIGN KEY (`UsuarioUsr`) REFERENCES `personal` (`UsuarioUsr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.receta: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` (`RecetaId`, `UsuarioUsr`, `RxId`, `RecetaFecExpedicion`, `RecetaTa`, `RecetaPeso`, `RecetaTalla`, `RecetaImc`) VALUES
	(1, 'MiUser', 1, '2018-11-09', '180/90', '90kg', '92', '25');
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `UsuarioUsr` varchar(100) NOT NULL,
  `UsuarioPass` varchar(100) NOT NULL,
  `UsuarioNombre` varchar(100) NOT NULL DEFAULT ' ',
  `UsuarioApellido` varchar(100) NOT NULL DEFAULT ' ',
  `UsuarioFecAlta` date NOT NULL,
  `UsuarioEstado` tinyint(1) NOT NULL DEFAULT '1',
  `UsuarioFecBaja` date NOT NULL,
  `UsuarioTipo` enum('A','C') NOT NULL DEFAULT 'C',
  `UsuarioDomicilio` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`UsuarioUsr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`UsuarioUsr`, `UsuarioPass`, `UsuarioNombre`, `UsuarioApellido`, `UsuarioFecAlta`, `UsuarioEstado`, `UsuarioFecBaja`, `UsuarioTipo`, `UsuarioDomicilio`) VALUES
	('Admin', 'tsIm+toU+7g=', 'Hilario Martín', 'Herrera Maya', '2018-10-11', 1, '1753-01-01', 'A', 'Desarrollo Calle 7 en Col. Agrícola Pantitlán');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
