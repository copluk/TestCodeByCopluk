package testClass;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.example.copluk.testcodebycopluk.R;


/**
 * Created by Copluk on 16/6/8.
 */
public class ViewTools {

    private Context _mContent;
    private LayoutInflater _mInflater;

    public ViewTools(Context context){
        _mContent = context;
        _mInflater = LayoutInflater.from(_mContent);
    }

    public PopupWindow setPopup(){

        View popupView = _mInflater.inflate(R.layout.popup_window , null);


        final PopupWindow popupWin = new PopupWindow(popupView
                , WindowManager.LayoutParams.FILL_PARENT
                ,WindowManager.LayoutParams.FILL_PARENT);


        ImageButton popupCancel = (ImageButton) popupView.findViewById(R.id.popupCancel);
        popupCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWin.dismiss();
            }
        });

        return  popupWin;
    }


}
