package com.example.lianlian;

public class MyPoint {
	public int x;
	public int y;
	public MyPoint(int x,int y){
		this.x=x;
		this.y=y;
	}
	public boolean equals(MyPoint p){
		if(p.x==x&&p.y==y){
			return true;
		}else{
			return false;
		}
	}

}
