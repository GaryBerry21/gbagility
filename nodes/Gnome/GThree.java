package gbagility.nodes.Gnome;

import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class GThree extends Node {

	@Override
	public boolean activate() {

		return Obstacles.G3.contains(Players.getLocal().getLocation())
				&& Players.getLocal().getAnimation() != Obstacles.GBRANCH
						.getAnimation();
	}

	@Override
	public void execute() {

		final SceneObject a = SceneEntities.getNearest(Obstacles.GBRANCH
				.getID());
		if (a != null) {
			if (a.isOnScreen()) {
				if (a.interact("Climb")) {
					Task.sleep(500);
					final Timer wait = new Timer(600);

					while (wait.isRunning()
							&& Players.getLocal().getAnimation() != Obstacles.GBRANCH
									.getAnimation()) {
						Task.sleep(20, 40);
					}
				}
			} else
				Methods.cameraTurnTo(a);
		}

	}

}