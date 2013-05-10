package gbagility.nodes.Gnome;

import gbagility.util.Condition;
import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class GOne extends Node {

	@Override
	public boolean activate() {

		return Obstacles.G1.contains(Players.getLocal().getLocation())
				&& Players.getLocal().getAnimation() != Obstacles.GLOG
						.getAnimation();
	}

	@Override
	public void execute() {
		final SceneObject a = SceneEntities.getNearest(Obstacles.GLOG.getID());

		if (a != null) {
			if (Calculations.distance(Players.getLocal().getLocation(), a) < 5) {
				if (a.interact("Walk-across")) {

					if (Methods.nap(new Condition() {
						@Override
						public boolean validate() {

							return Players.getLocal().getAnimation() == Obstacles.GLOG
									.getAnimation();
						}
					}, Random.nextInt(500, 800)))
						;

				}
			} else if (!Players.getLocal().isMoving()) {
				Task.sleep(2100, 2400);
				Walking.walk(a);
				final Timer wait = new Timer(500);
				while (wait.isRunning()
						&& Calculations.distance(a, Players.getLocal()
								.getLocation()) >= 5) {
					sleep(100);
				}
			} else if (Players.getLocal().isMoving() && !a.isOnScreen()) {
				Methods.cameraTurnTo(a);
			}
		}

	}

}