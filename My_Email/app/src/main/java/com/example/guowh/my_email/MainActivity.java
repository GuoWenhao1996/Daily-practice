package com.example.guowh.my_email;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static String address="";
    protected static String pwd="";
    private EditText EditText_address;
    private EditText EditText_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button Button_Login = (Button) findViewById(R.id.button_login);//获取登录按钮资源
        EditText_address = (EditText) findViewById(R.id.editText_Address);
        EditText_pwd = (EditText) findViewById(R.id.editText_Password);


        Button_Login.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                if (Loginin()) {
                    Toast.makeText(getApplicationContext(), "登录成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Send_Email.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean Loginin() {
        try {
            address=EditText_address.getText().toString();
            pwd=EditText_pwd.getText().toString();
            return true;
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "登录失败！", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
