import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Main{

    static int score;
    static JFrame f;
    static Display d;
    static Square q;
    static int[] obstacles;

    public static void main(String[] args){
        f = new JFrame();
        f.setSize(600,400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        d=new Display();
        f.add(d);

        f.setVisible(true);

        q = new Square();
        f.addKeyListener(new KeyL() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                q.jump();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

       score = 0;
        while(true){
            try {

                if(score % 5000 == 0){
                    obstacles = genObstacles();
                    System.out.println("-------------------");
                    //for(int i=0;i<obstacles.length;i++){
                    //    System.out.println(obstacles[i]);
                    //}
                }
                boolean b = false;
                for(int i = 0; i<obstacles.length;i++) {
                    if (score % 5000 +100 > obstacles[i] && score % 5000 +100 < obstacles[i] + 25 && q.getHeight()<55){
                        b=true;
                        break;
                    }
                }
                if(b)
                    break;

                score += 5;
                Thread.sleep(10);
                q.update();
                d.repaint();
                d.revalidate();

            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("funkar inte");
            }
        }
    }

    // undone
    public static int[] genObstacles(){
        ArrayList<Integer> G = new ArrayList<Integer>();

        for(int i= 400; i< 4900;){
            i = (int) (Math.random() * 400 + i + 100);
                G.add(i);
        }
        int[] g = new int[G.size()];
        for(int i=0; i < G.size(); i++){
            g[i] = G.get(i);
        }


        return g;
    }

}
