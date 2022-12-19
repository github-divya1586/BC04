/*
SQLyog Community v8.71 
MySQL - 5.5.30 : Database - bc04-2022
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bc04-2022` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bc04-2022`;

/*Table structure for table `fileupload` */

DROP TABLE IF EXISTS `fileupload`;

CREATE TABLE `fileupload` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `domain` varchar(100) DEFAULT NULL,
  `fileName` varchar(1000) DEFAULT NULL,
  `hashValue` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `fileupload` */

insert  into `fileupload`(`fileId`,`userId`,`domain`,`fileName`,`hashValue`) values (3,1,'Cloud Computing','test','m9UgbWHobnKKQBxWTFTIvbMrg8jB55,qlIUI4P6T1+HD8DXnGJkTJ9TyxHJm7fv5MfzDDBzO4A=');

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `emailid` varchar(100) DEFAULT NULL,
  `password` varchar(1000) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `register` */

insert  into `register`(`userid`,`username`,`emailid`,`password`,`mobile`) values (1,'shyam','shyam.9989@gmail.com','123456','987656767'),(2,'shyam','shyampilli@hotmail.com','123456','987656767'),(3,'shyam','sh@gmail.com','123456','9876567678'),(4,'shyam','shyam@gmail.com','123456','9876567656');

/*Table structure for table `statustable` */

DROP TABLE IF EXISTS `statustable`;

CREATE TABLE `statustable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Sqlinject` int(2) DEFAULT NULL,
  `DDos` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `statustable` */

insert  into `statustable`(`id`,`Sqlinject`,`DDos`) values (1,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
