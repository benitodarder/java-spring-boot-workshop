-- Sample values
INSERT INTO UNIT (NAME, ABBREVIATION, enabled) VALUES ('grams','g', true)
INSERT INTO UNIT (NAME, ABBREVIATION, enabled) VALUES ('kilograms','kg', false)
INSERT INTO UNIT (NAME, ABBREVIATION, enabled) VALUES ('liters','l', true)
INSERT INTO UNIT (NAME, ABBREVIATION, enabled) VALUES ('mililiters','ml', false)
INSERT INTO COMPONENT (UNITID,NAME, enabled) VALUES ((SELECT id from unit WHERE abbreviation = 'g'),'sugar', false)
INSERT INTO COMPONENT (UNITID,NAME, enabled) VALUES ((SELECT id from unit WHERE abbreviation = 'kg'),'potatoes', true)
INSERT INTO COMPONENT (UNITID,NAME, enabled) VALUES ((SELECT id from unit WHERE abbreviation = 'l'),'water', false)
INSERT INTO COMPONENT (UNITID,NAME, enabled) VALUES ((SELECT id from unit WHERE abbreviation = 'ml'),'shampoo', true)
INSERT INTO COMPONENT (UNITID,NAME, enabled) VALUES ((SELECT id from unit WHERE abbreviation = 'g'),'coffee', false)
INSERT INTO PRODUCT (NAME,DESCRIPTION, enabled) VALUES ('coffe','a cup', true)
INSERT INTO ASSEMBLY (COMPONENTID,PRODUCTID,QUANTITY, enabled) VALUES ((SELECT id from component WHERE name = 'sugar'),(SELECT id from product WHERE name = 'coffe'),4.0, false)
INSERT INTO ASSEMBLY (COMPONENTID,PRODUCTID,QUANTITY, enabled) VALUES ((SELECT id from component WHERE name = 'coffee'),(SELECT id from product WHERE name = 'coffe'),8.3, true);

