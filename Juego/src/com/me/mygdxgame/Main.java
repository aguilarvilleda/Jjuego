package com.me.mygdxgame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassA a = new ClassA();
		ClassB b = new ClassB();
		ClassA c = new ClassB();

		a.func();
		b.func();
		c.func();
		
		b.func2();
		c.func();
		
		ClassB casteada = (ClassB)c;
		casteada.func2();
	}

}
