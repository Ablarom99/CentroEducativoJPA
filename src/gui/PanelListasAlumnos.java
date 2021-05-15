package gui;

import javax.swing.JPanel;

import model.Materia;
import model.Profesor;
import model.Valoracionmateria;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesores;
import model.controllers.ControladorValoracionMateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.util.List;

import javax.swing.JList;
import javax.swing.JComboBox;

public class PanelListasAlumnos extends JPanel {
	private JComboBox jcbProfesor = new JComboBox();
	private JComboBox jcbNota = new JComboBox();
	private JComboBox jcbMateria = new JComboBox();

	/**
	 * Create the panel.
	 */
	public PanelListasAlumnos() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 9;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);

		jcbMateria = new JComboBox();
		jcbMateria.setToolTipText("");
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.gridwidth = 11;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);

		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);

		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.gridwidth = 11;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);

		JLabel lblNota = new JLabel("Nota:");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.EAST;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		panel.add(lblNota, gbc_lblNota);

		jcbNota = new JComboBox();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.gridwidth = 11;
		gbc_jcbNota.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);

		JButton btnActualizar = new JButton("Actualizar Alumnado");
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.gridwidth = 6;
		gbc_btnActualizar.gridx = 6;
		gbc_btnActualizar.gridy = 3;
		panel.add(btnActualizar, gbc_btnActualizar);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 5;
		gbc_panel_1.gridwidth = 9;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 110, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNoSeleccionado = new JLabel("Alumno no Seleccionado:");
		GridBagConstraints gbc_lblNoSeleccionado = new GridBagConstraints();
		gbc_lblNoSeleccionado.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoSeleccionado.gridx = 0;
		gbc_lblNoSeleccionado.gridy = 0;
		panel_1.add(lblNoSeleccionado, gbc_lblNoSeleccionado);

		JLabel lblSeleccionados = new JLabel("Alumno Seleccionado:");
		GridBagConstraints gbc_lblSeleccionados = new GridBagConstraints();
		gbc_lblSeleccionados.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccionados.gridx = 2;
		gbc_lblSeleccionados.gridy = 0;
		panel_1.add(lblSeleccionados, gbc_lblSeleccionados);

		JList jlistNoSeleccionado = new JList();
		GridBagConstraints gbc_jlistNoSeleccionado = new GridBagConstraints();
		gbc_jlistNoSeleccionado.insets = new Insets(0, 0, 0, 5);
		gbc_jlistNoSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_jlistNoSeleccionado.gridx = 0;
		gbc_jlistNoSeleccionado.gridy = 1;
		panel_1.add(jlistNoSeleccionado, gbc_jlistNoSeleccionado);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton btnDesSeleccionarTodo = new JButton("<<");
		GridBagConstraints gbc_btnDesSeleccionarTodo = new GridBagConstraints();
		gbc_btnDesSeleccionarTodo.insets = new Insets(0, 0, 5, 0);
		gbc_btnDesSeleccionarTodo.gridx = 0;
		gbc_btnDesSeleccionarTodo.gridy = 1;
		panel_2.add(btnDesSeleccionarTodo, gbc_btnDesSeleccionarTodo);

		JButton btnDesSeleccionar = new JButton("<");
		GridBagConstraints gbc_btnDesSeleccionar = new GridBagConstraints();
		gbc_btnDesSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnDesSeleccionar.gridx = 0;
		gbc_btnDesSeleccionar.gridy = 2;
		panel_2.add(btnDesSeleccionar, gbc_btnDesSeleccionar);

		JButton btnSeleccionar = new JButton(">");
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionar.gridx = 0;
		gbc_btnSeleccionar.gridy = 3;
		panel_2.add(btnSeleccionar, gbc_btnSeleccionar);

		JButton btnSeleccionarTodo = new JButton(">>");
		GridBagConstraints gbc_btnSeleccionarTodo = new GridBagConstraints();
		gbc_btnSeleccionarTodo.gridx = 0;
		gbc_btnSeleccionarTodo.gridy = 4;
		panel_2.add(btnSeleccionarTodo, gbc_btnSeleccionarTodo);

		JList jlistSeleccionado = new JList();
		GridBagConstraints gbc_jlistSeleccionado = new GridBagConstraints();
		gbc_jlistSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_jlistSeleccionado.gridx = 2;
		gbc_jlistSeleccionado.gridy = 1;
		panel_1.add(jlistSeleccionado, gbc_jlistSeleccionado);

		JButton btnGuardar = new JButton("Guardar la nota de todos los alumnos seleccionados");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 7;
		gbc_btnGuardar.gridy = 6;
		add(btnGuardar, gbc_btnGuardar);

		cargarDatos();

	}

	private void cargarDatos() {
		List<Materia> materia = ControladorMateria.getInstance().findAll();

		for (Materia t : materia) {
			this.jcbMateria.addItem(t);
		}

		List<Profesor> profesor = ControladorProfesores.getInstance().findAll();

		for (Profesor t : profesor) {
			this.jcbProfesor.addItem(t);

		}
		List<Valoracionmateria> valoracionmateria = ControladorValoracionMateria.getInstance().findAll();

		for (Valoracionmateria t : valoracionmateria) {
			this.jcbNota.addItem(t);

		}
	}
}
