package gbagility.nodes.Barbarian;

import gbagility.util.Obstacles;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class FourthWall extends Node {

	@Override
	public boolean activate() {

		return Obstacles.FourthWallClimbArea.contains(Players.getLocal()
				.getLocation())

		&& Players.getLocal().getAnimation() != Obstacles.BWALL.getAnimation();
	}

	@Override
	public void execute() {
		final SceneObject s = SceneEntities.getNearest(Obstacles.BWALL.getID());

		if (s != null) {
			if (!s.isOnScreen()) {
				Camera.turnTo(s);

			} else if (s.isOnScreen()) {
				final Timer wait = new Timer(2000);

				while (wait.isRunning()
						&& (!Players.getLocal().getLocation()
								.equals(Obstacles.Climbtile))) {
					Obstacles.Climbtile.interact("Walk");
					Task.sleep(400, 500);

				}

				if (s.interact("Climb")) {
					Task.sleep(800);
				}
			}

			/*
			 * if (Players.getLocal().getLocation().equals(Climbtile)) {
			 * 
			 * if (s.interact("Climb")) { Task.sleep(800, 1200); } } else if
			 * (!Players.getLocal().getLocation() .equals(Climbtile)) {
			 * Climbtile.click(true); Task.sleep(500, 600); s.interact("Climb");
			 * }
			 * 
			 * }
			 */
		}

	}

}
