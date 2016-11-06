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

public class Deletestudent extends AppCompatActivity {
    String _id=null;
    String _name=null;
    private SQLiteDatabase db;
    private MyDatabaseHelper helper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletestudent);
        helper = new MyDatabaseHelper(Deletestudent.this);
        db = helper.getWritableDatabase();
        final Button b_shanchu = (Button) findViewById(R.id.button_shanchu);//获取添加按钮资源
        final EditText XM=(EditText)findViewById(R.id.editText_xm);
        final EditText XH=(EditText)findViewById(R.id.editText_xh);
        b_shanchu.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                _id=XH.getText().toString();
                _name=XM.getText().toString();
                //String sql="select name from stulisttb where id='"+_id+"'";
                //db.execSQL(sql);
                //if(_name.equals()) {
                    try {
                        String sql2="delete from stulisttb where id='"+_id+"'";
                        db.execSQL(sql2);
                            Toast.makeText(getApplicationContext(), _name + "删除成功", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "数据库有误" + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                //}
              //  else
                //    Toast.makeText(getApplicationContext(), "姓名学号不匹配，请核对！", Toast.LENGTH_SHORT).show();
           }
        });
    }

}