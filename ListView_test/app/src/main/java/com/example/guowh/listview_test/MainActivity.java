package com.example.guowh.listview_test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    private List<info> mlistInfo = new ArrayList<info>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) this.findViewById(R.id.listView);
        setInfo();
        lv.setAdapter(new ListViewAdapter(mlistInfo));
    }
    public class  ListViewAdapter extends BaseAdapter{
        View[] itemViews;
        public ListViewAdapter(List<info>mlistInfo){
            itemViews=new View[mlistInfo.size()];
            for(int i=0;i<mlistInfo.size();i++){
                info getInfo=(info)mlistInfo.get(i);
                itemViews[i]=makeItemView(
                        getInfo.getTitle(),getInfo.getDetail(),getInfo.getAvatar()
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
        private View makeItemView(String strTitle,String strText,int resId){
            LayoutInflater inflater=(LayoutInflater)MainActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView=inflater.inflate(R.layout.item,null);
            TextView title=(TextView)itemView.findViewById(R.id.title);
            title.setText(strTitle);
            TextView text=(TextView)itemView.findViewById(R.id.info);
            text.setText(strText);
            ImageView image= (ImageView) itemView.findViewById(R.id.img);
            image.setImageResource(resId);
            return  itemView;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null)
                return itemViews[position];
            return convertView;
        }

    }

    public void setInfo() {
        mlistInfo.clear();
        int j=0;//学生1-30
        int k=1;//班级1-4
        for (int i = 0; i < 120; i++) {
            j++;
            if(j==31) {
                j = 1;
                k++;
            }
            info information = new info();
            information.setId(i);
            if(k==1&&j==9)
                information.setTitle("郭文浩");
            else if(k==4&&j==1)
                information.setTitle("刘翠芳");
            else
                information.setTitle("同学" + j);
            if(j<10)
                information.setDetail("631406010" + k+"0"+j);
            else
                information.setDetail("631406010" + k+j);
            information.setAvatar(R.drawable.pig);
            mlistInfo.add(information);
        }
    }
}

