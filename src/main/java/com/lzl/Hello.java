package com.lzl;

import java.util.HashMap;
import java.util.Map;

import com.lzl.pojo.User;

public class Hello extends Object{

	public static int sum=1;
	public Hello() {
		sum=sum+5;
	}
	public void show() {
		
	}
	public int show(int x) {
		return 0;
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		
		super.finalize();
		System.out.println("666");
	}
	public static void main(String args[]) {
		Hello d1=new Hello();
		Hello d2=new Hello();
		double k = 12.2;
		float t = 12.2f;
		int i =4;
		int z = i++;
		System.out.println(z);
		System.gc();
		String string = "erty";
		System.out.println(string.substring(0,0));
	}
}
