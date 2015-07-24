package com.loncoto.InterfaceBuilder.windows;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

public class FlowWindow extends BaseWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlowWindow(String name) throws HeadlessException {
		super(name);

		setLayout(new FlowLayout());
	}
	
}
