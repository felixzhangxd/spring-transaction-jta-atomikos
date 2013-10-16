 DROP SCHEMA spring_transaction_master;
 CREATE SCHEMA IF NOT EXISTS spring_transaction_master DEFAULT CHARACTER SET utf8;
 USE spring_transaction_master;
 CREATE TABLE IF NOT EXISTS `user` (
 `id` int(10) auto_increment,
 `username` varchar(12) DEFAULT NULL,
 `password` varchar(12) DEFAULT NULL,
 `birthday` date DEFAULT NULL,
 PRIMARY KEY(id))
 ENGINE=InnoDB DEFAULT CHARSET=utf8;
 GRANT ALL ON spring_transaction_master.* TO 'master'@'127.0.0.1' IDENTIFIED BY 'master';

 DROP SCHEMA spring_transaction_slave;
 CREATE SCHEMA IF NOT EXISTS spring_transaction_slave DEFAULT CHARACTER SET utf8;
 USE spring_transaction_slave;
 CREATE TABLE IF NOT EXISTS `user` (
 `id` int(10) auto_increment,
 `username` varchar(12) DEFAULT NULL,
 `password` varchar(12) DEFAULT NULL,
 `birthday` date DEFAULT NULL,
 PRIMARY KEY(id))
 ENGINE=InnoDB DEFAULT CHARSET=utf8;
 GRANT ALL ON spring_transaction_slave.* TO 'slave'@'127.0.0.1' IDENTIFIED BY 'slave';
