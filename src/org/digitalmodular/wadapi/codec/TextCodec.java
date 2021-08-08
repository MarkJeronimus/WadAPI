package wadapi.codec;

import org.digitalmodular.utilities.annotation.Singleton;

import wadapi.FileBuffer;
import wadapi.LumpType;
import wadapi.lump.FileBufferLump;
import wadapi.lump.TextLump;

/**
 * @author Zom-B
 */
// Created 2011-09-17
@Singleton
public class TextCodec extends LumpCodec<TextLump> {
	public static final TextCodec INSTANCE = new TextCodec();

	@Override
	public TextLump decode(FileBufferLump lump) {
		FileBuffer fileBuffer  = lump.getFileBuffer();
		int        maxTextSize = fileBuffer.remaining();

		TextLump textLump = new TextLump(lump.getName(), LumpType.TEXT, maxTextSize);

		StringBuilder text = textLump.getText();
		for (int i = 0; i < maxTextSize; i++) {
			int c = fileBuffer.getUnsignedByte();
			if (c != '\r')
				text.append((char)c);
		}

		return textLump;
	}

	@Override
	public void encode(TextLump textLump, FileBuffer buffer) {
		StringBuilder text = textLump.getText();

		int lumpSize = text.length();
		for (int i = 0; i < lumpSize; i++) {
			int c = text.charAt(i);

			if (c == '\n')
				buffer.putUnsignedByte('\r');

			buffer.putUnsignedByte(c);
		}
	}
}
