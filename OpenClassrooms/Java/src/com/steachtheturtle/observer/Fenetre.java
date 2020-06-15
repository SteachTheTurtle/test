package com.steachtheturtle.observer;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame {

	private JLabel label = new JLabel();

	private Horloge horloge;

	public Fenetre() {
		// On initialise la JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(200, 80);

		// On initialise l'horloge
		this.horloge = new Horloge();

		// On place un écouteur sur l'horloge
		this.horloge.addObservateur(new Observateur() {
			@Override
			public void update(String hour) {
				label.setText(hour);
			}
		});

		// On initialise le JLabel
		Font police = new Font("Courrier", Font.TYPE1_FONT, 30);
		this.label.setFont(police);
		this.label.setHorizontalAlignment(JLabel.CENTER);
		// On ajoute le JLabel à la JFrame
		this.getContentPane().add(this.label, BorderLayout.CENTER);
		this.setVisible(true);
		this.horloge.run();
	}
}
