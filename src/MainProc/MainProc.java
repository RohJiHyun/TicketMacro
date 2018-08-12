package MainProc;

import InputProc.ActionController;
import ScreenProc.MainPanel;
import ScreenProc.Options;

public class MainProc {

	public static void main(String args[]) {

		MainDeskFrame desk = new MainDeskFrame();
		desk.setResizable(false);
		MainPanel mainPanel = new MainPanel();
		Options option = new Options();
		ScreenManager screenManager = new ScreenManager(desk, mainPanel, option);

	}
}
