-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: baseaviones
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aviones`
--

DROP TABLE IF EXISTS `aviones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aviones` (
  `COD_AVION` int(11) NOT NULL,
  `MODELO` varchar(30) DEFAULT NULL,
  `AEROLINEA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`COD_AVION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aviones`
--

LOCK TABLES `aviones` WRITE;
/*!40000 ALTER TABLE `aviones` DISABLE KEYS */;
INSERT INTO `aviones` VALUES (1,'Airbus','Tame'),(2,'360','Avianca');
/*!40000 ALTER TABLE `aviones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `COD_CLIENTE` int(11) NOT NULL,
  `CEDULA_CLIENTE` varchar(10) DEFAULT NULL,
  `NACIONALIDAD_CLIENTE` varchar(50) DEFAULT NULL,
  `NOMBRE_CLIENTE` varchar(50) DEFAULT NULL,
  `APELLIDO_CLIENTE` varchar(50) DEFAULT NULL,
  `FECHA_NAC` date DEFAULT NULL,
  PRIMARY KEY (`COD_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'1723061550','Ecuador','Oscar','Fierro','1995-10-19'),(2,'1723061550','ecuatoriana','Oscar','Fierro','0025-04-21'),(3,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-13'),(4,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(5,'1723061550','ecuaotoriana','Martin','Fierro','0024-11-11'),(6,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-16'),(7,'1723061550','ecuatoriana','Oscar','Fierro','0025-04-14'),(8,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(9,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(10,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(11,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(12,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(13,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(14,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(15,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(16,'1723061550','eucatoriana','Oscar','Fierro','0025-03-17'),(17,'1723061550','eucatoriana','Oscar','Fierro','0025-03-17'),(18,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-17'),(19,'1723061550','ecuatoriana','Oscar','Fierro','0016-05-15'),(20,'1703576155','ecuatoriana','Carlos','Perez','0025-03-29'),(21,'1703576155','ecuatoriana','Carlos','Perez','0025-03-29'),(22,'1723061550','ecuatoriana','Oscar','Fierro','0025-03-15'),(23,'9182738971','lkadhlkahslkd','lkahsdlkahsd','lkahdslkhaksld','0025-02-28'),(24,'1234123123','eadasd','asdasd','asdasd','0025-03-09'),(25,'1231231231','asdasd','osca','sadasd','0025-10-01'),(26,'1231231231','asdasda','asdasd','asdasd','0020-10-28'),(27,'1324123123','asdasda','adasd','asdasd','0014-11-15'),(28,'1231231231','asdasd','dad','asdasd','0020-10-28'),(29,'1231231231','asdasd','dad','asdasd','0020-10-28'),(30,'1231231231','asdasd','adasdas','asdasd','0020-10-28'),(31,'1231231231','asdasdasd','adasdasd','asdasdasd','0020-10-28'),(32,'1231231231','gasdasd','asdasdasd','asdasd','0014-11-15'),(33,'9191919919','kakkakak','kakakkaka','kakakakka','0014-11-15'),(34,'6666666666','jjjjjjjjjjjjjjjjj','jjjjjjjjjjjjjj','jjjjjjjjjjjjjjjjjjj','0029-10-30'),(35,'5555555555','yyyyyyyyyyyyyyy','yyyyyyyyyyyyyy','yyyyyyyyyyyyyyy','0020-12-15'),(36,'4343434343','hhhhhhhhhhh','tttttttttt','tttttttttt','0020-10-28'),(37,'3333333333','uuuiuiui','yyttrt','adasdasd','0014-11-15'),(38,'1723061502','qtqtqt','awewe','wtqtqt','0014-11-15'),(39,'5555555555','jjjjjjjjjjjj','yyyyyyyyyyy','uuuuuuuuuuuuu','0020-10-28'),(40,'5555555555','jjjjjjjjjjjj','yyyyyyyyyyy','uuuuuuuuuuuuu','0020-10-28'),(41,'1723615212','asdasd','asdasd','asdad','0014-11-15'),(42,'1231231231','adasd','asdasd','asdasd','0014-11-15'),(43,'1111111111','asdasdasd','asdasdasd','asdasdasd','0014-11-15'),(44,'3333333333','asd','asd','asd','0014-11-15'),(45,'1231231231','asdasd','asdasd','asdasd','0014-11-15'),(46,'1111111111','asdasd','sdsd','asdasd','0014-11-15'),(47,'1111111111','fff','cgfff','fff','0014-11-15'),(48,'1111111111','asdasd','asdasd','asdasd','0014-11-15'),(49,'1231231231','asdasd','adasd','asdasd','0014-11-15'),(50,'1111111111','aaa','sss','aaa','0014-11-15'),(51,'1111111111','111','asdasd','asdasd','0014-11-15'),(52,'1231231231','aa','aa','aaa','0014-11-15'),(53,'1111111111','asdasd','asdasd','asdasd','0014-11-15'),(54,'1231231231','asd','asda','asd','0014-11-15'),(55,'6666666666','asd','asdas','asd','0014-11-15'),(56,'1111111111','asdasd','1asdasd','adsd','0014-11-15'),(57,'1231231231','123123123','asasdasd','123123123','0014-11-15'),(58,'1111111111','asdasd','asdasdasd','adasd','0014-11-15'),(59,'1111111111','asdasd','asdasdasd','adasd','0014-11-15'),(60,'1111111111','asdasd','asdasdasd','adasd','0014-11-15'),(61,'1111111111','asdasd','asdasd','asdasd','0029-10-30'),(62,'1231231231','asdasd','adsd','asdasd','0020-10-28'),(63,'1231231231','asdasd','asdasd','asdasd','0016-03-26'),(64,'1231231231','ttttt','adsadsasd','asdasd','0029-10-30'),(65,'1723072727','asdasd','adasda','asdasd','0014-11-15'),(66,'8181818818','LKAJSDLK','SKLNLSK','KLSJDKS','0026-08-17');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `cod_reserva` int(11) NOT NULL,
  `numero_asiento` int(11) NOT NULL,
  `cod_vuelo` int(11) DEFAULT NULL,
  `cod_cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_reserva`),
  KEY `cod_vuelo_idx` (`cod_vuelo`),
  KEY `cod_cliente_idx` (`cod_cliente`),
  CONSTRAINT `cod_cliente` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`COD_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cod_vuelo` FOREIGN KEY (`cod_vuelo`) REFERENCES `vuelo` (`COD_VUELO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,1,1,1),(2,2,1,1),(3,8,1,7),(4,5,1,52),(5,20,1,53),(6,10,1,54),(7,7,1,55),(8,19,1,56),(9,11,1,57),(10,12,1,58),(11,12,1,59),(12,12,1,60),(13,13,1,61),(14,9,1,62),(15,14,1,63),(16,6,1,64),(17,15,1,65),(18,16,1,66);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelo`
--

DROP TABLE IF EXISTS `vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vuelo` (
  `COD_VUELO` int(11) NOT NULL,
  `COD_AVION` int(11) NOT NULL,
  `FECHA_SALIDA` datetime DEFAULT NULL,
  `FECHA_LLEGADA` datetime DEFAULT NULL,
  `PRECIO` decimal(4,2) DEFAULT NULL,
  `ORIGEN` varchar(50) DEFAULT NULL,
  `DESTINO` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`COD_VUELO`,`COD_AVION`),
  KEY `FK_VUELO2` (`COD_AVION`),
  CONSTRAINT `FK_VUELO2` FOREIGN KEY (`COD_AVION`) REFERENCES `aviones` (`COD_AVION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelo`
--

LOCK TABLES `vuelo` WRITE;
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` VALUES (1,1,'2018-07-01 00:00:00','2018-07-02 00:00:00',25.00,'Quito','Bogotá'),(2,2,'2018-07-12 00:00:00','2018-07-13 00:00:00',79.00,'Lima','Guayaquil');
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-11 10:10:47
