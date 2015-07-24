package com.loncoto.InterfaceBuilder.principal;

import javax.swing.JFrame;

import com.loncoto.InterfaceBuilder.factory.WindowFactory;

public class Program {

	public static void main(String[] args) {
		
		WindowFactory wf  = new WindowFactory("fenetre1.xml");
		
		JFrame f1 = wf.buildWindow("window1");
		f1.setVisible(true);
		
		JFrame f2 = wf.buildWindow("window2");
		f2.setVisible(true);
		
		JFrame f3 = wf.buildWindow("window3");
		f3.setVisible(true);
	}

}
