create table student
	(sno	numeric(6)	constraint c1 check(sno between 90000 and 99999),
	 sname	char(20)	constraint c2 not null,
	 sage	numeric(3)	constraint c3 check(sage<30),
	 ssex	char(2)		constraint c4 check(ssex in('��','Ů')),
						constraint studentkey primary key(sno))
						
--�˾���Ϣ 547������ 16��״̬ 0���� 1 ��
--ALTER TABLE ����� CHECK Լ��"c1"��ͻ���ó�ͻ���������ݿ�"test"����"dbo.student", column 'sno'��
--ɾ�������ɹ�����Ӳ���ʧ��						
alter table student drop constraint c1
alter table student add	 constraint c1 check(sno between 900000 and 999999)

--�ָ�ԭc1
alter table student add	 constraint c1 check(sno between 90000 and 99999)

alter table student drop constraint c3
alter table student add	 constraint c3 check(sage<40)

insert student values('90004','�໰�',17,'Ů')
insert student values('90005','��ǰ��',18,'��')
insert student values('90006','������',19,'Ů')
insert student values('90007','������',20,'��')
insert student values('90008','������',21,'Ů')