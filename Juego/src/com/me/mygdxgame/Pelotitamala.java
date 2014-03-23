package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pelotitamala extends Image{

	Pelotitamala(int x, int y)
	{
		super(new Texture("data/Pelotitamala.png"));
		addListener(new Milistenermala(this));
		setX(x);
		setY(y);
		// TODO Auto-generated constructor stub
	}
	public void act(float delta){
	
		setX(getX()+1);
		
		
		if(getX()>500)
			remove();	
	}
	
}
