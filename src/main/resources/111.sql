/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50646
Source Host           : localhost:3306
Source Database       : formsystem

Target Server Type    : MYSQL
Target Server Version : 50599
File Encoding         : 65001

Date: 2020-07-10 00:10:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for anesthesia_after_opra_konwed
-- ----------------------------
DROP TABLE IF EXISTS `anesthesia_after_opra_konwed`;
CREATE TABLE `anesthesia_after_opra_konwed` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of anesthesia_after_opra_konwed
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for anesthesia_brfore_opra
-- ----------------------------
DROP TABLE IF EXISTS `anesthesia_brfore_opra`;
CREATE TABLE `anesthesia_brfore_opra` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of anesthesia_brfore_opra
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for anesthesia_interview
-- ----------------------------
DROP TABLE IF EXISTS `anesthesia_interview`;
CREATE TABLE `anesthesia_interview` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of anesthesia_interview
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for anesthesia_konwed
-- ----------------------------
DROP TABLE IF EXISTS `anesthesia_konwed`;
CREATE TABLE `anesthesia_konwed` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of anesthesia_konwed
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for blood_transfusion_rec
-- ----------------------------
DROP TABLE IF EXISTS `blood_transfusion_rec`;
CREATE TABLE `blood_transfusion_rec` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of blood_transfusion_rec
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for consum_approve
-- ----------------------------
DROP TABLE IF EXISTS `consum_approve`;
CREATE TABLE `consum_approve` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of consum_approve
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for doctor_info
-- ----------------------------
DROP TABLE IF EXISTS `doctor_info`;
CREATE TABLE `doctor_info` (
`doctor_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`doctor_sign_photo`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`doctor_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of doctor_info
-- ----------------------------
BEGIN;
INSERT INTO `doctor_info` VALUES ('qiumingjie', 'photo.jpg');
COMMIT;

-- ----------------------------
-- Table structure for form_collection
-- ----------------------------
DROP TABLE IF EXISTS `form_collection`;
CREATE TABLE `form_collection` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`is_collection`  bit(1) NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of form_collection
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for form_dict
-- ----------------------------
DROP TABLE IF EXISTS `form_dict`;
CREATE TABLE `form_dict` (
`form_dict_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`form_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`form_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_num`  int(11) NULL DEFAULT NULL ,
`repository_class_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_dict_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of form_dict
-- ----------------------------
BEGIN;
INSERT INTO `form_dict` VALUES ('E0001_0001', '2020-01-30 20:59:53', '\0', '', '2020-01-30 20:59:53', '\0', '测试1表11单', '', null, ''), ('E0001_0002', '2020-01-30 20:59:53', '\0', '', '2020-01-30 20:59:53', '\0', '测试1表11单', '', null, '11'), ('E0002_0001', null, null, null, null, null, '器械清点', null, '4', 'MachineCount'), ('E0002_0002', null, null, null, null, null, '手术护理记录单', null, '4', 'OpraNurseRec'), ('E0002_0003', null, null, null, null, null, '手术室手术病人访式表', null, '3', 'OpraVisiteTable'), ('E0002_0004', null, null, null, null, null, '手术患者术前压疮风险评估单（手术室）', null, '1', 'PressureRisk'), ('E0002_0006', null, null, null, null, null, '输血护理观察记录单', null, '-1', 'BloodTransfusionRec'), ('E0002_0007', null, null, null, null, null, '手术患者转交接记录单', null, '-1', 'OpraPatientTransRec'), ('E0003_0003', null, null, null, null, null, '麻醉术前访视记录单', null, '1', 'AnesthesiaBrforeOpra'), ('E0003_0004', null, null, null, null, null, '麻醉经过及术后访视', null, '3', 'AnesthesiaInterview'), ('E0003_0005', null, null, null, null, null, '麻醉知情同意书', null, '1', 'AnesthesiaKonwed'), ('E0003_0006', null, null, null, null, null, '术后镇痛知情同意书', null, '1', 'AnesthesiaAfterOpraKonwed'), ('E0003_0007', null, null, null, null, null, '使用自费、高费用项目同意书', null, '-1', 'UseExpensiveKnowed'), ('E0003_0008', null, null, null, null, null, '自费药品、医保乙类药品及大型检查申请审批表', null, '-1', 'LargeExamApprove'), ('E0003_0009', null, null, null, null, null, '医保乙类、丙类诊疗项目、材料及贵重耗材申请审批表', null, '-1', 'ConsumApprove'), ('I0001_0001', '2020-01-30 17:44:43', null, null, '2020-01-30 17:49:03', null, '测试1表11单', null, null, null);
COMMIT;

-- ----------------------------
-- Table structure for form_main
-- ----------------------------
DROP TABLE IF EXISTS `form_main`;
CREATE TABLE `form_main` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`form_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`form_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of form_main
-- ----------------------------
BEGIN;
INSERT INTO `form_main` VALUES ('E0002_0001_0001', '2020-07-06 14:14:52', null, null, '2020-07-06 14:14:52', null, null, null, null, '', '', 'qiu', null, null, 'E0002_0001', '器械清点', '122的11111惹我11311', null, null, null), ('E0002_0001_0002', '2020-07-06 14:17:29', null, null, '2020-07-06 15:58:44', null, null, '', null, '', '', 'qiu', null, '', 'E0002_0001', '器械清点', '122的11111惹我11311', null, null, null);
COMMIT;

-- ----------------------------
-- Table structure for form_value
-- ----------------------------
DROP TABLE IF EXISTS `form_value`;
CREATE TABLE `form_value` (
`form_dict_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`item_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`value`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_dict_id`, `item_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of form_value
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for item_dict
-- ----------------------------
DROP TABLE IF EXISTS `item_dict`;
CREATE TABLE `item_dict` (
`item_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`content`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'I' ,
`units`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value_level`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`item_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of item_dict
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for large_exam_approve
-- ----------------------------
DROP TABLE IF EXISTS `large_exam_approve`;
CREATE TABLE `large_exam_approve` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of large_exam_approve
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for machine_count
-- ----------------------------
DROP TABLE IF EXISTS `machine_count`;
CREATE TABLE `machine_count` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of machine_count
-- ----------------------------
BEGIN;
INSERT INTO `machine_count` VALUES ('E0002_0001_0001', '2020-07-06 14:14:52', null, null, '2020-07-06 14:14:52', null, null, null, null, '', '', 'qiu', null, null, 'E0002_0001', '器械清点', '122的11111惹我11311'), ('E0002_0001_0002', '2020-07-06 14:17:29', null, null, '2020-07-06 15:47:45', null, 'MEQCICcJYG782UWQddurjI3gdqj0Wvcsp9kbTsu3YsknULoMAiBS4dC2aM2WErnnRYfs4SMNXlXUtufjTfMulIFSYky7mQ==', null, null, '', '', 'qiu', null, '', 'E0002_0001', '器械清点', '122的11111 我11311'), ('E0002_0001_0021', '2020-07-01 11:24:08', null, null, '2020-07-01 16:53:02', null, '', null, null, '', '', 'qiu', null, '\0', 'E0002_0001', '器械清点', '122的11111惹我11311');
COMMIT;

-- ----------------------------
-- Table structure for opra_nurse_rec
-- ----------------------------
DROP TABLE IF EXISTS `opra_nurse_rec`;
CREATE TABLE `opra_nurse_rec` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of opra_nurse_rec
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for opra_patient_trans_rec
-- ----------------------------
DROP TABLE IF EXISTS `opra_patient_trans_rec`;
CREATE TABLE `opra_patient_trans_rec` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of opra_patient_trans_rec
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for opra_visite_table
-- ----------------------------
DROP TABLE IF EXISTS `opra_visite_table`;
CREATE TABLE `opra_visite_table` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of opra_visite_table
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ops_queue
-- ----------------------------
DROP TABLE IF EXISTS `ops_queue`;
CREATE TABLE `ops_queue` (
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`asa`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`amount_bleeding`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`analgesia_formula`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthesia_endtime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthesia_starttime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_assistant1`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_assistant1code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_assistant1shift_datetime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_assistant2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_assistant2code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_assistant2shift_datetime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_assistant3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_assistant3code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_assistant3shift_datetime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_doctor`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_doctor_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_doctor_shift_datetime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_method`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`anesthetic_method_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`apparatus_nurse`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`application_dept`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`application_dept_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`application_form_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`application_person`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`application_person_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`application_time`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`body_position`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`canceled_cause`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`canceled_person`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`canceled_time`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`checked_person`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`checked_person_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_nurse`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_nurse2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_nurse2code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_nurse3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_nurse3code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_nurse_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_relief_datetime1`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_relief_datetime2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_relief_datetime3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_relief_nurse1`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_relief_nurse1code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_relief_nurse2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_relief_nurse2code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_relief_nurse3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circulating_relief_nurse3code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tbcondition`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dept_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`emergency_or_not`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`enter_room_time`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`exit_room_time`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`green_channel`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`heart_function`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`incision_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`infection_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`inpatient_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`inpatient_or_outpatient`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`instrument_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation1`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation1code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation2code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation3code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation4`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation4code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation5`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation5code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation6`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`intended_operation6code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ipid`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_anesthing`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_endoscopic_surgery`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_monitoring`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_open_surgery`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_postoperative_visits`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_preoperation_fasting`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_preoperative_visits`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_printed`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`isolation`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`monitoring_endtime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`monitoring_starttime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant1`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant1code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant2code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant3code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant4`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant4code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant5`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_assistant5code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_datetime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_doctor`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_doctor_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_endtime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_finishstate`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_lv`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post2code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post3code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post4`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post4code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post5`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post5code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post6`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post6code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_method_post_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_no`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_position`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_room`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_starttime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_state`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_state_notfinal_reason`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`others`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`outpatient_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_bed`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_dep_room`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_dept`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_height`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_state`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_ward`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_weight`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`postopera_analgesia`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`postoperation_diagnosis`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`postoperation_diagnosis_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`postoperative_death`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`preanesth_medication`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`preoperation_diagnosis`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`preoperation_diagnosis_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`register_person`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`register_person_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`register_time`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relief_anesthetic_assistant1`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relief_anesthetic_assistant1code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relief_anesthetic_assistant2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relief_anesthetic_assistant2code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relief_anesthetic_assistant3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relief_anesthetic_assistant3code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relief_anesthetic_doctor`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relief_anesthetic_doctor_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`request_datetime`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_nurse`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_nurse2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_nurse2code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_nurse3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_nurse3code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_nurse_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_relief_datetime1`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_relief_datetime2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_relief_datetime3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_relief_nurse1`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_relief_nurse1code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_relief_nurse2`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_relief_nurse2code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_relief_nurse3`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scrub_relief_nurse3code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`special_case`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`special_instrument`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`urinary_production`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ward_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`operation_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of ops_queue
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for patient_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_info`;
CREATE TABLE `patient_info` (
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`adverse_reaction_drug`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`age`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`age_day`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`age_month`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`allergy_drug`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`birthday`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`blood_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bloodtype_rh`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`hbsag`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`hcv`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`hiv`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`id_card_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`inhospital_bed`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`inhospital_dept`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`inhospital_diagnoses`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`inhospital_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`inhospital_ward`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`medical_card_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`medicare_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`medicare_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`mypatid`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`nation`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`other_inspection`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_info_expand1`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_info_expand2`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_info_expand3`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`pinyin_code`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`register_datetime`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`register_person`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relation_addr`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relation_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relation_telephone_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relation_zipcode`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`relationship`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`residence`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sex`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`system_user_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`system_user_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`telephone_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tp`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`weight`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`zipcode`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`patient_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of patient_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pressure_risk
-- ----------------------------
DROP TABLE IF EXISTS `pressure_risk`;
CREATE TABLE `pressure_risk` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of pressure_risk
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
`form_dict_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`item_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
PRIMARY KEY (`form_dict_id`, `item_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
`sign_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`doctor_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`doctor_sign_photo`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`sign_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of sign
-- ----------------------------
BEGIN;
INSERT INTO `sign` VALUES ('12122780-5032-4cfd-92ff-c64394714546', 'qiumingjie', 'photo.jpg', 'E0002_0001_0002'), ('1d2d1699-259b-4e8d-a465-ec1254786228', 'qiumingjie', null, 'E0002_0001_0021'), ('2da2dd3e-f223-45d7-9c43-590c683f6821', 'qiumingjie', null, 'E0002_0001_0002'), ('5883c8b3-f296-400f-911b-0dba28bb7484', 'qiumingjie', 'photo.jpg', 'E0002_0001_0021'), ('80ff88f7-9cb0-4568-9f64-e8ec9a119f86', 'qiumingjie', 'photo.jpg', 'E0002_0001_0002'), ('8255d995-e148-43c1-9901-ed1b68fa152e', 'qiumingjie', 'photo.jpg', 'E0002_0001_0002'), ('894dc10f-47d7-4865-ac0c-d35e1f09abce', 'qiumingjie', 'photo.jpg', 'E0002_0001_0021'), ('8ba1d4a8-89a0-4ef5-b25a-5b80feb8a1d8', 'qiumingjie', 'photo.jpg', 'E0002_0001_0002'), ('a3abdd4c-c084-4a73-af82-31cb2918badd', 'qiumingjie', null, 'E0002_0001_0002'), ('aafec72d-709b-40a8-8dd8-d26a64e4689f', 'qiumingjie', 'photo.jpg', 'E0002_0001_0002'), ('b045dcd1-b7ad-4ca3-865b-719fc2963b3d', 'qiumingjie', null, 'E0002_0001_0021'), ('cb128f7b-9cb5-4ef3-ac60-5e1c3d808e06', 'qiumingjie', null, 'E0002_0001_0021');
COMMIT;

-- ----------------------------
-- Table structure for use_expensive_knowed
-- ----------------------------
DROP TABLE IF EXISTS `use_expensive_knowed`;
CREATE TABLE `use_expensive_knowed` (
`form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_date_time`  datetime NULL DEFAULT NULL ,
`delete_flag`  bit(1) NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date_time`  datetime NULL DEFAULT NULL ,
`use_flag`  bit(1) NULL DEFAULT NULL ,
`after_sign_value`  varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`archive_flag`  bit(1) NULL DEFAULT NULL ,
`creator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operation_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`patient_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`record_date_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sign_flag`  bit(1) NULL DEFAULT NULL ,
`template_form_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`template_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`value`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`form_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of use_expensive_knowed
-- ----------------------------
BEGIN;
COMMIT;
