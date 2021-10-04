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
