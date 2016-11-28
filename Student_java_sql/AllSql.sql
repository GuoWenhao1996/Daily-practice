/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  guowh
 * Created: 2016-11-28
 */
 
--使用Link_DB_Student_631406010109数据库
use Link_DB_Student_631406010109

----向学校表插值
--insert into xx values('001','重庆交通大学') 
--insert into xx values('002','重庆大学') 
--insert into xx values('003','重庆工商大学') 
--insert into xx values('004','重庆师范大学') 
--insert into xx values('005','重庆医科大学') 
--insert into xx values('006','重庆邮电大学')
select * from xx 

----向学院表插值
--insert into xy values('11','001','信息科学与工程学院')
--insert into xy values('12','001','土木学院')
--insert into xy values('13','001','机电学院')
--insert into xy values('21','002','重大的一个学院')
--insert into xy values('31','003','工商的一个学院')
--insert into xy values('41','004','重师的一个学院')
select xydm,xymc,xxmc from xy a,xx b where a.xxdm=b.xxdm

----向专业表插值
--insert into zy values('11','11','计算机科学与技术')
--insert into zy values('12','11','通信工程')
--insert into zy values('13','11','电子信息工程')
--insert into zy values('14','11','物联网')
--insert into zy values('21','12','土木造价专业')
--insert into zy values('31','13','齿轮设计专业')
select zydm,zymc,xymc from zy a,xy b where a.xydm=b.xydm

----向班级表插值
--insert into bj values('11','11','计科1401班')
--insert into bj values('12','11','计科1402班')
--insert into bj values('13','11','计科1403班')
--insert into bj values('14','11','计科1404班')
--insert into bj values('21','12','通信1401班')
--insert into bj values('22','12','通信1402班')
--insert into bj values('23','12','通信1403班')
--insert into bj values('31','13','电子1401班')
--insert into bj values('32','13','电子1402班')
--insert into bj values('33','13','电子1403班')
--insert into bj values('41','14','物联1401班')
--insert into bj values('42','14','物联1402班')
--insert into bj values('43','14','物联1403班')
select bjdm,bjmc,zymc from bj a,zy b where a.zydm=b.zydm

----向政治面貌表插值
--insert into zzmm values('01','共产党员')
--insert into zzmm values('02','共青团员')
--insert into zzmm values('03','群众')
--insert into zzmm values('04','其他')
select * from zzmm

----向民族表插值
--insert into mz values('01','汉族')
--insert into mz values('02','藏族')
--insert into mz values('03','回族')
--insert into mz values('04','其它民族')
select * from mz

----向亲属称谓表插值
--insert into qscw values('01','爸爸')
--insert into qscw values('02','妈妈')
--insert into qscw values('03','姐姐')
--insert into qscw values('04','哥哥')
--insert into qscw values('05','娘娘')
--insert into qscw values('06','姨夫')
select * from qscw

----向教师表插值
--insert into js values('T000000001','王家伟')
--insert into js values('T000000002','曹建秋')
--insert into js values('T000000003','王勇')
--insert into js values('T000000004','蒋震')
--insert into js values('T000000005','娄路')
--insert into js values('T000000006','许强')
--insert into js values('T000000007','蒋伟')
select * from js

----向课程表插值
--insert into kc values('C000000001','数据库原理B',3.5)
--insert into kc values('C000000002','操作系统原理A',4)
--insert into kc values('C000000003','计算机网络原理',3.5)
--insert into kc values('C000000004','软件需求分析',2.5)
--insert into kc values('C000000005','移动互联APP',2.5)
--insert into kc values('C000000006','嵌入式程序设计（WMARM）',2.5)
--insert into kc values('C000000007','数据库及应用课程设计',2)
--insert into kc values('C000000008','数学建模',2.5)
select * from kc

----向上课安排表插值
--insert into skap values('C000000001','T000000001','周二上午3-4节&&周四上午1-2节','20406&&20406')
select * from skap