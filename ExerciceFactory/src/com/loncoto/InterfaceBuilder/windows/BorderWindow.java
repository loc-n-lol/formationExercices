package com.loncoto.InterfaceBuilder.windows;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;


public class BorderWindow extends BaseWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BorderWindow(String name) throws HeadlessException {
		super(name);

		setLayout(new BorderLayout());
	}

	@Override
	public void add(Component comp, Object constraints) {
		
		
		if (constraints instanceof String)
			switch((String)constraints)
			{
			case "north":
				constraints = BorderLayout.NORTH;
				break;
			case "south":
				constraints = BorderLayout.SOUTH;
				break;
			case "east":
				constraints = BorderLayout.EAST;
				break;
			case "west":
				constraints = BorderLayout.WEST;
				break;
			default:
				constraints = BorderLayout.CENTER;
				break;
			}
		
		super.add(comp, constraints);
	}

}
