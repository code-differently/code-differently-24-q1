
-- A SELECT query that returns the counts of media items by type.

SELECT type, COUNT(*) 
FROM media_items
GROUP BY type;

-- A SELECT query that returns the sum of total pages checked out by guests.

SELECT SUM(pages) 
FROM media_items
JOIN checked_out_items ON media_items.id = checked_out_items.item_id;

-- A SELECT query that shows all 5 guests and any corresponding records in the checked_out_items table.

SELECT G.type, G.email, COI.*
FROM guests G
LEFT JOIN checked_out_items COI ON G.email = COI.email;

-- Add a new table called library_users to the SQLite database that stores a user's id (UUID formatted string), email, first name, last name, and a password (bcrypt encoded string).

CREATE TABLE library_users (
    id VARCHAR(36) PRIMARY KEY,
    email VARCHAR(255),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    password_hash VARCHAR(255)
);

-- Populate the database with a few users.

INSERT INTO library_users(id, email, first_name, last_name, password) 
VALUES ('123e4567-e89b-12d3-a456-426614174000', 'jane.doe@example.com', 'Jane', 'Doe','$2a$12$P1mnGtwZaRYV7CjLq4rZKu8lIzC.6KKhDhRaC3Cz3Fl1Ytp3DC8we'); 
  
INSERT INTO library_users(id, email, first_name, last_name, password) 
VALUES ('abcdef12-3456-7890-abcd-ef1234567890', 'bob.smith@example.com', 'Bob', 'Smith', '$2a$12$JVLloBTExYQ2OQhYO3L6y.YnkfM0ltAFT9ah4C5D1DFHJ3yy8P48G');
  
INSERT INTO library_users(id, email, first_name, last_name, password) 
VALUES ('78901234-5678-9012-3456-789012345678', 'alice.jones@example.com', 'Alice', 'Jones', '$2a$12$0Vz/Ee8AjewPynKaTtDx..F0WjNVFk7EINnSWbc3lZqGGj4D5D1U6');

--Verifies rows have been added

SELECT * FROM library_users;

