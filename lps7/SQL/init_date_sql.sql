
	insert into `lapd_test`.`t_clockcategory` (id, clockcategory) values(1, "点钟");
	insert into `lapd_test`.`t_clockcategory` (id, clockcategory) values(2, "排钟");

        
    insert into `lapd_test`.`t_roomcategory`(id, roomcategory ) values (1, "洗脚");
    insert into `lapd_test`.`t_roomcategory`(id, roomcategory ) values (2, "按摩");
    insert into `lapd_test`.`t_roomcategory`(id, roomcategory ) values (3, "澡堂");
      

	insert into `lapd_test`.`t_room` (id , name, roomcategory, floor, size, remark, addTime, isFree, isClean)
		values(1, "101",1, 1, 2, null, now(), true, true);
	insert into `lapd_test`.`t_room` (id , name, roomcategory, floor, size, remark, addTime, isFree, isClean)
		values(2, "201",1, 2, 3, null, now(), true, true);
	insert into `lapd_test`.`t_room` (id , name, roomcategory, floor, size, remark, addTime, isFree, isClean)
		values(3, "202",2, 2, 2, null, now(), true, true);
	insert into `lapd_test`.`t_room` (id , name, roomcategory, floor, size, remark, addTime, isFree, isClean)
		values(4, "204",2, 2, 2, null, now(), true, true);
        
        
	insert into `lapd_test`.`t_orderstatus` (id, orderstatus) values(1, "待接收");
	insert into `lapd_test`.`t_orderstatus` (id, orderstatus) values(2, "工作中");
	insert into `lapd_test`.`t_orderstatus` (id, orderstatus) values(3, "待付款");
	insert into `lapd_test`.`t_orderstatus` (id, orderstatus) values(4, "支付完成");
	insert into `lapd_test`.`t_orderstatus` (id, orderstatus) values(5, "挂起");
	insert into `lapd_test`.`t_orderstatus` (id, orderstatus) values(6, "无效");
	
    insert into `lapd_test`.`t_workstatus`(id , workStatus) values(1, "空闲");
    insert into `lapd_test`.`t_workstatus`(id , workStatus) values(2, "待接收");
    insert into `lapd_test`.`t_workstatus`(id , workStatus) values(3, "工作中");
    
    INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (1, 'user001', 'password', 11, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '王昭君', '13624612546845416581152');
        
    INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (2, 'user002', 'password', 12, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '张三', '1362461254681455581152');
        
    INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (3, 'user003', 'password', 13, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '金珂', '13624612546845456581152');
        
    INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (4, 'user004', 'password', 14, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '安其拉', '13624612546848556581152');
        
    INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (5, 'user005', 'password', 15, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '典韦', '1362461254681456581152');
    
        INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (6, 'user006', 'password', 13, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '金珂', '13624612546845456581152');
        
    INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (7, 'user007', 'password', 14, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '安其拉', '13624612546848556581152');
        
    INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (8, 'user008', 'password', 15, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '典韦', '1362461254681456581152');
    
        INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (9, 'user009', 'password', 15, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '典韦', '1362461254681456581152');
    
        INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (10, 'user010', 'password', 13, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '金珂', '13624612546845456581152');
        
    INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (11, 'user011', 'password', 14, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '安其拉', '13624612546848556581152');
        
    INSERT INTO `lapd_test`.`t_user` (`id`, `userName`, `password`, `workId`, `birthday`, `telephonePhone`, `email`, `address`, `avatar`, `question`, `answer`, `workStatus`, `registerTime`, `realName`, `IDCardNo`) 
    VALUES (12, 'user012', 'password', 15, '1996-10-1', '13672245662', '1561684155@qq.com', '南昌航空大学', NULL, '你是谁', '0001', 1, now(), '典韦', '1362461254681456581152');
    
    

   INSERT INTO `lapd_test`.`t_workrank` (`id`, `rank`, `stuffId`, `rankNum`, `spotNum`) 
   VALUES (1, 1, 1, null, NULL);
   INSERT INTO `lapd_test`.`t_workrank` (`id`, `rank`, `stuffId`, `rankNum`, `spotNum`) 
   VALUES (2, 2, 2, null, NULL);
   INSERT INTO `lapd_test`.`t_workrank` (`id`, `rank`, `stuffId`, `rankNum`, `spotNum`) 
   VALUES (3, 3, 3, null, NULL);
   INSERT INTO `lapd_test`.`t_workrank` (`id`, `rank`, `stuffId`, `rankNum`, `spotNum`) 
   VALUES (4, 4, 4, null, NULL);
   INSERT INTO `lapd_test`.`t_workrank` (`id`, `rank`, `stuffId`, `rankNum`, `spotNum`) 
   VALUES (5, 5, 5, null, NULL);
        
   insert into `lapd_test`.`t_pledge` (id, name, price ) values (1, "苹果充电器", 50);
   insert into `lapd_test`.`t_pledge` (id, name, price ) values (2, "安卓充电器", 50);
   insert into `lapd_test`.`t_pledge` (id, name, price ) values (3, "其他", 50);
        
    insert into  `lapd_test`.`t_paypath` (id, payPath) values(1, "支付宝");
    insert into  `lapd_test`.`t_paypath` (id, payPath) values(2, "微信");
    insert into  `lapd_test`.`t_paypath` (id, payPath) values(3, "现金");
    insert into  `lapd_test`.`t_paypath` (id, payPath) values(4, "银联");
    
    INSERT INTO `lapd_test`.`t_admin` (`id`, `userName`, `password`, `registerTime`, `avatar`) 
    VALUES (1, 'admin', 'admin', now(), NULL);
    
    INSERT INTO `lapd_test`.`t_admin` (`id`, `userName`, `password`, `registerTime`, `avatar`) 
    VALUES (2, 'admin2', 'admin', now(), NULL);
    
    INSERT INTO `lapd_test`.`t_admin` (`id`, `userName`, `password`, `registerTime`, `avatar`) 
    VALUES (3, 'admin3', 'admin', now(), NULL);
    
    INSERT INTO `lapd_test`.`t_admin` (`id`, `userName`, `password`, `registerTime`, `avatar`) 
    VALUES (4, 'admin4', 'admin', now(), NULL);
    
   -- delete from `lapd_test`.`t_serverorder`;
    
    INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000001', 1, 1, 1, 1, 1, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
    INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000002', 1, 1, 1, 1, 1, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
    INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000003', 1, 1, 1, 1, 1, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
    INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000004', 1, 1, 1, 1, 1, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
    INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000005', 1, 1, 1, 1, 1, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
    INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000006', 1, 1, 1, 1, 1, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
    INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000007', 1, 1, 1, 1, 1, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
     
     INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000008', 2, 2, 2, 2, 2, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
     INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000009', 2, 2, 2, 2, 2, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
     INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000010', 2, 2, 2, 2, 2, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
     INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000011', 2, 2, 2, 2, 2, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
     INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000012', 2, 2, 2, 2, 2, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
     INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000013', 2, 2, 2, 2, 2, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
     INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000014', 2, 2, 2, 2, 2, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
     INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`, 
    `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000015', 2, 2, 2, 2, 2, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL);
     
     
INSERT INTO `lapd_test`.`t_serverorder` (`idOrder`, `stuffId`, `roomId`, `statusId`, `clockcategoryId`, `payPathId`,
  `pledgeNameId`, `initTime`, `receiveTime`, `finishTime`, `pay`, `realPay`, `payTime`, `orderRemark`)
     VALUES ('000000000000050' + count1, 2, 2, count1 % 6 + 1, 2, 2, NULL, now(), NULL, NULL, NULL, NULL, NULL, NULL); 

     
select  * from `lapd_test`.`t_serverorder`;
    
select  * from `lapd_test`.`t_orderstatus`;
    
select * from `lapd_test`.`t_room`;

select * from `lapd_test`.`t_roomcategory`;
    
select * from `lapd_test`.`t_workStatus`;
    
select  * from `lapd_test`.`t_user`;
    
select  * from `lapd_test`.`t_pledge`; 
 
select *  from `lapd_test`.`t_paypath`;

select * from `lapd_test`.`t_clockcategory`;

select * from `lapd_test`.`t_admin`;



