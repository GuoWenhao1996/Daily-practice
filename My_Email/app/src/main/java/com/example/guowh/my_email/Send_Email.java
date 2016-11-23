package com.example.guowh.my_email;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by guowh on 2016/11/23.
 */

public class Send_Email extends AppCompatActivity {
    private String sendAddress = null;
    private String sendPassword = null;
    private String receiveAddress = null;
    private String subject = null;
    private String detail = null;
    private EditText EditText_Detail;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_email);
        final Button Button_Send = (Button) findViewById(R.id.button_send);//获取登录按钮资源
        final EditText EditText_ReceiveAddress = (EditText) findViewById(R.id.editText_ReceiveAddress);
        final EditText EditText_Subject = (EditText) findViewById(R.id.editText_Subject);
        EditText_Detail = (EditText) findViewById(R.id.editText_Detail);

        sendAddress = MainActivity.address;
        sendPassword = MainActivity.pwd;

        Button_Send.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {

                EditText_ReceiveAddress.setText("1842297753@qq.com");
                EditText_Subject.setText("我的主题");
                EditText_Detail.setText("主要内容111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
                Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();

                receiveAddress = EditText_ReceiveAddress.getText().toString();
                subject = EditText_Subject.getText().toString();
                detail = EditText_Detail.getText().toString();
                Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();

                SendMail(sendAddress, sendPassword, receiveAddress, subject, detail);


            }
        });
    }

    private void SendMail(String sendAddress, String sendPassword, String receiveAddress, String subject, String detail) {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.transport.protocol", "smtp");
            Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();

            Session session = Session.getInstance(props);
            session.setDebug(true);
            Toast.makeText(getApplicationContext(), "4", Toast.LENGTH_SHORT).show();

            Message msg = new MimeMessage(session);
            msg.setSubject(subject);
            msg.setText(detail);
            msg.setFrom(new InternetAddress(sendAddress));
            Toast.makeText(getApplicationContext(), "5", Toast.LENGTH_SHORT).show();

            Transport transport = session.getTransport();
            Toast.makeText(getApplicationContext(), "5-1", Toast.LENGTH_SHORT).show();
            transport.connect("smtp.163.com", 25, sendAddress, sendPassword);
            Toast.makeText(getApplicationContext(), "5-2", Toast.LENGTH_SHORT).show();
            transport.sendMessage(msg, new Address[]{new InternetAddress(receiveAddress)});
            Toast.makeText(getApplicationContext(), "6", Toast.LENGTH_SHORT).show();

            transport.close();
            Toast.makeText(getApplicationContext(), "7", Toast.LENGTH_SHORT).show();

            Toast.makeText(getApplicationContext(), "发送成功！", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "发送失败！", Toast.LENGTH_SHORT).show();
            EditText_Detail.setText(e.toString());
        }
    }
}
