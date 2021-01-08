-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2019 at 09:29 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlyhocsinh`
--

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--
--
drop table if exists `diem`;
drop table if exists `giaovu`;
drop table if exists `hocsinh`;
drop table if exists `mon`;
drop table if exists `hocky`;
drop table if exists `lop`;
drop table if exists `khoi`;

drop table if exists `taikhoan`;
drop table if exists `phanquyen`;
CREATE TABLE `diem` (
  `id` int(11) UNSIGNED  NULL,
  `mahocsinh` varchar(255) NOT NULL,
  `malop` varchar(255) NOT NULL,
  `mamonhoc` varchar(255) NOT NULL,
  `mahocky` varchar(255) NOT NULL DEFAULT '',
  `diemmieng1` float(10,2) DEFAULT NULL,
   `diemmieng2` float(10,2) DEFAULT NULL,
    `diemmieng3` float(10,2) DEFAULT NULL,
  `diem15ph1` float(10,2) DEFAULT NULL,
    `diem15ph2` float(10,2) DEFAULT NULL,
      `diem15ph3` float(10,2) DEFAULT NULL,
  `diem1tiet1` float(10,2) DEFAULT NULL,
    `diem1tiet2` float(10,2) DEFAULT NULL,
      `diem1tiet3` float(10,2) DEFAULT NULL,
  `diemhocky` float(10,2) DEFAULT NULL,
    `diemtbmon` float(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `diem`
--

INSERT INTO `diem` (`id`, `mahocsinh`, `malop`, `mamonhoc`, `mahocky`, `diemmieng1`,`diemmieng2`,`diemmieng3`, `diem15ph1`, `diem15ph2`, `diem15ph3`, `diem1tiet1`,`diem1tiet2`,`diem1tiet3`, `diemhocky`,`diemtbmon`) VALUES
(1,'1910101', '10a1', 'toan', '2019_2020_HK1', 8, 8, 8,8,8,8,8,8,8, 8,8),
( 2,'1910102', '10a1', 'toan', '2019_2020_HK1', 4, 4,4,4,4,4,4,4,4,4,4),
( 3,'1910101', '10a1', 'van', '2019_2020_HK1', 9, 9,9,9,9,9,9,9,9,9,9),
( 4,'1910102', '10a1', 'van', '2019_2020_HK1', 9, 9,9,9,9,9,9,9,9,9,9),
( 5,'1910101', '10a1', 'hoa', '2019_2020_HK1', 9, 9,9,9,9,9,9,9,9,9,9),
( 6,'1910101', '10a1', 'hoa', '2019_2020_HK2', 9, 9,9,9,9,9,9,9,9,9,9),
(7,'1910101', '10a1', 'toan', '2019_2020_HK2', 8, 8, 8,8,8,8,8,8,8, 8,8),
( 8,'1910102', '10a1', 'toan', '2019_2020_HK2', 2, 2,2,2,2,2,2,2,2,2,2),
( 9,'1910101', '10a1', 'van', '2019_2020_HK2', 9, 9,9,9,9,9,9,9,9,9,9),
( 10,'1910102', '10a1', 'van', '2019_2020_HK2', 9, 9,9,9,9,9,9,9,9,9,9);
-- --------------------------------------------------------

--
drop table if exists `hanhkiem`;
CREATE TABLE `hanhkiem` (
  `id` int(11) UNSIGNED NOT NULL,
  `tenhanhkiem` varchar(255) NOT NULL
 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `hanhkiem` (`id`, `tenhanhkiem`) VALUES
(1, 'TỐT' ),(2,"KHÁ"),(3,"TB"),(4,'YẾU');

drop table if exists `chitiethanhkiem`;
CREATE TABLE `chitiethanhkiem` (
  `id` int(11) primary key auto_increment NOT NULL,
  `mahanhkiem` int(11) UNSIGNED NOT NULL,
  `mahocsinh` varchar(255)  NOT NULL,
    `malop` varchar(255)  NOT NULL,
  `mahocky` varchar(255) NOT NULL
  
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
-- Table structure for table `giaovu`
INSERT INTO `chitiethanhkiem` (`id`, `mahanhkiem`,`malop`,`mahocsinh`,`mahocky`) VALUES
(1, 1,'1910101','10a1',"2019_2020_HK1" ),(2,2,'1910102','10a1',"2019_2020_HK2");
--

CREATE TABLE `giaovu` (
  `id` int(10) UNSIGNED NOT NULL,
  `diemchuandatmon` float(10,2) NOT NULL,
  `tuoitoida` int(10) NOT NULL,
  `tuoitoithieu` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `giaovu`
--

INSERT INTO `giaovu` (`id`, `diemchuandatmon`, `tuoitoida`, `tuoitoithieu`) VALUES
(1, 5.00, 20, 15);

-- --------------------------------------------------------

--
-- Table structure for table `hocky`
--

CREATE TABLE `hocky` (
  `id` int(11) UNSIGNED NOT NULL,
  `mahocky` varchar(255) NOT NULL,
  `tenhocky` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `hocky`
--

INSERT INTO `hocky` (`id`, `mahocky`, `tenhocky`) VALUES
(1, '2019_2020_HK1', 'Học kỳ 1 2019 - 2020'),
(2, '2019_2020_HK2', 'Học kỳ 2 2019 - 2020'),
(3, '2020_2021_HK1', 'Học kỳ 1 2020 - 2021'),
(4, '2020_2021_HK2', 'Học kỳ 2 2020 - 2021');

-- --------------------------------------------------------

--
-- Table structure for table `hocsinh`
--

CREATE TABLE `hocsinh` (
  `id` int(11) UNSIGNED NOT NULL,
  `mahocsinh` varchar(255) NOT NULL,
  `lop` varchar(255) NOT NULL,
  `ten` varchar(255) NOT NULL,
  `ngaysinh` varchar(255) NOT NULL,
  `gioitinh` varchar(255) NOT NULL,
  `diachi` varchar(1000) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nienkhoa` varchar(255) NOT NULL
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
drop table if exists `tongket`;
CREATE TABLE `tongket` (
  `id` int(11) primary key auto_increment NOT NULL,
  `manamhoc` varchar(255) default "",
  `mahocsinh` varchar(255) default "",
  `hoten` varchar(255) default "",
  `lop` varchar(255) default "",
  `tbhk1` varchar(255) default "",
  `hk1` varchar(255) default "",
  `xeploai1` varchar(255) default "",
  
  `tbhk2` varchar(1000) default "",
  `hk2` varchar(255)  default "",
  `xeploai2` varchar(255) default "",
   `tbcn` varchar(1000) default "",
  `hkcn` varchar(255) default "",
  `xeploaicn` varchar(255) default ""
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `hocsinh`
--

INSERT INTO `hocsinh` (`id`, `mahocsinh`, `lop`, `ten`, `ngaysinh`, `gioitinh`, `diachi`, `email`) VALUES
(1, '1910201', '10a2', 'Nguyen phu vinh', '16/01/2003', 'Nam', ' Quan 7', ' phuvinh@gmail.com'),
(2, '1910101', '10a1', 'Ngô Nhật Huy', '30/08/1995', 'Nam', 'Quận 12', 'Huy@gmail.com'),
(3, '1910102', '10a1', 'Lê Thúy', '23/04/2003', 'Nữ', 'Quan 3', ' king@gmail.com'),
(4, '1910103', '10a1', 'Chau hai Hung', '15/06/2003', 'Nam', ' Quan 6', ' haihung@gmail.com'),
(5, '1910104', '10a1', 'Nguyễn Hoa Huệ', '13/03/2003', 'Nữ', 'Tân Qui', 'hoahue@gmail.com'),
(6, '1910105', '10a1', 'Nguyễn Tín', '11/05/2003', 'Nam', 'Vĩnh Kỳ, Hà Nam', 'tinnguyen@gmail.com'),
(7, '1910106', '10a1', 'Nguyễn Phú', '23/04/2003', 'Nam', 'Quận 2', 'phunguyen@gmail.com'),
(8, '1910107', '10a1', 'Lý Hoàng', '04/04/2003', 'Nam', 'Tiền Giang', 'hoang03@gmail.com'),
(9, '1910108', '10a1', 'Trương Hồng', '23/03/2003', 'Nữ', 'Quận Thử Đức', 'hong03@gmail.com'),
(10, '1910109', '10a1', 'Nguyễn Ngọc Nguyên', '24/05/2003', 'Nữ', 'Bến Tre', 'nguyenngon@gmail.com'),
(11, '1910110', '10a1', 'Trương Hòa Binh', '03/04/2003', 'Nam', 'Quận 10', 'hoa11@gmail.com'),
(12, '1910111', '10a1', 'Trương Mỹ Hoa', '16/09/2003', 'Nữ', 'Quận 9', 'hoamy@gmail.com'),
(13, '1910112', '10a1', 'Nguyễn Tấn Dũng', '16/01/2003', 'Nam', 'Quận 1', 'dungcamau@gmail.com'),
(14, '1910113', '10a1', 'Nguyễn Xuân Sắc', '14/01/2003', 'Nam', 'Hà Nội', 'xuannguyen@gmail.com'),
(15, '1910114', '10a1', 'Trần Xuân Bắc', '24/01/2003', 'Nam', 'Nghệ An', 'xuantran@gmail.com'),
(16, '1910115', '10a1', 'Nguyễn Hà Anh', '22/03/2003', 'Nữ', 'Phú Thọ', 'haanh@gmail.com'),
(17, '1910116', '10a1', 'Nguyễn Phú Trường', '17/07/2003', 'Nam', 'Hà Đông', 'truongnguyen@gmail.com'),
(18, '1910117', '10a1', 'Nguyễn Vĩnh', '14/07/2003', 'Nam', 'Nghệ An', 'vinhnguyen@gmail.com'),
(19, '1910118', '10a1', 'Nguyễn Phú Trọng', '19/01/2003', 'Nam', 'Hà Bắc', 'phunguyen@gmail.com'),
(20, '1910119', '10a1', 'Nguyễn Lê Anh ', '25/05/2003', 'Nữ', 'Quận 3', 'leanh@gmail.com'),
(22, '1910201', '10a2', 'Lê Hà Luyến', '15/06/2003', 'Nam', 'Hà Nội', 'luyenle@gmail.com'),
(23, '1910202', '10a2', 'Hà Văn Luyện', '05/09/2003', 'Nam', 'Kỳ Anh', 'vanluyen@gmail.com'),
(24, '1910203', '10a2', 'Lê Hà Tý', '09/09/2003', 'Nam', 'Cà Mau', 'tyha@gmail.com'),
(25, '1910204', '10a2', 'Lê Trâm Huyền', '06/09/2003', 'Nữ', 'Quận 9', 'tram22@gmail.com'),
(26, '1910205', '10a2', 'Lê Hoa Thu', '04/05/2003', 'Nữ ', 'Quận 3', 'thule@gmail.com'),
(27, '1910206', '10a2', 'Lê Hoàn Hảo', '01/02/2003', 'Nam ', 'Quận 11', 'hoanhao@gmail.com'),
(28, '1910207', '10a2', 'Lê Tý Anh', '04/06/2003', 'Nam ', 'Quận 5', 'anhty@gmail.com'),
(29, '1910208', '10a2', 'Trương Hồ Tú Hảo', '14/02/2003', 'Nữ ', 'Quận 12', 'haotu14@gmail.com'),
(30, '1910209', '10a2', 'Lê Hòa Bình', '04/12/2003', 'Nam ', 'Quận 2', 'hoabinh@gmail.com'),
(31, '1910210', '10a2', 'Liên Hùng', '04/09/2003', 'Nam ', 'Quận 3', 'hunglen@gmail.com'),
(32, '1910211', '10a2', 'Nguyễn Bính Hồ', '24/02/2003', 'Nam ', 'Quận 6', 'hobinh@gmail.com'),
(33, '1910212', '10a2', 'Lê Dương Hoa', '04/03/2003', 'Nữ ', 'Quận 5', 'hoaduong@gmail.com'),
(34, '1910213', '10a2', 'Dương Hoàn Lý', '14/12/2003', 'Nam ', 'Quận 12', 'lyhoan@gmail.com'),
(35, '1910214', '10a2', 'Nguyễn Anh Viên', '24/02/2003', 'Nam ', 'Quận 9', 'vienanh@gmail.com'),
(36, '1910215', '10a2', 'Lê Bảo Anh', '04/01/2003', 'Nữ ', 'Quận 8', 'baoanh@gmail.com'),
(37, '1910216', '10a2', 'Hồ Quý Ly', '04/12/2003', 'Nam ', 'Quận 9', 'hoquy@gmail.com'),
(38, '1910217', '10a2', 'Hồ Hảo Hến', '04/12/2003', 'Nam ', 'Quận 8', 'henho@gmail.com'),
(39, '1910218', '10a2', 'Lê Tuyền Anh', '04/09/2003', 'Nữ ', 'Quận 4', 'anhle@gmail.com'),
(40, '1910219', '10a2', 'Trương Anh Kiệt', '04/12/2003', 'Nam ', 'Quận 12', 'kietque@gmail.com'),
(41, '1910220', '10a2', 'Lê Hùng Anh', '01/02/2003', 'Nam ', 'Quận 8', 'hunganh@gmail.com'),
(42, '1910221', '10a2', 'Hồ Quang Huy', '04/12/2003', 'Nam ', 'Quận 11', 'quangle@gmail.com'),
(43, '1910301', '10a3', 'Lê Tú ', '04/02/2003', 'Nữ ', 'Quận 5', 'tutu@gmail.com'),
(44, '1910302', '10a3', 'Lê Hoàn Dân', '14/02/2003', 'Nam ', 'Quận 2', 'hoandan@gmail.com'),
(45, '1910303', '10a3', 'Lê Hoàn Tín', '04/03/2003', 'Nam ', 'Quận 2', 'hoanle@gmail.com'),
(46, '1910304', '10a3', 'Dương Bá Cảnh', '04/12/2003', 'Nam ', 'Quận 1', 'baba@gmail.com'),
(47, '1910305', '10a3', 'Lê Dương Bảo Bảo', '18/02/2003', 'Nam ', 'Quận 5', 'baobao@gmail.com'),
(48, '1910306', '10a3', 'Lê Anh Bá', '04/06/2003', 'Nam ', 'Quận 1', 'baanh@gmail.com'),
(49, '1910307', '10a3', 'Nguyễn Tú Hảo', '04/09/2003', 'Nữ ', 'Quận 11', 'haotu@gmail.com'),
(50, '1910308', '10a3', 'Ninh Dương Bảo', '18/02/2003', 'Nam ', 'Quận 1', 'baoninh@gmail.com'),
(51, '1910309', '10a3', 'Nguyễn Hoàn Tú', '04/12/2003', 'Nữ ', 'Quận 4', 'hoantu@gmail.com'),
(52, '1910310', '10a3', 'Lê Ngọc Ánh', '04/12/2003', 'Nữ ', 'Quận 1', 'ngocanh@gmail.com'),
(53, '1910311', '10a3', 'Nguyễn Hoàn Tú Anh', '09/02/2003', 'Nữ ', 'Quận 8', 'hoantu@gmail.com'),
(54, '1910312', '10a3', 'Nguyễn Lê Phi', '04/07/2003', 'Nam ', 'Quận Tân Phú', 'phiphi@gmail.com'),
(55, '1910313', '10a3', 'Lê Diệc Phi', '02/02/2003', 'Nữ ', 'Quận 3', 'diecle@gmail.com'),
(56, '1910314', '10a3', 'Trương Anh Phiên', '03/02/2003', 'Nam ', 'Quận 11', 'phienanh@gmail.com'),
(57, '1910315', '10a3', 'Trần Anh Hoa', '04/12/2003', 'Nữ ', 'Quận 6', 'caumuoi@gmail.com'),
(58, '1910316', '10a3', 'Lê Trí Anh', '04/07/2003', 'Nam ', 'Quận 11', 'anhtri@gmail.com'),
(59, '1910317', '10a3', 'Trần Minh Hoàng', '03/02/2003', 'Nam ', 'Quận 12', 'minhhoang@gmail.com'),
(60, '1910318', '10a3', 'Châu Anh Hảo', '04/01/2003', 'Nam ', 'Quận 2', 'haoanh@gmail.com'),
(61, '1910319', '10a3', 'Châu Chí Hùng', '03/02/2003', 'Nam ', 'Quận 12', 'hunghung@gmail.com'),
(62, '1910320', '10a3', 'Lê Hoàn Hảo', '04/11/2003', 'Nam ', 'Quận 9', 'haohaohoan@gmail.com'),
(63, '1910401', '10a4', 'Lê Hà Anh', '04/12/2003', 'Nữ ', 'Quận 5', 'haanh@gmail.com'),
(64, '1910402', '10a4', 'Lê Bá Hảo', '04/01/2003', 'Nam', 'Quận 1', 'haoba@gmail.com'),
(65, '1910403', '10a4', 'Trần Tú Hảo', '14/02/2003', 'Nam ', 'Quận 11', 'haotrantu@gmail.com'),
(66, '1910404', '10a4', 'Lê Dương Tú Hảo', '04/04/2003', 'Nữ ', 'Quận 12', 'haotutu@gmail.com'),
(67, '1910405', '10a4', 'Dương Tú Hảo', '14/02/2003', 'Nam ', 'Quận 4', 'haoduongtu@gmail.com'),
(68, '1910406', '10a4', 'Đường Bá Tú', '19/02/2003', 'Nam ', 'Quận 8', 'batu@gmail.com'),
(69, '1910407', '10a4', 'Trương Mỹ Hoa', '19/02/2003', 'Nữ ', 'Quận Bình Thạnh', 'hoamy@gmail.com'),
(70, '1910408', '10a4', 'Trương Vệ Kiện', '04/12/2003', 'Nam ', 'Quận Tân Bình', 'kienkien@gmail.com'),
(71, '1910409', '10a4', 'Hoàng Thùy Linh', '11/02/2003', 'Nữ ', 'Quận 9', 'linhthuy@gmail.com'),
(72, '1910410', '10a4', 'Lê Bảo', '04/12/2003', 'Nam ', 'Quận 11', 'baole@gmail.com'),
(73, '1910411', '10a4', 'Anh Tú', '09/02/2003', 'Nam ', 'Quận 1', 'anhtu@gmail.com'),
(74, '1910412', '10a4', 'Hoàng Bảo Anh', '04/06/2003', 'Nữ ', 'Quận 2', 'baoanh@gmail.com'),
(75, '1910413', '10a4', 'Hồ Trung Kiên', '19/02/2003', 'Nam ', 'Quận Gò Vấp', 'anhhungca@gmail.com'),
(76, '1910414', '10a4', 'Lê Dương Hòa', '03/02/2003', 'Nam ', 'Quận Bình Thạnh', 'kykaka@gmail.com'),
(77, '1910415', '10a4', 'Hồ Dũng Anh', '04/11/2003', 'Nam ', 'Quận Bình Chánh', 'kythuatgia@gmail.com'),
(78, '1910416', '10a4', 'Lê Tuấn Dũng', '13/02/2003', 'Nam ', 'Quận Tân Phú', 'nguoigiakim@gmail.com'),
(79, '1910417', '10a4', 'Nguyễn Bá Tiên', '24/02/2003', 'Nam ', 'Quận 3', 'tienbadao@gmail.com'),
(80, '1910418', '10a4', 'Đinh Bá Hùng', '04/12/2003', 'Nam ', 'Quận 8', 'hungbathienha@gmail.com'),
(81, '1910419', '10a4', 'Trương Hoa Tú', '14/02/2003', 'Nữ ', 'Quận 9', 'hoatu@gmail.com'),
(82, '1910420', '10a4', 'Nguyễn Vy', '14/09/2003', 'Nữ ', 'Quận 5', 'vyvy@gmail.com'),
(83, '1811101', '11a1', 'Đường Thái Tông', '04/12/2002', 'Nam ', 'Quận 5', 'vuanhaduong@gmail.com'),
(84, '1811102', '11a1', 'Đường Bá Hổ', '24/02/2002', 'Nam ', 'Quận 1', 'thitai@gmail.com'),
(85, '1811103', '11a1', 'Đường Thế Dân', '04/12/2002', 'Nam ', 'Quận 3', 'vuanhaduong@gmail.com'),
(86, '1811104', '11a1', 'Trần Nhân Tông', '19/02/2002', 'Nam ', 'Quận 12', 'vuavietnam@gmail.com'),
(87, '1811105', '11a1', 'Trần Thế Tông', '18/02/2002', 'Nam ', 'Quận 8', 'vuanhatran@gmail.com'),
(88, '1811106', '11a1', 'Hồ Quý Lý', '04/12/2002', 'Nam ', 'Quận 5', 'phando@gmail.com'),
(89, '1811107', '11a1', 'Dương Văn Lâm', '18/09/2002', 'Nam ', 'Quận 9', 'lamrung@gmail.com'),
(90, '1811108', '11a1', 'Lý Bá Cảnh', '12/02/2002', 'Nam ', 'Quận 2', 'canhba@gmail.com'),
(91, '1811109', '11a1', 'Dương Mỹ Hạnh', '15/02/2002', 'Nữ ', 'Quận 4', 'hanhmy@gmail.com'),
(92, '1811110', '11a1', 'Lê Huỳnh Anh', '04/12/2002', 'Nữ ', 'Quận 3', 'huynhanhsin@gmail.com'),
(93, '1811111', '11a1', 'Lê Ngọc Anh', '09/02/2002', 'Nữ ', 'Quận Tân Phú', 'anhngoc@gmail.com'),
(94, '1811112', '11a1', 'Nguyễn Vĩnh Viên', '14/02/2002', 'Nam ', 'Quận Bình Thạnh', 'vienvien@gmail.com'),
(95, '1811113', '11a1', 'Ngô Gia Tự', '11/02/2002', 'Nam ', 'Quận 5', 'giatustreet@gmail.com'),
(96, '1811114', '11a1', 'Ngô Gia Bảo', '04/04/2002', 'Nam ', 'Quận 10', 'baobao@gmail.com'),
(97, '1811115', '11a1', 'Lê Vĩnh Kỳ', '04/05/2002', 'Nam ', 'Quận 1', 'kyky@gmail.com'),
(98, '1811116', '11a1', 'Lê Tú Duyên', '24/02/2002', 'Nữ ', 'Quận Bình Thạnh', 'duyenduyengmail.com'),
(99, '1811117', '11a1', 'Lê Tôn Tú Hảo', '04/12/2002', 'Nữ ', 'Quận 9', 'congchuanhanguyen@gmail.com'),
(100, '1811118', '11a1', 'Tôn Tằng Quý Hảo', '04/09/2002', 'Nữ ', 'Quận 3', 'quyhoa@gmail.com'),
(101, '1811119', '11a1', 'Lưu Diệc Phi', '02/02/2002', 'Nữ ', 'Quận 9', 'hoahongdo@gmail.com'),
(102, '1811120', '11a1', 'Lưu Thi Thi', '04/05/2002', 'Nữ ', 'Quận 11', 'thuthu@gmail.com'),
(103, '1811201', '11a2', 'Lê Bá Cảnh', '01/02/2002', 'Nam ', 'Quận 5', 'bacanh@gmail.com'),
(104, '1811202', '11a2', 'Trần Tú Hảo', '02/03/2002', 'Nữ ', 'Quận 2', 'haotu@gmail.com'),
(105, '1811203', '11a2', 'Dương Tú Hảo', '03/02/2002', 'Nữ ', 'Quận 4', 'haotu@gmail.com'),
(106, '1811204', '11a2', 'Lê Hiểu Anh', '03/05/2002', 'Nữ ', 'Quận 7', 'hieuanh@gmail.com'),
(107, '1811205', '11a2', 'Trần Bảo Lâm', '04/03/2002', 'Nam ', 'Quận 2', 'baolam@gmail.com'),
(108, '1811206', '11a2', 'Trần Dương Anh Huy', '05/07/2002', 'Nam ', 'Quận 4', 'haotu@gmail.com'),
(109, '1811207', '11a2', 'Hồ Quang Ca', '06/02/2002', 'Nam ', 'Quận 7', 'quangcaca@gmail.com'),
(110, '1811208', '11a2', 'Hồ Quang Huy', '07/09/2002', 'Nam ', 'Quận 9', 'huyhuya@gmail.com'),
(111, '1811209', '11a2', 'Hồ Quang Diệu', '08/02/2002', 'Nam ', 'Quận 4', 'quangdieu@gmail.com'),
(112, '1811210', '11a2', 'Hồ Lên Anh Thảo', '09/04/2002', 'Nữ ', 'Quận 6', 'anhthao@gmail.com'),
(113, '1811211', '11a2', 'Trần Dương Tú', '01/04/2002', 'Nam ', 'Quận 2', 'tuduong@gmail.com'),
(114, '1811212', '11a2', 'Nguyễn Tiên Thảo', '02/05/2002', 'Nữ ', 'Quận 7', 'tientien@gmail.com'),
(115, '1811213', '11a2', 'Nguyễn Cẩm Tiên', '04/06/2002', 'Nữ ', 'Quận 2', 'tiencam@gmail.com'),
(116, '1811214', '11a2', 'Nguyễn Duy Tiến', '05/04/2002', 'Nam ', 'Quận 7', 'itech@gmail.com'),
(117, '1811215', '11a2', 'Trần Hoàng Hồng', '06/03/2002', 'Nữ ', 'Quận 3', 'honghong@gmail.com'),
(118, '1811216', '11a2', 'Trần Tú Duyên', '02/01/2002', 'Nữ ', 'Quận 2', 'duyentu@gmail.com'),
(119, '1811217', '11a2', 'Lâm Anh Duy', '09/07/2002', 'Nam ', 'Quận 9', 'duyduygmail.com'),
(120, '1811218', '11a2', 'Trần Dương Tuyền', '11/04/2002', 'Nữ ', 'Quận 11', 'tuyen22@gmail.com'),
(173, '1712221', '12a2', 'Trịnh Kim Anh', '22/02/2001', 'Nữ ', 'Quận 5', 'anhkim121@gmail.com'),
(174, '1712222', '12a2', 'Trịnh Cẩm Đào', '15/03/2001', 'Nữ ', 'Quận 2', 'daotrinh@gmail.com'),
(175, '1712223', '12a2', 'Dương Cẩm Tiên', '12/11/2001', 'Nữ ', 'Quận 4', 'camtien192@gmail.com'),
(176, '1712224', '12a2', 'Lê Hoàng Tiên', '03/05/2001', 'Nữ ', 'Quận 7', 'tienle182@gmail.com'),
(177, '1712225', '12a2', 'Trần Bá Lâm', '22/03/2001', 'Nam ', 'Quận 12', 'balam979@gmail.com'),
(178, '1712226', '12a2', 'Dương Anh Huy', '05/07/2001', 'Nam ', 'Quận 4', 'hao183tu@gmail.com'),
(179, '1712227', '12a2', 'Nguyễn Kiều Huy', '14/11/2001', 'Nam ', 'Quận 7', 'huy9263@gmail.com'),
(180, '1712228', '12a2', 'Lê Sĩ Hùng', '22/11/2001', 'Nam ', 'Quận 9', 'húngi868@gmail.com'),
(181, '1712229', '12a2', 'Hoàng Kim Yến', '08/02/2001', 'Nữ ', 'Quận 4', 'yenyenmuimui@gmail.com'),
(182, '1712230', '12a2', 'Lê Anh Tín', '11/04/2001', 'Nam ', 'Quận 6', 'tianh989@gmail.com'),
(183, '1712231', '12a2', 'Lương Cung Cảnh', '01/04/2001', 'Nam ', 'Quận 12', 'tienkiemkyhiep111@gmail.com'),
(184, '1712232', '12a2', 'Nguyễn Hoàng Thùy', '12/05/2001', 'Nữ ', 'Quận 7', 'linhthuy27@gmail.com'),
(185, '1712233', '12a2', 'Trần Công Tiển', '04/06/2001', 'Nam ', 'Quận 2', 'cungtien273@gmail.com'),
(186, '1712234', '12a2', 'Lý Hoàng Kim', '05/11/2001', 'Nữ ', 'Quận 7', 'kile@gmail.com'),
(187, '1712235', '12a2', 'Lý Kinh Hòa', '26/11/2001', 'Nữ ', 'Quận 3', 'hoalekinh2920@gmail.com'),
(188, '1712236', '12a2', 'Nguyễn Dương Thảo', '27/01/2001', 'Nữ ', 'Quận 12', 'thao271@gmail.com'),
(189, '1712237', '12a2', 'Trần Vĩnh Kiên', '31/09/2001', 'Nam ', 'Quận 1', 'vinhkien182@gmail.com'),
(190, '1712238', '12a2', 'Lê Văn Dương', '23/01/2001', 'Nam ', 'Quận 1', 'duongle193@gmail.com'),
(191, '1712239', '12a2', 'Trần Hòa Dân', '12/11/2001', 'Nam ', 'Quận 2', 'danhoa173@gmail.com'),
(192, '1712240', '12a2', 'Lê Văn Lưu', '19/12/2001', 'Nam ', 'Quận 2', 'luuluyen183@gmail.com'),
(193, '1912101', '12a1', ' nguyễn phú vinh', '01/01/2003', 'Nam', ' bến tre', ' npvinh230@gmail.com'),
(200, '1910224', '10a2', 'vip huy', '01/01/2003', 'Nữ', '12', 'huy@dom.com'),
(201, '1910120', '10a1', 'viphuy', '07/01/2003', 'Nam', 'quan 12', 'huy@gmail.com'),
(202, '1912102', '12a1', 'ha', '01/01/2003', 'Nam', '24', 'congty@gmail.com');

SET SQL_SAFE_UPDATES = 0;
UPDATE hocsinh SET nienkhoa = '2019' WHERE (mahocsinh = '1910101');
UPDATE hocsinh SET nienkhoa = '2019' WHERE (mahocsinh = '1910102');
UPDATE hocsinh SET nienkhoa = '2019' WHERE (mahocsinh = '1910201');
-- --------------------------------------------------------

--
-- Table structure for table `khoi`
--

CREATE TABLE `khoi` (
  `id` int(11) UNSIGNED NOT NULL,
  `tenkhoi` varchar(255) NOT NULL,
  `sisotoida` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `khoi`
--

INSERT INTO `khoi` (`id`, `tenkhoi`, `sisotoida`) VALUES
(1, 'lớp 10', 20),
(2, 'lớp 11', 20),
(3, 'lớp 12', 40);

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE `lop` (
  `id` int(11) UNSIGNED NOT NULL,
  `malop` varchar(255) NOT NULL,
  `tenlop` varchar(255) NOT NULL,
  `khoi` int(11) UNSIGNED NOT NULL,
  `siso` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`id`, `malop`, `tenlop`, `khoi`, `siso`) VALUES
(1, '10a1', '10 A1', 1, 21),
(2, '10a2', '10 A2', 1, 23),
(3, '10a3', '10 A3', 1, 20),
(4, '10a4', '10 A4', 1, 20),
(5, '11a1', '11 A1', 2, 20),
(6, '11a2', '11 A2', 2, 18),
(7, '11a3', '11 A3', 2, 0),
(8, '12a1', '12 A1', 3, 2),
(9, '12a2', '12 A2', 3, 20);

-- --------------------------------------------------------




--
-- Table structure for table `mon`
--

CREATE TABLE `mon` (
  `id` int(11) UNSIGNED NOT NULL,
  `tenmon` varchar(255) NOT NULL,
  `hesomon` varchar(255) NOT NULL,
  `mamon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `mon`
--

INSERT INTO `mon` (`id`, `tenmon`, `hesomon`, `mamon`) VALUES
(1, 'Toán Học', '10', 'toan'),
(2, 'Văn Học', '10', 'van'),
(3, 'Vật Lý', '10', 'ly'),
(4, 'Hóa Học', '10', 'hoa'),
(5, 'Sinh Học', '10', 'sinh'),
(6, 'Lịch Sử', '10', 'su'),
(7, 'Địa Lý', '10', 'dia'),
(8, 'Đạo Đức', '10', 'daoduc'),
(9, 'Thể Dục', '10', 'theduc'),
(10, 'GIÁO DỤC GIỚI TINH s', '10', 'gioitinh');

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen`
--

CREATE TABLE `phanquyen` (
  `id` int(11) UNSIGNED NOT NULL,
  `tenchucvu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `phanquyen`
--

INSERT INTO `phanquyen` (`id`, `tenchucvu`) VALUES
(1, 'Giáo Viên'),
(2, 'Giáo Vụ');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) UNSIGNED NOT NULL,
  `tentaikhoan` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `chucvu` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `tentaikhoan`, `matkhau`, `chucvu`) VALUES
(2, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 2),
(3, '17520884', 'e10adc3949ba59abbe56e057f20f883e', 1),
(4, '17520616', '827ccb0eea8a706c4c34a16891f84e7b', 1);


--
-- Indexes for dumped tables
--

--
-- Indexes for table `diem`
--
ALTER TABLE `diem`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `mahocsinh` (`mahocsinh`),
  ADD KEY `mamonhoc` (`mamonhoc`),
  ADD KEY `mahocky` (`mahocky`),
  ADD KEY `malop` (`malop`);

--
-- Indexes for table `giaovu`
--
ALTER TABLE `giaovu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hocky`
--
ALTER TABLE `hocky`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `mahocky` (`mahocky`);

--
-- Indexes for table `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `lop` (`lop`) USING BTREE,
  ADD KEY `mahocsinh` (`mahocsinh`);

--
-- Indexes for table `khoi`
--
ALTER TABLE `khoi`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `khoi` (`khoi`) USING BTREE,
  ADD KEY `malop` (`malop`);

--
-- Indexes for table `mon`
--
ALTER TABLE `mon`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `mamon` (`mamon`);

--
-- Indexes for table `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`id`) USING BTREE;
  
  ALTER TABLE `hanhkiem`
  ADD PRIMARY KEY (`id`) USING BTREE;
  
  



--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `chucvu` (`chucvu`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diem`
--
ALTER TABLE `diem`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `giaovu`
--
ALTER TABLE `giaovu`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `hocky`
--
ALTER TABLE `hocky`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hocsinh`
--
ALTER TABLE `hocsinh`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=203;

--
-- AUTO_INCREMENT for table `khoi`
--
ALTER TABLE `khoi`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `lop`
--
ALTER TABLE `lop`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `mon`
--
ALTER TABLE `mon`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
  ALTER TABLE `hanhkiem`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `mon` ADD UNIQUE(tenmon);
ALTER TABLE `mon` ADD UNIQUE(mamon);

--
-- AUTO_INCREMENT for table `phanquyen`
--
ALTER TABLE `phanquyen`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
  
 

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `diem_ibfk_1` FOREIGN KEY (`mahocsinh`) REFERENCES `hocsinh` (`mahocsinh`),
  ADD CONSTRAINT `diem_ibfk_2` FOREIGN KEY (`mamonhoc`) REFERENCES `mon` (`mamon`),
  ADD CONSTRAINT `diem_ibfk_3` FOREIGN KEY (`mahocky`) REFERENCES `hocky` (`mahocky`),
  ADD CONSTRAINT `diem_ibfk_4` FOREIGN KEY (`malop`) REFERENCES `lop` (`malop`);

--
-- Constraints for table `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD CONSTRAINT `hocsinh_ibfk_1` FOREIGN KEY (`lop`) REFERENCES `lop` (`malop`);

--
-- Constraints for table `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `lop_ibfk_1` FOREIGN KEY (`khoi`) REFERENCES `khoi` (`id`);
ALTER TABLE `lop` ADD UNIQUE(malop);
ALTER TABLE `lop` ADD UNIQUE(tenlop);
--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`chucvu`) REFERENCES `phanquyen` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
