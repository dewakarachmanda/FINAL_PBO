-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2023 at 07:35 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cepetdong`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `resi` varchar(255) NOT NULL,
  `ID` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `nohp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`resi`, `ID`, `nama`, `nohp`) VALUES
('', 'dewaka', '0001', 8122212),
('', 'coba', '0002', 9723232),
('', '0003', 'nopal', 8121212),
('', '0004', 'rexa', 812121212),
('', '9999', 'jk', 8121212);

-- --------------------------------------------------------

--
-- Table structure for table `kurir`
--

CREATE TABLE `kurir` (
  `idKurir` varchar(255) NOT NULL,
  `ID` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `nohp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kurir`
--

INSERT INTO `kurir` (`idKurir`, `ID`, `nama`, `nohp`) VALUES
('010', '001', 'naufal', 812222),
('0002', '002', 'ryan', 89898);

-- --------------------------------------------------------

--
-- Table structure for table `paket`
--

CREATE TABLE `paket` (
  `namaPaket` varchar(255) NOT NULL,
  `idPaket` varchar(255) NOT NULL,
  `beratPaket` int(11) NOT NULL,
  `kuantitas` int(11) NOT NULL,
  `hargaPaket` int(11) NOT NULL,
  `resiPaket` varchar(255) NOT NULL,
  `alamatTujuan` varchar(255) NOT NULL,
  `statusPengiriman` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paket`
--

INSERT INTO `paket` (`namaPaket`, `idPaket`, `beratPaket`, `kuantitas`, `hargaPaket`, `resiPaket`, `alamatTujuan`, `statusPengiriman`) VALUES
('Kasur', '001', 3, 1, 0, '', 'gn', '');

-- --------------------------------------------------------

--
-- Table structure for table `pengirim`
--

CREATE TABLE `pengirim` (
  `detailPaket` varchar(255) NOT NULL,
  `detailResi` varchar(255) NOT NULL,
  `ID` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `nohp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengirim`
--

INSERT INTO `pengirim` (`detailPaket`, `detailResi`, `ID`, `nama`, `nohp`) VALUES
('', '', 'ryan', '0001', 1221212111),
('', '', '001', 'nopal', 82121),
('', '', '0005', 'ryan', 82342123);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
