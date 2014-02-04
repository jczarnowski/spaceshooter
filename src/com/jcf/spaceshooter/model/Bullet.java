package com.jcf.spaceshooter.model;

import com.jcf.spaceshooter.engine.Assets;
import com.jcf.spaceshooter.engine.Pixmap;

public class Bullet extends InteractiveSpaceObject{

	protected Pixmap pixmap;
	public Bullet(int x, int y, float velx, float vely, int screenWidth, int screenHeight)
	{
		super(x,y,velx, vely,screenWidth,screenHeight,Assets.bullet);
		hp = 1;

	}
	
	public Bullet(int x, int y, float velx, float vely, int screenWidth, int screenHeight, Pixmap pixmap)
	{
		super(x,y,velx, vely,screenWidth,screenHeight, pixmap);
		hp = 1;

	}


	public boolean update(int time) {
		
		if (x < - width 		||
				x > swidth + width 	||
				y < - height		||
				y > sheight - height) 
				{
					return false;
				}

		return super.update(time);
	}

	public boolean colisionDetection(InteractiveSpaceObject object) {
		
		if(object instanceof SpaceShuttle || object instanceof Bullet) return false;
		
		return super.colisionDetection(object);
	}
	
	public void colisionDetected(InteractiveSpaceObject object) {
		if(object instanceof SpaceShuttle || object instanceof Bullet) return;
		hp = -1;
	}
	
}
