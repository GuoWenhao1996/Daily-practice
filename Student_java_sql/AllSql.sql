/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  guowh
 * Created: 2016-11-28
 */
 
--ʹ��Link_DB_Student_631406010109���ݿ�
use Link_DB_Student_631406010109

----��ѧУ���ֵ
--insert into xx values('001','���콻ͨ��ѧ') 
--insert into xx values('002','�����ѧ') 
--insert into xx values('003','���칤�̴�ѧ') 
--insert into xx values('004','����ʦ����ѧ') 
--insert into xx values('005','����ҽ�ƴ�ѧ') 
--insert into xx values('006','�����ʵ��ѧ')
select * from xx 

----��ѧԺ���ֵ
--insert into xy values('11','001','��Ϣ��ѧ�빤��ѧԺ')
--insert into xy values('12','001','��ľѧԺ')
--insert into xy values('13','001','����ѧԺ')
--insert into xy values('21','002','�ش��һ��ѧԺ')
--insert into xy values('31','003','���̵�һ��ѧԺ')
--insert into xy values('41','004','��ʦ��һ��ѧԺ')
select xydm,xymc,xxmc from xy a,xx b where a.xxdm=b.xxdm

----��רҵ���ֵ
--insert into zy values('11','11','�������ѧ�뼼��')
--insert into zy values('12','11','ͨ�Ź���')
--insert into zy values('13','11','������Ϣ����')
--insert into zy values('14','11','������')
--insert into zy values('21','12','��ľ���רҵ')
--insert into zy values('31','13','�������רҵ')
select zydm,zymc,xymc from zy a,xy b where a.xydm=b.xydm

----��༶���ֵ
--insert into bj values('11','11','�ƿ�1401��')
--insert into bj values('12','11','�ƿ�1402��')
--insert into bj values('13','11','�ƿ�1403��')
--insert into bj values('14','11','�ƿ�1404��')
--insert into bj values('21','12','ͨ��1401��')
--insert into bj values('22','12','ͨ��1402��')
--insert into bj values('23','12','ͨ��1403��')
--insert into bj values('31','13','����1401��')
--insert into bj values('32','13','����1402��')
--insert into bj values('33','13','����1403��')
--insert into bj values('41','14','����1401��')
--insert into bj values('42','14','����1402��')
--insert into bj values('43','14','����1403��')
select bjdm,bjmc,zymc from bj a,zy b where a.zydm=b.zydm

----��������ò���ֵ
--insert into zzmm values('01','������Ա')
--insert into zzmm values('02','������Ա')
--insert into zzmm values('03','Ⱥ��')
--insert into zzmm values('04','����')
select * from zzmm

----��������ֵ
--insert into mz values('01','����')
--insert into mz values('02','����')
--insert into mz values('03','����')
--insert into mz values('04','��������')
select * from mz

----��������ν���ֵ
--insert into qscw values('01','�ְ�')
--insert into qscw values('02','����')
--insert into qscw values('03','���')
--insert into qscw values('04','���')
--insert into qscw values('05','����')
--insert into qscw values('06','�̷�')
select * from qscw

----���ʦ���ֵ
--insert into js values('T000000001','����ΰ')
--insert into js values('T000000002','�ܽ���')
--insert into js values('T000000003','����')
--insert into js values('T000000004','����')
--insert into js values('T000000005','¦·')
--insert into js values('T000000006','��ǿ')
--insert into js values('T000000007','��ΰ')
select * from js

----��γ̱��ֵ
--insert into kc values('C000000001','���ݿ�ԭ��B',3.5)
--insert into kc values('C000000002','����ϵͳԭ��A',4)
--insert into kc values('C000000003','���������ԭ��',3.5)
--insert into kc values('C000000004','����������',2.5)
--insert into kc values('C000000005','�ƶ�����APP',2.5)
--insert into kc values('C000000006','Ƕ��ʽ������ƣ�WMARM��',2.5)
--insert into kc values('C000000007','���ݿ⼰Ӧ�ÿγ����',2)
--insert into kc values('C000000008','��ѧ��ģ',2.5)
select * from kc

----���Ͽΰ��ű��ֵ
--insert into skap values('C000000001','T000000001','�ܶ�����3-4��&&��������1-2��','20406&&20406')
select * from skap