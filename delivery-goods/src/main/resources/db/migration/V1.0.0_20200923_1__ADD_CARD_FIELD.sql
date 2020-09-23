ALTER TABLE `delivery_card` ADD COLUMN `qr_link` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '二维码链接' AFTER `address`;
