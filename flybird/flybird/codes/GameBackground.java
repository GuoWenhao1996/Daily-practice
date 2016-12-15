
import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class GameBackground {
	
	private BufferedImage bg;
	private BufferedImage ground;
	private int ground_x=0;
	private int ground_y=0;
	
	public GameBackground(){
		bg = R.lode("bg.png");
		ground = R.lode("ground.png");
		ground_x=0;
		ground_y=bg.getHeight()-ground.getHeight();
	}
	public int getSkyHeigh() {
		return bg.getHeight()-ground.getHeight();
	}
	public int getSkyWeigh() {
		return bg.getWidth();
	}
	
	
	public void paintsky(Graphics g){
		//����
		g.drawImage(bg, 0, 0, null);
	}
	
	public void paintground(Graphics g){
		// 28Ϊ��λ����,5����λ�����ػ�һ�βݵ�
		if (ground_x == -140)
			ground_x = 0;
		ground_x--;
		//�ݵ�
		g.drawImage(ground, ground_x,ground_y, null);
	}
}
