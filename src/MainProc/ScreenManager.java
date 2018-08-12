package MainProc;

import InputProc.ActionController;
import InputProc.FileManager;
import ScreenProc.MainPanel;
import ScreenProc.Options;

public class ScreenManager{

	MainDeskFrame desk;
	MainPanel mainPanel;
	Options option;
	ActionController actionController;
	FileManager fmg;
	
	public ScreenManager(MainDeskFrame desk, MainPanel mainPanel, Options option)//초기화 기본은 메인 화면.
	{
		actionController=new ActionController(this);
		//fmg=new FileManager();
		this.desk=desk;
		this.mainPanel=mainPanel;
		this.desk.add(mainPanel);
		this.option=option;
		setActionController();
		setManagers();
	}
	
	private void setActionController()//설정 패널과 조작 패널에 사용자 정의 액션리스너를 추가합니다. 
	{
		mainPanel.setController(actionController);
		option.setController(actionController);
	}
	private void setManagers()
	{
		option.setFileManager(fmg);
	}
	
	
	
	
	///////////////////////////////
	///클래스 외부에서 사용될 메소드 모음///
	//////////////////////////////
	public void changeOptionMenu() //옵션메뉴로 변경
	{
		desk.getContentPane().removeAll();
		desk.getContentPane().add(option);
		desk.revalidate();
		desk.repaint();	
	}
	
	public void changeMainWindow() //메인 화면으로 변경
	{

		desk.getContentPane().removeAll();
		desk.getContentPane().add(mainPanel);
		desk.revalidate();
		desk.repaint();
		
	}
	public void saveSetting()
	{
		option.saveOptions();
	}
	
	
}
