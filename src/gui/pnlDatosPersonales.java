package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;


import model.Tipologiasexo;
import model.controllers.ControladorTipologiaSexo;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlDatosPersonales extends JPanel {
	protected JTextField jtfNombre;
	protected JTextField jtfApellido1;
	protected JTextField jtfApellido2;
	protected JTextField jtfDni;
	protected JTextField jtfDir;
	protected JTextField jtfEmail;
	protected JTextField jtfTel;
	protected JLabel lblSexo;
	protected JComboBox<Tipologiasexo>jcbSexo;
	private JScrollPane scrollPane;
	private JButton btnSeleccionar;
	private JButton btnColor;
	private JTextField jtfColor;
	private JLabel lblNewLabel;
	JColorChooser bg;
	String strColor;
	Color color;

	
	/**
	 * Create the panel.
	 */
	public pnlDatosPersonales() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 400, 180, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 1;
		add(lblApellido, gbc_lblApellido);
		
		jtfApellido1 = new JTextField();
		jtfApellido1.setColumns(10);
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 1;
		add(jtfApellido1, gbc_jtfApellido1);
		
		JLabel lblApellido_1 = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblApellido_1 = new GridBagConstraints();
		gbc_lblApellido_1.anchor = GridBagConstraints.EAST;
		gbc_lblApellido_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido_1.gridx = 0;
		gbc_lblApellido_1.gridy = 2;
		add(lblApellido_1, gbc_lblApellido_1);
		
		jtfApellido2 = new JTextField();
		jtfApellido2.setColumns(10);
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 2;
		add(jtfApellido2, gbc_jtfApellido2);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 3;
		add(lblSexo, gbc_lblSexo);
		
		jcbSexo = new JComboBox();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 3;
		add(jcbSexo, gbc_jcbSexo);
		
		JLabel lblDni = new JLabel("Dni:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 4;
		add(lblDni, gbc_lblDni);
		
		jtfDni = new JTextField();
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 4;
		add(jtfDni, gbc_jtfDni);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 5;
		add(lblDireccion, gbc_lblDireccion);
		
		jtfDir = new JTextField();
		jtfDir.setColumns(10);
		GridBagConstraints gbc_jtfDir = new GridBagConstraints();
		gbc_jtfDir.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDir.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDir.gridx = 1;
		gbc_jtfDir.gridy = 5;
		add(jtfDir, gbc_jtfDir);
		
		btnSeleccionar = new JButton("Selecciona Imagen");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionar.gridx = 2;
		gbc_btnSeleccionar.gridy = 5;
		add(btnSeleccionar, gbc_btnSeleccionar);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
		gbc_lblTelfono.anchor = GridBagConstraints.EAST;
		gbc_lblTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfono.gridx = 0;
		gbc_lblTelfono.gridy = 7;
		add(lblTelfono, gbc_lblTelfono);
		
		jtfTel = new JTextField();
		jtfTel.setColumns(10);
		GridBagConstraints gbc_jtfTel = new GridBagConstraints();
		gbc_jtfTel.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTel.gridx = 1;
		gbc_jtfTel.gridy = 7;
		add(jtfTel, gbc_jtfTel);
		
		lblNewLabel = new JLabel("Color Favorito");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 8;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 8;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		btnColor = new JButton("Seleccionar Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnColor.gridx = 2;
		gbc_btnColor.gridy = 8;
		add(btnColor, gbc_btnColor);
		cargarDatos();
	}
	private void seleccionaColor() {
		color=bg.showDialog(null, "Seleccione un color", color.cyan);
		if (color != null) {
            strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
            this.jtfColor.setText(strColor);
            setBackground(color);
        }
	}
	private void cargarDatos() {
        List<Tipologiasexo> sexo = ControladorTipologiaSexo.getInstance().findAll();

        for (Tipologiasexo t : sexo) {
            this.jcbSexo.addItem(t);
        }
    }
	
	public String getNombre() {
		return this.jtfNombre.getText();
	}
	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}
	public String getApellido1() {
		return this.jtfApellido1.getText();
	}
	public void setApellido1(String apellido1) {
		this.jtfApellido1.setText(apellido1);
	}
	public String getApellido2() {
		return this.jtfApellido2.getText();
	}
	public void setApellido2(String apellido2) {
		this.jtfApellido2.setText(apellido2);
	}
	public String getDni() {
		return this.jtfDni.getText();
	}
	public void setDni(String dni) {
		this.jtfDni.setText(dni);
	}
	public String getDir() {
		return this.jtfDir.getText();
	}
	public void setDir(String direccion) {
		this.jtfDir.setText(direccion);
	}
	public String getEmail() {
		return this.jtfEmail.getText();
	}
	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}
	public String getTelefono() {
		return this.jtfTel.getText();
	}
	public void setTelefono(String telefono) {
		this.jtfTel.setText(telefono);
	}
	public JComboBox<Tipologiasexo>getJcbSexo(){
        return jcbSexo;
    }

    public void setJcbSexo(JComboBox<Tipologiasexo>jcbSexo) {
        this.jcbSexo=jcbSexo;
    }
	/**
	 * @return the color
	 */
	public  String getColor() {
		return this.jtfColor.getText();
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		if (color != null) {
            this.jtfColor.setText(color);
            this.setBackground(Color.decode(color));
        }
        else {
            this.setBackground(Color.black);
        }
	}
    

}
