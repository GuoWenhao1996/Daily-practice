

import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class GameStatus {
	private BufferedImage start;
	private BufferedImage over;

	public GameStatus() {
		start = R.lode("start.png");
		over = R.lode("gameover.png");
	}

	public void paint(Graphics g) {
		if (GamePanel.STATU == GamePanel.READY) {
			// 开始
			g.drawImage(start, 0, 0, null);
		} else if (GamePanel.STATU == GamePanel.GAMEOVER) {
			// 游戏结束
			g.drawImage(over, 0, 0, null);
		}
	}
}
