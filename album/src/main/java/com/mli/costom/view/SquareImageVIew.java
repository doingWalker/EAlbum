package com.mli.costom.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by limian on 2016/3/31.
 * 中间显示为正方形图片的ImageView（ImageView不一定是正方形）
 */
public class SquareImageVIew extends ImageView {

    public SquareImageVIew(Context context) {
        super(context);
    }

    public SquareImageVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public SquareImageVIew(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        int min = Math.min(wSize, hSize);
        setMeasuredDimension(min, min);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable d = getDrawable();
        if (null == d || !(d instanceof BitmapDrawable)) {
            super.onDraw(canvas);
            return;
        }
        int wCanvas = getWidth();
        int hCanvas = getHeight();
        if (wCanvas != hCanvas) {
            float minCanvas = Math.min(wCanvas, hCanvas);
            canvas.translate((wCanvas - minCanvas) / 2, (hCanvas - minCanvas) / 2);
        }

        ShapeDrawable shape = getRoundShapeDrawable((BitmapDrawable) d);
        shape.draw(canvas);
    }

    private ShapeDrawable getRoundShapeDrawable(BitmapDrawable d) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        Bitmap bitmap = getBitmap(d);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        shapeDrawable.getPaint().setShader(bitmapShader);
        int min = Math.min(getWidth(), getHeight());
        shapeDrawable.setBounds(0, 0, min, min);
        return shapeDrawable;
    }

    private Bitmap getBitmap(BitmapDrawable d) {
        Bitmap source = d.getBitmap();
        int sourceW = source.getWidth();
        int sourceH = source.getHeight();
        Bitmap squear = null;
        if (sourceW != sourceH) {
            int min = Math.min(sourceW, sourceH);
            squear = Bitmap.createBitmap(source, (sourceW - min) / 2, (sourceH - min) / 2, min, min);
        } else {
            squear = source;
        }

        int minCanvas = Math.min(getWidth(), getHeight());
        int minBitmap = Math.min(squear.getWidth(), squear.getHeight());
        float rate = minCanvas / (float) minBitmap;
        Matrix matrix = new Matrix();
        matrix.setScale(rate, rate);

        Bitmap result = Bitmap.createBitmap(squear, 0, 0, squear.getWidth(), squear.getHeight(), matrix, true);
        return result;
    }
}
