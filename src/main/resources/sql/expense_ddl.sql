CREATE TABLE IF NOT EXISTS `expense` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `quota` bigint NOT NULL,
  `category_id` bigint NOT NULL,
  `add_date` date NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  CONSTRAINT `category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
);