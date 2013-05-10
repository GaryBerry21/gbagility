package gbagility.util;

import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Entity;
import org.powerbot.game.api.wrappers.Locatable;
import org.powerbot.game.api.wrappers.node.SceneObject;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Methods {

	public static boolean doObstacle(final int obstacle, final String action) {
		final SceneObject ob = SceneEntities.getNearest(obstacle);

		if (ob != null) {
			if (ob.isOnScreen()) {
				if (ob.interact(action)) {
					Task.sleep(300, 600);

				}
			} else
				cameraTurnTo(ob);
		}
		return false;
	}

	public static boolean nap(final Condition cond, final int wait) {
		final Timer t = new Timer(wait);
		while (t.isRunning()) {
			if (cond.validate())
				return true;
			Task.sleep(100, 150);
		}
		return false;
	}

	public static void cameraTurnTo(final Locatable loc) {
		final Thread t = new Thread() {
			@Override
			public void run() {
				Camera.turnTo(loc);
				if (!isOnScreen((Entity) loc))
					Camera.setPitch(false);
			}
		};
		t.start();
	}

	public static boolean isOnScreen(final Entity e) {

		final WidgetChild actionbar = Widgets.get(640, 6);
		return e.isOnScreen()
				&& (actionbar == null || !(actionbar != null
						&& actionbar.isOnScreen() && actionbar
						.getBoundingRectangle().contains(e.getCentralPoint())));
	}

	public static boolean NeedsBoost() {
		return Variables.RequiredLvl > Skills.getLevel(Skills.AGILITY);
	}

}
