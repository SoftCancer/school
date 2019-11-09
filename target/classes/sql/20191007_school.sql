/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.102
Source Server Version : 50719
Source Host           : 192.168.1.102:3306
Source Database       : school

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-10-07 16:45:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_access_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_access_permission`;
CREATE TABLE `sys_access_permission` (
  `ID` varchar(32) NOT NULL COMMENT '访问权限表',
  `URL` varchar(50) DEFAULT NULL COMMENT '访问链接',
  `ROLES` varchar(255) DEFAULT NULL COMMENT '角色列表用,分割',
  `SORT` int(11) DEFAULT NULL COMMENT '排序号',
  `IS_DELETED` int(2) DEFAULT NULL COMMENT '是否删除',
  `CREATE_USER` varchar(32) DEFAULT NULL COMMENT '创建用户',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` varchar(50) DEFAULT NULL COMMENT '更新用户',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_request_url` (`URL`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_access_permission
-- ----------------------------
INSERT INTO `sys_access_permission` VALUES ('1', '/', 'anon', '1', '0', 'admin', '2017-12-25 16:41:02', 'admin', '2017-12-25 16:41:02');
INSERT INTO `sys_access_permission` VALUES ('2', '/index', 'anon', '2', '0', 'admin', '2017-12-25 16:41:08', 'admin', '2017-12-25 16:41:08');
INSERT INTO `sys_access_permission` VALUES ('3', '/login', 'anon', '3', '0', 'admin', '2017-12-25 16:41:08', 'admin', '2017-12-25 16:41:08');
INSERT INTO `sys_access_permission` VALUES ('4', '/role/*', 'authc,roles[admin]', '5', '0', 'admin', '2017-12-25 16:41:08', 'admin', '2017-12-25 16:41:08');
INSERT INTO `sys_access_permission` VALUES ('5', '/getVCode', 'anon', '4', '0', 'admin', '2017-12-25 16:41:09', 'admin', '2017-12-25 16:41:09');
INSERT INTO `sys_access_permission` VALUES ('6', '/**/*.do', 'authc', '999', '0', 'admin', '2017-12-25 16:41:09', 'admin', '2017-12-25 16:41:09');
INSERT INTO `sys_access_permission` VALUES ('6319f8a7688343139ac4ba0d40877e2c', 'sys/*', 'authc,roles[test,admin]', '201', '0', 'gameloft9', '2017-12-28 11:04:58', null, '2017-12-28 11:04:58');
INSERT INTO `sys_access_permission` VALUES ('7042e4eeebf5433388ddfdfb09764369', 'log/*', 'authc,roles[test,admin]', '419', '0', 'gameloft9', '2017-12-27 17:04:10', null, '2017-12-27 17:04:10');
INSERT INTO `sys_access_permission` VALUES ('7c1f21aa63cf4fd6a5be43072e81ab99', 'test/*', 'authc,roles[test,admin]', '135', '0', 'gameloft9', '2017-12-28 11:05:10', null, '2017-12-28 11:05:10');
INSERT INTO `sys_access_permission` VALUES ('7ee176c20c904536862da37aacb0f7c8', 'org/*', 'authc,roles[test]', '123', '0', 'gameloft9', '2017-12-27 17:04:18', null, '2017-12-27 17:04:18');
INSERT INTO `sys_access_permission` VALUES ('8e68507e882c4165b06a4a9147d14a34', 'role/*', 'authc,roles[admin]', '669', '0', 'gameloft9', '2017-12-27 17:04:04', null, '2017-12-27 17:04:04');
INSERT INTO `sys_access_permission` VALUES ('90762decb8874ba0955eb8cef21b6682', 'menu/*', 'authc,roles[admin]', '197', '0', 'gameloft9', '2017-12-28 11:02:26', null, '2017-12-28 11:02:26');
INSERT INTO `sys_access_permission` VALUES ('c8c4e92a1ece4da79ede1763faecdf77', 'sysUser/*', 'authc,roles[admin]', '170', '0', 'gameloft9', '2017-12-27 17:05:49', null, '2017-12-27 17:05:49');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `ID` varchar(32) NOT NULL COMMENT '菜单表',
  `TITLE` varchar(100) NOT NULL COMMENT '菜单名称',
  `HREF` varchar(200) NOT NULL COMMENT '访问链接',
  `REQUEST_URL` varchar(200) DEFAULT NULL COMMENT '后台请求url',
  `ICON` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `CODE` varchar(100) DEFAULT NULL COMMENT '菜单编码',
  `TARGET` varchar(50) DEFAULT NULL COMMENT '目标窗口,_blank则直接跳转，否则在子页面打开',
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父菜单',
  `SORT` int(2) DEFAULT NULL COMMENT '排序号',
  `CREATE_USER` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_USER` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_title` (`TITLE`) USING BTREE,
  UNIQUE KEY `uidx_menu_req_url` (`REQUEST_URL`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1688998d013c4ebf95be6fd7e1fecb20', '测试一级菜单', '/memCard/index.do', 'test/*', 'icon-text', '2', null, null, '2', 'gameloft9', '2017-12-27 17:09:17', null, '2017-12-27 17:09:17');
INSERT INTO `sys_menu` VALUES ('244247008b53450fa16bc503bc861b7c', '系统管理', '#', 'sys/*', 'icon-text', '1', null, null, '1', 'gameloft9', '2017-12-25 19:31:22', null, '2017-12-25 19:31:22');
INSERT INTO `sys_menu` VALUES ('26b3df2c6d464a0b89858eb896b849d2', '系统用户管理', 'page/system/sysUser/allUsers.html', 'sysUser/*', 'icon-text', '1-5', null, '244247008b53450fa16bc503bc861b7c', '4', 'gameloft9', '2017-12-27 17:05:40', null, '2017-12-27 17:05:40');
INSERT INTO `sys_menu` VALUES ('4a7f3cae133e4a51b8f35769b55163dd', '菜单管理', 'page/system/sysMenu/allMenus.html', 'menu/*', 'icon-text', '1-1', null, '244247008b53450fa16bc503bc861b7c', '1', 'gameloft9', '2017-12-25 19:32:25', null, '2017-12-25 19:32:25');
INSERT INTO `sys_menu` VALUES ('882b26afbdbb4d63bcba0cd826a5b9c1', '系统日志管理', 'page/system/sysLog/allLogs.html', 'log/*', 'icon-text', '1-4', null, '244247008b53450fa16bc503bc861b7c', '5', 'gameloft9', '2017-12-27 17:03:41', null, '2017-12-27 17:03:41');
INSERT INTO `sys_menu` VALUES ('89e9f1eb41a240fea361e0d188375884', '机构管理', 'page/system/sysOrg/allOrgs.html', 'org/*', 'icon-text', '1-2', null, '244247008b53450fa16bc503bc861b7c', '3', 'gameloft9', '2017-12-27 17:01:58', null, '2017-12-27 17:01:58');
INSERT INTO `sys_menu` VALUES ('b53bfdfe33444703aa76c2c1a1b8d820', '角色管理', 'page/system/sysRole/allRoles.html', 'role/*', 'icon-text', '1-3', null, '244247008b53450fa16bc503bc861b7c', '2', 'gameloft9', '2017-12-27 17:02:42', null, '2017-12-27 17:02:42');

-- ----------------------------
-- Table structure for sys_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_role`;
CREATE TABLE `sys_menu_role` (
  `ID` varchar(32) NOT NULL,
  `MENU_ID` varchar(32) DEFAULT NULL COMMENT '菜单id',
  `ROLE_ID` varchar(32) DEFAULT NULL COMMENT '角色id',
  `CREATE_USER` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_menu_role` (`MENU_ID`,`ROLE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu_role
-- ----------------------------
INSERT INTO `sys_menu_role` VALUES ('123456789ijhg', '244247008b53450fa16bc503bc861b7c', 'J/F9-+?', null, '2017-12-26 09:46:03', null, '2017-12-26 09:46:03');
INSERT INTO `sys_menu_role` VALUES ('4523b393aae64771aac4f91c5623599b', '244247008b53450fa16bc503bc861b7c', '343859934ece44c988f53700fb34c80a', null, '2018-01-11 14:47:33', null, '2018-01-11 14:47:33');
INSERT INTO `sys_menu_role` VALUES ('5905556900e741a89aafec25948b8fca', '89e9f1eb41a240fea361e0d188375884', 'J/F9-+?', null, '2017-12-27 17:04:18', null, '2017-12-27 17:04:18');
INSERT INTO `sys_menu_role` VALUES ('5b79d6e436154cfb9533a531fb7eb744', '882b26afbdbb4d63bcba0cd826a5b9c1', '343859934ece44c988f53700fb34c80a', null, '2018-01-11 14:47:16', null, '2018-01-11 14:47:16');
INSERT INTO `sys_menu_role` VALUES ('6302f705514e4c839400f804ec29ec5c', '89e9f1eb41a240fea361e0d188375884', '343859934ece44c988f53700fb34c80a', null, '2018-01-11 14:46:55', null, '2018-01-11 14:46:55');
INSERT INTO `sys_menu_role` VALUES ('71fa522e4da04ab9abd6008d2cb1c070', '26b3df2c6d464a0b89858eb896b849d2', 'J/F9-+?', null, '2017-12-27 17:05:49', null, '2017-12-27 17:05:49');
INSERT INTO `sys_menu_role` VALUES ('874970f9c9b14021909485f201479373', '1688998d013c4ebf95be6fd7e1fecb20', 'J/F9-+?', null, '2017-12-28 11:05:10', null, '2017-12-28 11:05:10');
INSERT INTO `sys_menu_role` VALUES ('asdfr456yhbv123', '4a7f3cae133e4a51b8f35769b55163dd', 'J/F9-+?', null, '2017-12-26 09:46:29', null, '2017-12-26 09:46:29');
INSERT INTO `sys_menu_role` VALUES ('bd3b96f8742940e8acc628ff5c940465', 'b53bfdfe33444703aa76c2c1a1b8d820', 'J/F9-+?', null, '2017-12-27 17:04:03', null, '2017-12-27 17:04:03');
INSERT INTO `sys_menu_role` VALUES ('c89cc73ffa1b40da943cb542b9b9819f', '882b26afbdbb4d63bcba0cd826a5b9c1', 'J/F9-+?', null, '2017-12-27 17:04:10', null, '2017-12-27 17:04:10');
INSERT INTO `sys_menu_role` VALUES ('e92a68532e134b2e9b8af46a43ce61e0', '1688998d013c4ebf95be6fd7e1fecb20', '343859934ece44c988f53700fb34c80a', null, '2018-01-11 14:47:42', null, '2018-01-11 14:47:42');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `ID` varchar(32) NOT NULL COMMENT '应用日志表',
  `USER_ID` varchar(32) DEFAULT NULL,
  `LOGIN_NAME` varchar(32) DEFAULT NULL,
  `IP_ADDR` varchar(64) DEFAULT NULL,
  `OPER_TYPE` varchar(200) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `MEMO` varchar(1500) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES ('3ddf7674b9eb45a19b3a19422cc8351a', '123', 'admin', '127.0.0.1', 'add', '2019-06-22 14:52:15', '添加用户');
INSERT INTO `sys_oper_log` VALUES ('413c9a00f5cf47b1b95dabf67426e0a1', '123', 'admin', '127.0.0.1', 'upd', '2019-06-22 14:58:00', '初始化密码');
INSERT INTO `sys_oper_log` VALUES ('5e5b839337714d91bcbb1a4440b0d4e7', '123', 'gameloft9', '127.0.0.1', 'upd', '2019-06-22 14:41:55', '更新用户');
INSERT INTO `sys_oper_log` VALUES ('74ad67f861494325b651fdcd85dbad75', '123', 'admin', '127.0.0.1', 'upd', '2019-06-22 14:56:40', '更新个人密码');
INSERT INTO `sys_oper_log` VALUES ('896f1739e4504e468de026dbe1453691', '18269308b9e1414281574f1296c8ada2', 'gameloft9', '127.0.0.1', 'upd', '2019-06-22 14:58:42', '更新个人密码');
INSERT INTO `sys_oper_log` VALUES ('8c99d45c8ce340f08b7591f095910522', '18269308b9e1414281574f1296c8ada2', 'gameloft9', '127.0.0.1', 'upd', '2019-06-22 15:58:45', '更新个人信息');
INSERT INTO `sys_oper_log` VALUES ('ae65f656e0d043858118b319b41fda8f', '123', 'admin', '127.0.0.1', 'upd', '2019-06-22 14:55:53', '初始化密码');
INSERT INTO `sys_oper_log` VALUES ('d658e71946a24e7ab0dd1d1ce442bf26', '123', 'admin', '127.0.0.1', 'upd', '2019-06-22 14:52:35', '更新用户');
INSERT INTO `sys_oper_log` VALUES ('e54fa0472f0f44ec93a03cb8b38d3f7a', '123', 'admin', '127.0.0.1', 'upd', '2019-06-22 14:56:35', '更新个人密码');

-- ----------------------------
-- Table structure for sys_organize
-- ----------------------------
DROP TABLE IF EXISTS `sys_organize`;
CREATE TABLE `sys_organize` (
  `ID` varchar(32) NOT NULL COMMENT '组织机构表',
  `PARENT_ID` varchar(32) DEFAULT NULL,
  `ORGANIZE_NAME` varchar(255) NOT NULL COMMENT '机构名称',
  `ORGANIZE_CODE` varchar(8) NOT NULL COMMENT '机构编码',
  `TREE_LEVEL` int(11) NOT NULL COMMENT '机构级别',
  `TREE_PATH` varchar(200) DEFAULT NULL COMMENT '机构路径',
  `CREATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_org_name` (`ORGANIZE_NAME`) USING BTREE,
  UNIQUE KEY `uidx_org_code` (`ORGANIZE_CODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_organize
-- ----------------------------
INSERT INTO `sys_organize` VALUES ('21a6ff8a6abf410eaf97981c1da039d8', null, '总公司', '010001', '1', '21a6ff8a6abf410eaf97981c1da039d8', '2017-12-27 17:06:04', '2017-12-27 17:06:04');
INSERT INTO `sys_organize` VALUES ('54fa67f3d443427c9f47432ead20f2f4', '21a6ff8a6abf410eaf97981c1da039d8', '湖北分公司', '010002', '2', '21a6ff8a6abf410eaf97981c1da039d8#54fa67f3d443427c9f47432ead20f2f4', '2017-12-27 17:06:22', '2017-12-27 17:06:22');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` varchar(32) NOT NULL COMMENT '角色表',
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色名',
  `IS_SUPER` int(2) DEFAULT NULL COMMENT '是否是超级管理员',
  `IS_DELETED` int(2) DEFAULT NULL COMMENT '是否删除',
  `CREATE_USER` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` varchar(50) DEFAULT NULL COMMENT '更新用户',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('343859934ece44c988f53700fb34c80a', 'test', '0', '0', 'gameloft9', '2018-01-11 14:46:22', null, '2018-01-11 14:46:22');
INSERT INTO `sys_role` VALUES ('J/F9-+?', 'admin', '1', '0', 'v[l_4zL8', '2008-03-01 04:17:00', ':9He2+GW', '2002-09-27 03:13:16');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` varchar(32) NOT NULL COMMENT '用户测试表',
  `LOGIN_NAME` varchar(10) DEFAULT NULL,
  `PASSWORD` varchar(128) DEFAULT NULL,
  `REAL_NAME` varchar(50) DEFAULT NULL,
  `IS_FORBIDDEN` varchar(2) DEFAULT NULL,
  `MOBILE` varchar(11) DEFAULT NULL,
  `ICON` varchar(200) DEFAULT NULL,
  `ORG_ID` varchar(32) DEFAULT NULL,
  `ORG_NAME` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_login_name` (`LOGIN_NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('123', 'admin', '123456', 'Albert', '0', '13618629441', null, 'gameloft9', '总公司', '2019-10-07 08:43:08', '2019-10-07 08:43:08');
INSERT INTO `sys_user` VALUES ('18269308b9e1414281574f1296c8ada2', 'gameloft9', '7C4A8D09CA3762AF61E59520943DC26494F8941B', 'Albert', '0', '13223078433', null, 'gameloft9', '湖北分公司', '2019-06-22 14:57:25', null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ID` varchar(32) NOT NULL COMMENT '用户角色表',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `ROLE_ID` varchar(32) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('03f9afb1d42e49d6a026f537d9f033b6', '9dbdc3a6cc444190bb5ac4e15df6234b', '343859934ece44c988f53700fb34c80a');
INSERT INTO `sys_user_role` VALUES ('8d3113049075468db079b1c2075bcd2d', '123', 'J/F9-+?');
INSERT INTO `sys_user_role` VALUES ('9ec665cb26384bad9de494a35a9352e6', '18269308b9e1414281574f1296c8ada2', 'J/F9-+?');
