-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2014 at 02:23 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `humap`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_data_member`
--

CREATE TABLE IF NOT EXISTS `tbl_data_member` (
  `id` int(32) NOT NULL,
  `title` varchar(128) DEFAULT NULL,
  `firstname` varchar(128) NOT NULL,
  `lastname` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `phone` varchar(32) NOT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `fax` varchar(32) DEFAULT NULL,
  `organization` varchar(256) DEFAULT NULL,
  `street` varchar(128) DEFAULT NULL,
  `city` varchar(128) DEFAULT NULL,
  `state` varchar(128) DEFAULT NULL,
  `zipcode` varchar(16) DEFAULT NULL,
  `country` varchar(128) DEFAULT NULL,
  `remark` varchar(1024) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `signuptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastupdatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastsignintime` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_data_member`
--

INSERT INTO `tbl_data_member` (`id`, `title`, `firstname`, `lastname`, `email`, `phone`, `mobile`, `fax`, `organization`, `street`, `city`, `state`, `zipcode`, `country`, `remark`, `password`, `signuptime`, `lastupdatetime`, `lastsignintime`) VALUES
(100, NULL, 'Jared', 'Qin', 'jaredqin@gmail.com', '0449893796', NULL, NULL, '', '', NULL, NULL, NULL, NULL, NULL, '*9CF2A93034C849E088656565F76A2B4187784CF8', '2014-05-21 15:02:52', '2014-05-21 15:02:52', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_data_order_intent`
--

CREATE TABLE IF NOT EXISTS `tbl_data_order_intent` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL,
  `firstname` varchar(256) DEFAULT NULL,
  `lastname` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `phone` varchar(256) DEFAULT NULL,
  `organization` varchar(512) DEFAULT NULL,
  `remark` varchar(4096) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_data_product`
--

CREATE TABLE IF NOT EXISTS `tbl_data_product` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `cataloguenumber` varchar(128) NOT NULL,
  `organ` varchar(128) NOT NULL,
  `description` varchar(512) DEFAULT NULL,
  `species` varchar(128) DEFAULT NULL,
  `fixative` varchar(128) DEFAULT NULL,
  `totalcases` varchar(128) NOT NULL,
  `totalcores` varchar(128) NOT NULL,
  `corediameter` varchar(128) NOT NULL,
  `sectionthickness` varchar(128) DEFAULT NULL,
  `validation` varchar(128) DEFAULT NULL,
  `tissuesummary` varchar(512) DEFAULT NULL,
  `storage` varchar(512) DEFAULT NULL,
  `usage` varchar(512) DEFAULT NULL,
  `corescaseset` varchar(128) DEFAULT NULL,
  `pathdiagset` varchar(128) DEFAULT NULL,
  `inforset` varchar(128) DEFAULT NULL,
  `organid` int(32) NOT NULL,
  `unitprice` varchar(32) NOT NULL,
  `pricingunit` varchar(32) NOT NULL DEFAULT 'AUD/1 slide',
  PRIMARY KEY (`id`),
  KEY `corescaseset` (`corescaseset`),
  KEY `pathdiagset` (`pathdiagset`),
  KEY `inforset` (`inforset`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2802 ;


--
-- Table structure for table `tbl_data_resource`
--

CREATE TABLE IF NOT EXISTS `tbl_data_resource` (
  `id` int(32) NOT NULL,
  `name` varchar(128) NOT NULL,
  `desc` varchar(512) NOT NULL,
  `sort` int(4) NOT NULL,
  `filepath` varchar(128) NOT NULL,
  `filename` varchar(128) NOT NULL,
  `filetype` varchar(32) NOT NULL,
  `type` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_dict_universal`
--

CREATE TABLE IF NOT EXISTS `tbl_dict_universal` (
  `id` int(32) NOT NULL,
  `name` varchar(128) NOT NULL,
  `value` varchar(128) NOT NULL,
  `desc` varchar(512) DEFAULT NULL,
  `parentid` int(32) NOT NULL DEFAULT '0',
  `sort` int(4) NOT NULL DEFAULT '0',
  `type` int(32) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_dict_universal`
--

INSERT INTO `tbl_dict_universal` (`id`, `name`, `value`, `desc`, `parentid`, `sort`, `type`) VALUES
(1, 'Brain', '1', 'Brain', 0, 3, 1001),
(2, 'Bladder', '2', 'Bladder', 0, 2, 1001),
(8, 'tumor only', '8', 'tumor only', 0, 1, 1003),
(9, '1', '9', '1', 0, 1, 1002),
(10, '2', '10', '2', 0, 2, 1002),
(11, '3', '11', '3', 0, 3, 1002),
(12, '4', '12', '4', 0, 4, 1002),
(13, 'others', '13', 'others', 0, 5, 1002),
(14, 'with normal adjacent tissue', '14', 'with normal adjacent tissue', 0, 4, 1003),
(15, 'with distant normal tissue', '15', 'with distant normal tissue', 0, 5, 1003),
(16, 'with diseased', '16', 'with diseased', 0, 6, 1003),
(17, 'with lymph nodes', '17', 'with lymph nodes', 0, 7, 1003),
(18, 'with metastasis', '18', 'with metastasis', 0, 8, 1003),
(19, 'progression', '19', 'progression', 0, 9, 1003),
(20, 'aborted fetus', '20', 'aborted fetus', 0, 10, 1003),
(21, 'other', '21', 'other', 0, 11, 1003),
(22, 'basic information only', '22', 'basic information only', 0, 1, 1004),
(23, 'with TNM stage', '23', 'with TNM stage', 0, 2, 1004),
(24, 'with survival information', '24', 'with survival information', 0, 3, 1004),
(25, 'with medical history', '25', 'with medical history', 0, 5, 1004),
(26, 'with IHC data', '26', 'with IHC data', 0, 4, 1004),
(27, 'with Gleason grade', '27', 'with Gleason grade', 0, 6, 1004),
(28, 'biochemical indicator', '28', 'biochemical indicator', 0, 7, 1004),
(31, 'normal tissue only', '31', 'normal tissue only', 0, 2, 1003),
(32, 'with normal tissue', '32', 'with normal tissue', 0, 3, 1003),
(98, 'Colon', '98', 'Colon', 0, 5, 1001),
(99, 'Digestive system', '99', 'Digestive system', 0, 6, 1001),
(100, 'Esophagus', '100', 'Esophagus', 0, 7, 1001),
(102, 'Kidney', '102', 'Kidney', 0, 9, 1001),
(104, 'Lung', '104', 'Lung', 0, 11, 1001),
(105, 'Multiple organ', '105', 'Multiple organ', 0, 13, 1001),
(107, 'Pancreas', '107', 'Pancreas', 0, 15, 1001),
(108, 'Rectum', '108', 'Rectum', 0, 17, 1001),
(110, 'Skin', '110', 'Skin', 0, 19, 1001),
(113, 'Stomach', '113', 'Stomach', 0, 20, 1001),
(114, 'Liver', '114', 'Liver', 0, 10, 1001),
(115, 'Lymphoma', '115', 'Lymphoma', 0, 12, 1001),
(116, 'Prostate', '116', 'Prostate', 0, 16, 1001),
(117, 'Reproductive system', '117', 'Reproductive system', 0, 18, 1001),
(118, 'Thyroid', '118', 'Thyroid', 0, 21, 1001),
(119, 'Urological system', '119', 'Urological system', 0, 22, 1001),
(120, 'Uterus', '120', 'Uterus', 0, 23, 1001),
(121, 'Breast', '121', 'Breast', 0, 4, 1001),
(122, 'Ovarium', '122', 'Ovarium', 0, 14, 1001),
(123, 'Bile Ducts', '123', 'Bile Ducts', 0, 1, 1001),
(124, 'Gallbladder', '124', 'Gallbladder', 0, 8, 1001),
(1001, 'Organ', '1001', 'Organ', 0, 1, 0),
(1002, 'Cores/case', '1002', 'Cores/case', 0, 2, 0),
(1003, 'Pathology diagnosis', '1003', 'Pathology diagnosis', 0, 3, 0),
(1004, 'Information', '1004', 'Information', 0, 4, 0),
(1005, 'Resource type', '1005', 'Resource type', 0, 5, 0),
(1006, 'File type', '1006', 'File type', 0, 6, 0),
(1007, 'Publication years', '1007', 'Publication years', 0, 7, 0),
(2009, '2009', '2009', '2009', 0, 1, 1007),
(2010, '2010', '2010', '2010', 0, 2, 1007),
(2011, '2011', '2011', '2011', 0, 3, 1007),
(2012, '2012', '2012', '2012', 0, 4, 1007),
(2013, '2013', '2013', '2013', 0, 5, 1007),
(2014, '2014', '2014', '2014', 0, 6, 1007);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_ref_product_resource`
--

CREATE TABLE IF NOT EXISTS `tbl_ref_product_resource` (
  `productid` int(32) NOT NULL COMMENT '=tbl_data_product.id',
  `resourceid` int(32) NOT NULL COMMENT '=tbl_data_resource.id',
  `sort` int(4) NOT NULL DEFAULT '0',
  `filename` varchar(512) DEFAULT NULL,
  `filepath` varchar(512) DEFAULT NULL,
  `filetype` varchar(32) NOT NULL,
  `name` varchar(512) NOT NULL,
  `desc` varchar(512) DEFAULT NULL,
  `type` int(4) NOT NULL DEFAULT '1',
  `id` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
