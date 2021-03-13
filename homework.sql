/*
Navicat MySQL Data Transfer

Source Server         : 39.106.109.103
Source Server Version : 80016
Source Host           : 39.106.109.103:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-03-13 12:08:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `depart` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `admin_depart` (`depart`),
  CONSTRAINT `admin_depart` FOREIGN KEY (`depart`) REFERENCES `depart` (`name`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cron
-- ----------------------------
DROP TABLE IF EXISTS `cron`;
CREATE TABLE `cron` (
  `cron_id` varchar(30) NOT NULL,
  `cron` varchar(30) NOT NULL,
  PRIMARY KEY (`cron_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for depart
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart` (
  `no` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`name`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `no` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` smallint(6) DEFAULT NULL,
  `depart` varchar(10) NOT NULL,
  `teacher` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '导师',
  `team` int(10) unsigned DEFAULT NULL COMMENT '所属课题组',
  `mobile` char(15) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `student_depart` (`depart`),
  KEY `student_teacher` (`teacher`),
  KEY `student_group` (`team`),
  CONSTRAINT `student_depart` FOREIGN KEY (`depart`) REFERENCES `depart` (`name`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `student_teacher` FOREIGN KEY (`teacher`) REFERENCES `teacher` (`no`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `student_team` FOREIGN KEY (`team`) REFERENCES `team` (`no`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stu_achive
-- ----------------------------
DROP TABLE IF EXISTS `stu_achive`;
CREATE TABLE `stu_achive` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `student` varchar(15) NOT NULL,
  `content` varchar(20) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `info` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `achive_student` (`student`),
  CONSTRAINT `achive_student` FOREIGN KEY (`student`) REFERENCES `student` (`no`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stu_task
-- ----------------------------
DROP TABLE IF EXISTS `stu_task`;
CREATE TABLE `stu_task` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `student` char(15) NOT NULL,
  `content` varchar(30) NOT NULL,
  `starttime` date NOT NULL,
  `endtime` date DEFAULT NULL,
  `schedule` varchar(20) DEFAULT NULL,
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `isread` varchar(10) DEFAULT NULL,
  `suggest` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `basic_index` (`student`,`starttime`) USING BTREE,
  CONSTRAINT `task_student` FOREIGN KEY (`student`) REFERENCES `student` (`no`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `no` char(15) NOT NULL,
  `name` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` smallint(6) DEFAULT NULL,
  `title` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职称',
  `depart` varchar(10) NOT NULL,
  `mobile` char(15) DEFAULT NULL,
  `info` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个人介绍',
  PRIMARY KEY (`no`),
  KEY `teacher_depart` (`depart`),
  CONSTRAINT `teacher_depart` FOREIGN KEY (`depart`) REFERENCES `depart` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teach_achive
-- ----------------------------
DROP TABLE IF EXISTS `teach_achive`;
CREATE TABLE `teach_achive` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `teacher` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `info` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `achive_teacher` (`teacher`),
  CONSTRAINT `achive_teacher` FOREIGN KEY (`teacher`) REFERENCES `teacher` (`no`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `no` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `labor` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属实验室',
  `teacher` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`no`),
  KEY `group_teacher` (`teacher`),
  CONSTRAINT `group_teacher` FOREIGN KEY (`teacher`) REFERENCES `teacher` (`no`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for team_task
-- ----------------------------
DROP TABLE IF EXISTS `team_task`;
CREATE TABLE `team_task` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `team` int(10) unsigned NOT NULL,
  `content` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `starttime` date NOT NULL,
  `endtime` date DEFAULT NULL,
  `schedule` varchar(20) DEFAULT NULL,
  `state` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `isread` varchar(5) DEFAULT NULL,
  `suggest` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `basic_index` (`team`,`starttime`,`id`) USING BTREE,
  CONSTRAINT `task_time` FOREIGN KEY (`team`) REFERENCES `team` (`no`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for team_teacher
-- ----------------------------
DROP TABLE IF EXISTS `team_teacher`;
CREATE TABLE `team_teacher` (
  `team` int(10) unsigned NOT NULL,
  `teacher` char(15) NOT NULL,
  KEY `t` (`teacher`),
  KEY `g` (`team`),
  CONSTRAINT `g` FOREIGN KEY (`team`) REFERENCES `team` (`no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t` FOREIGN KEY (`teacher`) REFERENCES `teacher` (`no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for group_statistics
-- ----------------------------
DROP VIEW IF EXISTS `group_statistics`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY INVOKER VIEW `group_statistics` AS select `team`.`name` AS `name`,count(distinct `student`.`no`) AS `student_num`,count(distinct `team_teacher`.`teacher`) AS `teacher_num` from ((`team` join `student`) join `team_teacher`) where ((`team`.`no` = `student`.`team`) and (`team`.`no` = `team_teacher`.`team`)) group by `team`.`no` ;

-- ----------------------------
-- View structure for stu_statistic
-- ----------------------------
DROP VIEW IF EXISTS `stu_statistic`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY INVOKER VIEW `stu_statistic` AS select `student`.`depart` AS `name`,count(0) AS `student_num` from `student` group by `student`.`depart` ;

-- ----------------------------
-- View structure for teacher_statistic
-- ----------------------------
DROP VIEW IF EXISTS `teacher_statistic`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY INVOKER VIEW `teacher_statistic` AS select `teacher`.`depart` AS `name`,count(0) AS `teacher_num` from `teacher` group by `teacher`.`depart` ;

-- ----------------------------
-- Procedure structure for UPDATE_STUTASK_STATE
-- ----------------------------
DROP PROCEDURE IF EXISTS `UPDATE_STUTASK_STATE`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_STUTASK_STATE`()
BEGIN

	DECLARE END_TIME DATE;
	DECLARE START_TIME DATE;
	DECLARE STU CHAR(15);
	DECLARE STA CHAR(5);
	DECLARE V_FINISHED INT DEFAULT 0;
	DECLARE TODAY DATE DEFAULT CURDATE();

	DECLARE CUR CURSOR FOR
	SELECT student,state,starttime,endtime FROM stu_task;
	
	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET V_FINISHED = 1;
	
	OPEN CUR;
	
	UPDATESTATE:LOOP
	FETCH CUR INTO STU,STA,START_TIME,END_TIME;
	
	IF V_FINISHED = 1 THEN
	LEAVE UPDATESTATE;
	END IF;
	
	IF END_TIME < TODAY AND STA<>'任务已完成' AND STA<>'废弃' THEN
	UPDATE stu_task 
	SET state='超时未完成'
	WHERE student=STU AND starttime=START_TIME;

	ELSE IF START_TIME > TODAY AND STA<>'任务已完成' AND STA<>'废弃' THEN
	UPDATE stu_task 
	SET state='任务未开始'
	WHERE student=STU AND starttime=START_TIME;

	ELSE IF TODAY BETWEEN START_TIME AND END_TIME AND STA<>'任务已完成' AND STA<>'废弃' THEN
	UPDATE stu_task 
	SET state='任务进行中'
	WHERE student=STU AND starttime=START_TIME;
	END IF;
	END IF;
	END IF;

	END LOOP UPDATESTATE;
	CLOSE CUR;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for UPDATE_TEAMTASK_STATE
-- ----------------------------
DROP PROCEDURE IF EXISTS `UPDATE_TEAMTASK_STATE`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_TEAMTASK_STATE`()
BEGIN
	DECLARE END_TIME DATE;
	DECLARE START_TIME DATE;
	DECLARE TEAM_ CHAR(15);
	DECLARE STA CHAR(5);
	DECLARE V_FINISHED INT DEFAULT 0;
	DECLARE TODAY DATE DEFAULT CURDATE();

	DECLARE CUR CURSOR FOR
	SELECT team,state,starttime,endtime FROM team_task;
	
	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET V_FINISHED = 1;
	
	OPEN CUR;
	
	UPDATESTATE:LOOP
	FETCH CUR INTO TEAM_,STA,START_TIME,END_TIME;
	
	IF V_FINISHED = 1 THEN
	LEAVE UPDATESTATE;
	END IF;
	
	IF END_TIME < TODAY AND STA<>'任务已完成' AND STA<>'废弃' THEN
	UPDATE team_task 
	SET state='超时未完成'
	WHERE team=TEAM_ AND starttime=START_TIME;

	ELSE IF START_TIME > TODAY AND STA<>'任务已完成' AND STA<>'废弃' THEN
	UPDATE team_task 
	SET state='任务未开始'
	WHERE team=TEAM_ AND starttime=START_TIME;

	ELSE IF TODAY BETWEEN START_TIME AND END_TIME AND STA<>'任务已完成' AND STA<>'废弃' THEN
	UPDATE team_task 
	SET state='任务进行中'
	WHERE team=TEAM_ AND starttime=START_TIME;
	END IF;
	END IF;
	END IF;

	END LOOP UPDATESTATE;
	CLOSE CUR;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `INIT_CODE`;
DELIMITER ;;
CREATE TRIGGER `INIT_CODE` BEFORE INSERT ON `student` FOR EACH ROW begin
SET new.password=NEW.no;
end
;;
DELIMITER ;
