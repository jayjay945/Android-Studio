package com.example.yvtc.intentbasic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainCouseActivity extends Activity {

    private TextView mealA, mealB;
    private TextView textViewResult;
    private RadioGroup radioGroup;
    private RadioButton radioA, radioB;
    private boolean mealAFlag , mealBFlag;
    private CheckBox checkCola , checkSaladA, checkFrenchfries, checkApplepie;
    private CheckBox checkSoup, checkSaladB, checkIceCream, checkChicken;
    private boolean colaFlag, saladAFlag, frenchfriesFlag, applePieFlag;
    private boolean soupFlag, saladBFlag, iceCreamFlag, chickenFlag;
    private Button okButton, cancelButton;

    private static final int ReturnData = 1;
    private static final int ReturnError = 2;
    private final String Tag="main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_couse);

        //001-元件宣告區start
        mealA = (TextView) findViewById(R.id.textView_mealA);
        mealB = (TextView) findViewById(R.id.textView_mealB);
        mealA.setText("漢堡餐");
        mealB.setText("炸雞餐");

        textViewResult = (TextView) findViewById(R.id.textView4_id);
        textViewResult.setText("");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_id);
        radioA = (RadioButton) findViewById(R.id.radioButton_A);
        radioB = (RadioButton) findViewById(R.id.radioButton_B);

        mealAFlag = false;
        mealBFlag = false;

        radioGroup.setOnCheckedChangeListener(new CheckedRadioChange());

        checkCola = (CheckBox) findViewById(R.id.checkBox_Cola);
        checkSaladA = (CheckBox) findViewById(R.id.checkBox_saladA);
        checkFrenchfries = (CheckBox) findViewById(R.id.checkBox_french);
        checkApplepie =  (CheckBox) findViewById(R.id.checkBox_apple);

        checkSoup = (CheckBox) findViewById(R.id.checkBox_soup);
        checkSaladB = (CheckBox) findViewById(R.id.checkBox_saladB);
        checkIceCream = (CheckBox) findViewById(R.id.checkBox_iceCream);
        checkChicken = (CheckBox) findViewById(R.id.checkBox_chicken);
        //001-元件宣告區end


        //002-Meal A多選打勾框checkBox按下動作監控區start
        checkCola.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealAFlag){             //如果在Meal A
                    colaFlag = isChecked;  //按一下打勾=true,在按一下沒打勾=false
                } else {
                    checkCola.setChecked(false); //如果不在Meal A按下才會跑這段
                    colaFlag = false;
                }
            }
        });

        checkSaladA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealAFlag){
                    saladAFlag = isChecked;
                } else {
                    checkSaladA.setChecked(false);
                    saladAFlag = false;
                }
            }
        });

        checkFrenchfries.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealAFlag){
                    frenchfriesFlag = isChecked;
                } else {
                    checkFrenchfries.setChecked(false);
                    frenchfriesFlag = false;
                }
            }
        });

        checkApplepie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealAFlag){
                    applePieFlag = isChecked;
                } else {
                    checkApplepie.setChecked(false);
                    applePieFlag = false;
                }
            }
        });

        checkSoup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealBFlag){
                    soupFlag = isChecked;
                } else {
                    checkSoup.setChecked(false);
                    soupFlag = false;
                }
            }
        });

        checkSaladB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealBFlag){
                    saladBFlag = isChecked;
                } else {
                    checkSaladB.setChecked(false);
                    saladBFlag = false;
                }
            }
        });

        checkIceCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealBFlag){
                    iceCreamFlag = isChecked;
                } else {
                    checkIceCream.setChecked(false);
                    iceCreamFlag = false;
                }
            }
        });

        checkChicken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealBFlag){
                    chickenFlag = isChecked;
                } else {
                    checkChicken.setChecked(false);
                    chickenFlag = false;
                }
            }
        });

        //003-Meal B多選打勾框checkBox按下動作監控區end


        //004-OK,CANCEL,Button 元件宣告及動作區start
        okButton = (Button) findViewById(R.id.button_ok);
        cancelButton = (Button) findViewById(R.id.button_cancel);

        okButton.setOnClickListener( new ButtonClick());
        cancelButton.setOnClickListener(new ButtonClick());
        //004-OK,CANCEL,Button 元件宣告區end
    } // end of onCreate()

    //005-多選1 RadioButton 按在Meal A或Meal B 按下監聽start
    private class CheckedRadioChange implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId){

                case R.id.radioButton_A:  //如果按在Meal A
                    mealAFlag = true;
                    mealBFlag = false;

                    checkSoup.setChecked(false);     //如果Meal B有打勾,清掉Meal B的Checkbox打勾選項框1
                    checkSaladB.setChecked(false);   //如果Meal B有打勾,清掉Meal B的Checkbox打勾選項框2
                    checkIceCream.setChecked(false); //如果Meal B有打勾,清掉Meal B的Checkbox打勾選項框3
                    checkChicken.setChecked(false);  //如果Meal B有打勾,清掉Meal B的Checkbox打勾選項框4
                    break;

                case R.id.radioButton_B: //如果按在Meal B
                    mealAFlag = false;
                    mealBFlag = true;

                    checkCola.setChecked(false);  //如果Meal A有打勾,清掉Meal A的Checkbox打勾選項框1
                    checkSaladA.setChecked(false);
                    checkFrenchfries.setChecked(false);
                    checkApplepie.setChecked(false);
                    break;

            }

        }
    }
    //005-多選1 RadioButton 按在Meal A或Meal B 按下監聽end


    //006- OK,Cancel 按下動作start
    private class ButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            switch ( v.getId()){

                case R.id.button_ok:   //如果按下 OK
                    int orderSum = 0;  //宣告計算價錢清為0
                    if(mealAFlag){     //如果按在Meal A mealAFlag=true

                        textViewResult.setText("Your order is Hamburger set :\n"); //標題顯示文字

                        if(colaFlag){      //如果ColaFlag=true 有打勾
                            textViewResult.append("Cola drink, "); //下方說明增加文字
                            orderSum += 50;                         //價錢++
                        }

                        if(saladAFlag) {
                            textViewResult.append("Salad A, ");
                            orderSum +=100;
                        }

                        if(frenchfriesFlag) {
                            textViewResult.append("French fries, ");
                            orderSum += 60;
                        }

                        if(applePieFlag) {
                            textViewResult.append("Apple pie.");
                            orderSum +=80;
                        }

                        textViewResult.append("\n\nThe total payment is : "+orderSum);  //顯示總共的價錢

                    } else if(mealBFlag){  //如果按在Meal B mealBFlag=true

                        textViewResult.setText("Your order is Fried chicken set : \n"); //標題顯示文字

                        if(soupFlag) {
                            textViewResult.append("Soup, ");
                            orderSum += 80;
                        }

                        if(saladBFlag) {
                            textViewResult.append("Salad B, ");
                            orderSum+=100;
                        }

                        if(iceCreamFlag) {
                            textViewResult.append("Ice Cream, ");
                            orderSum +=90;
                        }

                        if(chickenFlag) {
                            textViewResult.append("Chicken nugget.");
                            orderSum +=70;
                        }

                        textViewResult.append("\n\nThe total payment is : "+orderSum); //顯示總共的價錢

                    }

                    Intent intent = new Intent(); //宣告要回傳值的指令
                    String txtResult = textViewResult.getText().toString();//宣告txtResult 取上方結果textViewResult值轉換成String
                    intent.putExtra("order_list",txtResult);//intent.putExtra送資料到暫存("ID",放上方txtResult的資料)
                    Log.d(Tag,"order_list"+txtResult);
                    Log.d(Tag,"returnData = "+ReturnData);
                    setResult(ReturnData,intent);//送資料setResult(回主頁要按使用的ID,上方intent資料)
                    break;

                case R.id.button_cancel:    //如果按下 Cancel

                    textViewResult.setText(""); //清掉下方說明
                    radioA.setChecked(true);  //多選1框Radio button 按到Meal A
                    radioB.setChecked(false); //多選1框Radio button 清掉Meal B
                    mealAFlag = true;
                    mealBFlag = false;

                    checkCola.setChecked(false);    //Check Box 打勾框清掉(如果有打勾)
                    colaFlag = false;

                    checkSaladA.setChecked(false);
                    saladAFlag = false;

                    checkFrenchfries.setChecked(false);
                    frenchfriesFlag = false;

                    checkApplepie.setChecked(false);
                    applePieFlag = false;

                    checkSoup.setChecked(false);
                    soupFlag = false;

                    checkSaladB.setChecked(false);
                    saladBFlag = false;

                    checkIceCream.setChecked(false);
                    iceCreamFlag = false;

                    checkChicken.setChecked(false);
                    chickenFlag = false;

                    Intent intentError = new Intent(); //宣告要回傳值的指令
                    setResult(ReturnError,intentError);  //送資料setResult(回主頁要按使用的ID,上方intenError資料)

                    break;

            }

        }
    }
    //006-OK,Cancel 按下動作end
}//main end
