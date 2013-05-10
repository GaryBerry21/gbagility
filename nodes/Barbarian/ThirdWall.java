package gbagility.nodes.Barbarian;

import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class ThirdWall extends Node {

	@Override
	public boolean activate() {
		final SceneObject s = SceneEntities.getNearest(Obstacles.BWALL_RUN
				.getID());

		return (Obstacles.ThirdWallRunArea.contains(Players.getLocal()
				.getLocation()) && (Players.getLocal().getAnimation() == -1))
				|| ((s != null)
						&& (Players.getLocal().getAnimation() == Obstacles.BLOG
								.getAnimation()) && (s.getLocation()
						.distanceTo() < 7));

	}

	@Override
	public void execute() {

		Methods.doObstacle(Obstacles.BWALL_RUN.getID(), "Run");

	}

}