/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 100128
 Source Host           : localhost:3306
 Source Schema         : TRN

 Target Server Type    : MySQL
 Target Server Version : 100128
 File Encoding         : 65001

 Date: 07/01/2019 13:22:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `last_name` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `title` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `work_phone` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `designation` varchar(255) COLLATE ascii_bin NOT NULL,
  `expertise` varchar(255) COLLATE ascii_bin NOT NULL,
  `name` varchar(255) COLLATE ascii_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- ----------------------------
-- Table structure for trn_customers
-- ----------------------------
DROP TABLE IF EXISTS `trn_customers`;
CREATE TABLE `trn_customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `billing_address` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `city` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `company_name` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `company_website` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `email` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `fax_number` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `first_name` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `last_name` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `phone_number` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `ship_address` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `ship_city` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `ship_phone_number` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `ship_stated_or_province` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `ship_zip_code` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `stated_or_province` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `zip_code` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- ----------------------------
-- Table structure for trn_employees
-- ----------------------------
DROP TABLE IF EXISTS `trn_employees`;
CREATE TABLE `trn_employees` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `last_name` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `title` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `work_phone` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- ----------------------------
-- Records of trn_employees
-- ----------------------------
BEGIN;
INSERT INTO `trn_employees` VALUES (1, 'Adam', 'Barr', 'Sales Representative', '2065550123');
INSERT INTO `trn_employees` VALUES (2, 'Oliver', 'Cox', 'Sales Manager', '2065550126');
INSERT INTO `trn_employees` VALUES (3, 'Chris', 'Cannon', 'Sales Representative', '2065550125');
INSERT INTO `trn_employees` VALUES (4, 'Eva', 'Corets', 'Product Manager', '2065550127');
INSERT INTO `trn_employees` VALUES (5, 'Doris', 'Hartwig', 'Sales Representative', '2065550128');
COMMIT;

-- ----------------------------
-- Table structure for trn_order_details
-- ----------------------------
DROP TABLE IF EXISTS `trn_order_details`;
CREATE TABLE `trn_order_details` (
  `order_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `discount` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `FKbj9djhy1ebt9njd44x8k7j0gq` (`order_id`),
  KEY `FKq7992de3wqumwmgexll8wrn22` (`product_id`),
  CONSTRAINT `FKbj9djhy1ebt9njd44x8k7j0gq` FOREIGN KEY (`order_id`) REFERENCES `trn_orders` (`order_id`),
  CONSTRAINT `FKq7992de3wqumwmgexll8wrn22` FOREIGN KEY (`product_id`) REFERENCES `trn_products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- ----------------------------
-- Table structure for trn_orders
-- ----------------------------
DROP TABLE IF EXISTS `trn_orders`;
CREATE TABLE `trn_orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `freight_charge` int(11) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `payment_received` char(1) COLLATE ascii_bin DEFAULT NULL,
  `purchase_order_number` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `ship_date` datetime DEFAULT NULL,
  `taxes` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `shipping_method_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKewxxl9mv09b1099oj6dlpdo9t` (`customer_id`),
  KEY `FK3pu3m20krcfqayqg337h8ytgr` (`employee_id`),
  KEY `FKbt2ug765mkf1g042byhc8s3f0` (`shipping_method_id`),
  CONSTRAINT `FK3pu3m20krcfqayqg337h8ytgr` FOREIGN KEY (`employee_id`) REFERENCES `trn_employees` (`employee_id`),
  CONSTRAINT `FKbt2ug765mkf1g042byhc8s3f0` FOREIGN KEY (`shipping_method_id`) REFERENCES `trn_shipping_methods` (`shipping_method_id`),
  CONSTRAINT `FKewxxl9mv09b1099oj6dlpdo9t` FOREIGN KEY (`customer_id`) REFERENCES `trn_customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- ----------------------------
-- Table structure for trn_products
-- ----------------------------
DROP TABLE IF EXISTS `trn_products`;
CREATE TABLE `trn_products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `in_stock` char(1) COLLATE ascii_bin DEFAULT NULL,
  `product_name` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `unit_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- ----------------------------
-- Table structure for trn_shipping_methods
-- ----------------------------
DROP TABLE IF EXISTS `trn_shipping_methods`;
CREATE TABLE `trn_shipping_methods` (
  `shipping_method_id` int(11) NOT NULL AUTO_INCREMENT,
  `shipping_method` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  PRIMARY KEY (`shipping_method_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

SET FOREIGN_KEY_CHECKS = 1;
