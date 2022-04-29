-- sample.tb_board definition

CREATE TABLE `tb_board` (
  `id` int NOT NULL AUTO_INCREMENT,
  `entity_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `title` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '게시글 제목',
  `content` longtext COLLATE utf8mb4_unicode_ci COMMENT '게시글 내용',
  `view_count` int NOT NULL DEFAULT '0' COMMENT '조회수',
  `create_id` int DEFAULT NULL COMMENT '등록자',
  `create_dt` datetime DEFAULT NULL COMMENT '생성일',
  PRIMARY KEY (`id`),
  KEY `tb_board_FK` (`create_id`),
  CONSTRAINT `tb_board_FK` FOREIGN KEY (`create_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- sample.tb_menu definition

CREATE TABLE `tb_menu` (
  `menu_id` int NOT NULL AUTO_INCREMENT COMMENT '메뉴 PK',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '메뉴 명',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '메뉴 설명',
  `position` int NOT NULL DEFAULT '0' COMMENT '메뉴 순서',
  `category` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `link` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '메뉴 링크',
  `icon` mediumtext COLLATE utf8mb4_unicode_ci COMMENT '메뉴 아이콘',
  `use_yn` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'Y' COMMENT '사용 여부',
  `parent_id` int DEFAULT NULL COMMENT '부모 메뉴',
  `create_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO tb_menu (name,description,`position`,category,link,icon,use_yn,parent_id,create_dt) VALUES
	 ('소개','웹 소개',0,'up','/introduction',NULL,'Y',NULL,'2022-04-25 07:07:11'),
	 ('사용자','사용자 메뉴',1,'down','/user','<svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiSvgIcon-root MuiSvgIcon-fontSizeLarge css-zjt8k" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="AccountCircleIcon" tabindex="-1" title="AccountCircle"><path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 3c1.66 0 3 1.34 3 3s-1.34 3-3 3-3-1.34-3-3 1.34-3 3-3zm0 14.2c-2.5 0-4.71-1.28-6-3.22.03-1.99 4-3.08 6-3.08 1.99 0 5.97 1.09 6 3.08-1.29 1.94-3.5 3.22-6 3.22z"></path></svg>','Y',NULL,'2022-04-25 07:07:56'),
	 ('게시판','게시판 메뉴',2,'down','/board','<svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiSvgIcon-root MuiSvgIcon-fontSizeLarge css-zjt8k" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="ViewListIcon" tabindex="-1" title="ViewList"><path d="M3 14h4v-4H3v4zm0 5h4v-4H3v4zM3 9h4V5H3v4zm5 5h13v-4H8v4zm0 5h13v-4H8v4zM8 5v4h13V5H8z"></path></svg>','Y',NULL,'2022-04-25 07:08:12');

-- sample.tb_user definition

CREATE TABLE `tb_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '유저 ID',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '유저 패스워드',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '유저 이름',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '유저 닉네임',
  `delete_yn` char(1) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'N' COMMENT '삭제 여부',
  `create_dt` datetime DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- sample.tb_user_detail definition

CREATE TABLE `tb_user_detail` (
  `id` int NOT NULL COMMENT 'FK',
  `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '유저 이메일',
  `phone_number` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '유저 휴대폰번호',
  PRIMARY KEY (`id`),
  CONSTRAINT `tb_user_detail_FK` FOREIGN KEY (`id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;