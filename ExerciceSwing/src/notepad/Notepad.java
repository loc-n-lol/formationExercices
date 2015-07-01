package notepad;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class Notepad extends JFrame implements ActionListener, DocumentListener {

	private static boolean debug = false;
	
	private JTextField textField;
	private JButton buttonSave;
	private JButton buttonLoad;
	
	private JTextArea textArea;
	
	public static void main (String[] args)
	{
		new Notepad();
	}
	
	public Notepad()
	{
		super();
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(8, 8));
		
		//Panel
		JPanel panelHaut = new JPanel();
		add(panelHaut, BorderLayout.NORTH);
		BoxLayout blh = new BoxLayout(panelHaut, BoxLayout.X_AXIS);
		panelHaut.setLayout(blh);
		
		//Text Field
		textField = new JTextField(30);
		textField.getDocument().addDocumentListener(this);
		panelHaut.add(textField);
		
		//Buttons
		buttonLoad = new JButton("Load");
		buttonLoad.setEnabled(false);
		buttonSave = new JButton("Save");
		
		panelHaut.add(buttonLoad);
		panelHaut.add(buttonSave);
		
		buttonLoad.setActionCommand("load");
		buttonLoad.addActionListener(this);
		buttonSave.setActionCommand("save");
		buttonSave.addActionListener(this);
		
		//Text Area
		textArea = new JTextArea();	
		textArea.setLineWrap(true);
		add(new JScrollPane(textArea));
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand())
		{
		case "load":
			load();
			break;
			
		case "save":
			save();
			break;
		}
	}

	private void save() {
		if (debug)
			System.out.println("Save");
		
		
		File f = new File(textField.getText());
		
		if (f.exists())
		{
			if (!f.canWrite())
			{
				if (debug)
					System.out.println("!f.canWrite()");

				JOptionPane.showMessageDialog(this, "Impossible d'écraser ce fichier", "Erreur", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else
		{
			try {
			f.createNewFile();
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(this, "Impossible de créer le fichier à cet emplacement", "Erreur", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			errorMessageFileNotfound();
			return;
		}
		
		try {
			pw.write(textArea.getDocument().getText(0, textArea.getDocument().getLength()));
			if (debug)
				System.out.println("write");
		} catch (BadLocationException e) {
			errorMessageFileNotfound();
			return;
		}
		
		pw.close();
		

		
		
	}

	private void load() {
		if (debug)
			System.out.println("Load");
		
		File f = new File(textField.getText());
		
		if (f.exists())
		{
			Scanner reader = null;
			
			try {
				reader = new Scanner(f);
			} catch (FileNotFoundException e) {
				errorMessageFileNotfound();
				return;
			}
			
			StringBuilder sb = new StringBuilder();
			
			while (reader.hasNext())
			{
				sb.append(reader.nextLine());
				sb.append('\n');
			}
			
			textArea.setText(sb.toString());
			
			reader.close();
		}
		else
		{
			errorMessageFileNotfound();
			return;
		}
	}

	public void docChanged(DocumentEvent e)
	{
		Document d = e.getDocument();
		String filename = "";
		try {
			filename = d.getText(0, d.getLength());
		} catch (BadLocationException e1) {
			errorMessageFileNotfound();
			return;
		}
		File f = new File(filename);
		
		buttonLoad.setEnabled(f.exists());
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		docChanged(e);
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		docChanged(e);
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		docChanged(e);
	}
	
	private void errorMessageFileNotfound()
	{
		JOptionPane.showMessageDialog(this, "Fichier Introuvable", "Erreur", JOptionPane.ERROR_MESSAGE);
	}

}
