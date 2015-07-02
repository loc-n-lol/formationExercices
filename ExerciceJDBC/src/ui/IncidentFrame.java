package ui;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.Date;

import javax.swing.*;

import donnees.Incident;

public class IncidentFrame extends JFrame implements ActionListener {

	private MainFrame master; 

	private JTextField textDescription, textDate, textUrgence, textCategorie;
	private JButton okButton;
	private Incident incident;
	
	public IncidentFrame(MainFrame master)
	{
		super("Incident");
		
		this.master = master;
		
		setSize(400, 300);
		setLocationRelativeTo(master);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
		setLayout(new GridLayout(5, 1));
		
		JPanel panDesc = new JPanel(new BorderLayout(4, 4));
		JLabel labDesc = new JLabel("Description");
		textDescription = new JTextField();
		panDesc.add(labDesc, BorderLayout.NORTH);
		panDesc.add(textDescription, BorderLayout.CENTER);
		
		JPanel panDate = new JPanel(new BorderLayout(4, 4));
		JLabel labDate = new JLabel("Date");
		textDate = new JTextField();
		panDate.add(labDate, BorderLayout.NORTH);
		panDate.add(textDate, BorderLayout.CENTER);
		
		JPanel panUrgence = new JPanel(new BorderLayout(4, 4));
		JLabel labUrgence = new JLabel("Urgence");
		textUrgence = new JTextField();
		panUrgence.add(labUrgence, BorderLayout.NORTH);
		panUrgence.add(textUrgence, BorderLayout.CENTER);
		
		JPanel panCat = new JPanel(new BorderLayout(4, 4));
		JLabel labCat = new JLabel("Categorie");
		textCategorie = new JTextField();
		panCat.add(labCat, BorderLayout.NORTH);
		panCat.add(textCategorie, BorderLayout.CENTER);
		
		okButton = new JButton("Ok");
		
		okButton.addActionListener(this);
		
		add(panDesc);
		add(panDate);
		add(panUrgence);
		add(panCat);
		add(okButton);
		
		
		//setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean insertion = false;
		
		if (incident == null)
		{
			insertion = true;
			incident = new Incident();
		}

		try {
			incident.setDescription(textDescription.getText());
			incident.setDate(Incident.format.parse((textDate.getText())));
			incident.setUrgence(Integer.parseInt(textUrgence.getText()));
			incident.setCategorie(textCategorie.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		
		if (insertion)
		{
			master.insertion_liste(incident);
		}
		else
		{
			master.update_list(incident);		
		}
		
		setVisible(false);

	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
		
		if (incident != null)
		{
			textDescription.setText(incident.getDescription());
			textDate.setText(Incident.format.format(incident.getDate()));
			textUrgence.setText(Integer.toString(incident.getUrgence()));
			textCategorie.setText(incident.getCategorie());
		}
		else
		{
			textDescription.setText("");
			textDate.setText(Incident.format.format(new Date()));
			textUrgence.setText("1");
			textCategorie.setText("defaut");
		}
	}
}
