create table andMember(
	id varchar2(500),
	pw varchar2(500),
	nick varchar2(500),
	phone varchar2(500)
)

delete from andMember where id is null ;
select * from andMember;

create table andChat(
	nick varchar2(500),
	content varchar2(500),
	day date
)
select * from andChat

delete from andChat where nick = '123'; 

insert into andchat values('호두아빠', '지금나와', sysdate);
insert into andchat values('대희왕자', '하이후에호', sysdate);
insert into andchat values('예진축구', '역시 호날두 보다느 메시', sysdate);
insert into andchat values('해도도해', '저는 북한사람입니다', sysdate);

