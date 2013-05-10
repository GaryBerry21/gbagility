package gbagility.nodes.Barbarian;

import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;

public class SecondLog extends Node {

	@Override
	public boolean activate() {

		return (Obstacles.SecondLogArea.contains(Players.getLocal()
				.getLocation()) && Players.getLocal().isIdle() && (Players
				.getLocal().getAnimation() == -1))
				|| Players.getLocal().getAnimation() == Obstacles.BSWING
						.getAnimation();
	}

	@Override
	public void execute() {

		Methods.doObstacle(Obstacles.BLOG.getID(), "Walk");

	}

}