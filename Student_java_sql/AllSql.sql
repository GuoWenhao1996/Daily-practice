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
----alter table xk alter column cj numeric(4, 1) null
----alter table xk alter column bkcj numeric(4, 1) null
----��ѧУ���ֵ
--insert into xx values('001','���콻ͨ��ѧ') 
--insert into xx values('002','�����ѧ') 
--insert into xx values('003','���칤�̴�ѧ') 
--insert into xx values('004','����ʦ����ѧ') 
--insert into xx values('005','����ҽ�ƴ�ѧ') 
--insert into xx values('006','�����ʵ��ѧ')
----select * from xx 

----��ѧԺ���ֵ
--insert into xy values('11','001','��Ϣ��ѧ�빤��ѧԺ')
--insert into xy values('12','001','��ľѧԺ')
--insert into xy values('13','001','��ѧ��ͳ��ѧԺѧԺ')
--insert into xy values('21','002','�ش��һ��ѧԺ')
--insert into xy values('31','003','���̵�һ��ѧԺ')
--insert into xy values('41','004','��ʦ��һ��ѧԺ')
----select xydm,xymc,xxmc from xy a,xx b where a.xxdm=b.xxdm

----��רҵ���ֵ
--insert into zy values('11','11','�������ѧ�뼼��')
--insert into zy values('12','11','ͨ�Ź���')
--insert into zy values('13','11','������Ϣ����')
--insert into zy values('14','11','������')
--insert into zy values('21','12','��ľ���רҵ')
--insert into zy values('31','13','�������רҵ')
----select zydm,zymc,xymc from zy a,xy b where a.xydm=b.xydm

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
----select bjdm,bjmc,zymc from bj a,zy b where a.zydm=b.zydm

----��������ò���ֵ
--insert into zzmm values('01','������Ա')
--insert into zzmm values('02','������Ա')
--insert into zzmm values('03','Ⱥ��')
--insert into zzmm values('04','����')
----select * from zzmm

----��������ֵ
--insert into mz values('01','����')
--insert into mz values('02','����')
--insert into mz values('03','����')
--insert into mz values('04','��������')
----select * from mz

----��������ν���ֵ
--insert into qscw values('01','����')
--insert into qscw values('02','ĸ��')
--insert into qscw values('03','���')
--insert into qscw values('04','���')
--insert into qscw values('05','����')
--insert into qscw values('06','�̷�')
----select * from qscw

----���ʦ���ֵ
--insert into js values('T000000001','����ΰ')
--insert into js values('T000000002','�ܽ���')
--insert into js values('T000000003','����')
--insert into js values('T000000004','����')
--insert into js values('T000000005','¦·')
--insert into js values('T000000006','��ǿ')
--insert into js values('T000000007','��ΰ')
----select * from js

----��γ̱��ֵ
--insert into kc values('11','C000000001','���ݿ�ԭ��B',3.5)
--insert into kc values('11','C000000002','����ϵͳԭ��A',4)
--insert into kc values('11','C000000003','���������ԭ��',3.5)
--insert into kc values('11','C000000004','����������',2.5)
--insert into kc values('11','C000000005','�ƶ�����APP',2.5)
--insert into kc values('11','C000000006','Ƕ��ʽ������ƣ�WMARM��',2.5)
--insert into kc values('11','C000000007','���ݿ⼰Ӧ�ÿγ����',2)
--insert into kc values('13','C000000008','��ѧ��ģ',2.5)
----select * from kc
----select xymc,kcdm,kcmc,xf from kc a,xy b where a.xydm=b.xydm

----��רҵ�γ̱��ֵ
--insert into zykc values('11','C000000001','11',1)
--insert into zykc values('11','C000000002','11',1)
--insert into zykc values('11','C000000003','11',1)
--insert into zykc values('11','C000000004','11',1)
--insert into zykc values('11','C000000005','11',2)
--insert into zykc values('11','C000000006','11',2)
--insert into zykc values('11','C000000007','11',2)
--insert into zykc values('13','C000000008','11',2)
----select * from zykc
----select xymc,c.kcdm,kcmc,xf from xy a,zy b,kc c,zykc d where d.kcdm=c.kcdm and a.xydm=d.xydm and b.zydm=d.zydm and zymc='�������ѧ�뼼��' and xq=2

----���Ͽΰ��ű��ֵ
--insert into skap values('11','C000000001','T000000001','�ܶ�����3-4��&&��������1-2��','20406&&20406')
--insert into skap values('11','C000000002','T000000002','��һ����7-8��&&�ܶ�����5-6��','20203&&20423')
--insert into skap values('11','C000000003','T000000003','��������5-6��&&��������3-4��','20312&&20312')
--insert into skap values('11','C000000004','T000000004','�ܶ�����7-8��','20510')
--insert into skap values('11','C000000005','T000000005','��������1-2��','20505')
--insert into skap values('11','C000000006','T000000006','��һ����1-2��&&��������3-4��','20505&&20505')
--insert into skap values('11','C000000007','T000000001','�ݶ�','�ݶ�')
--insert into skap values('13','C000000008','T000000007','��������7-8��&&��������7-8��','20505&&20505')
----select kcmc,jsxm,sksj,skjs from skap a,kc b,js c where a.kcdm=b.kcdm and a.gh=c.gh

----��ѧ�����ֵ
--insert into xs values('631406010109','01','02','11','���ĺ�','��','20','1996-01-01','һ������ɽ����˧С���˧����ֱ��')
--insert into xs values('631406010102','01','02','11','Ī���','��','19','1997-01-01','һ�����������е�С����')
--insert into xs values('631406010103','01','02','11','���ƽ','��','20','1996-01-01','һ�����Թ���ʡ��С����')
--insert into xs values('631406010124','01','02','11','������','��','20','1996-01-01','һ�����Խ���ʡ��С����')
--insert into xs values('631406010127','02','02','11','����ķ','Ů','20','1996-01-01','һ������������������С����')
--insert into xs values('631406010115','01','03','11','Ф����','��','20','1996-01-01','һ�����������е�С����')
--insert into xs values('631406010201','01','02','12','Фϼ','Ů','20','1996-01-01','һ�����������е�С����')
--insert into xs values('631406010401','01','02','14','���䷼','Ů','20','1996-01-01','һ������ɽ��ʡ��С����')
----select xh,xsxm,bjmc,xb,nl,csrq,mzmc,zzmmmc,jtzz from xs a,mz b,zzmm c,bj d where a.mzdm=b.mzdm and a.zzmmdm=c.zzmmdm and a.bjdm=d.bjdm
----select xh,xsxm,xxmc,xymc,zymc,bjmc,xb,nl,csrq,mzmc,zzmmmc,jtzz 
----	from xs a,mz b,zzmm c,bj d,xx e,xy f,zy g 
----	where a.mzdm=b.mzdm and a.zzmmdm=c.zzmmdm and a.bjdm=d.bjdm and e.xxdm=f.xxdm and f.xydm=g.xydm and g.zydm=d.zydm
	
----������ϵ���ֵ
--insert into shgx values('01','631406010109','��ĳĳ','139********')
--insert into shgx values('02','631406010109','��ĳĳ','139********')
--insert into shgx values('01','631406010102','Īĳĳ','185********')
--insert into shgx values('02','631406010102','ĳĳĳ','187********')
--insert into shgx values('01','631406010124','��ĳĳ','137********')
--insert into shgx values('02','631406010124','ĳĳĳ','184********')
--insert into shgx values('01','631406010401','��ĳĳ','130********')
--insert into shgx values('02','631406010401','ĳĳĳ','131********')
----select * from shgx
----select xsxm,chmc,qsxm,qslxfs from xs a,qscw b,shgx c where a.xh=c.xh and b.chdm=c.chdm

----��ͷ�������ֵ
--insert into cfgl values('CF00000001','631406010109','2016-11-10','����̫˧����')
--insert into cfgl values('CF00000002','631406010109','2016-11-29','Ϊ�˹�ֱ����')
--insert into cfgl values('CF00000003','631406010102','2016-11-10','̫���ȴ���')
--insert into cfgl values('CF00000004','631406010124','2016-5-1','����̫�󴦷�')
--insert into cfgl values('CF00000005','631406010124','2016-11-29','üë̫Ũ����')
--insert into cfgl values('CF00000006','631406010102','2016-11-29','ĳĳĳĳ����')
--insert into cfgl values('CF00000007','631406010109','2016-11-29','��ҹд���ݿ⴦��')
--insert into cfgl values('CF00000008','631406010401','2016-11-29','����̫������')
--insert into cfgl values('CF00000009','631406010401','2016-11-29','�ر����Ĵ���')
----select * from cfgl
----select cfdm,b.xh,xsxm,cfsj,cfnr from cfgl a,xs b where a.xh=b.xh
----select b.xh,xsxm,jldm,jlnr,jlsj from jlgl a,xs b where a.xh=b.xh union select b.xh,xsxm,cfdm,cfnr,cfsj from cfgl a,xs b where a.xh=b.xh

----����������ֵ
--insert into jlgl values('JL00000001','631406010109','2016-11-10','������ƴ������Ƚ�')
--insert into jlgl values('JL00000002','631406010109','2016-11-29','��ҹд���ݿ⽱')
--insert into jlgl values('JL00000003','631406010102','2016-11-10','������ƴ������Ƚ�')
--insert into jlgl values('JL00000004','631406010124','2016-5-1','��������ȭ���ڶ���')
--insert into jlgl values('JL00000005','631406010124','2016-11-29','ĳĳĳĳ��')
--insert into jlgl values('JL00000006','631406010102','2016-11-29','ĳĳĳĳ��')
--insert into jlgl values('JL00000007','631406010109','2016-11-29','ĳĳĳĳ��')
--insert into jlgl values('JL00000008','631406010401','2016-11-29','���Ů�ѽ�')
--insert into jlgl values('JL00000009','631406010401','2016-11-29','ĳĳĳĳ��')
----select * from jlgl
----select jldm,b.xh,xsxm,jlsj,jlnr from jlgl a,xs b where a.xh=b.xh
update jlgl set xh='' ,jlsj='' where jldm=''
update jlgl set jlsj='' where jldm=''
update jlgl set jlnr='' where jldm=''

----��ѡ�α��ֵ
--insert into xk values('11','C000000001','631406010109',100,null)
--insert into xk values('11','C000000002','631406010109',99,null)
--insert into xk values('11','C000000003','631406010109',99,null)
--insert into xk values('11','C000000004','631406010109',100,null)
--insert into xk values('11','C000000005','631406010109',99,null)
--insert into xk values('11','C000000006','631406010109',99,null)
--insert into xk values('11','C000000007','631406010109',99,null)
--insert into xk values('13','C000000008','631406010109',99,null)
--insert into xk values('11','C000000001','631406010102',90,null)
--insert into xk values('11','C000000002','631406010102',90,null)
--insert into xk values('11','C000000003','631406010102',90,null)
--insert into xk values('11','C000000005','631406010102',90,null)
--insert into xk values('11','C000000007','631406010102',90,null)
--insert into xk values('13','C000000008','631406010102',90,null)
--insert into xk values('11','C000000001','631406010124',80,null)
--insert into xk values('11','C000000002','631406010124',50,100)
--insert into xk values('11','C000000003','631406010124',80,null)
--insert into xk values('11','C000000006','631406010124',80,null)
--insert into xk values('11','C000000007','631406010124',80,null)
--insert into xk values('13','C000000008','631406010124',80,null)
--insert into xk values('11','C000000001','631406010401',99,null)
--insert into xk values('11','C000000002','631406010401',99,null)
--insert into xk values('11','C000000003','631406010401',100,null)
--insert into xk values('11','C000000004','631406010401',99,null)
--insert into xk values('11','C000000005','631406010401',99,null)
--insert into xk values('11','C000000006','631406010401',100,null)
--insert into xk values('11','C000000007','631406010401',99,null)
--insert into xk values('13','C000000008','631406010401',99,null)
--select * from xk
--select a.xh,xsxm,a.kcdm,kcmc,cj,bkcj from xk a,xs b,kc c where a.xh=b.xh and a.kcdm=c.kcdm
--select a.xh,xsxm,a.kcdm,kcmc,cj,bkcj from xk a,xs b,kc c where a.xh=b.xh and a.kcdm=c.kcdm and b.xsxm='���ĺ�'
--select a.xh,xsxm,a.kcdm,kcmc,cj,bkcj from xk a,xs b,kc c where a.xh=b.xh and a.kcdm=c.kcdm and b.xsxm='���䷼'