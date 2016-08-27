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

CREATE TABLE IF NOT EXISTS `c4udatabase`.`profile` (
  `id`                          INT(11)       NOT NULL AUTO_INCREMENT,
  `surname`                     VARCHAR(45)   NOT NULL,
  `name`                        VARCHAR(45)   NOT NULL,
  `Patronymic`                  VARCHAR(45)   NULL      DEFAULT NULL,
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
  INDEX 'surname_idx' ('surname' ASC)
)
  ENGINE = InnoDB;
  DEFAULT CHARACTER SET = utf8;