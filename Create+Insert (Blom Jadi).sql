BEGIN TRAN
CREATE TABLE Restaurant(
    restaurantID int PRIMARY KEY,
    location varchar(255) not null,
    type varchar(255)
)

CREATE TABLE MsMenu(
    menuID int PRIMARY KEY not null,
    name varchar(255) not null,
    price int not null,
    type varchar(255) not null,
    description varchar(255),
    city varchar(255)
)

CREATE TABLE TableTypes(
    typeID int PRIMARY KEY,
    typeName varchar(255) not null,
    capacity int not null
);

CREATE TABLE RestaurantMenu(
    restaurantID int not null,
    menuID int not null,
    PRIMARY KEY(menuID,restaurantID),
    FOREIGN KEY(restaurantID) REFERENCES restaurant(restaurantID),
    FOREIGN KEY(menuID) REFERENCES MsMenu(menuID)
)

CREATE TABLE Employee(
    employeeID int PRIMARY KEY,
    employeeName VARCHAR(255) not null,
    restaurantID int not null,
    FOREIGN KEY(restaurantID) REFERENCES restaurant(restaurantID)
)

CREATE TABLE Orders(
    orderID int,
    tableTypeID int not null,
    customerName VARCHAR(255) not null,
    restaurantID int not null,
    tableQuantity int not null,
    totalPeople int not null,
	employeeID int not null,
    status varchar(255) not null,
	FOREIGN KEY(employeeID) REFERENCES Employee(employeeID),
	FOREIGN KEY(restaurantID) REFERENCES Restaurant(restaurantID),
	FOREIGN KEY(tableTypeID) REFERENCES TableTypes(typeID),
	PRIMARY KEY(orderID,tableTypeID)
)

INSERT INTO TableTypes(typeID, typeName, capacity) VALUES
(1, 'Romantic', 2),
(2, 'General', 4),
(3, 'Family', 10);

INSERT INTO restaurant VALUES
(1,'Bandung','special'),
(2,'Jakarta','special'),
(3,'Bali','special'),
(4,'Surabaya','local'),
(5,'Samarinda','local'),
(6,'Padang','local')


INSERT INTO employee VALUES
(1,'Andrew',1),
(2,'Alvin',2),
(3,'Charles',3),
(4,'Fred',4),
(5,'Alek',5),
(6,'Hendra',6)

INSERT INTO msmenu(menuID,name,price,type) VALUES
(1,'Rendang',10000,'normal')

ROLLBACK