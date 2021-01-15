package com.example.proiectaz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AfiseazaRaportUtilizatori  extends View {
    private Map<String, Integer> source;
    private Paint paint;
    private Paint paintFill=new Paint();
    private Paint paintStroke=new Paint();
    private List<String> labels;
    private Random random;

    public AfiseazaRaportUtilizatori(Context context, Map<String, Integer> source)
    {
        super(context);
        this.source = source;
        this.paint = new Paint();
        labels = new ArrayList<>(source.keySet());
        random = new Random();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        if (source != null && source.size() > 0)
        {
            canvas.drawColor(R.color.colorAccentLight);

            float paddW = (float) (getWidth() * 0.1);
            float paddH = (float) (getHeight() * 0.1);

            float availableWidth = getWidth() - 2 * paddW;
            float availableHeight = getHeight() - 2 * paddH;


            canvas.drawLine(paddW, paddH, paddW, paddH + availableHeight, paint);
            canvas.drawLine(paddW, paddH + availableHeight, paddW + availableWidth, paddH + availableHeight, paint);


            double maxValue = calculateMaxim();

            float widthOfElement = (float) (availableWidth / source.size() );
            for (int i = 0; i < labels.size(); i++) {

                paintFill.setStyle(Paint.Style.FILL);
                paintFill.setColor(Color.rgb(216,114,114));
                paintStroke.setStyle(Paint.Style.STROKE);
                paintStroke.setColor(Color.BLACK);
                paintStroke.setStrokeWidth(10);

                float x1 =  (60+paddW + i * widthOfElement);
                float y1 = (float) ((1 - source.get(labels.get(i)) / maxValue) * availableHeight + paddH);
                float x2 = x1 + widthOfElement;
                float y2 = paddH + availableHeight;


                canvas.drawRect( (x1), y1, (float) (x2*0.9), y2, paintFill);
                canvas.drawRect( (x1), y1, (float) (x2*0.9), y2, paintStroke);


                drawLabel(canvas, x1, widthOfElement, paddH, availableHeight, labels.get(i));
            }
        }
    }

    private void drawLabel(Canvas canvas, float x1, float widthOfElement, float paddH, float availableHeight, String label) {

        paintStroke.setColor(Color.BLACK);
        paintStroke.setStyle(Paint.Style.STROKE);
        paintStroke.setTextSize(80);
        float x =  (x1 + widthOfElement );
        float y =  (1 / 2 * paddH + availableHeight);
        canvas.rotate(360, x, y);
        canvas.drawText(label + " - " + source.get(label), x-530, y-950, paintStroke);
        canvas.rotate(-360, x, y);
    }

    private double calculateMaxim() {
        double max = 0;
        for (double value : source.values()) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }
}
