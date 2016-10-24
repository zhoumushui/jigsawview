package com.az.jigsawview;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    /**
     * 利用二维数组创建若干个拼图方块
     */
    private ImageView[][] imageJigsaw;

    private GridLayout gridJigsaw;

    private static final int NUM_X = 4;
    private static final int NUM_Y = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initialLayout() {
        gridJigsaw = (GridLayout) findViewById(R.id.gridJigsaw);

        imageJigsaw = new ImageView[NUM_X][NUM_Y];

        // 拼图全图
        Bitmap bitmapWhole = ((BitmapDrawable) getResources().getDrawable(R.drawable.golden)).getBitmap();
        int widthLittle = bitmapWhole.getWidth() / NUM_X;
        int heightLittle = bitmapWhole.getHeight() / NUM_Y;
        for (int i = 0; i < NUM_X; i++) {
            for (int j = 0; j < NUM_Y; j++) {
                // 根据行列切割成小格子
                Bitmap bitmapLittle = Bitmap.createBitmap(bitmapWhole,
                        j * widthLittle, i * heightLittle, widthLittle, heightLittle);

                imageJigsaw[i][j] = new ImageView(this);
                imageJigsaw[i][j].setImageBitmap(bitmapLittle);
                imageJigsaw[i][j].setPadding(2, 2, 2, 2); // 设置格子间距

                gridJigsaw.addView(imageJigsaw[i][j]);
            }
        }


    }
}
