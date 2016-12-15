
import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Pipe {
	private BufferedImage uppipe;
	private BufferedImage downpipe;
	public int x = 0;
	public int w = 0;
	private int upy = 0;
	private int downy = 0;
	public int distance = 0;
	private GamePanel gp;
	public int temp;

	public Pipe(GamePanel gp) {
		this.gp = gp;
		distance = 100;
		uppipe = R.lode("up.png");
		downpipe = R.lode("down.png");
		w = uppipe.getWidth();
		reset();
	}

	private void reset() {
		// distance--;
		x = 0;
		randomY();
	}

	/*
	 * 随机管道位置
	 */
	public void randomY() {
		temp = MyRandom(10, gp.getSkyHeigh() - distance - 10);
		upy = temp - uppipe.getHeight();
		downy = temp + distance;
	}

	/*
	 * 返回a和b之间的随机数
	 * 
	 */
	private static int MyRandom(int a, int b) {
		return ((int) (Math.random() * Math.abs(a - b))) + Math.min(a, b);
	}

	public void paint(Graphics g) {
		// x = x - 10;
		x--;
		g.drawImage(uppipe, x, upy, null);
		g.drawImage(downpipe, x, downy, null);
	}
}
