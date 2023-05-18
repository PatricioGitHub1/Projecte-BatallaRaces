-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: RacesPAC
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.22.04.2

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
-- Table structure for table `BATTLE`
--

DROP TABLE IF EXISTS `BATTLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BATTLE` (
  `Battle_id` int NOT NULL AUTO_INCREMENT,
  `Player_id` int DEFAULT NULL,
  `Warrior_id` int DEFAULT NULL,
  `Warrior_Weapon_id` int DEFAULT NULL,
  `Opponent_id` int DEFAULT NULL,
  `Opponent_Weapon_id` int DEFAULT NULL,
  `Injuries_Caused` int DEFAULT NULL,
  `Injuries_Suffered` int DEFAULT NULL,
  `Battle_Points` int DEFAULT NULL,
  PRIMARY KEY (`Battle_id`),
  KEY `FK_PLAYER_BATTLE` (`Player_id`),
  KEY `FK_WARRIORS_BATTLE` (`Warrior_id`),
  KEY `FK_OPPONENT_BATTLE` (`Opponent_id`),
  KEY `FK_OPPONENTW_BATTLE` (`Opponent_Weapon_id`),
  KEY `FK_WEAPONS_BATTLE` (`Warrior_Weapon_id`),
  CONSTRAINT `FK_OPPONENT_BATTLE` FOREIGN KEY (`Opponent_id`) REFERENCES `WARRIORS` (`Warrior_id`),
  CONSTRAINT `FK_OPPONENTW_BATTLE` FOREIGN KEY (`Opponent_Weapon_id`) REFERENCES `WEAPONS` (`Weapon_id`),
  CONSTRAINT `FK_PLAYER_BATTLE` FOREIGN KEY (`Player_id`) REFERENCES `PLAYERS` (`Player_id`),
  CONSTRAINT `FK_WARRIORS_BATTLE` FOREIGN KEY (`Warrior_id`) REFERENCES `WARRIORS` (`Warrior_id`),
  CONSTRAINT `FK_WEAPONS_BATTLE` FOREIGN KEY (`Warrior_Weapon_id`) REFERENCES `WEAPONS` (`Weapon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PLAYERS`
--

DROP TABLE IF EXISTS `PLAYERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PLAYERS` (
  `Player_id` int NOT NULL AUTO_INCREMENT,
  `Player_name` varchar(45) DEFAULT NULL,
  `Total_Points` int DEFAULT NULL,
  PRIMARY KEY (`Player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ROUNDS`
--

DROP TABLE IF EXISTS `ROUNDS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ROUNDS` (
  `Round_id` int NOT NULL AUTO_INCREMENT,
  `Round_Number` int DEFAULT NULL,
  `Battle_id` int DEFAULT NULL,
  `Warrior_id` int DEFAULT NULL,
  `Warrior_Weapon_id` int DEFAULT NULL,
  `Opponent_id` int DEFAULT NULL,
  `Opponent_Weapon_id` int DEFAULT NULL,
  `Injuries_Caused` int DEFAULT NULL,
  `Injuries_Suffered` int DEFAULT NULL,
  PRIMARY KEY (`Round_id`),
  KEY `FK_BATTLE_ROUNDS` (`Battle_id`),
  CONSTRAINT `FK_BATTLE_ROUNDS` FOREIGN KEY (`Battle_id`) REFERENCES `BATTLE` (`Battle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=373 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `WARRIORS`
--

DROP TABLE IF EXISTS `WARRIORS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WARRIORS` (
  `Warrior_id` int NOT NULL AUTO_INCREMENT,
  `Warrior_name` varchar(45) DEFAULT NULL,
  `Warrior_Image_Path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Warrior_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `WEAPONS`
--

DROP TABLE IF EXISTS `WEAPONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WEAPONS` (
  `Weapon_id` int NOT NULL,
  `Weapon_name` varchar(30) DEFAULT NULL,
  `Weapon_Image_Path` varchar(100) DEFAULT NULL,
  `Speed` int DEFAULT NULL,
  `Strength` int DEFAULT NULL,
  `Points_value` int DEFAULT NULL,
  PRIMARY KEY (`Weapon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `WEAPONS_AVAILABLE`
--

DROP TABLE IF EXISTS `WEAPONS_AVAILABLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WEAPONS_AVAILABLE` (
  `Warrior_id` int DEFAULT NULL,
  `Weapon_id` int DEFAULT NULL,
  KEY `FK_WARRIORS_WEAPONS_AVAILABLE` (`Warrior_id`),
  KEY `FK_WEAPONS_WEAPONS_AVAILABLE` (`Weapon_id`),
  CONSTRAINT `FK_WARRIORS_WEAPONS_AVAILABLE` FOREIGN KEY (`Warrior_id`) REFERENCES `WARRIORS` (`Warrior_id`),
  CONSTRAINT `FK_WEAPONS_WEAPONS_AVAILABLE` FOREIGN KEY (`Weapon_id`) REFERENCES `WEAPONS` (`Weapon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-18 20:46:18
