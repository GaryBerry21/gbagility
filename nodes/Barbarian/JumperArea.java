package gbagility.nodes.Barbarian;

import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;

public class JumperArea extends Node {

	@Override
	public boolean activate() {

		return Players.getLocal().getLocation().equals(Obstacles.Jumptile);
	}

	@Override
	public void execute() {

		Methods.doObstacle(Obstacles.BJUMPGAP.getID(), "Jump");

	}

}
