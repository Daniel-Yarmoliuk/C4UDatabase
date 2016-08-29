SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `c4u_database`;
CREATE SCHEMA IF NOT EXISTS `c4u_database`
  DEFAULT CHARACTER SET utf8;
USE `c4u_database`;

-- -----------------------------------------------------
-- Table `c4u_database`.`profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `c4u_database`.`profile`;

CREATE TABLE IF NOT EXISTS `c4u_database`.`profile` (
  `id`                          INT(11)       NOT NULL AUTO_INCREMENT,
  `surname`                     VARCHAR(45)   NOT NULL,
  `name`                        VARCHAR(45)   NOT NULL,
  `patronymic`                  VARCHAR(45)   NULL      DEFAULT NULL,
  `date_of_birth`               DATE          NULL      DEFAULT NULL,
  `address`                     VARCHAR(200)  NULL      DEFAULT NULL,
  `phone`                       VARCHAR(45)   NULL      DEFAULT NULL,
  `index`                       VARCHAR(45)   NULL      DEFAULT NULL,
  `baptized_on_date`            DATE          NULL      DEFAULT NULL,
  `baptism_of_the_holy_spirit`  TINYINT(1)    NULL      DEFAULT NULL,
  `specialty`                   VARCHAR(45)   NULL      DEFAULT NULL,
  `from_another_church`         TINYINT(1)    NULL      DEFAULT NULL,
  `the_name_of_another_church`  VARCHAR(45)   NULL      DEFAULT NULL,
  `arrival_date`                DATE          NULL      DEFAULT NULL,
  `widow`                       TINYINT(1)    NULL      DEFAULT NULL,
  `divorced`                    TINYINT(1)    NULL      DEFAULT NULL,
  `disability_group`            TINYINT(1)    NULL      DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `surname1_idx` (`surname` ASC)
  )

  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

  -- -----------------------------------------------------
-- procedure addProfile
-- -----------------------------------------------------

USE `c4u_database`;
DROP PROCEDURE IF EXISTS `addProfile`;

DELIMITER $$
USE `c4u_database`$$
CREATE PROCEDURE `addProfile`(
aSurname                    VARCHAR(45),
aName                       VARCHAR(45),
aPatronymic                 VARCHAR(45),
aDateOfBirth                DATE,
anAddress                   VARCHAR(200),
aPhone                      VARCHAR(45),
anIndex                     VARCHAR(45),
aBaptizedOnDate             DATE,
aBaptismOfTheHolySpirit     INT,
aSpecialty                  VARCHAR(45),
aFromAnotherChurch          INT,
aTheNameOfAnotherChurch     VARCHAR(45),
anArrivalDate               DATE,
aWidow                      INT,
aDivorced                   INT,
aDisabilityGroup            INT
)
  BEGIN
    INSERT INTO profile (surname, name, patronymic, date_of_birth, address, phone, index, baptized_on_date,
    baptism_of_the_holy_spirit, specialty, from_another_church, the_name_of_another_church, arrival_date, widow,
    divorced, disability_group)
    VALUES (aSurname, aName, aPatronymic, aDateOfBirth, anAddress, aPhone, anIndex, aBaptizedOnDate,
    aBaptismOfTheHolySpirit, aSpecialty, aFromAnotherChurch, aTheNameOfAnotherChurch, anArrivalDate, aWidow,
    aDivorced, aDisabilityGroup);
    SELECT LAST_INSERT_ID();
  END$$

DELIMITER ;
