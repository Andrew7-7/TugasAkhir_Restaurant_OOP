CREATE TABLE MsLocation (
    LocationID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Location VARCHAR(50) NOT NULL,
    RestaurantType VARCHAR(20) NOT NULL
);

CREATE TABLE MsMenu (
    MenuID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    MenuName VARCHAR(225) NOT NULL,
    Price INT NOT NULL,
    AvailableOn VARCHAR(125) NOT NULL,
    OriginLocation VARCHAR(255),
    CharacteristicOrDescription VARCHAR(255)
);

CREATE TABLE MsTableType (
    TableTypeID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TableType VARCHAR(20) NOT NULL,
    MaxTableLoad INT NOT NULL
);

CREATE TABLE MsBranch (
    BranchID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LocationID INT,
    BranchName VARCHAR(125) NOT NULL,
    FOREIGN KEY (LocationID) REFERENCES MsLocation(LocationID)
);

CREATE TABLE MsEmployee (
    EmployeeID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    BranchID INT,
    EmployeeName VARCHAR(125) NOT NULL,
	EmployeeEmail VARCHAR(225) NOT NULL,
	EmployeePassword VARCHAR(225) NOT NULL,
    FOREIGN KEY (BranchID) REFERENCES MsBranch(BranchID)
);

CREATE TABLE TransactionDetail (
    OrderID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    EmployeeID INT,
    ReservedTime DATETIME NOT NULL,
    ReservationStatus VARCHAR(20) NOT NULL,
    FOREIGN KEY (EmployeeID) REFERENCES MsEmployee(EmployeeID)
);

CREATE TABLE TransactionHeader (
    OrderID INT NOT NULL,
    MenuID INT NOT NULL,
    PRIMARY KEY (OrderID, MenuID),
    MenuQuantity INT NOT NULL,
    TableTypeID INT NOT NULL,
    TableQuantity INT NOT NULL,
    CustomerName VARCHAR(225) NOT NULL,
    TotalPeopleReserved INT,
    FOREIGN KEY (OrderID) REFERENCES TransactionDetail(OrderID),
    FOREIGN KEY (MenuID) REFERENCES MsMenu(MenuID),
    FOREIGN KEY (TableTypeID) REFERENCES MsTableType(TableTypeID)
);

DELIMITER //

CREATE TRIGGER CheckAvailableOn
BEFORE INSERT ON MrMenu
FOR EACH ROW
BEGIN
    DECLARE branch_count INT;

    SELECT COUNT(*)
    INTO branch_count
    FROM MrMenu AS M
    LEFT JOIN MrBranch AS B ON NEW.AvailableOn = B.BranchName
    WHERE NEW.AvailableOn IS NOT NULL AND B.BranchID IS NULL;

    IF branch_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Such branch does not exist';
    END IF;
END;
//

DELIMITER ;


INSERT INTO MsLocation(Location, RestaurantType) VALUES ('Jakarta', 'Main');
INSERT INTO MsLocation(Location, RestaurantType) VALUES ('Surabaya', 'Local');
INSERT INTO MsLocation(Location, RestaurantType) VALUES ('Padang', 'Local');
INSERT INTO MsLocation(Location, RestaurantType) VALUES ('Bandung', 'Main');
INSERT INTO MsLocation(Location, RestaurantType) VALUES ('Samarinda', 'Local');
INSERT INTO MsLocation(Location, RestaurantType) VALUES ('Bali', 'Main');

INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Wagyu A5', 1000000, 'LaperAh Tanjung Duren', NULL, 'Di lereng pegunungan Jepang, Wagyu A5 terkenal dengan marbling luar biasa, tekstur lembut seperti awan, dan cita rasa mentega yang melumer di lidah, memberikan pengalaman kuliner mewah yang tak terlupakan.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Rawon', 250000, 'LaperAh Tunjungan Plaza', 'Banyuwangi', 'Rawon adalah sup tradisional Jawa Timur yang kaya rempah, berwarna hitam pekat karena penggunaan kluwek, dengan cita rasa gurih, pedas, dan lezat.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Nasi Goreng Kampung', 100000, 'LaperAh Tunjungan Plaza', NULL, NULL);
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Ayang Goreng', 80000, 'LaperAh Tunjungan Plaza', NULL, NULL);
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Rendang', 100000, 'LaperAh Bukittinggi', 'Padang Barat', 'Rendang, hidangan khas Padang, ditandai oleh daging yang empuk dimasak secara perlahan dengan campuran santan dan rempah-rempah yang kaya, menghasilkan sensasi rasa dan aroma yang lezat.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Sate Padang', 20000, 'LaperAh Bukittinggi', 'Padang Utara', 'Sate Padang, terkenal dengan cita rasa pedas dan bumbu kacang yang kaya, merupakan hidangan sate yang berasal dari Padang, Sumatra Barat, Indonesia.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Mie Ayam', 30000, 'LaperAh Alun-alun Bandung', NULL, NULL);
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Sate Kambing', 35000, 'LaperAh Alun-alun Bandung', NULL, NULL);
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Nasi Goreng Special', 50000, 'LaperAh Tanjung Duren', NULL, 'Nasi goreng spesial dengan berbagai tambahan lauk.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Ayam Bakar Kecap', 70000, 'LaperAh Tanjung Duren', NULL, 'Ayam bakar dengan saus kecap yang lezat.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Soto Betawi', 35000, 'LaperAh Tanjung Duren', NULL, 'Soto Betawi dengan daging sapi, kentang, dan santan.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Bakso Malang', 30000, 'LaperAh Tanjung Duren', NULL, 'Bakso Malang dengan pangsit dan kuah yang gurih.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Sate Ayam Madura', 20000, 'LaperAh Tunjungan Plaza', NULL, 'Sate ayam khas Madura dengan bumbu kacang yang nikmat.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Pempek Palembang', 30000, 'LaperAh Tunjungan Plaza', NULL, 'Pempek Palembang dengan cuko yang khas.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Mie Kocok Bandung', 25000, 'LaperAh Bukittinggi', NULL, 'Mie Kocok Bandung dengan daging sapi, bakso, dan kuah kocok yang khas.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Martabak Manis', 15000, 'LaperAh Bukittinggi', NULL, 'Martabak Manis dengan topping keju dan coklat.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Siomay Bandung', 18000, 'LaperAh Bukittinggi', NULL, 'Siomay Bandung dengan bumbu kacang dan kecap yang lezat.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Pisang Goreng', 10000, 'LaperAh Alun-alun Bandung', NULL, 'Pisang Goreng dengan tepung gurih.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Batagor', 15000, 'LaperAh Alun-alun Bandung', NULL, 'Batagor dengan bumbu kacang dan kecap yang lezat.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Surabi', 12000, 'LaperAh Alun-alun Bandung', NULL, 'Surabi dengan kelapa parut dan gula merah.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Sate Lilit Palaran', 25000, 'LaperAh Palaran', NULL, 'Sate lilit khas Bali dengan bumbu rempah yang lezat.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Lumpia Palaran', 15000, 'LaperAh Palaran', NULL, 'Lumpia dengan isian rebung dan ayam, disajikan dengan saus kacang.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Bebek Goreng Palaran', 80000, 'LaperAh Palaran', NULL, 'Bebek goreng dengan bumbu khas Palaran.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Nasi Kuning Palaran', 30000, 'LaperAh Palaran', NULL, 'Nasi kuning dengan lauk ayam, telur, dan kacang serundeng.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Es Cendol Palaran', 18000, 'LaperAh Palaran', NULL, 'Es cendol dengan santan dan gula merah.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Surabi Kuta', 12000, 'LaperAh Kuta', NULL, 'Surabi dengan kelapa parut dan gula merah.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Es Doger Kuta', 18000, 'LaperAh Kuta', NULL, 'Es Doger dengan santan, kelapa muda, dan cincau.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Nasi Timbel Kuta', 25000, 'LaperAh Kuta', NULL, 'Nasi Timbel dengan ikan bakar dan sambal terasi.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Soto Kuta', 30000, 'LaperAh Kuta', NULL, 'Soto khas Bali dengan berbagai tambahan rempah.');
INSERT INTO MsMenu(MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('Ikan Bakar Kuta', 60000, 'LaperAh Kuta', NULL, 'Ikan bakar dengan bumbu khas Kuta.');

INSERT INTO MsTableType(TableType, MaxTableLoad) VALUES ('Romantic', 2);
INSERT INTO MsTableType(TableType, MaxTableLoad) VALUES ('General', 4);
INSERT INTO MsTableType(TableType, MaxTableLoad) VALUES ('Family', 10);

INSERT INTO MsBranch(LocationID, BranchName) VALUES (1, 'LaperAh Tanjung Duren');
INSERT INTO MsBranch(LocationID, BranchName) VALUES (2, 'LaperAh Tunjungan Plaza');
INSERT INTO MsBranch(LocationID, BranchName) VALUES (3, 'LaperAh Bukittinggi');
INSERT INTO MsBranch(LocationID, BranchName) VALUES (4, 'LaperAh Alun-alun Bandung');
INSERT INTO MsBranch(LocationID, BranchName) VALUES (5, 'LaperAh Palaran');
INSERT INTO MsBranch(LocationID, BranchName) VALUES (6, 'LaperAh Kuta');

INSERT INTO MsEmployee(BranchID, EmployeeName, EmployeeEmail, EmployeePassword) VALUES (1, 'Nobita','Nobita@gmail.com', 'Nobita123');
INSERT INTO MsEmployee(BranchID, EmployeeName, EmployeeEmail, EmployeePassword) VALUES (2, 'Taylor','Taylor@gmail.com', 'Taylor123');
INSERT INTO MsEmployee(BranchID, EmployeeName, EmployeeEmail, EmployeePassword) VALUES (3, 'Teguh','Teguh@gmail.com', 'Teguh123');
INSERT INTO MsEmployee(BranchID, EmployeeName, EmployeeEmail, EmployeePassword) VALUES (4, 'Eli','Eli@gmail.com', 'Eli123');
INSERT INTO MsEmployee(BranchID, EmployeeName, EmployeeEmail, EmployeePassword) VALUES (5, 'Joko','Joko@gmail.com', 'Joko123');
INSERT INTO MsEmployee(BranchID, EmployeeName, EmployeeEmail, EmployeePassword) VALUES (6, 'Reno','Reno@gmail.com', 'Reno123');

INSERT INTO TransactionDetail(OrderID, EmployeeID, ReservedTime, ReservationStatus) VALUES (1, 1, '2020-01-12 11:00:00', 'Finalized');
INSERT INTO TransactionDetail(OrderID, EmployeeID, ReservedTime, ReservationStatus) VALUES (2, 2, '2020-01-13 11:00:00', 'Finalized');
INSERT INTO TransactionDetail(OrderID, EmployeeID, ReservedTime, ReservationStatus) VALUES (3, 3, '2020-01-15 11:00:00', 'Finalized');
INSERT INTO TransactionDetail(OrderID, EmployeeID, ReservedTime, ReservationStatus) VALUES (4, 4, '2020-01-20 11:00:00', 'Finalized');

INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES (1, 1, 1, 1, 1, 'Andrew', 2);
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES (2, 2, 2, 2, 1, 'Charles', 4);
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES (2, 3, 4, 3, 1, 'Charles', 8);
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES (2, 4, 3, 3, 1, 'Charles', 8);
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES (3, 5, 4, 3, 2, 'Jarit', 17);
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES (3, 6, 28, 3, 2, 'Jarit', 17);
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES (4, 7, 2, 1, 2, 'Jessica', 4);
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES (4, 8, 4, 2, 1, 'Jessica', 4);