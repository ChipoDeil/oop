package General;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Display.Display;

public class General {
	public static void main(String[] args){
		Display.create(800, 600, "Game", 0xff00ff00);
		Timer t= new Timer(1000 / 60, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.clear();
				Display.render();
				Display.swapBuffers();
			}
		});
		t.setRepeats(true);
		t.start();
	}
}
