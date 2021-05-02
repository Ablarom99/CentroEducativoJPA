package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class pnlSeleccion extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public pnlSeleccion() {
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 25, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblJulio = new JLabel("New label");
		GridBagConstraints gbc_lblJulio = new GridBagConstraints();
		gbc_lblJulio.insets = new Insets(0, 0, 5, 5);
		gbc_lblJulio.gridx = 1;
		gbc_lblJulio.gridy = 0;
		panel_1.add(lblJulio, gbc_lblJulio);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		
		JLabel lblPaco = new JLabel("New label");
		GridBagConstraints gbc_lblPaco = new GridBagConstraints();
		gbc_lblPaco.anchor = GridBagConstraints.EAST;
		gbc_lblPaco.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaco.gridx = 1;
		gbc_lblPaco.gridy = 1;
		panel_1.add(lblPaco, gbc_lblPaco);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		panel_1.add(textField_1, gbc_textField_1);
		
		JLabel lblMigue = new JLabel("New label");
		GridBagConstraints gbc_lblMigue = new GridBagConstraints();
		gbc_lblMigue.anchor = GridBagConstraints.EAST;
		gbc_lblMigue.insets = new Insets(0, 0, 0, 5);
		gbc_lblMigue.gridx = 1;
		gbc_lblMigue.gridy = 2;
		panel_1.add(lblMigue, gbc_lblMigue);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 2;
		panel_1.add(textField_2, gbc_textField_2);

	}

}
