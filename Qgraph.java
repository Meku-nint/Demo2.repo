package  pack1
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
public class  Qgraph extends JFrame {
    JPanel plane;
    JButton drawbtn;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Qgraph(int xc[],int yc[]){


        setSize(1000,1000);
        setLayout(null);
        ImageIcon icon = new ImageIcon(Qgraph.class.getResource("logo.png"));
        setIconImage(icon.getImage());
        setBackground(Color.GRAY);
        setTitle("Kutir Quadratic Graph");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        plane= new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int x= plane.getWidth()/2;
                int y= plane.getHeight()/2;
                int x_intecpt;
                int y_intecpt;
                Graphics2D g2d = (Graphics2D) g;
                g.setColor(Color.BLACK);
                ((Graphics2D) g).setStroke(new BasicStroke(2));
                g.drawLine(x, 10, x, 880);
                g.drawLine(10, y, 880, y);
                ((Graphics2D) g).setStroke(new BasicStroke(1));
                g.setColor(Color.RED);
                int y2=y;
                int x2=x;
                for(int i=0;i<10;i++){
                    g.drawLine(10, y+25, 880, y+25);
                    g.drawLine(10, y2-25, 880, y2-25);
                    y+=25;y2-=25;
                }
                g.setColor(Color.BLUE);
                for(int i=0;i<10;i++){
                    g.drawLine(x+25, 10, x+25, 880);
                    g.drawLine(x2-25, 10, x2-25, 880);
                    x+=25;x2-=25;
                }
                g.setColor(Color.BLACK);
                ((Graphics2D) g).setStroke(new BasicStroke(2));

                for(int i=0;i<(xc.length-1);i++){
                    g.drawLine(xc[i],yc[i],xc[i+1],yc[i+1]);
                }

            }
        };
        plane.setBounds(20,20,900,900);
        plane.setBackground(Color.white);
        plane.setLayout(null);

        add(plane);

    }
    public static  void main(String args[]){

        int m=2,b=1;
        int y[] = new int[11];
        //int[] x={-4,-3,-2,-1,0,1,2,3,4};
        int[] x={-8,-4,-3,-2,-1,0,1,2,3,4,8};
        for(int i=0;i<11;i++){
            y[i]=(m*x[i])+b;
        }
        for(int i=0;i<9;i++){
            System.out.println("("+x[i]+","+y[i]+")");
        }

        for(int i=0;i<x.length;i++){
            if(x[i]>=0)
                x[i]=450+(x[i]*25);
            else
                x[i]=450-(25*(x[i]*(-1)));
        }
        for(int i=0;i<y.length;i++){
            if(y[i]>=0)
                y[i]=450-(25*y[i]);
            else
                y[i]=450+(25*(y[i]*(-1)));
        }
        for(int i=0;i<9;i++){
            System.out.println("("+x[i]+","+y[i]+")");
        }
    }
}