create table student
	(sno	numeric(6)	constraint c1 check(sno between 90000 and 99999),
	 sname	char(20)	constraint c2 not null,
	 sage	numeric(3)	constraint c3 check(sage<30),
	 ssex	char(2)		constraint c4 check(ssex in('男','女')),
						constraint studentkey primary key(sno))
						
--此句消息 547，级别 16，状态 0，第 1 行
--ALTER TABLE 语句与 CHECK 约束"c1"冲突。该冲突发生于数据库"test"，表"dbo.student", column 'sno'。
--删除操作成功，添加操作失败						
alter table student drop constraint c1
alter table student add	 constraint c1 check(sno between 900000 and 999999)

--恢复原c1
alter table student add	 constraint c1 check(sno between 90000 and 99999)

alter table student drop constraint c3
alter table student add	 constraint c3 check(sage<40)

insert student values('90004','嗷嗷啊',17,'女')
insert student values('90005','其前期',18,'男')
insert student values('90006','啧啧啧',19,'女')
insert student values('90007','我问问',20,'男')
insert student values('90008','是是是',21,'女')