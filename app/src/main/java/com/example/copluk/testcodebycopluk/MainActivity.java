package com.example.copluk.testcodebycopluk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int checkButton = 0;
    String mainMessage = "testAPP1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mainText ;
        Button testButton = (Button)findViewById(R.id.testButton1);


        mainText = (TextView)findViewById(R.id.mainTextBox);
        mainText.setText(mainMessage);

        testButton.setText("ButtonTest");
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testButton(mainText);
            }
        });

    }

    private void testButton(TextView mainText){

        if (checkButton == 0)
        {
            mainMessage = "testAPP2";
            mainText.setText(mainMessage);
            checkButton = 1;
        }else{
            mainMessage = "testAPP1";
            mainText.setText(mainMessage);
            checkButton = 0;
        }

    }

}
