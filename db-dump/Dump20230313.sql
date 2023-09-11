CREATE DATABASE  IF NOT EXISTS `shortcode` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shortcode`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: shortcode
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `additional_service`
--

DROP TABLE IF EXISTS `additional_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional_service` (
  `aserviceid` bigint NOT NULL AUTO_INCREMENT,
  `aservice_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aserviceid`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_service`
--

LOCK TABLES `additional_service` WRITE;
/*!40000 ALTER TABLE `additional_service` DISABLE KEYS */;
INSERT INTO `additional_service` VALUES (1,'Hunting Service'),(9,'test'),(3,'Call Masking'),(10,'Man'),(11,'new additional'),(12,'new additional'),(13,'new additional2'),(14,'new additional2'),(16,'new additional23'),(17,'new additional234'),(18,'new additional2345'),(15,'new additional2345'),(19,'new additional2345');
/*!40000 ALTER TABLE `additional_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `classid` bigint NOT NULL AUTO_INCREMENT,
  `class_name` varchar(45) NOT NULL,
  PRIMARY KEY (`classid`),
  UNIQUE KEY `UK_mgg5753yel6celk0t48duc5jx` (`class_name`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'Silver'),(2,'Basic'),(11,'Dimond'),(14,'new class'),(6,'Silver Plus'),(9,'Golden'),(15,'new class2'),(17,'new class3'),(18,'new class4'),(19,'new class5');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(3,'Role1'),(4,'Role2');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routing_msisdns`
--

DROP TABLE IF EXISTS `routing_msisdns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routing_msisdns` (
  `routingmsisdnid` bigint NOT NULL AUTO_INCREMENT,
  `routingmsisdnname` varchar(255) DEFAULT NULL,
  `shortcodeid` bigint DEFAULT NULL,
  PRIMARY KEY (`routingmsisdnid`),
  KEY `FK331mmqx9dbt30f2sv294gr3mf` (`shortcodeid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routing_msisdns`
--

LOCK TABLES `routing_msisdns` WRITE;
/*!40000 ALTER TABLE `routing_msisdns` DISABLE KEYS */;
INSERT INTO `routing_msisdns` VALUES (1,'RoutingMSISDNs 2',1);
/*!40000 ALTER TABLE `routing_msisdns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segment`
--

DROP TABLE IF EXISTS `segment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `segment` (
  `segmentid` bigint NOT NULL AUTO_INCREMENT,
  `segment_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`segmentid`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segment`
--

LOCK TABLES `segment` WRITE;
/*!40000 ALTER TABLE `segment` DISABLE KEYS */;
INSERT INTO `segment` VALUES (1,'SMEs'),(4,'Government'),(3,'MA'),(7,'SM'),(5,'Region'),(8,'NGOS'),(9,'B.S'),(22,'new segment4'),(15,'testing'),(21,'new segment3'),(18,'new segment'),(19,'new segment2'),(23,'new segment5');
/*!40000 ALTER TABLE `segment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shortcode`
--

DROP TABLE IF EXISTS `shortcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shortcode` (
  `shortcodeid` bigint NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `activation_date` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `follow_up_number` varchar(255) DEFAULT NULL,
  `routingmsisdns` varchar(255) DEFAULT NULL,
  `short_code_price` varchar(255) DEFAULT NULL,
  `shortcode_no` varchar(255) DEFAULT NULL,
  `zain_requester_accout` varchar(255) DEFAULT NULL,
  `zain_requester_email` varchar(255) DEFAULT NULL,
  `aserviceid` bigint NOT NULL,
  `classid` bigint NOT NULL,
  `segmentid` bigint NOT NULL,
  `statusid` bigint NOT NULL,
  PRIMARY KEY (`shortcodeid`),
  KEY `FK48rbb3co3d618a0qa287t7a12` (`aserviceid`),
  KEY `FKejecb8ijcjc8ksf7pt1nh9q8u` (`classid`),
  KEY `FKc7tdo5dr4n59sjp5o8wqjcjhl` (`segmentid`),
  KEY `FKp4iyopou7iamc7t5jpmjenwg9` (`statusid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shortcode`
--

LOCK TABLES `shortcode` WRITE;
/*!40000 ALTER TABLE `shortcode` DISABLE KEYS */;
INSERT INTO `shortcode` VALUES (1,'account','2023-03-12 16:01:45','new commment','Marwa jaberallah','2023-03-12 16:01:45','123','1','300','1234','marwa','marwasabon@gmail.com',11,14,18,23);
/*!40000 ALTER TABLE `shortcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `statusid` bigint NOT NULL AUTO_INCREMENT,
  `status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`statusid`),
  UNIQUE KEY `UK_ikty98aye7nunxe4f25a39efl` (`status_name`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (9,'New'),(7,'Renew'),(10,'DISCONNECT'),(23,'new status'),(26,'new status3'),(27,'new status4'),(28,'new status5');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `status` int NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Marwa.sabon@sd.zain.com','Marwa Jaberallah Sabon',1,'m.sabon',1),(2,'Dalia.fatahelrahman@sd.zain.com','Dalia omer',1,'d.eltinay',1),(4,'marwasabon@zain.sd.com','Mohamed Ali Abbas',0,'m.s',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-13 12:48:46
