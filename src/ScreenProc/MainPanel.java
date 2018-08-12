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
		userDesiredTime = new TextField("시간을 적어주세요. ex)시:분:초");
		timeBar.setEditable(false);
		userDesiredTime.setEditable(false);

		addFile = new PwrBtn(PwrBtn.BtnType.ADD, "추가", PwrBtn.BtnSizeType.OPTION);
		removeFile = new PwrBtn(PwrBtn.BtnType.REMOVE, "삭제");
		execute = new PwrBtn(PwrBtn.BtnType.EXCUTE, "실행");
		changeOption = new PwrBtn(PwrBtn.BtnType.UPDATE, "옵션 변경");

		timeDependExcuteOption = new Checkbox("서버시간에 맞추어 실행");
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
