package com.example.guowh.my_email;

import android.os.Bundle;
import android.os.StrictMode;
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
    private EditText EditText_ReceiveAddress;
    private EditText EditText_Subject;
    private EditText EditText_Detail;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_email);
        final Button Button_Send = (Button) findViewById(R.id.button_send);//获取登录按钮资源
        EditText_ReceiveAddress = (EditText) findViewById(R.id.editText_ReceiveAddress);
        EditText_Subject = (EditText) findViewById(R.id.editText_Subject);
        EditText_Detail = (EditText) findViewById(R.id.editText_Detail);

        sendAddress = MainActivity.address;
        sendPassword = MainActivity.pwd;

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());

        Button_Send.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
//                EditText_ReceiveAddress.setText("1842297753@qq.com");
//                EditText_Subject.setText("我的主题");
//                EditText_Detail.setText("主要内容111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
                receiveAddress = EditText_ReceiveAddress.getText().toString();
                subject = EditText_Subject.getText().toString();
                detail = EditText_Detail.getText().toString();
                SendMail(sendAddress, sendPassword, receiveAddress, subject, detail);
            }
        });
    }

    private void SendMail( String sendAddress,  String sendPassword,  String receiveAddress, String subject, String detail) {
        try {
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
            Toast.makeText(getApplicationContext(), "发送失败！"+e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
