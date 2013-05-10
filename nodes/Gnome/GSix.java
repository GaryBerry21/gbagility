package gbagility.nodes.Gnome;

import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class GSix extends Node {

	@Override
	public boolean activate() {

		return (Obstacles.G6.contains(Players.getLocal().getLocation()) && Players
				.getLocal().getAnimation() != Obstacles.GPOLE.getAnimation())
				|| Players.getLocal().getAnimation() == Obstacles.GSIGN
						.getAnimation();
	}

	@Override
	public void execute() {

		final SceneObject a = SceneEntities.getNearest(Obstacles.GPOLE.getID());
		if (a != null) {
			if (a.isOnScreen()) {
				if (a.interact("Swing")) {
					final Timer wait = new Timer(3000);

					while (wait.isRunning()
							&& Players.getLocal().getAnimation() != Obstacles.GPOLE
									.getAnimation()) {
						Task.sleep(20, 40);
					}
				}

			} else
				Methods.cameraTurnTo(a);
			Task.sleep(200);

		}
	}

}