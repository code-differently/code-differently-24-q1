
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















