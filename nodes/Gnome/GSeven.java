package gbagility.nodes.Gnome;

import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;

public class GSeven extends Node {

	@Override
	public boolean activate() {

		return Obstacles.G7.contains(Players.getLocal().getLocation())
				&& Players.getLocal().getAnimation() != Obstacles.GBARRIER
						.getAnimation();
	}

	@Override
	public void execute() {
		Methods.doObstacle(Obstacles.GBARRIER.getID(), "Jump");

	}

}
