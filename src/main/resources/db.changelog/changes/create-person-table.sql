--liquibase formatted sql
--changeset amakovskyy:create-person-table splitStatements:true endDelimiter:;
CREATE TABLE `persons` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `age` int DEFAULT NULL,
                           `last_name` varchar(255) DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `test`.`persons` (`age`, `last_name`, `name`) VALUES ('25', 'Pupkins', 'Ivan');

--rollback DROP TABLE persons;