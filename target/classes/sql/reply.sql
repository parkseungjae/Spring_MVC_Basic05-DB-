create table reply(
id varchar(20),
title varchar(50),
content varchar(300),
write_group number(10),
write_date date default sysdate,
constraint fk_test1 foreign key(write_group) references mvc_board(write_no) on delete cascade,
--게시판 번호를 참조하여 댓글을 달 것이고 원글 삭제시 같은 번호의 모든 값을 삭제하겠다.
constraint fk_test2 foreign key(id) references membership(id) on delete cascade
--답글을 삭제시 답글 작성자가 요청한 값만 삭제 하겠다.
);
select * from reply;