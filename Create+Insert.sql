CREATE TABLE MrLocation(
LocationID CHAR(5) NOT NULL PRIMARY KEY CHECK (LocationID LIKE 'LI[0-9][0-9][0-9]'),
Location VARCHAR(50) NOT NULL,
RestaurantType VARCHAR(20) NOT NULL
)

CREATE TABLE MrMenu(
MenuID CHAR(5) NOT NULL PRIMARY KEY CHECK (MenuID LIKE 'MN[0-9][0-9][0-9]'),
MenuName VARCHAR(225) NOT NULL,
Price INT NOT NULL,
AvailableOn VARCHAR(125) NOT NULL,
OriginLocation VARCHAR(255),
CharacteristicOrDescription VARCHAR(255),
)

CREATE TABLE MrTableType(
TableTypeID CHAR(5) NOT NULL PRIMARY KEY CHECK (TableTypeID LIKE 'TT[0-9][0-9][0-9]'),
TableType VARCHAR(20) NOT NULL,
MaxTableLoad INT NOT NULL
)

CREATE TABLE MrBranch(
BranchID CHAR(5) NOT NULL PRIMARY KEY CHECK (BranchID LIKE 'BR[0-9][0-9][0-9]'),
LocationID CHAR(5) FOREIGN KEY REFERENCES MrLocation(LocationID),
BranchName VARCHAR(125) NOT NULL
)

CREATE TABLE MrEmployee(
EmployeeID CHAR(5) NOT NULL PRIMARY KEY CHECK (EmployeeID LIKE 'EM[0-9][0-9][0-9]'),
BranchID CHAR(5) FOREIGN KEY REFERENCES MrBranch(BranchID),
EmployeeName VARCHAR(125) NOT NULL
)

CREATE TABLE TransactionDetail(
OrderID CHAR(5) NOT NULL PRIMARY KEY CHECK (OrderID LIKE 'OD[0-9][0-9][0-9]'),
EmployeeID CHAR(5) FOREIGN KEY REFERENCES MrEmployee(EmployeeID),
ReservedTime DATETIME NOT NULL,
ReservationStatus VARCHAR(20) NOT NULL
)

CREATE TABLE TransactionHeader(
OrderID CHAR(5) NOT NULL CHECK (OrderID LIKE 'OD[0-9][0-9][0-9]'),
MenuID CHAR(5) NOT NULL CHECK (MenuID LIKE 'MN[0-9][0-9][0-9]'),
PRIMARY KEY(OrderID, MenuID),
MenuQuantity INT NOT NULL,
TableTypeID CHAR(5) FOREIGN KEY REFERENCES MrTableType(TableTypeID),
TableQuantity INT NOT NULL,
CustomerName VARCHAR(225) NOT NULL,
TotalPeopleReserved INT
)

INSERT INTO MrLocation(LocationID, Location, RestaurantType) VALUES ('LI001', 'Jakarta', 'Main')
INSERT INTO MrLocation(LocationID, Location, RestaurantType) VALUES ('LI002', 'Surabaya', 'Local')
INSERT INTO MrLocation(LocationID, Location, RestaurantType) VALUES ('LI003', 'Padang', 'Local')
INSERT INTO MrLocation(LocationID, Location, RestaurantType) VALUES ('LI004', 'Bandung', 'Main')
INSERT INTO MrLocation(LocationID, Location, RestaurantType) VALUES ('LI005', 'Samarinda', 'Local')
INSERT INTO MrLocation(LocationID, Location, RestaurantType) VALUES ('LI006', 'Bali', 'Main')

INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN001', 'Wagyu A5', 1000000, 'LaperAh Tanjung Duren', NULL, 'Di lereng pegunungan Jepang, Wagyu A5 terkenal dengan marbling luar biasa, tekstur lembut seperti awan, dan cita rasa mentega yang melumer di lidah, memberikan pengalaman kuliner mewah yang tak terlupakan.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN002', 'Rawon', 250000, 'LaperAh Tunjungan Plaza', 'Banyuwangi', 'Rawon adalah sup tradisional Jawa Timur yang kaya rempah, berwarna hitam pekat karena penggunaan kluwek, dengan cita rasa gurih, pedas, dan lezat.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN003', 'Nasi Goreng Kampung', 100000, 'LaperAh Tunjungan Plaza', NULL, NULL)
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN004', 'Ayang Goreng', 80000, 'LaperAh Tunjungan Plaza', NULL, NULL)
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN005', 'Rendang', 100000, 'LaperAh Bukittinggi', 'Padang Barat', 'Rendang, hidangan khas Padang, ditandai oleh daging yang empuk dimasak secara perlahan dengan campuran santan dan rempah-rempah yang kaya, menghasilkan sensasi rasa dan aroma yang lezat.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN006', 'Sate Padang', 20000, 'LaperAh Bukittinggi', 'Padang Utara', 'Sate Padang, terkenal dengan cita rasa pedas dan bumbu kacang yang kaya, merupakan hidangan sate yang berasal dari Padang, Sumatra Barat, Indonesia.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN007', 'Mie Ayam', 30000, 'LaperAh Alun-alun Bandung', NULL, NULL)
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN008', 'Sate Kambing', 35000, 'LaperAh Alun-alun Bandung', NULL, NULL)
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN009', 'Nasi Goreng Special', 50000, 'LaperAh Tanjung Duren', NULL, 'Nasi goreng spesial dengan berbagai tambahan lauk.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN010', 'Ayam Bakar Kecap', 70000, 'LaperAh Tanjung Duren', NULL, 'Ayam bakar dengan saus kecap yang lezat.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN011', 'Soto Betawi', 35000, 'LaperAh Tanjung Duren', NULL, 'Soto Betawi dengan daging sapi, kentang, dan santan.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN012', 'Bakso Malang', 30000, 'LaperAh Tanjung Duren', NULL, 'Bakso Malang dengan pangsit dan kuah yang gurih.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN013', 'Sate Ayam Madura', 20000, 'LaperAh Tunjungan Plaza', NULL, 'Sate ayam khas Madura dengan bumbu kacang yang nikmat.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN014', 'Pempek Palembang', 30000, 'LaperAh Tunjungan Plaza', NULL, 'Pempek Palembang dengan cuko yang khas.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN015', 'Mie Kocok Bandung', 25000, 'LaperAh Bukittinggi', NULL, 'Mie Kocok Bandung dengan daging sapi, bakso, dan kuah kocok yang khas.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN016', 'Martabak Manis', 15000, 'LaperAh Bukittinggi', NULL, 'Martabak Manis dengan topping keju dan coklat.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN017', 'Siomay Bandung', 18000, 'LaperAh Bukittinggi', NULL, 'Siomay Bandung dengan bumbu kacang dan kecap yang lezat.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN018', 'Pisang Goreng', 10000, 'LaperAh Alun-alun Bandung', NULL, 'Pisang Goreng dengan tepung gurih.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN019', 'Batagor', 15000, 'LaperAh Alun-alun Bandung', NULL, 'Batagor dengan bumbu kacang dan kecap yang lezat.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN020', 'Surabi', 12000, 'LaperAh Alun-alun Bandung', NULL, 'Surabi dengan kelapa parut dan gula merah.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN021', 'Sate Lilit Palaran', 25000, 'LaperAh Palaran', NULL, 'Sate lilit khas Bali dengan bumbu rempah yang lezat.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN022', 'Lumpia Palaran', 15000, 'LaperAh Palaran', NULL, 'Lumpia dengan isian rebung dan ayam, disajikan dengan saus kacang.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN023', 'Bebek Goreng Palaran', 80000, 'LaperAh Palaran', NULL, 'Bebek goreng dengan bumbu khas Palaran.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN024', 'Nasi Kuning Palaran', 30000, 'LaperAh Palaran', NULL, 'Nasi kuning dengan lauk ayam, telur, dan kacang serundeng.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN025', 'Es Cendol Palaran', 18000, 'LaperAh Palaran', NULL, 'Es cendol dengan santan dan gula merah.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN026', 'Surabi Kuta', 12000, 'LaperAh Kuta', NULL, 'Surabi dengan kelapa parut dan gula merah.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN027', 'Es Doger Kuta', 18000, 'LaperAh Kuta', NULL, 'Es Doger dengan santan, kelapa muda, dan cincau.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN028', 'Nasi Timbel Kuta', 25000, 'LaperAh Kuta', NULL, 'Nasi Timbel dengan ikan bakar dan sambal terasi.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN029', 'Soto Kuta', 30000, 'LaperAh Kuta', NULL, 'Soto khas Bali dengan berbagai tambahan rempah.')
INSERT INTO MrMenu(MenuID, MenuName, Price, AvailableOn, OriginLocation, CharacteristicOrDescription) VALUES ('MN030', 'Ikan Bakar Kuta', 60000, 'LaperAh Kuta', NULL, 'Ikan bakar dengan bumbu khas Kuta.')

INSERT INTO MrTableType(TableTypeID, TableType, MaxTableLoad) VALUES ('TT001', 'Romantic', 2)
INSERT INTO MrTableType(TableTypeID, TableType, MaxTableLoad) VALUES ('TT002', 'General', 4)
INSERT INTO MrTableType(TableTypeID, TableType, MaxTableLoad) VALUES ('TT003', 'Family', 10)

INSERT INTO MrBranch(BranchID, LocationID, BranchName) VALUES ('BR001', 'LI001', 'LaperAh Tanjung Duren')
INSERT INTO MrBranch(BranchID, LocationID, BranchName) VALUES ('BR002', 'LI002', 'LaperAh Tunjungan Plaza')
INSERT INTO MrBranch(BranchID, LocationID, BranchName) VALUES ('BR003', 'LI003', 'LaperAh Bukittinggi')
INSERT INTO MrBranch(BranchID, LocationID, BranchName) VALUES ('BR004', 'LI004', 'LaperAh Alun-alun Bandung')
INSERT INTO MrBranch(BranchID, LocationID, BranchName) VALUES ('BR005', 'LI005', 'LaperAh Palaran')
INSERT INTO MrBranch(BranchID, LocationID, BranchName) VALUES ('BR006', 'LI006', 'LaperAh Kuta')

INSERT INTO MrEmployee(EmployeeID, BranchID, EmployeeName) VALUES ('EM001', 'BR001', 'Nobita')
INSERT INTO MrEmployee(EmployeeID, BranchID, EmployeeName) VALUES ('EM002', 'BR002', 'Taylor')
INSERT INTO MrEmployee(EmployeeID, BranchID, EmployeeName) VALUES ('EM003', 'BR003', 'Teguh')
INSERT INTO MrEmployee(EmployeeID, BranchID, EmployeeName) VALUES ('EM004', 'BR004', 'Eli')
INSERT INTO MrEmployee(EmployeeID, BranchID, EmployeeName) VALUES ('EM003', 'BR005', 'Joko')
INSERT INTO MrEmployee(EmployeeID, BranchID, EmployeeName) VALUES ('EM004', 'BR006', 'Reno')

INSERT INTO TransactionDetail(OrderID, EmployeeID, ReservedTime, ReservationStatus) VALUES ('OD001', 'EM001', '2020-01-12 11:00:00', 'Finalized')
INSERT INTO TransactionDetail(OrderID, EmployeeID, ReservedTime, ReservationStatus) VALUES ('OD002', 'EM002', '2020-01-13 11:00:00', 'Finalized')
INSERT INTO TransactionDetail(OrderID, EmployeeID, ReservedTime, ReservationStatus) VALUES ('OD003', 'EM003', '2020-01-15 11:00:00', 'Finalized')
INSERT INTO TransactionDetail(OrderID, EmployeeID, ReservedTime, ReservationStatus) VALUES ('OD004', 'EM004', '2020-01-20 11:00:00', 'Finalized')

INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES ('OD001', 'MN001', 1, 'TT001', 1, 'Andrew', 2)
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES ('OD002', 'MN002', 2, 'TT002', 1, 'Charles', 4)
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES ('OD002', 'MN003', 4, 'TT003', 1, 'Charles', 8)
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES ('OD002', 'MN004', 3, 'TT003', 1, 'Charles', 8)
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES ('OD003', 'MN005', 4, 'TT003', 2, 'Jarit', 17)
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES ('OD003', 'MN006', 28, 'TT003', 2, 'Jarit', 17)
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES ('OD004', 'MN007', 2, 'TT001', 2, 'Jessica', 4)
INSERT INTO TransactionHeader(OrderID, MenuID, MenuQuantity, TableTypeID, TableQuantity, CustomerName, TotalPeopleReserved) VALUES ('OD004', 'MN008', 4, 'TT002', 1, 'Jessica', 4)

CREATE TRIGGER CheckAvailableOn
ON MrMenu
INSTEAD OF INSERT
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM MrMenu AS M
        LEFT JOIN MrBranch AS B ON M.AvailableOn = B.BranchName
        WHERE M.AvailableOn IS NOT NULL AND B.BranchID IS NULL
    )
    BEGIN
        RAISERROR ('Such branch does not exist', 16, 1);
        ROLLBACK;
        RETURN;
    END
END;