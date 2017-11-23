drop database  if exists lapd_test;
create database lapd_test;

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_admin` (
  `id` INT NOT NULL COMMENT '����ID',
  `userName` VARCHAR(15) NOT NULL COMMENT '�û�����',
  `password` VARCHAR(15) NOT NULL COMMENT '����',
  `registerTime` TIMESTAMP NOT NULL COMMENT 'ע��ʱ��',
  `avatar` VARCHAR(255) NULL COMMENT 'ͷ�񣬴洢ͷ����ļ�·��',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idadmin_UNIQUE` (`userName` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

--drop table `lapd_test`.`t_user`;

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_user` (
  `id` INT NOT NULL,
  `userName` VARCHAR(45) NOT NULL COMMENT 'Ա�����',
  `password` VARCHAR(45) NOT NULL COMMENT 'Ա������',
  `workId` INT(11) NULL COMMENT 'Ա���Ĺ���id',
  `birthday` DATE NULL COMMENT '��������',
  `telephonePhone` VARCHAR(15) NULL DEFAULT NULL COMMENT '�绰����',
  `email` VARCHAR(20) NULL COMMENT '�����ʼ�',
  `address` VARCHAR(200) NULL DEFAULT NULL COMMENT '��ַ',
  `avatar` VARCHAR(255) NULL COMMENT 'ͷ��ͼƬ·��',
  `question` VARCHAR(20) NOT NULL COMMENT '�ܱ�����',
  `answer` VARCHAR(100) NOT NULL COMMENT '�ܱ���',
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
  `id` INT NOT NULL  COMMENT '���',
  `roomcategory` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `roomcategory_UNIQUE` (`roomcategory` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

--drop table t_room;

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_room` (
  `id` INT NOT NULL COMMENT '����',
  `name` VARCHAR(10) NOT NULL COMMENT '������',
  `roomCategory` INT NOT NULL COMMENT '��������',
  `floor` INT NOT NULL,
  `size` INT NOT NULL COMMENT '��������ɿ��˵�����',
  `remark` VARCHAR(255) NULL DEFAULT NULL COMMENT '��������',
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
  `id` INT NOT NULL COMMENT '���',
  `clockcategory` VARCHAR(20) NOT NULL COMMENT '��������',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`clockcategory` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8


CREATE TABLE IF NOT EXISTS `lapd_test`.`t_paypath` (
  `id` INT NOT NULL COMMENT '����',
  `payPath` VARCHAR(20) NULL COMMENT '֧����ʽ',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `payPath_UNIQUE` (`payPath` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `lapd_test`.`t_orderstatus` (
  `id` INT NOT NULL COMMENT '���',
  `orderstatus` VARCHAR(20) NULL COMMENT '��������',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `orderstatus_UNIQUE` (`orderstatus` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `lapd_test`.`workrank` (
  `id` INT NOT NULL,
  `stuffId` INT(11) NOT NULL COMMENT 'Ա���Ĺ����ƺ�\n',
  `rankNum` INT(11) NULL DEFAULT '0' COMMENT '��������',
  `spotNum` INT(11) NULL DEFAULT '0' COMMENT '��������',
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
  `rank` INT NOT NULL COMMENT '�������',
  `stuffId` INT(11) NOT NULL COMMENT 'Ա���Ĺ����ƺ�\n',
  `rankNum` INT(11) NULL DEFAULT '0' COMMENT '��������',
  `spotNum` INT(11) NULL DEFAULT '0' COMMENT '��������',
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
