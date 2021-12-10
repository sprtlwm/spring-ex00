USE test;
CREATE TABLE Board(
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    writer VARCHAR(255) NOT NULL,
    inserted DATETIME DEFAULT NOW(),
    updated DATETIME DEFAULT NOW()
);
  
  DESC Board;
  
  SELECT * FROM Board;
  
  DELETE FROM Board WHERE
  (id) IN (SELECT id
			 FROM Board
            WHERE inserted IS NULL);
            
DELETE FROM Board WHERE updated IS NULL;
  
ALTER TABLE Board MODIFY COLUMN inserted DATETIME NOT NULL DEFAULT NOW();
ALTER TABLE Board MODIFY COLUMN updated DATETIME NOT NULL DEFAULT NOW();    
  
  
  
  