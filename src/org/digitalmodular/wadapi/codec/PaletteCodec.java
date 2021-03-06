package org.digitalmodular.wadapi.codec;

import java.util.List;

import org.digitalmodular.utilities.annotation.Singleton;

import org.digitalmodular.wadapi.FileBuffer;
import org.digitalmodular.wadapi.LumpUtilities;
import org.digitalmodular.wadapi.lump.FileBufferLump;
import org.digitalmodular.wadapi.lump.PaletteLump;
import org.digitalmodular.wadapi.structure.Palette;

/**
 * @author Zom-B
 */
// Created 2011-09-12
@Singleton
public class PaletteCodec extends LumpCodec<PaletteLump> {
	public static final int PALETTE_FIELD_SIZE = 768;

	public static final PaletteCodec INSTANCE = new PaletteCodec();

	@Override
	public PaletteLump decode(FileBufferLump lump) {
		String     name       = lump.getName();
		FileBuffer fileBuffer = lump.getFileBuffer();

		int numPalettes = LumpUtilities.calcNumFields(fileBuffer.remaining(), PALETTE_FIELD_SIZE, name);

		PaletteLump palettesLump = new PaletteLump(name, numPalettes);

		List<Palette> palettes = palettesLump.getPalettes();
		for (int i = 0; i < numPalettes; i++) {
			Palette palette = readPalette(fileBuffer);
			palettes.add(palette);
		}

		return palettesLump;
	}

	@Override
	public void encode(PaletteLump palettesLump, FileBuffer buffer) {
		List<Palette> palettes = palettesLump.getPalettes();
		for (Palette palette : palettes)
			writePalette(palette, buffer);
	}

	private static Palette readPalette(FileBuffer buffer) {
		Palette palette = new Palette();

		for (int i = 0; i < 256; i++)
			palette.set(i, buffer.getColor());

		return palette;
	}

	private static void writePalette(Palette palette, FileBuffer buffer) {
		for (int i = 0; i < 256; i++)
			buffer.putColor(palette.get(i));
	}
}
