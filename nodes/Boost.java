package gbagility.nodes;

import gbagility.util.Methods;
import gbagility.util.Obstacles;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.bot.Context;

public class Boost extends Node {

	@Override
	public boolean activate() {

		return Methods.NeedsBoost() && Players.getLocal().getAnimation() == -1
				&& !Players.getLocal().isMoving();
	}

	@Override
	public void execute() {
		final Item pie = Inventory.getItem(Obstacles.PIE);
		if (pie != null) {
			pie.getWidgetChild().interact("Eat");

			final Timer wait = new Timer(1000);
			while (wait.isRunning() && Methods.NeedsBoost()) {
				Task.sleep(300, 500);
			}
		} else {
			Game.logout(true);
			Context.get().getScriptHandler().shutdown();
		}

	}
}
