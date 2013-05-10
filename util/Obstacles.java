package gbagility.util;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public enum Obstacles {

	// sorry this is how it formatted it after it saved haha

	BSWING(43526, 751, "Swing"), BLOG(43595, 9908, "Walk-across"), BWALL_RUN(
			43533, 10492, "Run-up"), BWALL(43597, 10023, "Climb"), BFIRE(43587,
			4189, "Fire"), BBALANCE(43527, 16079, "Cross"), BJUMPGAP(43531,
			2586, "Jump"), BROOF(43532, 11792, "Slide"), GLOG(69526, 9908,
			"Walk-across"), GNET(69383, 828, "Climb-over"), GBRANCH(69508, 828,
			"Climb"), GTREE(69506, 828, "Climb-up"), GSIGN(69514, 2922,
			"Run-across"), GPOLE(43529, 11789, "Swing-to"), GBARRIER(69381,
			2923, "Jump-over");

	private int OBJECT_ID;
	private int ANIMATION;
	private String action;

	Obstacles(final int OBJECT_ID, final int ANIMATION, final String action) {
		this.OBJECT_ID = OBJECT_ID;
		this.ANIMATION = ANIMATION;
		this.action = action;
	}

	public int getID() {
		return this.OBJECT_ID;
	}

	public int getAnimation() {
		return this.ANIMATION;
	}

	public String getAction() {
		return this.action;
	}

	// Food crap
	public final static int[] PIE = { 7218, 7220 };
	public final static int HALFPIE = 7220;
	boolean HASFOOD;
	public static int[] FOODIDS = { 333, 385, 7218, 7220, 15272, 15266, 391,
			697, 7946, 373, 365, 379, 361, };
	// Barbarian Area

	public final static Area FirstSwingArea = new Area(new Tile[] {
			new Tile(2543, 3559, 0), new Tile(2556, 3559, 0),
			new Tile(2556, 3550, 0), new Tile(2543, 3550, 0) });
	public final static Area POND_AREA = new Area(new Tile(2542, 3548, 0),
			new Tile(2549, 3550, 0));

	public final static Area SecondLogArea = new Area(new Tile[] {
			new Tile(2549, 3550, 0), new Tile(2556, 3550, 0),
			new Tile(2556, 3540, 0), new Tile(2549, 3540, 0) });

	public final static Area ThirdWallRunArea = new Area(new Tile[] {
			new Tile(2531, 3549, 0), new Tile(2549, 3549, 0),
			new Tile(2549, 3540, 0), new Tile(2531, 3540, 0) });

	public final static Area FourthWallClimbArea = new Area(new Tile[] {
			new Tile(2535, 3548, 2), new Tile(2539, 3548, 2),
			new Tile(2539, 3544, 2), new Tile(2535, 3544, 2) });

	public final static Tile Climbtile = new Tile(2537, 3546, 2);

	public final static Area FifthFireArea = new Area(new Tile[] {
			new Tile(2530, 3548, 3), new Tile(2538, 3548, 3),
			new Tile(2538, 3544, 3), new Tile(2530, 3544, 3) });

	public final static Tile Springtile = new Tile(2533, 3547, 3);

	public final static Area SixthCrossBeamArea = new Area(new Tile[] {
			new Tile(2529, 3555, 3), new Tile(2534, 3555, 3),
			new Tile(2534, 3552, 3), new Tile(2529, 3552, 3) });

	public final static Tile Jumptile = new Tile(2536, 3553, 3);

	public final static Area SeventhSlideArea = new Area(new Tile[] {
			new Tile(2537, 3555, 2), new Tile(2540, 3555, 2),
			new Tile(2540, 3551, 2), new Tile(2537, 3551, 2) });
	// Gnome
	public final static Area G1 = new Area(new Tile[] {
			new Tile(2458, 3451, 0), new Tile(2491, 3451, 0),
			new Tile(2491, 3431, 0), new Tile(2458, 3431, 0) });

	public final static Area G2 = new Area(new Tile[] {
			new Tile(2468, 3431, 0), new Tile(2481, 3431, 0),
			new Tile(2481, 3423, 0), new Tile(2468, 3423, 0) });

	public final static Area G3 = new Area(new Tile[] {
			new Tile(2470, 3425, 1), new Tile(2477, 3425, 1),
			new Tile(2477, 3421, 1), new Tile(2470, 3421, 1) });

	public final static Area G4 = new Area(new Tile[] {
			new Tile(2470, 3422, 2), new Tile(2478, 3422, 2),
			new Tile(2478, 3417, 2), new Tile(2470, 3417, 2) });

	public final static Area G5 = new Area(new Tile[] {
			new Tile(2471, 3422, 3), new Tile(2478, 3422, 3),
			new Tile(2478, 3417, 3), new Tile(2471, 3417, 3) });

	public final static Area G6 = new Area(new Tile[] {
			new Tile(2483, 3422, 3), new Tile(2488, 3422, 3),
			new Tile(2488, 3417, 3), new Tile(2483, 3417, 3) });

	public final static Area G7 = new Area(new Tile[] {
			new Tile(2481, 3436, 3), new Tile(2489, 3436, 3),
			new Tile(2489, 3431, 3), new Tile(2481, 3431, 3) });

}
