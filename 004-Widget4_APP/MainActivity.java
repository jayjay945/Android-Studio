package com.jj.widget4app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView mealA, mealB;
    private TextView textViewResult;
    private RadioGroup radioGroup;
    private RadioButton radioA, radioB;
    private boolean mealAFlag, mealBFlag;
    private CheckBox checkCola, checkSaladA, checkFrenchfires, checkApplePie;
    private CheckBox checkSoup, checkSaladB, checkIceCream, checkChicken;
    private boolean ColaFlag, SaladAFlag, FrenchFiresFlag, ApplePieFlag;
    private boolean SoupFlag, SaladBFlag, IceCreamFlag, ChickenFlag;
    private Button okButton, cancelButton;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //001-元件宣告區start
        context = this ; //如果要用notifyMessage 螢幕下方顯示訊息 context可以自行定義,紅字要Create field到MainActivity

        mealA = (TextView) findViewById(R.id.textView_mealA); //mealA宣告TextView指向ID
        mealB = (TextView) findViewById(R.id.textView_mealB); //mealB宣告TextView指向ID
        mealA.setText("漢堡餐");                             //mealA文字更改
        mealB.setText("炸雞餐");                             //mealB文字更改

        textViewResult = (TextView) findViewById(R.id.textView4_id); //下方說明宣告TextView指向ID
        textViewResult.setText("");                                //文字更改成空白

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_id); //多選1框架宣告RadioGroup指向ID
        radioA = (RadioButton) findViewById(R.id.radioButton_A);   //Meal A多選1按鈕宣告RadioButton指向ID
        radioB = (RadioButton) findViewById(R.id.radioButton_B);   //Meal B多選1按鈕宣告RadioButton指向ID

        mealAFlag = false;              //多選1宣告mealA Flag旗標上方要宣告boolean,用來監聽按在Meal A或MealB
        mealBFlag = false;              //多選1宣告mealB Flag旗標上方要宣告boolean,用來監聽按在Meal A或MealB

        radioGroup.setOnCheckedChangeListener(new CheckedRadioChange()); //Meal A,Meal B多選1框架按下監聽宣告

        checkCola = (CheckBox) findViewById(R.id.checkBox_Cola);  //MealA多選打勾框宣告checkBox指向ID
        checkSaladA = (CheckBox) findViewById(R.id.checkBox_salada); //MealA多選打勾框宣告checkBox指向ID
        checkFrenchfires = (CheckBox) findViewById(R.id.checkBox_french); //MealA多選打勾框宣告checkBox指向ID
        checkApplePie = (CheckBox) findViewById(R.id.checkBox_apple); //MealA多選打勾框宣告checkBox指向ID

        checkSoup = (CheckBox) findViewById(R.id.checkBox_soup); //MealB多選打勾框宣告checkBox指向ID
        checkSaladB = (CheckBox) findViewById(R.id.checkBox_saladb); //MealB多選打勾框宣告checkBox指向ID
        checkIceCream = (CheckBox) findViewById(R.id.checkBox_iceCream); //MealB多選打勾框宣告checkBox指向ID
        checkChicken = (CheckBox) findViewById(R.id.checkBox_chicken); //MealB多選打勾框宣告checkBox指向ID
        //001-元件宣告區end


        //002-Meal A多選打勾框checkBox按下動作監控區start
        checkCola.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mealAFlag){            //如果在Meal A
                    ColaFlag = isChecked;  //ColaFlag上方要宣告boolean 動作還不太確定,按一下true,在按一下變false
                    Toast.makeText(context, "己按下COLA", Toast.LENGTH_SHORT).show(); //notifyMessage 螢幕下方顯示訊息
                }else {
                    checkCola.setChecked(false);  //如果不在Meal A按下才會跑這段
                    ColaFlag = false;
                    Toast.makeText(context, "沒按COLA", Toast.LENGTH_SHORT).show(); //notifyMessage 螢幕下方顯示訊息
                }  //else end
            }
        });

        checkSaladA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mealAFlag){
                    SaladAFlag = isChecked;
                    Toast.makeText(context, "己按下SALADA", Toast.LENGTH_SHORT).show(); //notifyMessage 螢幕下方顯示訊息
                }else {
                    checkSaladA.setChecked(false);
                    SaladAFlag = false;
                    Toast.makeText(context, "沒按SALADA", Toast.LENGTH_SHORT).show(); //notifyMessage 螢幕下方顯示訊息

                }
            }
        });

        checkFrenchfires.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mealAFlag){
                    FrenchFiresFlag = isChecked;
                }else {
                    checkFrenchfires.setChecked(false);
                    FrenchFiresFlag = false;
                }
            }
        });

        checkApplePie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mealAFlag){
                    ApplePieFlag = isChecked;
                }else {
                    checkApplePie.setChecked(false);
                    ApplePieFlag = false;
                }
            }
        });

        //002-Meal A多選打勾框checkBox按下動作監控區end

        //003-Meal B多選打勾框checkBox按下動作監控區start

        checkSoup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mealBFlag){
                    SoupFlag = isChecked;
                }else {
                    checkSoup.setChecked(false);
                    SoupFlag = false;
                }
            }
        });

        checkSaladB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mealBFlag){
                    SaladBFlag = isChecked;
                }else {
                    checkSaladB.setChecked(false);
                    SaladBFlag = false;
                }
            }
        });

        checkIceCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mealBFlag){
                    IceCreamFlag = isChecked;
                }else {
                    checkIceCream.setChecked(false);
                    IceCreamFlag = false;
                }
            }
        });

        checkChicken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mealBFlag){
                    ChickenFlag = isChecked;
                }else {
                    checkChicken.setChecked(false);
                    ChickenFlag = false;
                }
            }
        });

        //003-Meal B多選打勾框checkBox按下動作監控區end

        //004-OK,CANCEL,Button 元件宣告及動作區start
        okButton = (Button) findViewById(R.id.button_ok);
        cancelButton = (Button) findViewById(R.id.button_cancel);

        okButton.setOnClickListener(new ButtonClick()); //Button 按下監聽宣告,ButtonClick可以自行定義名稱
        cancelButton.setOnClickListener(new ButtonClick()); //Button 按下監聽宣告,ButtonClick可以自行定義名稱
        //004-OK,CANCEL,Button 元件宣告區end

    }   // end of onCreate()


    //005-多選1 RadioButton 按在Meal A或Meal B 按下監聽start
    private class CheckedRadioChange implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId){

                case R.id.radioButton_A:    //如果按在Meal A
                    Toast.makeText(context, "點到RadioButton Meal A", Toast.LENGTH_SHORT).show(); //notifyMessage 螢幕下方顯示訊息
                    mealAFlag = true;
                    mealBFlag = false;

                    checkSoup.setChecked(false);  //如果Meal B有打勾,清掉Meal B的Checkbox打勾選項框1
                    checkSaladB.setChecked(false);//如果Meal B有打勾,清掉Meal B的Checkbox打勾選項框2
                    checkIceCream.setChecked(false);//如果Meal B有打勾,清掉Meal B的Checkbox打勾選項框3
                    checkChicken.setChecked(false);//如果Meal B有打勾,清掉Meal B的Checkbox打勾選項框4

                    break;

                case R.id.radioButton_B:  //如果按在Meal B
                    Toast.makeText(context, "點到RadioButton Meal B", Toast.LENGTH_SHORT).show(); //notifyMessage 螢幕下方顯示訊息
                    mealAFlag = false;
                    mealBFlag = true;

                    checkCola.setChecked(false);        //如果Meal A有打勾,清掉Meal A的Checkbox打勾選項框1
                    checkSaladA.setChecked(false);      //如果Meal A有打勾,清掉Meal A的Checkbox打勾選項框2
                    checkApplePie.setChecked(false);    //如果Meal A有打勾,清掉Meal A的Checkbox打勾選項框3
                    checkFrenchfires.setChecked(false); //如果Meal A有打勾,清掉Meal A的Checkbox打勾選項框4
                    break;
            }
        }
    }

    //005-多選1 RadioButton 按在Meal A或Meal B 按下監聽end


    //006- OK,Cancel 按下動作start
    private class ButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v){

            switch (v.getId()){

                case R.id.button_ok:    //如果按下 OK
                    int orderSum = 0  ;     //宣告計算價錢清為0
                    if (mealAFlag) {       //如果按在Meal A mealAFlag=true
                        textViewResult.setText("your order is Hamburger set :\n");  //標題顯示文字
                        if(ColaFlag){       //如果ColaFlag=true 有打勾
                            textViewResult.append("Cola drink, "); //下方說明增加文字
                            orderSum+=30;                          //價錢++
                        }
                        if(SaladAFlag){    //如果SaladAFlag=true 有打勾
                            textViewResult.append("Salad A, "); //下方說明增加文字
                            orderSum+=40;                         //價錢++
                        }
                        if(ApplePieFlag){
                            textViewResult.append("Apple Pie, ");
                            orderSum+=30;
                        }
                        if(FrenchFiresFlag){
                            textViewResult.append("French Fires");
                            orderSum+=40;
                        }
                        textViewResult.append("\n\nThe total payment is: " + orderSum);  //顯示總共的價錢
                    }else if(mealBFlag){   //如果按在Meal B mealBFlag=true
                        textViewResult.setText("your order is Fried Chicken set :\n"); //標題顯示文字
                        if (SoupFlag){
                            textViewResult.append("Soup, ");
                            orderSum+=30;
                        }
                        if (SaladBFlag){
                            textViewResult.append("Salad B, ");
                            orderSum+=40;
                        }
                        if (IceCreamFlag){
                            textViewResult.append("Ice Cream,");
                            orderSum+=20;
                        }
                        if (ChickenFlag){
                            textViewResult.append("Chicken Nugget");
                            orderSum+=30;

                        }
                        textViewResult.append("\n\nThe total payment is: " + orderSum); //顯示總共的價錢
                    }
                    break;

                case R.id.button_cancel:     //如果按下 Cancel

                    textViewResult.setText("");     //清掉下方說明
                    radioA.setChecked(true);        //多選1框Radio button 按到Meal A
                    radioB.setChecked(false);       //多選1框Radio button 清掉Meal B
                    mealAFlag = true;
                    mealBFlag = false;

                    checkCola.setChecked(false);    //Check Box 打勾框清掉(如果有打勾)
                    ColaFlag = false;

                    checkSaladA.setChecked(false); //Check Box 打勾框清掉(如果有打勾)
                    SaladAFlag = false;

                    checkApplePie.setChecked(false); //Check Box 打勾框清掉(如果有打勾)
                    ApplePieFlag = false;

                    checkFrenchfires.setChecked(false); //Check Box 打勾框清掉(如果有打勾)
                    FrenchFiresFlag = false;

                    checkSoup.setChecked(false); //Check Box 打勾框清掉(如果有打勾)
                    SoupFlag = false;

                    checkSaladB.setChecked(false); //Check Box 打勾框清掉(如果有打勾)
                    SaladBFlag = false;

                    checkIceCream.setChecked(false); //Check Box 打勾框清掉(如果有打勾)
                    IceCreamFlag = false;

                    checkChicken.setChecked(false); //Check Box 打勾框清掉(如果有打勾)
                    ChickenFlag = false;

                    break;
            }
        }
    }
    //006-OK,Cancel 按下動作end


}  //main end
