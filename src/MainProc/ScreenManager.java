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
	
	public ScreenManager(MainDeskFrame desk, MainPanel mainPanel, Options option)//�ʱ�ȭ �⺻�� ���� ȭ��.
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
	
	private void setActionController()//���� �гΰ� ���� �гο� ����� ���� �׼Ǹ����ʸ� �߰��մϴ�. 
	{
		mainPanel.setController(actionController);
		option.setController(actionController);
	}
	private void setManagers()
	{
		option.setFileManager(fmg);
	}
	
	
	
	
	///////////////////////////////
	///Ŭ���� �ܺο��� ���� �޼ҵ� ����///
	//////////////////////////////
	public void changeOptionMenu() //�ɼǸ޴��� ����
	{
		desk.getContentPane().removeAll();
		desk.getContentPane().add(option);
		desk.revalidate();
		desk.repaint();	
	}
	
	public void changeMainWindow() //���� ȭ������ ����
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
