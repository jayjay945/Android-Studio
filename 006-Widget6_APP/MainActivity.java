package com.jj.widget6app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText idEdit, nameEdit;
    private TextView textViewResult;
    private RadioGroup radioGroup;
    private boolean maleFlag , femaleFlag;
    private CheckBox checkSport,  checkReading,checkPainting;
    private boolean sportFlag,readingFlag,paintingFlag;
    private Button okButton , cancelButton;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        //001-元件宣告區-start
        idEdit = (EditText) findViewById(R.id.editText_id);
        nameEdit = (EditText) findViewById(R.id.editText_name);
        textViewResult = (TextView) findViewById(R.id.textView_result);
        textViewResult.setText("");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_id);

        //001-元件宣告區end

        //002-radioGroup多選1-按鍵動作監聽-start
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch ( checkedId){
                    case R.id.radioButton_male:
                        maleFlag = true;      //按下male按鈕產生一個FLAG
                        femaleFlag = false;
                        break;

                    case R.id.radioButton_female:
                        maleFlag = false;      //按下female按鈕產生一個FLAG
                        femaleFlag = true;
                        break;
                }
            }
        });
        //002-radioGroup多選1-按鍵動作監聽-end


        //003-CheckBox打勾多選框-start
        //003-1-CheckBox打勾多選框元件宣告區-start
        checkSport = (CheckBox) findViewById(R.id.checkBox_sport);
        checkReading = (CheckBox) findViewById(R.id.checkBox_reading);
        checkPainting = (CheckBox) findViewById(R.id.checkBox_painting);
        //003-1-CheckBox打勾多選框元件宣告區-end

        //003-2-CheckBox打勾多選框按鍵監聽區-start
        checkSport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sportFlag = isChecked;  //按一下打勾=true,在按一下沒打勾=false
                Toast.makeText(context , "sportFlag="+sportFlag,Toast.LENGTH_SHORT).show();//測試打勾多選框true,false
            }
        });

        checkReading.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                readingFlag = isChecked; //按一下打勾=true,在按一下沒打勾=false
                Toast.makeText(context , "readingFlag="+readingFlag,Toast.LENGTH_SHORT).show();//測試打勾多選框true,false
            }
        });

        checkPainting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                paintingFlag = isChecked; //按一下打勾=true,在按一下沒打勾=false
                Toast.makeText(context , "paintingFlag="+paintingFlag,Toast.LENGTH_SHORT).show();//測試打勾多選框true,false
            }
        });
        //003-2-CheckBox打勾多選框按鍵監聽區-end
        //003-check打勾多選框-end


        //004-ok,cancel按鍵區-start
        //004-1-元件宣告id-start
        okButton = (Button) findViewById(R.id.button_ok);
        cancelButton = (Button) findViewById(R.id.button_cancel);
        //004-1-元件宣告id-end

        //004-2 按鍵宣告-start
        okButton.setOnClickListener(new myButtonClick());
        cancelButton.setOnClickListener(new myButtonClick());
        //004-2 按鍵宣告-end
    }
        //004-4-3按鍵監聽-start
    private class myButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
         switch (v.getId()){
             case R.id.button_cancel:
                 checkSport.setChecked(false);     //打勾框清成不打勾
                 checkReading.setChecked(false);   //打勾框清成不打勾
                 checkPainting.setChecked(false);  //打勾框清成不打勾
                 radioGroup.clearCheck();          //多選1框清成初始都沒點
                 maleFlag=false;                   //多選1框都沒點所以false
                 femaleFlag=false;                 //多選1框都沒點所以false
                 idEdit.setText("");               //輸入框清空
                 nameEdit.setText("");             //輸入框清空
                 textViewResult.setText("");       //下方說明框清空

                 break;

             case R.id.button_ok:
                 textViewResult.setText("");    //下方說明框清空
                 if(idEdit.length() ==0 || nameEdit.length() ==0){  //如果二個輸入框長度都是0
                 Toast.makeText(context, "Please input ID and name.",Toast.LENGTH_SHORT).show();//請輸入
             }else{

                     String result = "ID : " + idEdit.getText().toString() + "\n" + "Name :" + nameEdit.getText() + "\n";//result=取二個輸入框改String
                     textViewResult.append(result);  //顯示ID:888換行Name:XXX

                     if(maleFlag){    //如果多選1選在male
                         textViewResult.append("Gender : male");  //加上這行文字
                     } else if(femaleFlag){ //如果多選1選在female
                         textViewResult.append("Gender : female");  //加上這行文字
                     }else{
                         Toast.makeText(context , "Please select the gender.",Toast.LENGTH_SHORT).show();
                     }

                    textViewResult.append("\n\nHobby : ");  //加上這行文字,空二行Hobby

                     if(sportFlag)                   //如果多選有打勾
                         textViewResult.append("Sport"); //加上這行文字
                     if(readingFlag)                  //如果多選有打勾
                         textViewResult.append("Reading"); //加上這行文字
                     if(paintingFlag)                  //如果多選有打勾

                         textViewResult.append("Painting"); //加上這行文字


                 }
                 break;

         }
        }
    }
}   //main end
