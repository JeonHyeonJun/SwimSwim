drop table if exists board;
create table board(num int primary key auto_increment, pass varchar(30), name varchar(30), email varchar(30), title varchar(50), content varchar(1000), readcount int, writedate date);
insert into board values(0, '1234', '오니쨩','onijjang@naver.com','대학생이 3월에 강한이유는?','개강해서',0,now());
insert into board values(0, '1234', '이길선','pjjwjwth@naver.com','신사가 자기소개할때 하는말은?','신사임당',0,now());
insert into board values(0, '1234', '권록헌','lock@naver.com','소금의 유통기한은?','천일염',0,now());
insert into board values(0, '1234', '배성수','tjdtn4354@naver.com','우주인이 술을 마시는 곳은?','스페이스바',0,now());
insert into board values(0, '1234', '고석현','seok@naver.com','화장실에서 방금나온 사람은?','일본사람',0,now());
select * from board;
