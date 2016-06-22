package com.example.nikeru8.app_spinner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private List<Integer> list;
    private ArrayAdapter<Integer> adapter;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        initaladapter();
    }


    private void init() {
        context = this;
        spinner = (Spinner) findViewById(R.id.spinner);
    }

    private void initaladapter() {

        //創造陣列
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);



       //這裡就是adapter的使用方法了，把陣列內的資料丟入adapter(轉接器)，在輸出到螢幕上(spinner)
        adapter = new ArrayAdapter<Integer>(context, android.R.layout.simple_spinner_item, list);


        //把adapter(轉接器)輸入到spinner內！
        spinner.setAdapter(adapter);






        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //選擇之後
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                //+上吐司能清楚看出切換。
                Toast.makeText(context, list.get(position).toString(), Toast.LENGTH_SHORT).show();

            }

            //都不選擇的話，這邊可以空白不影響。
            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


    }


}
