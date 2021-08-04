package wadapi.structure;

import org.jetbrains.annotations.Nullable;

import wadapi.ThingConstants;
import wadapi.ThingData;

/**
 * @author Zom-B
 */
// Created 2011-08-02
public class DoomThing extends Thing {
	public static final int FLAG_EASY            = 0x0001;
	public static final int FLAG_MEDIUM          = 0x0002;
	public static final int FLAG_HARD            = 0x0004;
	public static final int FLAG_AMBUSH          = 0x0008;
	public static final int FLAG_NOT_SINGLE      = 0x0010;
	public static final int FLAG_NOT_DEATHMATCH  = 0x0020;
	public static final int FLAG_NOT_COOPERATIVE = 0x0040;

	public DoomThing(int x, int y, int angle, int type, int flags) {
		super(x, y, angle, type, flags);
	}

	public boolean isEasy() {
		return (getFlags() & FLAG_EASY) != 0;
	}

	public boolean isMedium() {
		return (getFlags() & FLAG_MEDIUM) != 0;
	}

	public boolean isHard() {
		return (getFlags() & FLAG_HARD) != 0;
	}

	public boolean isAmbush() {
		return (getFlags() & FLAG_AMBUSH) != 0;
	}

	public boolean isSinglePlayer() {
		return (getFlags() & FLAG_NOT_SINGLE) == 0;
	}

	public boolean isDeathmatch() {
		return (getFlags() & FLAG_NOT_DEATHMATCH) == 0;
	}

	public boolean isCooperative() {
		return (getFlags() & FLAG_NOT_COOPERATIVE) == 0;
	}

	public boolean isNetwork() {
		return isDeathmatch() || isCooperative();
	}

	@Override
	public String toString() {
		@Nullable ThingData thingData = ThingConstants.getThingData(this);
		String              thingName = thingData == null ? Integer.toString(getType()) : thingData.getName();

		StringBuilder sb = new StringBuilder(128);
		sb.append('[').append(getType()).append(" (").append(thingName).append(')');
		sb.append(", x=").append(getX());
		sb.append(", y=").append(getY());
		sb.append(", angle=").append(getAngle());
		sb.append(", flags=").append(getFlags());
		if (getFlags() != 0) {
			sb.append(" (");

			boolean addComma = false;
			if (isEasy()) {
				sb.append("Easy");
				addComma = true;
			}

			if (isMedium()) {
				if (addComma)
					sb.append(", ");

				sb.append("Medium");
				addComma = true;
			}

			if (isHard()) {
				if (addComma)
					sb.append(", ");

				sb.append("Hard");
				addComma = true;
			}

			if (isAmbush()) {
				if (addComma)
					sb.append(", ");

				sb.append("Ambush");
				addComma = true;
			}

			if (isSinglePlayer()) {
				if (addComma)
					sb.append(", ");

				sb.append("SinglePlayer");
				addComma = true;
			}

			if (isDeathmatch()) {
				if (addComma)
					sb.append(", ");

				sb.append("Deathmatch");
				addComma = true;
			}

			if (isCooperative()) {
				if (addComma)
					sb.append(", ");

				sb.append("Cooperative");
			}

			sb.append(')');
		}

		return sb.append(']').toString();
	}
}
