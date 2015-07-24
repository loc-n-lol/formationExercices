package com.loncoto.InterfaceBuilder.windows;

import java.awt.GridLayout;
import java.awt.HeadlessException;

public class GridWindow extends BaseWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridWindow(String name, int x, int y) throws HeadlessException {
		super(name);

		setLayout(new GridLayout(x, y));
	}
	
}
