package com.me.mygdxgame;

public class ClassA {
	
	void func()
	{
		System.out.println("Clase A");
	}
	

}

class ClassB extends ClassA
{
	void func(){
		System.out.println("Clase B");
	}
	
	void func2(){
		
		System.out.println("Probando B");
	}


}
