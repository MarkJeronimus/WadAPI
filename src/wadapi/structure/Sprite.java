package wadapi.structure;

import java.awt.image.BufferedImage;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

/**
 * @author Zom-B
 */
// Created 2021-06-08
public class Sprite {
	private int           centerX;
	private int           centerY;
	private BufferedImage image;

	public Sprite(int centerX, int centerY, BufferedImage image) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.image = requireNonNull(image, "image");
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = requireNonNull(image, "image");
	}
}
