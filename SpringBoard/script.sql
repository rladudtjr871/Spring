
-- C:\class\spring\SpringBoard\script.sql


select * from tblUser;
select * from tblSpringBoard;


create table tblSpringBoard (
    
    seq number primary key,
    subject varchar2(300) not null,
    content varchar2(2000) not null,
    id varchar2(30) not null references tblUser(id),
    regdate date default sysdate not null

);

create sequence seqSpringBoard;


insert into tblSpringBoard (seq, subject, content, id, regdate) values (seqSpringBoard.nextVal, '게시판입니다.', '내용입니다.', 'hong', default);

select * from tblSpringBoard;

commit;