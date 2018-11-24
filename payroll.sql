-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: payroll
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attendance` (
  `id` bigint(20) NOT NULL,
  `days_worked` int(11) NOT NULL,
  `month` int(11) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr7q0h8jfngkyybll6o9r3h9ua` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (4,30,0,2018,1),(6,27,1,2018,1),(8,15,2,2018,1),(10,30,3,2018,1),(12,27,4,2018,1),(14,23,5,2018,1),(16,26,6,2018,1),(18,20,7,2018,1),(20,30,8,2018,1),(22,30,9,2018,1),(24,28,10,2018,1),(26,27,11,2018,1),(28,30,0,2018,2),(30,26,1,2018,2),(32,30,2,2018,2),(34,22,3,2018,2),(36,27,4,2018,2),(38,30,5,2018,2),(44,30,6,2018,2),(46,29,7,2018,2),(48,30,8,2018,2),(50,30,9,2018,2),(52,30,10,2018,2),(54,30,11,2018,2);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `leave_balance` int(11) NOT NULL,
  `manager_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `sex` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'CS','Manager','vipul@gmail.com',5,1,'Vipul','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',9716539257,'Male'),(2,'CS','AssistantManager','nilesh@gmail.com',24,1,'Nilesh','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',9898989898,'Male'),(39,'CS','Clerk','yash@gmail.com',5,2,'Yash','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',9716539257,'Male'),(40,'CS','Clerk','kd@gmail.com',5,2,'KD','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',9716539257,'Male'),(41,'CS','AssistantManager','saurabh@gmail.com',3,1,'Saurabh','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',9716539257,'Male');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (56),(56),(56),(56);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaves`
--

DROP TABLE IF EXISTS `leaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `leaves` (
  `id` bigint(20) NOT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `number_leaves` int(11) NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoyaicpcjhq2kad5vgtlexcjjo` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaves`
--

LOCK TABLES `leaves` WRITE;
/*!40000 ALTER TABLE `leaves` DISABLE KEYS */;
INSERT INTO `leaves` VALUES (42,'2018-11-26',2,'2018-11-24',2),(55,'2018-11-29',6,'2018-11-23',2);
/*!40000 ALTER TABLE `leaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salary` (
  `id` bigint(20) NOT NULL,
  `basic` int(11) NOT NULL,
  `da` int(11) NOT NULL,
  `hra` int(11) NOT NULL,
  `month` int(11) DEFAULT NULL,
  `pf` int(11) NOT NULL,
  `ta` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnlnv3jbyvbiu8ci59r3btlk00` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (3,60000,30000,30000,0,7800,6000,2018,1),(5,54000,27000,27000,1,7020,5400,2018,1),(7,30000,15000,15000,2,3900,3000,2018,1),(9,60000,30000,30000,3,7800,6000,2018,1),(11,54000,27000,27000,4,7020,5400,2018,1),(13,46000,23000,23000,5,5980,4600,2018,1),(15,52000,26000,26000,6,6760,5200,2018,1),(17,40000,20000,20000,7,5200,4000,2018,1),(19,60000,30000,30000,8,7800,6000,2018,1),(21,60000,30000,30000,9,7800,6000,2018,1),(23,56000,28000,28000,10,7280,5600,2018,1),(25,54000,27000,27000,11,7020,5400,2018,1),(27,39990,19995,19995,0,5198,3999,2018,2),(29,34658,17329,17329,1,4505,3465,2018,2),(31,39990,19995,19995,2,5198,3999,2018,2),(33,29326,14663,14663,3,3812,2932,2018,2),(35,35991,17995,17995,4,4678,3599,2018,2),(37,39990,19995,19995,5,5198,3999,2018,2),(43,39990,19995,19995,6,5198,3999,2018,2),(45,38657,19328,19328,7,5025,3865,2018,2),(47,39990,19995,19995,8,5198,3999,2018,2),(49,39990,19995,19995,9,5198,3999,2018,2),(51,39990,19995,19995,10,5198,3999,2018,2),(53,39990,19995,19995,11,5198,3999,2018,2);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-24 11:47:36
