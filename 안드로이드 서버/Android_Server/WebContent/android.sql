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

insert into andchat values('ȣ�ξƺ�', '���ݳ���', sysdate);
insert into andchat values('�������', '�����Ŀ�ȣ', sysdate);
insert into andchat values('�����౸', '���� ȣ���� ���ٴ� �޽�', sysdate);
insert into andchat values('�ص�����', '���� ���ѻ���Դϴ�', sysdate);

