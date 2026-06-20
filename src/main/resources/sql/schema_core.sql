-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- 核心表结构（user / app / chat_history / blog_*）
-- 全新部署时第一个导入，然后再导入同目录下其他 sql 脚本。
-- 导入顺序见 docs/DEPLOY_SERVER.md 第 3 步。
--
-- Host: localhost    Database: aiscene
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userAccount` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '璐﹀彿',
  `userPassword` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '瀵嗙爜',
  `userName` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '鐢ㄦ埛鏄电О',
  `userAvatar` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '鐢ㄦ埛澶村儚',
  `userProfile` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '鐢ㄦ埛绠€浠?,
  `userRole` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'user' COMMENT '鐢ㄦ埛瑙掕壊锛歶ser/admin',
  `editTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '缂栬緫鏃堕棿',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
  `isDelete` tinyint NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `vipExpireTime` datetime DEFAULT NULL COMMENT '浼氬憳杩囨湡鏃堕棿',
  `vipCode` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '浼氬憳鍏戞崲鐮?,
  `vipNumber` bigint DEFAULT NULL COMMENT '浼氬憳缂栧彿',
  `shareCode` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '鍒嗕韩鐮?,
  `inviteUser` bigint DEFAULT NULL COMMENT '閭€璇风敤鎴?id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_userAccount` (`userAccount`),
  KEY `idx_userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=401312023905906689 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='鐢ㄦ埛';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `app`
--

DROP TABLE IF EXISTS `app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `appName` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '搴旂敤鍚嶇О',
  `cover` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '搴旂敤灏侀潰',
  `initPrompt` text COLLATE utf8mb4_unicode_ci COMMENT '搴旂敤鍒濆鍖栫殑 prompt',
  `codeGenType` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '浠ｇ爜鐢熸垚绫诲瀷锛堟灇涓撅級',
  `deployKey` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '閮ㄧ讲鏍囪瘑',
  `deployedTime` datetime DEFAULT NULL COMMENT '閮ㄧ讲鏃堕棿',
  `priority` int NOT NULL DEFAULT '0' COMMENT '浼樺厛绾?,
  `userId` bigint NOT NULL COMMENT '鍒涘缓鐢ㄦ埛id',
  `editTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '缂栬緫鏃堕棿',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
  `isDelete` tinyint NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_deployKey` (`deployKey`),
  KEY `idx_appName` (`appName`),
  KEY `idx_userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=387424400586571905 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='搴旂敤';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chat_history`
--

DROP TABLE IF EXISTS `chat_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_history` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `message` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '娑堟伅',
  `messageType` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'user/ai',
  `appId` bigint NOT NULL COMMENT '搴旂敤id',
  `userId` bigint NOT NULL COMMENT '鍒涘缓鐢ㄦ埛id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
  `isDelete` tinyint NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `parentId` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_appId` (`appId`),
  KEY `idx_createTime` (`createTime`),
  KEY `idx_appId_createTime` (`appId`,`createTime`)
) ENGINE=InnoDB AUTO_INCREMENT=420791359411187713 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='瀵硅瘽鍘嗗彶';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `blog_category`
--

DROP TABLE IF EXISTS `blog_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '鍒嗙被ID',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '鍒嗙被鍚嶇О',
  `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '鍒嗙被鎻忚堪',
  `icon` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '鍒嗙被鍥炬爣',
  `sort_order` int DEFAULT '0' COMMENT '鎺掑簭椤哄簭',
  `status` tinyint DEFAULT '1' COMMENT '鐘舵€侊紙0-绂佺敤锛?-鍚敤锛?,
  `created_time` datetime NOT NULL COMMENT '鍒涘缓鏃堕棿',
  `updated_time` datetime NOT NULL COMMENT '鏇存柊鏃堕棿',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='鍗氬鍒嗙被琛?;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `blog_tag`
--

DROP TABLE IF EXISTS `blog_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '鏍囩ID',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '鏍囩鍚嶇О',
  `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '鏍囩鎻忚堪',
  `color` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT '#667eea' COMMENT '鏍囩棰滆壊',
  `count` int DEFAULT '0' COMMENT '浣跨敤娆℃暟',
  `status` tinyint DEFAULT '1' COMMENT '鐘舵€侊紙0-绂佺敤锛?-鍚敤锛?,
  `created_time` datetime NOT NULL COMMENT '鍒涘缓鏃堕棿',
  `updated_time` datetime NOT NULL COMMENT '鏇存柊鏃堕棿',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='鍗氬鏍囩琛?;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `blog_post`
--

DROP TABLE IF EXISTS `blog_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_post` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '鏂囩珷ID',
  `title` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '鏂囩珷鏍囬',
  `summary` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '鏂囩珷鎽樿',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '鏂囩珷鍐呭',
  `cover_url` varchar(1200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '灏侀潰鍥剧墖URL',
  `category_id` bigint NOT NULL COMMENT '鍒嗙被ID',
  `user_id` bigint NOT NULL COMMENT '浣滆€匢D',
  `view_count` int DEFAULT '0' COMMENT '娴忚閲?,
  `like_count` int DEFAULT '0' COMMENT '鐐硅禐鏁?,
  `status` tinyint DEFAULT '1' COMMENT '鐘舵€侊紙0-鑽夌锛?-鍙戝竷锛?-涓嬫灦锛?,
  `is_top` tinyint DEFAULT '0' COMMENT '鏄惁缃《锛?-鍚︼紝1-鏄級',
  `sort_order` int DEFAULT '0' COMMENT '鎺掑簭椤哄簭',
  `extend_info` json DEFAULT NULL COMMENT '鎵╁睍淇℃伅',
  `created_time` datetime NOT NULL COMMENT '鍒涘缓鏃堕棿',
  `updated_time` datetime NOT NULL COMMENT '鏇存柊鏃堕棿',
  `deleted_time` datetime DEFAULT NULL COMMENT '鍒犻櫎鏃堕棿',
  PRIMARY KEY (`id`),
  KEY `idx_category_id` (`category_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_status` (`status`),
  KEY `idx_is_top` (`is_top`),
  KEY `idx_created_time` (`created_time`),
  FULLTEXT KEY `idx_search` (`title`,`summary`),
  CONSTRAINT `fk_post_category` FOREIGN KEY (`category_id`) REFERENCES `blog_category` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_post_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='鍗氬鏂囩珷琛?;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `blog_post_tag`
--

DROP TABLE IF EXISTS `blog_post_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_post_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '鍏崇郴ID',
  `post_id` bigint NOT NULL COMMENT '鏂囩珷ID',
  `tag_id` bigint NOT NULL COMMENT '鏍囩ID',
  `created_time` datetime NOT NULL COMMENT '鍒涘缓鏃堕棿',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_post_tag` (`post_id`,`tag_id`),
  KEY `idx_post_id` (`post_id`),
  KEY `idx_tag_id` (`tag_id`),
  CONSTRAINT `fk_post_tag_post` FOREIGN KEY (`post_id`) REFERENCES `blog_post` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_post_tag_tag` FOREIGN KEY (`tag_id`) REFERENCES `blog_tag` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='鏂囩珷鏍囩鍏崇郴琛?;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `blog_image`
--

DROP TABLE IF EXISTS `blog_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_image` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '鍥剧墖ID',
  `filename` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '鍘熷鏂囦欢鍚?,
  `storage_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '瀛樺偍鏂囦欢鍚?,
  `url` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '璁块棶URL',
  `size` bigint NOT NULL COMMENT '鏂囦欢澶у皬',
  `type` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'MIME绫诲瀷',
  `width` int DEFAULT NULL COMMENT '鍥剧墖瀹藉害',
  `height` int DEFAULT NULL COMMENT '鍥剧墖楂樺害',
  `post_id` bigint DEFAULT NULL COMMENT '鍏宠仈鏂囩珷ID',
  `user_id` bigint NOT NULL COMMENT '涓婁紶鐢ㄦ埛ID',
  `usage_type` tinyint DEFAULT '1' COMMENT '浣跨敤绫诲瀷锛?-灏侀潰锛?-鍐呭鍥剧墖锛?-鍏朵粬锛?,
  `status` tinyint DEFAULT '1' COMMENT '鐘舵€侊紙0-鍒犻櫎锛?-姝ｅ父锛?,
  `created_time` datetime NOT NULL COMMENT '鍒涘缓鏃堕棿',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_storage_name` (`storage_name`),
  KEY `idx_post_id` (`post_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_usage_type` (`usage_type`),
  CONSTRAINT `fk_image_post` FOREIGN KEY (`post_id`) REFERENCES `blog_post` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fk_image_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='鍥剧墖璧勬簮琛?;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-20 15:51:18
