-- Know which tables exist in database
SELECT name FROM sqlite_master WHERE type='table';

-- Count of media items by type
SELECT type, COUNT() AS item_count
FROM media_items
GROUP BY type;

-- Total pages checked out by guests
SELECT MI.type, SUM(pages) AS total_pages
FROM media_items MI, checked_out_items CO
WHERE MI.id = CO.item_id AND MI.type = 'book'
GROUP BY MI.type;
 
-- LEFT JOIN allows me to include all guests 
-- even if they don't have corresponding records
SELECT G.name, CO.*  FROM guests G LEFT JOIN checked_out_items CO 
ON G.email = CO.email;

-- Create new table
CREATE TABLE library_users (
users_id CHAR(36) PRIMARY KEY, 
email CHAR(320),
first_name VARCHAR(40),
last_name VARCHAR(40),
password VARCHAR(72)
);

-- Populating database
INSERT INTO library_users
  (users_id, email, first_name, last_name, password )
VALUES
  ('0bbb0342-9680-4404-aa95-d3ef4ebcd4bb','vicente@example.com', 'vicente', 'vigueras', '$2a$12$6IEd/gKoNPlZeRCQ5X.rdu280m2ZBeyXzufBj2qre7YF.SoFzWfAa'),
  ('3ccf8b0a-bdc4-42c1-9869-afeffbd0b02f','alexa@example.com', 'alexa', 'amazon', '$2a$12$Lp0AOZQcwl49sDrldcCXX.DZ2fEIVvAaL2Jm5pEIl.zXL7OywFIEm'),
  ('376bad7a-b9b8-405d-93e2-1841101990fd','siri@example.com', 'siri', 'apple', '$2a$12$EyzJ3cb70TT2aihi3zRb0e.g8xk9p8mMjFR3Zcy36ly/KWBtUYf1G');

-- Check if database was populated
SELECT * FROM library_users;
