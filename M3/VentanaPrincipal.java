

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class VentanaPrincipal extends JFrame {
    private JPanel panel0, panel1, panel2, panel3, panel4, panel5,panel6,panel7,panel8;
    private JLabel title,text,creators,error;
    private JTextField name;
    private JButton save, start,exit;
    private String username;
    private boolean valido = false;

    public VentanaPrincipal() {
        panel0 = new JPanel();
        panel1 = new JPanel() {
            private BufferedImage image;
            private int newWidth = 1250;
            private int newHeight = 600;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    image = ImageIO.read(new File("./imagenes/portada.jpg"));
                    g.drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        error = new JLabel();
        title = new JLabel("THE BATTLE FOR MIDDLE-EARTH");
        title.setFont(new Font("Abyssinica SIL", Font.BOLD, 30));
        text = new JLabel("Enter your username");
        creators = new JLabel("By Cristian Alvarez | Alex Martinez | Patricio");
        creators.setFont(new Font("Abyssinica SIL", Font.ITALIC,10));
        name = new JTextField(10);
        save = new JButton("Save");
        start = new JButton("Start");
        exit = new JButton("Exit");
        
        panel8.add(exit);
        panel5.add(title);
        panel2.add(text);
        panel3.add(name);
        panel4.add(save);
        panel4.add(start);
        panel6.add(creators);
        panel7.add(error);
        

        panel1.setLayout(new BorderLayout());
        

        panel0.add(panel1);
        panel0.add(panel5);
        panel0.add(panel2, BorderLayout.SOUTH);
        panel0.add(panel3);
        panel0.add(panel7);
        panel0.add(panel4);
        panel0.add(panel8);
        panel0.add(panel6);

        panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
        this.add(panel0);
        
        save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				username =name.getText();
				
					if (username.isBlank()) {
						error.setText("Username not permitted");
					}else {
	                valido = true;
	            	error.setText("");
	            	}}}
		);
        start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (valido == true) {
					String imagen = "./imagenes/?.jpg";
					dispose();
					new VentanaLucha(imagen,imagen,imagen,imagen,0,username,null,null,null,null);
				}else {
					error.setText("Username not permitted");
				}
			}});
        
        exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}});

        setSize(1250, 800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}