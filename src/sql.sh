CREATE TABLE `admin` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





  CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `courseName` varchar(40) NOT NULL,
  `academicYear` varchar(40) NOT NULL,
  `term` varchar(40) NOT NULL,
  `teacherName` varchar(40) NOT NULL DEFAULT '',
  `commitStatus` varchar(10) DEFAULT NULL,
  `courseQuality` varchar(40) NOT NULL,
  `hours` int NOT NULL,
  `score` int NOT NULL,
  `count` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;