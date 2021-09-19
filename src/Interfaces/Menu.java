package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import Interfaces.Principal;
import Elements.Configuration;

public class Menu extends JPanel {
	public String txt;


	/**
	 * Create the panel.
	 */
	public Menu() {
        initComponents();
	}
	
    private void initComponents()
    {

		this.setBackground(new Color(255, 235, 205));
		this.setLayout(null);	
		
		
		JLabel lblNewLabel = new JLabel("Bienvenue");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 27));
		lblNewLabel.setForeground(new Color(0, 128, 128));
		this.add(lblNewLabel);
		

		
		JLabel lblNewLabel_1 = new JLabel("Choisissez le type du graphe :");
		lblNewLabel_1.setBounds(10, 11, 195, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		this.add(lblNewLabel_1);
		
		JRadioButton rdbtnSimple = new JRadioButton("Graphe Simple");
		rdbtnSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuration.oriente= false;
				Configuration.pondere=false;
				txt="done";
			}
		});
		rdbtnSimple.setBounds(142, 41, 173, 25);
		rdbtnSimple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(rdbtnSimple);
		
		JRadioButton rdbtnOriente = new JRadioButton("Graphe Orient\u00E9");
		rdbtnOriente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuration.oriente= true;
				Configuration.pondere=false;
				txt="done";
			}
		});
		rdbtnOriente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOriente.setBounds(142, 69, 173, 23);
		this.add(rdbtnOriente);
		
		JRadioButton rdbtnPondere = new JRadioButton("Graphe Pond\u00E9r\u00E9");
		rdbtnPondere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuration.oriente= false;
				Configuration.pondere=true;
				txt="done";
			}
		});
		rdbtnPondere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnPondere.setBounds(142, 95, 173, 23);
		this.add(rdbtnPondere);
		
		JRadioButton rdbtnOP = new JRadioButton("Graphe Orient\u00E9 Pond\u00E9r\u00E9");
		rdbtnOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuration.oriente= true;
				Configuration.pondere=true;
				txt="done";
			}
		});
		rdbtnOP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOP.setBounds(142, 121, 173, 23);
		this.add(rdbtnOP);
		
		ButtonGroup type = new ButtonGroup();
		type.add(rdbtnPondere);
		type.add(rdbtnOriente);
		type.add(rdbtnOP);
		type.add(rdbtnSimple);
		
		JButton btnLancer = new JButton("Lancer");
		btnLancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        	if(txt== "")
			        	{
			        		JOptionPane.showMessageDialog(Principal.getInstance(), "Veuillez selectionner votre choix s'il vous plaît !");
			        	}
			        	else
			        	{

							Principal.getInstance().setCentrePanel(new Canvas());
					        Configuration.checkAlgos();



			        	}
			}
		});
		btnLancer.setBackground(new Color(255, 255, 255));
		btnLancer.setForeground(new Color(0, 128, 128));
		btnLancer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLancer.setBounds(177, 160, 89, 23);
		this.add(btnLancer);
		
		JLabel lblNewLabel_2 = new JLabel("Ou cliquez sur le mode d'emploi :");
		lblNewLabel_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(10, 220, 207, 14);
		this.add(lblNewLabel_2);
		
		JButton btnME = new JButton("Mode d'emploi");
		btnME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	String url="guide\\mode_emploi.html";
		    	File htmlFile = new File(url);
		    	try {
					Desktop.getDesktop().browse(htmlFile.toURI());
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnME.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnME.setForeground(new Color(178, 34, 34));
		btnME.setBounds(307, 217, 134, 23);
		this.add(btnME);
	}

}
