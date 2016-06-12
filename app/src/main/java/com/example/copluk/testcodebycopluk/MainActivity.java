package com.example.copluk.testcodebycopluk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import org.json.JSONArray;

import testClass.ViewTools;
import testClass.myAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        JSONArray data = new JSONArray();
        for (int i = 0 ; i < 100 ; i++){
            data.put(Integer.toString(i));
        }
        myAdapter myAdapter = new myAdapter(this,data);

        ListView lV = (ListView) findViewById(R.id.listView);
        lV.setAdapter(myAdapter);

        ViewTools viewTools = new ViewTools(this);
        final PopupWindow popupWin = viewTools.setPopup();

        Button testBtn = (Button) findViewById(R.id.testButton1);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                popupWin.showAsDropDown(v);
                popupWin.showAtLocation(v,  Gravity.NO_GRAVITY , 0 , 0);
            }
        });



    }

}
