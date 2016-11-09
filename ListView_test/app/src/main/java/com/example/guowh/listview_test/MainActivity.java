package com.example.guowh.listview_test;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<info> mlistInfo = new ArrayList<info>();
    private SQLiteDatabase db;
    private MyDatabaseHelper helper;
    private Cursor c;
    private int number = 0;
    private int c_Position = -1;
    private boolean b = true;
    private View[] itemViews;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new MyDatabaseHelper(MainActivity.this);
        db = helper.getWritableDatabase();
        final Button b_pre = (Button) findViewById(R.id.button_pre);//获取上一页按钮资源
        final Button b_next = (Button) findViewById(R.id.button_next);//获取下一页按钮资源
        final Button b_add = (Button) findViewById(R.id.button_add);//获取添加按钮资源
        final Button b_delete = (Button) findViewById(R.id.button_delete);//获取删除按钮资源
        //final ImageView img_touxiang = (ImageView) findViewById(R.id.img);//获取img按钮资源
        lv = (ListView) this.findViewById(R.id.listView);
        setInfo();
        lv.setAdapter(new ListViewAdapter(mlistInfo));
        b_next.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                number = 0;
                setInfo();
                lv.setAdapter(new ListViewAdapter(mlistInfo));
            }
        });
        b_pre.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                number = 0;
                set_c_pre();
                setInfo();
                lv.setAdapter(new ListViewAdapter(mlistInfo));
            }
        });

        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                info getObject = mlistInfo.get(position);
                String stuid = getObject.getStudent_id();
                String name = getObject.getName();
                int ra = 0;
                RadioButton radio_zq = (RadioButton) itemViews[position].findViewById(R.id.radioButton_zq);
                RadioButton radio_cd = (RadioButton) itemViews[position].findViewById(R.id.radioButton_cd);
                RadioButton radio_zt = (RadioButton) itemViews[position].findViewById(R.id.radioButton_zt);
                RadioButton radio_kk = (RadioButton) itemViews[position].findViewById(R.id.radioButton_kk);
                RadioButton radio_bj = (RadioButton) itemViews[position].findViewById(R.id.radioButton_bj);
                if (radio_zq.isChecked() == true)
                    ra = 1;
                else if (radio_cd.isChecked() == true)
                    ra = 2;
                else if (radio_zt.isChecked() == true)
                    ra = 3;
                else if (radio_kk.isChecked() == true)
                    ra = 4;
                else if (radio_bj.isChecked() == true)
                    ra = 5;
                else
                    ra = 0;
                //Toast.makeText(getApplicationContext(), ra + "", Toast.LENGTH_SHORT).show();
                try {
                    String sql = "update stulisttb set state=" + ra + " where id='" + stuid + "'";
                    db.execSQL(sql);
                    Toast.makeText(getApplicationContext(), name + "数据保存成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "数据库有误" + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        b_add.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Addstudent.class);
                startActivity(intent);
            }
        });
        b_delete.setOnClickListener(new View.OnClickListener() {//创建监听
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Deletestudent.class);
                startActivity(intent);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).

                addApi(AppIndex.API)

                .

                        build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public class ListViewAdapter extends BaseAdapter {


        public ListViewAdapter(List<info> mlistInfo) {
            itemViews = new View[mlistInfo.size()];
            for (int i = 0; i < mlistInfo.size(); i++) {
                info getInfo = (info) mlistInfo.get(i);
                itemViews[i] = makeItemView(
                        getInfo.getName(), getInfo.getStudent_id(), getInfo.getState(), getInfo.getPhoto()
                );
            }
        }

        @Override
        public int getCount() {
            return itemViews.length;
        }

        @Override
        public View getItem(int position) {
            return itemViews[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private View makeItemView(String stuName, String stuID, int state, int imgId) {
            LayoutInflater inflater = (LayoutInflater) MainActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.item, null);
            TextView Sname = (TextView) itemView.findViewById(R.id.name);
            Sname.setText(stuName);
            TextView Sid = (TextView) itemView.findViewById(R.id.stu_id);
            Sid.setText(stuID);
            RadioButton radio_zq = (RadioButton) itemView.findViewById(R.id.radioButton_zq);
            RadioButton radio_cd = (RadioButton) itemView.findViewById(R.id.radioButton_cd);
            RadioButton radio_zt = (RadioButton) itemView.findViewById(R.id.radioButton_zt);
            RadioButton radio_kk = (RadioButton) itemView.findViewById(R.id.radioButton_kk);
            RadioButton radio_bj = (RadioButton) itemView.findViewById(R.id.radioButton_bj);
            switch (state) {
                case 1:
                    radio_zq.setChecked(true);
                    break;
                case 2:
                    radio_cd.setChecked(true);
                    break;
                case 3:
                    radio_zt.setChecked(true);
                    break;
                case 4:
                    radio_kk.setChecked(true);
                    break;
                case 5:
                    radio_bj.setChecked(true);
                    break;
            }
            ImageView image = (ImageView) itemView.findViewById(R.id.img);
            image.setImageResource(imgId);
            return itemView;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                return itemViews[position];
            return convertView;
        }

    }

    private void setInfo() {
        mlistInfo.clear();
        info information;
        c = db.query("stulisttb", null, null, null, null, null, null);
        c.moveToPosition(c_Position);
        while (c.moveToNext()) {
            b = false;
            number++;
            String id = c.getString(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            int state = c.getInt(c.getColumnIndex("state"));
            information = new info();
            information.setName(name);
            information.setStudent_id(id);
            information.setState(state);
            switch (id) {
                case "631406010102":
                    information.setPhoto(R.drawable._631406010102);
                    break;
                case "631406010103":
                    information.setPhoto(R.drawable._631406010103);
                    break;
                case "631406010104":
                    information.setPhoto(R.drawable._631406010104);
                    break;
                case "631406010105":
                    information.setPhoto(R.drawable._631406010105);
                    break;
                case "631406010106":
                    information.setPhoto(R.drawable._631406010106);
                    break;
                case "631406010107":
                    information.setPhoto(R.drawable._631406010107);
                    break;
                case "631406010108":
                    information.setPhoto(R.drawable._631406010108);
                    break;
                case "631406010109":
                    information.setPhoto(R.drawable._631406010109);
                    break;
                case "631406010110":
                    information.setPhoto(R.drawable._631406010110);
                    break;
                case "631406010111":
                    information.setPhoto(R.drawable._631406010111);
                    break;
                case "631406010112":
                    information.setPhoto(R.drawable._631406010112);
                    break;
                case "631406010113":
                    information.setPhoto(R.drawable._631406010113);
                    break;
                case "631406010114":
                    information.setPhoto(R.drawable._631406010114);
                    break;
                case "631406010401":
                    information.setPhoto(R.drawable._631406010401);
                    break;
                default:
                    information.setPhoto(R.drawable.pig);
                    break;
            }
            mlistInfo.add(information);
            if (number == 5) {
                c_Position = c.getPosition();
                b = true;
                break;
            }
        }
        c.close();
        //db.close();
    }


    private void set_c_pre() {
        if (b)
            c_Position = c_Position - 10;
        else
            c_Position = c_Position - 5;
    }

    //之前的手动测试信息
//        public void setInfo() {
//        mlistInfo.clear();
//        int j=0;//学生1-30
//        int k=1;//班级1-4
//        for (int i = 0; i < 100; i++) {
//            j++;
//            if(j==31) {
//                j = 1;
//                k++;
//            }
//            info information = new info();
//            if(k==1&&j==9)
//                information.setName("郭文浩");
//            else if(k==4&&j==1)
//                information.setName("刘翠芳");
//            else
//                information.setName("同学" + j);
//            if(j<10)
//                information.setStudent_id("631406010" + k+"0"+j);
//            else
//                information.setStudent_id("631406010" + k+j);
//            information.setPhoto(R.drawable.pig);
//            mlistInfo.add(information);
//        }
//    }


    //                int ra=0;
//                if (radio_zq.getId() == checkedId) {
//                    ra=1;
//                } else if (radio_cd.getId() == checkedId) {
//                    ra=2;
//                } else if (radio_zt.getId() == checkedId) {
//                    ra=3;
//                } else if (radio_kk.getId() == checkedId) {
//                    ra=4;
//                } else if (radio_bj.getId() == checkedId) {
//                    ra=5;
//                }
//                try {
//                    String sql = "update stulisttb set state="+ra+" where id='631406010102'";
//                    //db.execSQL(sql);
//                    Toast.makeText(getApplicationContext(), "数据保存成功", Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(), "数据库有误" + e.toString(), Toast.LENGTH_SHORT).show();
//                }
}

