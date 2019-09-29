/*
SQLyog Ultimate v8.32 
MySQL - 5.7.22-log : Database - powerdoc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`powerdoc` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `powerdoc`;

/*Table structure for table `power_device` */

DROP TABLE IF EXISTS `power_device`;

CREATE TABLE `power_device` (
  `device_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设备表主键自增',
  `device_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '设备名称',
  `device_type` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '设备类型（变压器，避雷器等）',
  `air_temperature` varchar(3) COLLATE utf8_bin DEFAULT '/' COMMENT '气温（℃）',
  `humidity` varchar(3) COLLATE utf8_bin DEFAULT '/' COMMENT '湿度',
  `run_humidity` varchar(10) COLLATE utf8_bin DEFAULT '/' COMMENT '运行电压',
  `oil_temperature` varchar(3) COLLATE utf8_bin DEFAULT '/' COMMENT '油温',
  `connect_group` varchar(30) COLLATE utf8_bin DEFAULT '/' COMMENT '连接组别',
  `model_no` varchar(100) COLLATE utf8_bin DEFAULT '/' COMMENT '型号',
  `producer` varchar(100) COLLATE utf8_bin DEFAULT '/' COMMENT '制造厂家',
  `capacity` varchar(10) COLLATE utf8_bin DEFAULT '/' COMMENT '容量',
  `run_no` varchar(20) COLLATE utf8_bin DEFAULT '/' COMMENT '运行编号',
  `run_date` varchar(20) COLLATE utf8_bin DEFAULT '/' COMMENT '投运日期',
  `production_date` varchar(20) COLLATE utf8_bin DEFAULT '/' COMMENT '出厂日期',
  `production_no` varchar(50) COLLATE utf8_bin DEFAULT '/' COMMENT '出厂编号',
  `status` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '状态 0：失效 1：正常 2：已删除',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='设备表';

/*Data for the table `power_device` */

LOCK TABLES `power_device` WRITE;

insert  into `power_device`(`device_id`,`device_name`,`device_type`,`air_temperature`,`humidity`,`run_humidity`,`oil_temperature`,`connect_group`,`model_no`,`producer`,`capacity`,`run_no`,`run_date`,`production_date`,`production_no`,`status`,`add_userid`,`add_username`,`addtime`,`edit_userid`,`edit_username`,`edittime`) values (1,'变压器',NULL,'15','40','220kV','24','YNyn0d11','SFSZ10-150000/220','广州维奥伊林变压器有限公司','/','/','/','2006-10','005015','1',0,NULL,NULL,NULL,NULL,NULL),(2,'高压套管',NULL,'15','40','220kV','0','/','COT1050-800','上海MWB互感器有限公司','/','/','/','2006-08','A：060329  B：060391  C：06090   O：061215','1',0,NULL,NULL,NULL,NULL,NULL),(3,'电压互感器',NULL,'15','40','35kV','0','/','JDZX9-35DG','大连华夏泰克电气集团有限公司','/','朝35kV北母PT','/','2016-09','A:HY1609022906 B:HY1609202904 C:HY1609202905','1',0,NULL,NULL,NULL,NULL,NULL),(4,'电流互感器',NULL,'17','65','220kV','0','/','LVB-220','山东泰开互感器有限公司','/','御澶2CT','/','2017-02','A：1700007  B：1700008  C：1700009','1',0,NULL,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `power_device_model` */

DROP TABLE IF EXISTS `power_device_model`;

CREATE TABLE `power_device_model` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '设备与模板关系表主键',
  `model_id` bigint(11) DEFAULT NULL COMMENT '模板id',
  `model_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '模板名称',
  `device_id` bigint(11) DEFAULT NULL COMMENT '设备id',
  `devie_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '设备名称',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `modelId_deviceId` (`model_id`,`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='设备_模板中间表';

/*Data for the table `power_device_model` */

LOCK TABLES `power_device_model` WRITE;

insert  into `power_device_model`(`id`,`model_id`,`model_name`,`device_id`,`devie_name`,`add_userid`,`add_username`,`addtime`,`edit_userid`,`edit_username`,`edittime`) values (1,1,'变压器绝缘试验报告',1,'变压器',0,'system',NULL,NULL,NULL,NULL),(2,2,'变压器直流电阻试验报告',1,'变压器',0,'system',NULL,NULL,NULL,NULL),(3,3,'高压套管试验报告',2,'高压套管',NULL,'system',NULL,NULL,NULL,NULL),(4,15,'电压互感器试验报告',3,'电压互感器',NULL,NULL,NULL,NULL,NULL,NULL),(5,16,'电流互感器试验报告',4,'电流互感器',NULL,'system',NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `power_doc_current_transformer` */

DROP TABLE IF EXISTS `power_doc_current_transformer`;

CREATE TABLE `power_doc_current_transformer` (
  `current_transformer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '电流互感器试验报告主键',
  `subreport_id` bigint(11) DEFAULT NULL COMMENT '所属报告id',
  `A_first` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '绝缘电阻测量_A_一次/末屏、二次及地',
  `B_first` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '绝缘电阻测量_B_一次/末屏、二次及地',
  `C_first` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '绝缘电阻测量_C_一次/末屏、二次及地',
  `A_last` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '绝缘电阻测量_A_末屏/二次及地',
  `B_last` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '绝缘电阻测量_B_末屏/二次及地',
  `C_last` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '绝缘电阻测量_C_末屏/二次及地',
  `A_second` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '绝缘电阻测量_A_二次/末屏及地',
  `B_second` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '绝缘电阻测量_B_二次/末屏及地',
  `C_second` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '绝缘电阻测量_C_二次/末屏及地',
  `test_position_positive` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '试验部位_正接法',
  `A_Cx_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_A_Cx(pf)',
  `B_Cx_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_B_Cx(pf)',
  `C_Cx_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_C_Cx(pf)',
  `A_tg_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_A_tgδ%',
  `B_tg_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_B_tgδ%',
  `C_tg_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_C_tgδ%',
  `A_pf_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_A_原始电容(pf)',
  `B_pf_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_B_原始电容(pf)',
  `C_pf_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_C_原始电容(pf)',
  `A_C_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_A_△C %',
  `B_C_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_B_△C %',
  `C_C_positive` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '电容值测量_正接法_C_△C %',
  `test_position_reverse` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '试验部位_反接法',
  `A_Cx_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_A_Cx(pf)',
  `B_Cx_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_B_Cx(pf)',
  `C_Cx_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_C_Cx(pf)',
  `A_tg_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_A_tgδ%',
  `B_tg_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_B_tgδ%',
  `C_tg_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_C_tgδ%',
  `A_pf_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_A_原始电容(pf)',
  `B_pf_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_B_原始电容(pf)',
  `C_pf_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_C_原始电容(pf)',
  `A_C_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_A_△C %',
  `B_C_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_B_△C %',
  `C_C_reverse` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '电容值测量_反接法_C_△C %',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`current_transformer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='电流互感器试验报告';

/*Data for the table `power_doc_current_transformer` */

LOCK TABLES `power_doc_current_transformer` WRITE;

UNLOCK TABLES;

/*Table structure for table `power_doc_dc_resistance` */

DROP TABLE IF EXISTS `power_doc_dc_resistance`;

CREATE TABLE `power_doc_dc_resistance` (
  `dc_resistance_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '变压器直流电阻报告主键',
  `subreport_id` bigint(11) DEFAULT NULL COMMENT '所属报告id',
  `dc_ab` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '直阻测试值-ab',
  `dc_bc` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '直阻测试值-bc',
  `dc_ca` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '直阻测试值-ca',
  `dc_last` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '直阻测试值-斜杠',
  `convert_ax` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '换算至相电阻-ax',
  `convert_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '换算至相电阻-by',
  `convert_cz` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '换算至相电阻-cz',
  `convert_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '相间最大误差(%)',
  `high_1_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_1_AO',
  `high_1_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_1_BO',
  `high_1_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_1_CO',
  `high_1_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_1_相间最大误差(%)',
  `middle_1_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_1_AmOm',
  `middle_1_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_1_BmOm',
  `middle_1_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_1_CmOm',
  `middle_1_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_1_error',
  `high_2_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_2_AO',
  `high_2_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_2_BO',
  `high_2_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_2_CO',
  `high_2_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_2_相间最大误差(%)',
  `middle_2_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_2_AmOm',
  `middle_2_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_2_BmOm',
  `middle_2_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_2_CmOm',
  `middle_2_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_2_error',
  `high_3_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_3_AO',
  `high_3_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_3_BO',
  `high_3_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_3_CO',
  `high_3_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_3_相间最大误差(%)',
  `middle_3_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_3_AmOm',
  `middle_3_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_3_BmOm',
  `middle_3_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_3_CmOm',
  `middle_3_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_3_error',
  `high_4_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_4_AO',
  `high_4_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_4_BO',
  `high_4_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_4_CO',
  `high_4_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_4_相间最大误差(%)',
  `middle_4_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_4_AmOm',
  `middle_4_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_4_BmOm',
  `middle_4_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_4_CmOm',
  `middle_4_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_4_error',
  `high_5_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_5_AO',
  `high_5_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_5_BO',
  `high_5_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_5_CO',
  `high_5_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_5_相间最大误差(%)',
  `middle_5_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_5_AmOm',
  `middle_5_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_5_BmOm',
  `middle_5_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_5_CmOm',
  `middle_5_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_5_error',
  `high_6_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_6_AO',
  `high_6_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_6_BO',
  `high_6_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_6_CO',
  `high_6_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_6_相间最大误差(%)',
  `middle_6_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_6_AmOm',
  `middle_6_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_6_BmOm',
  `middle_6_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_6_CmOm',
  `middle_6_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_6_error',
  `high_7_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_7_AO',
  `high_7_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_7_BO',
  `high_7_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_7_CO',
  `high_7_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_7_相间最大误差(%)',
  `middle_7_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_7_AmOm',
  `middle_7_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_7_BmOm',
  `middle_7_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_7_CmOm',
  `middle_7_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_7_error',
  `high_8_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_8_AO',
  `high_8_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_8_BO',
  `high_8_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_8_CO',
  `high_8_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_8_相间最大误差(%)',
  `middle_8_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_8_AmOm',
  `middle_8_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_8_BmOm',
  `middle_8_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_8_CmOm',
  `middle_8_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_8_error',
  `high_9b_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_9b_AO',
  `high_9b_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_9b_BO',
  `high_9b_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_9b_CO',
  `high_9b_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_9b_相间最大误差(%)',
  `middle_9b_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_9b_AmOm',
  `middle_9b_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_9b_BmOm',
  `middle_9b_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_9b_CmOm',
  `middle_9b_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_9b_error',
  `high_10_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_10_AO',
  `high_10_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_10_BO',
  `high_10_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_10_CO',
  `high_10_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_10_相间最大误差(%)',
  `middle_10_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_10_AmOm',
  `middle_10_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_10_BmOm',
  `middle_10_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_10_CmOm',
  `middle_10_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_10_error',
  `high_11_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_11_AO',
  `high_11_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_11_BO',
  `high_11_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_11_CO',
  `high_11_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_11_相间最大误差(%)',
  `middle_11_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_11_AmOm',
  `middle_11_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_11_BmOm',
  `middle_11_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_11_CmOm',
  `middle_11_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_11_error',
  `high_12_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_12_AO',
  `high_12_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_12_BO',
  `high_12_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_12_CO',
  `high_12_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_12_相间最大误差(%)',
  `middle_12_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_12_AmOm',
  `middle_12_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_12_BmOm',
  `middle_12_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_12_CmOm',
  `middle_12_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_12_error',
  `high_13_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_13_AO',
  `high_13_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_13_BO',
  `high_13_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_13_CO',
  `high_13_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_13_相间最大误差(%)',
  `middle_13_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_13_AmOm',
  `middle_13_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_13_BmOm',
  `middle_13_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_13_CmOm',
  `middle_13_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_13_error',
  `high_14_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_14_AO',
  `high_14_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_14_BO',
  `high_14_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_14_CO',
  `high_14_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_14_相间最大误差(%)',
  `middle_14_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_14_AmOm',
  `middle_14_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_14_BmOm',
  `middle_14_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_14_CmOm',
  `middle_14_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_14_error',
  `high_15_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_15_AO',
  `high_15_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_15_BO',
  `high_15_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_15_CO',
  `high_15_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_15_相间最大误差(%)',
  `middle_15_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_15_AmOm',
  `middle_15_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_15_BmOm',
  `middle_15_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_15_CmOm',
  `middle_15_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_15_error',
  `high_16_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_16_AO',
  `high_16_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_16_BO',
  `high_16_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_16_CO',
  `high_16_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_16_相间最大误差(%)',
  `middle_16_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_16_AmOm',
  `middle_16_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_16_BmOm',
  `middle_16_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_16_CmOm',
  `middle_16_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_16_error',
  `high_17_AO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_17_AO',
  `high_17_BO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_17_BO',
  `high_17_CO` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_17_CO',
  `high_17_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '高压侧直阻（m）_17_相间最大误差(%)',
  `middle_17_AmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_17_AmOm',
  `middle_17_BmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_17_BmOm',
  `middle_17_CmOm` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_17_CmOm',
  `middle_17_error` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '中压侧直阻（m）_17_error',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dc_resistance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='变压器直流电阻试验报告';

/*Data for the table `power_doc_dc_resistance` */

LOCK TABLES `power_doc_dc_resistance` WRITE;

UNLOCK TABLES;

/*Table structure for table `power_doc_hv_bushings` */

DROP TABLE IF EXISTS `power_doc_hv_bushings`;

CREATE TABLE `power_doc_hv_bushings` (
  `hv_bushings_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '高压套管试验报告主键',
  `subreport_id` bigint(11) DEFAULT NULL COMMENT '所属报告id',
  `A_once` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'A_一次末屏',
  `A_land` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'A_末屏地',
  `B_once` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'B_一次末屏',
  `B_land` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'B_末屏地',
  `C_once` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'C_一次末屏',
  `C_land` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'C_末屏地',
  `D_once` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'D_一次末屏',
  `D_land` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'D_末屏地',
  `test_position` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '试验部位',
  `test_voltage` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '试验电压',
  `A_Cx` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'A_Cx(pF)',
  `A_tg` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'A_tgδ%',
  `A_pF` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'A_原始电容',
  `A_C` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'A_△C %',
  `B_Cx` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'B_Cx(pF)',
  `B_tg` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'B_tgδ%',
  `B_pF` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'B_原始电容',
  `B_C` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'B_△C %',
  `C_Cx` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'C_Cx(pF)',
  `C_tg` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'C_tgδ%',
  `C_pF` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'C_原始电容',
  `C_C` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'C_△C %',
  `D_Cx` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'D_Cx(pF)',
  `D_tg` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'D_tgδ%',
  `D_pF` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'D_原始电容',
  `D_C` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT 'D_△C %',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`hv_bushings_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='高压套管试验报告';

/*Data for the table `power_doc_hv_bushings` */

LOCK TABLES `power_doc_hv_bushings` WRITE;

UNLOCK TABLES;

/*Table structure for table `power_doc_insulation` */

DROP TABLE IF EXISTS `power_doc_insulation`;

CREATE TABLE `power_doc_insulation` (
  `insulation_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '绝缘报告主键',
  `subreport_id` bigint(11) DEFAULT NULL COMMENT '所属报告id',
  `iron_core` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '铁芯/地绝缘( MΩ)',
  `clip` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '夹件/地绝缘( MΩ)',
  `high_mid_R15` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '高压/中压、低压及地-R15s',
  `mid_high_R15` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '中压/高压、低压及地-R15s',
  `low_high_R15` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '低压/高压、中压及地-R15s',
  `high_mid_R60` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '高压/中压、低压及地-R60',
  `mid_high_R60` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '中压/高压、低压及地-R60',
  `low_high_R60` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '低压/高压、中压及地-R60',
  `high_mid_R10` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '高压/中压、低压及地-R10',
  `mid_high_R10` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '中压/高压、低压及地-R10',
  `low_high_R10` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '低压/高压、中压及地-R10',
  `high_mid_ratio` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '高压/中压、低压及地-吸收比',
  `mid_high_ratio` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '中压/高压、低压及地-吸收比',
  `low_high_ratio` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '低压/高压、中压及地-吸收比',
  `high_mid_index` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '高压/中压、低压及地-极化指数',
  `mid_high_index` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '中压/高压、低压及地-极化指数',
  `low_high_index` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '低压/高压、中压及地-极化指数',
  `high_mid_kv` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '高压/中压、低压及地-电压',
  `mid_high_kv` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '中压/高压、低压及地-电压',
  `low_high_kv` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '低压/高压、中压及地-电压',
  `high_mid_nf` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '高压/中压、低压及地-电容',
  `mid_high_nf` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '中压/高压、低压及地-电容',
  `low_high_nf` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '低压/高压、中压及地-电容',
  `high_mid_tg` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '高压/中压、低压及地-介损',
  `mid_high_tg` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '中压/高压、低压及地-介损',
  `low_high_tg` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '/' COMMENT '低压/高压、中压及地-介损',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`insulation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='变压器绝缘报告';

/*Data for the table `power_doc_insulation` */

LOCK TABLES `power_doc_insulation` WRITE;

insert  into `power_doc_insulation`(`insulation_id`,`subreport_id`,`iron_core`,`clip`,`high_mid_R15`,`mid_high_R15`,`low_high_R15`,`high_mid_R60`,`mid_high_R60`,`low_high_R60`,`high_mid_R10`,`mid_high_R10`,`low_high_R10`,`high_mid_ratio`,`mid_high_ratio`,`low_high_ratio`,`high_mid_index`,`mid_high_index`,`low_high_index`,`high_mid_kv`,`mid_high_kv`,`low_high_kv`,`high_mid_nf`,`mid_high_nf`,`low_high_nf`,`high_mid_tg`,`mid_high_tg`,`low_high_tg`,`add_userid`,`add_username`,`addtime`,`edit_userid`,`edit_username`,`edittime`) values (1,2,'13000','11000','25000','20000','15000','45000','30000','20000',NULL,NULL,NULL,'1.8',NULL,'1.47',NULL,NULL,NULL,'10','10','10','11.08','11.08','27.26','0.181','0.203','0.263',NULL,NULL,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `power_doc_voltage_transformer` */

DROP TABLE IF EXISTS `power_doc_voltage_transformer`;

CREATE TABLE `power_doc_voltage_transformer` (
  `voltage_transformer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '电压互感器试验报告主键',
  `subreport_id` bigint(11) DEFAULT NULL COMMENT '所属报告id',
  `A_first` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '绝缘电阻测量_A_一次/其它及地',
  `A_second` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '绝缘电阻测量_A_二次/其它及地',
  `A_support` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '绝缘电阻测量_A_辅助/其它及地',
  `B_first` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '绝缘电阻测量_B_一次/其它及地',
  `B_second` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '绝缘电阻测量_B_二次/其它及地',
  `B_support` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '绝缘电阻测量_B_辅助/其它及地',
  `C_first` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '绝缘电阻测量_C_一次/其它及地',
  `C_second` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '绝缘电阻测量_C_二次/其它及地',
  `C_support` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '绝缘电阻测量_C_辅助/其它及地',
  `test_position` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_试验部位',
  `A_voltage` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_A_试验电压(kv)',
  `B_voltage` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_B_试验电压(kv)',
  `C_voltage` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_C_试验电压(kv)',
  `A_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_A_试讲（分）',
  `B_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_B_试讲（分）',
  `C_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_C_试讲（分）',
  `A_result` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_A_结果',
  `B_result` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_B_结果',
  `C_result` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_C_结果',
  `A_after` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_A_耐压后绝缘（ＭΩ）',
  `B_after` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_B_耐压后绝缘（ＭΩ）',
  `C_after` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '交流耐压_C_耐压后绝缘（ＭΩ）',
  `A_direct` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '直流电阻测试_A_直流电阻值（Ω）',
  `B_direct` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '直流电阻测试_B_直流电阻值（Ω）',
  `C_direct` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '直流电阻测试_C_直流电阻值（Ω）',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`voltage_transformer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='电压互感器试验报告';

/*Data for the table `power_doc_voltage_transformer` */

LOCK TABLES `power_doc_voltage_transformer` WRITE;

UNLOCK TABLES;

/*Table structure for table `power_instrument` */

DROP TABLE IF EXISTS `power_instrument`;

CREATE TABLE `power_instrument` (
  `instrument_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '仪器表主键',
  `instrument_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '仪器名称',
  `instrument_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '仪器类型（备用）',
  `instrument_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '1' COMMENT '仪器状态 0：失效 1：正常 2：已删除',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`instrument_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='仪器表';

/*Data for the table `power_instrument` */

LOCK TABLES `power_instrument` WRITE;

insert  into `power_instrument`(`instrument_id`,`instrument_name`,`instrument_type`,`instrument_status`,`add_userid`,`add_username`,`addtime`,`edit_userid`,`edit_username`,`edittime`) values (1,'MODEL3124高压兆欧表',NULL,'1',0,NULL,NULL,NULL,NULL,NULL),(2,'A1-6000（F型）抗干扰介质损耗测量',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL),(3,'变压器直流电阻测试仪',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL),(4,'流耐压试验装置',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL),(5,'单臂电桥',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `power_model` */

DROP TABLE IF EXISTS `power_model`;

CREATE TABLE `power_model` (
  `model_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '模板表主键',
  `model_table_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '模板明细对应表名',
  `model_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '模板名称',
  `model_type` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '模板类型（备用）',
  `model_template_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '文档模板名称',
  `model_url` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '模板路径',
  `model_status` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '模板状态 0：失效 1：正常 2：已删除',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='模板表';

/*Data for the table `power_model` */

LOCK TABLES `power_model` WRITE;

insert  into `power_model`(`model_id`,`model_table_name`,`model_name`,`model_type`,`model_template_name`,`model_url`,`model_status`,`add_userid`,`add_username`,`addtime`,`edit_userid`,`edit_username`,`edittime`) values (1,'power_doc_insulation','变压器绝缘试验报告',NULL,'insulation.doc',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL),(2,'power_doc_dc_resistance','变压器直流电阻试验报告',NULL,'dcResistance.doc',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL),(3,'power_doc_hv_bushings','高压套管试验报告',NULL,'hvBushings.doc',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL),(15,'power_doc_voltage_transformer','电压互感器试验报告',NULL,'voltageTransformer.doc',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL),(16,'power_doc_current_transformer','电流互感器试验报告',NULL,'currentTransformer.doc',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `power_report` */

DROP TABLE IF EXISTS `power_report`;

CREATE TABLE `power_report` (
  `id` bigint(11) NOT NULL COMMENT '时间毫秒值',
  `substation_id` bigint(11) DEFAULT NULL COMMENT '变电站id',
  `substation_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '变电站名称',
  `device_ids` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '设备ids',
  `device_names` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备名称',
  `run_no` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '运行编号',
  `test_properties` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '试验性质',
  `test_people_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '试验人员id（，号分割）',
  `test_people` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '试验人员',
  `test_duty_person_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '试验负责人id',
  `test_duty_person` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '试验负责人',
  `test_date` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '试验日期',
  `review_person_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '校对人id',
  `review_person` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '校对人',
  `check_person_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人id',
  `check_person` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人',
  `approve_person_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '批准人id',
  `approve_person` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '批准人',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  `report_status` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '报告状态 0：失效:1：正常  2：已删除',
  `report_type` char(2) COLLATE utf8_bin DEFAULT NULL COMMENT '报告类型 （预留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='试验报告主表';

/*Data for the table `power_report` */

LOCK TABLES `power_report` WRITE;

insert  into `power_report`(`id`,`substation_id`,`substation_name`,`device_ids`,`device_names`,`run_no`,`test_properties`,`test_people_id`,`test_people`,`test_duty_person_id`,`test_duty_person`,`test_date`,`review_person_id`,`review_person`,`check_person_id`,`check_person`,`approve_person_id`,`approve_person`,`add_userid`,`add_username`,`addtime`,`edit_userid`,`edit_username`,`edittime`,`report_status`,`report_type`) values (10092910,1,'澶都变电站','1','变压器','澶2#主变','2019年度 例行试验','12,13','张飞 赵云','15','黄忠','2019年03月11日','','','12','张飞','','',NULL,NULL,'2019-09-22 17:38:48',NULL,NULL,NULL,'1',NULL),(10092998,1,'澶都变电站','1','变压器','澶2#主变','2019年度 例行试验','12,13','张飞 赵云','15','黄忠','2019年03月11日','','','12','张飞','','',NULL,NULL,'2019-09-22 17:33:00',NULL,NULL,NULL,'1',NULL);

UNLOCK TABLES;

/*Table structure for table `power_sub_report` */

DROP TABLE IF EXISTS `power_sub_report`;

CREATE TABLE `power_sub_report` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '单个报告自增主键',
  `report_id` bigint(11) DEFAULT NULL COMMENT '父id',
  `device_id` bigint(11) DEFAULT NULL COMMENT '设备id',
  `device_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '设备名称',
  `device_type` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '设备类型（统计后维护）',
  `air_temperature` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '气温（℃）',
  `humidity` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '湿度',
  `run_humidity` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '运行电压',
  `oil_temperature` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '油温',
  `connect_group` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '连接组别',
  `model_no` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '型号',
  `producer` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '制造厂家',
  `capacity` varchar(10) COLLATE utf8_bin DEFAULT '/' COMMENT '容量',
  `run_no` varchar(20) COLLATE utf8_bin DEFAULT '/' COMMENT '运行编号',
  `run_date` varchar(20) COLLATE utf8_bin DEFAULT '/' COMMENT '投运日期',
  `production_date` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '出厂日期',
  `production_no` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '出厂编号',
  `instrument_ids` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '使用仪器ids（，号分割）',
  `instrument_names` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '使用仪器（，号分割）',
  `test_date` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '试验日期',
  `status` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '状态 0：失效 1：正常 2：已删除',
  `conclusion` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '结论',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加人id',
  `add_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '添加人姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改人id',
  `edit_username` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人姓名',
  `edittime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='试验报告子表，以设备划分';

/*Data for the table `power_sub_report` */

LOCK TABLES `power_sub_report` WRITE;

insert  into `power_sub_report`(`id`,`report_id`,`device_id`,`device_name`,`device_type`,`air_temperature`,`humidity`,`run_humidity`,`oil_temperature`,`connect_group`,`model_no`,`producer`,`capacity`,`run_no`,`run_date`,`production_date`,`production_no`,`instrument_ids`,`instrument_names`,`test_date`,`status`,`conclusion`,`remark`,`add_userid`,`add_username`,`addtime`,`edit_userid`,`edit_username`,`edittime`) values (1,10092998,1,'变压器',NULL,'15','40','220kV',NULL,'YNyn0d11','SFSZ10-150000/220','广州维奥伊林变压器有限公司','/','/','/','2006-10','005015','2,5','A1-6000（F型）抗干扰介质损耗测量 单臂电桥','2019年03月11日','1','合格','备注',NULL,NULL,NULL,NULL,NULL,NULL),(2,10092910,1,'变压器',NULL,'15','40','220kV',NULL,'YNyn0d11','SFSZ10-150000/220','广州维奥伊林变压器有限公司','/','/','/','2006-10','005015','2,5','A1-6000（F型）抗干扰介质损耗测量 单臂电桥','2019年03月11日','1','合格','备注',NULL,NULL,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `power_substation` */

DROP TABLE IF EXISTS `power_substation`;

CREATE TABLE `power_substation` (
  `substation_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '变电站id',
  `substation_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '变电站名称',
  `substation_level` char(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '变电站等级（备用）',
  `remark` varchar(100) COLLATE utf8mb4_bin DEFAULT '' COMMENT '备注',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加者id',
  `add_username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '添加者姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `edit_username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改者姓名',
  `edittime` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`substation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='变电站信息表';

/*Data for the table `power_substation` */

LOCK TABLES `power_substation` WRITE;

insert  into `power_substation`(`substation_id`,`substation_name`,`substation_level`,`remark`,`add_userid`,`add_username`,`addtime`,`edit_userid`,`edit_username`,`edittime`) values (1,'澶都变电站','1','',NULL,'system',NULL,NULL,NULL,NULL),(2,'朝阳变电站','2','',NULL,'system',NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `power_sys_config` */

DROP TABLE IF EXISTS `power_sys_config`;

CREATE TABLE `power_sys_config` (
  `id` bigint(6) unsigned NOT NULL AUTO_INCREMENT COMMENT '配置表主键',
  `kname` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '配置名',
  `kval` mediumtext COLLATE utf8mb4_bin NOT NULL COMMENT '配置值',
  `act_id` int(10) unsigned DEFAULT '0' COMMENT '操作人ID',
  `remark` varchar(100) COLLATE utf8mb4_bin DEFAULT '' COMMENT '备注',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加者id',
  `add_username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '添加者姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `edit_username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改者姓名',
  `edittime` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  KEY `idx_kname` (`kname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='配置表（备用）';

/*Data for the table `power_sys_config` */

LOCK TABLES `power_sys_config` WRITE;

UNLOCK TABLES;

/*Table structure for table `power_sys_dic` */

DROP TABLE IF EXISTS `power_sys_dic`;

CREATE TABLE `power_sys_dic` (
  `id` mediumint(6) unsigned NOT NULL AUTO_INCREMENT COMMENT '字典表主键-自增',
  `type` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '字典类型',
  `code` varchar(10) COLLATE utf8mb4_bin NOT NULL COMMENT '码值',
  `value` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '字典值',
  `remark` varchar(100) COLLATE utf8mb4_bin DEFAULT '' COMMENT '备注',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加者id',
  `add_username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '添加者姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `edit_username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改者姓名',
  `edittime` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典表';

/*Data for the table `power_sys_dic` */

LOCK TABLES `power_sys_dic` WRITE;

UNLOCK TABLES;

/*Table structure for table `power_sys_user` */

DROP TABLE IF EXISTS `power_sys_user`;

CREATE TABLE `power_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `nickname` varchar(100) COLLATE utf8mb4_bin DEFAULT '' COMMENT '昵称',
  `icon` varchar(100) COLLATE utf8mb4_bin DEFAULT '' COMMENT '用户图标',
  `sex` int(4) unsigned DEFAULT '0' COMMENT '性别 默认0 男 1，女 2',
  `phone` char(11) COLLATE utf8mb4_bin DEFAULT '' COMMENT '手机',
  `email` char(30) COLLATE utf8mb4_bin DEFAULT '' COMMENT '邮箱',
  `lastip` char(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '最后登录IP',
  `lasttime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `regip` char(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '注册IP',
  `regtime` datetime DEFAULT NULL COMMENT '注册时间',
  `login_error_num` smallint(5) unsigned DEFAULT '0' COMMENT '登录错误次数',
  `is_sysadmin` int(1) unsigned DEFAULT '0' COMMENT '是否系统管理员 0否 1是',
  `is_duty_person` int(1) unsigned DEFAULT '0' COMMENT '是否是试验负责人 0：否 1：是',
  `status` int(1) unsigned DEFAULT '1' COMMENT '状态  1启用  2禁用 3已删除',
  `remark` varchar(100) COLLATE utf8mb4_bin DEFAULT '' COMMENT '备注',
  `add_userid` int(11) DEFAULT NULL COMMENT '添加者id',
  `add_username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '添加者姓名',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `edit_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `edit_username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改者姓名',
  `edittime` datetime DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

/*Data for the table `power_sys_user` */

LOCK TABLES `power_sys_user` WRITE;

insert  into `power_sys_user`(`id`,`username`,`password`,`nickname`,`icon`,`sex`,`phone`,`email`,`lastip`,`lasttime`,`regip`,`regtime`,`login_error_num`,`is_sysadmin`,`is_duty_person`,`status`,`remark`,`add_userid`,`add_username`,`addtime`,`edit_userid`,`edit_username`,`edittime`) values (12,'张飞','123456','小飞子','',0,'','','0:0:0:0:0:0:0:1',NULL,'',NULL,0,0,0,1,'',NULL,NULL,NULL,NULL,NULL,NULL),(13,'赵云','123456','云','',0,'','','',NULL,'',NULL,0,0,0,1,'',NULL,NULL,NULL,NULL,NULL,NULL),(14,'项羽','123456','霸王','',0,'','','',NULL,'',NULL,0,0,0,1,'',NULL,NULL,NULL,NULL,NULL,NULL),(15,'黄忠','123456','炮台','',0,'','','',NULL,'',NULL,0,0,0,1,'',NULL,NULL,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
