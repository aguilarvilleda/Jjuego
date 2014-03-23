package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pelotita extends Image{

	Pelotita(int x,int y)
	{
		super(new Texture("data/Pelotita1.png"));
		addListener(new Milistener(this));
		setX(x);
		setY(y);
	}
	
	public void act(float delta){
		
		setX(getX()+1.5f);
		//setX((float) (Math.random()*1%getX())+1);
		
		if(getX()>500)
			remove();
	}

}
