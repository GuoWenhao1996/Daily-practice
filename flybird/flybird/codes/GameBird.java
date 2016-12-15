

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;



public class GameBird {
	private BufferedImage[] birds = new BufferedImage[3];
	private int bird_index = 0;
	private int bird_x = 0;
	private int bird_y = 0;
	private double height = 0;
	private long lasttime;// 上次画翅膀的时间
	private int w = 0;
	private int h = 0;
	private double angle;
	/*
	 * bird_y height 0g 0.5g 0.5 2g 1.5 4.5g 2.5 8g 3.5
	 * 
	 */

	public GameBird() {
		birds[0] = R.lode("0.png");
		birds[1] = R.lode("1.png");
		birds[2] = R.lode("2.png");
		w = birds[0].getWidth();
		h = birds[0].getHeight();
		bird_x = 160 - birds[0].getWidth() / 2;
		bird_y = 0;
		height = 0.5;
		lasttime = System.currentTimeMillis();
	}

	public void Fly() {
		height = -2.5;
		angle = Math.atan(height / 10);
		new Music("fei.wav").start();
	}

	public void paint(Graphics g) {
		bird_y = (int) (bird_y + height);
		if (System.currentTimeMillis() - lasttime > 120) {
			height = height + 1;
			bird_index++;
			if (bird_index == 3) {
				bird_index = 0;
			}
			lasttime = System.currentTimeMillis();
			angle = Math.atan(height / 10);
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(angle, bird_x + w / 2, bird_y + h / 2);
		g.drawImage(birds[bird_index], bird_x, bird_y, null);
		g2d.rotate(-angle, bird_x + w / 2, bird_x + h / 2);
	}

	public void reset() {
		bird_y = 0;
		height = 0.5;
	}

	public boolean isHidePipe(Pipe a, Pipe b) {
		if (bird_x + birds[0].getWidth() > a.x && bird_x < a.x + a.w
				&& (bird_y < a.temp || bird_y + birds[0].getHeight() > a.temp + a.distance))
			return true;
		if (bird_x + birds[0].getWidth() > b.x && bird_x < b.x + b.w
				&& (bird_y < b.temp || bird_y + birds[0].getHeight() > b.temp + b.distance))
			return true;

		return false;
	}

	public boolean isHideGround() {
		if (bird_y + h > 400) {
			return true;
		} else
			return false;
	}

	/** 判断鸟是否通过柱子 */
	public boolean pass(Pipe a, Pipe b) {
		return a.x + a.w == bird_x || b.x + b.w == bird_x;
	}
}
