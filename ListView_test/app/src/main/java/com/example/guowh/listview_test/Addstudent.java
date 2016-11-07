package com.example.guowh.listview_test;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by guowh on 2016/11/6.
 */

public class Addstudent extends AppCompatActivity {

    String _id=null;
    String _name=null;
    private SQLiteDatabase db;
    private MyDatabaseHelper helper;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudent);
        helper = new MyDatabaseHelper(Addstudent.this);
        db = helper.getWritableDatabase();
        final Button b_tianjia = (Button) findViewById(R.id.button_tianjia);//获取添加按钮资源
        final EditText XM=(EditText)findViewById(R.id.editText_xm);
        final EditText XH=(EditText)findViewById(R.id.editText_xh);
        b_tianjia.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                _id=XH.getText().toString();
                _name=XM.getText().toString();
                String sql="insert into stulisttb(id,name,state) values ('"+_id+"','"+_name+"',1);";
                try {
                    db.execSQL(sql);
                    Toast.makeText(getApplicationContext(), _name + "保存成功！", Toast.LENGTH_SHORT).show();
                }catch (android.database.sqlite.SQLiteConstraintException e){
                    XH.setSelectAllOnFocus(true);
                    Toast.makeText(getApplicationContext(), "添加失败！\n原因： 学号"+_id+"已存在", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "添加失败！\n原因： 数据库有误" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
