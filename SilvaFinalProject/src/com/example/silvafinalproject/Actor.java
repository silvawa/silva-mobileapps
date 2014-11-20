package com.example.silvafinalproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;

public class Actor {
	
	// Fields for Actor
	private Point p; // for Location
	private int c; // color
	private int s; //color
	private int dx; //change in x speed
	private int dy; // for change in y speed
	private Paint paint; // Paint object to hold painter
	
	// ints for width and height
	private int w; // width
	private int h; //height
	
	private boolean isVisible = true;
	// Context So Actor Can Get At Graphic Resources
	private Context aContext;
	
	// Integer for Drawable Resources
	private int costume;
	
	// Stores Graphic for Costume
	private BitmapDrawable graphic;
	
	// Constructor 
	public  Actor(Context context, int x, int y, int col, int size) {
	
		p = new Point(x, y); // set the x and y position
		c = col; //sets color
		s = size; //sets the size
		w = s; // set width
		h = s;// set height
		paint = new Paint(); //creatures Paint object
		paint.setColor(c); //sets paint color
		dx = 0;
		dy= 0;
		
		//Set The Constructor
		
		aContext = context;
	}// End Constructor
	
	public int getX(){
		return p.x;
	} // end getX()
	public int getY() {
		return p.y;
	}
	public Paint getPaint(){
		return paint;
	} //end getPaint()
	public int getSize(){
		return s;
	} //end getSize()
	
	// Modifiers
	public void setColor(int col) {
		c= col;
		paint.setColor(c);
	
	}
	
	public void goTo(int x, int y) {
		p.x = x;
		p.y = y;
	}
	public void setDX(int speed){
		dx = speed;
	}
	public void setDY(int speed){
		dy = speed;
		}
	
	
	public void changeDX(float a){
		dx += a;
	}
	public void changeDY(float a){
		dy += a;
	}
	public void move() {
		p.x += dx;
		p.y += dy;
	}
	
public void bounce(Canvas c) {
	if (p.x > c.getWidth() || p.x <0){
		dx = dx * -1;
	}
	if (p.y > c.getHeight() || p.y< 0 ){
		dy =dy*-1;
	}
	
	}
 

public void bounceActor (Actor a){
	// Empty Also
}


public void drawCircle(Canvas c) {
	c.drawCircle(p.x, p.y, s, paint);
}
public void drawSquare(Canvas c) {
	c.drawRect(p.x, p.y, p.x + s, p.y + s, paint);
}
public void draw(Canvas c){
	c.drawBitmap(getBitmap(), p.x, p.y, paint);
}
public Bitmap getBitmap() {
	return graphic.getBitmap();
}
public void setCostume (int cost){
	costume = cost;
	graphic = (BitmapDrawable)aContext.getResources().getDrawable(costume);

w = graphic.getBitmap().getWidth();
h = graphic.getBitmap().getHeight();
}
public int getHeight() {
	return h;
}
public int getWidth() {
	return w;
}

public boolean isTouching(Actor a){
	boolean result = false;
	if ((p.x +w> a.getX() && p.x < a.getX() + a.getWidth()) && (p.y + h > a.getY() && p.y+h < a.getY() +a.getHeight())) {
		result = true;
		
	}
	return result;
}

public void bounceOff() {
	dx = dx * -1;
	dy = dy * -1;
}

public void setWidth(int width){
	w = width;
}
public void setHeight(int height) {
	h = height;
}
// Function to draw a rectangle
public void drawRect(Canvas c){
	if (isVisible) {
	c.drawRect(p.x, p.y, p.x+w, p.y + h, paint);
	}
}
public void bounceUp() {
	dy = dy * -1;
}
public boolean getVisible() {
	return isVisible;
}
public void setVisible(boolean v) {
	isVisible = v;
}

} // end class Actor
