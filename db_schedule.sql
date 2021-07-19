--
-- Database: `mint_schedule`
--
CREATE DATABASE IF NOT EXISTS `mint_schedule` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `mint_schedule`;

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `id_event` int(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  `start_date` datetime NOT NULL DEFAULT current_timestamp(),
  `end_date` datetime NOT NULL,
  `type` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `instructor` int(11) NOT NULL,
  PRIMARY KEY (`id_event`),
  UNIQUE KEY `id_event` (`id_event`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `events`:
--   `instructor`
--       `instructors` -> `id_instructor`
--
-- --------------------------------------------------------

--
-- Table structure for table `instructors`
--

DROP TABLE IF EXISTS `instructors`;
CREATE TABLE `instructors` (
  `id_instructor` int(100) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `birthday` date NOT NULL,
  PRIMARY KEY (`id_instructor`),
  UNIQUE KEY `id_instructor` (`id_instructor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Initialize database
--

INSERT INTO `instructors` (`id_instructor`, `first_name`, `last_name`, `birthday`) VALUES
(1, 'Carlos', 'Fuentes', '1992-06-18'),
(2, 'Juliana', 'Marín', '2000-10-28'),
(3, 'Miguel', 'Torres', '1981-02-10'),
(4, 'Rodrigo', 'Gutierrez', '1993-11-08'),
(5, 'Angelica', 'Cruz', '1979-04-21');


INSERT INTO `events` (`id_event`, `start_date`, `end_date`, `type`, `description`, `instructor`) VALUES
(1, '2021-07-01 00:00:00', '2021-07-07 00:00:00', 'Holiday', '', 1),
(2, '2021-07-07 00:00:00', '2021-07-14 00:00:00', 'Holiday', '', 2),
(3, '2021-07-14 00:00:00', '2021-07-21 00:00:00', 'Holiday', '', 3),
(4, '2021-07-21 00:00:00', '2021-07-30 00:00:00', 'Holiday', '', 4),
(5, '2021-07-01 00:00:00', '2021-07-07 00:00:00', 'Holiday', '', 5),
(6, '2021-07-07 00:00:00', '2021-07-14 00:00:00', 'Seminar', 'First seminar', 1),
(7, '2021-07-14 00:00:00', '2021-07-21 00:00:00', 'Seminar', 'First seminar', 2),
(8, '2021-07-21 00:00:00', '2021-07-30 00:00:00', 'Seminar', 'First seminar', 3),
(9, '2021-07-01 00:00:00', '2021-07-07 00:00:00', 'Seminar', 'First seminar', 4),
(10, '2021-07-07 00:00:00', '2021-07-14 00:00:00', 'Seminar', 'First seminar', 5),
(11, '2021-07-14 00:00:00', '2021-07-21 00:00:00', 'Seminar', 'Second seminar', 1),
(12, '2021-07-21 00:00:00', '2021-07-30 00:00:00', 'Seminar', 'Second seminar', 2),
(13, '2021-07-01 00:00:00', '2021-07-07 00:00:00', 'Seminar', 'Second seminar', 3),
(14, '2021-07-07 00:00:00', '2021-07-14 00:00:00', 'Seminar', 'Second seminar', 4),
(15, '2021-07-14 00:00:00', '2021-07-21 00:00:00', 'Seminar', 'Second seminar', 5),
(16, '2021-07-21 00:00:00', '2021-07-30 00:00:00', 'Project', 'Demo Client x', 1),
(17, '2021-07-01 00:00:00', '2021-07-07 00:00:00', 'Project', 'Demo Client x', 2),
(18, '2021-07-07 00:00:00', '2021-07-14 00:00:00', 'Project', 'Demo Client x', 3),
(19, '2021-07-14 00:00:00', '2021-07-21 00:00:00', 'Project', 'Demo Client x', 4),
(20, '2021-07-21 00:00:00', '2021-07-30 00:00:00', 'Project', 'Demo Client x', 5);
