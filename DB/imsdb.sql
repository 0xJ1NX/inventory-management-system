-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2024 at 10:42 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `imsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
                            `customer_id` bigint(20) NOT NULL,
                            `address` varchar(255) NOT NULL,
                            `email` varchar(255) NOT NULL,
                            `name` varchar(255) NOT NULL,
                            `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `address`, `email`, `name`, `phone`) VALUES
    (12, 'ramallah', 'dsfdsfdsf', 'omjlkjlklkar', '0568347131');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
                        `item_id` bigint(20) NOT NULL,
                        `description` text DEFAULT NULL,
                        `name` varchar(255) NOT NULL,
                        `price` decimal(10,2) NOT NULL,
                        `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `description`, `name`, `price`, `quantity`) VALUES
                                                                               (4, '14', 'm', '22.00', 98),
                                                                               (5, '1234', 'mfmo', '22.00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
                          `order_id` bigint(20) NOT NULL,
                          `date` datetime(6) NOT NULL,
                          `customerid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `date`, `customerid`) VALUES
    (9, '2024-04-17 23:33:45.529000', 12);

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

CREATE TABLE `order_item` (
                              `order_item_id` bigint(20) NOT NULL,
                              `quantity` int(11) NOT NULL,
                              `itemid` bigint(20) NOT NULL,
                              `orderid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_item`
--

INSERT INTO `order_item` (`order_item_id`, `quantity`, `itemid`, `orderid`) VALUES
    (13, 2, 4, 9);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
                            `supplier_id` bigint(20) NOT NULL,
                            `address` varchar(255) NOT NULL,
                            `email` varchar(255) NOT NULL,
                            `name` varchar(255) NOT NULL,
                            `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `address`, `email`, `name`, `phone`) VALUES
    (2, 'ramallah', 'dsfdsfdsf', 'sdfgh', '0568347131');

-- --------------------------------------------------------

--
-- Table structure for table `supply`
--

CREATE TABLE `supply` (
                          `supplyid` bigint(20) NOT NULL,
                          `date` datetime(6) NOT NULL,
                          `ppu` decimal(10,2) NOT NULL,
                          `quantity` int(11) NOT NULL,
                          `itemid` bigint(20) NOT NULL,
                          `supplierid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supply`
--

INSERT INTO `supply` (`supplyid`, `date`, `ppu`, `quantity`, `itemid`, `supplierid`) VALUES
    (2, '2024-04-17 23:06:09.834000', '220.00', 100, 4, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
    ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
    ADD PRIMARY KEY (`item_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
    ADD PRIMARY KEY (`order_id`),
    ADD KEY `FKbhieamq65ke02r8ijfso5tivn` (`customerid`);

--
-- Indexes for table `order_item`
--
ALTER TABLE `order_item`
    ADD PRIMARY KEY (`order_item_id`),
    ADD KEY `FKrffp1wvvbgxi3qf9u125913j5` (`itemid`),
    ADD KEY `FK6qdi17749hl3bd01qyvxkid49` (`orderid`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
    ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `supply`
--
ALTER TABLE `supply`
    ADD PRIMARY KEY (`supplyid`),
    ADD KEY `FK8um3ttr2lfwlmm0qkai9v6l0s` (`itemid`),
    ADD KEY `FK436g0f5h5ywnqk85u48vgl9c9` (`supplierid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
    MODIFY `customer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
    MODIFY `item_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
    MODIFY `order_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `order_item`
--
ALTER TABLE `order_item`
    MODIFY `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
    MODIFY `supplier_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `supply`
--
ALTER TABLE `supply`
    MODIFY `supplyid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
    ADD CONSTRAINT `FKbhieamq65ke02r8ijfso5tivn` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customer_id`);

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
    ADD CONSTRAINT `FK6qdi17749hl3bd01qyvxkid49` FOREIGN KEY (`orderid`) REFERENCES `orders` (`order_id`),
    ADD CONSTRAINT `FKrffp1wvvbgxi3qf9u125913j5` FOREIGN KEY (`itemid`) REFERENCES `item` (`item_id`);

--
-- Constraints for table `supply`
--
ALTER TABLE `supply`
    ADD CONSTRAINT `FK436g0f5h5ywnqk85u48vgl9c9` FOREIGN KEY (`supplierid`) REFERENCES `supplier` (`supplier_id`),
    ADD CONSTRAINT `FK8um3ttr2lfwlmm0qkai9v6l0s` FOREIGN KEY (`itemid`) REFERENCES `item` (`item_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
