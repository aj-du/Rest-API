ALTER TABLE `User` DROP FOREIGN KEY `User_fk0`;

ALTER TABLE `Service` DROP FOREIGN KEY `Service_fk0`;

ALTER TABLE `Service` DROP FOREIGN KEY `Service_fk1`;

ALTER TABLE `Package_Service` DROP FOREIGN KEY `Package_Service_fk0`;

ALTER TABLE `Package_Service` DROP FOREIGN KEY `Package_Service_fk1`;

ALTER TABLE `Package_User` DROP FOREIGN KEY `Package_User_fk0`;

ALTER TABLE `Package_User` DROP FOREIGN KEY `Package_User_fk1`;

ALTER TABLE `Organization` DROP FOREIGN KEY `Organization_fk0`;

ALTER TABLE `Organization` DROP FOREIGN KEY `Organization_fk1`;

ALTER TABLE `Opinion` DROP FOREIGN KEY `Opinion_fk0`;

ALTER TABLE `Opinion` DROP FOREIGN KEY `Opinion_fk1`;

ALTER TABLE `Task` DROP FOREIGN KEY `Task_fk0`;

ALTER TABLE `Task` DROP FOREIGN KEY `Task_fk1`;

ALTER TABLE `Schedule_User` DROP FOREIGN KEY `Schedule_User_fk0`;

ALTER TABLE `Schedule_User` DROP FOREIGN KEY `Schedule_User_fk1`;

ALTER TABLE `Blog_User` DROP FOREIGN KEY `Blog_User_fk0`;

ALTER TABLE `Blog_User` DROP FOREIGN KEY `Blog_User_fk1`;

ALTER TABLE `Post` DROP FOREIGN KEY `Post_fk0`;

ALTER TABLE `Comment` DROP FOREIGN KEY `Comment_fk0`;

ALTER TABLE `Comment` DROP FOREIGN KEY `Comment_fk1`;

ALTER TABLE `Movie` DROP FOREIGN KEY `Movie_fk0`;

ALTER TABLE `Image` DROP FOREIGN KEY `Image_fk0`;

DROP TABLE IF EXISTS `User`;

DROP TABLE IF EXISTS `Role`;

DROP TABLE IF EXISTS `Package`;

DROP TABLE IF EXISTS `Service`;

DROP TABLE IF EXISTS `Package_Service`;

DROP TABLE IF EXISTS `Package_User`;

DROP TABLE IF EXISTS `Organization`;

DROP TABLE IF EXISTS `Category`;

DROP TABLE IF EXISTS `Address`;

DROP TABLE IF EXISTS `Opinion`;

DROP TABLE IF EXISTS `Schedule`;

DROP TABLE IF EXISTS `Task`;

DROP TABLE IF EXISTS `Task_Status`;

DROP TABLE IF EXISTS `Schedule_User`;

DROP TABLE IF EXISTS `Blog`;

DROP TABLE IF EXISTS `Blog_User`;

DROP TABLE IF EXISTS `Post`;

DROP TABLE IF EXISTS `Comment`;

DROP TABLE IF EXISTS `Movie`;

DROP TABLE IF EXISTS `Image`;

