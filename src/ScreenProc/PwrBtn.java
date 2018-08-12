package ScreenProc;

import javax.swing.JButton;




public class PwrBtn extends JButton{
	//the button types info enum
	public enum BtnType{ADD, REMOVE, RECORD_START, RECORD_END , EXCUTE, UPDATE, CANCEL}
	public enum BtnSizeType{OPTION, NORMAL} 
	private BtnType btnType;
	
	
	public PwrBtn(BtnType btnType, String text) {
		super.setText(text);
		this.btnType=btnType;
	}
	
	public PwrBtn(BtnType btnType, String text, BtnSizeType size)
	{
		this(btnType, text);
		switch(size)
		{
		case NORMAL:
			setSize(10, 20);
			break;
		case OPTION:
			setSize(20, 40);
			break;
		}
		
		
	}
	
	public BtnType getBtnType()
	{
		return btnType;
	}
	

}
