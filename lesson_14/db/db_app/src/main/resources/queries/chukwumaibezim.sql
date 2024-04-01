SELECT type, COUNT(*) AS item_count
FROM media_items
GROUP BY type;

SELECT SUM(media_items.pages) AS total_checked_out_pages
FROM checked_out_items
JOIN media_items ON checked_out_items.item_id = media_items.id;


SELECT DISTINCT guests.*, checked_out_items.*
FROM guests
LEFT JOIN checked_out_items ON guests.email = checked_out_items.email;


CREATE TABLE IF NOT EXISTS library_users    (
    id TEXT PRIMARY KEY,
    email TEXT UNIQUE NOT NULL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    password TEXT NOT NULL
);

INSERT INTO library_users (id, email, first_name, last_name, password)
VALUES
    ('4ee48966-59d8-4fa8-aec6-5a5b7b2cda36', 'kanye@gmail.com', 'Kanye', 'West', '$2a$10$gZWTVaC70xFgNLEt4kvBfOlV/7jFm8Ex4o.7jj4FX/7mtTKXZgPwq'), 
    ('09cb0f92-3cf0-4f37-90bb-30af97d4c7de', 'willsmith@gmail.com', 'Will', 'Smith', '$2a$10$xV0adwSRoIInXp/T1wrgPe2DsglO15Gh4y/NEDTUVyD3vBC3WRZvO'),
    ('92e5b6b3-58d4-4d24-b0c6-c7a244f03837', 'seancarter@gmail.com', 'Sean', 'Carter', '$2a$10$Bkh3mCsGQ0xlM2gP18bu4O8cNQumzqfPpVzN1Yr8l7JNhCWL1p/Va'),
    ('af8d5200-d6d7-44ab-b11d-2641bdc2f35c', 'johnlegend@gmail.com', 'John', 'Legend', '$2a$10$J4QVoDSjXDT3tBz6qNMI1eEICe8iyt.lZzI.KT2MujwALQRjPRZYe'),
    ('c1a6766f-d16e-47b3-9c6d-226d6fd09742', 'beyonce@gmail.com', 'Beyonce', 'Knowles', '$2a$10$J4QVoDSjXDT3tBz6qNMI1eEICe8iyt.lZzI.KT2MujwALQRjPRZYe');