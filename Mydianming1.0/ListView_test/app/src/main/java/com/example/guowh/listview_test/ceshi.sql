insert into stulisttb(id,name,state) values ('631406010102','Ī���',1);
insert into stulisttb(id,name,state) values ('631406010103','���ƽ',1);
insert into stulisttb(id,name,state) values ('631406010104','���ı�',1);
insert into stulisttb(id,name,state) values ('631406010105','�˿���',1);
insert into stulisttb(id,name,state) values ('631406010106','ʯ����',1);
insert into stulisttb(id,name,state) values ('631406010107','��Ȩ',1);
insert into stulisttb(id,name,state) values ('631406010108','����',1);
insert into stulisttb(id,name,state) values ('631406010109','���ĺ�',1);
insert into stulisttb(id,name,state) values ('631406010110','�',1);
insert into stulisttb(id,name,state) values ('631406010111','���˺�',1);
insert into stulisttb(id,name,state) values ('631406010112','�ŷ�',1);
insert into stulisttb(id,name,state) values ('631406010113','����',1);
insert into stulisttb(id,name,state) values ('631406010114','�̼ѳ�',1);
insert into stulisttb(id,name,state) values ('631406010115','Ф����',1);
insert into stulisttb(id,name,state) values ('631406010117','�鿭��',1);
insert into stulisttb(id,name,state) values ('631406010118','����',1);
insert into stulisttb(id,name,state) values ('631406010119','����',1);
insert into stulisttb(id,name,state) values ('631406010120','�����',1);
insert into stulisttb(id,name,state) values ('631406010122','̷��',1);
insert into stulisttb(id,name,state) values ('631406010123','������',1);

update stulisttb set state=2 where id='631406010102'
update stulisttb set state=1 where id='631406010109'
delete from stulisttb where id='631406010102' and name='莫天金'
select name from stulisttb where id='631406010109'
select id from stulisttb where name='郭文浩'