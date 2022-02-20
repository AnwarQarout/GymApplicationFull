-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 20, 2022 at 10:18 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gym`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `manger_id` int(11) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `phone` int(15) NOT NULL,
  `salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `manger_id`, `user_name`, `password`, `name`, `phone`, `salary`) VALUES
(1, 2, 'yassen', 'root1234', 'Anwar Qarout', 8068, 0),
(2, 2, '12345', '22323', '234567', 1233, 123213),
(3, 2, 'f5f5', 'f5f5', 'f5f5', 45354, 88888),
(4, 2, 'eqwrt', 'ewqrt', 'ewqrgt', 21345, 3245),
(5, 2, '5f5f5f5f5', '5f5f5f5f', 'f5f5f5f5', 32145, 55555),
(6, 2, 'temp12', 'temp1234', 'temp', 595378068, 600),
(7, 2, 'temp', 'temp', 'temp', 5195125, 300),
(8, 2, 'test', 'test', 'test', 41243123, 200),
(9, 2, 'test1', 'test1', 'test1', 23123123, 2123);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `id` int(11) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`id`, `user_name`, `password`) VALUES
(1, 'anwar qarout', 'root1234'),
(2, 'anwar', 'root1234');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `phone` int(11) NOT NULL,
  `image` varchar(32) NOT NULL,
  `height` double NOT NULL,
  `weight` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `employee_id`, `user_name`, `password`, `name`, `phone`, `image`, `height`, `weight`) VALUES
(1, 1, 'anwarM', 'root1234', 'Anwar Ahmad Qarout', 595378068, '', 220, 80);

-- --------------------------------------------------------

--
-- Table structure for table `membership`
--

CREATE TABLE `membership` (
  `id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `employee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `membership`
--

INSERT INTO `membership` (`id`, `name`, `employee_id`) VALUES
(1, 'WeightGain', 1),
(2, 'WeightLoss', 1),
(3, 'MassGain', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nutrition_programs`
--

CREATE TABLE `nutrition_programs` (
  `id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `type` varchar(12) NOT NULL,
  `membership` varchar(13) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nutrition_programs`
--

INSERT INTO `nutrition_programs` (`id`, `employee_id`, `name`, `type`, `membership`, `image`) VALUES
(1, 1, 'lazangaaa', 'breakfast', 'WeightLoss', 'https://hips.hearstapps.com/vidthumb/images/180820-bookazine-delish-01280-1536610916.jpg?crop=1xw:1xh;center,top&resize=768:*'),
(2, 1, 'humus', 'lunch', 'WeightLoss', 'https://www.inspiredtaste.net/wp-content/uploads/2019/07/The-Best-Homemade-Hummus-Recipe-1200.jpg'),
(3, 1, 'labna', 'breakfast', 'WeightGain', 'https://www.stayathomemum.com.au/wp-content/uploads/2017/02/bigstock-161030033.jpg'),
(4, 1, 'eggs', 'dinner', 'WeightLoss', 'https://www.simplyrecipes.com/thmb/35jQjKw_vCVZFfpiawO3P27Xkq4=/736x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/__opt__aboutcom__coeus__resources__content_migration__simply_recipes__uploads__2014__07__hard-boiled-eggs-horiz-800-429f7e9948b84a6d84237e228f9d54f2.jpg'),
(6, 1, 'Mansaf', 'lunch', 'WeightGain', 'https://kaleela.com/wp-content/uploads/2020/03/mansaf.jpg'),
(7, 1, 'Fried Potatoes', 'dinner', 'WeightGain', 'https://www.delonghi.com/Global/recipes/multifry/patatine_fritte.jpg'),
(9, 1, 'Chicken breast', 'breakfast', 'MassGain', 'https://rasamalaysia.com/wp-content/uploads/2020/05/boneless-chicken-breasts1.jpg'),
(12, 1, 'eggs', 'lunch', 'MassGain', 'https://i.insider.com/5ef4d074aee6a85ed37683f5?width=600&format=jpeg&auto=webp');

-- --------------------------------------------------------

--
-- Table structure for table `workout`
--

CREATE TABLE `workout` (
  `id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `steps` text NOT NULL,
  `video` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `workout`
--

INSERT INTO `workout` (`id`, `employee_id`, `name`, `steps`, `video`) VALUES
(1, 1, 'Chest Press', 'Hold the dumbbell and lift up your chest', 'https://images.squarespace-cdn.com/content/v1/54f9e84de4b0d13f30bba4cb/1526590877144-BYR9X8ZX5FROTGOZ2VHL/DSC_6330.mov.gif?format=500w'),
(5, 1, 'Push ups', 'Get on the ground and do simple pushups', ''),
(7, 1, 'Standing Cable Chest Press', 'Stand up, pull the cable and push forward', 'https://images.squarespace-cdn.com/content/v1/54f9e84de4b0d13f30bba4cb/1525881176260-YJD6JDG15GZPB72R5XCO/cable+chest+press.gif?format=500w'),
(8, 1, 'Alternating Dumbbell Bench Press', 'Lie down and bench press one hand each', 'https://images.squarespace-cdn.com/content/v1/54f9e84de4b0d13f30bba4cb/1529093935346-YKURBEER9QK50PMLLGTW/319.gif?format=500w');

-- --------------------------------------------------------

--
-- Table structure for table `workout2membership`
--

CREATE TABLE `workout2membership` (
  `workout_id` int(11) NOT NULL,
  `membership_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `workout2membership`
--

INSERT INTO `workout2membership` (`workout_id`, `membership_id`) VALUES
(1, 3),
(5, 3),
(7, 3),
(8, 2),
(5, 1),
(7, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_ibfk_1` (`manger_id`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_name` (`user_name`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `membership`
--
ALTER TABLE `membership`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `nutrition_programs`
--
ALTER TABLE `nutrition_programs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `workout`
--
ALTER TABLE `workout`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `workout2membership`
--
ALTER TABLE `workout2membership`
  ADD KEY `membership_id` (`membership_id`),
  ADD KEY `workout_id` (`workout_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `manager`
--
ALTER TABLE `manager`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `membership`
--
ALTER TABLE `membership`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nutrition_programs`
--
ALTER TABLE `nutrition_programs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `workout`
--
ALTER TABLE `workout`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`manger_id`) REFERENCES `manager` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `membership`
--
ALTER TABLE `membership`
  ADD CONSTRAINT `membership_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nutrition_programs`
--
ALTER TABLE `nutrition_programs`
  ADD CONSTRAINT `nutrition_programs_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `workout`
--
ALTER TABLE `workout`
  ADD CONSTRAINT `workout_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `workout2membership`
--
ALTER TABLE `workout2membership`
  ADD CONSTRAINT `workout2membership_ibfk_1` FOREIGN KEY (`membership_id`) REFERENCES `membership` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `workout2membership_ibfk_2` FOREIGN KEY (`workout_id`) REFERENCES `workout` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
