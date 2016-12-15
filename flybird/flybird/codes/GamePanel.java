

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.Thread.State;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements Runnable {
	private Thread gameThread = null;
	private GameBird bird;
	private GameBackground background;
	private GamePipes pipes;
	private GameStatus status;
	private int score=0;
	Music mu= new Music("bg.wav");
	public static final int READY = 0;
	public static final int PLAYING = 1;
	public static final int GAMEOVER = -1;
	public static int STATU = 0;

	public int getSkyHeigh() {
		return background.getSkyHeigh();
	}

	public int getSkyWeigh() {
		return background.getSkyWeigh();
	}

	public GamePanel() {
		bird = new GameBird();
		background = new GameBackground();
		pipes = new GamePipes(this);
		status = new GameStatus();
		score=0;
		// 监听点击事件
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseEvent();
			}
		});
		init();
	}

	public void mouseEvent() {
		if (STATU == READY) {
			STATU = PLAYING;
			mu=new Music("bg.wav");
			mu.start();
		} else if (STATU == GAMEOVER) {
			STATU = READY;
			bird.reset();
			pipes.reset(this);
			score=0;
		} else
			bird.Fly();
	}

	private void init() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				repaint();
				Thread.sleep(1000 / 60);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// 1.绘制背景
		background.paintsky(g);
		if (STATU == PLAYING) {
			if (bird.isHidePipe(pipes.a,pipes.b)) {
				new Music("de.wav").start();
				STATU = GAMEOVER;
				mu.stop();
			}
			if (bird.isHideGround()) {
				new Music("de.wav").start();
				STATU = GAMEOVER;
				mu.stop();
			}
			if(bird.pass(pipes.a,pipes.b))
				score++;
			// 2.绘制管子
			pipes.paint(g);
			//绘制分数
			Font font = new Font(Font.MONOSPACED, Font.BOLD, 30);
			g.setFont(font);
			g.setColor(Color.ORANGE);
			g.drawString("得分：" + score , 30, 50);

			// 3.绘制草地
			background.paintground(g);
			// 4.绘制鸟
			bird.paint(g);

		}
		// 5.绘制游戏状态
		status.paint(g);
	}
}
