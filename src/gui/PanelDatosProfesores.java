package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import model.Tipologiasexo;
import model.Profesor;
import model.controllers.ControladorProfesores;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDatosProfesores extends JPanel {
	

	pnlDatosPersonales p = new pnlDatosPersonales();
	Profesor actual = new Profesor();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PanelDatosProfesores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
			actual = ControladorProfesores.
			cargarActualEnPantalla();
		});
		btnNewButton.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/primen.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/patras.png")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/palante.png")));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/ultimo.png")));
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/guardar.png")));
		toolBar.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/nuevo.png")));
		toolBar.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/eliminar.png")));
		toolBar.add(btnNewButton_6);
		
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(p, gbc_lblNewLabel);
		
		
	}
	protected void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.p.setNombre(this.actual.getNombre());
			this.p.setApellido1(this.actual.getApellido1());
			this.p.setApellido2(this.actual.getApellido2());
			this.p.setDni(this.actual.getDni());
			this.p.setDir(this.actual.getDireccion());
			this.p.setEmail(this.actual.getEmail());
			this.p.setTelefono(this.actual.getTelefono());
			Tipologiasexo t = (Tipologiasexo) p.getJcbSexo().getSelectedItem();
	        this.actual.setTipologiasexo(t);
		}
	}
	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
        this.actual.setNombre(this.p.getNombre());
        this.actual.setApellido1(this.p.getApellido1());
        this.actual.setApellido2(this.p.getApellido2());
        this.actual.setDni(this.p.getDni());
        this.actual.setDireccion(this.p.getDir());
        this.actual.setEmail(this.p.getEmail());
        this.actual.setTelefono(this.p.getTelefono());
        Tipologiasexo t = (Tipologiasexo) this.p.getJcbSexo().getSelectedItem();
        this.actual.setTipologiasexo(t);
    }
	
	/**
	 * 
	 */
	private void vaciarCampos() {
        this.p.jtfNombre.setText("");
        this.p.jtfApellido1.setText("");
        this.p.jtfApellido2.setText("");
        this.p.jtfDni.setText("");
        this.p.jtfDir.setText("");
        this.p.jtfTel.setText("");
        this.p.jtfEmail.setText("");
        this.p.jcbSexo.setSelectedIndex(0);
    }
	
	
	/**
	 * 
	 */
	private void guardar () {
        cargarActualDesdePantalla();
        boolean resultado = ControladorProfesores.getInstance().guardar(this.actual);
        if (resultado == true && this.actual != null && this.actual.getId() > 0) {
            JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
        }
        else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }
	
	private void borrar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opci�n se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión Centro Educativo", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	ControladorProfesores.getInstance().borrar(this.actual);
	    	vaciarCampos();
	    }
	}
	
	

}
