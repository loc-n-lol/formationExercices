package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import bdd.DAOIncidents;
import donnees.Incident;

public class MainFrame extends JFrame implements ActionListener {
	
	private DAOIncidents base;
	
	private JButton btCreer, btEditer, btSupprimer, btRafraichir;
	private JList<Incident> list;
	private DefaultListModel<Incident> listData;
	
	private IncidentFrame incidentFrame;
	
	private static final String ACTION_CREER = "c";
	private static final String ACTION_EDITER = "e";
	private static final String ACTION_SUPPR = "s";
	private static final String ACTION_RAFRAICHIR = "r";	
	
	public MainFrame() {
		super("Incidents");
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(4, 4));
		
		////////////////////////////////////////////////////
		
		JPanel pan1 = new JPanel();
		add(pan1, BorderLayout.NORTH);
		
		
		pan1.setLayout(new GridLayout(1, 4, 4, 4));
		
		btCreer = new JButton("Créer");
		btCreer.addActionListener(this);
		btCreer.setActionCommand(ACTION_CREER);
		
		btEditer = new JButton("Editer");
		btEditer.addActionListener(this);
		btEditer.setActionCommand(ACTION_EDITER);
		
		btSupprimer = new JButton("Supprimer");
		btSupprimer.addActionListener(this);
		btSupprimer.setActionCommand(ACTION_SUPPR);
		
		btRafraichir = new JButton("Rafraichir");
		btRafraichir.addActionListener(this);
		btRafraichir.setActionCommand(ACTION_RAFRAICHIR);
		
		pan1.add(btCreer);
		pan1.add(btEditer);
		pan1.add(btSupprimer);
		pan1.add(btRafraichir);
		
		////////////////////////////////////////////////////
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1, 1, 4, 4));
		add (pan2, BorderLayout.CENTER);
		
		listData = new DefaultListModel<Incident>();
		list = new JList<Incident>(listData);
		pan2.add(new JScrollPane(list));
		
		//listData.addElement(new Incident(1, "panne signalisation", new Date(), 3, "routine"));
		//listData.addElement(new Incident(2, "panne signalisation", new Date(), 3, "routine"));
		
		////////////////////////////////////////////////////
		
		incidentFrame = new IncidentFrame(this);
		
		base = new DAOIncidents();
		
		rafraichir();
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand())
		{
		case ACTION_CREER:
			creer_incident();
			break;
		case ACTION_EDITER:
			editer_incident();
			break;
		case ACTION_SUPPR:
			supprimer_incident();
			break;
		case ACTION_RAFRAICHIR:
			rafraichir();
			break;
		}
		
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////
//			RAFRAICHIR
/////////////////////////////////////////////////////////////////////////////////////////////////////		
	private void rafraichir() {
		listData.clear();
		
		ArrayList<Incident> liste_incidents = base.getAllIncidents();
		
		for (Incident i : liste_incidents)
			listData.addElement(i);
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
//			CREER
/////////////////////////////////////////////////////////////////////////////////////////////////////
	private void creer_incident() {
		incidentFrame.setVisible(true);
		incidentFrame.setAlwaysOnTop(true);
		
		incidentFrame.setIncident(null);
	}
	
	//Appelé par IncidentFrame
	public void insertion_liste(Incident incident)
	{
		//System.out.println("insertion " + incident.toString());
		listData.addElement(incident);
		System.out.println(base.enregistrerIncident(incident));
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
//			EDITER
/////////////////////////////////////////////////////////////////////////////////////////////////////	
	private void editer_incident() {
		incidentFrame.setVisible(true);
		incidentFrame.setAlwaysOnTop(true);
	
		incidentFrame.setIncident(list.getSelectedValue());
	}
	
	//Appelé par IncidentFrame
	public void update_list(Incident incident)
	{
		list.repaint();
		System.out.println(base.modifierIncident(incident));
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
//			SUPPRIMER
/////////////////////////////////////////////////////////////////////////////////////////////////////	
	private void supprimer_incident() {
		Incident i = list.getSelectedValue();
		
		if (i.getId() != 0)
			System.out.println(base.effacerIncident(i));
		
		listData.removeElement(i);	
	}





}
