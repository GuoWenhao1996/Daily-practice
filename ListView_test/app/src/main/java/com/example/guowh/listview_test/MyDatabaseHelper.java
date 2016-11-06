package com.example.guowh.listview_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by guowh on 2016/11/3.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {


    private String[] str=new String[22];
    private void sqlstr(){
        str[0]="insert into stulisttb(id,name,state) values ('631406010102','莫天金',1);";
        str[1]="insert into stulisttb(id,name,state) values ('631406010103','吴国平',1);";
        str[2]="insert into stulisttb(id,name,state) values ('631406010104','孙文斌',1);";
        str[3]="insert into stulisttb(id,name,state) values ('631406010105','潘俊旭',1);";
        str[4]="insert into stulisttb(id,name,state) values ('631406010106','石佳磊',1);";
        str[5]="insert into stulisttb(id,name,state) values ('631406010107','赵权',1);";
        str[6]="insert into stulisttb(id,name,state) values ('631406010108','马鹏',1);";
        str[7]="insert into stulisttb(id,name,state) values ('631406010109','郭文浩',1);";
        str[8]="insert into stulisttb(id,name,state) values ('631406010110','李季',1);";
        str[9]="insert into stulisttb(id,name,state) values ('631406010111','陈仕豪',1);";
        str[10]="insert into stulisttb(id,name,state) values ('631406010112','杜菲',1);";
        str[11]="insert into stulisttb(id,name,state) values ('631406010113','李红兵',1);";
        str[12]="insert into stulisttb(id,name,state) values ('631406010114','蔡佳辰',1);";
        str[13]="insert into stulisttb(id,name,state) values ('631406010115','肖洒益',1);";
        str[14]="insert into stulisttb(id,name,state) values ('631406010117','伍凯荣',1);";
        str[15]="insert into stulisttb(id,name,state) values ('631406010118','张林',1);";
        str[16]="insert into stulisttb(id,name,state) values ('631406010119','王斌',1);";
        str[17]="insert into stulisttb(id,name,state) values ('631406010120','廖宇峰',1);";
        str[18]="insert into stulisttb(id,name,state) values ('631406010122','谭建',1);";
        str[19]="insert into stulisttb(id,name,state) values ('631406010123','左永和',1);";
        str[20]="insert into stulisttb(id,name,state) values ('631406010124','111111',1);";
        str[21]="insert into stulisttb(id,name,state) values ('631406010125','222222',1);";
    }

    public MyDatabaseHelper(Context context) {
        super(context,"stulist.db", null, 1);
    }

    @Override//首次创建数据库时使用
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table stulisttb(id text primary key,name text,state integer default(0));");
        sqlstr();
        for(int i=0;i<str.length;i++){
            db.execSQL(str[i]);
        }
    }

    @Override//更新数据库
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
