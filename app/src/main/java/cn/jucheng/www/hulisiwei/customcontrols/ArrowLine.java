package cn.jucheng.www.hulisiwei.customcontrols;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import cn.jucheng.www.hulisiwei.R;

/**
 * Created by zyn on 2018/1/12.
 */

public class ArrowLine extends View{

    private Canvas myCanvas;
    private Paint myPaint=new Paint();
    int sx,sy,ex,ey;

    public ArrowLine(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    public ArrowLine(Context context,int xs,int ys,int xe,int ye) {
        super(context);
        // TODO Auto-generated constructor stub
        sx=xs ;sy=ys;ex=xe;ey=ye;

    }

    public ArrowLine(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public ArrowLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        this.myCanvas=canvas;
        drawAL(sx, sy, ex, ey);
    }

    /**
     * 设置画笔默认样式
     */
    public void setPaintDefaultStyle(){
        myPaint.setAntiAlias(true);
        myPaint.setColor(getResources().getColor(R.color.bg_txt_color));
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(1);
    }


    /**
     * 画圆
     * @param x x坐标
     * @param y y坐标
     * @param radius    圆的半径
     */
    public void drawCircle(float x,float y,float radius){
        myCanvas.drawCircle(x, y, radius, myPaint);
        invalidate();
    }

    /**
     * 画一条直线
     * @param fromX 起点x坐标
     * @param fromY 起点Y坐标
     * @param toX   终点X坐标
     * @param toY   终点Y坐标
     */
    public void drawLine(float fromX,float fromY,float toX,float toY){
        Path linePath=new Path();
        linePath.moveTo(fromX, fromY);
        linePath.lineTo(toX, toY);
        linePath.close();
        myCanvas.drawPath(linePath, myPaint);
        invalidate();
    }


    /**
     * 画箭头
     * @param sx
     * @param sy
     * @param ex
     * @param ey
     */
    public void drawAL(int sx, int sy, int ex, int ey)
    {
        double H = 8; // 箭头高度
        double L = 3.5; // 底边的一半
        int x3 = 0;
        int y3 = 0;
        int x4 = 0;
        int y4 = 0;
        double awrad = Math.atan(L / H); // 箭头角度
        double arraow_len = Math.sqrt(L * L + H * H); // 箭头的长度
        double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
        double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
        double x_3 = ex - arrXY_1[0]; // (x3,y3)是第一端点
        double y_3 = ey - arrXY_1[1];
        double x_4 = ex - arrXY_2[0]; // (x4,y4)是第二端点
        double y_4 = ey - arrXY_2[1];
        Double X3 = new Double(x_3);
        x3 = X3.intValue();
        Double Y3 = new Double(y_3);
        y3 = Y3.intValue();
        Double X4 = new Double(x_4);
        x4 = X4.intValue();
        Double Y4 = new Double(y_4);
        y4 = Y4.intValue();
        // 画线
        myCanvas.drawLine(sx, sy, ex, ey,myPaint);
        //画箭头
        Path triangle = new Path();
        triangle.moveTo(ex, ey);
        triangle.lineTo(x3, y3);
        triangle.lineTo(x4, y4);
        triangle.close();

        myCanvas.drawPath(triangle,myPaint);
//        Paint left_paint = new Paint();
//        Paint right_paint = new Paint();
//        Path left_path = new Path();
//        Path right_path = new Path();
//        left_path.reset();
//        right_path.reset();
//        left_paint.setAntiAlias(true);
//        left_paint.setColor(getResources().getColor(R.color.bg_txt_color));
//        right_paint.setAntiAlias(true);
//        right_paint.setColor(getResources().getColor(R.color.bg_txt_color));
//        left_paint.setStrokeWidth(2.0f);
//        right_paint.setStrokeWidth(2.0f);
//        left_paint.setStyle(Paint.Style.STROKE);
//        right_paint.setStyle(Paint.Style.STROKE);
//        left_path.moveTo(ex, ey);
//        right_path.moveTo(ex, ey);
//        left_path.quadTo(ex - 3, ey - 3, ex - 6, ey - 6);
//        right_path.quadTo(ex + 3, ey - 3, ex + 6, ey - 6);
//        myCanvas.drawPath(left_path, left_paint);
//        myCanvas.drawPath(right_path, right_paint);
    }
    // 计算
    public double[] rotateVec(int px, int py, double ang, boolean isChLen, double newLen)
    {
        double mathstr[] = new double[2];
        // 矢量旋转函数，参数含义分别是x分量、y分量、旋转角、是否改变长度、新长度
        double vx = px * Math.cos(ang) - py * Math.sin(ang);
        double vy = px * Math.sin(ang) + py * Math.cos(ang);
        if (isChLen) {
            double d = Math.sqrt(vx * vx + vy * vy);
            vx = vx / d * newLen;
            vy = vy / d * newLen;
            mathstr[0] = vx;
            mathstr[1] = vy;
        }
        return mathstr;
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
//    }


}


