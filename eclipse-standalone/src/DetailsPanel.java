import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DetailsPanel extends JPanel{

	
	public DetailsPanel()
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Personal Details"));
		JLabel nameLabel = new JLabel("Name : ");
		JLabel occupationLabel = new JLabel("Occupation");
		JTextField nameField = new JTextField(10);
		JTextField occupationField = new JTextField(10);
		JButton addBtn = new JButton("Add");
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 0;
		add(nameLabel, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		add(occupationLabel, gc);

	}
}
