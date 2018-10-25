package com.example.yvtc.intentbasic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int IntentRequestCode = 2;
    private static final int ReturnData = 1;
    private static final int ReturnError = 2;
    private static final String TAG = "menu";
    private Context context;
    private ImageButton drinkButton, mainButton;
    private Intent intent;
    private TextView orderResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;  //Intent,Toast專用

        //001-元件宣告區-start
        drinkButton = (ImageButton) findViewById(R.id.imageButton_drink);
        mainButton = (ImageButton) findViewById(R.id.imageButton_main);

        orderResult = (TextView) findViewById(R.id.textView_list);
        orderResult.setTextSize(20);
        orderResult.setTextColor(0xff008080);
        orderResult.setText("");
        //001-元件宣告區end

        //002-drink按鍵監聽區-start
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"order drink",Toast.LENGTH_SHORT).show();
                intent = new Intent(context, DrinkActivity.class); //宣告intent要去的頁面(context,要去的頁面.class)
                startActivity(intent);   //執行要去的頁面指令不回傳值
            }
        });
        //002-drink按鍵監聽區-end

        //003-couse按鍵監聽區-start
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, MainCouseActivity.class); //宣告要去的頁面
                startActivityForResult(intent, IntentRequestCode);  //回傳值的方法執行要去的頁面(上方intent,去回requestCode的ID)
            }
        });
        //003-couse按鍵監聽區-end

    } // end of onCreate()

    //004-intent couse頁面回傳值監聽區-start
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//(上方IntentRequestCode,,去的couse頁面回傳的值)
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IntentRequestCode){  //上方startActivityForResult(要去的頁面, IntentRequestCode);如果是那頁面回傳的值
            switch (resultCode){
                case ReturnData: //上方定義constant int 去的couse頁面按OK回傳值
                    String result = data.getStringExtra("order_list");//取去的couse頁面傳回的值("ID")
                    Log.d(TAG,"order_result = "+result);
                    orderResult.setText(result);  //顯示在下方說明(上方result的值)
                    break;

                case ReturnError: //上方定義constant int 去的couse頁面按Cancel回傳值
                    orderResult.setText("Please order meal !");
                    break;

                default:     //Maincouse,OK,Cancel都沒有按
                    Toast.makeText(context,"You did not order meal.",Toast.LENGTH_SHORT).show();
                    break;


            }   //end of switch
        }       // end of if
    }           //004-intent couse頁面回傳值監聽區-end

}//main end
