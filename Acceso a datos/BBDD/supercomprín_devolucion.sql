-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: supercomprín
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `devolucion`
--

DROP TABLE IF EXISTS `devolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devolucion` (
  `id_devolucion` int NOT NULL AUTO_INCREMENT,
  `id_compra` int NOT NULL,
  `id_producto` int NOT NULL,
  `id_cliente` int NOT NULL,
  `fecha` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `importe` double NOT NULL,
  `puntos` int NOT NULL,
  PRIMARY KEY (`id_devolucion`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devolucion`
--

LOCK TABLES `devolucion` WRITE;
/*!40000 ALTER TABLE `devolucion` DISABLE KEYS */;
INSERT INTO `devolucion` VALUES (1,2,5,5,'29/11/2020',5,1),(3,8,4,1,'20/1/2002',10,2),(4,6,4,9,'14/9/2015',5,5),(5,2,1,5,'2/5/2009',20,20),(6,9,12,1,'14/9/2015',5.4,10),(7,9,5,1,'29/11/2020',1,101),(8,8,3,1,'30/11/2020',15,87),(9,1,3,1,'29/11/2020',5,97),(10,10,5,1,'29/11/2020',1,102),(11,0,1,9,'2021-02-13 23:00:00.0',50,50),(12,0,1,9,'2021-02-13 23:00:00.0',50,50),(13,0,5,1,'2021-02-13 23:00:00.0',1,1),(14,0,5,1,'2021-02-13 23:00:00.0',1,1),(15,0,5,1,'2021-02-13 23:00:00.0',1,1),(16,0,1,9,'2021-02-13 23:00:00.0',50,50),(17,0,8,10,'2021-02-13 23:00:00.0',10,10),(18,0,8,11,'2021-02-13 23:00:00.0',10,10),(19,0,8,11,'2021-02-13 23:00:00.0',10,10);
/*!40000 ALTER TABLE `devolucion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-14 21:32:52
