package Display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

import javax.swing.JFrame;

public abstract class Display {
	private static boolean created = false;
	private static JFrame window;
	private static Canvas content;
	private static int WIDTH;
	private static int HEIGHT;
	
	private static BufferedImage buffer;
	private static int[] bufferData;
	private static Graphics bufferGraphics;
	private static int clearColor;
	
	private static int _width = 0;
	private static int _height = 0;
	private static int v = 10;
	private static boolean choice = false;
	
	public static void create(int width, int height, String title, int _clearColor){
		if (created) {
			return;
		}
		WIDTH = width;
		HEIGHT = height;
		window = new JFrame(title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = new Canvas();
		
		Dimension size = new Dimension(width, height);
		content.setPreferredSize(size);
		content.setBackground(Color.BLACK);
		
		window.setResizable(false);
		window.getContentPane().add(content);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		bufferData = ( (DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
		bufferGraphics = buffer.getGraphics();
		clearColor = _clearColor;
		
		created = true;
	}
	
	
	public static void clear(){
		Arrays.fill(bufferData, clearColor);
	}
	
	public static void render(){
		
		bufferGraphics.fillOval(_width, HEIGHT/2 - 25, 50, 50);
	}
	
	public static void swapBuffers(){
		Graphics g = content.getGraphics();
		g.drawImage(buffer, 0, 0, null);
	}
	
}
