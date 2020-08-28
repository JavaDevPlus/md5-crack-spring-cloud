/*
 Navicat Premium Data Transfer

 Source Server         : 本机-MySql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : microservice-md5

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 27/07/2020 21:33:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for crack_md5_ten_0
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_0`;
CREATE TABLE `crack_md5_ten_0` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_0
-- ----------------------------
BEGIN;
INSERT INTO `crack_md5_ten_0` VALUES (111, 'aaa', '111aaa', '2020-07-22 14:49:09');
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_1
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_1`;
CREATE TABLE `crack_md5_ten_1` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_1
-- ----------------------------
BEGIN;
INSERT INTO `crack_md5_ten_1` VALUES (222, 'bbb', '222bbb', '2020-07-22 14:51:09');
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_2
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_2`;
CREATE TABLE `crack_md5_ten_2` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_2
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_3
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_3`;
CREATE TABLE `crack_md5_ten_3` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_3
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_4
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_4`;
CREATE TABLE `crack_md5_ten_4` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_4
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_5
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_5`;
CREATE TABLE `crack_md5_ten_5` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_5
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_6
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_6`;
CREATE TABLE `crack_md5_ten_6` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_6
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_7
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_7`;
CREATE TABLE `crack_md5_ten_7` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_7
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_8
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_8`;
CREATE TABLE `crack_md5_ten_8` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_8
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_9
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_9`;
CREATE TABLE `crack_md5_ten_9` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_9
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_a
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_a`;
CREATE TABLE `crack_md5_ten_a` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_a
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_b
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_b`;
CREATE TABLE `crack_md5_ten_b` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_b
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_c
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_c`;
CREATE TABLE `crack_md5_ten_c` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_c
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_d
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_d`;
CREATE TABLE `crack_md5_ten_d` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_d
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_e
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_e`;
CREATE TABLE `crack_md5_ten_e` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_e
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_f
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_f`;
CREATE TABLE `crack_md5_ten_f` (
  `id` bigint(40) NOT NULL,
  `old_str` varchar(500) NOT NULL,
  `MD5_32_str` varchar(32) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`old_str`(255)) USING BTREE,
  KEY `MD5_32_str_index` (`MD5_32_str`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_f
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crack_md5_ten_info
-- ----------------------------
DROP TABLE IF EXISTS `crack_md5_ten_info`;
CREATE TABLE `crack_md5_ten_info` (
  `id` bigint(40) NOT NULL,
  `all_count` bigint(16) NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `old_str_index` (`all_count`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crack_md5_ten_info
-- ----------------------------
BEGIN;
INSERT INTO `crack_md5_ten_info` VALUES (11, 2014, '2020-07-21 16:34:55');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
