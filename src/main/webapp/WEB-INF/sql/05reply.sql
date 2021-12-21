USE test;

DESC Member;

CREATE TABLE Reply (
	id INT PRIMARY KEY AUTO_INCREMENT,
	boardId INT NOT NULL,
    reply VARCHAR(500) NOT NULL,
    memberId VARCHAR(30) NOT NULL,
    inserted DATETIME NOT NULL DEFAULT NOW(),
    updated DATETIME NOT NULL DEFAULT NOW()
);

-- crud

SELECT * FROM Board ORDER BY id DESC; 
SELECT * FROM Member ORDER BY inserted DESC; 

-- test 데이터 입력
INSERT INTO Reply (boardId, reply, memberId) VALUES (41,'테스트 댓글', 'asdf');

SELECT * FROM Reply ORDER BY id DESC;

SELECT r.*, m.nickName FROM Reply r JOIN Member m ON r.memberId = m.id;