-- script.sql

create table tblMyBatis (
    seq number primary key,
    item varchar2(100) not null,
    price number not null,
    regdate date default sysdate not null
);


create sequence seqMyBatis;

insert into tblMyBatis (seq, item, price, regdate) values (seqMyBatis.nextVal, '마우스', 3500, default);
insert into tblMyBatis (seq, item, price, regdate) values (seqMyBatis.nextVal, '키보드,', 5000, default);
insert into tblMyBatis (seq, item, price, regdate) values (seqMyBatis.nextVal, '모니터', 2300, default);

commit;

select * from tblMyBatis;