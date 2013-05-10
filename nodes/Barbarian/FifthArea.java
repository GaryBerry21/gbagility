package gbagility.nodes.Barbarian;

import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class FifthArea extends Node {

	@Override
	public boolean activate() {

		return Obstacles.FifthFireArea.contains(Players.getLocal()
				.getLocation());
	}

	@Override
	public void execute() {
		final SceneObject s = SceneEntities.getNearest(Obstacles.BFIRE.getID());

		if (s != null) {
			if (!s.isOnScreen()) {
				Methods.cameraTurnTo(s);

			} else if (s.isOnScreen()) {
				final Timer wait = new Timer(2000);

				while (wait.isRunning()
						&& (!Players.getLocal().getLocation()
								.equals(Obstacles.Springtile))) {
					Obstacles.Springtile.interact("Walk");
					Task.sleep(400, 500);

				}

				if (s.interact("Fire")) {
					Task.sleep(800, 1200);
				}
				/*
				 * if (Players.getLocal().getLocation()
				 * .equals(Variables.Springtile)) {
				 * 
				 * s.interact("Fire"); Task.sleep(800, 1200);
				 * 
				 * } else if (!Players.getLocal().getLocation()
				 * .equals(Variables.Springtile)) {
				 * Variables.Springtile.click(true); Task.sleep(800, 1200);
				 * s.interact("Fire"); Task.sleep(800, 1200); }
				 */
			}

		}

	}

}