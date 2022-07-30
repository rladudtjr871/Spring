

-- 게시판
create table tblFileBoard (
    seq number primary key,
    title varchar2(300) not null,
    regdate date default sysdate not null    
);

create sequence seqFileBoard;

select * from tblFileBoard;

-- 첨부파일
create table tblFile (
    seq number primary key,
    filename varchar2(100) not null,
    filesize varchar2(30) not null,
    mimetype varchar2(50) not null,
    bseq number not null references tblFileBoard(seq)
);


select * from tblFile;

create sequence seqFile;

