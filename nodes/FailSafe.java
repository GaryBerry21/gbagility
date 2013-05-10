package gbagility.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class FailSafe extends Node {
	public boolean ABOpened() {
		return Widgets.get(640, 4).visible();
	}

	private void CloseAB() {
		if (Widgets.get(640, 30).visible()) {
			Widgets.get(640, 30).interact("Minimise");
			Task.sleep(300, 600);
		}
	}

	@Override
	public boolean activate() {

		// actionbar

		// xp dialogue

		// TODO Auto-generated method stub
		return ABOpened() || Widgets.get(1218, 73).visible();
	}

	@Override
	public void execute() {
		final WidgetChild Minimise = Widgets.get(640, 30);
		// xp dialogue
		final WidgetChild Close = Widgets.get(1218, 73);

		if (Minimise.validate()) {
			CloseAB();
		}
		if (Close.validate()) {
			Close.click(true);
			final Timer wait = new Timer(1000);

			while (wait.isRunning() && Close.validate()) {
				Task.sleep(20, 40);
			}
		}

	}

}
