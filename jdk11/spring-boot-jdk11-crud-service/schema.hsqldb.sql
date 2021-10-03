-- Schema
CREATE TABLE UNIT (
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
    abbreviation varchar(16),
    name varchar(128),
    enabled BOOLEAN DEFAULT TRUE NOT NULL
);
CREATE TABLE COMPONENT (
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
    unitId INT, 
    name varchar(64),
    quantity DOUBLE,
    enabled BOOLEAN DEFAULT TRUE NOT NULL,
    FOREIGN KEY(unitId) REFERENCES UNIT(id) -- n to 1
);	
CREATE TABLE PRODUCT (
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
    name varchar(64), 
    description varchar(512),
    enabled BOOLEAN DEFAULT TRUE NOT NULL	
);
CREATE TABLE ASSEMBLY (
    componentId INT NOT NULL,
    productId INT NOT NULL,
    quantity DOUBLE,
    enabled BOOLEAN DEFAULT TRUE NOT NULL,
    PRIMARY KEY(componentId, productId),	
    FOREIGN KEY(componentId) REFERENCES COMPONENT(id),
    FOREIGN KEY(productId) REFERENCES PRODUCT(id)
);
CREATE TABLE UNITCONVERSION (
    fromUnitId INT NOT NULL,
    toUnitId INT NOT NULL,
    factor DOUBLE,
    enabled BOOLEAN DEFAULT TRUE NOT NULL,
    PRIMARY KEY(fromUnitId, toUnitId),	
    FOREIGN KEY(fromUnitId) REFERENCES UNIT(id),
    FOREIGN KEY(toUnitId) REFERENCES UNIT(id)
);
-- Sample values
INSERT INTO "UNIT" (ID,ABBREVIATION, NAME, enabled) VALUES (0,'g', 'grams', true);
INSERT INTO "UNIT" (ID,ABBREVIATION,NAME, enabled) VALUES (1,'kg', 'kilograms', true);
INSERT INTO "UNIT" (ID,ABBREVIATION,NAME, enabled) VALUES (2,'l', 'liters', true);
INSERT INTO "UNIT" (ID,ABBREVIATION,NAME, enabled) VALUES (3,'ml', 'mililites', true);
INSERT INTO "COMPONENT" (ID,UNITID,NAME, enabled) VALUES (0,0,'sugar', true);
INSERT INTO "COMPONENT" (ID,UNITID,NAME, enabled) VALUES (1,1,'potatoes', true);
INSERT INTO "COMPONENT" (ID,UNITID,NAME, enabled) VALUES (2,2,'water', true);
INSERT INTO "COMPONENT" (ID,UNITID,NAME, enabled) VALUES (3,3,'shampoo', true);
INSERT INTO "COMPONENT" (ID,UNITID,NAME, enabled) VALUES (4,0,'coffee', true);
INSERT INTO "PRODUCT" (ID,NAME,DESCRIPTION, enabled) VALUES (0,'coffe','a cup', true);
INSERT INTO "ASSEMBLY" (COMPONENTID,PRODUCTID,QUANTITY, enabled) VALUES (0,0,4.0, true);
INSERT INTO "ASSEMBLY" (COMPONENTID,PRODUCTID,QUANTITY, enabled) VALUES (4,0,8.3, true);
