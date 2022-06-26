
package brick.breaker;

import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class MYFRAME extends JFrame{
   
   MYFRAME() throws FileNotFoundException{
  NewClass  p = new NewClass();
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.add(p);
       this.pack();
       this.setLocationRelativeTo(null);
       this.setVisible(true);
       
   }
}
