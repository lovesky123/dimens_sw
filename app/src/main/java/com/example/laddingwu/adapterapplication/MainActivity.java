package com.example.laddingwu.adapterapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * https://github.com/ladingwu/dimens_sw
 * 使用方法
 * 1.clone该项目到本地,以Android项目打开。
 * 2.DimenTypes文件中写入你希望适配的sw尺寸，默认的这些尺寸能够覆盖几乎所有手机适配需求
 * 3.DimenGenerator文件中填写设计稿的尺寸(DESIGN_WIDTH是设计稿宽度，DESIGN_HEIGHT是设计稿高度)
 * 4.执行lib module中的DimenGenerator.main()方法，当前地址下会生成相应的适配文件,把相应的文件连带文件夹拷贝到正在开发的项目中
 */
public class MainActivity extends AppCompatActivity {
    TextView tv2, tv1, tv3, tv4;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        view = findViewById(R.id.view_show);

        tv1.postDelayed(new Runnable() {
            @Override
            public void run() {
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                int width = Math.min(dm.widthPixels, dm.heightPixels);
                tv1.setText("dpi : " + dm.densityDpi + "   smallest width pixels : " + width);
                tv2.setText("计算出来的smallestWidth : " + width / (dm.densityDpi / 160.0) + "dp");
                tv3.setText("实际使用的smallestWidth :  " + getResources().getString(R.string.base_dpi));
                tv4.setText("当前手机： " + SystemUtil.getDeviceBrand() + "  " + SystemUtil.getSystemModel() + " \n" + "当前系统： " + SystemUtil.getSystemVersion() + " ");
                LinearLayout.LayoutParams p = (LinearLayout.LayoutParams) view.getLayoutParams();
                p.width = getResources().getDimensionPixelSize(R.dimen.qb_px_375);
                view.setLayoutParams(p);
            }
        }, 500);
    }
}
