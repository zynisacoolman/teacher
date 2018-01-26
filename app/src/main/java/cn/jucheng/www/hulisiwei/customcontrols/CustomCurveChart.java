package cn.jucheng.www.hulisiwei.customcontrols;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by zyn
 */
public class CustomCurveChart extends View {
    // 曲线数据
    private int color;
    // 默认边距
    private int margin = 20;
    // 距离左边偏移量
    private int marginX = 30;
    private Boolean showValue;
    // 原点坐标
    private int xPoint;
    private int yPoint;
    // X,Y轴的单位长度
    private int xScale;
    private int yScale;
    // 坐标单位
    private String[] xLabel;
    private String[] yLabel;
    //数据 这是个Arraylist数组 0表示 x坐标 1
    private ArrayList<Integer>[] dataList;
    // 画笔
    private Paint paintCurve ;

    public CustomCurveChart(Context context,String[] xlabel,String[] ylabel,
                            ArrayList<Integer>[] xy,
                            int color, boolean showValue) {

        super(context);
        this.dataList=xy;
        this.color = color;
        this.showValue = showValue;
        this.xLabel=xlabel;
        this.yLabel=ylabel;

    }

    public CustomCurveChart(Context context) {
        super(context);
    }

    /**
     * 初始化数据值和画笔
     */
    public void init() {
        xPoint = margin + marginX;
        yPoint = this.getHeight() - margin;
        xScale = (this.getWidth() - 2 * margin - marginX) / (xLabel.length - 1);
        yScale = (this.getHeight() - 2 * margin) / (yLabel.length - 1);


        paintCurve=new Paint();
        paintCurve.setStyle(Paint.Style.STROKE);
        paintCurve.setDither(true);
        paintCurve.setAntiAlias(true);
        paintCurve.setStrokeWidth(3);
        PathEffect pathEffect = new CornerPathEffect(25);
        paintCurve.setPathEffect(pathEffect);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(getResources().getColor(R.color.color1));
        init();
        drawCurve(canvas, paintCurve, dataList, color);

    }
    /**
     * 绘制曲线
     */
    private void drawCurve(Canvas canvas,
                           Paint paint,
                           ArrayList<Integer>[] xy,
                           int color) {
        paint.setColor(getResources().getColor( color));
        Path path = new Path();
        for (int i = 0; i <= (xy[0].size() - 1); i++) {
            if (i == 0) {
                path.moveTo(xy[0].get(i), xy[1].get(i));
            } else {
                path.lineTo(xy[0].get(i), xy[1].get(i));
            }
        }
        canvas.drawPath(path, paint);
    }

}
