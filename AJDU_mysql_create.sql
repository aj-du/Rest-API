CREATE TABLE `Role` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Role_Name` varchar(10) NOT NULL UNIQUE,
	PRIMARY KEY (`ID`)
);

INSERT INTO `Role` (`Role_Name`) VALUES ("ADMIN");
INSERT INTO `Role` (`Role_Name`) VALUES ("REG_USER");
INSERT INTO `Role` (`Role_Name`) VALUES ("ADD_USER");
INSERT INTO `Role` (`Role_Name`) VALUES ("ORG_USER");

CREATE TABLE `User` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`First_Name` varchar(20) NOT NULL,
	`Last_Name` varchar(40) NOT NULL,
	`Login` varchar(20) NOT NULL,
	`Password` varchar(40) NOT NULL,
	`Email` varchar(40) NOT NULL,
	`Role_ID` bigint NOT NULL DEFAULT '2',
	`Active` bool NOT NULL DEFAULT '0',
	`Date_Created` DATETIME NOT NULL,
	PRIMARY KEY (`ID`)
);


CREATE TABLE `Package` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Total_Cost` DECIMAL(10,2) NOT NULL DEFAULT '0',
	`Date_Created` DATETIME NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Service` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Name` varchar(50) NOT NULL,
	`Description` TEXT(30),
	`Category_ID` bigint NOT NULL,
	`Organization_ID` bigint NOT NULL,
	`Cost` DECIMAL(7,2) NOT NULL,
	`Distinction` bool NOT NULL DEFAULT '0',
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Package_Service` (
	`Package_ID` bigint NOT NULL,
	`Service_ID` bigint NOT NULL
);

CREATE TABLE `Package_User` (
	`User_ID` bigint NOT NULL,
	`Package_ID` bigint NOT NULL
);

CREATE TABLE `Organization` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Name` varchar(40) NOT NULL,
	`Category_ID` bigint NOT NULL,
	`Login` varchar(20) NOT NULL,
	`Password` varchar(40) NOT NULL,
	`Email` varchar(40) NOT NULL,
	`Active` bool NOT NULL DEFAULT '0',
	`Date_Created` DATETIME NOT NULL,
	`Address_ID` bigint NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Category` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Name` varchar(30) NOT NULL UNIQUE,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Address` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`City` varchar(50) NOT NULL,
	`Postal_Code` varchar(10) NOT NULL,
	`Country` varchar(20) NOT NULL,
	`Region` varchar(40) NOT NULL,
	`Line_1` varchar(40) NOT NULL,
	`Line_2` varchar(40) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Opinion` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Rate` int NOT NULL,
	`Content` TEXT NOT NULL,
	`Date` DATETIME NOT NULL,
	`Service_ID` bigint NOT NULL,
	`User_ID` bigint NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Schedule` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Task` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Name` varchar(40) NOT NULL,
	`Description` TEXT NOT NULL,
	`Due_Date` DATETIME NOT NULL,
	`Task_Status_ID` bigint NOT NULL,
	`Schedule_ID` bigint NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Task_Status` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Status` varchar(10) NOT NULL UNIQUE,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Schedule_User` (
	`User_ID` bigint NOT NULL,
	`Schedule_ID` bigint NOT NULL
);

CREATE TABLE `Blog` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Title` varchar(50) NOT NULL UNIQUE,
	`Description` TEXT NOT NULL,
	`Date_Created` DATETIME NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Blog_User` (
	`Blog_ID` bigint NOT NULL,
	`User_ID` bigint NOT NULL
);

CREATE TABLE `Post` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Title` varchar(50) NOT NULL,
	`Content` TEXT NOT NULL,
	`Date` DATETIME NOT NULL,
	`Blog_ID` bigint NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Comment` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Content` TEXT NOT NULL,
	`Date` DATETIME NOT NULL,
	`User_ID` bigint NOT NULL,
	`Post_ID` bigint NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Movie` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Title` varchar(40) NOT NULL,
	`File` longblob NOT NULL,
	`Service_ID` longblob NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Image` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Title` varchar(40) NOT NULL,
	`File` blob NOT NULL,
	`Service_ID` bigint NOT NULL,
	PRIMARY KEY (`ID`)
);

ALTER TABLE `User` ADD CONSTRAINT `User_fk0` FOREIGN KEY (`Role_ID`) REFERENCES `Role`(`ID`);

ALTER TABLE `Service` ADD CONSTRAINT `Service_fk0` FOREIGN KEY (`Category_ID`) REFERENCES `Category`(`ID`);

ALTER TABLE `Service` ADD CONSTRAINT `Service_fk1` FOREIGN KEY (`Organization_ID`) REFERENCES `Organization`(`ID`);

ALTER TABLE `Package_Service` ADD CONSTRAINT `Package_Service_fk0` FOREIGN KEY (`Package_ID`) REFERENCES `Package`(`ID`);

ALTER TABLE `Package_Service` ADD CONSTRAINT `Package_Service_fk1` FOREIGN KEY (`Service_ID`) REFERENCES `Service`(`ID`);

ALTER TABLE `Package_User` ADD CONSTRAINT `Package_User_fk0` FOREIGN KEY (`User_ID`) REFERENCES `User`(`ID`);

ALTER TABLE `Package_User` ADD CONSTRAINT `Package_User_fk1` FOREIGN KEY (`Package_ID`) REFERENCES `Package`(`ID`);

ALTER TABLE `Organization` ADD CONSTRAINT `Organization_fk0` FOREIGN KEY (`Category_ID`) REFERENCES `Category`(`ID`);

ALTER TABLE `Organization` ADD CONSTRAINT `Organization_fk1` FOREIGN KEY (`Address_ID`) REFERENCES `Address`(`ID`);

ALTER TABLE `Opinion` ADD CONSTRAINT `Opinion_fk0` FOREIGN KEY (`Service_ID`) REFERENCES `Service`(`ID`);

ALTER TABLE `Opinion` ADD CONSTRAINT `Opinion_fk1` FOREIGN KEY (`User_ID`) REFERENCES `User`(`ID`);

ALTER TABLE `Task` ADD CONSTRAINT `Task_fk0` FOREIGN KEY (`Task_Status_ID`) REFERENCES `Task_Status`(`ID`);

ALTER TABLE `Task` ADD CONSTRAINT `Task_fk1` FOREIGN KEY (`Schedule_ID`) REFERENCES `Schedule`(`ID`);

ALTER TABLE `Schedule_User` ADD CONSTRAINT `Schedule_User_fk0` FOREIGN KEY (`User_ID`) REFERENCES `User`(`ID`);

ALTER TABLE `Schedule_User` ADD CONSTRAINT `Schedule_User_fk1` FOREIGN KEY (`Schedule_ID`) REFERENCES `Schedule`(`ID`);

ALTER TABLE `Blog_User` ADD CONSTRAINT `Blog_User_fk0` FOREIGN KEY (`Blog_ID`) REFERENCES `Blog`(`ID`);

ALTER TABLE `Blog_User` ADD CONSTRAINT `Blog_User_fk1` FOREIGN KEY (`User_ID`) REFERENCES `User`(`ID`);

ALTER TABLE `Post` ADD CONSTRAINT `Post_fk0` FOREIGN KEY (`Blog_ID`) REFERENCES `Blog`(`ID`);

ALTER TABLE `Comment` ADD CONSTRAINT `Comment_fk0` FOREIGN KEY (`User_ID`) REFERENCES `User`(`ID`);

ALTER TABLE `Comment` ADD CONSTRAINT `Comment_fk1` FOREIGN KEY (`Post_ID`) REFERENCES `Post`(`ID`);

ALTER TABLE `Movie` ADD CONSTRAINT `Movie_fk0` FOREIGN KEY (`Service_ID`) REFERENCES `Service`(`ID`);

ALTER TABLE `Image` ADD CONSTRAINT `Image_fk0` FOREIGN KEY (`Service_ID`) REFERENCES `Service`(`ID`);

