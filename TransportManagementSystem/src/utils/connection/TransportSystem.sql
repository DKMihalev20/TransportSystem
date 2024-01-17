CREATE DATABASE TransportSystemDB

USE TransportSystemDB

CREATE TABLE Accounts (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
	Email VARCHAR(50),
    Username VARCHAR(50),
    [Password] VARCHAR(50)
)

INSERT INTO Accounts (FirstName, LastName, Email, Username, [Password]) VALUES ('Susy', 'Hubball', 'clanning0@apache.org', 'clanning0', 'rE8=3nEsAtv');
INSERT INTO Accounts (FirstName, LastName, Email, Username, [Password]) VALUES ('Ulrikaumeko', 'Strowlger', 'bschuster1@economist.com', 'bschuster1', 'bU9(q5JR(i4Iu');
INSERT INTO Accounts (FirstName, LastName, Email, Username, [Password]) VALUES ('Royal', 'Littleover', 'dversey2@google.ru', 'dversey2', 'uK9>K3(#s<mEkXD');
INSERT INTO Accounts (FirstName, LastName, Email, Username, [Password]) VALUES ('Lillian', 'Sedworth', 'mparfitt3@latimes.com', 'mparfitt3', 'iE0{.a\c''hD$S1N4');
INSERT INTO Accounts (FirstName, LastName, Email, Username, [Password]) VALUES ('Floris', 'Bilsland', 'bkopman4@chronoengine.com', 'bkopman4', 'cH3~\"Ir~1}r6O`');
INSERT INTO Accounts (FirstName, LastName, Email, Username, [Password]) VALUES ('Trixie', 'Spellesy', 'aalabone5@slashdot.org', 'aalabone5', 'mF1*QJhr&mUZz');
INSERT INTO Accounts (FirstName, LastName, Email, Username, [Password]) VALUES ('Daisy', 'Vogele', 'dbraden6@bravesites.com', 'dbraden6', 'gZ0\),4N,g<ny');
INSERT INTO Accounts (FirstName, LastName, Email, Username, [Password]) VALUES ('Gage', 'Chislett', 'wball7@wordpress.org', 'wball7', 'xJ6@zN6AS.{|%!Ud');

CREATE TABLE Cities (
	CityId INT IDENTITY(1,1) PRIMARY KEY,
	CityName VARCHAR(50) UNIQUE
)

INSERT INTO Cities (CityName) VALUES ('Sofia');
INSERT INTO Cities (CityName) VALUES ('Burgas');
INSERT INTO Cities (CityName) VALUES ('Ruse');
INSERT INTO Cities (CityName) VALUES ('Varna');
INSERT INTO Cities (CityName) VALUES ('Plovdiv');
INSERT INTO Cities (CityName) VALUES ('Pomorie');
INSERT INTO Cities (CityName) VALUES ('Shumen');
INSERT INTO Cities (CityName) VALUES ('Blagoevgrad');

CREATE TABLE Prices (
    PriceId INT IDENTITY(1,1) PRIMARY KEY,
    Price MONEY
)

INSERT INTO Prices (Price) VALUES (6.40);
INSERT INTO Prices (Price) VALUES (9.58);
INSERT INTO Prices (Price) VALUES (6.40);
INSERT INTO Prices (Price) VALUES (3.10);
INSERT INTO Prices (Price) VALUES (5.36);
INSERT INTO Prices (Price) VALUES (7.67);
INSERT INTO Prices (Price) VALUES (5.58);
INSERT INTO Prices (Price) VALUES (4.37);

CREATE TABLE Tickets (
    TicketId INT IDENTITY(1,1) PRIMARY KEY,
    PassengerFirstName VARCHAR(100),
    PassengerLastName VARCHAR(100),
    ArrivalCityId INT,
    DepartureCityId INT,
    AccountId INT,
    PriceId INT,
    FOREIGN KEY (DepartureCityId) REFERENCES Cities (CityId),
    FOREIGN KEY (ArrivalCityId) REFERENCES Cities (CityId),
    FOREIGN KEY (AccountId) REFERENCES Accounts (Id),
	FOREIGN KEY (PriceId) REFERENCES Prices (PriceId)
);

INSERT INTO Tickets (PassengerFirstName, PassengerLastName, ArrivalCityId, DepartureCityId, AccountId, PriceId) VALUES ('Susy', 'Hubball', 1, 4, 1, 1);
INSERT INTO Tickets (PassengerFirstName, PassengerLastName, ArrivalCityId, DepartureCityId, AccountId, PriceId) VALUES ('Ulrikaumeko', 'Strowlger', 2, 3, 2, 2);
INSERT INTO Tickets (PassengerFirstName, PassengerLastName, ArrivalCityId, DepartureCityId, AccountId, PriceId) VALUES ('Royal', 'Littleover', 3, 2, 3, 3);
INSERT INTO Tickets (PassengerFirstName, PassengerLastName, ArrivalCityId, DepartureCityId, AccountId, PriceId) VALUES ('Lillian', 'Sedworth', 4, 1, 4, 4);
INSERT INTO Tickets (PassengerFirstName, PassengerLastName, ArrivalCityId, DepartureCityId, AccountId, PriceId) VALUES ('Floris', 'Bilsland', 5, 6, 5, 5);
INSERT INTO Tickets (PassengerFirstName, PassengerLastName, ArrivalCityId, DepartureCityId, AccountId, PriceId) VALUES ('Trixie', 'Spellesy', 6, 4, 6, 6);
INSERT INTO Tickets (PassengerFirstName, PassengerLastName, ArrivalCityId, DepartureCityId, AccountId, PriceId) VALUES ('Daisy', 'Vogele', 7, 8, 7, 7);
INSERT INTO Tickets (PassengerFirstName, PassengerLastName, ArrivalCityId, DepartureCityId, AccountId, PriceId) VALUES ('Gage', 'Chislett', 8, 3, 8, 8);
