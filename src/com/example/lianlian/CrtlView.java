package com.example.lianlian;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class CrtlView extends GameView {
	private static final String TAG="me";
	public CrtlView(Context context,AttributeSet attrs){
		super(context,attrs);
	}
	public boolean onTouchEvent(MotionEvent event){
		lastX=curX;
		lastY=curY;
		if((int)(event.getX()/width)>=COL||(int)(event.getY()/height)>=ROW||
				map[(int)(event.getX()/width)][(int)(event.getY()/height)]==-1){
			return false;
		}
		else{
			curX=(int)(event.getX()/width);
			curY=(int)(event.getY()/height);
			Log.v(TAG,"curX="+curX+""+"curY="+curY);
		}
		click();
		return super.onTouchEvent(event);
		
	}
	private void click() {
		// TODO Auto-generated method stub
		invalidate();
		MyPoint[] p=new MyPoint[2];
		p[0]=new MyPoint(lastX,lastY);
		p[1]=new MyPoint(curX,curY);
		if(checkLink(p[0],p[1])){
			map[p[0].x][p[0].y]=-1;
			map[p[1].x][p[1].y]=-1;
			invalidate();
		}
	}
	private boolean checkLink(MyPoint a, MyPoint b) {
		// TODO Auto-generated method stub
		if(map[a.x][a.y]!=map[b.x][b.y]){
			return false;
		}
		if(map[a.x][a.y]==-1 && map[b.x][b.y]==-1){
			return false;
		}
		if(a.x==b.x && horizon(a,b)){
			return true;
		}
		if(a.y==b.y && vertical(a,b)){
			return true;
		}
		return false;
	}
	private boolean horizon(MyPoint a, MyPoint b) {
		// TODO Auto-generated method stub
		if(a.equals(b)){
			return false;
		}
			int y_start=a.y<=b.y?a.y:b.y;
			int y_end=a.y<=b.y?b.y:a.y;
			for(int y=y_start+1;y<y_end;y++){
				if(map[a.x][y]!=-1){
					return false;
				}
			}
		return true;
	}
	private boolean vertical(MyPoint a, MyPoint b) {
		// TODO Auto-generated method stub
		if(a.equals(b)){
			return false;
		}
		int x_start=a.x<=b.x?a.x:b.x;
		int x_end=a.x<=b.x?b.x:a.x;
		for(int x=x_start+1;x<x_end;x++){
			if(map[x][a.y]!=-1){
				return false;
			}
		}
		return true;
	}
}
