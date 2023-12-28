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