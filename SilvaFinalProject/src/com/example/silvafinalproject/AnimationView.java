package com.example.silvafinalproject;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {

	// Create the Runnable
	private Runnable r = new Runnable() {
		
		@Override
		public void run(){
			// Call the Invalidate Method to reDraw
			invalidate();
		}
	};
	// Create Actors
	private Actor actorone;
	private Actor actortwo;
	private Actor actorthree;
	private Actor tardis;
	
	// Breakout Actors
	private Actor paddle;
	private Actor ball;
	
	// Array List for Bricks
	private List <Actor> bricks;
	private List <Actor> brickstwo;
	
	// Values to hold the accel data
	private float ax = 0;
	private float ay = 0;
	private float az = 0;

	
	// Create the Handler for animation
	private Handler h;
	private int RATE = 30; //about 30 frames a second
	
	
	public AnimationView(Context context, AttributeSet attrs){
		super(context, attrs);
		
		
		// Initialize Breakout Actors
		ball = new Actor(context, 200, 200, Color.BLUE, 25);
		paddle = new Actor(context, 300, 300, Color.RED, 40);
		
		paddle.setWidth(150);
		paddle.setHeight(40);
		
		ball.setDX(10);
		ball.setDY(10);
		
		
		// Initialize Bricks
		bricks = new ArrayList <Actor> (0); // List of 6
		
		for (int i = 0; i<6; i++) {
			bricks.add(new Actor(context, i*80, 100, Color.GREEN, 40));
			
		}
		
		for (int i = 0; i< bricks.size(); i++) {
			bricks.get(i).setWidth(75);
		}
		
	 
		
		
	// Initialize actors
		actorone= new Actor(context, 100, 100, Color.RED, 40);
		actortwo = new Actor(context, 200, 200, Color.BLUE, 50);
		actorthree = new Actor(context, 300, 200, Color.GREEN, 100);
		// Initialize the tardis
		tardis = new Actor(context, 300, 300, Color.BLUE, 50);
		tardis.setCostume(R.drawable.tardis);
		actorone.setDX(5);
		actorone.setDY(5);
		
		actortwo.setDX(10);
		actortwo.setDY(-10);
		
	 
		// Initialize the Handler
		h = new Handler();
	
	} //end onCreate
	
	// Create onDraw (in all View Classes)
	public void onDraw(Canvas c){
	// have actors draw themselves
	 
		paddle.drawRect(c);
		ball.drawCircle(c);
		
		ball.move();
		ball.bounce(c);
		if(ball.isTouching(paddle)){
			ball.bounceUp();
			
			
			for (int i = 0; i < bricks.size(); i++) {
				// Set Brick Width
				bricks.get(i).setWidth((c.getWidth()/6)-3);
				// Set the x position for the bricks
				int xPos = i * (c.getWidth()/6);
				//goTo and Draw the Bricks
				bricks.get(i).goTo(xPos, 100);
				bricks.get(i).drawRect(c);
				
				// Check for Collisions and Erase Bricks
				if (ball.isTouching(bricks.get(i))) {
					if (bricks.get(i).getVisible() == true) {
						ball.bounceUp();
						bricks.get(i).setVisible(false);
						
					}
				}
			}
		}
		 
		
		
		//tardis.changeDX(ax * -1); //read the x acceleration
		//tardis.changeDY(ay); // read the y acceleration
		//tardis.move(); // Move
		//tardis.bounce(c); // bounce
		
		//actorone.drawCircle(c);
		//actortwo.drawSquare(c);
		//actorthree.drawSquare(c);
	    //tardis.draw(c);
		h.postDelayed(r,RATE);
		
		//actorone.move();
		//actorone.bounce(c);
		//actortwo.move();
		//actortwo.bounce(c);
		
		
		// Bounce off the actorthree
				if (actorone.isTouching(actorthree)) {
					actorone.bounceOff();
				}
				if (actorone.isTouching(actortwo)){
					actorone.bounceOff();
				}
							 
				 if(actortwo.isTouching(actorthree)){
					 actortwo.bounceOff();
				 
				 }
				 if(actortwo.isTouching(actorthree)){
					 actortwo.bounceOff();
				 }
				 if(tardis.isTouching(actorthree)) {
					 tardis.bounceOff();
					 }
	} // End onDraw
	
	 
	public boolean onTouchEvent(MotionEvent event){
		// Fetch Data from touch event
		int actions = event.getActionMasked(); // Get type of Action
		int actionIdex = event.getActionIndex(); // Get Index of Action
		
		// Set Position of Sandy to Touch Data
		actorthree.goTo((int)event.getX(), (int)event.getY());
		
		paddle.goTo((int)event.getX(), 750);
		return true;
	}
	
	 public void setAX(float x){
		 ax = x;
	 }
	 public void setAY(float y){
		 ay = y;
	 }
	 public void setAZ(float z){
		 az = z;
	 }
	 
}// End Class Animation View
