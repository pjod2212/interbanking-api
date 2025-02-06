CREATE TABLE `companies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adhesion_date` datetime(6) NOT NULL,
  `business_name` varchar(255) NOT NULL,
  `cuit` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsvsf1h2stvn0wtju1w9vq93qr` (`cuit`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `transfers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` decimal(38,2) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `credit_account` varchar(255) NOT NULL,
  `date` datetime(6) NOT NULL,
  `debit_account` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;