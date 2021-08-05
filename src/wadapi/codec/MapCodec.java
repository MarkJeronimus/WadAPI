package wadapi.codec;

import org.jetbrains.annotations.Nullable;

import org.digitalmodular.utilities.annotation.UtilityClass;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import wadapi.FileBuffer;
import wadapi.LumpType;
import wadapi.LumpUtilities;
import wadapi.WadMap;
import wadapi.io.LumpPointer;
import wadapi.io.MapPointers;
import wadapi.lump.FileBufferLump;
import wadapi.lump.Lump;

/**
 * @author Zom-B
 */
// Created 2021-08-02
@UtilityClass
public final class MapCodec {
	private MapCodec() {
		throw new AssertionError();
	}

	public static WadMap makeMap(MapPointers mapPointers) {
		requireNonNull(mapPointers, "mapPointers");

		for (LumpPointer mapPointer : mapPointers)
			decodeLump(mapPointer);

		boolean isHexenFormat = mapPointers.getBehaviorPointer() != null;

		WadMapBuilder builder = new WadMapBuilder();
		builder.setMapLump(mapPointers.getMapTagPointer().getLump());
		builder.setThingsLump(mapPointers.getThingsPointer().getLump());
		builder.setLinedefsLump(mapPointers.getLinedefsPointer().getLump());
		builder.setSidedefsLump(mapPointers.getSidedefsPointer().getLump());
		builder.setVerticesLump(mapPointers.getVerticesPointer().getLump());
		builder.setSegmentsLump(LumpPointer.getNullableLump(mapPointers.getSegmentsPointer()));
		builder.setSubsectorsLump(LumpPointer.getNullableLump(mapPointers.getSubsectorsPointer()));

		@Nullable LumpPointer nodesPointer = mapPointers.getNodesPointer();
		if (nodesPointer != null) {
			Lump nodesLump = nodesPointer.getLump();

			if (nodesLump instanceof FileBufferLump) {
				FileBufferLump rawNodesLump = (FileBufferLump)nodesLump;

				NodeFormat nodeFormat = getNodeFormat(rawNodesLump);
				switch (nodeFormat) {
					case DOOM:
						decodeDoomNodes(rawNodesLump, mapPointers, builder);
						break;
					case XNOD:
						decodeExtendedNodes(rawNodesLump, mapPointers, builder);
						break;
					case ZNOD:
					case ZGLN:
					case ZGL2:
					case ZGL3:
					case XGLN:
					case XGL2:
					case XGL3:
					case XND4:
						throw new UnsupportedOperationException("Not implemented yet: " + nodeFormat);
					default:
						throw new AssertionError("Unimplemented NodeFormat: " + nodeFormat);
				}
			} else {
				builder.setNodesLump(nodesLump);
				builder.setSectorsLump(mapPointers.getSectorsPointer().getLump());
				builder.setRejectLump(LumpPointer.getNullableLump(mapPointers.getRejectPointer()));
				builder.setBlockmapLump(LumpPointer.getNullableLump(mapPointers.getBlockmapPointer()));
				builder.setScriptsLump(LumpPointer.getNullableLump(mapPointers.getScriptsPointer()));
				builder.setBehaviorLump(LumpPointer.getNullableLump(mapPointers.getBehaviorPointer()));
			}
		}

		return builder.build();
	}

	private static void decodeLump(@Nullable LumpPointer lumpPointer) {
		if (lumpPointer == null)
			return;

		// Nodes are handled differently.
		Lump lump = lumpPointer.getLump();
		if (lump.getLumpType() == LumpType.NODES)
			return;

		Lump decodedLump = LumpUtilities.decodeLump(lump);
		lumpPointer.setLump(decodedLump);
	}

	private static NodeFormat getNodeFormat(FileBufferLump lump) {
		FileBuffer fileBuffer = lump.getFileBuffer();

		fileBuffer.rewind();
		double size       = fileBuffer.remaining();
		int    signature0 = size < 4 ? 0 : fileBuffer.getInt();
		int    signature1 = size < 8 ? 0 : fileBuffer.getInt();
		fileBuffer.rewind();

		NodeFormat[] nodeFormats = NodeFormat.values();
		for (int i = nodeFormats.length - 1; i >= 0; i--) {
			NodeFormat format = nodeFormats[i];

			if (signatureMatches(size, signature0, signature1, format))
				return format;
		}

		throw new AssertionError(size + ", " + signature0 + ", " + signature1);
	}

	private static boolean signatureMatches(double size, int signature0, int signature1, NodeFormat format) {
		int[] signature = format.getSignature();

		if (signature.length >= 2 && (size < 8 || signature[1] != signature1))
			return false;

		if (signature.length >= 1 && (size < 4 || signature[0] != signature0))
			return false;

		return true;
	}

	private static void decodeDoomNodes(FileBufferLump rawNodesLump, MapPointers mapPointers, WadMapBuilder builder) {
		builder.setNodesLump(DoomNodesCodec.decode(rawNodesLump));
		builder.setSectorsLump(mapPointers.getSectorsPointer().getLump());
		builder.setRejectLump(LumpPointer.getNullableLump(mapPointers.getRejectPointer()));
		builder.setBlockmapLump(LumpPointer.getNullableLump(mapPointers.getBlockmapPointer()));
		builder.setScriptsLump(LumpPointer.getNullableLump(mapPointers.getScriptsPointer()));
		builder.setBehaviorLump(LumpPointer.getNullableLump(mapPointers.getBehaviorPointer()));
	}

	private static void decodeExtendedNodes(
			FileBufferLump rawNodesLump, MapPointers mapPointers, WadMapBuilder builder) {
		ExtendedNodesCodec.decode(rawNodesLump, builder);

		builder.setSectorsLump(mapPointers.getSectorsPointer().getLump());
		builder.setRejectLump(LumpPointer.getNullableLump(mapPointers.getRejectPointer()));
		builder.setBlockmapLump(LumpPointer.getNullableLump(mapPointers.getBlockmapPointer()));
		builder.setScriptsLump(LumpPointer.getNullableLump(mapPointers.getScriptsPointer()));
		builder.setBehaviorLump(LumpPointer.getNullableLump(mapPointers.getBehaviorPointer()));
	}
}
