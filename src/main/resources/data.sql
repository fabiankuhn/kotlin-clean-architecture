-- script simple columns table "Product";

INSERT INTO "PUBLIC"."product"("ID", "NAME", "PRICE") VALUES(1, 'Apfel', 5.0);
INSERT INTO "PUBLIC"."product"("ID", "NAME", "PRICE") VALUES(2, 'Birne', 8.0);

INSERT INTO "PUBLIC"."stock"("ID", "AMOUNT", "product_id") VALUES('1', 2, '1');
INSERT INTO "PUBLIC"."stock"("ID", "AMOUNT", "product_id") VALUES('2', 3, '2');
