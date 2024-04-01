SELECT type, COUNT(*) 
FROM media_items
GROUP BY type;

SELECT SUM(pages) 
FROM media_items, checked_out_items
WHERE id = item_id ;

SELECT G.type, G.name, CI.*
FROM guests G 
LEFT JOIN checked_out_items CI
ON G.email = CI.email;

CREATE TABLE library_users(
id VARCHAR(36) PRIMARY KEY, 
email VARCHAR(320),
first_name VARCHAR(50),
last_name VARCHAR(50),
password VARCHAR(72));

INSERT INTO library_users(id, email,first_name, last_name, password) 
VALUES ("2584d0d6-fe06-46f2-be8b-6f1a31b57fb3","johnjr@book.com","John", "Book Jr.", "$2a$12$pKO91AkPiVjNjPX0f8Cu1Os6zPO3e7slKayXMGXgeTr2grCwM.0Hu");

SELECT * FROM library_users;