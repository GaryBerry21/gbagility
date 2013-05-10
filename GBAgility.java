package gbagility;

import gbagility.nodes.Boost;
import gbagility.nodes.FailSafe;
import gbagility.nodes.Heal;
import gbagility.nodes.Barbarian.FifthArea;
import gbagility.nodes.Barbarian.FirstSwing;
import gbagility.nodes.Barbarian.FourthWall;
import gbagility.nodes.Barbarian.JumperArea;
import gbagility.nodes.Barbarian.SecondLog;
import gbagility.nodes.Barbarian.SeventhArea;
import gbagility.nodes.Barbarian.SixthArea;
import gbagility.nodes.Barbarian.ThirdWall;
import gbagility.nodes.Gnome.GFive;
import gbagility.nodes.Gnome.GFour;
import gbagility.nodes.Gnome.GOne;
import gbagility.nodes.Gnome.GSeven;
import gbagility.nodes.Gnome.GSix;
import gbagility.nodes.Gnome.GThree;
import gbagility.nodes.Gnome.GTwo;
import gbagility.util.Variables;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.imageio.ImageIO;

import org.powerbot.core.Bot;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.input.Mouse.Speed;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.methods.widget.WidgetCache;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.client.Client;

@Manifest(authors = { "GaryBerry21" }, name = "GBAgility", description = "Supports Advanced Barbarian and Advanced Gnome Agility Course", version = 2.6)
public class GBAgility extends ActiveScript implements PaintListener,
		MouseListener {

	public Tree jobs = null;
	private Client client = Bot.client();
	private final static NumberFormat k = new DecimalFormat("###,###,###");

	@Override
	public void onStart() {
		Mouse.setSpeed(Speed.VERY_FAST);
		Camera.setPitch(true);
		Variables.Starttime = System.currentTimeMillis();
		Variables.Astartexp = Skills.getExperience(Skills.AGILITY);
		Variables.Startlvl = Skills.getRealLevel(Skills.AGILITY);
		if (jobs == null) {
			// gnome course
			if ((Players.getLocal().getLocation().getX() < 2500)) {
				Course = "Adv. Gnome";
				Variables.RequiredLvl = 85;
				jobs = new Tree(new Node[] { new FailSafe(), new Boost(),
						new Heal(), new GOne(), new GTwo(), new GThree(),
						new GFour(), new GFive(), new GSix(), new GSeven() });
			} else {
				// barbarian
				Course = "Adv. Barbarian";
				Variables.RequiredLvl = 90;

				jobs = new Tree(new Node[] { new FailSafe(), new Boost(),
						new Heal(), new FirstSwing(), new SecondLog(),
						new ThirdWall(), new FourthWall(), new FifthArea(),
						new SixthArea(), new JumperArea(), new SeventhArea() });
			}
		}

	}

	@Override
	public int loop() {
		if (Game.getClientState() != Game.INDEX_MAP_LOADED) {
			return 1000;
		}
		if (client != Bot.client()) {
			WidgetCache.purge();
			Bot.context().getEventManager().addListener(this);
			client = Bot.client();
		}

		if (jobs != null) {
			final Node job = jobs.state();
			if (job != null) {
				jobs.set(job);
				getContainer().submit(job);
				job.join();
			}
		}

		return 123;

	}

	@Override
	public void mouseEntered(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void drawMouse(final Graphics g) {
		g.setColor(Color.GREEN);
		final int mouseY = (int) Mouse.getLocation().getY();
		final int mouseX = (int) Mouse.getLocation().getX();
		g.drawLine(mouseX - 3, mouseY + 2, mouseX + 3, mouseY - 2);
		g.drawLine(mouseX + 3, mouseY + 2, mouseX - 3, mouseY - 2);
	}

	private Image getImage(final String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (final IOException e) {
			return null;
		}
	}

	// START: Code generated using Enfilade's Easel
	private final Image img = getImage("http://i199.photobucket.com/albums/aa183/juzie123/main-paint_zps36455fa3.png");
	// private final Color color1 = new Color(0, 0, 0, 76);
	// private final Color color2 = new Color(69, 20, 0);
	private final Color color3 = new Color(255, 255, 255);

	// private final BasicStroke stroke1 = new BasicStroke(1);

	private final Font font2 = new Font("Jokerman", 0, 15);

	boolean hide = false; // Will not hide paint on start
	Point p;
	Rectangle close = new Rectangle(1, 375, 515, 145);
	Rectangle open = new Rectangle(1, 375, 515, 145);

	private String Course;

	@Override
	public void onRepaint(final Graphics g1) {
		final int Aexp = Skills.getExperience(Skills.AGILITY)
				- Variables.Astartexp;
		int AExpHr;

		AExpHr = (int) ((Aexp * 3600000D) / Variables.RunTime.getElapsed());

		final int CurrentExp = Skills.getExperience(Skills.AGILITY);
		final int CurrentExpGained = CurrentExp - Variables.Astartexp;
		final int CurrentLvl = Skills.getRealLevel(Skills.AGILITY);
		final int levelups = CurrentLvl - Variables.Startlvl;

		long TTL = 0;
		if (CurrentLvl != 99) {
			TTL = (Variables.RunTime.getElapsed() * (Skills.XP_TABLE[CurrentLvl + 1] - CurrentExp))
					/ CurrentExpGained;
		}

		final Graphics2D g = (Graphics2D) g1;
		drawMouse(g);
		/*
		 * g.setColor(color1); g.fillRect(551, 391, 182, 121);
		 * g.setColor(color2); g.setStroke(stroke1); g.drawRect(551, 391, 182,
		 * 121);
		 */

		if (Game.getClientState() == 11) {
			if (!hide) {
				// show paint
				g.drawImage(img, 0, 390, null);

				g.setColor(color3);

				g.setFont(font2);
				g.drawString(
						"Run Time: " + Variables.RunTime.toElapsedString(), 69,
						465);
				g.drawString("XP Gained: " + k.format(Aexp), 69, 496);
				g.drawString("EXP/hr: " + k.format(AExpHr), 69, 527);
				g.drawString("TTNL: " + Time.format(TTL), 300, 465);
				if (CurrentLvl == Variables.Startlvl) {
					g.drawString("Agility Lvl: " + CurrentLvl, 300, 496);
				} else {
					g.drawString("Agility Lvl: " + CurrentLvl + "(" + levelups
							+ ")", 300, 496);
				}
				if (Course != null) {
					g.drawString(Course, 300, 527);
				}
			} else {
				// hide paint
			}
		}
	}

	@Override
	public void mouseClicked(final MouseEvent e) {
		p = e.getPoint();
		if (close.contains(p) && !hide) {
			hide = true;
		} else if (open.contains(p) && hide) {
			hide = false;
		}
	}

}
