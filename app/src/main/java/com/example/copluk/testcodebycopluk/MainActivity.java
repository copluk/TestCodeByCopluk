package com.example.copluk.testcodebycopluk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.List;

import testClass.myAdapter;

public class MainActivity extends AppCompatActivity {

    int checkButton = 0;
    String mainMessage = "testAPP1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mainText ;
        Button testButton = (Button)findViewById(R.id.testButton1);
        final Button gpsButton = (Button)findViewById(R.id.gpsButton);



        mainText = (TextView)findViewById(R.id.mainTextBox);
        mainText.setText(mainMessage);

        testButton.setText("ButtonTest");
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                testButton test1 = new testButton();

                checkButton = test1.testButton(mainText , checkButton);
            }
        });

        //加入一個按紐、拿GPS資料
        //在Manifest add <INTERNET> <ACCESS_NETWORK_STATE> <ACCESS_FINE_LOCATION> <ACCESS_FINE_LOCATION>
        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpsModel gpsModel = new gpsModel(MainActivity.this);

                gpsButton.setText(gpsModel.useGps());

            }
        });

        JSONArray data = new JSONArray();
        for (int i = 0 ; i < 100 ; i++){
            data.put(Integer.toString(i));
        }
        myAdapter myAdapter = new myAdapter(this,data);

        ListView lV = (ListView) findViewById(R.id.listView);
        lV.setAdapter(myAdapter);

    }



//    private void testButton(TextView mainText){
//
//        if (checkButton == 0)
//        {
//            mainMessage = "testAPP2";
//            mainText.setText(mainMessage);
//            checkButton = 1;
//        }else{
//            mainMessage = "testAPP1";
//            mainText.setText(mainMessage);
//            checkButton = 0;
//        }
//
//    }

}
