import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MyFrame  extends JFrame{

	public MyFrame(String title) {
		super(title);
		
		// Set layout manager
		setLayout(new BorderLayout());
		// Create Swing component
		final JTextArea textArea = new JTextArea();
		JButton button = new JButton("Click me");
		// Add Swing components to content pane
		Container c = getContentPane();
		DetailsPanel detailsPanel = new DetailsPanel();
		c.add(detailsPanel, BorderLayout.WEST);
		c.add(textArea, BorderLayout.CENTER);
		c.add(button, BorderLayout.SOUTH);
		// Click handler
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				textArea.append("Hello\n");
				
			}
		
			
		});


	}

}

