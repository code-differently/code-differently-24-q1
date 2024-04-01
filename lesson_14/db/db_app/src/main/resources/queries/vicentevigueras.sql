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
first_name VARCHAR(400),
last_name VARCHAR(400),
password VARCHAR(300)
);









 







