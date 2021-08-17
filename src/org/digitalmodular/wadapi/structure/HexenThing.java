package org.digitalmodular.wadapi.structure;

import java.io.IOException;

import org.digitalmodular.udbconfigreader.ConfigStruct;
import org.digitalmodular.wadapi.GameConfigurationLoader;
import org.digitalmodular.wadapi.GameResources;
import org.digitalmodular.wadapi.GameType;
import org.digitalmodular.wadapi.MapFormat;
import org.digitalmodular.wadapi.SourcePort;

/**
 * @author Zom-B
 */
// Created 2011-08-03
public class HexenThing extends Thing {
	public static final int FLAG_EASY            = 0x0001; // Thing is on skill levels 1 & 2
	public static final int FLAG_MEDIUM          = 0x0002; // Thing is on skill level 3
	public static final int FLAG_HARD            = 0x0004; // Thing is on skill levels 4 & 5
	public static final int FLAG_AMBUSH          = 0x0008; // Thing is waiting in ambush
	public static final int FLAG_DORMANT         = 0x0010; // Will not wake up until it's activated using Thing_Activate
	public static final int FLAG_FIGHTER         = 0x0020; // Thing appears to the Fighter class
	public static final int FLAG_CLERIC          = 0x0040; // Thing appears to the Cleric class
	public static final int FLAG_MAGE            = 0x0080; // Thing appears to the Mage class
	public static final int FLAG_NOT_SINGLE      = 0x0100; // Thing appears in single-player games
	public static final int FLAG_NOT_DEATHMATCH  = 0x0200; // Thing appears in cooperative games
	public static final int FLAG_NOT_COOPERATIVE = 0x0400; // Thing appears in deathmatch games

	private int tid;
	private int z;
	private int action;
	private int ar1;
	private int ar2;
	private int ar3;
	private int ar4;
	private int ar5;

	public HexenThing(int tid,
	                  int x,
	                  int y,
	                  int z,
	                  int angle,
	                  int type,
	                  int flags,
	                  int action,
	                  int ar1,
	                  int ar2,
	                  int ar3,
	                  int ar4,
	                  int ar5) {
		super(x, y, angle, type, flags);
		this.tid = tid;
		this.z = z;
		this.action = action;
		this.ar1 = ar1;
		this.ar2 = ar2;
		this.ar3 = ar3;
		this.ar4 = ar4;
		this.ar5 = ar5;
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

	public boolean isDormant() {
		return (getFlags() & FLAG_DORMANT) != 0;
	}

	public boolean isFighter() {
		return (getFlags() & FLAG_FIGHTER) != 0;
	}

	public boolean isCleric() {
		return (getFlags() & FLAG_CLERIC) != 0;
	}

	public boolean isMage() {
		return (getFlags() & FLAG_MAGE) != 0;
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

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getAr1() {
		return ar1;
	}

	public void setAr1(int ar1) {
		this.ar1 = ar1;
	}

	public int getAr2() {
		return ar2;
	}

	public void setAr2(int ar2) {
		this.ar2 = ar2;
	}

	public int getAr3() {
		return ar3;
	}

	public void setAr3(int ar3) {
		this.ar3 = ar3;
	}

	public int getAr4() {
		return ar4;
	}

	public void setAr4(int ar4) {
		this.ar4 = ar4;
	}

	public int getAr5() {
		return ar5;
	}

	public void setAr5(int ar5) {
		this.ar5 = ar5;
	}

	@Override
	public String toString() {
		String thingName;
		try {
			ConfigStruct gameConfig = GameConfigurationLoader.loadGameConfiguration(
					SourcePort.GZDOOM, GameType.DOOM, MapFormat.DOOM);
			thingName = new GameResources(gameConfig).getThingName(getType());
		} catch (IOException | IllegalArgumentException ignored) {
			thingName = "";
		}

		StringBuilder sb = new StringBuilder(128);
		sb.append('[').append(getType());

		if (!thingName.isEmpty())
			sb.append(" (").append(thingName).append(')');

		sb.append(", x=").append(getX() / 65536.0);
		sb.append(", y=").append(getY() / 65536.0);
		sb.append(", z=").append(getZ() / 65536.0);
		sb.append(", angle=").append(getAngle() * 180.0f / 2147483648.0f);
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

			if (isDormant()) {
				if (addComma)
					sb.append(", ");

				sb.append("Dormant");
				addComma = true;
			}

			if (isFighter()) {
				if (addComma)
					sb.append(", ");

				sb.append("Fighter");
				addComma = true;
			}

			if (isCleric()) {
				if (addComma)
					sb.append(", ");

				sb.append("Cleric");
				addComma = true;
			}

			if (isMage()) {
				if (addComma)
					sb.append(", ");

				sb.append("Mage");
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

		sb.append(", tid=").append(getTid());
		sb.append(", sp=").append(getAction());
		sb.append(", a1=").append(getAr1());
		sb.append(", a2=").append(getAr2());
		sb.append(", a3=").append(getAr3());
		sb.append(", a4=").append(getAr4());
		sb.append(", a5=").append(getAr5());

		return sb.append(']').toString();
	}
}
