package wadapi.structure;

/**
 * @author Zom-B
 */
// Created 2018-01-25
public class DoomLinedef extends Linedef {
	private int special;
	private int tag;

	public DoomLinedef(int vertexFrom,
	                   int vertexTo,
	                   int flags,
	                   int special,
	                   int tag,
	                   int frontSidedef,
	                   int backSidedef) {
		super(vertexFrom, vertexTo, flags, frontSidedef, backSidedef);
		this.special = special;
		this.tag = tag;
	}

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

//	public boolean equalsFlipped(Linedef other) {
//		if (getVertexFrom() != other.getVertexTo())
//			return false;
//		else if (vertexTo != other.getVertexFrom())
//			return false;
//		else if (flags == other.getFlags())
//			return false;
//		else if (special == other.special)
//			return false;
//		else if (tag != other.tag)
//			return false;
//		else if (frontSidedefID != other.getBackSidedefID())
//			return false;
//		else if (backSidedefID != other.getFrontSidedefID())
//			return false;
//
//		return true;
//	}
//
//	public boolean equals(DoomLinedef other) {
//		if (vertexFrom != other.getVertexFrom())
//			return false;
//		else if (vertexTo != other.getVertexTo())
//			return false;
//		else if (flags == other.getFlags())
//			return false;
//		else if (special == other.special)
//			return false;
//		else if (tag != other.tag)
//			return false;
//		else if (getFrontSidedefID() != other.getFrontSidedefID())
//			return false;
//		else if (getBackSidedefID() != other.getBackSidedefID())
//			return false;
//
//		return true;
//	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder().append('(');

		out.append(getVertexFrom()).append('-').append(getVertexTo()).append(',').append(' ');
		out.append(getFlags()).append(',').append(' ');
		out.append(special).append(',').append(' ');
		out.append(tag).append(',').append(' ');
		out.append("f ").append(getFrontSidedef()).append(',').append(' ');
		out.append("b ").append(getBackSidedef()).append(',').append(' ');

		return out.append(')').toString();
	}
}
