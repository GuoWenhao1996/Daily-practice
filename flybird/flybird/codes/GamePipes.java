

import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class GamePipes {
	public Pipe a;
	public Pipe b;
	private int between=150;
	public GamePipes(GamePanel gp) {
		a=new Pipe(gp);
		//����aˮ�ܵ�λ��Ϊ��յĿ�ȣ���Ļ�ұߣ�
		a.x=gp.getSkyWeigh()+100;
		b=new Pipe(gp);
		//����bˮ�ܵ�λ�þ���aΪbetween
		b.x=a.x+a.w+between;
	}
	public void reset(GamePanel gp) {
		 a.x = gp.getSkyWeigh()+100;
		 b.x=a.x+a.w+between;
	}
	public void paint(Graphics g) {
		a.paint(g);
		//�ܵ����ƶ�����Ļ�⣬���ùܵ�
		if(a.x<-a.w){//a.x+a.w<0
			//a��λ�ñ�Ϊ����bΪbettween
			a.x=b.x+b.w+between;
			a.randomY();
		}		
		b.paint(g);
		
		//�ܵ��Ѿ��ƶ�����Ļ��,���ùܵ�λ��
		if(b.x<-b.w){
			//b����a����
			b.x=a.x+a.w+between;
			b.randomY();
		}
	}
}
