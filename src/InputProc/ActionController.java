package InputProc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MainProc.ScreenManager;
import ScreenProc.PwrBtn;
//창의 전환을 처리한다.

public class ActionController implements ActionListener{
	
	private boolean changePanel; 
	PwrBtn tempBtn;
	ScreenManager screenManager;
	public ActionController(ScreenManager manager) {
	
		screenManager=manager;
		changePanel=false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		tempBtn=(PwrBtn)e.getSource();
		System.out.println("file");
		switch(tempBtn.getBtnType())
		{
		case UPDATE:
			changePanel();
			break;
		case CANCEL :
			changePanel();
			break;
		}
		
	}
	private void saveSetting()
	{
		
	}
	
	private void changePanel()
	{
		if(!changePanel)
			screenManager.changeOptionMenu();
		else
			screenManager.changeMainWindow();
		changePanel=!changePanel;
	}

}
