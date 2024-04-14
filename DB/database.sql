CREATE TABLE Item (
                      ItemID INT PRIMARY KEY,
                      Name VARCHAR(255),
                      Description TEXT,
                      Price DECIMAL(10, 2),
                      Quantity INT
);
CREATE TABLE Supplier (
                          SupplierID INT PRIMARY KEY,
                          Name VARCHAR(255),
                          Address VARCHAR(255),
                          Phone VARCHAR(20),
                          Email VARCHAR(255)
);
CREATE TABLE Supply (
                        SupplyID INT PRIMARY KEY,
                        ItemID INT,
                        SupplierID INT,
                        Quantity INT,
                        PPU DECIMAL(10, 2),
                        Date DATE,
                        FOREIGN KEY (ItemID) REFERENCES Item(ItemID),
                        FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID)
);
CREATE TABLE Customer (
                          CustomerID INT PRIMARY KEY,
                          Name VARCHAR(255),
                          Address VARCHAR(255),
                          Phone VARCHAR(20),
                          Email VARCHAR(255)
);
CREATE TABLE `Order` (
                         OrderID INT PRIMARY KEY,
                         CustomerID INT,
                         Date DATE,
                         FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);
CREATE TABLE OrderDetail (
                             OrderDetailID INT PRIMARY KEY,
                             OrderID INT,
                             ItemID INT,
                             Quantity INT,
                             FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID),
                             FOREIGN KEY (ItemID) REFERENCES Item(ItemID)
);

-- foreign key for item
ALTER TABLE Supply
    ADD FOREIGN KEY (ItemID) REFERENCES Item(ItemID)
        ON DELETE CASCADE;

-- foreign key for supplier
ALTER TABLE Supply
    ADD FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID)
        ON DELETE CASCADE;

-- foreign key for customer
ALTER TABLE `Order`
    ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
        ON DELETE CASCADE;

-- foreign key for order
ALTER TABLE OrderDetail
    ADD FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID)
        ON DELETE CASCADE;

-- foreign key for item
ALTER TABLE OrderDetail
    ADD FOREIGN KEY (ItemID) REFERENCES Item(ItemID)
        ON DELETE CASCADE;



-- index for item
CREATE INDEX idx_Item_ItemID ON Item (ItemID);


-- -- trigger for updating quantity in inventory after insert or update or delete
-- CREATE TRIGGER UpdateInventory_Order
--     ON OrderDetail
--     AFTER INSERT, UPDATE, DELETE
-- AS
-- BEGIN
--     DECLARE @ItemID INT; DECLARE @OrderQuantity INT;
--     SELECT @ItemID = ItemID, @OrderQuantity = Quantity
--     FROM inserted;
--     UPDATE Item
--     SET Quantity = Quantity - @OrderQuantity
--     WHERE ItemID = @ItemID;
-- END

-- CREATE TRIGGER UpdateInventory_Supply
--     ON Supply
--     AFTER INSERT, UPDATE, DELETE
-- AS
-- BEGIN
--     DECLARE @ItemID INT; DECLARE @SupplyQuantity INT;
--     SELECT @ItemID = ItemID, @SupplyQuantity = Quantity
--     FROM inserted;
--     UPDATE Item
--     SET Quantity = Quantity + @SupplyQuantity
--     WHERE ItemID = @ItemID;
-- END




-- CREATE INDEX idx_Inventory_ItemID ON Inventory (ItemID);

-- -- trigger for updating inventory

-- CREATE TRIGGER UpdateInventory_Order
--     ON OrderDetail
--     AFTER INSERT
-- AS
-- BEGIN
--     DECLARE @ItemID INT; DECLARE @OrderQuantity INT;
--     SELECT @ItemID = ItemID, @OrderQuantity = Quantity
--     FROM inserted;
--     UPDATE Inventory
--     SET Quantity = Quantity - @OrderQuantity
--     WHERE ItemID = @ItemID;
-- END

-- CREATE TRIGGER UpdateInventory_Supply
--     ON Supply
--     AFTER INSERT
-- AS
-- BEGIN
--     DECLARE @ItemID INT; DECLARE @SupplyQuantity INT;
--     SELECT @ItemID = ItemID, @SupplyQuantity = Quantity
--     FROM inserted;
--     UPDATE Inventory
--     SET Quantity = Quantity + @SupplyQuantity
--     WHERE ItemID = @ItemID;
-- END
