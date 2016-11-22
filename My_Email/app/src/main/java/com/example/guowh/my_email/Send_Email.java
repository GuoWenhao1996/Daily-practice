package com.example.guowh.my_email;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by guowh on 2016/11/22.
 */

public class Send_Email extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_email);
        final Button Button_Send = (Button) findViewById(R.id.button_send);//获取登录按钮资源
        final EditText EditText_ReceiveAddress = (EditText) findViewById(R.id.editText_ReceiveAddress);
        final EditText EditText_Subject = (EditText) findViewById(R.id.editText_Subject);
        final EditText EditText_Detail = (EditText) findViewById(R.id.editText_Detail);

        String sendAddress="写";
        String sendPassword="写";

        String receiveAddress=EditText_ReceiveAddress.getText().toString();
        String subject=EditText_Subject.getText().toString();
        String detail=EditText_Detail.getText().toString();


        Button_Send.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                try{

                    Toast.makeText(getApplicationContext(), "发送成功！", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "发送失败！", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
