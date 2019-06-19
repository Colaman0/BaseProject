package com.lsj.colaman.quickproject.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.lsj.colaman.quickproject.R;

import androidx.annotation.Nullable;

/**
 * Create by kyle on 2019/3/10
 * Function :
 */
public class TouchView extends View {
    private Bitmap mBitmap;
    private Paint mPaint;
    private Matrix mMatrix;

    private Point mLeftTop;
    private Point mRightTop;
    private Point mLeftBottom;
    private Point mRightBottom;

    public TouchView(Context context) {
        this(context, null);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((getWidth() - getBitmap().getWidth()) >> 1, (getHeight() - getBitmap().getHeight()) >> 1);
        canvas.drawBitmap(getBitmap(), setBitmapMatrix(), mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    private Bitmap getBitmap() {
        if (mBitmap == null) {
            mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        }
        return mBitmap;
    }

    private Matrix setBitmapMatrix(int leftTop, int rightTop, int leftBottom, int rightBottom) {
        mMatrix = new Matrix();
        int width = getBitmap().getWidth();
        int height = getBitmap().getHeight();
        float[] src = {0, 0, 0, height, width, height, width, 0};
        float[] dst = {mLeftTop, 0, 0, height, width, height, width - DX, 0};
        mMatrix.setPolyToPoly(src, 0, dst, 0, 4);
        return mMatrix;
    }
}
