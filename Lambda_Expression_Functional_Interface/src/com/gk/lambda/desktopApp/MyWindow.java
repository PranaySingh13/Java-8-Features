package com.gk.lambda.desktopApp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyWindow {

	public static void main(String[] args) {

		JFrame frame = new JFrame("My Window");
		frame.setSize(400, 400);
		frame.setLayout(new FlowLayout());

		// ActionListener action=

		// Create Button and Add Jframe
		JButton button1 = new JButton("Click Me First");

		// By Anonymous Class
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hey! First Button Clicked");

			}
		});

		JButton button2 = new JButton("Click Me Second");

		// Above Method with Lambda Expression as ActionListener Interface contains only
		// one abstract Method
		button2.addActionListener((e) -> JOptionPane.showMessageDialog(null, "Hey! Second Button Clicked"));

		frame.add(button1);
		frame.add(button2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
