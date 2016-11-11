package com.example.guowh.listview_test;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by guowh on 2016/11/10.
 */

public class Alterstudents extends AppCompatActivity {
    String _id = null;
    String _name = null;
    private SQLiteDatabase db;
    private MyDatabaseHelper helper;
    byte[] _photo;
    private Bitmap addBitmap;
    private ImageView ZP;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alterstudent);
        helper = new MyDatabaseHelper(Alterstudents.this);
        db = helper.getWritableDatabase();
        final Button b_xiugai = (Button) findViewById(R.id.button_alter);//获取修改按钮资源
        final Button b_chakan = (Button) findViewById(R.id.button_look);//获取查看按钮资源
        final EditText XM = (EditText) findViewById(R.id.editText_xm);
        final EditText XH = (EditText) findViewById(R.id.editText_xh);
        ZP = (ImageView) findViewById(R.id.imageView_alter);

        b_chakan.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                ZP.setImageResource(R.drawable.pig);
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
        b_xiugai.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                _id = XH.getText().toString();
                _name = XM.getText().toString();
                _photo = getPicture(addBitmap);
                ContentValues cv = new ContentValues();
                cv.put("id", _id);
                cv.put("name", _name);
                cv.put("state", 1);
                ZP.setDrawingCacheEnabled(true);
                //cv.put("photo", getPicture(addBitmap));
                cv.put("photo", _photo);
                ZP.setDrawingCacheEnabled(false);
                db.update("stulisttb",cv,"id=?", new String[]{_id});
                Toast.makeText(getApplicationContext(), _id + "修改成功！", Toast.LENGTH_SHORT).show();
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