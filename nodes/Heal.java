package gbagility.nodes;

import gbagility.util.Obstacles;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

public class Heal extends Node {

	@Override
	public boolean activate() {

		return (Players.getLocal().getHealthPercent() < 50);
	}

	@Override
	public void execute() {
		if (Inventory.getItem(Obstacles.FOODIDS) != null) {
			if (Inventory.getItem(Obstacles.FOODIDS).getWidgetChild()
					.interact("Eat")) {
				Task.sleep(1200);
			}
		}

	}

}