package com.example.copluk.testcodebycopluk;

import android.widget.TextView;

/**
 * Created by Copluk on 16/3/28.
 */
public class testButton {

    String mainMessage;
    public int testButton(TextView mainText , int checkButton){

        if (checkButton == 0)
        {
            mainMessage = "testAPP2";
            mainText.setText(mainMessage);
            return  1;
        }else{
            mainMessage = "testAPP1";
            mainText.setText(mainMessage);
            return  0;
        }

    }
}
