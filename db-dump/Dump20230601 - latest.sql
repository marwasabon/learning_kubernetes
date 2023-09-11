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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_service`
--

LOCK TABLES `additional_service` WRITE;
/*!40000 ALTER TABLE `additional_service` DISABLE KEYS */;
INSERT INTO `additional_service` VALUES (1,'Hunting Service'),(2,'Call Masking');
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
  `class_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'Basic'),(3,'Silver Plus'),(5,'Dimond'),(6,'Platinum'),(9,'Silver'),(10,'Golden');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new_table`
--

DROP TABLE IF EXISTS `new_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `new_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `routingmsisdn` varchar(45) DEFAULT NULL,
  `shortcodeid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_table`
--

LOCK TABLES `new_table` WRITE;
/*!40000 ALTER TABLE `new_table` DISABLE KEYS */;
INSERT INTO `new_table` VALUES (1,'912001282','3598'),(2,'912001281','3634'),(3,'912712200','3681'),(4,'912362449','3682'),(5,'930087962','6450'),(6,'155148110','2970'),(7,'0187-113612','3890'),(8,'Old Number','2741'),(9,'123055598','3840'),(10,'900009930','3631'),(11,'119650165','3848'),(12,'912615451','3588'),(13,'123284308','3808'),(14,'906000095','3653'),(15,'120068011','3900'),(16,'964040650','2217'),(17,'999992168','3667'),(18,'110238941','2246'),(19,'123748366','2206'),(20,'110230067','3676'),(21,'156557807','2366'),(22,'9692512298','6778'),(23,'100666909','3877'),(24,'912395226','3850'),(25,'916945555','4243'),(26,'127463902','4646'),(27,'123307650','3620'),(28,'930088770','3419'),(29,'0183-528838','3627'),(30,'118728690','6390'),(31,'127464001','3801'),(32,'999949915','4567'),(33,'922406176','2802'),(34,'123741747','3855'),(35,'122216363','3818'),(36,'119800861','3661'),(37,'918110082','3835'),(38,'912001266','1335'),(39,'112561003','3830'),(40,'900286733 ','6702 '),(41,'911716640','6774'),(42,'Old One','6806'),(43,'Old One','2707'),(44,'123595642','3720'),(45,'901231697','1308'),(46,'100155721','40023'),(47,'907700110','40321'),(48,'0183-740702','6242'),(49,'912531151','1300'),(50,'900717060','7060'),(51,'903993214','2602'),(52,'912001300','2613'),(53,'912001300','6838'),(54,'123397700','2869'),(55,'930116700','2982'),(56,'912001283','7288'),(57,'112553474','3805'),(58,'183478040','2567'),(59,'2.50E+11','3887'),(60,'961739842','4400'),(61,' 0912530954','2487 '),(62,' 09138999952',' 2897'),(63,'120041425','6922'),(64,'183288829','3330'),(65,'912001300','3484'),(66,'900724488','2692'),(67,'911717974','3293'),(68,'906748421','2887'),(69,'900904061','2901'),(70,'911718503','6739'),(71,'114764026','1920'),(72,'117777071','2767');
/*!40000 ALTER TABLE `new_table` ENABLE KEYS */;
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
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (2,'Corporate Business Solution','CBS'),(1,'admin','AD'),(7,'Corporate Sales Info','CSI'),(10,'Role',' R1'),(11,'USER','ADE');
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
  `routingmsisdn` varchar(255) DEFAULT NULL,
  `shortcodeid` bigint DEFAULT NULL,
  PRIMARY KEY (`routingmsisdnid`),
  KEY `FK331mmqx9dbt30f2sv294gr3mf` (`shortcodeid`)
) ENGINE=MyISAM AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routing_msisdns`
--

LOCK TABLES `routing_msisdns` WRITE;
/*!40000 ALTER TABLE `routing_msisdns` DISABLE KEYS */;
INSERT INTO `routing_msisdns` VALUES (1,'912001282',1),(2,'912001281',2),(3,'912712200',3),(4,'912362449',4),(5,'930087962',5),(6,'155148110',6),(7,'0187-113612',7),(8,'Old Number',8),(9,'123055598',9),(10,'900009930',10),(11,'119650165',11),(12,'912615451',12),(13,'123284308',13),(14,'906000095',14),(15,'120068011',15),(16,'964040650',16),(17,'999992168',17),(18,'110238941',18),(19,'123748366',19),(20,'110230067',20),(21,'156557807',21),(22,'9692512298',22),(23,'100666909',23),(24,'912395226',24),(25,'916945555',25),(26,'127463902',26),(27,'123307650',27),(28,'930088770',28),(29,'0183-528838',29),(30,'118728690',30),(31,'127464001',31),(32,'999949915',32),(33,'922406176',33),(34,'123741747',34),(35,'122216363',35),(36,'119800861',36),(37,'918110082',37),(38,'912001266',38),(39,'112561003',39),(40,'900286733Â ',40),(41,'911716640',41),(42,'Old One',42),(43,'Old One',43),(44,'123595642',44),(45,'901231697',45),(46,'100155721',46),(47,'907700110',47),(48,'0183-740702',48),(49,'912531151',49),(50,'900717060',50),(51,'903993214',51),(52,'912001300',52),(53,'912001300',53),(54,'123397700',54),(55,'930116700',55),(56,'912001283',56),(57,'112553474',57),(58,'183478040',58),(59,'2.50E+11',59),(60,'961739842',60),(61,'Â 0912530954',61),(62,'Â 09138999952',62),(63,'120041425',63),(64,'183288829',64),(65,'912001300',65),(66,'900724488',66),(67,'911717974',67),(68,'906748421',68),(69,'900904061',69),(70,'911718503',70),(71,'114764026',71),(72,'117777071',72);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segment`
--

LOCK TABLES `segment` WRITE;
/*!40000 ALTER TABLE `segment` DISABLE KEYS */;
INSERT INTO `segment` VALUES (1,'SMEs'),(2,'MA'),(3,'Government '),(4,'Region'),(5,'SM'),(6,'NGOS'),(7,'B.S'),(11,'SMs');
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
  `account_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `activation_date` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `follow_up_number` varchar(255) DEFAULT NULL,
  `short_code_price` varchar(255) DEFAULT NULL,
  `shortcodeno` varchar(255) DEFAULT NULL,
  `zain_requester_account` varchar(255) DEFAULT NULL,
  `zain_requester_email` varchar(255) DEFAULT NULL,
  `segment_id` bigint DEFAULT NULL,
  `status_id` bigint DEFAULT NULL,
  `class_id` bigint DEFAULT NULL,
  `aservice_id` bigint DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_by_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shortcodeid`),
  KEY `FKavbmnjoxfk032e0nqabci6f9v` (`aservice_id`),
  KEY `FK27xkhk91gtqlmi5j4swtwdu7p` (`class_id`),
  KEY `FKkfrlmuicjw2cqj061guttdihn` (`segment_id`),
  KEY `FKjfho3r41efb1ewcaopj7ro5i8` (`status_id`)
) ENGINE=MyISAM AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shortcode`
--

LOCK TABLES `shortcode` WRITE;
/*!40000 ALTER TABLE `shortcode` DISABLE KEYS */;
INSERT INTO `shortcode` VALUES (1,'شركة مارينا للمشاريع المتطورة','2023-01-07 00:00:00',NULL,NULL,'وليد احمد\n',NULL,'912106583','3141','3598','Mirvat',NULL,1,1,NULL,NULL,NULL,NULL),(2,'monawir','2023-01-07 00:00:00',NULL,NULL,'ebthaj',NULL,'900906027','3141','3634','Shaza hassan ',NULL,1,1,NULL,NULL,NULL,NULL),(3,'تكاسى اكسبريس للخدمات التجارية\n','2023-01-07 00:00:00',NULL,NULL,'محمد حسين\n',NULL,'914388338','3141','3681','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(4,'أعمال اسمارت لينك لتقنية المعلومات\n','2023-01-07 00:00:00',NULL,NULL,'كنانى احمد\n',NULL,'912362449','3141','3682','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(5,'شركة اوت اوف ذا بوكس للاستثمار\n','2023-01-07 00:00:00',NULL,NULL,'ايرينى طلعت\n',NULL,'123228852','3141','6450','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(6,'شركة الصناعات الوطنية\n','2023-01-07 00:00:00',NULL,NULL,'ابوبكر بخيت\n',NULL,'123380642','3141','2970','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(7,'جمعية الشارقة الخيرية\n','2023-01-07 00:00:00',NULL,NULL,'اجلال محمد\n',NULL,'918377526','3141','3890','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(8,'شركة ابوسيفين انترناشونال لخدمات المواتر\n','2023-01-16 00:00:00',NULL,NULL,'يوئيل يعقوب\n',NULL,'912469083','3141','2741','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(9,'قولدن لاينز الهندسية\n','2023-01-07 00:00:00',NULL,NULL,'مصعب الامير\n',NULL,'912319014','3141','3840','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(10,'شركة رنين فون للالكترونيات\n','2023-01-16 00:00:00',NULL,NULL,'نزار عبدالقادر\n',NULL,'912200141','7854','3631','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(11,'مطاعم النيلين للاسماك\n','2023-01-16 00:00:00',NULL,NULL,'احمد محمد\n',NULL,'918495764','7854','3848','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(12,'شركة بن منصور للانشطة المتعددة المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'محمد حمد\n',NULL,'912615451','7854','3588','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(13,'شركة افروسكوت سيرفيسس المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'صديق الهادى\n',NULL,'123284351','7854','3808','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(14,'مطعم الامبراطور للاسماك\n','2023-01-16 00:00:00',NULL,NULL,'طارق حامد\n',NULL,'912858035','7854','3653','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(15,'شركة بارما الاستثمارية المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'معاذ شرف الدين\n',NULL,'120068003','7854','3900','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(16,'عطارة المنذر\n','2023-01-16 00:00:00',NULL,NULL,'السمانى محمد\n',NULL,'964040650','7854','2217','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(17,'شركة اس ايه ديزاين الهندسية المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'صلاح الدين الزين\n',NULL,'927727740','7854','3667','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(18,'مدارس الامتياز الخاصة\n','2023-01-18 00:00:00',NULL,NULL,'محمد مصطفى\n',NULL,'927984519','7854','2246','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(19,'زاهرود المرضى للتجارة\n','2023-01-17 00:00:00',NULL,NULL,'محمد احمد\n',NULL,'912102984','7854','2206','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(20,'شركة البطريق للتجارة والخدمات المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'خلف الله محمد\n',NULL,'912709565','7854','3676','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(21,'شركة اى ترانراكشنز المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'عصام الدين احمد\n',NULL,'911111986','7854','2366','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(22,'الرؤية جروب للاستيراد والتصدير والتوكيلات التجارية\n','2023-01-16 00:00:00',NULL,NULL,'هيثم صلاح\n',NULL,'122235888','7854','6778','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(23,'شركة ديفو الطبية المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'مصعب النور \n',NULL,'910004090','7854','3877','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(24,'وكالة اوراد للسفر والسياحة\n','2023-01-18 00:00:00',NULL,NULL,'محمد عيسى\n',NULL,'912395226','3141','3850','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(25,'bashasha','2023-01-16 00:00:00',NULL,NULL,'mohamed',NULL,'2.50E+11','23750','4243','Shaza hassan ',NULL,1,2,NULL,NULL,NULL,NULL),(26,'مكافحة العنف ضد المرأة والطفل\n','2023-01-16 00:00:00',NULL,NULL,'بانقا صالح \n',NULL,'915007208','31500','4646','Osman ismat',NULL,2,1,NULL,NULL,NULL,NULL),(27,'مطعم الالسكالا\n','2023-01-18 00:00:00',NULL,NULL,'فاروق محمد\n',NULL,'912893654','3141','3620','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(28,'اعمال على الله للاستيراد والتصدير\n','2023-01-11 00:00:00',NULL,NULL,'عماد الدين محمد\n',NULL,'129155972','3141','3419','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(29,'ألفا ميد التشخيصى\n','2023-01-18 00:00:00',NULL,NULL,'عمر عثمان\n',NULL,'123716789','3141','3627','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(30,'اعمال مارسيل التجارية\n','2023-01-16 00:00:00',NULL,NULL,'روزالين لطيف\n',NULL,'993594560','3141','6390','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(31,'مركز اكسلانت للتدريب\n','2023-01-18 00:00:00',NULL,NULL,'محمد مصطفى\n',NULL,'927984519','3141','3801','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(32,'شركة الظافر سنس المحدودة\n','2023-01-11 00:00:00',NULL,NULL,'ريان على\n',NULL,'999949932','3141','4567','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(33,'شركة كاولين العالمية للتجارة\n','2023-01-11 00:00:00',NULL,NULL,'مزمل الامين\n',NULL,'123901106','7854','2802','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(34,'تريند العقارية\n','2023-01-16 00:00:00',NULL,NULL,'السمانى صلاح\n',NULL,'922307944','7854','3855','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(35,'شركة ايسترن للملاحه المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'ابوبكر سيف الدين\n',NULL,'122216363','7854','3818','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(36,'شركة رافت سامى المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'سامى نبيل\n',NULL,'912666370','7854','3661','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(37,'شركة رافت سامى المحدودة\n','2023-01-18 00:00:00',NULL,NULL,'عادل حسن\n',NULL,'918110082','7854','3835','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(38,'شركة المناهرى التجارية المحدودة\n','2023-01-23 00:00:00',NULL,NULL,'محى الدين حسن\n',NULL,'900344111','7854','1335','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(39,'جيتاترونيك للاستيراد والتصدير\n','2023-01-16 00:00:00',NULL,NULL,'محمد سيد\n',NULL,'118010244','23562','3830','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(40,' Mercy Corps','2023-01-16 00:00:00',NULL,NULL,'Mohammed Gafar ',NULL,' +249964950911  ','3,141.60 ','6702 ','Suhaima Mustafa',NULL,6,2,NULL,NULL,NULL,NULL),(41,'واصل للخدمات المحدودة\n','2023-01-12 00:00:00',NULL,NULL,'شمس الريان\n',NULL,'912369211','7854','6774','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(42,'Qutar Bank','2023-01-16 00:00:00',NULL,NULL,'',NULL,'','7854','6806','Mohamed Elboshra',NULL,3,2,NULL,NULL,NULL,NULL),(43,'بوهيات الشروق\n','2023-01-16 00:00:00',NULL,NULL,'',NULL,'','7854','2707','Mohamed Elboshra',NULL,3,2,NULL,NULL,NULL,NULL),(44,'شركة رانكين للهندسة والمقاولات\n','2023-01-16 00:00:00',NULL,NULL,'مصعب تاج السر\n',NULL,'912378663','3141','3720','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(45,'مطعم وكافية سمكنا\n','2023-01-30 00:00:00',NULL,NULL,'مصطفى عثمان\n',NULL,'912243687','3141','1308','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(46,'شركة عصامكو للانشطة المتعددة\n','2023-01-16 00:00:00',NULL,NULL,'هاله عبدالمنعم\n',NULL,'920827644','7854','40023','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(47,'شركة لاين كير للخدمات الذكية\n','2023-01-16 00:00:00',NULL,NULL,'عماد محمد\n',NULL,'912188345','3141','40321','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(48,'شركة الفافا للكمبيوتر\n','2023-01-16 00:00:00',NULL,NULL,'عباس هاشم\n',NULL,'111117059','7854','6242','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(49,'شركة النيلين للتأمين\n','2023-01-16 00:00:00',NULL,NULL,'سيان عثمان\n',NULL,'990990931','7854','1300','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(50,'شركة صم للتجارة والاستثمار  المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'النور  محمد\n',NULL,'912503054','23562','7060','Rasha Abdelwahab',NULL,1,1,NULL,NULL,NULL,NULL),(51,'معامل تست لاب للتحاليل الطبية\n','2023-01-16 00:00:00',NULL,NULL,'وضاح عبدالحكيم\n',NULL,'123221945','3141','2602','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(52,'مطعم ايطاليانو بروست ايطاليانو جريل\n','2023-01-16 00:00:00',NULL,NULL,'مهند احمد\n',NULL,'910400897','3141','2613','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(53,'دي ار بيرقر للسندوتشات\n','2023-01-16 00:00:00',NULL,NULL,'مهند احمد\n',NULL,'910400897','7854','6838','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(54,'معمل الريادة الطبي الحديث\n','2023-01-16 00:00:00',NULL,NULL,'عبدالحافظ محمد\n',NULL,'127900700','3141','2869','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(55,'شركه المتانه التركيه\n','2023-01-16 00:00:00',NULL,NULL,'',NULL,'','7854','2982','Alhaitham Mahmoud',NULL,1,2,NULL,NULL,NULL,NULL),(56,'شركة داينستي للخدمات الطبية المحدودة\n','2023-01-18 00:00:00',NULL,NULL,'ابوبكر الصديق\n',NULL,'911229220','7854','7288','Mirvat',NULL,1,1,NULL,NULL,NULL,NULL),(57,'شركة اي بي ام للتجارة والاستثمار المحدودة\n','2023-01-16 00:00:00',NULL,NULL,'الشفيع',NULL,'912825433','3141','3805','Mirvat',NULL,1,1,NULL,NULL,NULL,NULL),(58,'شركة اماديوس سودانى المحدودة\n','2023-01-18 00:00:00',NULL,NULL,'ناجى محمد\n',NULL,'912395139','3141','2567','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(59,'كلية الخرطوم التطبيقية\n','2023-02-08 00:00:00',NULL,NULL,'يحي خالد\n',NULL,'900995050','7854','3887','Mirvat',NULL,1,1,NULL,NULL,NULL,NULL),(60,'شركة التأمين الاسلامية\n','2023-01-24 00:00:00',NULL,NULL,'مهيد عبد المنعم\n',NULL,'961739842','7854','4400','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(61,'NCA ','2023-01-26 00:00:00',NULL,NULL,'Abdelsalam Adlan ',NULL,' 0912673506','3,141.60 ','2487 ','Suhaima Mustafa',NULL,6,2,NULL,NULL,NULL,NULL),(62,' NCA','2023-01-26 00:00:00',NULL,NULL,'Abdelsalam Adlan  ',NULL,' 0912673506','3,141.60  ',' 2897','Suhaima Mustafa',NULL,6,2,NULL,NULL,NULL,NULL),(63,'عوض سلفر\n','2023-01-26 00:00:00',NULL,NULL,'اجلال محمد\n',NULL,'918377526','7854','6922','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(64,'شركة ارادة للتمويل الاصغر المحدودة\n','2023-01-26 00:00:00',NULL,NULL,'عثمان تاور\n',NULL,'925615554','15708','3330','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(65,'تطبيق فارميدو هيلث كير الالكتروني\n','2023-01-26 00:00:00',NULL,NULL,'خليل فتحي\n',NULL,'912301217','3141','3484','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(66,'شركة هايبر  نوفا المحدوده\n','2023-01-26 00:00:00',NULL,NULL,'نزار عوض الله علي\n',NULL,'110221245','7854','2692','Abier Hassan Elkhier',NULL,1,2,NULL,NULL,NULL,NULL),(67,'شركة هايبر  نوفا المحدوده\n','2023-01-26 00:00:00',NULL,NULL,'نزار عوض الله علي\n',NULL,'110221245','7854','3293','Abier Hassan Elkhier',NULL,1,2,NULL,NULL,NULL,NULL),(68,'مستشفى دار العلاج التخصصى\n','2023-01-26 00:00:00',NULL,NULL,'عثمان الامين\n',NULL,'123788553','7854','2887','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(69,'مركز الرومى الطبى\n','2023-01-26 00:00:00',NULL,NULL,'احمد تاج السر\n',NULL,'968121821','3142','2901','Rasha Abdelwahab',NULL,1,2,NULL,NULL,NULL,NULL),(70,'كويك بيرقر\n','2023-01-26 00:00:00',NULL,NULL,'عمر احميمر\n',NULL,'912242426','3141','6739','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(71,'مصنع افروكينج لزيوت وشحوم السيارات\n','2023-01-26 00:00:00',NULL,NULL,'مهند',NULL,'917355354','3141','1920','Mirvat',NULL,1,2,NULL,NULL,NULL,NULL),(72,'مركز النيل للعيون\n','2023-01-18 00:00:00',NULL,'2023-05-05 00:00:00','مصعب','2023-05-05 00:00:00','123081718','3141','2767','Mirvat',NULL,1,2,NULL,NULL,'m.sabon','[admin]');
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
  `status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'New'),(2,'Renewal '),(3,'Disconnect');
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
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'Dalia.fatahelrahman@sd.zain.com','Dalia omer',0,'d.eltinay',1),(4,'marwasabon@zain.sd.com','Marwa Jaberallah Sabon',1,'m.sabon',1),(24,'manarjaberallah@gmail.com','Omar',1,'Omar',11);
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

-- Dump completed on 2023-06-01  2:50:29
