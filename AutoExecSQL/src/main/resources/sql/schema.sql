DROP TABLE IF EXISTS `sys_action`;
CREATE TABLE `sys_action` (
                              `action_id` varchar(64) NOT NULL COMMENT '编号',
                              `action_code` varchar(64) DEFAULT NULL,
                              `action_name` varchar(64) DEFAULT NULL,
                              `service_id` varchar(64) DEFAULT NULL,
                              `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
                              `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                              `create_time` datetime NOT NULL COMMENT '创建时间',
                              `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
                              `update_time` datetime NOT NULL COMMENT '更新时间',
                              `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
                              PRIMARY KEY (`action_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作表';