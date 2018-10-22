package com.jj.widget5app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText nameEdit ,dateEdit,inputEdit;
    private TextView textViewResult;
    private Button okButton,cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //001-元件宣告區start
        nameEdit = (EditText) findViewById(R.id.editText_name);  //宣告文字輸入框EditText指向ID
        dateEdit = (EditText) findViewById(R.id.editText_date);   //宣告文字輸入框EditText指向ID
        inputEdit = (EditText) findViewById(R.id.editText_input); //宣告文字輸入框EditText指向ID
        textViewResult = (TextView) findViewById(R.id.textView_result); //下方說明宣告TextView指向ID
        textViewResult.setText("");                                  //文字更改成空白

        okButton = (Button) findViewById(R.id.button_ok);           //宣告Button指向ID
        cancelButton = (Button) findViewById(R.id.button_cancel);     //宣告Button指向ID

        //001-元件宣告區end

        //002-OK,CANCEL,Button 監聽動作區start
        okButton.setOnClickListener(new myButtonClick()); //Button 按下監聽宣告,myButtonClick可以自行定義名稱
        cancelButton.setOnClickListener(new myButtonClick()); //Button 按下監聽宣告,myButtonClick可以自行定義名稱
    }
    //002-OK,CANCEL,Button 監聽動作區end

    //003- OK,Cancel 按下動作監聽start
    private class myButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_ok:                                    //如果按下 OK
                    String name = nameEdit.getText().toString();      //取值轉String
                    String date = dateEdit.getText().toString();      //取值轉String
                    String content = inputEdit.getText().toString();  //取值轉String

                    textViewResult.setText("");              //先把下方說明框清空
                    textViewResult.append(content+ "\n\n");  //顯示輸入內容
                    textViewResult.append(name+ "\n");       //顯示輸入內容
                    textViewResult.append(date);             //顯示輸入內容

                    break;

                case R.id.button_cancel:             //如果按下 Cancel
                    nameEdit.setText("");         //清空上方輸入框內容
                    dateEdit.setText("");         //清空上方輸入框內容
                    inputEdit.setText("");        //清空上方輸入框內容
                    textViewResult.setText("");   //清空下方說明框內容

                    break;

            }
        }
    }
    //006- OK,Cancel 按下動作start,end
}   //main end
