drop database  if exists lapd_test;
create database lapd_test;

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_admin` (
  `id` INT NOT NULL COMMENT '主键ID',
  `userName` VARCHAR(15) NOT NULL COMMENT '用户名称',
  `password` VARCHAR(15) NOT NULL COMMENT '密码',
  `registerTime` TIMESTAMP NOT NULL COMMENT '注册时间',
  `avatar` VARCHAR(255) NULL COMMENT '头像，存储头像的文件路径',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idadmin_UNIQUE` (`userName` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

--drop table `lapd_test`.`t_user`;

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_user` (
  `id` INT NOT NULL,
  `userName` VARCHAR(45) NOT NULL COMMENT '员工编号',
  `password` VARCHAR(45) NOT NULL COMMENT '员工密码',
  `workId` INT(11) NULL COMMENT '员工的工作id',
  `birthday` DATE NULL COMMENT '出生日期',
  `telephonePhone` VARCHAR(15) NULL DEFAULT NULL COMMENT '电话号码',
  `email` VARCHAR(20) NULL COMMENT '电子邮件',
  `address` VARCHAR(200) NULL DEFAULT NULL COMMENT '地址',
  `avatar` VARCHAR(255) NULL COMMENT '头像图片路径',
  `question` VARCHAR(20) NOT NULL COMMENT '密保问题',
  `answer` VARCHAR(100) NOT NULL COMMENT '密保答案',
  `workStatus` INT NULL DEFAULT NULL,
  `registerTime` TIMESTAMP NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`workId` ASC),
  INDEX `workStatus_idx` (`workStatus` ASC),
  UNIQUE INDEX `idUser_UNIQUE` (`userName` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `UserworkStatus`
    FOREIGN KEY (`workStatus`)
    REFERENCES `lapd_test`.`t_workstatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

--desc `lapd_test`.`t_user`;

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_roomcategory` (
  `id` INT NOT NULL  COMMENT '序号',
  `roomcategory` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `roomcategory_UNIQUE` (`roomcategory` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

--drop table t_room;

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_room` (
  `id` INT NOT NULL COMMENT '主键',
  `name` VARCHAR(10) NOT NULL COMMENT '房间编号',
  `roomCategory` INT NOT NULL COMMENT '房间名字',
  `floor` INT NOT NULL,
  `size` INT NOT NULL COMMENT '房间可容纳客人的人数',
  `remark` VARCHAR(255) NULL DEFAULT NULL COMMENT '房间描述',
  `addTime` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `name_idx` (`roomCategory` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  CONSTRAINT `name`
    FOREIGN KEY (`roomCategory`)
    REFERENCES `lapd_test`.`t_roomcategory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_clockcategory` (
  `id` INT NOT NULL COMMENT '序号',
  `clockcategory` VARCHAR(20) NOT NULL COMMENT '上钟类型',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`clockcategory` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8


CREATE TABLE IF NOT EXISTS `lapd_test`.`t_paypath` (
  `id` INT NOT NULL COMMENT '主键',
  `payPath` VARCHAR(20) NULL COMMENT '支付方式',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `payPath_UNIQUE` (`payPath` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_orderstatus` (
  `id` INT NOT NULL COMMENT '序号',
  `orderstatus` VARCHAR(20) NULL COMMENT '订单类型',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `orderstatus_UNIQUE` (`orderstatus` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `lapd_test`.`workrank` (
  `id` INT NOT NULL,
  `stuffId` INT(11) NOT NULL COMMENT '员工的工作牌号\n',
  `rankNum` INT(11) NULL DEFAULT '0' COMMENT '排钟数量',
  `spotNum` INT(11) NULL DEFAULT '0' COMMENT '点钟数量',
  INDEX `id_user_idx` (`stuffId` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `id_user`
    FOREIGN KEY (`stuffId`)
    REFERENCES `lapd_test`.`t_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8


CREATE TABLE IF NOT EXISTS `lapd_test`.`t_workrank` (
  `id` INT NOT NULL,
  `rank` INT NOT NULL COMMENT '排名序号',
  `stuffId` INT(11) NOT NULL COMMENT '员工的工作牌号\n',
  `rankNum` INT(11) NULL DEFAULT '0' COMMENT '排钟数量',
  `spotNum` INT(11) NULL DEFAULT '0' COMMENT '点钟数量',
  INDEX `id_user_idx` (`stuffId` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `rank_UNIQUE` (`rank` ASC),
  CONSTRAINT `id_user`
    FOREIGN KEY (`stuffId`)
    REFERENCES `lapd_test`.`t_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
