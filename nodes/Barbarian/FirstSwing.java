package gbagility.nodes.Barbarian;

import gbagility.util.Obstacles;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class FirstSwing extends Node {

	@Override
	public boolean activate() {

		return (Obstacles.FirstSwingArea.contains(Players.getLocal()
				.getLocation()) || Obstacles.POND_AREA.contains(Players
				.getLocal().getLocation()))
				&& Players.getLocal().isIdle()
				&& !Players.getLocal().isMoving()
				&& Players.getLocal().getAnimation() != Obstacles.BSWING
						.getAnimation();
	}

	@Override
	public void execute() {
		final SceneObject s = SceneEntities
				.getNearest(Obstacles.BSWING.getID());

		if (s != null) {
			if (!s.isOnScreen()) {
				s.getLocation().clickOnMap();

			} else if (s.isOnScreen()) {

				if (s.interact("Swing")) {
					final Timer wait = new Timer(3000);
					while (wait.isRunning()
							&& !Obstacles.SecondLogArea.contains(Players
									.getLocal().getLocation())
							&& Players.getLocal().getAnimation() != Obstacles.BSWING
									.getAnimation()) {
						Task.sleep(20, 40);
					}

				}
			}
		}
	}

}