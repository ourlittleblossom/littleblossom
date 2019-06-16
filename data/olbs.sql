-- MySQL dump 10.13  Distrib 5.7.22, for macos10.13 (x86_64)
--
-- Host: localhost    Database: olbs
-- ------------------------------------------------------
-- Server version	5.7.22

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
-- Table structure for table `configuration`
--

DROP TABLE IF EXISTS `configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuration` (
  `parameter` varchar(50) NOT NULL,
  `value` text,
  PRIMARY KEY (`parameter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuration`
--

LOCK TABLES `configuration` WRITE;
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` VALUES ('aboutUs','{\"society\":\"Our Little Blossom School was founded on July, 2001 with the need for young educated citizens of the country. The society works towards providing quality education to young minds. The mission of the society is to establish strong moral values and passion for learning in every child by organising innovative training and educational programmes.\",\"principalMessage\":\"Every child is special and we at Our Litle Blossom School work towards providing each child full opprotunity and support to take first step towards his/her dream. We help the student to build the character that will be required to withstand extreme challenges and situations in life. We train the students to be a responsible citizen, teach them morale values like honesty, loyalty, respect, patience, kindness and courtesy.\",\"principalName\":\"Poonam Gupta\",\"principalImage\":\"\",\"moto\":\"Darkness to Brightness\",\"motoDescription\":\"Ensure every child\'s development to help achieve a bright future.\"}'),('clickOutsideToClose','false'),('contactUs','{\"emailId\": \"ourlittleblossom@gmail.com\", \"phone\": \"9045489923\",\"address\":\"4/29-A, CHASE COMPOUND, JAIL ROAD, ALIGARH\",\"fbLink\":\"https://www.facebook.com/Our-Little-Blossom-School-468131513564686/\"}'),('discourageDownloads','true'),('serverImageAbsolutePath','/Users/ujjwalgupta/Documents/Olbs/apache-tomcat-8.5.39/webapps/images/'),('serverImagePrefixPath','http://127.0.0.1:1208/images/');
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_images`
--

DROP TABLE IF EXISTS `event_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_images` (
  `event_name` varchar(50) NOT NULL,
  `event_date` date NOT NULL,
  `event_description` text,
  `image_folder_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`event_name`,`event_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_images`
--

LOCK TABLES `event_images` WRITE;
/*!40000 ALTER TABLE `event_images` DISABLE KEYS */;
INSERT INTO `event_images` VALUES ('documents','2019-06-17','House documents','documents/'),('holi','2019-04-13','Holi celebration at our school','holi/'),('home','2019-06-01','Home Images','home/'),('Republic Day','2019-01-26','Independence Day Celebration with honoary guest Shyama Shukla','republicDay/');
/*!40000 ALTER TABLE `event_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_structure`
--

DROP TABLE IF EXISTS `fee_structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_structure` (
  `standard` varchar(50) NOT NULL,
  `tuition_fee` int(11) DEFAULT NULL,
  `annual_fee` int(11) DEFAULT NULL,
  `examination_fee` int(11) DEFAULT NULL,
  `course_fee` int(11) DEFAULT NULL,
  PRIMARY KEY (`standard`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_structure`
--

LOCK TABLES `fee_structure` WRITE;
/*!40000 ALTER TABLE `fee_structure` DISABLE KEYS */;
INSERT INTO `fee_structure` VALUES ('First',500,5000,100,0),('PlayWay',500,5000,50,0);
/*!40000 ALTER TABLE `fee_structure` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-17  0:18:42
