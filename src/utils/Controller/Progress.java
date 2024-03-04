package utils.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Cursor;
import java.util.Locale;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Progress extends JFrame {
	JProgressBar progressBar;
    private final JLabel lblCargandoSistema;


	public Progress(String Rol,String Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 178);
        JPanel contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		contentPane.setBackground(new Color(0, 128, 128));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 11));
		progressBar.setLocale(new Locale("es", "CU"));
		progressBar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(new Color(255, 215, 0));
		progressBar.setBounds(0, 60, 750, 71);
		contentPane.add(progressBar);
		
		lblCargandoSistema = new JLabel("Cargando Sistema...");
		lblCargandoSistema.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblCargandoSistema.setBounds(294, 11, 212, 30);
		contentPane.add(lblCargandoSistema);

		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		arrancar();
	}
	
	public void arrancar() {
		Thread hilo = new Thread(new Runnable() {
			String word = lblCargandoSistema.getText();
			public void run() {
				for (int i = 0; i <= 100; i++) {
					try {
						progressBar.setValue(i);
						String WORD = word.substring(0,i % word.length())+"";
						lblCargandoSistema.setText(WORD);
						
						Thread.sleep(10);
						
						if (i==100) {
							dispose();
						}
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
			}
		});
		hilo.start();
		
		
	}



}
