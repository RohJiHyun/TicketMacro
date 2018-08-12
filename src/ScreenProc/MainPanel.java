package ScreenProc;

import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.System.Logger;

import javax.swing.JPanel;

import InputProc.ActionController;
import MainProc.ScreenManager;

public class MainPanel extends JPanel {
	TextField userDesiredTime;
	TextField timeBar;

	PwrBtn addFile, removeFile, record, execute, changeOption;
	ScreenManager screenManager;
	ActionController actionController = null;

	Checkbox timeDependExcuteOption;
	boolean timeDependChecker = false;

	public MainPanel() {
		init();
	}

	private void init() {
		timeBar = new TextField("Disconnected now :(");
		userDesiredTime = new TextField("�ð��� �����ּ���. ex)��:��:��");
		timeBar.setEditable(false);
		userDesiredTime.setEditable(false);

		addFile = new PwrBtn(PwrBtn.BtnType.ADD, "�߰�", PwrBtn.BtnSizeType.OPTION);
		removeFile = new PwrBtn(PwrBtn.BtnType.REMOVE, "����");
		execute = new PwrBtn(PwrBtn.BtnType.EXCUTE, "����");
		changeOption = new PwrBtn(PwrBtn.BtnType.UPDATE, "�ɼ� ����");

		timeDependExcuteOption = new Checkbox("�����ð��� ���߾� ����");
		timeDependExcuteOption.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent exearg) {
				// TODO Auto-generated method stub
				if (exearg.getStateChange() == 1) {
					timeBar.setEditable(true);
					userDesiredTime.setEditable(true);
					timeDependChecker = true;
				} else {
					timeBar.setEditable(false);
					userDesiredTime.setEditable(false);
					timeDependChecker = false;
				}

			}
		});

		setAddComponent();

	}

	private void setAddComponent() {
		add(timeBar);
		add(userDesiredTime);
		add(timeDependExcuteOption);
		add(addFile);
		add(removeFile);
		add(execute);
		add(changeOption);
	}

	public void setController(ActionController e) {
		actionController = e;
		System.out.println("setListener");
		setAddKeyListener();
	}

	private void setAddKeyListener() {
		timeBar.addActionListener(actionController);
		userDesiredTime.addActionListener(actionController);
		addFile.addActionListener(actionController);
		removeFile.addActionListener(actionController);
		execute.addActionListener(actionController);
		changeOption.addActionListener(actionController);
	}

	public void setScreenManager(ScreenManager manager) {
		screenManager = manager;
		
	}

}
