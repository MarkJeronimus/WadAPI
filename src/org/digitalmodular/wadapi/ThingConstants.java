package org.digitalmodular.wadapi;

import java.awt.Color;

import org.jetbrains.annotations.Nullable;

import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

import org.digitalmodular.wadapi.structure.Thing;

/**
 * @author Zom-B
 */
// Created 2021-06-13
@SuppressWarnings("LongLine")
public class ThingConstants {
	static final Color[] COLORS = {null,
	                               new Color(61, 99, 212),
	                               new Color(32, 131, 32),
	                               new Color(90, 167, 160),
	                               new Color(167, 32, 32),
	                               null,
	                               new Color(173, 126, 10),
	                               new Color(231, 231, 231),
	                               new Color(167, 32, 32),
	                               new Color(0, 180, 240),
	                               new Color(47, 193, 47),
	                               new Color(165, 224, 224),
	                               new Color(240, 93, 67),
	                               new Color(224, 122, 224),
	                               new Color(240, 240, 0),
	                               new Color(231, 231, 231),
	                               new Color(255, 0, 0)};

	private static final ThingConstants DOOM  = new ThingConstants();
	private static final ThingConstants HEXEN = new ThingConstants();

	static {
		commonThings(DOOM);
		commonThings(HEXEN);
		doomThings();
		hexenThings();
	}

	private static void commonThings(ThingConstants game) {
		// @formatter:off
		game.add(32000, ThingType.EDITOR     , 0, 15, true ,  16,   0, false, false, null      , "Visual Mode camera");
		// @formatter:on
	}

	private static void doomThings() {
		// @formatter:off
		DOOM.add(    1, ThingType.PLAYER      ,  0, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 1 start");
		DOOM.add(    2, ThingType.PLAYER      ,  1, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 2 start");
		DOOM.add(    3, ThingType.PLAYER      ,  2, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 3 start");
		DOOM.add(    4, ThingType.PLAYER      ,  3, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 4 start");
		DOOM.add( 4001, ThingType.PLAYER      ,  4, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 5 start");
		DOOM.add( 4002, ThingType.PLAYER      ,  5, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 6 start");
		DOOM.add( 4003, ThingType.PLAYER      ,  6, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 7 start");
		DOOM.add( 4004, ThingType.PLAYER      ,  7, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 8 start");
		DOOM.add(   11, ThingType.PLAYER      ,  8, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player Deathmatch start");
		DOOM.add( 5080, ThingType.PLAYER      ,  9, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player Blue start (ST/CTF)");
		DOOM.add( 5081, ThingType.PLAYER      , 10, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player Red start (ST/CTF)");
		DOOM.add( 5082, ThingType.PLAYER      , 11, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player Temporary start (ST/CTF)");

		DOOM.add(   14, ThingType.TELEPORT    ,  0,  2, true ,  16,  56, false, false, "TFOGA0"  , "Teleport Destination");
		DOOM.add( 9044, ThingType.TELEPORT    ,  1,  2, true ,  16,  56, false, false, "TFOGB0"  , "Teleport (Z Height)");
		DOOM.add( 9043, ThingType.TELEPORT    ,  2,  2, true ,  16,  56, false, false, "TFOGB0"  , "Teleport (Z Height and Gravity)");

		DOOM.add( 3004, ThingType.MONSTER     ,  0, 12, true ,  20,  56, false, true , "POSSA1"  , "Zombieman");
		DOOM.add( 9061, ThingType.MONSTER     ,  1, 12, true ,  20,  56, false, true , "POSSA1"  , "Zombieman (stealth)");
		DOOM.add(    9, ThingType.MONSTER     ,  2, 12, true ,  20,  56, false, true , "SPOSA1"  , "Shotgun guy");
		DOOM.add( 9060, ThingType.MONSTER     ,  3, 12, true ,  20,  56, false, true , "SPOSA1"  , "Shotgun guy (stealth)");
		DOOM.add( 5005, ThingType.MONSTER     ,  4, 12, true ,  20,  56, false, true , "GPOSA1"  , "Super Shotgun guy");
		DOOM.add(   84, ThingType.MONSTER     ,  5, 12, true ,  20,  56, false, true , "SSWVA1"  , "Wolfenstein SS");
		DOOM.add( 3001, ThingType.MONSTER     ,  6, 12, true ,  20,  56, false, true , "TROOA1"  , "Imp");
		DOOM.add( 9057, ThingType.MONSTER     ,  7, 12, true ,  20,  56, false, true , "TROOA1"  , "Imp (stealth)");
		DOOM.add( 5003, ThingType.MONSTER     ,  8, 12, true ,  20,  56, false, true , "DIMPA1"  , "Dark Imp");
		DOOM.add( 3002, ThingType.MONSTER     ,  9, 12, true ,  30,  56, false, true , "SARGA1"  , "Demon");
		DOOM.add( 9055, ThingType.MONSTER     , 10, 12, true ,  30,  56, false, true , "SARGA1"  , "Demon (stealth)");
		DOOM.add(   58, ThingType.MONSTER     , 11, 12, true ,  30,  56, false, true , "SARGA1"  , "Spectre");
		DOOM.add( 5004, ThingType.MONSTER     , 12, 12, true ,  30,  56, false, true , "SRG2A1"  , "Blood Demon");
		DOOM.add( 3006, ThingType.MONSTER     , 13, 12, true ,  16,  56, false, true , "SKULA1"  , "Lost Soul");
		DOOM.add( 3005, ThingType.MONSTER     , 14, 12, true ,  31,  56, false, true , "HEADA1"  , "Cacodemon");
		DOOM.add( 9053, ThingType.MONSTER     , 15, 12, true ,  31,  56, false, true , "HEADA1"  , "Cacodemon (stealth)");
		DOOM.add( 5006, ThingType.MONSTER     , 16, 12, true ,  31,  56, false, true , "HED2A1"  , "Cacolantern");
		DOOM.add( 5015, ThingType.MONSTER     , 17, 12, true ,  31,  56, false, true , "HED3A1"  , "Abaddon");
		DOOM.add(   69, ThingType.MONSTER     , 18, 12, true ,  24,  64, false, true , "BOS2A1C1", "Hell Knight");
		DOOM.add( 9056, ThingType.MONSTER     , 19, 12, true ,  24,  64, false, true , "BOS2A1C1", "Hell Knight (stealth)");
		DOOM.add( 3003, ThingType.MONSTER     , 20, 12, true ,  24,  64, false, true , "BOSSA1"  , "Baron of Hell");
		DOOM.add( 9052, ThingType.MONSTER     , 21, 12, true ,  24,  64, false, true , "BOSSA1"  , "Baron of Hell (stealth)");
		DOOM.add( 5008, ThingType.MONSTER     , 22, 12, true ,  24,  56, false, true , "BOS3A1"  , "Belphegor");
		DOOM.add(   68, ThingType.MONSTER     , 23, 12, true ,  64,  64, false, true , "BSPIA1D1", "Arachnotron");
		DOOM.add( 9050, ThingType.MONSTER     , 24, 12, true ,  64,  64, false, true , "BSPIA1D1", "Arachnotron (stealth)");
		DOOM.add(   71, ThingType.MONSTER     , 25, 12, true ,  31,  56, false, true , "PAINA1"  , "Pain Elemental");
		DOOM.add(   66, ThingType.MONSTER     , 26, 12, true ,  20,  56, false, true , "SKELA1D1", "Revenant");
		DOOM.add( 9059, ThingType.MONSTER     , 27, 12, true ,  20,  56, false, true , "SKELA1D1", "Revenant (stealth)");
		DOOM.add(   67, ThingType.MONSTER     , 28, 12, true ,  48,  64, false, true , "FATTA1"  , "Mancubus");
		DOOM.add( 9058, ThingType.MONSTER     , 29, 12, true ,  48,  64, false, true , "FATTA1"  , "Mancubus (stealth)");
		DOOM.add( 5007, ThingType.MONSTER     , 30, 12, true ,  48,  56, false, true , "HECTA1"  , "Hectebus");
		DOOM.add(   64, ThingType.MONSTER     , 31, 12, true ,  20,  56, false, true , "VILEA1D1", "Arch-vile");
		DOOM.add( 9051, ThingType.MONSTER     , 32, 12, true ,  20,  56, false, true , "VILEA1D1", "Arch-vile (stealth)");
		DOOM.add(    7, ThingType.MONSTER     , 33, 12, true , 128, 100, false, true , "SPIDA1D1", "Spider Mastermind");
		DOOM.add(   16, ThingType.MONSTER     , 34, 12, true ,  40, 110, false, true , "CYBRA1"  , "Cyberdemon");
		DOOM.add(   65, ThingType.MONSTER     , 35, 12, true ,  20,  56, false, true , "CPOSA1"  , "Heavy weapon dude");
		DOOM.add( 9054, ThingType.MONSTER     , 36, 12, true ,  20,  56, false, true , "CPOSA1"  , "Heavy weapon dude (stealth)");
		DOOM.add(   88, ThingType.MONSTER     , 37, 12, true ,  16,  16, false, true , "BBRNA0"  , "Icon of Sin");
		DOOM.add(   89, ThingType.MONSTER     , 38, 12, true ,  20,  32, false, true , "BOSFB0"  , "Monsters Spawner");
		DOOM.add(   87, ThingType.MONSTER     , 39, 12, true ,  20,  32, false, true , "TFOGB0"  , "Monsters Target");
		DOOM.add(   72, ThingType.MONSTER     , 40, 12, true ,  16,  72, true , true , "KEENA0"  , "Commander Keen");
		DOOM.add( 2035, ThingType.MONSTER     , 41,  3, false,  10,  32, false, true , "BAR1A0"  , "Barrel");

		DOOM.add( 2005, ThingType.WEAPON      ,  0, 14, false,  20,  25, false, false, "CSAWA0"  , "Chainsaw");
		DOOM.add( 5010, ThingType.WEAPON      ,  1, 14, false,  20,  25, false, false, "PISTA0"  , "Pistol");
		DOOM.add( 2001, ThingType.WEAPON      ,  2, 14, false,  20,  25, false, false, "SHOTA0"  , "Shotgun");
		DOOM.add(   82, ThingType.WEAPON      ,  3, 14, false,  20,  25, false, false, "SGN2A0"  , "Super Shotgun");
		DOOM.add( 2002, ThingType.WEAPON      ,  4, 14, false,  20,  25, false, false, "MGUNA0"  , "Chaingun");
		DOOM.add( 5014, ThingType.WEAPON      ,  5, 14, false,  20,  25, false, false, "MNGNA0"  , "Minigun");
		DOOM.add( 2003, ThingType.WEAPON      ,  6, 14, false,  20,  25, false, false, "LAUNA0"  , "Rocket launcher");
		DOOM.add( 5011, ThingType.WEAPON      ,  7, 14, false,  20,  25, false, false, "GLAUA0"  , "Grenade launcher");
		DOOM.add( 2004, ThingType.WEAPON      ,  8, 14, false,  20,  25, false, false, "PLASA0"  , "Plasma gun");
		DOOM.add( 5012, ThingType.WEAPON      ,  9, 14, false,  20,  25, false, false, "RAILA0"  , "Railgun");
		DOOM.add( 2006, ThingType.WEAPON      , 10, 14, false,  20,  30, false, false, "BFUGA0"  , "BFG9000");
		DOOM.add( 5013, ThingType.WEAPON      , 11, 14, false,  20,  25, false, false, "BFG2A0"  , "BFG10000");

		DOOM.add( 2007, ThingType.AMMO        ,  0,  6, false,  20,  16, false, false, "CLIPA0"  , "Ammo clip");
		DOOM.add( 2048, ThingType.AMMO        ,  1,  6, false,  20,  16, false, false, "AMMOA0"  , "Box of Ammo");
		DOOM.add( 2008, ThingType.AMMO        ,  2,  6, false,  20,  16, false, false, "SHELA0"  , "Shotgun shells");
		DOOM.add( 2049, ThingType.AMMO        ,  3,  6, false,  20,  16, false, false, "SBOXA0"  , "Box of Shells");
		DOOM.add( 2010, ThingType.AMMO        ,  4,  6, false,  20,  16, false, false, "ROCKA0"  , "Rocket");
		DOOM.add( 2046, ThingType.AMMO        ,  5,  6, false,  20,  25, false, false, "BROKA0"  , "Box of Rockets");
		DOOM.add( 2047, ThingType.AMMO        ,  6,  6, false,  20,  16, false, false, "CELLA0"  , "Cell charge");
		DOOM.add(   17, ThingType.AMMO        ,  7,  6, false,  20,  25, false, false, "CELPA0"  , "Cell charge pack");
		DOOM.add(    8, ThingType.AMMO        ,  8,  6, false,  20,  16, false, false, "BPAKA0"  , "Backpack");

		DOOM.add( 2014, ThingType.HEALTH      ,  0,  1, false,  20,  16, false, false, "BON1A0"  , "Health bonus");
		DOOM.add( 5090, ThingType.HEALTH      ,  1,  1, false,  20,  16, false, false, "BON3A0"  , "Max. health bonus");
		DOOM.add( 2011, ThingType.HEALTH      ,  2,  1, false,  20,  16, false, false, "STIMA0"  , "Stimpack");
		DOOM.add( 2012, ThingType.HEALTH      ,  3,  1, false,  20,  25, false, false, "MEDIA0"  , "Medikit");
		DOOM.add( 2015, ThingType.HEALTH      ,  4,  1, false,  20,  16, false, false, "BON2A0"  , "Armor bonus");
		DOOM.add( 5091, ThingType.HEALTH      ,  5,  1, false,  20,  16, false, false, "BON4A0"  , "Max. armor bonus");
		DOOM.add( 2018, ThingType.HEALTH      ,  6,  1, false,  20,  16, false, false, "ARM1A0"  , "Green armor");
		DOOM.add( 2019, ThingType.HEALTH      ,  7,  1, false,  20,  16, false, false, "ARM2A0"  , "Blue armor");
		DOOM.add( 5040, ThingType.HEALTH      ,  8,  1, false,  20,  16, false, false, "ARM3A0"  , "Red armor");

		DOOM.add( 2023, ThingType.POWERUP     ,  0,  9, false,  20,  16, false, false, "PSTRA0"  , "Berserk");
		DOOM.add( 2013, ThingType.POWERUP     ,  1,  9, false,  20,  45, false, false, "SOULA0"  , "Soulsphere");
		DOOM.add( 2025, ThingType.POWERUP     ,  2,  9, false,  20,  60, false, false, "SUITA0"  , "Radiation suit");
		DOOM.add( 2024, ThingType.POWERUP     ,  3,  9, false,  20,  45, false, false, "PINSA0"  , "Invisibility");
		DOOM.add( 2045, ThingType.POWERUP     ,  4,  9, false,  20,  16, false, false, "PVISA0"  , "Lite Amplification goggles");
		DOOM.add( 2022, ThingType.POWERUP     ,  5,  9, false,  20,  30, false, false, "PINVA0"  , "Invulnerability");
		DOOM.add(   83, ThingType.POWERUP     ,  6,  9, false,  20,  40, false, false, "MEGAA0"  , "Megasphere");
		DOOM.add( 2026, ThingType.POWERUP     ,  7,  9, false,  20,  35, false, false, "PMAPA0"  , "Computer map");
		DOOM.add( 5036, ThingType.POWERUP     ,  8,  9, false,  20,  45, false, false, "DOOMA0"  , "Doomsphere");
		DOOM.add( 5035, ThingType.POWERUP     ,  9,  9, false,  20,  45, false, false, "INVSA0"  , "Invisibility sphere");
		DOOM.add( 5030, ThingType.POWERUP     , 10,  9, false,  20,  45, false, false, "TURBA0"  , "Turbosphere");
		DOOM.add( 5032, ThingType.POWERUP     , 11,  9, false,  20,  45, false, false, "TIMEA0"  , "Time freeze sphere");
		DOOM.add( 5039, ThingType.POWERUP     , 12,  9, false,  20,  45, false, false, "DOOMA0"  , "Random POWERUP");

		DOOM.add(    5, ThingType.KEY         ,  0, 13, false,   8,  16, false, false, "BKEYA0"  , "Blue keycard");
		DOOM.add(   40, ThingType.KEY         ,  1, 13, false,   8,  16, false, false, "BSKUA0"  , "Blue skullkey");
		DOOM.add(    6, ThingType.KEY         ,  2, 13, false,   8,  16, false, false, "YKEYA0"  , "Yellow keycard");
		DOOM.add(   39, ThingType.KEY         ,  3, 13, false,   8,  16, false, false, "YSKUA0"  , "Yellow skullkey");
		DOOM.add(   13, ThingType.KEY         ,  4, 13, false,   8,  16, false, false, "RKEYA0"  , "Red keycard");
		DOOM.add(   38, ThingType.KEY         ,  5, 13, false,   8,  16, false, false, "RSKUA0"  , "Red skullkey");

		DOOM.add( 5102, ThingType.RUNE        ,  0,  9, false,  20,  45, false, false, "DRARA0"  , "Drain");
		DOOM.add( 5109, ThingType.RUNE        ,  1,  9, false,  20,  45, false, false, "HASRA0"  , "Haste");
		DOOM.add( 5108, ThingType.RUNE        ,  2,  9, false,  20,  45, false, false, "HIJRA0"  , "High Jumper");
		DOOM.add( 5106, ThingType.RUNE        ,  3,  9, false,  20,  45, false, false, "PRSRA0"  , "Prosperity");
		DOOM.add( 5101, ThingType.RUNE        ,  4,  9, false,  20,  45, false, false, "RAGRA0"  , "Rage");
		DOOM.add( 5107, ThingType.RUNE        ,  5,  9, false,  20,  45, false, false, "REFRA0"  , "Reflection");
		DOOM.add( 5105, ThingType.RUNE        ,  6,  9, false,  20,  45, false, false, "REGRA0"  , "Regeneration");
		DOOM.add( 5104, ThingType.RUNE        ,  7,  9, false,  20,  45, false, false, "RESRA0"  , "Resistance");
		DOOM.add( 5103, ThingType.RUNE        ,  8,  9, false,  20,  45, false, false, "SPRRA0"  , "Spread");
		DOOM.add( 5100, ThingType.RUNE        ,  9,  9, false,  20,  45, false, false, "STRRA0"  , "Strength");

		DOOM.add( 5130, ThingType.FLAG        ,  0, 13, false,  20,  20, false, false, "BFLAA0"  , "Blue flag");
		DOOM.add( 5131, ThingType.FLAG        ,  1, 13, false,  20,  20, false, false, "RFLAA0"  , "Red flag");
		DOOM.add( 5132, ThingType.FLAG        ,  2, 13, false,  20,  20, false, false, "WFLAA0"  , "White flag");

		DOOM.add( 5020, ThingType.SCORE_PILLAR,  0,  3, false,  20,  20, false, true , "HLSPA0"  , "Hell Pillar");
		DOOM.add( 5021, ThingType.SCORE_PILLAR,  1,  3, false,  20,  20, false, true , "HLSPA0"  , "Gothic Pillar");
		DOOM.add( 5022, ThingType.SCORE_PILLAR,  2,  3, false,  20,  20, false, true , "HLSPA0"  , "Starbase Pillar");
		DOOM.add( 5023, ThingType.SCORE_PILLAR,  3,  3, false,  20,  20, false, true , "HLSPA0"  , "Military Pillar");
		DOOM.add( 5024, ThingType.SCORE_PILLAR,  4,  3, false,  20,  20, false, true , "HLSPA0"  , "Labortory Pillar");

		DOOM.add( 5065, ThingType.BRIDGE      ,  0,  8, false,   8,   8, false, true , null      , "Invisible Bridge, radius 8");
		DOOM.add( 5064, ThingType.BRIDGE      ,  0,  8, false,  16,   8, false, true , null      , "Invisible Bridge, radius 16");
		DOOM.add( 5061, ThingType.BRIDGE      ,  0,  8, false,  32,   8, false, true , null      , "Invisible Bridge, radius 32");
		DOOM.add( 9990, ThingType.BRIDGE      ,  0,  8, false,  32,   4, false, true , null      , "Custom Invisible Bridge");
		DOOM.add( 9991, ThingType.BRIDGE      ,  0,  8, false,  32,   2, false, true , null      , "Bridge Custom");

		DOOM.add(   70, ThingType.OBSTACLE    ,  1,  3, false,  16,  32, false, true , "FCANA0"  , "Burning barrel");
		DOOM.add(   48, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "ELECA0"  , "Tall techno pillar");
		DOOM.add(   30, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "COL1A0"  , "Tall green pillar");
		DOOM.add(   32, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "COL3A0"  , "Tall red pillar");
		DOOM.add(   31, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "COL2A0"  , "Short green pillar");
		DOOM.add(   36, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "COL5A0"  , "Short green pillar (beating heart)");
		DOOM.add(   33, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "COL4A0"  , "Short red pillar");
		DOOM.add(   37, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "COL6A0"  , "Short red pillar (skull)");
		DOOM.add(   47, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "SMITA0"  , "Stalagmite");
		DOOM.add(   43, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "TRE1A0"  , "Gray tree");
		DOOM.add(   54, ThingType.OBSTACLE    ,  2,  3, false,  32,  20, false, true , "TRE2A0"  , "Large brown tree");
		DOOM.add(   41, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "CEYEA0"  , "Evil Eye");
		DOOM.add(   42, ThingType.OBSTACLE    ,  2,  3, false,  16,  20, false, true , "FSKUA0"  , "Floating skull rock");
		DOOM.add( 5009, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "FSKUA0"  , "Floating skull rock (bobs)");
		DOOM.add( 5120, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "POL7A0"  , "Impaling Spike");
		DOOM.add( 5121, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "POL8A0"  , "Impaled Chaingunner Head");
		DOOM.add( 5122, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "POL9A0"  , "Impaled ZombieMan Head");
		DOOM.add( 5050, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "SMT2A0"  , "Grey Stalagmite");
		DOOM.add( 5051, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "COL8A0"  , "Short Grey Pillar");
		DOOM.add( 5052, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "COL7A0"  , "Tall Grey Pillar");
		DOOM.add( 5053, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "COL9A0"  , "Grey Pillar with Pumping Heart");
		DOOM.add( 5054, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "GCOLA0"  , "Tall Gothic Pillar");
		DOOM.add( 5055, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "SGRBA0"  , "Revenant Hand");
		DOOM.add( 5056, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "IHEDA1"  , "Imp's Head");
		DOOM.add( 5057, ThingType.OBSTACLE    ,  3,  3, false,  16,  20, false, true , "HISYA1"  , "Hissy");

		DOOM.add( 2028, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "COLUA0"  , "Floor lamp");
		DOOM.add(   34, ThingType.LIGHT       ,  0, 11, false,  20,  16, false, false, "CANDA0"  , "Candle");
		DOOM.add(   35, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "CBRAA0"  , "Candelabra");
		DOOM.add(   44, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "TBLUA0"  , "Tall blue firestick");
		DOOM.add(   45, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "TGRNA0"  , "Tall green firestick");
		DOOM.add(   46, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "TREDA0"  , "Tall red firestick");
		DOOM.add(   55, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "SMBTA0"  , "Short blue firestick");
		DOOM.add(   56, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "SMGTA0"  , "Short green firestick");
		DOOM.add(   57, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "SMRTA0"  , "Short red firestick");
		DOOM.add(   85, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "TLMPA0"  , "Tall techno floor lamp");
		DOOM.add(   86, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "TLP2A0"  , "Short techno floor lamp");
		DOOM.add( 5156, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "CANRA0"  , "Red Candle");
		DOOM.add( 5157, ThingType.LIGHT       ,  0, 11, false,  16,  16, false, true , "CANBA0"  , "Blue Candle");

		DOOM.add(   49, ThingType.DECORATION  ,  0,  4, false,  16,  68, true , true , "GOR1A0"  , "Hanging victim, twitching (blocking)");
		DOOM.add(   63, ThingType.DECORATION  ,  0,  4, false,  20,  68, true , false, "GOR1A0"  , "Hanging victim, twitching");
		DOOM.add(   50, ThingType.DECORATION  ,  0,  4, false,  16,  84, true , true , "GOR2A0"  , "Hanging victim, arms out (blocking)");
		DOOM.add(   59, ThingType.DECORATION  ,  0,  4, false,  20,  86, true , false, "GOR2A0"  , "Hanging victim, arms out");
		DOOM.add(   52, ThingType.DECORATION  ,  0,  4, false,  16,  68, true , true , "GOR4A0"  , "Hanging pair of legs (blocking)");
		DOOM.add(   60, ThingType.DECORATION  ,  0,  4, false,  20,  68, true , false, "GOR4A0"  , "Hanging pair of legs");
		DOOM.add(   51, ThingType.DECORATION  ,  0,  4, false,  16,  68, true , true , "GOR3A0"  , "Hanging victim, 1-legged (blocking)");
		DOOM.add(   61, ThingType.DECORATION  ,  0,  4, false,  20,  52, true , false, "GOR3A0"  , "Hanging victim, 1-legged");
		DOOM.add(   53, ThingType.DECORATION  ,  0,  4, false,  16,  52, true , true , "GOR5A0"  , "Hanging leg (blocking)");
		DOOM.add(   62, ThingType.DECORATION  ,  0,  4, false,  20,  52, true , false, "GOR5A0"  , "Hanging leg");
		DOOM.add(   25, ThingType.DECORATION  ,  0,  4, false,  16,  16, false, true , "POL1A0"  , "Impaled human");
		DOOM.add(   26, ThingType.DECORATION  ,  0,  4, false,  16,  16, false, true , "POL6A0"  , "Twitching impaled human");
		DOOM.add(   27, ThingType.DECORATION  ,  0,  4, false,  16,  16, false, true , "POL4A0"  , "Skull on a pole");
		DOOM.add(   28, ThingType.DECORATION  ,  0,  4, false,  16,  16, false, true , "POL2A0"  , "5 skulls shish kebob");
		DOOM.add(   29, ThingType.DECORATION  ,  0,  4, false,  16,  16, false, true , "POL3A0"  , "Pile of skulls and candles");
		DOOM.add(   10, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, "PLAYW0"  , "Bloody mess 1");
		DOOM.add(   12, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, "PLAYW0"  , "Bloody mess 2");
		DOOM.add(   24, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, "POL5A0"  , "Pool of blood and bones");
		DOOM.add(   15, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, "PLAYN0"  , "Dead player");
		DOOM.add(   18, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, "POSSL0"  , "Dead former human");
		DOOM.add(   19, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, "SPOSL0"  , "Dead former sergeant");
		DOOM.add(   20, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, "TROOM0"  , "Dead imp");
		DOOM.add(   21, ThingType.DECORATION  ,  0,  4, false,  30,  16, false, false, "SARGN0"  , "Dead demon");
		DOOM.add(   22, ThingType.DECORATION  ,  0,  4, false,  31,  16, false, false, "HEADL0"  , "Dead cacodemon");
		DOOM.add(   23, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, null      , "Dead lost soul");
		DOOM.add(   73, ThingType.DECORATION  ,  0,  4, false,  16,  88, true , true , "HDB1A0"  , "Hanging victim, guts removed");
		DOOM.add(   74, ThingType.DECORATION  ,  0,  4, false,  16,  88, true , true , "HDB2A0"  , "Hanging victim, guts and brain removed");
		DOOM.add(   75, ThingType.DECORATION  ,  0,  4, false,  16,  64, true , true , "HDB3A0"  , "Hanging torso, looking down");
		DOOM.add(   76, ThingType.DECORATION  ,  0,  4, false,  16,  64, true , true , "HDB4A0"  , "Hanging torso, open skull");
		DOOM.add(   77, ThingType.DECORATION  ,  0,  4, false,  16,  64, true , true , "HDB5A0"  , "Hanging torso, looking up");
		DOOM.add(   78, ThingType.DECORATION  ,  0,  4, false,  16,  64, true , true , "HDB6A0"  , "Hanging torso, brain removed");
		DOOM.add(   79, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, true , "POB1A0"  , "Pool of blood and guts");
		DOOM.add(   80, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, true , "POB2A0"  , "Pool of blood");
		DOOM.add(   81, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, true , "BRS1A0"  , "Pool of brains");
		DOOM.add( 9027, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, null      , "Red Particle Fountain");
		DOOM.add( 9028, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, null      , "Green Particle Fountain");
		DOOM.add( 9029, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, null      , "Blue Particle Fountain");
		DOOM.add( 9030, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, null      , "Yellow Particle Fountain");
		DOOM.add( 9031, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, null      , "Purple Particle Fountain");
		DOOM.add( 9032, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, null      , "Black Particle Fountain");
		DOOM.add( 9033, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, null      , "White Particle Fountain");
		DOOM.add( 5058, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, "IMPSA0"  , "Impse");
		DOOM.add( 5070, ThingType.DECORATION  ,  0,  4, false,  20,  16, false, false, "CYBRP0"  , "Dead cyberdemon");
		DOOM.add( 5110, ThingType.DECORATION  ,  0,  4, false,  20,  56, false, false, "STA1A1"  , "Imp Statue");
		DOOM.add( 5111, ThingType.DECORATION  ,  0,  4, false,  30,  56, false, false, "STA2A1"  , "Demon Statue");
		DOOM.add( 5112, ThingType.DECORATION  ,  0,  4, false,  20,  56, false, false, "STA3A1"  , "Arch-Vile Statue");
		DOOM.add( 5113, ThingType.DECORATION  ,  0,  4, false,  24,  64, false, false, "STA4A1"  , "Baron of Hell Statue");
		DOOM.add( 5114, ThingType.DECORATION  ,  0,  4, false,  40, 110, false, false, "STA5A1"  , "Cyberdemon Statue");
		DOOM.add( 5115, ThingType.DECORATION  ,  0,  4, false,  20,  56, false, false, "STA6A1"  , "Massmouth Statue");
		DOOM.add( 5320, ThingType.DECORATION  ,  0,  4, false,  16,  56, false, false, "POLAA0"  , "Impaling Spike (doomguy head)");
		DOOM.add( 5321, ThingType.DECORATION  ,  0,  4, false,  16,  64, false, false, "POLBA0"  , "Impaling Spike (3 doomguy heads)");
		DOOM.add( 5322, ThingType.DECORATION  ,  0,  4, false,  16,  45, false, false, "POLCA0"  , "Impaling Spike (3 doomguy heads, short)");
		DOOM.add( 5323, ThingType.DECORATION  ,  0,  4, false,  16,  54, false, false, "POLDA0"  , "Impaling Spike (doomguy torso, one arm)");
		DOOM.add( 5324, ThingType.DECORATION  ,  0,  4, false,  16,  54, false, false, "POLEA0"  , "Impaling Spike (doomguy torso, two arms)");
		DOOM.add( 5325, ThingType.DECORATION  ,  0,  4, false,  16,  64, false, false, "POLFA0"  , "Impaling Spike (doomguy skewered, twitching)");
		DOOM.add( 5326, ThingType.DECORATION  ,  0,  4, false,  16,  64, false, false, "POLGA0"  , "Impaling Spike (doomguy skewered, long arm)");
		DOOM.add( 5327, ThingType.DECORATION  ,  0,  4, false,  16,  64, false, false, "POLHA0"  , "Impaling Spike (doomguy skewered, short arm)");
		DOOM.add( 5328, ThingType.DECORATION  ,  0,  4, false,  16,  64, false, false, "GIB1A0"  , "Pool of Blood with Marine Helmet");

		DOOM.add( 1400, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 0");
		DOOM.add( 1401, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 1");
		DOOM.add( 1402, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 2");
		DOOM.add( 1403, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 3");
		DOOM.add( 1404, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 4");
		DOOM.add( 1405, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 5");
		DOOM.add( 1406, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 6");
		DOOM.add( 1407, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 7");
		DOOM.add( 1408, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 8");
		DOOM.add( 1409, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 9");
		DOOM.add( 1411, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence 0");
		DOOM.add(14001, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 1");
		DOOM.add(14002, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 2");
		DOOM.add(14003, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 3");
		DOOM.add(14004, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 4");
		DOOM.add(14005, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 5");
		DOOM.add(14006, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 6");
		DOOM.add(14007, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 7");
		DOOM.add(14008, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 8");
		DOOM.add(14009, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 9");
		DOOM.add(14010, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 10");
		DOOM.add(14011, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 11");
		DOOM.add(14012, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 12");
		DOOM.add(14013, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 13");
		DOOM.add(14014, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 14");
		DOOM.add(14015, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 15");
		DOOM.add(14016, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 16");
		DOOM.add(14017, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 17");
		DOOM.add(14018, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 18");
		DOOM.add(14019, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 19");
		DOOM.add(14020, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 20");
		DOOM.add(14021, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 21");
		DOOM.add(14022, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 22");
		DOOM.add(14023, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 23");
		DOOM.add(14024, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 24");
		DOOM.add(14025, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 25");
		DOOM.add(14026, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 26");
		DOOM.add(14027, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 27");
		DOOM.add(14028, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 28");
		DOOM.add(14029, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 29");
		DOOM.add(14030, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 30");
		DOOM.add(14031, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 31");
		DOOM.add(14032, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 32");
		DOOM.add(14033, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 33");
		DOOM.add(14034, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 34");
		DOOM.add(14035, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 35");
		DOOM.add(14036, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 36");
		DOOM.add(14037, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 37");
		DOOM.add(14038, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 38");
		DOOM.add(14039, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 39");
		DOOM.add(14040, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 40");
		DOOM.add(14041, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 41");
		DOOM.add(14042, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 42");
		DOOM.add(14043, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 43");
		DOOM.add(14044, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 44");
		DOOM.add(14045, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 45");
		DOOM.add(14046, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 46");
		DOOM.add(14047, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 47");
		DOOM.add(14048, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 48");
		DOOM.add(14049, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 49");
		DOOM.add(14050, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 50");
		DOOM.add(14051, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 51");
		DOOM.add(14052, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 52");
		DOOM.add(14053, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 53");
		DOOM.add(14054, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 54");
		DOOM.add(14055, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 55");
		DOOM.add(14056, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 56");
		DOOM.add(14057, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 57");
		DOOM.add(14058, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 58");
		DOOM.add(14059, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 59");
		DOOM.add(14060, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 60");
		DOOM.add(14061, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 61");
		DOOM.add(14062, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 62");
		DOOM.add(14063, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 63");
		DOOM.add(14064, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Ambient Sound 64");
		DOOM.add(14065, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Custom Ambient Sound");
		DOOM.add(14066, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Sequence");
		DOOM.add(14067, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Custom Ambient Sound (no gravity)");
		DOOM.add(14101, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 01");
		DOOM.add(14102, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 02");
		DOOM.add(14103, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 03");
		DOOM.add(14104, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 04");
		DOOM.add(14105, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 05");
		DOOM.add(14106, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 06");
		DOOM.add(14107, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 07");
		DOOM.add(14108, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 08");
		DOOM.add(14109, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 09");
		DOOM.add(14110, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 10");
		DOOM.add(14111, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 11");
		DOOM.add(14112, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 12");
		DOOM.add(14113, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 13");
		DOOM.add(14114, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 14");
		DOOM.add(14115, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 15");
		DOOM.add(14116, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 16");
		DOOM.add(14117, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 17");
		DOOM.add(14118, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 18");
		DOOM.add(14119, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 19");
		DOOM.add(14120, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 20");
		DOOM.add(14121, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 21");
		DOOM.add(14122, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 22");
		DOOM.add(14123, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 23");
		DOOM.add(14124, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 24");
		DOOM.add(14125, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 25");
		DOOM.add(14126, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 26");
		DOOM.add(14127, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 27");
		DOOM.add(14128, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 28");
		DOOM.add(14129, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 29");
		DOOM.add(14130, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 30");
		DOOM.add(14131, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 31");
		DOOM.add(14132, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 32");
		DOOM.add(14133, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 33");
		DOOM.add(14134, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 34");
		DOOM.add(14135, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 35");
		DOOM.add(14136, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 36");
		DOOM.add(14137, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 37");
		DOOM.add(14138, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 38");
		DOOM.add(14139, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 39");
		DOOM.add(14140, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 40");
		DOOM.add(14141, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 41");
		DOOM.add(14142, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 42");
		DOOM.add(14143, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 43");
		DOOM.add(14144, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 44");
		DOOM.add(14145, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 45");
		DOOM.add(14146, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 46");
		DOOM.add(14147, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 47");
		DOOM.add(14148, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 48");
		DOOM.add(14149, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 49");
		DOOM.add(14150, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 50");
		DOOM.add(14151, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 51");
		DOOM.add(14152, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 52");
		DOOM.add(14153, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 53");
		DOOM.add(14154, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 54");
		DOOM.add(14155, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 55");
		DOOM.add(14156, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 56");
		DOOM.add(14157, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 57");
		DOOM.add(14158, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 58");
		DOOM.add(14159, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 59");
		DOOM.add(14160, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 60");
		DOOM.add(14161, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 61");
		DOOM.add(14162, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 62");
		DOOM.add(14163, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 63");
		DOOM.add(14164, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Music Changer 64");
		DOOM.add(14165, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Custom Music Changer");
		DOOM.add( 9048, ThingType.SOUND       ,  0,  7, false,  10,  20, false, false, null      , "Sound Environment (reverbs)");

		DOOM.add( 5001, ThingType.SPECIAL     ,  0,  8, true ,   0,   0, false, false, null      , "Pusher");
		DOOM.add( 5002, ThingType.SPECIAL     ,  1,  8, true ,   0,   0, false, false, null      , "Puller");
		DOOM.add( 9045, ThingType.SPECIAL     ,  2,  8, true ,  10,  20, false, false, null      , "Deep Water");
		DOOM.add( 9046, ThingType.SPECIAL     ,  3,  8, true ,  10,  20, false, false, null      , "Sector Secret");
		DOOM.add( 5060, ThingType.SPECIAL     ,  4,  8, true ,  10,  20, false, false, null      , "Exploding Bridge Thing");
		DOOM.add( 5062, ThingType.SPECIAL     ,  5,  8, true ,  10,  20, false, false, null      , "Breakable Glass Thing");
		DOOM.add( 5066, ThingType.SPECIAL     ,  6,  8, true ,  10,  20, false, false, null      , "Zero-gravity Zone");
		DOOM.add( 5067, ThingType.SPECIAL     ,  7,  8, true ,  10,  20, false, false, null      , "Skull Return Zone");
		DOOM.add( 5068, ThingType.SPECIAL     ,  8,  8, true ,  10,  20, false, false, null      , "Spring Pad Zone");
		DOOM.add( 5069, ThingType.SPECIAL     ,  9,  8, true ,  10,  20, false, false, null      , "Anti-gravity Zone");
		DOOM.add( 5142, ThingType.SPECIAL     , 10,  8, true ,  10,  20, false, false, null      , "Invisible bridge thing (8) (shootable)");
		DOOM.add( 5141, ThingType.SPECIAL     , 11,  8, true ,  10,  20, false, false, null      , "Invisible bridge thing (16) (shootable)");
		DOOM.add( 5140, ThingType.SPECIAL     , 12,  8, true ,  10,  20, false, false, null      , "Invisible bridge thing (32) (shootable)");
		// @formatter:on
	}

	private static void hexenThings() {
		// @formatter:off
		HEXEN.add(    1, ThingType.PLAYER     ,  0, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 1 start");
		HEXEN.add(    2, ThingType.PLAYER     ,  1, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 2 start");
		HEXEN.add(    3, ThingType.PLAYER     ,  2, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 3 start");
		HEXEN.add(    4, ThingType.PLAYER     ,  3, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 4 start");
		HEXEN.add( 9100, ThingType.PLAYER     ,  4, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 5 start");
		HEXEN.add( 9101, ThingType.PLAYER     ,  5, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 6 start");
		HEXEN.add( 9102, ThingType.PLAYER     ,  6, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 7 start");
		HEXEN.add( 9103, ThingType.PLAYER     ,  7, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player 8 start");
		HEXEN.add(   11, ThingType.PLAYER     ,  8, 10, true ,  16,  56, false, true , "PLAYA1"  , "Player Deathmatch start");

		HEXEN.add(   14, ThingType.TELEPORT   ,  0,  2, true ,  16,  56, false, false, "TFOGA0"  , "Teleport Landing");
		HEXEN.add(  140, ThingType.TELEPORT   ,  1,  2, true ,  16,  56, false, false, "TFOGA0"  , "Teleport Smo");

		HEXEN.add(  107, ThingType.MONSTER    ,  0, 12, true ,  20,  56, false, true , "CENTA1"  , "Centaur");
		HEXEN.add(10060, ThingType.MONSTER    ,  0, 12, true ,  20,  56, false, true , "FDMNA1"  , "Affrit");
		HEXEN.add(  115, ThingType.MONSTER    ,  0, 12, true ,  20,  56, false, true , "CENTF1"  , "Slaughtar");
		HEXEN.add(   34, ThingType.MONSTER    ,  0, 12, true ,  20,  56, false, true , "WRTHA1"  , "Reiver");
		HEXEN.add(10011, ThingType.MONSTER    ,  0, 12, true ,  20,  56, false, true , "WRTHA1"  , "Reiver (buried)");
		HEXEN.add(  254, ThingType.MONSTER    ,  0, 12, true ,  20,  56, false, true , "DRAGC1"  , "Dragon Lich");
		HEXEN.add(10030, ThingType.MONSTER    ,  0, 12, true ,  25,  56, false, true , "ETTNA1"  , "Ettin");
		HEXEN.add( 8020, ThingType.MONSTER    ,  0, 12, true ,  22,  56, false, true , "ICEYA1"  , "Wendigo");
		HEXEN.add(   31, ThingType.MONSTER    ,  0, 12, true ,  32,  56, false, true , "DEMNA1"  , "Green Chaos Serpent");
		HEXEN.add( 8080, ThingType.MONSTER    ,  0, 12, true ,  32,  56, false, true , "DEM2A1"  , "Brown Chaos Serpent");
		HEXEN.add(  114, ThingType.MONSTER    ,  0, 12, true ,  22,  56, false, true , "BISHA1"  , "Dark Bishop");
		HEXEN.add(  121, ThingType.MONSTER    ,  0, 12, true ,  32,  56, false, true , "SSPTB0"  , "Stalker");
		HEXEN.add(  120, ThingType.MONSTER    ,  0, 12, true ,  32,  56, false, true , "SSPTD0"  , "Stalker Boss");
		HEXEN.add(10100, ThingType.MONSTER    ,  0, 12, true ,  16,  56, false, true , "PLAYE8"  , "Zedek (fighter)");
		HEXEN.add(10101, ThingType.MONSTER    ,  0, 12, true ,  16,  56, false, true , "CLERE8"  , "Traductus (cleric)");
		HEXEN.add(10102, ThingType.MONSTER    ,  0, 12, true ,  16,  56, false, true , "MAGEE8"  , "Menelkir (mage)");
		HEXEN.add(10080, ThingType.MONSTER    ,  0, 12, true ,  40,  56, false, true , "SORCA1"  , "Heresiarch");
		HEXEN.add(10200, ThingType.MONSTER    ,  0, 12, true ,  65,  56, false, true , "KORXA1"  , "Korax");

		HEXEN.add(   10, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WCSSA0"  , "Serpent Staff");
		HEXEN.add( 8010, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WFAXA0"  , "Timon's Axe");
		HEXEN.add(   53, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WMCSA0"  , "Frost Shards");
		HEXEN.add( 8009, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WCFMA0"  , "Firestorm");
		HEXEN.add(  123, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WFHMA0"  , "Hammer Of Retribution");
		HEXEN.add( 8040, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WMLGG0"  , "Arc Of Death");
		HEXEN.add(   18, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WCH1A0"  , "Wraithverge Piece 1");
		HEXEN.add(   19, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WCH2A0"  , "Wraithverge Piece 2");
		HEXEN.add(   20, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WCH3A0"  , "Wraithverge Piece 3");
		HEXEN.add(   12, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WFR1A0"  , "Quietus Piece 1");
		HEXEN.add(   13, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WFR2A0"  , "Quietus Piece 2");
		HEXEN.add(   16, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WFR3A0"  , "Quietus Piece 3");
		HEXEN.add(   21, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WMS1A0"  , "BloodScourge Piece 1");
		HEXEN.add(   22, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WMS2A0"  , "BloodScourge Piece 2");
		HEXEN.add(   23, ThingType.WEAPON     ,  0,  6, false,  20,  25, false, false, "WMS3A0"  , "BloodScourge Piece 3");

		HEXEN.add(  122, ThingType.AMMO       ,  0,  6, false,   8,  16, false, false, "MAN1H0"  , "Blue Mana");
		HEXEN.add(  124, ThingType.AMMO       ,  0,  6, false,   8,  16, false, false, "MAN2H0"  , "Green Mana");
		HEXEN.add( 8004, ThingType.AMMO       ,  0,  6, false,   8,  16, false, false, "MAN3A0"  , "Combine Mana");

		HEXEN.add( 8005, ThingType.HEALTH     ,  0,  1, false,  20,  20, false, false, "ARM1A0"  , "Mesh Armor");
		HEXEN.add( 8006, ThingType.HEALTH     ,  0,  1, false,  20,  20, false, false, "ARM2A0"  , "Falcon Shield");
		HEXEN.add( 8007, ThingType.HEALTH     ,  0,  1, false,  20,  20, false, false, "ARM3A0"  , "Platinum Helm");
		HEXEN.add( 8008, ThingType.HEALTH     ,  0,  1, false,  20,  20, false, false, "ARM4A0"  , "Amulet Of Warding");
		HEXEN.add(   81, ThingType.HEALTH     ,  0,  1, false,  20,  20, false, false, "PTN1A0"  , "Crystal Vial");

		HEXEN.add(   30, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTIPORK", "Porkalator");
		HEXEN.add(   32, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTISPHL", "Mystic Urn");
		HEXEN.add(   33, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTITRCH", "Torch");
		HEXEN.add(   36, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTIATLP", "Chaos Device");
		HEXEN.add(   82, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTIPTN2", "Quartz Flask");
		HEXEN.add(   83, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTISOAR", "Wings Of Wrath");
		HEXEN.add(   84, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTIINVU", "Icon Of The Defender");
		HEXEN.add(   86, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTISUMN", "Dark Servant");
		HEXEN.add(10110, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTIBLST", "Disc Of Repulsion");
		HEXEN.add(10120, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTIHRAD", "Mystic Ambit Incant");
		HEXEN.add(10040, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTITELO", "Banishment Device");
		HEXEN.add( 8000, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTIPSBG", "Flechette");
		HEXEN.add( 8002, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTISPED", "Boots Of Speed");
		HEXEN.add( 8003, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTIBMAN", "Crater Of Might");
		HEXEN.add( 8041, ThingType.POWERUP    ,  0,  9, false,  20,  40, false, false, "ARTIBRAC", "Dragonskin Bracers");

		HEXEN.add( 9002, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTISKLL", "Yorick's Skull");
		HEXEN.add( 9003, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIBGEM", "Heart Of D'Sparil");
		HEXEN.add( 9004, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIGEMR", "Ruby Planet");
		HEXEN.add( 9005, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIGEMG", "Emerald Planet 1");
		HEXEN.add( 9006, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIGEMB", "Sapphire Planet 1");
		HEXEN.add( 9007, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIBOK1", "Daemon Codex");
		HEXEN.add( 9008, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIBOK2", "Liber Obscura");
		HEXEN.add( 9009, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIGMG2", "Emerald Planet 2");
		HEXEN.add( 9010, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIGMB2", "Sapphire Planet 2");
		HEXEN.add( 9011, ThingType.PUZZLE     ,  0, 16, false,  10,  16, false, false, "STWNA0"  , "Yorick's Statue");
		HEXEN.add( 9012, ThingType.PUZZLE     ,  0, 16, false,  10,  16, false, false, "GMPDA0"  , "Pedestal Of D'Sparil");
		HEXEN.add( 9014, ThingType.PUZZLE     ,  0, 16, false,  10,  16, false, false, "ARTISKL2", "Flame mask");
		HEXEN.add( 9015, ThingType.PUZZLE     ,  0, 16, false,  10,  16, false, false, "ARTIFWEP", "Glaive seal");
		HEXEN.add( 9016, ThingType.PUZZLE     ,  0, 16, false,  10,  16, false, false, "ARTICWEP", "Holy relic");
		HEXEN.add( 9017, ThingType.PUZZLE     ,  0, 16, false,  10,  16, false, false, "ARTIMWEP", "Sigil of the magus");
		HEXEN.add( 9018, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIGEAR", "Clock Gear (steel)");
		HEXEN.add( 9019, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIGER2", "Clock Gear (bronze)");
		HEXEN.add( 9020, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIGER3", "Clock Gear (steel and bronze)");
		HEXEN.add( 9021, ThingType.PUZZLE     ,  0, 16, false,  20,  16, false, false, "ARTIGER4", "Clock Gear (bronze and steel)");

		HEXEN.add( 8030, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEY1A0"  , "Steel Key");
		HEXEN.add( 8031, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEY2A0"  , "Cave Key");
		HEXEN.add( 8032, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEY3A0"  , "Axe Key");
		HEXEN.add( 8033, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEY4A0"  , "Fire Key");
		HEXEN.add( 8034, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEY5A0"  , "Emerald Key");
		HEXEN.add( 8035, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEY6A0"  , "Dungeon Key");
		HEXEN.add( 8036, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEY7A0"  , "Silver Key");
		HEXEN.add( 8037, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEY8A0"  , "Rusty Key");
		HEXEN.add( 8038, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEY9A0"  , "Horn Key");
		HEXEN.add( 8039, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEYAA0"  , "Swamp Key");
		HEXEN.add( 8200, ThingType.KEY        ,  0, 13, false,   8,  24, false, false, "KEYBA0"  , "Castle Key");

		HEXEN.add( 8064, ThingType.OBSTACLE   ,  0,  3, false,  16,  20, false, true , "SUITA0"  , "Suit Of Armor");
		HEXEN.add(   77, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "BNR1A0"  , "Battle Rag Banner");
		HEXEN.add( 8100, ThingType.OBSTACLE   ,  0,  3, false,  15,  20, false, true , "BARLA0"  , "Barrel");
		HEXEN.add( 8065, ThingType.OBSTACLE   ,  0,  3, false,  56,  20, false, true , "BBLLA0"  , "Bell");
		HEXEN.add(  103, ThingType.OBSTACLE   ,  0,  3, false,  12,  20, false, true , "VASEA0"  , "Pillar With Vase");
		HEXEN.add(    5, ThingType.OBSTACLE   ,  0,  3, false,  10,  20, false, true , "STTWA0"  , "Winged Statue");
		HEXEN.add(   98, ThingType.OBSTACLE   ,  0,  3, false,  15,  20, false, true , "RKBSA0"  , "Small Rock (brown)");
		HEXEN.add(   97, ThingType.OBSTACLE   ,  0,  3, false,  17,  20, false, true , "RKBLA0"  , "Big Rock (brown)");
		HEXEN.add(   99, ThingType.OBSTACLE   ,  0,  3, false,  20,  20, false, true , "RKBKA0"  , "Big Rock (grey)");
		HEXEN.add(   57, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "SLC3A0"  , "Stalactite (small)");
		HEXEN.add(   56, ThingType.OBSTACLE   ,  0,  3, false,   6,  20, false, true , "SLC2A0"  , "Stalactite (medium)");
		HEXEN.add(   52, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "SLC1A0"  , "Stalactite (large)");
		HEXEN.add(   48, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "SGMPA0"  , "Stalagmite (pillar)");
		HEXEN.add(   51, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "SGM3A0"  , "Stalagmite (small)");
		HEXEN.add(   50, ThingType.OBSTACLE   ,  0,  3, false,   6,  20, false, true , "SGM2A0"  , "Stalagmite (medium)");
		HEXEN.add(   49, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "SGM1A0"  , "Stalagmite (large)");
		HEXEN.add(   80, ThingType.OBSTACLE   ,  0,  3, false,  22,  20, false, true , "TRE6A0"  , "Gnarled Tree 1");
		HEXEN.add(   87, ThingType.OBSTACLE   ,  0,  3, false,  22,  20, false, true , "TRE7A0"  , "Gnarled Tree 2");
		HEXEN.add(   78, ThingType.OBSTACLE   ,  0,  3, false,  15,  20, false, true , "TRE5A0"  , "Tall Tree 1");
		HEXEN.add(   79, ThingType.OBSTACLE   ,  0,  3, false,  15,  20, false, true , "TRE4A0"  , "Tall Tree 2");
		HEXEN.add( 8067, ThingType.OBSTACLE   ,  0,  3, false,  12,  20, false, true , "IRONA0"  , "Iron Maiden");
		HEXEN.add(   63, ThingType.OBSTACLE   ,  0,  3, false,  10,  20, false, true , "TMS1A0"  , "Tombstone (RIP)");
		HEXEN.add(   64, ThingType.OBSTACLE   ,  0,  3, false,  10,  20, false, true , "TMS2A0"  , "Tombstone (Shane)");
		HEXEN.add(   65, ThingType.OBSTACLE   ,  0,  3, false,  10,  20, false, true , "TMS3A0"  , "Tombstone (slimy)");
		HEXEN.add(   66, ThingType.OBSTACLE   ,  0,  3, false,  10,  20, false, true , "TMS4A0"  , "Tombstone (Brian R)");
		HEXEN.add(   67, ThingType.OBSTACLE   ,  0,  3, false,  10,  20, false, true , "TMS5A0"  , "Tombstone (cross circle)");
		HEXEN.add(   68, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "TMS6A0"  , "Tombstone (small cross)");
		HEXEN.add(   69, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "TMS7A0"  , "Tombstone (Brian P)");
		HEXEN.add(   96, ThingType.OBSTACLE   ,  0,  3, false,   4,  20, false, true , "ICM4A0"  , "Ice Spike (tiny)");
		HEXEN.add(   95, ThingType.OBSTACLE   ,  0,  3, false,   5,  20, false, true , "ICM3A0"  , "Ice Spike (small)");
		HEXEN.add(   94, ThingType.OBSTACLE   ,  0,  3, false,   5,  20, false, true , "ICM2A0"  , "Ice Spike (medium)");
		HEXEN.add(   93, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "ICM1A0"  , "Ice Spike (large)");
		HEXEN.add(   92, ThingType.OBSTACLE   ,  0,  3, false,   4,  20, false, true , "ICT4A0"  , "Icicle (tiny)");
		HEXEN.add(   91, ThingType.OBSTACLE   ,  0,  3, false,   4,  20, false, true , "ICT3A0"  , "Icicle (small)");
		HEXEN.add(   90, ThingType.OBSTACLE   ,  0,  3, false,   5,  20, false, true , "ICT2A0"  , "Icicle (medium)");
		HEXEN.add(   89, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "ICT1A0"  , "Icicle (large)");
		HEXEN.add( 8068, ThingType.OBSTACLE   ,  0,  3, false,  11,  20, false, true , "XMASA0"  , "Evergreen Tree");
		HEXEN.add( 8062, ThingType.OBSTACLE   ,  0,  3, false,  15,  20, false, true , "TRDTA0"  , "Leafless Tree");
		HEXEN.add(   24, ThingType.OBSTACLE   ,  0,  3, false,  10,  20, false, true , "TRE1A0"  , "Dead Tree");
		HEXEN.add(   25, ThingType.OBSTACLE   ,  0,  3, false,  15,  20, false, true , "TRE1A0"  , "Dead Tree (destructable)");
		HEXEN.add(   60, ThingType.OBSTACLE   ,  0,  3, false,   8,  20, false, true , "SWMVA0"  , "Dead Tree (mossy)");
		HEXEN.add(   26, ThingType.OBSTACLE   ,  0,  3, false,  10,  20, false, true , "TRE2A0"  , "Mossy Tree 1");
		HEXEN.add(   27, ThingType.OBSTACLE   ,  0,  3, false,  10,  20, false, true , "TRE3A0"  , "Mossy Tree 2");
		HEXEN.add(   88, ThingType.OBSTACLE   ,  0,  3, false,  20,  20, false, true , "SLTRA0"  , "Log");
		HEXEN.add(   29, ThingType.OBSTACLE   ,  0,  3, false,  12,  20, false, true , "STM2A0"  , "Tree Stump (bare)");
		HEXEN.add(   28, ThingType.OBSTACLE   ,  0,  3, false,  12,  20, false, true , "STM1A0"  , "Tree Stump (burned)");
		HEXEN.add(   37, ThingType.OBSTACLE   ,  0,  3, false,  20,  20, false, true , "STM3A0"  , "Tree Stump 1");
		HEXEN.add(   38, ThingType.OBSTACLE   ,  0,  3, false,  20,  20, false, true , "STM4A0"  , "Tree Stump 2");
		HEXEN.add( 8051, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "GAR8A0"  , "Bronze Gargoyle (short)");
		HEXEN.add( 8047, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "GAR4A0"  , "Bronze Gargoyle (tall)");
		HEXEN.add( 8044, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "GAR1A0"  , "Rusty Gargoyle (tall)");
		HEXEN.add(   76, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "STT5A0"  , "Ice Gargoyle (short)");
		HEXEN.add(   73, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "STT3A0"  , "Ice Gargoyle (tall)");
		HEXEN.add( 8050, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "GAR7A0"  , "Lava Gargoyle (short)");
		HEXEN.add( 8046, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "GAR3A0"  , "Lava Gargoyle (tall)");
		HEXEN.add( 8049, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "GAR6A0"  , "Dark Lava Gargoyle (short)");
		HEXEN.add( 8045, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "GAR2A0"  , "Dark Lava Gargoyle (tall)");
		HEXEN.add(   74, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "STT4A0"  , "Stone Gargoyle (short)");
		HEXEN.add(   72, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "STT2A0"  , "Stone Gargoyle (tall)");
		HEXEN.add( 8052, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "GAR9A0"  , "Steel Gargoyle (short)");
		HEXEN.add( 8048, ThingType.OBSTACLE   ,  0,  3, false,  14,  20, false, true , "GAR5A0"  , "Steel Gargoyle (tall)");

		HEXEN.add(   17, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "CDLRA0"  , "Chandelier (lit)");
		HEXEN.add( 8063, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "CDLRD0"  , "Chandelier (unlit)");
		HEXEN.add( 8066, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "CANDA0"  , "Blue Candle (lit)");
		HEXEN.add( 8502, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "TST3A0"  , "Candle With Web (unlit)");
		HEXEN.add( 8503, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "TST4A0"  , "Small Gray Candle (unlit)");
		HEXEN.add( 8504, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "TST5A0"  , "Small Candle (unlit)");
		HEXEN.add(  119, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "CNDLA0"  , "3 Candles (lit)");
		HEXEN.add(10500, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "FFSMA0"  , "Small Flame (timed)");
		HEXEN.add(10501, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "FFSMA0"  , "Small Flame");
		HEXEN.add(10502, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "FFLGD0"  , "Large Flame (timed)");
		HEXEN.add(10503, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "FFLGD0"  , "Large Flame");
		HEXEN.add(   54, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "WLTRB0"  , "Wall Torch (lit)");
		HEXEN.add(   55, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "WLTRI0"  , "Wall Torch (unlit)");
		HEXEN.add( 8042, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "FBULB0"  , "Minotaur Statue (lit)");
		HEXEN.add( 8043, ThingType.LIGHT      ,  0, 11, false,  20,  16, false, false, "FBULH0"  , "Minotaur Statue (unlit)");
		HEXEN.add( 8069, ThingType.LIGHT      ,  0, 11, false,  12,  16, false, false, "CDRNG0"  , "Cauldron (lit)");
		HEXEN.add( 8070, ThingType.LIGHT      ,  0, 11, false,  12,  16, false, false, "CDRNA0"  , "Cauldron (unlit)");
		HEXEN.add( 8060, ThingType.LIGHT      ,  0, 11, false,   5,  16, false, false, "FSKLA0"  , "Skull With Flame");
		HEXEN.add( 8061, ThingType.LIGHT      ,  0, 11, false,   6,  16, false, false, "BRTRB0"  , "Brazier With Flame");
		HEXEN.add(  116, ThingType.LIGHT      ,  0, 11, false,  10,  16, false, false, "TWTRA0"  , "Twined Torch (lit)");
		HEXEN.add(  117, ThingType.LIGHT      ,  0, 11, false,  10,  16, false, false, "TWTRI0"  , "Twined Torch (unlit)");

		HEXEN.add( 8071, ThingType.DECORATION ,  0,  4, false,   4,  16, false, false, "CHNSA0"  , "Chain (short)");
		HEXEN.add( 8072, ThingType.DECORATION ,  0,  4, false,   4,  16, false, false, "CHNSB0"  , "Chain (long)");
		HEXEN.add( 8073, ThingType.DECORATION ,  0,  4, false,   4,  16, false, false, "CHNSC0"  , "Hook With Heart");
		HEXEN.add( 8077, ThingType.DECORATION ,  0,  4, false,   4,  16, false, false, "CHNSG0"  , "Hook With Skull");
		HEXEN.add( 8074, ThingType.DECORATION ,  0,  4, false,   4,  16, false, false, "CHNSD0"  , "Chain With Large Hook");
		HEXEN.add( 8075, ThingType.DECORATION ,  0,  4, false,   4,  16, false, false, "CHNSE0"  , "Chain With Small Hook");
		HEXEN.add( 8076, ThingType.DECORATION ,  0,  4, false,   4,  16, false, false, "CHNSF0"  , "Chain with Spike Ball");
		HEXEN.add( 8103, ThingType.DECORATION ,  0,  4, false,   8,  16, false, false, "BCKTA0"  , "Hanging Bucket");
		HEXEN.add(    6, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "RCK1A0"  , "Tiny Rock (mossy)");
		HEXEN.add(    7, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "RCK2A0"  , "Small Rock (mossy)");
		HEXEN.add(    9, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "RCK3A0"  , "Medium Rock (mossy)");
		HEXEN.add(   15, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "RCK4A0"  , "Big Rock (mossy)");
		HEXEN.add(  101, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "RBL2A0"  , "Brick Rubble (small)");
		HEXEN.add(  102, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "RBL3A0"  , "Brick Rubble (medium)");
		HEXEN.add(  100, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "RBL1A0"  , "Brick Rubble (large)");
		HEXEN.add(   39, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSH1A0"  , "Large Mushroom 1");
		HEXEN.add(   40, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSH2A0"  , "Large Mushroom 2");
		HEXEN.add( 8104, ThingType.DECORATION ,  0,  4, false,   6,  16, false, false, "SHRMB0"  , "Large Mushroom (explodes)");
		HEXEN.add(   41, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSH3A0"  , "Medium Mushroom");
		HEXEN.add(   42, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSH4A0"  , "Small Mushroom 1");
		HEXEN.add(   44, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSH5A0"  , "Small Mushroom 2");
		HEXEN.add(   45, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSH6A0"  , "Small Mushroom 3");
		HEXEN.add(   46, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSH7A0"  , "Small Mushroom 4");
		HEXEN.add(   47, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSH8A0"  , "Small Mushroom 5");
		HEXEN.add( 8101, ThingType.DECORATION ,  0,  4, false,   8,  16, false, false, "SHB1A0"  , "Shrub");
		HEXEN.add( 8102, ThingType.DECORATION ,  0,  4, false,  16,  16, false, false, "SHB2A0"  , "Shrub 2");
		HEXEN.add(  111, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "GIBSA0"  , "Pool Of Blood");
		HEXEN.add(   71, ThingType.DECORATION ,  0,  4, false,   6,  16, false, false, "CPS3A0"  , "Hanging Corpse");
		HEXEN.add(   61, ThingType.DECORATION ,  0,  4, false,  10,  16, false, false, "CPS1A0"  , "Impaled Corpse");
		HEXEN.add(  108, ThingType.DECORATION ,  0,  4, false,  11,  16, false, false, "CPS4A0"  , "Lynched Corpse");
		HEXEN.add(  109, ThingType.DECORATION ,  0,  4, false,  10,  16, false, false, "CPS5A0"  , "Lynched Corpse (heartless)");
		HEXEN.add(  110, ThingType.DECORATION ,  0,  4, false,  15,  16, false, false, "CPS6A0"  , "Corpse (sitting)");
		HEXEN.add(   62, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "CPS2A0"  , "Corpse (sleeping)");
		HEXEN.add( 8509, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "TST0A0"  , "Meat Cleaver");
		HEXEN.add( 8508, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "TST9A0"  , "Goblet (silver)");
		HEXEN.add( 8507, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "TST8A0"  , "Goblet (small)");
		HEXEN.add( 8506, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "TST7A0"  , "Goblet (tall)");
		HEXEN.add( 8505, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "TST6A0"  , "Goblet (spilled)");
		HEXEN.add( 8501, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "TST2A0"  , "Small Silver Stein");
		HEXEN.add( 8500, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "TST1A0"  , "Large Brown Stein");
		HEXEN.add(  104, ThingType.DECORATION ,  0,  4, false,  10,  16, false, false, "POT1A0"  , "Pot (tall)");
		HEXEN.add(  105, ThingType.DECORATION ,  0,  4, false,  10,  16, false, false, "POT2A0"  , "Pot (medium)");
		HEXEN.add(  106, ThingType.DECORATION ,  0,  4, false,  15,  16, false, false, "POT3A0"  , "Pot (short)");
		HEXEN.add(   58, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSS1A0"  , "Hanging Moss 1");
		HEXEN.add(   59, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "MSS2A0"  , "Hanging Moss 2");
		HEXEN.add(10090, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "TSPKD0"  , "Spike Down");
		HEXEN.add(10091, ThingType.DECORATION ,  0,  4, false,  20,  16, false, false, "TSPKB0"  , "Spike Up");

		HEXEN.add( 1403, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Creak");
		HEXEN.add( 1408, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Earth Crack");
		HEXEN.add( 1401, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Heavy");
		HEXEN.add( 1407, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Ice");
		HEXEN.add( 1405, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Lava");
		HEXEN.add( 1402, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Metal");
		HEXEN.add( 1409, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Metal2");
		HEXEN.add( 1404, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Silent");
		HEXEN.add( 1400, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Stone");
		HEXEN.add( 1406, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Water");
		HEXEN.add( 1410, ThingType.SOUND      ,  0,  5, false,  10,  20, false, false, null      , "Wind");

		HEXEN.add(  118, ThingType.SPECIAL    ,  0,  8, false,  32,  20, false, false, null      , "Glitter Bridge");
		HEXEN.add( 3000, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Polyobject Anchor");
		HEXEN.add( 3001, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Polyobject Start Spot");
		HEXEN.add( 3002, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Polyobject Start Spot (crush)");
		HEXEN.add(10225, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, "ABATC2C8", "Spawn Bat");
		HEXEN.add(10000, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Spawn Fog");
		HEXEN.add(10001, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Fog Patch (small)");
		HEXEN.add(10002, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Fog Patch (medium)");
		HEXEN.add(10003, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Fog Patch (large)");
		HEXEN.add(  113, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Spawn Leaf");
		HEXEN.add( 9001, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Map Spot");
		HEXEN.add( 9013, ThingType.SPECIAL    ,  0,  8, false,  10,  20, false, false, null      , "Map Spot (gravity)");
		// @formatter:on
	}

	private final ThingData[] data = new ThingData[32768];

	@SuppressWarnings("MethodWithTooManyParameters")
	private void add(int id,
	                 ThingType thingType,
	                 int naturalOrder,
	                 int colorIndex,
	                 boolean hasDirection,
	                 int diameter,
	                 int height,
	                 boolean hangs,
	                 boolean blocking,
	                 @Nullable String sprite,
	                 String name) {

		data[id] = new ThingData(id,
		                         thingType,
		                         naturalOrder,
		                         name,
		                         diameter,
		                         height,
		                         hasDirection,
		                         hangs,
		                         blocking,
		                         sprite,
		                         colorIndex);
	}

	public @Nullable ThingData get(int id) {
		if (id < 0 || id >= 32768)
			return null;

		return data[id];
	}

	public static ThingConstants get(GameType game) {
		requireNonNull(game, "game");

		switch (game) {
			case DOOM:
				return DOOM;
			case HEXEN:
				return HEXEN;
			case HERETIC:
			case STRIFE:
				throw new UnsupportedOperationException("Unimplemented GameType: " + game);
			default:
				throw new AssertionError("Unknown GameType: " + game);
		}
	}

	public static @Nullable ThingData getThingData(GameType game, Thing thing) {
		requireNonNull(thing, "thing");

		return get(game).get(thing.getType());
	}
}
