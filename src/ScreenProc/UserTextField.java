package ScreenProc;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

//자동 저장이 가능한 텍스트 필드.

public class UserTextField extends TextField {
	String tempKeySet;
	private KeyEvent[] keyCode;
	private int index;
	private String code;

	public UserTextField(String arg) {
		// TODO Auto-generated constructor stub

		setText(arg);
		setEditable(false);
		index = 0;
		setColumns(10);

		keyCode = new KeyEvent[3];
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				super.mouseClicked(arg0);
				setClear();
			}

		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (index < 3) {

					boolean isOverlap = false;
					if (index >= 1)
						while (keyCode[index - 1].getKeyCode() == e.getKeyCode()) {
							isOverlap = true;
							break;
						}
					if (!isOverlap)
						keyCode[index++] = e;
				}
				setKeyCode();
				invalidate();
			}

		});

	}

	private void setClear() {
		setText(null);
		index = 0;
	}

	private void setKeyCode() {
		code = keyCode[0].getKeyText(keyCode[0].getKeyCode());
		for (int i = 1; i < index; i++)
			code = code + "+" + keyCode[i].getKeyText(keyCode[i].getKeyCode());
		setText(code);

	}

	public KeyEvent[] getKeyCode() {
		return keyCode;
	}

	public int getIndex() {
		return index;

	}

}
