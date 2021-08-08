package wadapi.codec;

import java.nio.charset.StandardCharsets;

/**
 * @author Zom-B
 */
// Created 2021-08-04
public enum NodeFormat {
	DOOM(""),
	XNOD("XNOD"),
	ZNOD("ZNOD"),
	ZGLN("ZGLN"),
	ZGL2("ZGL2"),
	ZGL3("ZGL3"),
	XGLN("XGLN"),
	XGL2("XGL2"),
	XGL3("XGL3"),
	XND4("xNd4\0\0\0\0");

	private final int[] signature;

	NodeFormat(String signature) {
		this.signature = new int[signature.length() / 4];
		for (int i = 0; i < this.signature.length; i++) {
			byte[] bytes = signature.substring(i * 4, (i + 1) * 4).getBytes(StandardCharsets.ISO_8859_1);
			this.signature[i] = bytes[0] |
			                    bytes[1] << 8 |
			                    bytes[2] << 16 |
			                    bytes[3] << 24;
		}
	}

	public int[] getSignature() {
		return signature.clone();
	}
}
