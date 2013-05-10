package gbagility.nodes.Barbarian;

import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;

public class SixthArea extends Node {

	@Override
	public boolean activate() {

		return Obstacles.SixthCrossBeamArea.contains(Players.getLocal()
				.getLocation());
	}

	@Override
	public void execute() {

		Methods.doObstacle(Obstacles.BBALANCE.getID(), "Cross");

	}

}