
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username_uindex` (`username`)
) ;

INSERT INTO `user` VALUES (1,'郭靖','男',38,'湖北省武汉市','212223390','guojing@qq.com','guojing','123456'),(3,'黄蓉','女',28,'湖北省襄阳市','212223390','huangrong@qq.com','huangrong','123456'),(4,'黄老邪','男',58,'湖北省武汉市','212223390','huanglaoxie@qq.com','huanglaoxie','123456'),(6,'小龙女','男',18,'湖北省荆门市','212223390','xiaolongnv@qq.com','xiaolongnv','123456');

