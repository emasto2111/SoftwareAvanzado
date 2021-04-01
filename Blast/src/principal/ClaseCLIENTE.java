package principal;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ClaseCLIENTE {
	public static void main(String [] args)  {

	      SwingUtilities.invokeLater( new Runnable( )  {

	         public void run( )  {

	            JFrame frame = new JFrame("ButtonDemo") ;

	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;

	            ClaseGUI newContentPane= new ClaseGUI( ) ;

	            newContentPane.setOpaque(true) ;

	            //content panes must be opaque

	            frame.setContentPane(newContentPane) ;

	            frame.pack( ) ;

	            frame.setVisible(true) ;

	         }

	      } ) ;}

}
