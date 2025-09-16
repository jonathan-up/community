/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql8
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : community-377

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 12/09/2025 16:42:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for con_building
-- ----------------------------
DROP TABLE IF EXISTS `con_building`;
CREATE TABLE `con_building`
(
    `id`        int(0)                                                 NOT NULL AUTO_INCREMENT,
    `buildname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `villageid` int(0)                                                 NULL DEFAULT NULL,
    `period`    varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `lift`      tinyint(0)                                             NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 29
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_building
-- ----------------------------
INSERT INTO `con_building`
VALUES (1, 'A栋1单元', 1, '2016', 0);
INSERT INTO `con_building`
VALUES (2, 'B栋1单元', 1, '2004', 0);
INSERT INTO `con_building`
VALUES (3, 'C栋1单元', 1, '2018', 1);
INSERT INTO `con_building`
VALUES (4, 'D栋1单元', 1, '2022', 1);
INSERT INTO `con_building`
VALUES (5, 'A栋2单元', 2, '2010', 0);
INSERT INTO `con_building`
VALUES (6, 'B栋2单元', 2, '2018', 1);
INSERT INTO `con_building`
VALUES (7, 'C栋2单元', 2, '2024', 1);
INSERT INTO `con_building`
VALUES (8, 'D栋2单元', 2, '2020', 1);
INSERT INTO `con_building`
VALUES (9, 'A栋4单元', 4, '2014', 1);
INSERT INTO `con_building`
VALUES (10, 'B栋4单元', 4, '2015', 0);
INSERT INTO `con_building`
VALUES (11, 'C栋4单元', 4, '2008', 0);
INSERT INTO `con_building`
VALUES (12, 'D栋4单元', 4, '2016', 1);
INSERT INTO `con_building`
VALUES (14, 'A栋3单元', 3, '2018', 1);
INSERT INTO `con_building`
VALUES (18, 'B栋6单元', 5, '2024', 1);
INSERT INTO `con_building`
VALUES (20, 'A栋8单元', 5, '2022', 1);
INSERT INTO `con_building`
VALUES (26, 'B栋3单元', 3, '2010', 0);
INSERT INTO `con_building`
VALUES (27, 'E栋4单元', 4, '2010', 0);
INSERT INTO `con_building`
VALUES (28, 'A栋一单元', 12, '2020', 0);

-- ----------------------------
-- Table structure for con_device
-- ----------------------------
DROP TABLE IF EXISTS `con_device`;
CREATE TABLE `con_device`
(
    `id`     int(0)                                                 NOT NULL AUTO_INCREMENT,
    `code`   varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `type`   varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `bid`    int(0)                                                 NULL DEFAULT NULL,
    `vid`    int(0)                                                 NULL DEFAULT NULL,
    `status` int(0)                                                 NULL DEFAULT NULL,
    `name`   varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `mode`   varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_device
-- ----------------------------
INSERT INTO `con_device`
VALUES (1, 'F20A0138', '人脸机', 0, 1, 1, '大门人脸机', '延时模式');
INSERT INTO `con_device`
VALUES (2, 'FS0A0255', '门禁机', 0, 1, 1, '单元门门禁机', '延时模式');
INSERT INTO `con_device`
VALUES (3, 'F20A0179', '刷卡机', 9, 4, 1, '单元楼刷卡机', '延时模式');
INSERT INTO `con_device`
VALUES (4, 'F20A0921', '刷卡机', 9, 0, 1, '单元楼刷卡机', '延时模式');

-- ----------------------------
-- Table structure for con_house
-- ----------------------------
DROP TABLE IF EXISTS `con_house`;
CREATE TABLE `con_house`
(
    `id`        int(0)                                                 NOT NULL AUTO_INCREMENT,
    `buildid`   int(0)                                                 NULL DEFAULT NULL,
    `houseno`   varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `housename` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `area`      double                                                 NULL DEFAULT NULL,
    `layer`     int(0)                                                 NULL DEFAULT NULL,
    `toward`    varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `type`      varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `useage`    varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `fitment`   varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `person`    varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `perphone`  varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_house
-- ----------------------------
INSERT INTO `con_house`
VALUES (1, 1, '1108', '人文旅社', 180.1, 2, '朝南', '两房一厅', '自住', '毛坯', '张三', '13597361028');
INSERT INTO `con_house`
VALUES (2, 2, '1208', '芙蓉小舍', 136.5, 3, '朝北', '三房一厅', '租赁', '精装', '李四', '15964313250');
INSERT INTO `con_house`
VALUES (3, 20, '888', '飞升旅舍', 210, 5, '朝北', '四房两厅', '自住', '精装', '飞升管理员', '18899990000');
INSERT INTO `con_house`
VALUES (4, 27, '0731', '鉴宝直播间', 220, 7, '朝东', '三房两厅', '租赁', '精装', '听泉鉴宝', '18386818280');
INSERT INTO `con_house`
VALUES (5, 6, '2319', '文明寝室', 120, 3, '朝北', '一房一厅', '租赁', '毛坯', '文明', '15954185418');
INSERT INTO `con_house`
VALUES (6, 14, '1015', '青年旅舍', 300, 10, '朝东', '一房四铺', '租赁', '精装', '租客1', '15801661817');
INSERT INTO `con_house`
VALUES (7, 10, '0731', '明泉小屋', 100, 3, '朝北', '四方一人听', '租赁', '精装', '明泉', '11111111111');

-- ----------------------------
-- Table structure for con_household
-- ----------------------------
DROP TABLE IF EXISTS `con_household`;
CREATE TABLE `con_household`
(
    `id`         int(0)                                                 NOT NULL AUTO_INCREMENT,
    `name`       varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `phone`      varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `gender`     int(0)                                                 NULL DEFAULT NULL,
    `cardtype`   varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `cardno`     varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `birth`      date                                                   NULL DEFAULT NULL,
    `holdtype`   varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `cardnumber` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `other`      varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `houseid`    int(0)                                                 NULL DEFAULT NULL,
    `img`        varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_household
-- ----------------------------
INSERT INTO `con_household`
VALUES (1, '张三', '13580132018', 1, '身份证', '250019198001245410', '1980-01-24', '业主', '1065893102', '', 1,
        'http://www.img.community.com/509dd1e09e984a1ea086c9c9fd33340c.jpg');
INSERT INTO `con_household`
VALUES (2, '测试', '11111111111', 1, '身份证', '511720200301233601', '2024-10-19', '业主', '1035650120', '无', 2,
        'http://www.img.community.com/cab09e6767a240669c1d9cefbfa094ed.jpg');
INSERT INTO `con_household`
VALUES (3, '听泉赏宝', '10001013020', 2, '身份证', '511010200202022002', '2024-10-21', '业主', '1036942057', '', 4,
        'http://www.img.community.com/tqshangbao.jpg');
INSERT INTO `con_household`
VALUES (7, '云生', '18858185418', 1, '身份证', '511719198710210741', '1987-10-21', '业主', '1039508102', '', 2,
        'http://www.img.community.com/8cd265a3f7b4c9c2fe3d85180885c2a0.png');
INSERT INTO `con_household`
VALUES (8, '文明', '15954185418', 1, '身份证', '511723200301015418', '2003-01-01', '业主', '1036181452', '', 5,
        'http://www.img.community.com/6cc61a546e7b4837b50a110e77f66715.png');
INSERT INTO `con_household`
VALUES (9, '租客1', '15801661817', 1, '身份证', '511719199310240214', '1993-10-24', '业主', '1065150731', '', 6,
        'http://www.img.community.com/8cd265a3f7b4c9c2fe3d85180885c2a0.png');
INSERT INTO `con_household`
VALUES (10, '彭书杭', '13458190473', 1, '身份证', '511723200202020202', '2003-10-25', '业主', '1050362010', '无', 2,
        'http://www.img.community.com/8cd265a3f7b4c9c2fe3d85180885c2a0.png');
INSERT INTO `con_household`
VALUES (11, '租客1', '15801661817', 1, '身份证', '111111111', '2024-10-20', '业主', '11', 'wu ', 3,
        'http://www.img.community.com/ab255d0cd015463ab1c88fd7ed90ef4b.png');
INSERT INTO `con_household`
VALUES (12, '彭书杭', '13458190473', 1, '身份证', '1111', '2024-10-27', '业主', '11', 'wuy ', 6,
        'http://www.img.community.com/f837c405af4542aabf9ec8a360dffd0f.jpg');

-- ----------------------------
-- Table structure for con_menu
-- ----------------------------
DROP TABLE IF EXISTS `con_menu`;
CREATE TABLE `con_menu`
(
    `id`       int(0)                                                 NOT NULL AUTO_INCREMENT,
    `title`    varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `icon`     varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `type`     int(0)                                                 NULL DEFAULT NULL,
    `href`     varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `pid`      int(0)                                                 NULL DEFAULT NULL,
    `openType` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1062
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_menu
-- ----------------------------
INSERT INTO `con_menu`
VALUES (1, '首页', 'layui-icon layui-icon-console', 0, NULL, 0, NULL);
INSERT INTO `con_menu`
VALUES (2, '系统管理', 'layui-icon layui-icon-set-fill', 0, NULL, 0, NULL);
INSERT INTO `con_menu`
VALUES (3, '小区管理', 'layui-icon layui-icon-user', 0, NULL, 0, NULL);
INSERT INTO `con_menu`
VALUES (4, '人员管理', 'layui-icon layui-icon-user', 0, '', 0, NULL);
INSERT INTO `con_menu`
VALUES (5, '设备管理', 'layui-icon layui-icon-rmb', 0, '', 0, NULL);
INSERT INTO `con_menu`
VALUES (6, 'echarts图表', 'layui-icon layui-icon-release', 0, '', 0, NULL);
INSERT INTO `con_menu`
VALUES (10, '首页', 'layui-icon layui-icon-console', 1, 'view/console/console1.html', 1, '_iframe');
INSERT INTO `con_menu`
VALUES (100, '小区管理', 'layui-icon layui-icon-face-smile', 1, 'view/village/village.html', 3, '_iframe');
INSERT INTO `con_menu`
VALUES (200, '设备管理', 'layui-icon layui-icon-face-smile', 1, 'view/money/money.html', 5, '_iframe');
INSERT INTO `con_menu`
VALUES (500, '人员管理', 'layui-icon layui-icon-face-smile', 1, 'view/household/household.html', 4, '_iframe');
INSERT INTO `con_menu`
VALUES (601, '用户管理', 'layui-icon layui-icon-face-smile', 1, 'view/system/user.html', 2, '_iframe');
INSERT INTO `con_menu`
VALUES (602, '角色管理', 'layui-icon layui-icon-face-cry', 1, 'view/role/role.html', 2, '_iframe');
INSERT INTO `con_menu`
VALUES (603, '权限管理', 'layui-icon layui-icon-face-cry', 1, 'view/privilege/privilege.html', 2, '_iframe');
INSERT INTO `con_menu`
VALUES (605, '操作日志', 'layui-icon layui-icon-face-cry', 1, 'view/system/logging.html', 2, '_iframe');
INSERT INTO `con_menu`
VALUES (1001, '用户查询', NULL, 2, '/user/query', 601, NULL);
INSERT INTO `con_menu`
VALUES (1002, '用户增加', NULL, 2, '/user/add', 601, NULL);
INSERT INTO `con_menu`
VALUES (1003, '用户删除', NULL, 2, '/user/delete', 601, NULL);
INSERT INTO `con_menu`
VALUES (1004, '用户修改', NULL, 2, '/user/update', 601, NULL);
INSERT INTO `con_menu`
VALUES (1005, '用户id查询', NULL, 2, '/user/find', 601, NULL);
INSERT INTO `con_menu`
VALUES (1006, '用户批量删除', NULL, 2, '/user/deleteByIds', 601, NULL);
INSERT INTO `con_menu`
VALUES (1007, '小区查询', NULL, 2, '/village/query', 100, '');
INSERT INTO `con_menu`
VALUES (1008, '小区增加', NULL, 2, '/village/add', 100, NULL);
INSERT INTO `con_menu`
VALUES (1009, '小区修改', NULL, 2, '/village/update', 100, NULL);
INSERT INTO `con_menu`
VALUES (1010, '小区id查询', NULL, 2, '/village/find', 100, NULL);
INSERT INTO `con_menu`
VALUES (1011, '小区删除', NULL, 2, '/village/delete', 100, NULL);
INSERT INTO `con_menu`
VALUES (1012, '小区批量删除', NULL, 2, '/village/deleteByIds', 100, NULL);
INSERT INTO `con_menu`
VALUES (1013, '角色查询', NULL, 2, '/role/query', 602, NULL);
INSERT INTO `con_menu`
VALUES (1014, '角色授权', NULL, 2, '/role/assign', 602, NULL);
INSERT INTO `con_menu`
VALUES (1015, '楼栋资料', 'layui-icon layui-icon-face-smile', 1, 'view/customer/building.html', 3, '_iframe');
INSERT INTO `con_menu`
VALUES (1016, '楼栋查询', NULL, 2, '/build/list', 1015, NULL);
INSERT INTO `con_menu`
VALUES (1017, '房屋资料', 'layui-icon layui-icon-face-smile', 1, 'view/customer/house.html', 3, '_iframe');
INSERT INTO `con_menu`
VALUES (1018, '楼栋增加', NULL, 2, '/build/add', 1015, NULL);
INSERT INTO `con_menu`
VALUES (1019, '楼栋id查询', NULL, 2, '/build/find', 1015, NULL);
INSERT INTO `con_menu`
VALUES (1020, '楼栋修改', NULL, 2, '/build/update', 1015, NULL);
INSERT INTO `con_menu`
VALUES (1021, '楼栋删除', NULL, 2, '/build/delete', 1015, NULL);
INSERT INTO `con_menu`
VALUES (1022, '楼栋批量删除', NULL, 2, '/build/deleteByIds', 1015, NULL);
INSERT INTO `con_menu`
VALUES (1023, '房屋查询', NULL, 2, '/house/list', 1017, NULL);
INSERT INTO `con_menu`
VALUES (1024, '房屋id查询', NULL, 2, '/house/find', 1017, NULL);
INSERT INTO `con_menu`
VALUES (1025, '房屋修改', NULL, 2, '/house/update', 1017, NULL);
INSERT INTO `con_menu`
VALUES (1026, '房屋删除', NULL, 2, '/house/delete', 1017, NULL);
INSERT INTO `con_menu`
VALUES (1027, '房屋批量删除', NULL, 2, '/house/deleteByIds', 1017, NULL);
INSERT INTO `con_menu`
VALUES (1028, '柱状图', 'layui-icon layui-icon-face-smile', 1, 'view\\echarts\\column1.html', 6, '_iframe');
INSERT INTO `con_menu`
VALUES (1032, '折线图', 'layui-icon layui-icon-face-smile', 1, 'view\\echarts\\line1.html', 6, '_iframe');
INSERT INTO `con_menu`
VALUES (1033, '权限增加', NULL, 2, '/menu/add', 603, NULL);
INSERT INTO `con_menu`
VALUES (1034, '权限修改', NULL, 2, '/menu/update', 603, NULL);
INSERT INTO `con_menu`
VALUES (1035, '权限id查询', NULL, 2, '/menu/find', 603, NULL);
INSERT INTO `con_menu`
VALUES (1036, '权限查询', NULL, 2, '/menu/queryAll', 603, NULL);
INSERT INTO `con_menu`
VALUES (1037, '权限删除', NULL, 2, '/menu/delete', 603, NULL);
INSERT INTO `con_menu`
VALUES (1038, '资料查询', NULL, 2, '/household/list', 500, NULL);
INSERT INTO `con_menu`
VALUES (1039, '资料id查询', NULL, 2, '/household/find', 500, NULL);
INSERT INTO `con_menu`
VALUES (1040, '资料增加', NULL, 2, '/household/add', 500, NULL);
INSERT INTO `con_menu`
VALUES (1041, '资料修改', NULL, 2, '/household/update', 500, NULL);
INSERT INTO `con_menu`
VALUES (1042, '小区名字查询', NULL, 2, '/village/queryOnlyName', 100, NULL);
INSERT INTO `con_menu`
VALUES (1043, '人员删除', NULL, 2, '/household/delete', 500, NULL);
INSERT INTO `con_menu`
VALUES (1044, '人员批量删除', NULL, 2, '/household/deleteByIds', 500, NULL);
INSERT INTO `con_menu`
VALUES (1045, '楼栋名字查询', NULL, 2, '/build/queryByvid', 1015, NULL);
INSERT INTO `con_menu`
VALUES (1046, '房屋增加', NULL, 2, '/house/add', 1017, NULL);
INSERT INTO `con_menu`
VALUES (1047, '房屋名字查询', NULL, 2, '/house/queryByBid', 1017, NULL);
INSERT INTO `con_menu`
VALUES (1048, '设备查询', NULL, 2, '/device/list', 200, NULL);
INSERT INTO `con_menu`
VALUES (1049, '设备增加', NULL, 2, '/device/add', 200, NULL);
INSERT INTO `con_menu`
VALUES (1050, '设备id查询', NULL, 2, '/device/find', 200, NULL);
INSERT INTO `con_menu`
VALUES (1051, '设备修改', NULL, 2, '/device/update', 200, NULL);
INSERT INTO `con_menu`
VALUES (1052, '设备删除', NULL, 2, '/device/delete', 200, NULL);
INSERT INTO `con_menu`
VALUES (1053, '设备批量删除', NULL, 2, '/device/deleteByIds', 200, NULL);
INSERT INTO `con_menu`
VALUES (1054, '角色权限查询', NULL, 2, '/role/queryByUid', 602, NULL);
INSERT INTO `con_menu`
VALUES (1055, '角色id查询', NULL, 2, '/role/find', 602, NULL);
INSERT INTO `con_menu`
VALUES (1056, '角色增加', NULL, 2, '/role/add', 602, NULL);
INSERT INTO `con_menu`
VALUES (1057, '角色修改', NULL, 2, '/role/update', 602, NULL);
INSERT INTO `con_menu`
VALUES (1058, '角色删除', NULL, 2, '/role/delete', 602, NULL);
INSERT INTO `con_menu`
VALUES (1059, '角色批量删除', NULL, 2, '/role/deleteByIds', 602, NULL);
INSERT INTO `con_menu`
VALUES (1060, '设备开门', NULL, 2, '/device/updateStatus', 200, NULL);
INSERT INTO `con_menu`
VALUES (1061, '查看柱状图', NULL, 2, '/echarts/columnList', 1028, NULL);

-- ----------------------------
-- Table structure for con_resource
-- ----------------------------
DROP TABLE IF EXISTS `con_resource`;
CREATE TABLE `con_resource`
(
    `id`   int(0)                                                 NOT NULL AUTO_INCREMENT,
    `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `uri`  varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_resource
-- ----------------------------
INSERT INTO `con_resource`
VALUES (1, '用户查询', '/user/query');
INSERT INTO `con_resource`
VALUES (2, '用户增加', '/user/add');
INSERT INTO `con_resource`
VALUES (3, '用户修改', '/user/update');
INSERT INTO `con_resource`
VALUES (4, '用户删除', '/user/delete');
INSERT INTO `con_resource`
VALUES (5, '用户批量删除', '/user/deleteByIds');
INSERT INTO `con_resource`
VALUES (6, '小区查询', '/village/query');
INSERT INTO `con_resource`
VALUES (7, '小区增加', '/village/add');
INSERT INTO `con_resource`
VALUES (8, '小区修改', '/village/update');
INSERT INTO `con_resource`
VALUES (9, '小区删除', '/village/delete');
INSERT INTO `con_resource`
VALUES (10, '小区批量删除', '/village/deleteByIds');
INSERT INTO `con_resource`
VALUES (11, '用户查询id', '/user/find');
INSERT INTO `con_resource`
VALUES (12, '小区查询id', '/village/find');

-- ----------------------------
-- Table structure for con_role
-- ----------------------------
DROP TABLE IF EXISTS `con_role`;
CREATE TABLE `con_role`
(
    `id`          int(0)                                                 NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `status`      int(0)                                                 NULL DEFAULT 1,
    `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_role
-- ----------------------------
INSERT INTO `con_role`
VALUES (1, '超级管理员', 1, '具备所有的功能');
INSERT INTO `con_role`
VALUES (2, '普通管理员', 1, '具备查询和增加功能');
INSERT INTO `con_role`
VALUES (3, '普通用户', 1, '具备查询功能');
INSERT INTO `con_role`
VALUES (4, '特批修改员', 1, '具备查询和修改功能');
INSERT INTO `con_role`
VALUES (5, '删除员', 1, '具备查询和删除功能');
INSERT INTO `con_role`
VALUES (6, '角色测试', 1, '测试');
INSERT INTO `con_role`
VALUES (7, 'test角色', 1, '测试');

-- ----------------------------
-- Table structure for con_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `con_role_menu`;
CREATE TABLE `con_role_menu`
(
    `id`      int(0) NOT NULL AUTO_INCREMENT,
    `rid`     int(0) NULL DEFAULT NULL,
    `mid`     int(0) NULL DEFAULT NULL,
    `created` date   NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 126
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_role_menu
-- ----------------------------
INSERT INTO `con_role_menu`
VALUES (1, 2, 1, NULL);
INSERT INTO `con_role_menu`
VALUES (2, 2, 10, NULL);
INSERT INTO `con_role_menu`
VALUES (3, 2, 2, NULL);
INSERT INTO `con_role_menu`
VALUES (5, 2, 602, NULL);
INSERT INTO `con_role_menu`
VALUES (6, 2, 3, NULL);
INSERT INTO `con_role_menu`
VALUES (7, 2, 100, NULL);
INSERT INTO `con_role_menu`
VALUES (12, 2, 1007, NULL);
INSERT INTO `con_role_menu`
VALUES (13, 3, 1, NULL);
INSERT INTO `con_role_menu`
VALUES (14, 3, 10, NULL);
INSERT INTO `con_role_menu`
VALUES (15, 3, 3, NULL);
INSERT INTO `con_role_menu`
VALUES (16, 3, 100, NULL);
INSERT INTO `con_role_menu`
VALUES (22, 2, 1008, NULL);
INSERT INTO `con_role_menu`
VALUES (23, 3, 1007, NULL);
INSERT INTO `con_role_menu`
VALUES (26, 2, 1013, NULL);
INSERT INTO `con_role_menu`
VALUES (28, 4, 1, NULL);
INSERT INTO `con_role_menu`
VALUES (29, 4, 10, NULL);
INSERT INTO `con_role_menu`
VALUES (30, 4, 2, NULL);
INSERT INTO `con_role_menu`
VALUES (31, 4, 601, NULL);
INSERT INTO `con_role_menu`
VALUES (32, 4, 1001, NULL);
INSERT INTO `con_role_menu`
VALUES (33, 4, 1004, NULL);
INSERT INTO `con_role_menu`
VALUES (34, 4, 3, NULL);
INSERT INTO `con_role_menu`
VALUES (35, 4, 100, NULL);
INSERT INTO `con_role_menu`
VALUES (36, 4, 1007, NULL);
INSERT INTO `con_role_menu`
VALUES (37, 4, 1009, NULL);
INSERT INTO `con_role_menu`
VALUES (38, 2, 1015, NULL);
INSERT INTO `con_role_menu`
VALUES (39, 2, 1016, NULL);
INSERT INTO `con_role_menu`
VALUES (40, 4, 1015, NULL);
INSERT INTO `con_role_menu`
VALUES (41, 4, 1016, NULL);
INSERT INTO `con_role_menu`
VALUES (42, 4, 1020, NULL);
INSERT INTO `con_role_menu`
VALUES (43, 4, 1017, NULL);
INSERT INTO `con_role_menu`
VALUES (44, 4, 1023, NULL);
INSERT INTO `con_role_menu`
VALUES (46, 3, 1015, NULL);
INSERT INTO `con_role_menu`
VALUES (47, 3, 1016, NULL);
INSERT INTO `con_role_menu`
VALUES (48, 3, 1017, NULL);
INSERT INTO `con_role_menu`
VALUES (49, 3, 1023, NULL);
INSERT INTO `con_role_menu`
VALUES (50, 3, 4, NULL);
INSERT INTO `con_role_menu`
VALUES (51, 3, 500, NULL);
INSERT INTO `con_role_menu`
VALUES (52, 3, 1038, NULL);
INSERT INTO `con_role_menu`
VALUES (53, 3, 6, NULL);
INSERT INTO `con_role_menu`
VALUES (54, 3, 1028, NULL);
INSERT INTO `con_role_menu`
VALUES (55, 3, 1032, NULL);
INSERT INTO `con_role_menu`
VALUES (59, 4, 4, NULL);
INSERT INTO `con_role_menu`
VALUES (60, 4, 500, NULL);
INSERT INTO `con_role_menu`
VALUES (61, 4, 1038, NULL);
INSERT INTO `con_role_menu`
VALUES (62, 4, 1041, NULL);
INSERT INTO `con_role_menu`
VALUES (63, 4, 5, NULL);
INSERT INTO `con_role_menu`
VALUES (64, 4, 1028, NULL);
INSERT INTO `con_role_menu`
VALUES (65, 4, 1032, NULL);
INSERT INTO `con_role_menu`
VALUES (66, 2, 1018, NULL);
INSERT INTO `con_role_menu`
VALUES (67, 2, 1017, NULL);
INSERT INTO `con_role_menu`
VALUES (68, 2, 1023, NULL);
INSERT INTO `con_role_menu`
VALUES (69, 2, 4, NULL);
INSERT INTO `con_role_menu`
VALUES (70, 2, 500, NULL);
INSERT INTO `con_role_menu`
VALUES (71, 2, 1038, NULL);
INSERT INTO `con_role_menu`
VALUES (72, 2, 1040, NULL);
INSERT INTO `con_role_menu`
VALUES (73, 2, 6, NULL);
INSERT INTO `con_role_menu`
VALUES (74, 2, 1028, NULL);
INSERT INTO `con_role_menu`
VALUES (75, 2, 1032, NULL);
INSERT INTO `con_role_menu`
VALUES (77, 2, 601, NULL);
INSERT INTO `con_role_menu`
VALUES (78, 2, 1001, NULL);
INSERT INTO `con_role_menu`
VALUES (79, 2, 1002, NULL);
INSERT INTO `con_role_menu`
VALUES (80, 2, 1046, NULL);
INSERT INTO `con_role_menu`
VALUES (81, 2, 5, NULL);
INSERT INTO `con_role_menu`
VALUES (82, 2, 200, NULL);
INSERT INTO `con_role_menu`
VALUES (83, 2, 1048, NULL);
INSERT INTO `con_role_menu`
VALUES (84, 2, 1049, NULL);
INSERT INTO `con_role_menu`
VALUES (85, 4, 1005, NULL);
INSERT INTO `con_role_menu`
VALUES (86, 4, 1010, NULL);
INSERT INTO `con_role_menu`
VALUES (87, 4, 1019, NULL);
INSERT INTO `con_role_menu`
VALUES (88, 4, 1024, NULL);
INSERT INTO `con_role_menu`
VALUES (89, 4, 1039, NULL);
INSERT INTO `con_role_menu`
VALUES (90, 4, 6, NULL);
INSERT INTO `con_role_menu`
VALUES (91, 4, 200, NULL);
INSERT INTO `con_role_menu`
VALUES (92, 4, 1048, NULL);
INSERT INTO `con_role_menu`
VALUES (93, 4, 1050, NULL);
INSERT INTO `con_role_menu`
VALUES (94, 4, 1051, NULL);
INSERT INTO `con_role_menu`
VALUES (95, 2, 1042, NULL);
INSERT INTO `con_role_menu`
VALUES (96, 2, 1045, NULL);
INSERT INTO `con_role_menu`
VALUES (97, 2, 1047, NULL);
INSERT INTO `con_role_menu`
VALUES (98, 4, 1042, NULL);
INSERT INTO `con_role_menu`
VALUES (99, 4, 1045, NULL);
INSERT INTO `con_role_menu`
VALUES (100, 4, 1047, NULL);
INSERT INTO `con_role_menu`
VALUES (101, 2, 1060, NULL);
INSERT INTO `con_role_menu`
VALUES (102, 4, 1025, NULL);
INSERT INTO `con_role_menu`
VALUES (103, 2, 1061, NULL);
INSERT INTO `con_role_menu`
VALUES (104, 3, 1061, NULL);
INSERT INTO `con_role_menu`
VALUES (105, 4, 1061, NULL);
INSERT INTO `con_role_menu`
VALUES (107, 3, 1045, NULL);
INSERT INTO `con_role_menu`
VALUES (108, 5, 1, NULL);
INSERT INTO `con_role_menu`
VALUES (109, 5, 10, NULL);
INSERT INTO `con_role_menu`
VALUES (110, 5, 2, NULL);
INSERT INTO `con_role_menu`
VALUES (111, 5, 601, NULL);
INSERT INTO `con_role_menu`
VALUES (112, 5, 1001, NULL);
INSERT INTO `con_role_menu`
VALUES (113, 5, 1003, NULL);
INSERT INTO `con_role_menu`
VALUES (114, 5, 1006, NULL);
INSERT INTO `con_role_menu`
VALUES (115, 5, 3, NULL);
INSERT INTO `con_role_menu`
VALUES (116, 5, 100, NULL);
INSERT INTO `con_role_menu`
VALUES (117, 5, 1007, NULL);
INSERT INTO `con_role_menu`
VALUES (118, 5, 1011, NULL);
INSERT INTO `con_role_menu`
VALUES (119, 5, 1012, NULL);
INSERT INTO `con_role_menu`
VALUES (120, 6, 3, NULL);
INSERT INTO `con_role_menu`
VALUES (121, 6, 100, NULL);
INSERT INTO `con_role_menu`
VALUES (122, 6, 1007, NULL);
INSERT INTO `con_role_menu`
VALUES (123, 7, 4, NULL);
INSERT INTO `con_role_menu`
VALUES (124, 7, 500, NULL);
INSERT INTO `con_role_menu`
VALUES (125, 7, 1038, NULL);

-- ----------------------------
-- Table structure for con_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `con_role_resource`;
CREATE TABLE `con_role_resource`
(
    `id`      int(0) NOT NULL AUTO_INCREMENT,
    `rid`     int(0) NULL DEFAULT NULL,
    `reid`    int(0) NULL DEFAULT NULL,
    `created` date   NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_role_resource
-- ----------------------------
INSERT INTO `con_role_resource`
VALUES (1, 2, 1, NULL);
INSERT INTO `con_role_resource`
VALUES (2, 2, 2, NULL);
INSERT INTO `con_role_resource`
VALUES (3, 2, 6, NULL);
INSERT INTO `con_role_resource`
VALUES (4, 2, 7, NULL);
INSERT INTO `con_role_resource`
VALUES (5, 3, 1, NULL);
INSERT INTO `con_role_resource`
VALUES (6, 3, 6, NULL);

-- ----------------------------
-- Table structure for con_user
-- ----------------------------
DROP TABLE IF EXISTS `con_user`;
CREATE TABLE `con_user`
(
    `id`        int(0)                                                 NOT NULL AUTO_INCREMENT,
    `username`  varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `pwd`       varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `salt`      varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `phone`     varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `email`     varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `image`     varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `login`     int(0) UNSIGNED                                        NULL DEFAULT 0,
    `sex`       int(0)                                                 NULL DEFAULT NULL,
    `status`    int(0)                                                 NULL DEFAULT 1,
    `enable`    int(0)                                                 NULL DEFAULT 1,
    `real_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `avatar`    varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_user
-- ----------------------------
INSERT INTO `con_user`
VALUES (1, 'admin', 'u8iP183ud6XUaDQQ+h119g==', '2caf5ab4-1b7c-462c-afa1-a5e9e8fa70c4', '15543526531', '8540854@qq.com',
        NULL, 1, 1, 1, 1, '超级管理员', NULL);
INSERT INTO `con_user`
VALUES (4, 'wyy', '9gfPitzNVxtVivTyXPV00g==', '9778337d-20a9-4df3-8b84-2d88115c7edf', '1555324324234', '', NULL, 0, 2,
        1, 1, '吴优雅', NULL);
INSERT INTO `con_user`
VALUES (14, 'updater', 'hS3/HK2iSylZP2wyAKOKKw==', '1020f991-cef8-4312-bfc1-5d6c9b2aab5f', '131491779',
        'xgy131491779@235.com', NULL, 0, 1, 1, 1, '修改猿', NULL);
INSERT INTO `con_user`
VALUES (15, 'deleter', 'RqI2b4Tldd40Ba3Bk4n5sA==', '8578420b-85c6-4401-8446-faef37617261', '131491779',
        'xgy131491779@235.com', NULL, 0, 2, 1, 1, '删除员1', NULL);
INSERT INTO `con_user`
VALUES (16, 'test1', 'ztaQk21V8MiOBXIbSNWOhA==', '5974dbfe-3078-4291-a41a-b9226ceab88b', '11111111', 'aa@qq.com', NULL,
        0, 2, 1, 1, '张二娃', NULL);
INSERT INTO `con_user`
VALUES (17, 'test2', 'aaklCbXIQQAhrkAHmnTQ3Q==', '37189393-d089-4e00-9d9e-989fed6725c9', '111', 'xx', NULL, 0, 2, 1, 1,
        'xx', NULL);
INSERT INTO `con_user`
VALUES (18, 'test3', 's5KtkwaP7sNMj2576cHMZQ==', 'd9b656d2-a728-4d0f-bd56-692230c3e886', '11', '11', NULL, 0, 2, 1, 1,
        '张三', NULL);

-- ----------------------------
-- Table structure for con_user_role
-- ----------------------------
DROP TABLE IF EXISTS `con_user_role`;
CREATE TABLE `con_user_role`
(
    `id`      int(0) NOT NULL AUTO_INCREMENT,
    `uid`     int(0) NULL DEFAULT NULL,
    `rid`     int(0) NULL DEFAULT NULL,
    `created` date   NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_user_role
-- ----------------------------
INSERT INTO `con_user_role`
VALUES (1, 1, 1, '2024-10-12');
INSERT INTO `con_user_role`
VALUES (2, 2, 2, '2024-10-11');
INSERT INTO `con_user_role`
VALUES (3, 3, 3, '2024-10-04');
INSERT INTO `con_user_role`
VALUES (4, 4, 3, '2024-10-11');
INSERT INTO `con_user_role`
VALUES (5, 1, 2, '2024-10-16');
INSERT INTO `con_user_role`
VALUES (6, 2, 3, NULL);
INSERT INTO `con_user_role`
VALUES (8, 14, 4, NULL);
INSERT INTO `con_user_role`
VALUES (9, 15, 5, NULL);
INSERT INTO `con_user_role`
VALUES (10, 15, 4, NULL);
INSERT INTO `con_user_role`
VALUES (11, 16, 2, NULL);
INSERT INTO `con_user_role`
VALUES (12, 17, 6, NULL);
INSERT INTO `con_user_role`
VALUES (13, 18, 7, NULL);

-- ----------------------------
-- Table structure for con_village
-- ----------------------------
DROP TABLE IF EXISTS `con_village`;
CREATE TABLE `con_village`
(
    `id`               bigint(0)                                              NOT NULL AUTO_INCREMENT,
    `code`             varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `name`             varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `property`         varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `address`          varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `total_buildings`  int(0)                                                 NULL DEFAULT NULL,
    `total_households` int(0)                                                 NULL DEFAULT NULL,
    `phone`            varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
    `created`          date                                                   NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of con_village
-- ----------------------------
INSERT INTO `con_village`
VALUES (1, '13075', '芙蓉小区', '芙蓉物业', '成都芙蓉区', 30, 100, '13094534431', '2024-10-11');
INSERT INTO `con_village`
VALUES (2, '12640', '骑龙小区', '骑龙物业', '成都双流区', 100, 100, '16459761035', '2024-10-09');
INSERT INTO `con_village`
VALUES (3, '13802', '芙蓉社区', '芙蓉物业', '成都芙蓉区', 120, 100, '18946250136', '2024-08-02');
INSERT INTO `con_village`
VALUES (4, '15656', '明泉社区', '明泉物业', '成都明泉社', 30, 300, '15246227180', '2020-01-21');
INSERT INTO `con_village`
VALUES (5, '19502', '飞升小区', '飞升物业', '成都飞升区', 110, 110, '16791230460', '2000-10-21');
INSERT INTO `con_village`
VALUES (12, '333', '云华路小区', '云华路物业', '云华路333', 50, 100, NULL, '2024-10-25');
INSERT INTO `con_village`
VALUES (14, '2', '11', '66', '233', 44, 55, NULL, '2025-04-28');
INSERT INTO `con_village`
VALUES (15, '33', '33', '33', '33', 33, 33, NULL, '2025-04-28');
INSERT INTO `con_village`
VALUES (18, '66', '66', '66', '66', 66, 66, NULL, '2025-04-28');

SET FOREIGN_KEY_CHECKS = 1;
