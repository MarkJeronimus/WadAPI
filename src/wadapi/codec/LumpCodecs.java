package wadapi.codec;

import org.digitalmodular.utilities.annotation.UtilityClass;

import wadapi.LumpType;
import wadapi.lump.Lump;

/**
 * @author Zom-B
 */
// Created 2017-09-01
@UtilityClass
public final class LumpCodecs {
	private LumpCodecs() {
		throw new AssertionError();
	}
	public static LumpCodec<? extends Lump> getCodec(LumpType type, int size) {
		switch (type) {
			case BEHAVIOR:
			case UNASSIGNED:
			case BLOCKMAP:
			case REJECT:
				return BinaryCodec.INSTANCE;
			case SPRITE:
				return SpriteCodec.INSTANCE;
			case FLAT:
				return FlatCodec.INSTANCE;
			case LINEDEFS:
				return LinedefsCodec.INSTANCE;
			case MAP:
			case MARKER:
				return size > 0 ? BinaryCodec.INSTANCE : MarkerCodec.INSTANCE;
			case NODES:
				return NodesCodec.INSTANCE;
			case PLAYPAL:
				return PaletteCodec.INSTANCE;
			case PATCH:
				return PatchCodec.INSTANCE;
			case PNAMES:
				return PatchNamesCodec.INSTANCE;
			case SECTORS:
				return SectorsCodec.INSTANCE;
			case SEGS:
				return SegmentsCodec.INSTANCE;
			case SIDEDEFS:
				return SidedefsCodec.INSTANCE;
			case SSECTORS:
				return SubSectorsCodec.INSTANCE;
			case SCRIPTS:
			case TEXT:
				return TextCodec.INSTANCE;
			case TEXTUREX:
				return TextureXCodec.INSTANCE;
			case THINGS:
				return ThingsCodec.INSTANCE;
			case VERTEXES:
				return VerticesCodec.INSTANCE;
			default:
				throw new AssertionError("Unknown LumpType: " + type);
		}
	}
}
