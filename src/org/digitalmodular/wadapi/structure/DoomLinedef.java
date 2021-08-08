package org.digitalmodular.wadapi.structure;

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
		StringBuilder sb = new StringBuilder(128);

		sb.append('[').append(getVertexFrom()).append('-').append(getVertexTo());
		sb.append(", f=").append(getFrontSidedef());
		sb.append(", b=").append(getBackSidedef());
		sb.append(", special=").append(special);
		sb.append(", tag=").append(tag);
		sb.append(", flags=").append(getFlags());
		if (getFlags() != 0) {
			sb.append(" (");

			boolean addComma = false;
			if (isImpassable()) {
				sb.append("Impassable");
				addComma = true;
			}

			if (isBlock_monster()) {
				if (addComma)
					sb.append(", ");

				sb.append("Block monster");
				addComma = true;
			}

			if (isDouble_sided()) {
				if (addComma)
					sb.append(", ");

				sb.append("Double sided");
				addComma = true;
			}

			if (isUpper_unpegged()) {
				if (addComma)
					sb.append(", ");

				sb.append("Upper unpegged");
				addComma = true;
			}

			if (isLower_unpegged()) {
				if (addComma)
					sb.append(", ");

				sb.append("Lower unpegged");
				addComma = true;
			}

			if (isSecret()) {
				if (addComma)
					sb.append(", ");

				sb.append("Secret");
				addComma = true;
			}

			if (isBlock_sound()) {
				if (addComma)
					sb.append(", ");

				sb.append("Block sound");
			}

			if (isHidden()) {
				if (addComma)
					sb.append(", ");

				sb.append("Hidden");
			}

			if (isShown()) {
				if (addComma)
					sb.append(", ");

				sb.append("Shown");
			}

			sb.append(')');
		}

		return sb.append(']').toString();
	}
}
