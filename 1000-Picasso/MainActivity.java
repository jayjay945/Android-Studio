package com.jj.picasso;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        //001.元件宣告-start
        ImageView imageView = findViewById(R.id.image_view);
        //001.元件宣告-end
        Picasso.with(context).load("http://i.imgur.com/XY1856Y.png").into(imageView);  // 讀取圖片放到imageView

    }
}

//        Picasso.with(this)
//                .load("http://i.imgur.com/XY1856Y.png") // 圖片路徑
//                .placeholder(R.mipmap.ic_launcher)  // 圖片讀取完成之前先顯示的佔位圖
//                .error(R.mipmap.ic_launcher)        // 圖片讀取失敗時要顯示的錯誤圖
//                .resize(200, 200)   // 將圖片寬高轉為200*200 pixel
//                .centerInside()     // 與resize搭配使用，將調整過的圖片完整塞進ImageView中
//                .fit()              // 與resize只能擇一使用，將圖片寬高轉為ImageView的大小
//                .rotate(90)         // 將圖片旋轉90度
//                .into(image_view);  // 要顯示圖的View

/////////////////////////////如果要監聽//////////////////
/*Picasso.with(this)
        .load("http://i.imgur.com/XY1856Y.png")  // 圖片路徑
        .into(image_view, new Callback() {
@Override
public void onSuccess() {
        // 圖片讀取完成
        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
        }

@Override
public void onError() {
        // 圖片讀取失敗
        }
        });
        */
