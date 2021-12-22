USE test;

DESC Board;
DESC Member;

-- delete duplicated member id -- 중복된 내용 삭제
DELETE FROM Member WHERE id IN(
SELECT id FROM Member GROUP BY id HAVING count(id) > 1);
-- add primary key
ALTER TABLE Member
ADD PRIMARY KEY (id);

-- Board.wirter 가 Member.id 참조
ALTER TABLE Board
ADD FOREIGN KEY (writer) REFERENCES Member(id);

-- 탈퇴한 아이디의 게시물 삭제
DELETE FROM Board WHERE id IN
(
SELECT b.id 
FROM Board b LEFT JOIN Member m ON b.writer = m.id
WHERE m.id IS NULL
);

ALTER TABLE Reply
ADD FOREIGN KEY (boardId) REFERENCES Board(id);

ALTER TABLE Reply
ADD FOREIGN KEY (memberId) REFERENCES Member(id);

DESC Reply;





