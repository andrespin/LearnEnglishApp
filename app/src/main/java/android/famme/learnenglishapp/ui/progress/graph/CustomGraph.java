package android.famme.learnenglishapp.ui.progress.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.firestore.v1.Value;

public class CustomGraph extends View {

    private int width;
    private int height;

    private ResultsData data;

    public CustomGraph(Context context) {
        super(context);
    }

    public CustomGraph(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void setData(ResultsData data) {
        this.data = data;
        System.out.println("setData " + data.education);
        invalidate();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        System.out.println(widthMeasureSpec + " " + heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(30);

        Paint linePaint = new Paint();
        linePaint.setColor(Color.BLACK);
        linePaint.setStrokeWidth(4);

        canvas.drawLine(getWidthPoint(), 0, getWidthPoint(), 10 * getHeighthPoint(),
                linePaint);

        canvas.drawLine(getWidthPoint(), 10 * getHeighthPoint(), 12 * getWidthPoint(),
                10 * getHeighthPoint(), linePaint);

        for (int i = 1; i < 10; i++) {
            canvas.drawLine(getWidthPoint() - 15, i * getHeighthPoint(), getWidthPoint() + 15,
                    i * getHeighthPoint(), linePaint);

            canvas.drawLine(getWidthPoint() * (i + 1), getHeighthPoint() * 10 + 15, getWidthPoint() * (i + 1),
                    getHeighthPoint() * 10 - 15, linePaint);
        }

        canvas.drawLine(getWidthPoint() * 11, getHeighthPoint() * 10 + 15, getWidthPoint() * 11,
                getHeighthPoint() * 10 - 15, linePaint);


        Paint point = new Paint();
        point.setColor(Color.parseColor("#FFBB86FC"));
        point.setStrokeWidth(50);
        point.setTextSize(35);
        drawGraphs(canvas, point, linePaint, data);

    }

    private void drawGraphs(Canvas canvas, Paint point, Paint line, ResultsData data) {

        System.out.println("data " + data);

        try {
            int personality = getCoef(data.getPersonality());
            System.out.println("getCoef(data.getPersonality()) " + getCoef(data.getPersonality()));
            canvas.drawCircle(getFWidthPoint() * 2, getFHeighthPoint() * personality, 18f, point);

            int shopping = getCoef(data.getShopping());
            System.out.println("getCoef(data.getShopping()) " + getCoef(data.getShopping()));
            canvas.drawCircle(getFWidthPoint() * 3, getFHeighthPoint() * shopping, 18f, point);

            canvas.drawLine(getFWidthPoint() * 2, getFHeighthPoint() * personality,
                    getFWidthPoint() * 3, getFHeighthPoint() * shopping, line);


            int education = getCoef(data.getEducation());
            canvas.drawCircle(getFWidthPoint() * 4, getFHeighthPoint() * education, 18f, point);

            canvas.drawLine(getFWidthPoint() * 3, getFHeighthPoint() * shopping,
                    getFWidthPoint() * 4, getFHeighthPoint() * education, line);

            int family = getCoef(data.getFamily());
            canvas.drawCircle(getFWidthPoint() * 5, getFHeighthPoint() * family, 18f, point);

            canvas.drawLine(getFWidthPoint() * 4, getFHeighthPoint() * education,
                    getFWidthPoint() * 5, getFHeighthPoint() * family, line);

            int lifestyle = getCoef(data.getLifestyle());
            canvas.drawCircle(getFWidthPoint() * 6, getFHeighthPoint() * lifestyle, 18f, point);

            canvas.drawLine(getFWidthPoint() * 5, getFHeighthPoint() * family,
                    getFWidthPoint() * 6, getFHeighthPoint() * lifestyle, line);

            int clothes = getCoef(data.getClothes());
            canvas.drawCircle(getFWidthPoint() * 7, getFHeighthPoint() * clothes, 18f, point);

            canvas.drawLine(getFWidthPoint() * 6, getFHeighthPoint() * lifestyle,
                    getFWidthPoint() * 7, getFHeighthPoint() * clothes, line);

            int books = getCoef(data.getBooks());
            canvas.drawCircle(getFWidthPoint() * 8, getFHeighthPoint() * books, 18f, point);

            canvas.drawLine(getFWidthPoint() * 7, getFHeighthPoint() * clothes,
                    getFWidthPoint() * 8, getFHeighthPoint() * books, line);

            int culture = getCoef(data.getCulture());
            canvas.drawCircle(getFWidthPoint() * 9, getFHeighthPoint() * culture, 18f, point);

            canvas.drawLine(getFWidthPoint() * 8, getFHeighthPoint() * books,
                    getFWidthPoint() * 9, getFHeighthPoint() * culture, line);

            int life = getCoef(data.getLife());
            canvas.drawCircle(getFWidthPoint() * 10, getFHeighthPoint() * life, 18f, point);

            canvas.drawLine(getFWidthPoint() * 9, getFHeighthPoint() * culture,
                    getFWidthPoint() * 10, getFHeighthPoint() * life, line);

            int summer = getCoef(data.getSummer());
            canvas.drawCircle(getFWidthPoint() * 11, getFHeighthPoint() * summer, 18f, point);

            canvas.drawLine(getFWidthPoint() * 10, getFHeighthPoint() * life,
                    getFWidthPoint() * 11, getFHeighthPoint() * summer, line);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    private int getCoef(int i) {
        return 10 - i;
    }


    private float getFWidthPoint() {
        return (float) width / 12;
    }

    private float getFHeighthPoint() {
        return (float) height / 12;
    }

    private int getWidthPoint() {
        return width / 12;
    }

    private int getHeighthPoint() {
        return height / 12;
    }


}
