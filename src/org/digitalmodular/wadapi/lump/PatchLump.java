package org.digitalmodular.wadapi.lump;

import static org.digitalmodular.utilities.ValidatorUtilities.requireArrayLengthExactly;
import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;

import org.digitalmodular.wadapi.LumpType;

/**
 * @author Zom-B
 */
// Created 2011-08-05
public class PatchLump extends Lump {
	private int   width;   // 2
	private int   height;  // 2
	private int   xOffset; // 2
	private int   yOffset; // 2
	private int[] pixels;
//	public  short patch;
//	public  short stepDir;
//	public  short colorMap;

	public PatchLump(String name, int width, int height, int xOffset, int yOffset, int[] pixels) {
		super(name, LumpType.PATCH);

		this.width = requireAtLeast(1, width, "width");
		this.height = requireAtLeast(1, height, "height");
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		requireArrayLengthExactly(width * height, pixels, "pixels");
		this.pixels = pixels;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getXOffset() {
		return xOffset;
	}

	public void setXOffset(int xOffset) {
		this.xOffset = xOffset;
	}

	public int getYOffset() {
		return yOffset;
	}

	public void setYOffset(int yOffset) {
		this.yOffset = yOffset;
	}

	public int[] getPixels() {
		return pixels;
	}

	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}

//	public BufferedImage getBitmap(Palette palette) {
//		if (img == null) {
//			int[] pal = palette.palette[0];
//
//			img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//			img.setAccelerationPriority(0);
//
//			int[] pixels = ((IntegerInterleavedRaster)img.getRaster()).getDataStorage();
//
//			int p = 0;
//			for (int y = 0; y < height; y++) {
//				for (int x = 0; x < width; x++) {
//					int c = grid[y][x];
//					pixels[p++] = c == -1 ? 0x00000000 : pal[c];
//				}
//			}
//		}
//
//		return img;
//	}
}
