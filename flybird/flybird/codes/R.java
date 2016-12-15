
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class R {
/*
 * ∂¡»ÎÕº∆¨◊ ‘¥
 */
	public static BufferedImage lode(String file){
		try{
		return ImageIO.read(R.class.getResourceAsStream("/"+file));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
