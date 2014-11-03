package com.example.lianlian;

import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View{
	public static int ROW=8;
	public static int COL=8;
	public int iconWidth=32;
	public int iconHeight=32;
	public int picCount=12;
	public int [][] map;
	public Bitmap[] icons=new Bitmap[picCount];
	public int curX=0,curY=0,lastX=0,lastY=0;
	//public XyPoint[] p;
	public float width,height;
	public GameView(Context context, AttributeSet attrs) {
		// TODO Auto-generated constructor stub
		super(context,attrs);
		randomIcons();
	}

	public Resources r=this.getContext().getResources();
	public void randomIcons(){
		for(int i=0;i<picCount;i++){
			icons[i]=((BitmapDrawable)r.getDrawable(R.drawable.p2+i)).getBitmap();
			//icons[i]=((BitmapDrawable)r.getDrawable(R.drawable.p2+i)).getBitmap();
		}
		int i=0;
		map=new int[ROW][COL];
		for(int x=0;x<ROW;x++){
			map[x][0]=-1;
			map[x][COL-1]=-1;
		}
		for(int y=0;y<COL;y++){
			map[0][y]=-1;
			map[ROW-1][y]=-1;
		}
		for(int x=1;x<ROW-1;x+=1){
			for(int y=1;y<COL-1;y+=2){
				map[x][y]=map[x][y+1]=i++;
				if(i==picCount){
					i=0;
				}
			}
		}
			//Ëæ»ú´òÂÒÍ¼Æ¬
			int tmpV,tmpX,tmpY;
			Random random=new Random();
			for(int y=1;y<COL-1;y++){
				for(int x=1;x<ROW-1;x++){
					tmpV=map[x][y];
					tmpX=random.nextInt(ROW-2)+1;
					tmpY=random.nextInt(COL-2)+1;
					map[x][y]=map[tmpX][tmpY];
					map[tmpX][tmpY]=tmpV;
				}
			}
		}
		protected void onDraw(Canvas canvas){
			width=this.getWidth()/COL;
			height=this.getHeight()/ROW;
			RectF rDst=null;
			for(int x=0;x<ROW;x++){
				for(int y=0;y<COL;y++){
					if(map[x][y]!=-1){
						rDst=new RectF(x*width,y*height,x*width+iconWidth+3,y*height+iconHeight+3);
						canvas.drawBitmap(icons[map[x][y]],null,rDst,null);
					}
				}
			}
		
	}

}
