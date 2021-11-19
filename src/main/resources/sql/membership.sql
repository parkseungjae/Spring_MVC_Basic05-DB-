create table mvc_board(
    Write_no number(10) primary key,
    Title varchar2(100),
    Content varchar2(300),
    Savedate date default sysdate,
    Hit number(10) default 0,
    Image_file_name varchar(100),
    Id varchar(20) not null,
    constraint fk_test foreign key(id) references membership(id) on delete cascade
);

create sequence mvc_board_seq;

select * from membership;
select * from mvc_board;

insert into mvc_board(write_no, id) values(1, 'wujin');
insert into mvc_board(write_no, id) values(2, 'fff');
insert into mvc_board(write_no, id) values(3, 'test1');

delete from membership where id = 'test1';

delete from mvc_board where id = 'test1';