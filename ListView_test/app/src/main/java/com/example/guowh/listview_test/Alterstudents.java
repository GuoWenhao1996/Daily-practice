package com.example.guowh.listview_test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;

/**
 * Created by guowh on 2016/11/10.
 */

public class Alterstudents extends AppCompatActivity {
    String _id = null;
    String _name = null;
    private SQLiteDatabase db;
    private MyDatabaseHelper helper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alterstudent);
        helper = new MyDatabaseHelper(Alterstudents.this);
        db = helper.getWritableDatabase();
        final Button b_xiugai = (Button) findViewById(R.id.button_alter);//获取修改按钮资源
        final Button b_chakan = (Button) findViewById(R.id.button_look);//获取查看按钮资源
        final EditText XM = (EditText) findViewById(R.id.editText_xm);
        final EditText XH = (EditText) findViewById(R.id.editText_xh);
        final ImageView ZP = (ImageView) findViewById(R.id.imageView_alter);

        b_chakan.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                _id = XH.getText().toString();
                Cursor c = db.query("stulisttb",null, "id=?", new String[]{_id}, null, null, null);
                if (c.moveToNext()) {
                    XM.setText(c.getString(c.getColumnIndex("name")));
                    if(c.getBlob(3)!=null) {
                        ByteArrayInputStream baisTouXiang = new ByteArrayInputStream(c.getBlob(3));
                        ZP.setImageDrawable(Drawable.createFromStream(baisTouXiang, "zhaopian"));
                    }
                } else
                    Toast.makeText(getApplicationContext(), "查找失败！\n原因： 此学号不存在，请核对！", Toast.LENGTH_SHORT).show();
                c.close();
            }
        });
//        b_xiugai.setOnClickListener(new View.OnClickListener() {//创建监听
//            @Override
//            public void onClick(View view) {
//                _id = XH.getText().toString();
//                _name = XM.getText().toString();
//                //String sql="select name from stulisttb where id='"+_id+"'";
//                //db.execSQL(sql);
//                Cursor c = db.query("stulisttb", new String[]{"name"}, "id=?", new String[]{_id}, null, null, null);
//                if (c.moveToNext()) {
//                    if (c.getString(c.getColumnIndex("name")).equals( _name)) {
//                        try {
//                            //db.delete("stulisttb","id=?",new String[]{_id});
//                            String sql2 = "delete from stulisttb where id='" + _id + "'";
//                            db.execSQL(sql2);
//                            Toast.makeText(getApplicationContext(), _name + "删除成功", Toast.LENGTH_SHORT).show();
//                        } catch (Exception e) {
//                            Toast.makeText(getApplicationContext(), "数据库有误" + e.toString(), Toast.LENGTH_SHORT).show();
//                        }
//                    } else
//                        Toast.makeText(getApplicationContext(), "删除失败！\n原因： 此学号与姓名不匹配，请核对！", Toast.LENGTH_SHORT).show();
//                } else
//                    Toast.makeText(getApplicationContext(), "删除失败！\n原因： 此学号不存在，请核对！", Toast.LENGTH_SHORT).show();
//                c.close();
//            }
//        });
    }

}