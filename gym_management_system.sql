SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_account` int NOT NULL COMMENT 'Administrator account',
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Administrator password',
  PRIMARY KEY (`admin_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1001, '123456');
INSERT INTO `admin` VALUES (1002, '123456');
INSERT INTO `admin` VALUES (1003, '123456');

-- ----------------------------
-- Table structure for classtable
-- ----------------------------
DROP TABLE IF EXISTS `class_table`;
CREATE TABLE `class_table`  (
  `class_id` int NOT NULL DEFAULT 0 COMMENT 'Course id',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Course Name',
  `class_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Class start time',
  `class_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Course Duration',
  `coach` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Coaches',
  `price` int NULL DEFAULT NULL COMMENT 'vnd',
  `class_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'based on time/sport',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classtable
-- ----------------------------
INSERT INTO `class_table` VALUES (0001, 'yoga_3m', '2021-01-01 15:00', '60m', 'Coach', 600000, "yoga 3 months");
INSERT INTO `class_table` VALUES (0002, 'gym_1m', '2021-01-02 10:20', '90m', 'Yoga Instructor', 200000, "gym 1 month");
INSERT INTO `class_table` VALUES (0003, 'gym_3m', '2021-03-06 18:00', '90m', 'Coach', 550000, "gym 3 months");
INSERT INTO `class_table` VALUES (0004, 'gym_1m_PT', '2021-02-02 10:00', '45m', 'Coach', 3000000, "gym 1 month with PT");
INSERT INTO `class_table` VALUES (0005, 'yoga_1m', '2021-02-03 15:00', '60m', 'Instructor', 200000, "yoga 1 month");
INSERT INTO `class_table` VALUES (0006, 'cardio_1m', '2021-02-03 15:00', '60m', 'Coach', 150000, "cardio 1 month");
INSERT INTO `class_table` VALUES (0007, 'gym_1d', '2021-03-01 17:30', '60m', 'Instructor', 10000, "gym 1 day");
INSERT INTO `class_table` VALUES (0008, 'yoga_1d', '2021-02-22 09:00', '90m', 'Instructor', 12000,"yoga 1 day");
INSERT INTO `class_table` VALUES (0009, 'cardio_1d', '2021-02-04 15:00', '60m', 'Instructor', 8000, "cardio 1 day");
INSERT INTO `class_table` VALUES (0010, 'gym_1y_PT', '2021-03-08 15:00', '45m', 'Coach', 20000000, "gym 1 year with PT");
INSERT INTO `class_table` VALUES (0011, 'gym_1y', '2021-02-22 18:00', '60m', 'Instructor', 1500000, "gym 1 year");


-- ----------------------------
-- Table structure for class order
-- ----------------------------
DROP TABLE IF EXISTS `class_order`;
CREATE TABLE `class_order`  (
  `class_order_id` int NOT NULL AUTO_INCREMENT COMMENT 'Registration Form id',
  `class_id` int NULL DEFAULT NULL COMMENT 'Course id',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Course Name',
  `coach` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Coach',
  `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Member Name',
  `member_account` int NULL DEFAULT NULL COMMENT 'Member Account',
  `class_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Start time',
  `status` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'accepted/waiting',
  PRIMARY KEY (`class_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class order
-- ----------------------------
INSERT INTO `class_order` VALUES (1, 0002, 'Yoga', 'Yoga Instructor', 'Huy', 202100788, '2021-01-02 10:20', "accepted");
INSERT INTO `class_order` VALUES (2, 0002, 'Yoga', 'Yoga Instructor', 'Đinh', 202132539, '2021年1月2日 10:20', "accepted");
INSERT INTO `class_order` VALUES (3, 0004, 'Exercise Rehabilitation', 'Rehabilitation Coach', 'Trọng', 202156754, '2021年2月2日 10:00', "accepted");
INSERT INTO `class_order` VALUES (4, 0001, 'Muscle', 'Muscle Coach', 'Hoang', 202156754, '2021年1月1日 15:00', "accepted");
INSERT INTO `class_order` VALUES (5, 0001, 'Muscle', 'Muscle Coach', 'Quốc', 202183406, '2021年1月1日 15:00', "accepted");
INSERT INTO `class_order` VALUES (6, 0002, 'Yoga', 'Yoga Instructor', 'Nguyễn', 202183406, '2021年1月2日 10:20', "accepted");
INSERT INTO `class_order` VALUES (7, 0001, 'Muscle', 'Muscle Coach', 'Hiếu', 202100788, '2021年1月1日 15:00', "accepted");
INSERT INTO `class_order` VALUES (8, 0001, 'Muscle', 'Muscle Coach', 'Dương', 202186416, '2021年1月1日 15:00', "accepted");
INSERT INTO `class_order` VALUES (9, 0003, 'Fat loss', 'Fat Loss Coach', 'Kim', 202186416, '2021年3月6日 18:00', "accepted");
INSERT INTO `class_order` VALUES (10, 0003, 'Fat loss', 'Fat Loss Coach', 'Đào', 202123664, '2021年3月6日 18:00', "accepted");
INSERT INTO `class_order` VALUES (11, 0003, 'Fat loss', 'Fat Loss Coach', 'Bình', 202153468, '2021年3月6日 18:00', "accepted");



-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `member_account` int NOT NULL COMMENT 'Member Account',
  `member_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' COMMENT 'Member Password',
  `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Member Name',
  `member_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'Member Gender',
  `member_age` int NULL DEFAULT NULL COMMENT 'Age',
  `member_height` int NULL DEFAULT NULL COMMENT 'Height',
  `member_weight` int NULL DEFAULT NULL COMMENT 'weight',
  `member_phone` bigint NULL DEFAULT NULL COMMENT 'phone',
  `card_time` date NULL DEFAULT NULL COMMENT 'card time',
  `card_class` int NULL DEFAULT NULL COMMENT 'card class',
  `card_next_class` int NULL DEFAULT NULL COMMENT 'card next class',
  PRIMARY KEY (`member_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (202009867, '123456', 'Nguyễn', 'female', 24, 182, 60, 13515548482, '2020-06-05', 40, 40);
INSERT INTO `member` VALUES (202100788, '123456', 'Thái', 'male', 31, 178, 60, 13131554873, '2021-01-01', 50, 50);
INSERT INTO `member` VALUES (202132539, '123456', 'Bình', 'male', 31, 178, 60, 13154875489, '2021-01-01', 40, 40);
INSERT INTO `member` VALUES (202186416, '123456', 'Hoàng', 'female', 23, 160, 45, 13124576857, '2021-01-16', 30, 30);
INSERT INTO `member` VALUES (202106725, '123456', 'Huy', 'male', 24, 178, 88, 13758784959, '2021-02-26', 30, 30);
INSERT INTO `member` VALUES (202183406, '123456', 'Hiếu', 'female', 19, 170, 60, 13786457488,'2021-02-27', 30, 30);
INSERT INTO `member` VALUES (202176587, '123456', 'Dương', 'male', 33, 177, 90, 13767546666, '2021-02-27', 30, 30);
INSERT INTO `member` VALUES (202156754, '123456', 'Ronaldo', 'male', 36, 166, 67, 13786532448, '2021-02-28', 30, 30);
INSERT INTO `member` VALUES (202153468, '123456', 'Messi', 'female', 25, 173, 44, 13786457124,  '2021-03-01', 50, 50);
INSERT INTO `member` VALUES (202121345, '123456', 'Mbappe', 'male', 28, 160, 40, 13754457488, '2021-03-02', 30, 30);
INSERT INTO `member` VALUES (202189776, '123456', 'Haland', 'female', 27, 170, 50, 13986337489,  '2021-03-23', 30, 30);
INSERT INTO `member` VALUES (202123664, '123456', 'Alice', 'female', 25, 165, 51, 15986457423,  '2021-03-27', 30, 30);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `employee_account` int NOT NULL COMMENT 'Employee Account Number',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'employee name',
  `employee_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'employee gender',
  `employee_age` int NULL DEFAULT NULL COMMENT 'Age',
  `entry_time` date NULL DEFAULT NULL COMMENT 'entry time`',
  `staff` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'staff',
  `employee_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'employee message',
  PRIMARY KEY (`employee_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO employee VALUES (101038721, 'Coach 1', 'Female', 26, '2016-06-29', 'Fitness coach', 'Bodybuilding champion');
INSERT INTO employee VALUES (101068283, 'Coach 2', 'Male', 34, '2020-01-06', 'Fitness coach', 'Career coach');
INSERT INTO employee VALUES (101053687, 'Coach 3', 'Male', 30, '2020-06-06', 'Fitness coach', 'Career coach');
INSERT INTO employee VALUES (101045354, 'Coach 4', 'Male', 24, '2021-01-07', 'Fitness coach', 'Career coach');
INSERT INTO employee VALUES (101058973, 'Cleaning 1', 'Female', 48, '2019-08-24', 'Cleaners', 'Model employee');
INSERT INTO employee VALUES (101034208, 'Cleaning 2', 'Female', 48, '2010-08-01', 'Cleaners', '');



-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `equipment_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `equipment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'equipment name',
  `equipment_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'equipment location',
  `equipment_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'equipment status',
  `equipment_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'equipment message',
  PRIMARY KEY (`equipment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO equipment VALUES (1, 'Dumbbel 1', 'Room 1', 'Normal', '');
INSERT INTO equipment VALUES (2, 'Barbell 1', 'Room 2', 'Damage', 'To be repaired');
INSERT INTO equipment VALUES (3, 'Treadmill 1', 'Room 2', 'In maintenance', 'Contact the manufacturer for maintenance');
INSERT INTO equipment VALUES (4, 'Treadmill 2', 'Room 2', 'Normal', '');
INSERT INTO equipment VALUES (5, 'Treadmill 3', 'Room 2', 'Normal', '');
INSERT INTO equipment VALUES (6, 'Barbell 1', 'Room 1', 'Normal', '');
INSERT INTO equipment VALUES (7, 'Barbell 2', 'Room 1', 'Normal', '');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `feedback_id` int NOT NULL AUTO_INCREMENT COMMENT 'feedback id',
  `member_account` int NULL DEFAULT NULL COMMENT 'account of member with feedback',
  `employee_account` int NULL DEFAULT NULL COMMENT 'account of employee got feedback',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'content of feedback',
  PRIMARY KEY (`feedback_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `feedback` VALUES (1, 202100788, 101038721, 'Good');
INSERT INTO `feedback` VALUES (2, 202183406, 101038721, 'Awesome');
INSERT INTO `feedback` VALUES (3, 202183406, 101058973, 'Usually late');

SET FOREIGN_KEY_CHECKS = 1;