-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2018 at 06:34 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payroll`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` bigint(20) NOT NULL,
  `days_worked` int(11) NOT NULL,
  `month` int(11) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `days_worked`, `month`, `year`, `employee_id`) VALUES
(4, 30, 0, 2018, 1),
(6, 27, 1, 2018, 1),
(8, 15, 2, 2018, 1),
(10, 30, 3, 2018, 1),
(12, 27, 4, 2018, 1),
(14, 23, 5, 2018, 1),
(16, 26, 6, 2018, 1),
(18, 20, 7, 2018, 1),
(20, 30, 8, 2018, 1),
(22, 30, 9, 2018, 1),
(24, 28, 10, 2018, 1),
(26, 27, 11, 2018, 1),
(28, 30, 0, 2018, 2),
(30, 26, 1, 2018, 2),
(32, 30, 2, 2018, 2),
(34, 22, 3, 2018, 2),
(36, 27, 4, 2018, 2),
(38, 30, 5, 2018, 2);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `leave_balance` int(11) NOT NULL,
  `manager_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `sex` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `department`, `designation`, `email`, `leave_balance`, `manager_id`, `name`, `password`, `phone_no`, `sex`) VALUES
(1, 'CS', 'Manager', 'vipul@gmail.com', 5, 1, 'Vipul', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 9716539257, 'Male'),
(2, 'CS', 'AssistantManager', 'nilesh@gmail.com', 10, 1, 'Nilesh', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 9898989898, 'Male'),
(39, 'CS', 'Clerk', 'yash@gmail.com', 5, 2, 'Yash', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 9716539257, 'Male'),
(40, 'CS', 'Clerk', 'kd@gmail.com', 5, 2, 'KD', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 9716539257, 'Male'),
(41, 'CS', 'AssistantManager', 'saurabh@gmail.com', 3, 1, 'Saurabh', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 9716539257, 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(42),
(42),
(42),
(42);

-- --------------------------------------------------------

--
-- Table structure for table `leaves`
--

CREATE TABLE `leaves` (
  `id` bigint(20) NOT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `number_leaves` int(11) NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `id` bigint(20) NOT NULL,
  `basic` int(11) NOT NULL,
  `da` int(11) NOT NULL,
  `hra` int(11) NOT NULL,
  `month` int(11) DEFAULT NULL,
  `pf` int(11) NOT NULL,
  `ta` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`id`, `basic`, `da`, `hra`, `month`, `pf`, `ta`, `year`, `employee_id`) VALUES
(3, 60000, 30000, 30000, 0, 7800, 6000, 2018, 1),
(5, 54000, 27000, 27000, 1, 7020, 5400, 2018, 1),
(7, 30000, 15000, 15000, 2, 3900, 3000, 2018, 1),
(9, 60000, 30000, 30000, 3, 7800, 6000, 2018, 1),
(11, 54000, 27000, 27000, 4, 7020, 5400, 2018, 1),
(13, 46000, 23000, 23000, 5, 5980, 4600, 2018, 1),
(15, 52000, 26000, 26000, 6, 6760, 5200, 2018, 1),
(17, 40000, 20000, 20000, 7, 5200, 4000, 2018, 1),
(19, 60000, 30000, 30000, 8, 7800, 6000, 2018, 1),
(21, 60000, 30000, 30000, 9, 7800, 6000, 2018, 1),
(23, 56000, 28000, 28000, 10, 7280, 5600, 2018, 1),
(25, 54000, 27000, 27000, 11, 7020, 5400, 2018, 1),
(27, 39990, 19995, 19995, 0, 5198, 3999, 2018, 2),
(29, 34658, 17329, 17329, 1, 4505, 3465, 2018, 2),
(31, 39990, 19995, 19995, 2, 5198, 3999, 2018, 2),
(33, 29326, 14663, 14663, 3, 3812, 2932, 2018, 2),
(35, 35991, 17995, 17995, 4, 4678, 3599, 2018, 2),
(37, 39990, 19995, 19995, 5, 5198, 3999, 2018, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr7q0h8jfngkyybll6o9r3h9ua` (`employee_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `leaves`
--
ALTER TABLE `leaves`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoyaicpcjhq2kad5vgtlexcjjo` (`employee_id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnlnv3jbyvbiu8ci59r3btlk00` (`employee_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
