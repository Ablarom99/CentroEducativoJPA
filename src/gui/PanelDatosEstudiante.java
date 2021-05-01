package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import javax.swing.JToolBar;

import model.Estudiante;
import model.Profesor;
import model.Tipologiasexo;
import model.controllers.ControladorEstudiantes;
import model.controllers.ControladorProfesores;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PanelDatosEstudiante extends JPanel {

	pnlDatosPersonales p = new pnlDatosPersonales();
	Estudiante actual = new Estudiante();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public PanelDatosEstudiante() {
		initialize();
		this.actual = ControladorEstudiantes.getInstance().findPrimero();
		cargarActualEnPantalla();
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
		btnNewButton.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/primen.png")));
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actual = ControladorEstudiantes.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/patras.png")));
		toolBar.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiantes.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/palante.png")));
		toolBar.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiantes.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/ultimo.png")));
		toolBar.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiantes.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/guardar.png")));
		toolBar.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/nuevo.png")));
		toolBar.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(PanelDatosEstudiante.class.getResource("/iconos/eliminar.png")));
		toolBar.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
				vaciarCampos();
			}
		});
		
		
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
			for (int i = 0; i < this.p.getJcbSexo().getItemCount(); i++) {
                if (this.actual.getTipologiasexo().getId() == this.p.getJcbSexo().getItemAt(i).getId()) {
                    this.p.getJcbSexo().setSelectedIndex(i);

                }
            }
			this.p.setColor(this.actual.getColorFavorito());
			this.p.setImagen(this.actual.getImagen());
			this.p.setlabelDimensiones(calculaPixeles());
		}
	}
	private String calculaPixeles () {

        String str = "";
        InputStream is = new ByteArrayInputStream( this.actual.getImagen());

        try {
            BufferedImage newBi = ImageIO.read(is);
             str = newBi.getWidth() + " x " + newBi.getHeight() + " píxeles";

        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
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
        this.actual.setColorFavorito(this.p.getColor());
        this.actual.setImagen(this.p.getImagen());
    }
	
	/**
	 * 
	 */
	private void vaciarCampos() {
        this.actual.setId(0);
        this.p.jtfNombre.setText("");
        this.p.jtfApellido1.setText("");
        this.p.jtfApellido2.setText("");
        this.p.jtfDni.setText("");
        this.p.jtfDir.setText("");
        this.p.jtfTel.setText("");
        this.p.jtfEmail.setText("");
        this.p.jcbSexo.setSelectedItem(null);
        this.p.setColor(null);
        this.p.jtfColor.setText("");
        this.p.setLabelImag("");
    }
	
	
	/**
	 * 
	 */
	private void guardar() {
        cargarActualDesdePantalla();
        boolean resultado = ControladorEstudiantes.getInstance().guardar(this.actual);
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
	    	ControladorEstudiantes.getInstance().borrar(this.actual);
	    	vaciarCampos();
	    }
	}

}
