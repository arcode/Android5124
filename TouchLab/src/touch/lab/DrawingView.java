package touch.lab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView extends View implements View.OnTouchListener {

	private Paint paint;
	private Bitmap bitmap;
	private Path path;
	private Canvas canvas;
	private float lastX, lastY;

	public DrawingView(Context context) {
		super(context);
		init();
	}

	public DrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		this.paint = new Paint();
		this.paint.setAntiAlias(true);
		this.paint.setColor(Color.WHITE);
		this.paint.setStyle(Style.STROKE);
		this.paint.setStrokeJoin(Join.ROUND);
		this.paint.setStrokeCap(Cap.ROUND);
		this.paint.setStrokeWidth(5F);
		this.path = new Path();
		setOnTouchListener(this);
		this.setBackgroundColor(Color.BLUE);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		this.bitmap = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		this.canvas = new Canvas();
		this.canvas.setBitmap(this.bitmap);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(this.bitmap, 0, 0, paint);
		canvas.drawPath(this.path, this.paint);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			path.reset();
			path.moveTo(x, y);
			this.lastX = x;
			this.lastY = y;
			invalidate();
			return true;
		case MotionEvent.ACTION_MOVE:
			float diff = FloatMath.sqrt((x-lastX)*(x-lastX)+(y-lastY)*(y-lastY)); 
			if(diff<=4){
				return false;
			}
			path.lineTo(x, y);
			invalidate();
			return true;
		case MotionEvent.ACTION_UP:
			path.lineTo(x, y);
			canvas.drawPath(path, paint);
			return true;

		default:
			break;
		}
		return false;
	}

}
