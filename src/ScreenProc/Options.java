package ScreenProc;

import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPanel;

import InputProc.ActionController;
import InputProc.FileManager;

public class Options extends JPanel{
	
	PwrBtn update;
	PwrBtn cancel;
	UserTextField hotKey[];
	TextField timeDelay;
	JLabel note, record;
	String noteText= "����â�Դϴ�.";
	ActionController actionController;
	
	FileManager fmanger=null;
	
	
	
	public Options()
	{
		hotKey=new UserTextField[2];
		hotKey[0]=new UserTextField("");
		hotKey[1]=new UserTextField("");
		timeDelay = new TextField();
		update=new PwrBtn(PwrBtn.BtnType.UPDATE, "������Ʈ");
		cancel=new PwrBtn(PwrBtn.BtnType.CANCEL, "��      ��");
		note=new JLabel(noteText);
		
		this.add(note);
		this.add(hotKey[0]);
		this.add(hotKey[1]);
		this.add(update);
		this.add(cancel);
			
	}
	
	
	
	private void setAddKeyListener()
	{
		update.addActionListener(actionController);
		cancel.addActionListener(actionController);
	}
	
	public  void saveOptions()//�ɼ� ���� -> ���� �Ŵ����� ó�� ���.
	{
		if(fmanger==null)
			System.out.println("FIleManager is null.Error");
		
	}
	
	public void setController(ActionController e)
	{
		actionController=e;
		System.out.println("setListener");
		setAddKeyListener();
	}
	
	public void setFileManager(FileManager fmg)
	{
		fmanger=fmg;
	}
	
	
}
