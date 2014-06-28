import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class GuiApplication {

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				NewFrame frame = new NewFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.setSize(600, 500);

				frame.setVisible(true);
			}
		});
	}
	
	
}
