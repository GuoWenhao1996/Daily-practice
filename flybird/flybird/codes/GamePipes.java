

import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class GamePipes {
	public Pipe a;
	public Pipe b;
	private int between=150;
	public GamePipes(GamePanel gp) {
		a=new Pipe(gp);
		//设置a水管的位置为天空的宽度（屏幕右边）
		a.x=gp.getSkyWeigh()+100;
		b=new Pipe(gp);
		//设置b水管的位置距离a为between
		b.x=a.x+a.w+between;
	}
	public void reset(GamePanel gp) {
		 a.x = gp.getSkyWeigh()+100;
		 b.x=a.x+a.w+between;
	}
	public void paint(Graphics g) {
		a.paint(g);
		//管道已移动到屏幕外，重置管道
		if(a.x<-a.w){//a.x+a.w<0
			//a的位置变为距离b为bettween
			a.x=b.x+b.w+between;
			a.randomY();
		}		
		b.paint(g);
		
		//管道已经移动到屏幕外,重置管道位置
		if(b.x<-b.w){
			//b跟在a后面
			b.x=a.x+a.w+between;
			b.randomY();
		}
	}
}
