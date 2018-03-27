CREATE DATABASE  IF NOT EXISTS `useradmin`;


USE `useradmin`;


DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `users`;


CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `orders`(
`orderid` int(11) NOT NULL AUTO_INCREMENT,
`height` int(11) NOT NULL,
`length` int(11) NOT NULL,
`width` int(11) NOT NULL,
`status` varchar(11) NOT NULL,
`id` int(11) NOT NULL,
Primary key(`orderid`),
Foreign key(`id`) references users(`id`));


LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES 
(1,'jens@somewhere.com','jensen','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','employee'),
(4,'123','123','customer'),
(5,'456','456','employee');
UNLOCK TABLES;