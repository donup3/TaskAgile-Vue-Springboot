DROP TABLE IF EXISTS `board`;
CREATE TABLE `board`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) DEFAULT NULL,
    `team_id`     BIGINT       DEFAULT NULL,
    `created_at`  DATETIME     NOT NULL,
    `updated_at`  DATETIME     DEFAULT NULL,
    `deleted_at`  DATETIME     DEFAULT NULL,
    `created_by`  BIGINT       DEFAULT NULL,
    `updated_by`  BIGINT       DEFAULT NULL,
    PRIMARY KEY (`id`)
);