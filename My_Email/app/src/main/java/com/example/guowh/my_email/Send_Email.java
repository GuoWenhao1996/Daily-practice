package com.example.guowh.my_email;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by guowh on 2016/11/22.
 */

public class Send_Email extends AppCompatActivity {

    private String sendAddress = null;
    private String sendPassword = null;
    private String receiveAddress = null;
    private String subject = null;
    private String detail = null;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_email);
        final Button Button_Send = (Button) findViewById(R.id.button_send);//获取登录按钮资源
        final EditText EditText_ReceiveAddress = (EditText) findViewById(R.id.editText_ReceiveAddress);
        final EditText EditText_Subject = (EditText) findViewById(R.id.editText_Subject);
        final EditText EditText_Detail = (EditText) findViewById(R.id.editText_Detail);

        sendAddress = MainActivity.address;
        sendPassword = MainActivity.pwd;

        Button_Send.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                try {
                    EditText_ReceiveAddress.setText("1842297753@qq.com");
                    EditText_Subject.setText("我的主题");
                    EditText_Detail.setText("主要内容111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");

                    receiveAddress = EditText_ReceiveAddress.getText().toString();
                    subject = EditText_Subject.getText().toString();
                    detail = EditText_Detail.getText().toString();

                    Properties props = new Properties();
                    props.setProperty("mail.smtp.auth", "true");
                    props.setProperty("mail.transport.protocol", "smtp");

                    Session session = Session.getInstance(props);
                    session.setDebug(true);

                    Message msg = new MimeMessage(session);
                    msg.setSubject(subject);
                    msg.setText(detail);
                    msg.setFrom(new InternetAddress(sendAddress));

                    Transport transport = session.getTransport();
                    transport.connect("smtp.163.com", 25, sendAddress, sendPassword);
                    transport.sendMessage(msg, new Address[]{new InternetAddress(receiveAddress)});

                    transport.close();

                    Toast.makeText(getApplicationContext(), "发送成功！", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "发送失败！", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
