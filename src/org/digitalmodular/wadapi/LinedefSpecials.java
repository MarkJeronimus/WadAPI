package wadapi;

/**
 * @author Zom-B
 */
// Created 2011-08-14
public class LinedefSpecials {
	private static final String[] GENERALIZED_FLAT      = {"Ceiling", ", Floor"};
	private static final String[] GENERALIZED_DIRECTION = {", Lower", ", Raise"};
	private static final char[]   GENERALIZED_TRIGGER   = {'W', 'S', 'G', 'D'};
	private static final String[] GENERALIZED_TARGET    = {", to Highest Adjacent Floor",
	                                                       ", to Lowest Adjacent Floor",
	                                                       ", to Next Adjacent Floor",
	                                                       ", to Lowest Adjacent Ceiling",
	                                                       ", to Ceiling",
	                                                       ", to Shortest Lower Texture",
	                                                       ", by 24 Map Pixels (relative)",
	                                                       ", by 32 Map Pixels (relative)"};
	private static final String[] GENERALIZED_SPEED     = {", Slow", "", ", Fast", ", Turbo"};
	private static final String[] GENERALIZED_CHANGE    = {"",
	                                                       ", Change Texture and Remove Effect",
	                                                       ", Change Texture Only",
	                                                       ", Change Texture and Effect"};
	private static final String[] GENERALIZED_MODEL     = {", Trigger model",
	                                                       ", Numeric model"};
	private static final String[] GENERALIZED_ACTION    = {", Open Wait Close",
	                                                       ", Open",
	                                                       ", Close Wait Open",
	                                                       ", Close"};
	private static final String[] GENERALIZED_WAIT      = {", 1 Second",
	                                                       ", 4 Seconds",
	                                                       ", 9 Seconds",
	                                                       ", 30 Seconds"};
	private static final String[] GENERALIZED_LOCK      = {", Any Key",
	                                                       ", Red Keycard",
	                                                       ", Blue Keycard",
	                                                       ", Yellow Keycard",
	                                                       ", Red Skullkey",
	                                                       ", Blue Skullkey",
	                                                       ", Yellow Skullkey",
	                                                       ", All Keys"};
	private static final String[] GENERALIZED_LIFT      = {", to Lowest Adjacent Floor",
	                                                       ", to Next Adjacent Floor",
	                                                       ", to Lowest Adjacent Ceiling",
	                                                       ", Perpetual Lowest and Highest Floors"};
	private static final String[] GENERALIZED_DELAY     = {", 1 Second",
	                                                       ", 3 Seconds",
	                                                       ", 5 Seconds",
	                                                       ", 10 Seconds"};
	private static final String[] GENERALIZED_STEP      = {", 4 Map Pixels",
	                                                       ", 6 Map Pixels",
	                                                       ", 16 Map Pixels",
	                                                       ", 24 Map Pixels"};

	public static final LinedefSpecials[] DOOM = new LinedefSpecials[32768];

	public final char    trigger_type;
	public final boolean trigger_repeatable;
	public final String  category;
	public final String  title;

	static {
		commonSpecials();
		doomSpecials();
		boomSpecials();
		zdoomSpecials();
		boomGeneralizedSpecials();
	}

	private static void commonSpecials() {
		// @formatter:off
		DOOM[  0] = new LinedefSpecials(' ', false, "misc"        , "None");
		// @formatter:on
	}

	private static void doomSpecials() {
		// @formatter:off
		DOOM[  1] = new LinedefSpecials('D', true , "Door"        , "Door Open Wait Close (also monsters)");
		DOOM[  2] = new LinedefSpecials('W', false, "Door"        , "Door Open Stay");
		DOOM[  3] = new LinedefSpecials('W', false, "Door"        , "Door Close Stay");
		DOOM[  4] = new LinedefSpecials('W', false, "Door"        , "Door Open Wait Close");
		DOOM[ 16] = new LinedefSpecials('W', false, "Door"        , "Door Close Wait Open");
		DOOM[ 26] = new LinedefSpecials('D', true , "Door"        , "Door (Blue) Open Wait Close");
		DOOM[ 27] = new LinedefSpecials('D', true , "Door"        , "Door (Yellow) Open Wait Close");
		DOOM[ 28] = new LinedefSpecials('D', true , "Door"        , "Door (Red) Open Wait Close");
		DOOM[ 29] = new LinedefSpecials('S', false, "Door"        , "Door Open Wait Close");
		DOOM[ 31] = new LinedefSpecials('D', false, "Door"        , "Door Open Stay");
		DOOM[ 32] = new LinedefSpecials('D', false, "Door"        , "Door (Blue) Open Stay");
		DOOM[ 33] = new LinedefSpecials('D', false, "Door"        , "Door (Red) Open Stay");
		DOOM[ 34] = new LinedefSpecials('D', false, "Door"        , "Door (Yellow) Open Stay");
		DOOM[ 42] = new LinedefSpecials('S', true , "Door"        , "Door Close Stay");
		DOOM[ 46] = new LinedefSpecials('G', true , "Door"        , "Door Open Stay");
		DOOM[ 50] = new LinedefSpecials('S', false, "Door"        , "Door Close Stay");
		DOOM[ 61] = new LinedefSpecials('S', true , "Door"        , "Door Open Stay");
		DOOM[ 63] = new LinedefSpecials('S', true , "Door"        , "Door Open Wait Close");
		DOOM[ 75] = new LinedefSpecials('W', true , "Door"        , "Door Close Stay");
		DOOM[ 76] = new LinedefSpecials('W', true , "Door"        , "Door Close Stay Open");
		DOOM[ 86] = new LinedefSpecials('W', true , "Door"        , "Door Open Stay");
		DOOM[ 90] = new LinedefSpecials('W', true , "Door"        , "Door Open Wait Close");
		DOOM[ 99] = new LinedefSpecials('S', true , "Door"        , "Door (Blue) Open Stay (fast)");
		DOOM[103] = new LinedefSpecials('S', false, "Door"        , "Door Open Stay");
		DOOM[105] = new LinedefSpecials('W', true , "Door"        , "Door Open Wait Close (fast)");
		DOOM[106] = new LinedefSpecials('W', true , "Door"        , "Door Open Stay (fast)");
		DOOM[107] = new LinedefSpecials('W', true , "Door"        , "Door Close Stay (fast)");
		DOOM[108] = new LinedefSpecials('W', false, "Door"        , "Door Open Wait Close (fast)");
		DOOM[109] = new LinedefSpecials('W', false, "Door"        , "Door Open Stay (fast)");
		DOOM[110] = new LinedefSpecials('W', false, "Door"        , "Door Close (fast)");
		DOOM[111] = new LinedefSpecials('S', false, "Door"        , "Door Open Wait Close (fast)");
		DOOM[112] = new LinedefSpecials('S', false, "Door"        , "Door Open Stay (fast)");
		DOOM[113] = new LinedefSpecials('S', false, "Door"        , "Door Close Stay (fast)");
		DOOM[114] = new LinedefSpecials('S', true , "Door"        , "Door Open Wait Close (fast)");
		DOOM[115] = new LinedefSpecials('S', true , "Door"        , "Door Open Stay (fast)");
		DOOM[116] = new LinedefSpecials('S', true , "Door"        , "Door Close Stay (fast)");
		DOOM[117] = new LinedefSpecials('D', true , "Door"        , "Door Open Wait Close (fast)");
		DOOM[118] = new LinedefSpecials('D', false, "Door"        , "Door Open Stay (fast)");
		DOOM[133] = new LinedefSpecials('S', false, "Door"        , "Door (Blue) Open Stay (fast)");
		DOOM[134] = new LinedefSpecials('S', true , "Door"        , "Door (Red) Open Stay (fast)");
		DOOM[135] = new LinedefSpecials('S', false, "Door"        , "Door (Red) Open Stay (fast)");
		DOOM[136] = new LinedefSpecials('S', true , "Door"        , "Door (Yellow) Open Stay (fast)");
		DOOM[137] = new LinedefSpecials('S', false, "Door"        , "Door (Yellow) Open Stay (fast)");

		DOOM[  5] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise to Lowest Ceiling");
		DOOM[  9] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise Donut (changes texture)");
		DOOM[ 14] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise by 32 (changes texture)");
		DOOM[ 15] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise by 24 (changes texture)");
		DOOM[ 18] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise to Next Higher Floor");
		DOOM[ 19] = new LinedefSpecials('W', false, "Floor"       , "Floor Lower to Highest Floor");
		DOOM[ 20] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise to Next Higher Floor (changes texture)");
		DOOM[ 22] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise to Next Higher Floor (changes texture)");
		DOOM[ 23] = new LinedefSpecials('S', false, "Floor"       , "Floor Lower to Lowest Floor");
		DOOM[ 24] = new LinedefSpecials('G', false, "Floor"       , "Floor Raise to Lowest Ceiling");
		DOOM[ 30] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise by Shortest Lower Texture");
		DOOM[ 36] = new LinedefSpecials('W', false, "Floor"       , "Floor Lower to 8 above Highest Floor");
		DOOM[ 37] = new LinedefSpecials('W', false, "Floor"       , "Floor Lower to Lowest Floor (changes texture)");
		DOOM[ 38] = new LinedefSpecials('W', false, "Floor"       , "Floor Lower to Lowest Floor");
		DOOM[ 45] = new LinedefSpecials('S', true , "Floor"       , "Floor Lower to Highest Floor");
		DOOM[ 47] = new LinedefSpecials('G', false, "Floor"       , "Floor Raise to Next Higher Floor (changes texture)");
		DOOM[ 53] = new LinedefSpecials('W', false, "Floor"       , "Floor Start Moving Up and Down");
		DOOM[ 54] = new LinedefSpecials('W', false, "Floor"       , "Floor Stop Moving");
		DOOM[ 55] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise to 8 below Lowest Ceiling (crushes)");
		DOOM[ 56] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise to 8 below Lowest Ceiling (crushes)");
		DOOM[ 58] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise by 24");
		DOOM[ 59] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise by 24 (changes texture)");
		DOOM[ 60] = new LinedefSpecials('S', true , "Floor"       , "Floor Lower to Lowest Floor");
		DOOM[ 64] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise to Lowest Ceiling");
		DOOM[ 65] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise to 8 below Lowest Ceiling (crushes)");
		DOOM[ 66] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise by 24 (changes texture)");
		DOOM[ 67] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise by 32 (changes texture)");
		DOOM[ 68] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise to Next Higher Floor (changes texture)");
		DOOM[ 69] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise to Next Higher Floor");
		DOOM[ 70] = new LinedefSpecials('S', true , "Floor"       , "Floor Lower to 8 above Highest Floor");
		DOOM[ 71] = new LinedefSpecials('S', false, "Floor"       , "Floor Lower to 8 above Highest Floor");
		DOOM[ 82] = new LinedefSpecials('W', true , "Floor"       , "Floor Lower to Lowest Floor");
		DOOM[ 83] = new LinedefSpecials('W', true , "Floor"       , "Floor Lower to Highest Floor");
		DOOM[ 84] = new LinedefSpecials('W', true , "Floor"       , "Floor Lower to Lowest Floor (changes texture)");
		DOOM[ 87] = new LinedefSpecials('W', true , "Floor"       , "Floor Start Moving Up and Down");
		DOOM[ 89] = new LinedefSpecials('W', true , "Floor"       , "Floor Stop Moving");
		DOOM[ 91] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise to Lowest Ceiling");
		DOOM[ 92] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise by 24");
		DOOM[ 93] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise by 24 (changes texture)");
		DOOM[ 94] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise to 8 below Lowest Ceiling (crushes)");
		DOOM[ 95] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise to Next Higher Floor (changes texture)");
		DOOM[ 96] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise by Shortest Lower Texture");
		DOOM[ 98] = new LinedefSpecials('W', true , "Floor"       , "Floor Lower to 8 above Highest Floor");
		DOOM[101] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise to Lowest Ceiling");
		DOOM[102] = new LinedefSpecials('S', false, "Floor"       , "Floor Lower to Highest Floor");
		DOOM[119] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise to Next Higher Floor");
		DOOM[128] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise to Next Higher Floor");
		DOOM[129] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise to Next Higher Floor (fast)");
		DOOM[131] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise to Next Higher Floor (fast)");
		DOOM[132] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise to Next Higher Floor (fast)");
		DOOM[140] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise by 512");

		DOOM[  6] = new LinedefSpecials('W', false, "Crusher"     , "Crusher Start with Fast Damage");
		DOOM[ 25] = new LinedefSpecials('W', false, "Crusher"     , "Crusher Start with Slow Damage");
		DOOM[ 57] = new LinedefSpecials('W', false, "Crusher"     , "Crusher Stop");
		DOOM[ 73] = new LinedefSpecials('W', true , "Crusher"     , "Crusher Start with Slow Damage");
		DOOM[ 74] = new LinedefSpecials('W', true , "Crusher"     , "Crusher Stop");
		DOOM[ 77] = new LinedefSpecials('W', true , "Crusher"     , "Crusher Start with Fast Damage");
		DOOM[141] = new LinedefSpecials('W', false, "Crusher"     , "Crusher Start with Slow Damage (silent)");

		DOOM[  7] = new LinedefSpecials('S', false, "Stairs"      , "Stairs Raise by 8");
		DOOM[  8] = new LinedefSpecials('W', false, "Stairs"      , "Stairs Raise by 8");
		DOOM[100] = new LinedefSpecials('W', false, "Stairs"      , "Stairs Raise by 16 (fast)");
		DOOM[127] = new LinedefSpecials('S', false, "Stairs"      , "Stairs Raise by 16 (fast)");

		DOOM[ 10] = new LinedefSpecials('W', false, "Lift"        , "Lift Lower Wait Raise");
		DOOM[ 21] = new LinedefSpecials('S', false, "Lift"        , "Lift Lower Wait Raise");
		DOOM[ 62] = new LinedefSpecials('S', true , "Lift"        , "Lift Lower Wait Raise");
		DOOM[ 88] = new LinedefSpecials('W', true , "Lift"        , "Lift Lower Wait Raise");
		DOOM[120] = new LinedefSpecials('W', true , "Lift"        , "Lift Lower Wait Raise (fast)");
		DOOM[121] = new LinedefSpecials('W', false, "Lift"        , "Lift Lower Wait Raise (fast)");
		DOOM[122] = new LinedefSpecials('S', false, "Lift"        , "Lift Lower Wait Raise (fast)");
		DOOM[123] = new LinedefSpecials('S', true , "Lift"        , "Lift Lower Wait Raise (fast)");

		DOOM[ 11] = new LinedefSpecials('S', false, "Exit"        , "Exit Level");
		DOOM[ 51] = new LinedefSpecials('S', false, "Exit"        , "Exit Level (goes to secret level)");
		DOOM[ 52] = new LinedefSpecials('W', false, "Exit"        , "Exit Level");
		DOOM[124] = new LinedefSpecials('W', false, "Exit"        , "Exit Level (goes to secret level)");

		DOOM[ 12] = new LinedefSpecials('W', false, "Light"       , "Light Change to Brightest Adjacent");
		DOOM[ 13] = new LinedefSpecials('W', false, "Light"       , "Light Change to 255");
		DOOM[ 17] = new LinedefSpecials('W', false, "Light"       , "Light Start Blinking");
		DOOM[ 35] = new LinedefSpecials('W', false, "Light"       , "Light Change to 35");
		DOOM[ 79] = new LinedefSpecials('W', true , "Light"       , "Light Change to 35");
		DOOM[ 80] = new LinedefSpecials('W', true , "Light"       , "Light Change to Brightest Adjacent");
		DOOM[ 81] = new LinedefSpecials('W', true , "Light"       , "Light Change to 255");
		DOOM[104] = new LinedefSpecials('W', false, "Light"       , "Light Change to Darkest Adjacent");
		DOOM[138] = new LinedefSpecials('S', true , "Light"       , "Light Change to 255");
		DOOM[139] = new LinedefSpecials('S', true , "Light"       , "Light Change to 35");

		DOOM[ 40] = new LinedefSpecials('W', false, "Ceiling"     , "Ceiling Raise to Highest Ceiling");
		DOOM[ 41] = new LinedefSpecials('S', false, "Ceiling"     , "Ceiling Lower to Floor");
		DOOM[ 43] = new LinedefSpecials('S', true , "Ceiling"     , "Ceiling Lower to Floor");
		DOOM[ 44] = new LinedefSpecials('W', false, "Ceiling"     , "Ceiling Lower to 8 above Floor");
		DOOM[ 49] = new LinedefSpecials('S', false, "Ceiling"     , "Ceiling Lower to 8 above Floor (perpetual slow crusher damage)");
		DOOM[ 72] = new LinedefSpecials('W', true , "Ceiling"     , "Ceiling Lower to 8 above Floor");

		DOOM[ 48] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Texture Left");

		DOOM[ 97] = new LinedefSpecials('W', true , "Teleport"    , "Teleport");
		DOOM[ 39] = new LinedefSpecials('W', false, "Teleport"    , "Teleport");
		DOOM[125] = new LinedefSpecials('W', false, "Teleport"    , "Teleport (monsters only)");
		DOOM[126] = new LinedefSpecials('W', true , "Teleport"    , "Teleport (monsters only)");
		DOOM[130] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise to Next Higher Floor (fast)");
		// @formatter:on
	}

	private static void boomSpecials() {
		// @formatter:off
		DOOM[175] = new LinedefSpecials('S', false, "Door"        , "Door Close Wait Open (30 seconds)");
		DOOM[196] = new LinedefSpecials('S', true , "Door"        , "Door Close Wait Open (30 seconds)");

		DOOM[146] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise Donut (changes texture)");
		DOOM[155] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise Donut (changes texture)");
		DOOM[191] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise Donut (changes texture)");
		DOOM[142] = new LinedefSpecials('W', false, "Floor"       , "Floor Raise by 512");
		DOOM[147] = new LinedefSpecials('W', true , "Floor"       , "Floor Raise by 512");
		DOOM[158] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise by Shortest Lower Texture");
		DOOM[159] = new LinedefSpecials('S', false, "Floor"       , "Floor Lower to Lowest Floor (changes texture)");
		DOOM[160] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise by 24 (changes texture and effect)");
		DOOM[161] = new LinedefSpecials('S', false, "Floor"       , "Floor Raise by 24");
		DOOM[176] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise by Shortest Lower Texture");
		DOOM[177] = new LinedefSpecials('S', true , "Floor"       , "Floor Lower to Lowest Floor (changes texture)");
		DOOM[178] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise by 512");
		DOOM[179] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise by 24 (changes texture and effect)");
		DOOM[180] = new LinedefSpecials('S', true , "Floor"       , "Floor Raise by 24");
		DOOM[213] = new LinedefSpecials(' ', false, "Floor"       , "Floor Change Brightness to this Brightness");
		DOOM[219] = new LinedefSpecials('W', false, "Floor"       , "Floor Lower to Nearest Floor");
		DOOM[220] = new LinedefSpecials('W', true , "Floor"       , "Floor Lower to Nearest Floor");
		DOOM[221] = new LinedefSpecials('S', false, "Floor"       , "Floor Lower to Nearest Floor");
		DOOM[222] = new LinedefSpecials('S', true , "Floor"       , "Floor Lower to Nearest Floor");

		DOOM[150] = new LinedefSpecials('W', true , "Crusher"     , "Crusher Start (silent)");
		DOOM[164] = new LinedefSpecials('S', false, "Crusher"     , "Crusher Start (fast)");
		DOOM[165] = new LinedefSpecials('S', false, "Crusher"     , "Crusher Start (silent)");
		DOOM[168] = new LinedefSpecials('S', false, "Crusher"     , "Crusher Stop");
		DOOM[183] = new LinedefSpecials('S', true , "Crusher"     , "Crusher Start (fast)");
		DOOM[184] = new LinedefSpecials('S', true , "Crusher"     , "Crusher Start");
		DOOM[185] = new LinedefSpecials('S', true , "Crusher"     , "Crusher Start (silent)");
		DOOM[188] = new LinedefSpecials('S', true , "Crusher"     , "Crusher Stop");

		DOOM[256] = new LinedefSpecials('W', true , "Stairs"      , "Stairs Raise by 8");
		DOOM[257] = new LinedefSpecials('W', true , "Stairs"      , "Stairs Raise by 16 (fast)");
		DOOM[258] = new LinedefSpecials('S', true , "Stairs"      , "Stairs Raise by 8");
		DOOM[259] = new LinedefSpecials('S', true , "Stairs"      , "Stairs Raise by 16 (fast)");

		DOOM[143] = new LinedefSpecials('W', false, "Lift"        , "Lift Raise by 24 (changes texture)");
		DOOM[144] = new LinedefSpecials('W', false, "Lift"        , "Lift Raise by 32 (changes texture)");
		DOOM[148] = new LinedefSpecials('W', true , "Lift"        , "Lift Raise by 24 (changes texture)");
		DOOM[149] = new LinedefSpecials('W', true , "Lift"        , "Lift Raise by 32 (changes texture)");
		DOOM[162] = new LinedefSpecials('S', false, "Lift"        , "Lift Perpetual Lowest and Highest Floors");
		DOOM[163] = new LinedefSpecials('S', false, "Lift"        , "Lift Stop");
		DOOM[181] = new LinedefSpecials('S', true , "Lift"        , "Lift Perpetual Lowest and Highest Floors");
		DOOM[182] = new LinedefSpecials('S', true , "Lift"        , "Lift Stop");
		DOOM[211] = new LinedefSpecials('S', true , "Lift"        , "Lift Raise to Ceiling (instantly)");
		DOOM[212] = new LinedefSpecials('W', true , "Lift"        , "Lift Raise to Ceiling (instantly)");
		DOOM[227] = new LinedefSpecials('W', false, "Lift"        , "Lift Raise to Next Highest Floor (fast)");
		DOOM[228] = new LinedefSpecials('W', true , "Lift"        , "Lift Raise to Next Highest Floor (fast)");
		DOOM[229] = new LinedefSpecials('S', false, "Lift"        , "Lift Raise to Next Highest Floor (fast)");
		DOOM[230] = new LinedefSpecials('S', true , "Lift"        , "Lift Raise to Next Highest Floor (fast)");
		DOOM[231] = new LinedefSpecials('W', false, "Lift"        , "Lift Lower to Next Lowest Floor (fast)");
		DOOM[232] = new LinedefSpecials('W', true , "Lift"        , "Lift Lower to Next Lowest Floor (fast)");
		DOOM[233] = new LinedefSpecials('S', false, "Lift"        , "Lift Lower to Next Lowest Floor (fast)");
		DOOM[234] = new LinedefSpecials('S', true , "Lift"        , "Lift Lower to Next Lowest Floor (fast)");
		DOOM[235] = new LinedefSpecials('W', false, "Lift"        , "Lift Move to Same Floor Height (fast)");
		DOOM[236] = new LinedefSpecials('W', true , "Lift"        , "Lift Move to Same Floor Height (fast)");
		DOOM[237] = new LinedefSpecials('S', false, "Lift"        , "Lift Move to Same Floor Height (fast)");
		DOOM[238] = new LinedefSpecials('S', true , "Lift"        , "Lift Move to Same Floor Height (fast)");

		DOOM[197] = new LinedefSpecials('G', false, "Exit"        , "Exit Level");
		DOOM[198] = new LinedefSpecials('G', false, "Exit"        , "Exit Level (goes to secret level)");

		DOOM[156] = new LinedefSpecials('W', true , "Light"       , "Light Start Blinking");
		DOOM[157] = new LinedefSpecials('W', true , "Light"       , "Light Change to Darkest Adjacent");
		DOOM[169] = new LinedefSpecials('S', false, "Light"       , "Light Change to Brightest Adjacent");
		DOOM[170] = new LinedefSpecials('S', false, "Light"       , "Light Change to 35");
		DOOM[171] = new LinedefSpecials('S', false, "Light"       , "Light Change to 255");
		DOOM[172] = new LinedefSpecials('S', false, "Light"       , "Light Start Blinking");
		DOOM[173] = new LinedefSpecials('S', false, "Light"       , "Light Change to Darkest Adjacent");
		DOOM[192] = new LinedefSpecials('S', true , "Light"       , "Light Change to Brightest Adjacent");
		DOOM[193] = new LinedefSpecials('S', true , "Light"       , "Light Start Blinking");
		DOOM[194] = new LinedefSpecials('S', true , "Light"       , "Light Change to Darkest Adjacent");

		DOOM[174] = new LinedefSpecials('S', false, "Teleport"    , "Teleport (also monsters)");
		DOOM[195] = new LinedefSpecials('S', true , "Teleport"    , "Teleport (also monsters)");
		DOOM[207] = new LinedefSpecials('W', false, "Teleport"    , "Teleport (also monsters, silent, same angle)");
		DOOM[208] = new LinedefSpecials('W', true , "Teleport"    , "Teleport (also monsters, silent, same angle)");
		DOOM[209] = new LinedefSpecials('S', false, "Teleport"    , "Teleport (also monsters, silent, same angle)");
		DOOM[210] = new LinedefSpecials('S', true , "Teleport"    , "Teleport (also monsters, silent, same angle)");
		DOOM[243] = new LinedefSpecials('W', false, "Teleport"    , "Teleport to Line With Same Tag (silent, same angle)");
		DOOM[244] = new LinedefSpecials('W', true , "Teleport"    , "Teleport to Line With Same Tag (silent, same angle)");
		DOOM[262] = new LinedefSpecials('W', false, "Teleport"    , "Teleport to Line With Same Tag (silent, reversed angle)");
		DOOM[263] = new LinedefSpecials('W', true , "Teleport"    , "Teleport to Line With Same Tag (silent, reversed angle)");
		DOOM[264] = new LinedefSpecials('W', false, "Teleport"    , "Teleport to Line With Same Tag (also monsters, silent, reversed angle)");
		DOOM[265] = new LinedefSpecials('W', true , "Teleport"    , "Teleport to Line With Same Tag (also monsters, reversed angle)");
		DOOM[266] = new LinedefSpecials('W', false, "Teleport"    , "Teleport to Line With Same Tag (monsters only, silent)");
		DOOM[267] = new LinedefSpecials('W', true , "Teleport"    , "Teleport to Line With Same Tag (monsters only, silent)");
		DOOM[268] = new LinedefSpecials('W', false, "Teleport"    , "Teleport (monsters only, silent)");
		DOOM[269] = new LinedefSpecials('W', true , "Teleport"    , "Teleport (monsters only, silent)");

		DOOM[145] = new LinedefSpecials('W', false, "Ceiling"     , "Ceiling Lower to Floor (fast)");
		DOOM[151] = new LinedefSpecials('W', true , "Ceiling"     , "Ceiling Raise to Highest Ceiling");
		DOOM[152] = new LinedefSpecials('W', true , "Ceiling"     , "Ceiling Lower to Floor (fast)");
		DOOM[166] = new LinedefSpecials('S', false, "Ceiling"     , "Ceiling Raise to Highest Ceiling");
		DOOM[167] = new LinedefSpecials('S', false, "Ceiling"     , "Ceiling Lower to 8 Above Floor");
		DOOM[186] = new LinedefSpecials('S', true , "Ceiling"     , "Ceiling Raise to Highest Ceiling");
		DOOM[187] = new LinedefSpecials('S', true , "Ceiling"     , "Ceiling Lower to 8 Above Floor");
		DOOM[199] = new LinedefSpecials('W', false, "Ceiling"     , "Ceiling Lower to Lowest Ceiling");
		DOOM[200] = new LinedefSpecials('W', false, "Ceiling"     , "Ceiling Lower to Highest Floor");
		DOOM[201] = new LinedefSpecials('W', true , "Ceiling"     , "Ceiling Lower to Lowest Ceiling");
		DOOM[202] = new LinedefSpecials('W', true , "Ceiling"     , "Ceiling Lower to Highest Floor");
		DOOM[203] = new LinedefSpecials('S', false, "Ceiling"     , "Ceiling Lower to Lowest Ceiling");
		DOOM[204] = new LinedefSpecials('S', false, "Ceiling"     , "Ceiling Lower to Highest Floor");
		DOOM[205] = new LinedefSpecials('S', true , "Ceiling"     , "Ceiling Lower to Lowest Ceiling");
		DOOM[206] = new LinedefSpecials('S', true , "Ceiling"     , "Ceiling Lower to Highest Floor");
		DOOM[261] = new LinedefSpecials(' ', false, "Ceiling"     , "Ceiling Brightness to this Brightness");

		DOOM[ 85] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Texture Right");
		DOOM[214] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Ceiling Accelerates when Sector Changes Height");
		DOOM[215] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Floor Accelerates when Sector Changes Height");
		DOOM[216] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Things Accelerates when Sector Changes Height");
		DOOM[217] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Floor/Things Accelerates when Sector Changes Height");
		DOOM[218] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Wall Accelerates when Sector Changes Height");
		DOOM[245] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Ceiling when Sector Changes Height");
		DOOM[246] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Floor when Sector Changes Height");
		DOOM[247] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Move Things when Sector Changes Height");
		DOOM[248] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Floor/Move Things when Sector Changes Height");
		DOOM[249] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Wall when Sector Changes Height");
		DOOM[250] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Ceiling according to Line Vector");
		DOOM[251] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Floor according to Line Vector");
		DOOM[252] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Move Things according to Line Vector");
		DOOM[253] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Floor, Move Things");
		DOOM[254] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Wall according to Line Vector");
		DOOM[255] = new LinedefSpecials(' ', false, "Scroll"      , "Scroll Wall using Sidedef Offsets");

		DOOM[ 78] = new LinedefSpecials('S', true , "Change"      , "Change Texture and Effect to Nearest");
		DOOM[153] = new LinedefSpecials('W', false, "Change"      , "Change Texture And Effect");
		DOOM[154] = new LinedefSpecials('W', true , "Change"      , "Change Texture And Effect");
		DOOM[189] = new LinedefSpecials('S', false, "Change"      , "Change Texture And Effect");
		DOOM[190] = new LinedefSpecials('S', true , "Change"      , "Change Texture And Effect");
		DOOM[239] = new LinedefSpecials('W', false, "Change"      , "Change Texture and Effect to Nearest");
		DOOM[240] = new LinedefSpecials('W', true , "Change"      , "Change Texture and Effect to Nearest");
		DOOM[241] = new LinedefSpecials('S', false, "Change"      , "Change Texture and Effect to Nearest");

		DOOM[223] = new LinedefSpecials(' ', false, "Friction"    , "Friction Tagged Sector: Drag < 100, Slide > 100");

		DOOM[224] = new LinedefSpecials(' ', false, "Wind/Current", "Wind according to Line Vector");
		DOOM[225] = new LinedefSpecials(' ', false, "Wind/Current", "Current according to Line Vector");
		DOOM[226] = new LinedefSpecials(' ', false, "Wind/Current", "Wind/Current by Push/Pull Thing In Sector");

		DOOM[242] = new LinedefSpecials(' ', false, "Create"      , "Create Fake Ceiling and Floor");

		DOOM[260] = new LinedefSpecials(' ', false, "Translucent" , "Translucent (Middle Texture)");

		DOOM[271] = new LinedefSpecials(' ', false, "Transfer"    , "Transfer Sky Texture to Tagged Sectors");
		DOOM[272] = new LinedefSpecials(' ', false, "Transfer"    , "Transfer Sky Texture to Tagged Sectors (flipped)");
		// @formatter:on
	}

	private static void boomGeneralizedSpecials() {
		for (int i = 16384; i < 32768; i++) {
			int     flat       = i / 8192 & 1;
			int     trigger    = i / 2 & 3;
			boolean repeatable = (i & 1) == 1;
			int     direction  = i / 64 & 1;
			int     target     = i / 128 & 7;
			int     speed      = i / 8 & 3;
			int     change     = i / 1024 & 3;
			int     model      = i / 32 & 1;
			boolean crusher    = (i / 4096 & 1) == 1;
			String description = GENERALIZED_FLAT[flat] + GENERALIZED_DIRECTION[direction] + GENERALIZED_TARGET[target]
			                     + GENERALIZED_SPEED[speed] + GENERALIZED_CHANGE[change] + GENERALIZED_MODEL[model]
			                     + (crusher ? ", Crushes" : "");
			DOOM[i] =
					new LinedefSpecials(GENERALIZED_TRIGGER[trigger], repeatable, GENERALIZED_FLAT[flat], description);
		}
		for (int i = 15360; i < 16384; i++) {
			int     trigger    = i / 2 & 3;
			boolean repeatable = (i & 1) == 1;
			int     action     = i / 32 & 3;
			int     speed      = i / 8 & 3;
			int     wait       = i / 256 & 3;
			boolean monsters   = (i / 128 & 1) == 1;
			String description = "Door" + GENERALIZED_ACTION[action] + GENERALIZED_SPEED[speed] +
			                     GENERALIZED_WAIT[wait]
			                     + (monsters ? ", Also monsters" : "");
			DOOM[i] = new LinedefSpecials(GENERALIZED_TRIGGER[trigger], repeatable, "Door", description);
		}
		for (int i = 14336; i < 15360; i++) {
			int     trigger     = i / 2 & 3;
			boolean repeatable  = (i & 1) == 1;
			int     action      = i / 32 & 1;
			int     speed       = i / 8 & 3;
			int     lock        = i / 64 & 7;
			boolean combination = (i / 512 & 1) == 1;
			String description =
					"Locked Door" + GENERALIZED_ACTION[action] + GENERALIZED_SPEED[speed] + GENERALIZED_LOCK[lock]
					+ (combination ? ", Keycard and Skullkey are same" : "");
			DOOM[i] = new LinedefSpecials(GENERALIZED_TRIGGER[trigger], repeatable, "Locked Door", description);
		}
		for (int i = 13312; i < 14336; i++) {
			int     trigger    = i / 2 & 3;
			boolean repeatable = (i & 1) == 1;
			int     target     = i / 256 & 1;
			int     speed      = i / 8 & 3;
			int     delay      = i / 64 & 3;
			boolean monsters   = (i / 32 & 1) == 1;
			String description = "Lift" + GENERALIZED_LIFT[target] + GENERALIZED_SPEED[speed] +
			                     GENERALIZED_DELAY[delay]
			                     + (monsters ? ", Also monsters" : "");
			DOOM[i] = new LinedefSpecials(GENERALIZED_TRIGGER[trigger], repeatable, "Lift", description);
		}
		for (int i = 12288; i < 13312; i++) {
			int     trigger    = i / 2 & 3;
			boolean repeatable = (i & 1) == 1;
			int     direction  = i / 256 & 1;
			int     step       = i / 64 & 3;
			int     speed      = i / 8 & 3;
			boolean breakAt    = (i / 512 & 1) == 1;
			boolean monsters   = (i / 32 & 1) == 1;
			String description = "Stairs" + GENERALIZED_DIRECTION[direction] + GENERALIZED_STEP[step]
			                     + GENERALIZED_SPEED[speed] + (breakAt ? ", Break at different texture" : "")
			                     + (monsters ? ", Also monsters" : "");
			DOOM[i] = new LinedefSpecials(GENERALIZED_TRIGGER[trigger], repeatable, "Stairs", description);
		}
		for (int i = 12160; i < 12288; i++) {
			int     trigger    = i / 2 & 3;
			boolean repeatable = (i & 1) == 1;
			int     speed      = i / 8 & 3;
			boolean silent     = (i / 64 & 1) == 1;
			boolean monsters   = (i / 32 & 1) == 1;
			String description = "Crusher" + GENERALIZED_SPEED[speed] + (silent ? ", Silent" : "")
			                     + (monsters ? ", Also monsters" : "");
			DOOM[i] = new LinedefSpecials(GENERALIZED_TRIGGER[trigger], repeatable, "Crusher", description);
		}
	}

	private static void zdoomSpecials() {
		// @formatter:off
		DOOM[340] = new LinedefSpecials(' ', false, "Plane"       , "Plane Align Floor at front");
		DOOM[341] = new LinedefSpecials(' ', false, "Plane"       , "Plane Align Ceiling at front");
		DOOM[342] = new LinedefSpecials(' ', false, "Plane"       , "Plane Align Floor and Ceiling at front");
		DOOM[343] = new LinedefSpecials(' ', false, "Plane"       , "Plane Align Floor at back");
		DOOM[344] = new LinedefSpecials(' ', false, "Plane"       , "Plane Align Ceiling at back");
		DOOM[345] = new LinedefSpecials(' ', false, "Plane"       , "Plane Align Floor and Ceiling at back");
		DOOM[346] = new LinedefSpecials(' ', false, "Plane"       , "Plane Align Floor at back and Ceiling at front");
		DOOM[347] = new LinedefSpecials(' ', false, "Plane"       , "Plane Align Floor at front and Ceiling at back");
		// @formatter:on
	}

	public LinedefSpecials(char trigger_type, boolean trigger_repeatable, String category, String title) {
		this.trigger_type = trigger_type;
		this.trigger_repeatable = trigger_repeatable;
		this.category = category;
		this.title = title;
	}
}
