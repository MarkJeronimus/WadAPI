package wadapi.lump;

import java.awt.image.BufferedImage;
import java.util.List;

import wadapi.structure.Palette;
import wadapi.structure.Sprite;
import wadapi.structure.SpritePost;
import static wadapi.LumpType.SPRITE;

/**
 * @author Zom-B
 */
// Created 2021-06-07
public class SpriteLump extends Lump {
	private       int                    height;
	private       int                    leftOffset;
	private       int                    topOffset;
	private final List<List<SpritePost>> columns;

	public SpriteLump(String name, int height, int leftOffset, int topOffset, List<List<SpritePost>> columns) {
		super(name, SPRITE);

		this.height = height;
		this.leftOffset = leftOffset;
		this.topOffset = topOffset;
		this.columns = columns;
	}

	public int getWidth() {
		return columns.size();
	}

	public int getHeight() {
		return height;
	}

	public int getLeftOffset() {
		return leftOffset;
	}

	public int getTopOffset() {
		return topOffset;
	}

	public List<List<SpritePost>> getColumns() {
		return columns;
	}

	public Sprite renderSprite(Palette palette) {
		BufferedImage image = new BufferedImage(columns.size(), height, BufferedImage.TYPE_INT_ARGB);

		for (int x = 0; x < columns.size(); x++) {
			List<SpritePost> column = columns.get(x);
			for (SpritePost spritePost : column) {
				int    y    = spritePost.getTopDelta();
				byte[] data = spritePost.getData();

				for (byte index : data) {
					if (y >= height)
						break;

					image.setRGB(x, y, palette.get(index & 0xFF));
					y++;
				}
			}
		}

		return new Sprite(leftOffset, topOffset, image);
	}
}
