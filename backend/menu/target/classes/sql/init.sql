CREATE DATABASE `sample` /*!40100 DEFAULT CHARACTER SET utf16 COLLATE utf16_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `tb_user` (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                           `user_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '유저 ID',
                           `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '유저 패스워드',
                           `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '유저 이름',
                           `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '유저 닉네임',
                           `delete_yn` char(1) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'N' COMMENT '삭제 여부',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `tb_user_detail` (
                                  `id` int NOT NULL COMMENT 'FK',
                                  `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '유저 이메일',
                                  `phone_number` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '유저 휴대폰번호',
                                  PRIMARY KEY (`id`),
                                  CONSTRAINT `tb_user_detail_FK` FOREIGN KEY (`id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;