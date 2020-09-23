-- ----------------------------
-- Table structure for delivery_card
-- ----------------------------
CREATE TABLE `delivery_card`  (
  `id`           bigint      NOT NULL auto_increment    comment '主键',
  `card_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '卡编号',
  `card_password` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL  COMMENT '卡密码',
  `card_shop` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL  COMMENT '卡对应的商品',
  `start_time` 	    datetime                                   comment '开始时间',
  `end_time` 	    datetime                                   comment '结束时间',
  `card_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '卡状态',
  `user_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `qr_link` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '二维码链接',
  `remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `del_flag`          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  `create_by`         varchar(64)     default ''                 comment '创建者',
  `create_time` 	    datetime                                   comment '创建时间',
  `update_by`         varchar(64)     default ''                 comment '更新者',
  `update_time`       datetime                                   comment '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '卡劵表' ROW_FORMAT = Dynamic;