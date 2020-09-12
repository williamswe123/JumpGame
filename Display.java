import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    public Display() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0,300,600,100);
        g.drawString(""+Main.score,10,20);
        g.drawRect(100,300-55-Main.q.getHeight(),25,55);
        for(int i = 0;i<Main.obstacles.length;i++){
            g.fillRect(Main.obstacles[i] - Main.score % 5000 ,300-55,25,55);
        }
    }

}
