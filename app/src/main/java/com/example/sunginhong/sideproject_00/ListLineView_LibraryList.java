package com.example.sunginhong.sideproject_00;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.example.sunginhong.sideproject_00.Utils_Folder.Utils;

public class ListLineView_LibraryList extends View {
    public Context context;
    static public boolean drag = false;
    static public float dragStart_point_x = 0;
    static public float dragStart_point_y = 0;
    static public float dragMove_point_x = 0;
    static public float dragMove_point_y = 0;
    static public float dragEnd_point_x = 0;
    static public float dragEnd_point_y = 0;

    static public View frag1_lineview;
    static public boolean lib_lineAnim_Active = false;

    static Paint paint;
    static Path path;
    static Paint paintFill;
    static Path pathFill;
    static private int libLineMargin = 0;

    public ListLineView_LibraryList(Context context) {
        super(context);
        init();
    }

    public ListLineView_LibraryList(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ListLineView_LibraryList(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init(){
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paintFill = new Paint();
        paintFill.setStyle(Paint.Style.FILL);

        frag1_lineview = (View)findViewById(R.id.frag1_lineview);
        frag1_lineview.bringToFront();
        dragMove_point_y = Utils.dpToPx(libLineMargin);
        dragEnd_point_y = Utils.dpToPx(libLineMargin);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pathDraw(-Utils.dpToPx(0), Utils.dpToPx(libLineMargin), dragMove_point_x, dragMove_point_y, frag1_lineview.getWidth(), Utils.dpToPx(libLineMargin));
        canvas.drawPath(path, paint);
        canvas.drawPath(pathFill, paintFill);
        invalidate();
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    public static void clearCanvas(){
        if (path!=null){
            path.reset();
            paintFill.reset();
        }
    }

    private void pathDraw(float x1, float y1, float x2, float y2, float x3, float y3){
        path = new Path();
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(-Utils.dpToPx(0), Utils.dpToPx(libLineMargin));
        path.cubicTo(x1, y1, x2, y2, x3, y3);
//        path.close();

        pathFill = new Path();
//        paintLine.setColor(Color.WHITE);
        paintFill.setStrokeWidth(2);
        paintFill.setAlpha(0);
        paintFill.setAntiAlias(true);
//        paintLine.setStyle(Paint.Style.FILL);
        pathFill.moveTo(-Utils.dpToPx(0), Utils.dpToPx(libLineMargin));
        pathFill.cubicTo(x1, y1, x2, y2, x3, y3);
    }

    static public void functionRedraw(float x, float y) {
        dragMove_point_x = x;
        if (y < Utils.dpToPx(70) && y > -Utils.dpToPx(70)){
            dragMove_point_y = y/2;
        }

        frag1_lineview.invalidate();
    }

    static public void path_animator(int duration, boolean state) {
        ValueAnimator animator = ValueAnimator.ofFloat(dragMove_point_y, Utils.dpToPx(libLineMargin));
        animator.setDuration(duration);
        animator.setInterpolator(new DecelerateInterpolator(Float.valueOf(String.valueOf(1.5))));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                float path_origin_Yn = (float) animation.getAnimatedValue();
                dragMove_point_y = path_origin_Yn;
                frag1_lineview.invalidate();

            }
        });
        if (state == true){
            animator.start();
        }else {
            animator.cancel();
        }

    }
}