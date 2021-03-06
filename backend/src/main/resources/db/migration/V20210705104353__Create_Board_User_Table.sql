DROP TABLE IF EXISTS `board_user`;
CREATE TABLE `board_user`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `board_id`    BIGINT       NOT NULL,
    `user_id`     BIGINT       NOT NULL,
    `created_at`  DATETIME     NOT NULL,
    `updated_at`  DATETIME DEFAULT NULL,
    `deleted_at`  DATETIME DEFAULT NULL,
    `created_by`  BIGINT   DEFAULT NULL,
    `updated_by`  BIGINT   DEFAULT NULL,
    PRIMARY KEY (`id`)
);