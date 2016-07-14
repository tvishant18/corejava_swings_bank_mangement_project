CREATE TABLE `account_statement` (
  `customer_id` int(11) NOT NULL,
  `account_no` int(11) NOT NULL,
  `balance` int(11) NOT NULL,
  `last_credit_transaction` int(11) DEFAULT NULL,
  `last_credit_transaction_date` varchar(45) DEFAULT NULL,
  `last_debit_transaction` int(11) DEFAULT NULL,
  `last_debit_transaction_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `credit_transaction_history` (
  `Sr no` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `account_no` int(11) NOT NULL,
  `credit_amount` int(11) NOT NULL,
  `date_time` varchar(45) NOT NULL,
  PRIMARY KEY (`Sr no`,`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
CREATE TABLE `customer_details` (
  `account_no` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `acc_type` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `father's_name` varchar(45) NOT NULL,
  `mother's_name` varchar(45) NOT NULL,
  `date_of_birth` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `occupation` varchar(45) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `first_nominee_name` varchar(45) DEFAULT NULL,
  `second_nominee_name` varchar(45) DEFAULT NULL,
  `sms_service` varchar(45) NOT NULL,
  `ATM` varchar(45) NOT NULL,
  `Cheque BOOK` varchar(45) NOT NULL,
  PRIMARY KEY (`account_no`,`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `debit_transaction_history` (
  `sr_no` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `account_no` int(11) NOT NULL,
  `debit_amount` int(11) NOT NULL,
  `date_time` varchar(45) NOT NULL,
  PRIMARY KEY (`sr_no`,`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `transfer_transaction_history` (
  `sr_no` int(11) NOT NULL AUTO_INCREMENT,
  `sender_cust_id` int(11) NOT NULL,
  `sender_acc_no` int(11) NOT NULL,
  `rec_cust_id` int(11) NOT NULL,
  `rec_acc_no` int(11) NOT NULL,
  `transfer_amount` int(11) NOT NULL,
  `date_time` varchar(45) NOT NULL,
  PRIMARY KEY (`sr_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
CREATE TABLE `user_details` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `secret_ques` varchar(45) NOT NULL,
  `secret_answer` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
