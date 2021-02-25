package dragosholban.com.androidpuzzlegame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class BorderView extends View {
    private Paint borderPaint = new Paint();
    private ArrayList<Path> paths = new ArrayList<>();

    public BorderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        applyPaint();
    }

    void addPaths(ArrayList<Path> newPaths) {
        paths.clear();
        paths.addAll(newPaths);
        invalidate();
    }

    private void applyPaint() {
        borderPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_border));
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(8.0f);
        borderPaint.setStrokeJoin(Paint.Join.ROUND);
        borderPaint.setStrokeCap(Paint.Cap.ROUND);
        borderPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (!paths.isEmpty()) {
            for (int index = 0; index < paths.size(); index++) {
                canvas.drawPath(paths.get(index), borderPaint);
            }
        }
        canvas.restore();
    }
}
