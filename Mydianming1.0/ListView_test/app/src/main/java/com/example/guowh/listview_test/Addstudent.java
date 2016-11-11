package com.example.guowh.listview_test;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

/**
 * Created by guowh on 2016/11/6.
 */

public class Addstudent extends AppCompatActivity {

    String _id = null;
    String _name = null;
    byte[] _photo;
    private SQLiteDatabase db;
    private MyDatabaseHelper helper;
    private ImageView ZP;
    private Bitmap addBitmap;
    private Cursor c;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudent);
        helper = new MyDatabaseHelper(Addstudent.this);
        db = helper.getWritableDatabase();
        final Button b_tianjia = (Button) findViewById(R.id.button_tianjia);//获取添加按钮资源
        final EditText XM = (EditText) findViewById(R.id.editText_xm);
        final EditText XH = (EditText) findViewById(R.id.editText_xh);
        ZP = (ImageView) findViewById(R.id.imageView_add);

        b_tianjia.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                _id = XH.getText().toString();
                _name = XM.getText().toString();
                _photo = getPicture(addBitmap);
                //String sql="insert into stulisttb(id,name,state) values ('"+_id+"','"+_name+"',1);";
                try {
                    //db.execSQL(sql);
                    //Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                    c = db.query("stulisttb", null, "id=?", new String[]{_id}, null, null, null);
                    //Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
                    c.moveToNext();
                    c.getString(0);
                        //Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "添加失败！\n原因： 学号" + _id + "已存在", Toast.LENGTH_SHORT).show();

                } catch (android.database.CursorIndexOutOfBoundsException e) {
                    //Toast.makeText(getApplicationContext(), "4", Toast.LENGTH_SHORT).show();
                    c.close();
                    ContentValues cv = new ContentValues();
                    cv.put("id", _id);
                    cv.put("name", _name);
                    cv.put("state", 1);
                    ZP.setDrawingCacheEnabled(true);
                    //cv.put("photo", getPicture(addBitmap));
                    cv.put("photo", _photo);
                    ZP.setDrawingCacheEnabled(false);
                    db.insert("stulisttb", null, cv);
                    Toast.makeText(getApplicationContext(), _name + "保存成功！", Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "添加失败！\n原因： 数据库有误"+e.toString(), Toast.LENGTH_SHORT).show();
                }
                c.close();
            }
        });
        ZP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击照片", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(Intent.ACTION_PICK,
                //        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                Intent intent = new Intent();
                intent.setType("image/*"); //定义打开图片类型
                intent.setAction(Intent.ACTION_GET_CONTENT); //设置action为A。。。，代表图片内容
                startActivityForResult(intent, 1); //得到图片返回当前页
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //接受用户通过其他activity返回的数据
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) { //请求为1，进行处理
            if (resultCode == RESULT_OK) { //成功得到照片返回
                ContentResolver cr = this.getContentResolver();//通过Activity的content得到ContentR。。
                Uri uri = data.getData(); //得到返回的data数据
                try {
                    //通过ContentR。。得到对应图片的Bitmap
                    addBitmap = MediaStore.Images.Media.getBitmap(cr, uri);
                    ZP.setImageBitmap(addBitmap); //图片放Image。。去
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "错误" + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //将Bitmap转换成可以用来存储的byte[]类型
    private byte[] getPicture(Bitmap bitmap) {
        if (bitmap == null)
            return null;
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
