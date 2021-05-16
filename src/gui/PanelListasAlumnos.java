package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;
import model.controllers.ControladorEstudiantes;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesores;
import model.controllers.ControladorValoracionMateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelListasAlumnos extends JPanel {
	private Profesor profesor;
	private Materia materia;
	private int nota;
	private JComboBox jcbMateria;
	private JComboBox jcbProfesor;
	private JComboBox jcbNota;
	private JList jlistNoSeleccionado;
	private JList jlistSeleccionado;
	private JScrollPane scpSeleccionado;
	private JScrollPane scpNoSeleccionado;
	private DefaultListModel<Estudiante> dlmSeleccionados;
	private DefaultListModel<Estudiante> dlmNoSeleccionados;
	private List<Estudiante> estudiantes = ControladorEstudiantes.findAllEstudiantes();
	/**
	 * Create the panel.
	 */
	
	public PanelListasAlumnos() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{213, 180, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblMateria = new JLabel("Materia");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel_1.add(lblMateria, gbc_lblMateria);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel_1.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel_1.add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel_1.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNota = new JLabel("Nota");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.EAST;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		panel_1.add(lblNota, gbc_lblNota);
		
		jcbNota = new JComboBox();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel_1.add(jcbNota, gbc_jcbNota);
		
		JButton btnActualizar = new JButton("ActualizarAlumnado");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarJlist();
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.anchor = GridBagConstraints.EAST;
		gbc_btnActualizar.gridx = 1;
		gbc_btnActualizar.gridy = 3;
		panel_1.add(btnActualizar, gbc_btnActualizar);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 146, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scpNoSeleccionado = new JScrollPane();
		GridBagConstraints gbc_scpNoSeleccionado = new GridBagConstraints();
		gbc_scpNoSeleccionado.gridheight = 4;
		gbc_scpNoSeleccionado.insets = new Insets(0, 0, 5, 5);
		gbc_scpNoSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_scpNoSeleccionado.gridx = 0;
		gbc_scpNoSeleccionado.gridy = 1;
		panel.add(scpNoSeleccionado, gbc_scpNoSeleccionado);
		
		jlistNoSeleccionado = new JList();
		scpNoSeleccionado.setViewportView(jlistNoSeleccionado);
		
		JButton btnDesSeleccionarTodo = new JButton("<<");
		btnDesSeleccionarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deseleccionarTodo();
			}
		});
		GridBagConstraints gbc_btnDesSeleccionarTodo = new GridBagConstraints();
		gbc_btnDesSeleccionarTodo.insets = new Insets(0, 0, 5, 5);
		gbc_btnDesSeleccionarTodo.gridx = 1;
		gbc_btnDesSeleccionarTodo.gridy = 1;
		panel.add(btnDesSeleccionarTodo, gbc_btnDesSeleccionarTodo);
		
		scpSeleccionado = new JScrollPane();
		GridBagConstraints gbc_scpSeleccionado = new GridBagConstraints();
		gbc_scpSeleccionado.insets = new Insets(0, 0, 5, 0);
		gbc_scpSeleccionado.gridwidth = 2;
		gbc_scpSeleccionado.gridheight = 4;
		gbc_scpSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_scpSeleccionado.gridx = 2;
		gbc_scpSeleccionado.gridy = 1;
		panel.add(scpSeleccionado, gbc_scpSeleccionado);
		
		jlistSeleccionado = new JList();
		scpSeleccionado.setViewportView(jlistSeleccionado);
		
		JButton btnDesSeleccionar = new JButton("<");
		btnDesSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deseleccionarUno();
			}
		});
		GridBagConstraints gbc_btnDesSeleccionar = new GridBagConstraints();
		gbc_btnDesSeleccionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnDesSeleccionar.gridx = 1;
		gbc_btnDesSeleccionar.gridy = 2;
		panel.add(btnDesSeleccionar, gbc_btnDesSeleccionar);
		
		JButton btnSeleccionar = new JButton(">");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionarUno();
			}
		});
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeleccionar.gridx = 1;
		gbc_btnSeleccionar.gridy = 3;
		panel.add(btnSeleccionar, gbc_btnSeleccionar);
		
		JButton btnSeleccionarTodo = new JButton(">>");
		btnSeleccionarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionarTodo();
			}
		});
		GridBagConstraints gbc_btnSeleccionarTodo = new GridBagConstraints();
		gbc_btnSeleccionarTodo.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeleccionarTodo.gridx = 1;
		gbc_btnSeleccionarTodo.gridy = 4;
		panel.add(btnSeleccionarTodo, gbc_btnSeleccionarTodo);
		
		JButton btnGuardar = new JButton("Guardar Alumnado");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 5;
		panel.add(btnGuardar, gbc_btnGuardar);

		cargarDatos();

	}
	
	/**
	 * 
	 */

	private void cargarDatos() {
		List<Materia> materia = ControladorMateria.getInstance().findAll();

		for (Materia t : materia) {
			this.jcbMateria.addItem(t);
		}

		List<Profesor> profesor = ControladorProfesores.getInstance().findAll();

		for (Profesor t : profesor) {
			this.jcbProfesor.addItem(t);

		}
		// Cargar Notas del 1 al 10.
		for (int i = 0; i < 11; i++) {
            this.jcbNota.addItem(Integer.valueOf(i));
        }
	}
	/**
	 * 
	 */
	private void cargarJlist() {
		dlmSeleccionados = new DefaultListModel<Estudiante>();
		dlmNoSeleccionados = new DefaultListModel<Estudiante>();
		
		for(Estudiante est : estudiantes)
			if(ControladorValoracionMateria.getInstance().findByEstudianteAndProfesorAndMateria(profesor, materia, est, nota))
				dlmSeleccionados.addElement(est);
			else
				dlmNoSeleccionados.addElement(est);
		
		jlistSeleccionado = new JList(dlmSeleccionados);
		jlistNoSeleccionado = new JList(dlmNoSeleccionados);
		scpSeleccionado.setViewportView(jlistSeleccionado);
		scpNoSeleccionado.setViewportView(jlistNoSeleccionado);
	}
	/**
	 * 
	 */
	private void guardar() {
		Materia m = (Materia)jcbMateria.getSelectedItem();
		Profesor p = (Profesor)jcbProfesor.getSelectedItem();
		int nota = (int) jcbNota.getSelectedItem();
		boolean resultado = false;
		
		Valoracionmateria vm = null;
		
		for (int i = 0; i < this.dlmSeleccionados.size(); i++) {
			Estudiante e = this.dlmSeleccionados.elementAt(i);
			
			vm = ControladorValoracionMateria.getInstance().findEstProfMat(p, m, e);
			if (vm == null) {
				vm = new Valoracionmateria();
				vm.setEstudiante(e);
				vm.setMateria(m);
				vm.setProfesor(p);
				vm.setValoracion(nota);
			}
			else {
				vm.setValoracion((int) this.jcbNota.getSelectedItem());
				ControladorValoracionMateria.getInstance().guardar(vm);
				
			}
			resultado = ControladorValoracionMateria.getInstance().guardar(vm);
		}

		if (resultado == true) {
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}
	/**
	 * 
	 */
	private void deseleccionarTodo() {
		for (int i = 0; i < this.dlmSeleccionados.size(); i++) { 
			  this.dlmNoSeleccionados.addElement(this.dlmSeleccionados.elementAt(i)); 
			  }          
		  this.dlmSeleccionados.clear();
	}
	/**
	 * 
	 */
	private void deseleccionarUno() {
		if(!jlistSeleccionado.isSelectionEmpty()) {
			
			for(int i = 0; i < jlistSeleccionado.getSelectedIndices().length; i++)
				dlmNoSeleccionados.addElement(dlmSeleccionados.getElementAt(jlistSeleccionado.getSelectedIndices()[i]));
			
			
			for(int i = this.jlistSeleccionado.getSelectedIndices().length - 1; i >= 0; i--)
				dlmSeleccionados.removeElementAt(jlistSeleccionado.getSelectedIndices()[i]);
						
		} 
	}
	/**
	 * 
	 */
	private void seleccionarTodo() {
		for (int i = 0; i < this.dlmNoSeleccionados.size(); i++) { 
			  this.dlmSeleccionados.addElement(this.dlmNoSeleccionados.elementAt(i)); 
			  }           
		  this.dlmNoSeleccionados.clear();
	}
	/**
	 * 
	 */
	private void seleccionarUno() {
		if(!jlistNoSeleccionado.isSelectionEmpty()) {
			
			for(int i = 0; i < jlistNoSeleccionado.getSelectedIndices().length; i++) {
				dlmSeleccionados.addElement(dlmNoSeleccionados.getElementAt(jlistNoSeleccionado.getSelectedIndices()[i]));
			}
			
			for(int i = this.jlistNoSeleccionado.getSelectedIndices().length - 1; i >= 0; i--) {
				dlmNoSeleccionados.removeElementAt(jlistNoSeleccionado.getSelectedIndices()[i]);
			}			
		} 	
	}
	
	
	
	
	
	
}
