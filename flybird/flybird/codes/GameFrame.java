import javax.swing.JFrame;

public class GameFrame extends JFrame {
	public GameFrame() {
		init();
	}

	private void init() {
		this.setTitle("һֻСС��");
		this.setSize(320, 480);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new GamePanel());
	}
}
