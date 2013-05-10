package gbagility.nodes.Gnome;

import gbagility.util.Obstacles;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class GFour extends Node {

	@Override
	public boolean activate() {

		return Obstacles.G4.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {

		final SceneObject a = SceneEntities.getNearest(Obstacles.GTREE.getID());
		if (a != null) {
			if (a.isOnScreen()) {
				if (a.interact("Climb")) {
					Task.sleep(500);
					final Timer wait = new Timer(600);

					while (wait.isRunning()
							&& Players.getLocal().getAnimation() != Obstacles.GTREE
									.getAnimation()) {
						Task.sleep(20, 40);
					}
				}
			} else
				Camera.turnTo(a);

		}

	}

}
