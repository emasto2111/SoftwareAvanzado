package principal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ClaseGUI extends JPanel implements ActionListener {

	// Constructores
	JComboBox<String> cadena;
	protected JTextField porcentaje;
	protected static String proteinsString;
	protected static String nucelotidString;
	JRadioButton proteinsButton;
	JRadioButton nucleotidButton;
	ButtonGroup group;
	JPanel paraRadioButtons;
	JButton enviar;

	public ClaseGUI() {

		// Creamos los radio buttons
		String proteinsString = new String("proteins");
		String nucelotidString = new String("nucleotid");
		proteinsButton = new JRadioButton(proteinsString, true);
		nucleotidButton = new JRadioButton(nucelotidString, false);

		// Agrupamos los radio buttons.
		group = new ButtonGroup();
		group.add(proteinsButton);
		group.add(nucleotidButton);

		// Creo un panel donde añado mis opciones usando add
		paraRadioButtons = new JPanel();
		paraRadioButtons.add(proteinsButton);
		paraRadioButtons.add(nucleotidButton);
		add(paraRadioButtons);

		// add combobox secuencia
		cadena = new JComboBox<String>();
		cadena.setEditable(true);
		cadena.addItem(" ");

		// add porcentaje
		porcentaje = new JTextField("", 10);

		/*
		 * porcentaje= new JComboBox<Double>(); porcentaje.setEditable(true); for(double
		 * i= 0.0; i<1.0; i=(i+0.01)) { porcentaje.addItem(i); }
		 */

		// add boton enviar
		enviar = new JButton("Enviar");

		// le damos al actionlistener el control
		enviar.addActionListener(this);
		cadena.addActionListener(this);
		porcentaje.addActionListener(this);

		// lo añadimos todo
		add(cadena);
		add(porcentaje);
		add(enviar);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == enviar) {
			
			//Porcentaje de tipo float
			float floatPorcentaje = Float.parseFloat(porcentaje.getText());
			
			//cadena distinta de null y porcentaje en el rango
			if (cadena.getSelectedItem() != null && floatPorcentaje >= 0 && floatPorcentaje <= 1) {
				
				//comparación para no repetir la secuencia
				
				String cadenaAnterior= "";
				for (int i = 0; i < cadena.getItemCount(); i++) {
					 cadenaAnterior= cadena.getItemAt(i);
				}
				if(cadenaAnterior!= cadena.getSelectedItem()) {
					cadena.addItem(cadena.getSelectedItem().toString());
					System.out.println(cadenaAnterior + cadena.getSelectedItem());
					
				}
				 
				
				//vemos que radio button esta seleccionado
				if (proteinsButton.isSelected()) {
					System.out.println("Has introducido una cadena de aminoácidos");
				} else {
					System.out.println("Has introducido una cadena de nucleótidos");
				}
				System.out.println("La cadena a procesar sera la siguiente" + " " + cadena.getSelectedItem() +  " " + "con un porcenatje de " + floatPorcentaje);
			}
			
			// Si la cadena es nula o no esta bien el porcentaje, recibir un mensaje
			else {
				System.out.println("Introduzca la cadena o un porcentaje entre 0 y 1");
			}

		}

	}
}

