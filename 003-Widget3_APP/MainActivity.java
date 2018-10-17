package com.jj.widget3app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button button1 , button2, button3;
    private TextView text1 , text2 ,text3;
    private ImageButton imageButton1 , imageButton2, imageButton3 ;
    private ImageButton imageButton4, imageButton5, imageButton6;
    private View.OnClickListener buttonClick;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this ; //notifyMessage 螢幕下方顯示訊息 context可以自行定義,紅字要Create field到MainActivity

        button1 = (Button) findViewById(R.id.button_id1);      //宣告button_id1到button1變數
        button2 = (Button) findViewById(R.id.button_id2);      //宣告button_id2到button2變數
        button3 = (Button) findViewById(R.id.button_id3);      //宣告button_id3到button3變數

        text1 = (TextView) findViewById(R.id.textView_id1);   //宣告textView_id1到text1變數
        text2 = (TextView) findViewById(R.id.textView_id2);   //宣告textView_id1到text2變數
        text3 = (TextView) findViewById(R.id.textView_id3);   //宣告textView_id1到text3變數

        text1.setText("");                                 //text1框初始文字
        text2.setText("");                                 //text2框初始文字
        text3.setText("");                                 //text3框初始文字

        imageButton1 = (ImageButton) findViewById(R.id.imageButton_id1);  //宣告imageButton指向ID
        imageButton2 = (ImageButton) findViewById(R.id.imageButton_id2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton_id3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton_id4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton_id5);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton_id6);

        button1.setOnClickListener(new View.OnClickListener() {  //button1 動作第1種寫法
            @Override
            public void onClick(View v) {     //button動作第1種寫法
                text2.setText("");
                text3.setText("");
                text1.setTextSize(24);              //改變字大小
                text1.setText("Button 1 is pressed .");  //顯示文字
            }
        });     //button1 動作第1種寫法 end

        //button動作用法2,用CASE:
        buttonClick = new myButtonClass();   //會顯示紅字 create inner class 內部使用class在下方
        button2.setOnClickListener( buttonClick);  //會顯示紅字 create inner class 內部使用class
        button3.setOnClickListener(buttonClick);

        imageButton1.setOnClickListener(new myImageClass());
        imageButton2.setOnClickListener(new myImageClass());
        imageButton3.setOnClickListener(new myImageClass());
        imageButton4.setOnClickListener(new myImageClass());
        imageButton5.setOnClickListener(new myImageClass());
        imageButton6.setOnClickListener(new myImageClass());
    }   // end of oncreate()

    private class myButtonClass implements View.OnClickListener {  //button2,3 動作第2種寫法因還沒使用方法會有紅字
        //要用implement method 會產生下面public void onClick(View v) {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.button_id2:
                    text1.setText("");
                    text3.setText("");
                    text2.setText("Button 2 is pressed."); //顯示文字
                    break;

                case R.id.button_id3:
                    text1.setText("");
                    text2.setText("");
                    text3.setTextSize(36);  //改變字大小
                    text3.setText("Button 3 is pressed."); //顯示文字
                    break;
            }
        }
    }

    private class myImageClass implements View.OnClickListener {   //會顯示紅字,Implement methods會顯示下面onClick
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.imageButton_id1:
                    Toast.makeText(context, "Image button 1.", Toast.LENGTH_SHORT).show(); //notifyMessage 螢幕下方顯示訊息
                    break;
                case R.id.imageButton_id2:
                    Toast.makeText(context, "Image button 2.", Toast.LENGTH_SHORT).show();
                case R.id.imageButton_id3:
                    Toast.makeText(context, "Image button 3.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imageButton_id4:
                    Toast.makeText(context, "Image button 4.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imageButton_id5:
                    Toast.makeText(context, "Image button 5.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imageButton_id6:
                    Toast.makeText(context, "Image button 6.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
