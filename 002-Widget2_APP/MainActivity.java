package com.jj.widget2_app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "APP2" ;
    private Button button1,button2,button3;
    private ImageView pictureView;
    private TextView pictureText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate() stage");   //Log要import 上方class //   TAG為變數

        button1 = (Button) findViewById(R.id.button1_id);  //宣告button指向ID
        button2 = (Button) findViewById(R.id.button2_id);  //宣告button指向ID
        button3 = (Button) findViewById(R.id.button3_id);  //宣告button指向ID

        pictureView = (ImageView) findViewById(R.id.imageView); //宣告ImageView指向ID
        pictureText = (TextView) findViewById(R.id.textView4);   //宣告TextView指向ID
        pictureText.setText(" ");          //初始顯示設為空白

        button1.setOnClickListener(new View.OnClickListener() {  //button動作控制用法2
            @Override
            public void onClick(View v) {      //按鈕1動作
                pictureView.setImageResource(R.drawable.line1); //顯示圖片
                pictureText.setText("this is picture 1.\n it is line bear.\n"); //顯示文字
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { //button動作控制用法2
            @Override
            public void onClick(View v) {      //按鈕2動作
                pictureView.setImageResource(R.drawable.line2); //顯示圖片
                pictureText.setText("this is picture 2.\n it is line bear.\n"); //顯示文字
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { //button動作控制用法2
            @Override
            public void onClick(View v) {      //按鈕3動作
                pictureView.setImageResource(R.drawable.line3); //顯示圖片
                pictureText.setText("this is picture 3.\n it is line bear.\n"); //顯示文字
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart() stage.");  //Log要import 上方clas //   TAG為變數
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() stage.");//Log要import 上方clas //   TAG為變數
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() stage.");  //LOG要import 上方clas //   TAG為變數
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause() stage."); //LOG要import 上方clas //   TAG為變數
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() stage."); //LOG要import 上方clas //   TAG為變數
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart() stage."); //LOG要import 上方clas //   TAG為變數
    }
}
