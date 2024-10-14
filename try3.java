package  pack1;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.Random;
import javax.swing.*;
import javax.swing.JFrame;

import javax.swing.plaf.DimensionUIResource;

public class try3 extends JFrame{
    char operation = ' ';
    String sRawInput = "";
    String sDisplay = "";
    boolean bPlusMinus;
    boolean isPlus = true;//Is the sign of the operand is plus
    boolean isPoint = false;
    boolean isOperation;
    double number1 = 0;// 1st operand
    double number2 = 0;// 2nd operand
    double result = 0;
    JTextField jf,jf2,jf3,jf4,jf5,jf6,jf7;
    JRadioButton jr,jr2;
    ButtonGroup bgrp;
    String btnText[] ={"7","8","9","6","5","4","3","2","1","0",".","+/-"};
    String obtnText[] ={"+","-","×","÷","<","=","C"};

    String scitext[]={"π","e","10^","τ","sin","cos","tan","csc","sec","cot",
            "log","√","x²","x³","n!","rnd","ln","exp","tan⁻¹","sin⁻¹","cos⁻¹","csc⁻¹","sec⁻¹","cot⁻¹","eˣ"};
    JButton[] btn,Obtn,Sbtn;
    JComboBox<String> jcombo,jcombo2;
    JButton draw,drawq;
    JPanel jp,jp2,jpd = new JPanel(),jp3=new JPanel(),jp4=new JPanel(),jp5=new JPanel();
    JLabel ymx,Qf,fx,x1,fx2,x2,b,bx,cx;
    JMenuBar menuBar;
    JMenuItem stc,graph,temp,blame,whime,len,sci;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int x, y;
    public try3() {

        ImageIcon icon = new ImageIcon(try3.class.getResource("logo.png"));
        setIconImage(icon.getImage());
        setSize(500,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        Dimension size = getBounds().getSize();

        setTitle("Kutir");
        JMenu fileMenu = new JMenu("Menu");
        JMenu EditMenu2 = new JMenu("Edit");

        EditMenu2.setFont(new Font("Monaco", Font.PLAIN, 16));
        fileMenu.setFont(new Font("Monaco", Font.PLAIN, 16));

        menuBar = new JMenuBar();
        menuBar.add(Box.createHorizontalStrut(20));
        menuBar.add(fileMenu);
        menuBar.add(EditMenu2);

        //"Standard Calculator"
        stc = new JMenuItem("Standard Calculator");
        stc.setMargin(new Insets(10, 10, 10, 10));
        stc.addActionListener(e -> {
            add(jf);add(jf2);
            x = (int) ((screenSize.getWidth() - getWidth()) / 2);
            y = (int) ((screenSize.getHeight() - getHeight()) / 2);
            setLocation(x+240, y);
            add(jp);
            sci.setEnabled(true);
            graph.setEnabled(true);
            len.setEnabled(true);
            temp.setEnabled(true);
            stc.setEnabled(false);
            setSize(500,700);
            jf.setBounds(10,30,470,100);
            jf2.setBounds(10,20,470,40);
            jp.setBounds(20,170,460,460);
            remove(jp2);remove(jp4);remove(jp3);remove(jp5);

        });
        stc.setEnabled(false);
        stc.setFont(new Font("Monaco", Font.PLAIN, 16));
        JLabel conv= new JLabel("Unit Convertor");
        conv.setFont(new Font("Monaco", Font.PLAIN, 16));

        sci = new JMenuItem("Scientific Calculator");
        sci.setFont(new Font("Monaco", Font.PLAIN, 16));
        Scientifc2 scien =  new Scientifc2(this);
        sci.addActionListener(scien);
        sci.setMargin(new Insets(10, 10, 10, 10));

        graph = new JMenuItem("Graph Drawer");
        graph.setFont(new Font("Monaco", Font.PLAIN, 16));
        graph.setMargin(new Insets(10, 10, 10, 10));
        GraphD gl =  new GraphD(this);
        graph.addActionListener(gl);

        temp = new JMenuItem("Temperature");
        temp.setFont(new Font("Monaco", Font.PLAIN, 16));
        temp.setMargin(new Insets(10, 10, 10, 10));
        Tempc tempc =  new Tempc(this);
        temp.addActionListener(tempc);

        len = new JMenuItem("Length");
        len.setFont(new Font("Monaco", Font.PLAIN, 16));
        len.setMargin(new Insets(10, 10, 10, 10));
        Len leng =  new Len(this);
        len.addActionListener(leng);

        blame = new JMenuItem("Dark Theme");
        blame.setFont(new Font("Monaco", Font.PLAIN, 16));
        blame.setMargin(new Insets(10, 10, 10, 10));

        whime = new JMenuItem("White Theme");
        whime.setFont(new Font("Monaco", Font.PLAIN, 16));
        whime.setMargin(new Insets(10, 10, 10, 10));
        whiteTheme wT= new whiteTheme(this);
        whime.addActionListener(wT);
        DarkTheme dT = new DarkTheme(this);
        blame.addActionListener(dT);

        EditMenu2.add(whime);
        EditMenu2.add(blame);
        fileMenu.add(stc);
        fileMenu.add(sci);
        fileMenu.add(len);
        fileMenu.add(temp);
        fileMenu.add(graph);
        setJMenuBar(menuBar);

        jf2=new JTextField();
        jf= new JTextField();
        jp= new JPanel();
        jp.setBounds(20,170,460,460);
        jf.setText("0");

        jp.setLayout(null);

        jf.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jf2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        jf2.setFont(new Font("Monaco", Font.PLAIN, 40));
        jf.setBackground(new Color(245, 245, 245));
        jf2.setBounds(10,60,470,80);
        jf.setBounds(10,20,470,40);
        jf2.setBackground(new Color(245, 245, 245));
        jf2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jf.setLayout(null);
        add(jf);
        add(jf2);


        jf.setFont(new Font("Monaco", Font.PLAIN, 40));
        jf2.setBackground(new Color(245, 245, 245));

        jf.setEditable(false);
        jf2.setEditable(false);
        btn = new JButton[12];
        Obtn = new JButton[7];
        for(int i=0;i<12;i++){

            btn[i]=new JButton(btnText[i]);
            btn[i].setFont(new Font("Monaco", Font.PLAIN, 40));
            btn[i].setBorderPainted(false);
            btn[i].setBackground(new Color(245, 245, 245));
            btn[i].setFocusPainted(false);
            jp.add(btn[i]);
        }

        btn[0].setBounds(5,10,100,70);
        btn[1].setBounds(115,10,100,70);
        btn[2].setBounds(225,10,100,70);

        btn[3].setBounds(5,100,100,70);
        btn[4].setBounds(115,100,100,70);
        btn[5].setBounds(225,100,100,70);

        btn[6].setBounds(5,180,100,70);
        btn[7].setBounds(115,180,100,70);
        btn[8].setBounds(225,180,100,70);
        btn[9].setBounds(5,270,100,70);
        btn[10].setBounds(115,270,100,70);
        btn[11].setBounds(225,270,100,70);
        Obtn = new JButton[7];
        //   Obtn = new JButton[7];
        for(int i=0;i<7;i++){

            Obtn[i]=new JButton(obtnText[i]);
            Obtn[i].setFont(new Font("Monaco", Font.PLAIN, 40));
            Obtn[i].setBorderPainted(false);
            Obtn[i].setBackground(new Color(245, 245, 245));
            Obtn[i].setFocusPainted(false);
            jp.add(Obtn[i]);
        }
        Obtn[0].setBounds(335,10,100,70);
        Obtn[1].setBounds(335,90,100,70);

        Obtn[2].setBounds(335,180,100,70);
        Obtn[3].setBounds(335,270,100,70);
        Obtn[4].setBounds(335,360,100,70);
        Obtn[5].setBounds(5,360,155,70);
        Obtn[5].setBackground(new Color(135, 206, 250));
        Obtn[5].setFont(new Font("Monaco", Font.BOLD, 40));
        Obtn[5].setForeground(Color.white);
        Obtn[6].setBounds(170,360,155,70);
        Obtn[6].setFont(new Font("Monaco", Font.BOLD, 40));
        Obtn[6].setBackground(new Color(255, 160, 122));

        Obtn[6].setForeground(Color.white);



        add(jp);

        setResizable(false);
        listner2 ls=new listner2(this);
        for (int i=0;i<12;i++) {
            btn[i].addActionListener(ls);
        }
        for(int i=0;i<7;i++) {
            Obtn[i].addActionListener(ls);
        }
        setVisible(true);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try3 sc = new try3();
    }

}
class Scientifc2 implements ActionListener {
    try3 t;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int x ,y;
    public Scientifc2( try3 t){
        boolean home =true;
        this.t=t;
        this.t.jp2 = new JPanel();
        x = (int) ((screenSize.getWidth() - this.t.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - this.t.getHeight()) / 2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        t.add(t.jf);
        t.add(t.jf2);
        t.remove(t.jp);t.remove(t.jpd);
        t.remove(t.jp3);t.remove(t.jp4);t.remove(t.jp5);
        t.setLocation(x-200, y);
        t.jp2.setBounds(20,190,700,460);

        t.jp.setBounds(573,190,460,460);
        t.add(t.jp);

        t.sci.setEnabled(false);
        t.jf2.setBounds(10,80,1015,100);
        t.jf.setBounds(10,20,1015,60);
        t.setSize(1050,700);
        t.stc.setEnabled(true);
        t.graph.setEnabled(true);
        t.len.setEnabled(true);
        t.temp.setEnabled(true);
        t.Sbtn= new JButton[25];

        t.jp2.setLayout(null);
        int x=5;
        for(int i=0;i<25;i++){

            t.Sbtn[i]=new JButton(t.scitext[i]);
            t.Sbtn[i].setFont(new Font("Monaco", Font.BOLD, 25));
            t.Sbtn[i].setBorderPainted(false);
            t.Sbtn[i].setBackground(new Color(245, 245, 245));
            t.Sbtn[i].setFocusPainted(false);
            t.jp2.add(t.Sbtn[i]);
            listner2 l2=new listner2(t);
            t.Sbtn[i].addActionListener(l2);
        }
        t.Sbtn[0].setBounds(5,10,100,70);
        t.Sbtn[1].setBounds(115,10,100,70);
        t.Sbtn[2].setBounds(225,10,100,70);
        t.Sbtn[3].setBounds(335,10,100,70);
        t.Sbtn[4].setBounds(445,10,100,70);

        t.Sbtn[5].setBounds(5,100,100,70);
        t.Sbtn[6].setBounds(115,100,100,70);
        t.Sbtn[7].setBounds(225,100,100,70);
        t.Sbtn[8].setBounds(335,100,100,70);
        t.Sbtn[9].setBounds(445,100,100,70);

        t.Sbtn[10].setBounds(5,180,100,70);
        t.Sbtn[11].setBounds(115,180,100,70);
        t.Sbtn[12].setBounds(225,180,100,70);
        t.Sbtn[13].setBounds(335,180,100,70);
        t.Sbtn[14].setBounds(445,180,100,70);

        t.Sbtn[15].setBounds(5,270,100,70);
        t.Sbtn[16].setBounds(115,270,100,70);
        t.Sbtn[17].setBounds(225,270,100,70);
        t.Sbtn[18].setBounds(335,270,100,70);
        t.Sbtn[19].setBounds(445,270,100,70);

        t.Sbtn[20].setBounds(5,360,100,70);
        t.Sbtn[21].setBounds(115,360,100,70);
        t.Sbtn[22].setBounds(225,360,100,70);
        t.Sbtn[23].setBounds(335,360,100,70);
        t.Sbtn[24].setBounds(445,360,100,70);
       // t.Sbtn[24].setBounds(445,460,130,70);

        t.add(t.jp2);

    }
}
class GraphD extends JComponent implements  ActionListener{
    try3 t;
    int num1,num2,num3;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public GraphD(try3 t2){
        t=t2;
        t.x = (int) ((screenSize.getWidth() - this.t.getWidth()) / 2);
        t.y = (int) ((screenSize.getHeight() - this.t.getHeight()) / 2);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        t.setSize(1000,1000);
        t.setLocation(t.x-200,t.y-170);
        t.setBackground(Color.orange);
        t.remove(t.jf);t.remove(t.jp);t.remove(t.jp2);
        t.remove(t.jf2);t.remove(t.jp4);t.remove(t.jp5);
        t.graph.setEnabled(false);
        t.jp3.setLayout(null);
        t.jp3.setBackground(new Color(0, 128, 128));
        t.jp3.setBounds(0,400,1000,120);
        t.add(t.jp3);
        t.jf3= new JTextField();
        t.jf4= new JTextField();
        t.jf5= new JTextField();
        t.jf7=new JTextField();
        t.jf6= new JTextField();
        t.draw = new JButton("Draw");
        //t.drawq
        t.jr= new JRadioButton("Linear Equation",true);
        t.jr2= new JRadioButton("Quadratic Equation");

        t.jr.setFont(new Font("Monaco", Font.BOLD, 16));
        t.jr.setBorderPainted(false);
        t.jr.setBackground(new Color(0, 128, 128));
        t.jr.setFocusPainted(false);
        t.jr.setForeground(Color.white);

        t.jr2.setFont(new Font("Monaco", Font.BOLD, 16));
        t.jr2.setBorderPainted(false);
        t.jr2.setBackground(new Color(0, 128, 128));
        t.jr2.setFocusPainted(false);
        t.jr2.setForeground(Color.white);
        t.jr.setBounds(20,10,200,40);
        t.jr2.setBounds(400,10,200,40);
        t.bgrp =new ButtonGroup();
        t.bgrp.add(t.jr);
        t.bgrp.add(t.jr2);
        t.jp3.add(t.jr);
        t.jp3.add(t.jr2);

        t.ymx=new JLabel("y = mx+b");
        t.ymx.setForeground(Color.white);
        t.ymx.setBounds(20,35,150,40);
        t.ymx.setFont(new Font("Monaco", Font.BOLD, 14));
        t.jp3.add(t.ymx);

        t.Qf=new JLabel("y = ax²+bx+c");
        t.Qf.setForeground(Color.white);
        t.Qf.setBounds(450,35,150,40);
        t.Qf.setFont(new Font("Monaco", Font.BOLD, 14));
        t.jp3.add(t.Qf);


        t.fx=new JLabel("f(x)=");
        t.fx.setBounds(20,65,60,20);
        t.jp3.add(t.fx);
        t.fx.setFont(new Font("Monaco", Font.BOLD, 18));
        t.fx.setForeground(Color.white);

        t.x1=new JLabel("x+");
        t.b=new JLabel("b");
        t.x2=new JLabel("x²+");
        t.bx=new JLabel("+x");
        t.cx=new JLabel("+c");

        //t.ax=new JLabel("");

        t.x1.setBounds(117,62,60,20);
        t.x1.setFont(new Font("Monaco", Font.BOLD, 18));
        t.x1.setForeground(Color.white);t.b.setForeground(Color.white);
        t.jf3.setBounds(75,65,40,20);
        t.jf3.setFont(new Font("Monaco", Font.BOLD, 18));
        t.jf4.setFont(new Font("Monaco", Font.BOLD, 18));
        t.x1.setForeground(Color.white);t.b.setForeground(Color.white);
        t.jf4.setBounds(140,65,40,20);
        t.b.setBounds(185,62,60,20);
        t.b.setFont(new Font("Monaco", Font.BOLD, 18));
        t.jp3.add(t.b);
        t.jp3.add(t.jf3);
        t.jp3.add(t.x1);
        t.jp3.add(t.jf4);

        t.fx2=new JLabel("f(x)=");
        t.fx2.setFont(new Font("Monaco", Font.BOLD, 18));
        t.fx2.setBounds(420,65,60,20);
        t.fx2.setForeground(Color.white);
        t.x2.setBounds(505,65,60,20);
        t.x2.setFont(new Font("Monaco", Font.BOLD, 18));
        t.x2.setForeground(Color.white);t.b.setForeground(Color.white);

        t.jf5.setBounds(460,65,40,20);

        t.jf5.setFont(new Font("Monaco", Font.BOLD, 18));
        t.jf6.setFont(new Font("Monaco", Font.BOLD, 18));
        t.x2.setForeground(Color.white);t.b.setForeground(Color.white);
        t.jf6.setBounds(535,65,40,20);
        t.bx.setFont(new Font("Monaco", Font.BOLD, 18));
        t.bx.setBounds(575,65,60,20);
        t.bx.setForeground(Color.white);
        t.jf7.setFont(new Font("Monaco", Font.BOLD, 18));
        t.jf7.setBounds(600,65,40,20);
        t.cx.setBounds(645,65,40,20);
        t.cx.setFont(new Font("Monaco", Font.BOLD, 18));
        t.cx.setForeground(Color.white);
        t.draw.setBounds(730,35,100,50);
        t.draw.setFont(new Font("Monaco", Font.BOLD, 18));
        t.draw.setBackground(new Color(64, 224, 208));
        t.draw.setBorderPainted(false);
        t.draw.setFocusPainted(false);

        t.draw.addActionListener(z->{
            try{

            if(t.jr.isSelected()){

                num1 =Integer.parseInt(t.jf3.getText());
                num2 =Integer.parseInt(t.jf4.getText());
                Lcordinate(num1,num2);

            }
            else if (t.jr2.isSelected()) {
                System.out.println("Qudratic");
                 num1 =Integer.parseInt(t.jf5.getText());
                 num2 =Integer.parseInt(t.jf6.getText());
                 num3 =Integer.parseInt(t.jf7.getText());
                Qcordinate(num1,num2,num3);

            }
            }
            catch (Exception q){
                System.out.println("errorr: "+q);
                t.jf3.setText("");
                t.jf4.setText("");
                t.jf5.setText("");
                t.jf6.setText("");
                t.jf7.setText("");

            }
        });
        t.jp3.add(t.x2);
        t.jp3.add(t.draw);
        t.jp3.add(t.fx2);
        t.jp3.add(t.jf5);
        t.jp3.add(t.bx);
        t.jp3.add(t.jf6);
        t.jp3.add(t.jf7);
        t.jp3.add(t.cx);




    }
    public void Lcordinate(int num1,int num2){
        int m=num1,b=num2;
        int xyc[]= new int[4];
        int y[] = new int[11];
        //int[] x={-4,-3,-2,-1,0,1,2,3,4};
        int[] x={-8,-4,-3,-2,-1,0,1,2,3,4,8};
        for(int i=0;i<11;i++){
            y[i]=(m*x[i])+b;
        }
        for(int i=0;i<x.length;i++){
            if(x[i]>=0)
                x[i]=450+(x[i]*25);
            else
                x[i]=450-(25*(x[i]*(-1)));
            if(y[i]>=0)
                y[i]=450-(25*y[i]);
            else
                y[i]=450+(25*(y[i]*(-1)));
        }

        Gtry gt= new Gtry(x[0],y[0],x[10],y[10]);

    }

    public void Qcordinate(int num1,int num2,int num3){
        System.out.println("QUadratic");
        int a=num1,b=num2,c=num3;
        int xyc[]= new int[4];
        int y[] = new int[28];
        //int[] x={-4,-3,-2,-1,0,1,2,3,4};
        int[] x={-15,-14,-13,12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,8,9,10,11,12,13,14,15};
        for(int i=0;i<x.length;i++){
            y[i]=(int)((Math.pow(x[i],2)*a)+(b*x[i])+c);
            System.out.println(y[i]);
        }
        for(int i=0;i<x.length;i++){
            if(x[i]>=0)
                x[i]=450+(x[i]*25);
            else
                x[i]=450-(25*(x[i]*(-1)));
            if(y[i]>=0)
                y[i]=450-(25*y[i]);
            else
                y[i]=450+(25*(y[i]*(-1)));
        }
        Qgraph Qg= new Qgraph(x,y);
    }
}
class whiteTheme implements ActionListener{
    try3 t;
    public whiteTheme(try3 ta){
        t=ta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        t.getContentPane().setBackground(new Color(238,238, 238));
        t.jp.setBackground(new Color(238,238, 238));
        t.jp2.setBackground(new Color(238,238, 238));
        t.jf.setBackground(new Color(245, 245, 245));
        t.jf.setForeground(new Color(69, 69, 69));
        t.jf2.setForeground(new Color(69, 69, 69));
        t.jf2.setBackground(new Color(245, 245, 245));
        for(int i=0;i<t.btn.length;i++){
            t.btn[i].setBackground(new Color(245, 245, 245));
            t.btn[i].setForeground(new Color(69, 69, 69));
        }
        for(int i=0;i<5;i++){
            t.Obtn[i].setForeground(new Color(69, 69, 69));
            t.Obtn[i].setBackground(new Color(245, 245, 245));

        }
    }
}
class DarkTheme implements ActionListener{
    try3 t;
    public DarkTheme(try3 ta){
        t=ta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        t.getContentPane().setBackground(new Color(31, 31, 31));
        t.jp.setBackground(new Color(31, 31, 31));
        t.jp2.setBackground(new Color(31, 31, 31));
        t.jf.setForeground(new Color(245, 245, 245));
        t.jf2.setForeground(new Color(245, 245, 245));
        t.jf.setBackground(new Color(69, 69, 69));
        t.jf2.setBackground(new Color(69, 69, 69));
        for(int i=0;i<t.btn.length;i++){
            t.btn[i].setForeground(new Color(245, 245, 245));
            t.btn[i].setBackground(new Color(69, 69, 69));

        }
        for(int i=0;i<5;i++){
            t.Obtn[i].setForeground(new Color(245, 245, 245));
            t.Obtn[i].setBackground(new Color(69, 69, 69));
        }
    }
}

class listner2 implements ActionListener {



        try3 sc;
        String op;
        String numString = "", store = "";
        String prec = "";
        double num1 = 0, num2 = 0, result, temp = 0;
        int c;

        listner2(try3 sc) {
        this.sc = sc;
    }

        public void actionPerformed (ActionEvent e){
        try{
        if (e.getSource() == sc.btn[8]) {
            if (sc.operation == '=') {
                sc.sDisplay = "1";
                sc.sRawInput = "1";
                sc.jf.setText(sc.sRawInput);
                sc.operation = ' ';
            } else {
                sc.sDisplay = sc.sDisplay + "1";
                sc.sRawInput += "1";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[7]) {
            if (sc.operation == '=') {
                sc.sDisplay = "2";
                sc.sRawInput = "2";
                sc.jf.setText(sc.sRawInput);
                sc.operation = ' ';
            } else {
                sc.sDisplay = sc.sDisplay + "2";
                sc.sRawInput += "2";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[6]) {
            if (sc.operation == '=') {
                sc.sDisplay = "3";
                sc.sRawInput = "3";
                sc.jf.setText(sc.sRawInput);
                sc.operation = ' ';
            } else {
                sc.sDisplay = sc.sDisplay + "3";
                sc.sRawInput += "3";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[5]) {
            if (sc.operation == '=') {
                sc.sDisplay = "4";
                sc.sRawInput = "4";
                sc.jf.setText(sc.sRawInput);
                sc.operation = ' ';
            } else {
                sc.sDisplay = sc.sDisplay + "4";
                sc.sRawInput += "4";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[4]) {
            if (sc.operation == '=') {
                sc.sDisplay = "5";
                sc.sRawInput = "5";
                sc.jf.setText(sc.sRawInput);
                sc.operation = ' ';
            } else {
                sc.sDisplay = sc.sDisplay + "5";
                sc.sRawInput += "5";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[3]) {
            if (sc.operation == '=') {
                sc.sDisplay = "6";
                sc.sRawInput = "6";
                sc.jf.setText(sc.sRawInput);
                sc.operation = ' ';
            } else {
                sc.sDisplay = sc.sDisplay + "6";
                sc.sRawInput += "6";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[0]) {
            if (sc.operation == '=') {
                sc.sDisplay = "7";
                sc.sRawInput = "7";
                sc.jf.setText(sc.sRawInput);
                sc.operation = ' ';
            } else {
                sc.sDisplay = sc.sDisplay + "7";
                sc.sRawInput += "7";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[1]) {
            if (sc.operation == '=') {
                sc.sDisplay = "8";
                sc.sRawInput = "8";
                sc.jf.setText(sc.sRawInput);
                sc.operation = ' ';
            } else {
                sc.sDisplay = sc.sDisplay + "8";
                sc.sRawInput += "8";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[2]) {

            if (sc.operation == '=') {
                sc.sDisplay = "9";
                sc.sRawInput = "9";
                sc.jf.setText(sc.sRawInput);
                sc.operation = ' ';
            } else {
                sc.sDisplay = sc.sDisplay + "9";
                sc.sRawInput += "9";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[9]) {
            if (sc.sDisplay.equals(""))//zero at first
            {
                sc.sDisplay = "0";
                sc.sRawInput += "0";
                sc.jf.setText(sc.sRawInput);
            } else {
                sc.sDisplay = sc.sDisplay + "0";
                sc.sRawInput += "0";
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.btn[10]) ///when bPoint is clicked
        {
            if (sc.sDisplay.equals(""))//bPoint at starting of a number
            {
                sc.sDisplay = "0.";
                sc.sRawInput += "0.";
                sc.jf.setText(sc.sRawInput);
            } else if (!sc.isPoint)//when there is no bPoint till now then just add the bPoint
            {
                sc.sDisplay = sc.sDisplay + ".";
                sc.sRawInput += ".";
                sc.jf.setText(sc.sRawInput);
            }
            sc.isPoint = true;//when the bPoint button is clicked once set the bPoint flag to true
        } else if (e.getSource() == sc.btn[11] && !sc.sDisplay.equals("") && !sc.isOperation)//plus minus(sign) button
        {
            if (sc.isPlus) {
                sc.sDisplay = "-" + sc.sDisplay;
                sc.sRawInput = sc.sDisplay;
                sc.jf.setText(sc.sRawInput);
                sc.isPlus = false;
            } else {
                sc.sDisplay = sc.sDisplay.substring(1, sc.sDisplay.length());
                sc.sRawInput = sc.sDisplay.substring(1, sc.sDisplay.length());
                sc.jf.setText(sc.sRawInput);
                sc.isPlus = true;
            }
        }
        //String btnText[] ={"7","8","9","6","5","4","3","2","1","0",".","+/-"};
        //String obtnText[] ={"+","-","×","÷","<","=","C"};
        else if (e.getSource() == sc.Obtn[0] && (!sc.sDisplay.equals("") || sc.operation == '=')) // + button is clicked and input is not empty
        {
            if (!sc.isOperation)//to check if plus without number1
            {
                sc.number1 = Double.parseDouble(sc.sDisplay);
                sc.sDisplay = "";
                sc.operation = '+';
                sc.isPlus = true;
                sc.sRawInput += " + ";
                sc.jf.setText(sc.sRawInput);
                if (sc.isPoint)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    sc.jf2.setText("" + sc.number1);
                } else if (!sc.isPoint)//when there is no bPoint in the result
                {
                    sc.jf2.setText("" + (long) sc.number1);
                }
            } else if (sc.isOperation && sc.operation != '=') {
                sc.number2 = Double.parseDouble(sc.sDisplay);

                if (sc.operation == '+') {
                    result = sc.number1 + sc.number2;
                } else if (sc.operation == '-') {
                    result = sc.number1 - sc.number2;
                } else if (sc.operation == '*') {
                    result = sc.number1 * sc.number2;
                } else if (sc.operation == '/') {

                    result = sc.number1 / sc.number2;
                } else if (sc.operation == '%') {
                    result = sc.number1 % sc.number2;
                } else {
                    result = sc.number2;
                }
                String temp = "";
                if (sc.isPoint || sc.operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    System.out.println("ttt");
                    sc.jf2.setText("" + result);
                    temp = "" + result;
                } else if (!sc.isPoint)//when there is no bPoint in the result
                {
                    sc.jf2.setText("" + (long) result);
                    temp = "" + (long) result;
                }
                sc.operation = '+';
                sc.sDisplay = "";
                sc.number1 = result;
                sc.isPlus = true;
                sc.isPoint = false;
                sc.isOperation = true;
                sc.sRawInput += " + ";
                sc.jf.setText(sc.sRawInput);
                sc.sRawInput = temp + " + ";
            } else if (sc.operation == '=') {
                sc.sDisplay = "";
                sc.operation = '+';
                sc.isPlus = true;
                sc.isOperation = true;
                sc.sRawInput += " + ";
                sc.jf.setText(sc.sRawInput);
            }
            sc.isOperation = true;
        } else if (e.getSource() == sc.Obtn[1] && (!sc.sDisplay.equals("") || sc.operation == '='))  // - button is clicked and input is not empty
        {
            if (!sc.isOperation)//to check if plus without number1
            {
                sc.number1 = Double.parseDouble(sc.sDisplay);
                sc.sDisplay = "";
                sc.operation = '-';
                sc.isPlus = true;
                sc.sRawInput += " - ";
                sc.jf.setText(sc.sRawInput);
                if (sc.isPoint)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    sc.jf2.setText("" + sc.number1);
                } else if (!sc.isPoint)//when there is no bPoint in the result
                {
                    sc.jf2.setText("" + (long) sc.number1);
                }
            } else if (sc.isOperation && sc.operation != '=') {
                sc.number2 = Double.parseDouble(sc.sDisplay);

                if (sc.operation == '+') {
                    result = sc.number1 + sc.number2;
                } else if (sc.operation == '-') {
                    result = sc.number1 - sc.number2;
                } else if (sc.operation == '*') {
                    result = sc.number1 * sc.number2;
                } else if (sc.operation == '/') {

                    result = sc.number1 / sc.number2;
                } else if (sc.operation == '%') {
                    result = sc.number1 % sc.number2;
                } else {
                    result = sc.number2;
                }
                String temp = "";
                if (sc.isPoint || sc.operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    sc.jf2.setText("" + result);
                    temp = "" + result;
                } else if (!sc.isPoint)//when there is no bPoint in the result
                {
                    sc.jf2.setText("" + (long) result);
                    temp = "" + (long) result;
                }
                sc.operation = '-';
                sc.sDisplay = "";
                sc.number1 = result;
                sc.isPlus = true;
                sc.isPoint = false;
                sc.isOperation = true;
                sc.sRawInput += " - ";
                sc.jf.setText(sc.sRawInput);
                sc.sRawInput = temp + " + ";
            } else if (sc.operation == '=') {
                sc.sDisplay = "";
                sc.operation = '-';
                sc.isPlus = true;
                sc.isOperation = true;
                sc.sRawInput += " - ";
                sc.jf.setText(sc.sRawInput);
            }
            sc.isOperation = true;
        } else if (e.getSource() == sc.Obtn[2] && (!sc.sDisplay.equals("") || sc.operation == '='))  // * button is clicked and input is not empty
        {
            if (!sc.isOperation)//to check if plus without number1
            {
                sc.number1 = Double.parseDouble(sc.sDisplay);
                sc.sDisplay = "";
                sc.operation = '*';
                sc.isPlus = true;
                sc.sRawInput += " \u00D7 ";
                sc.jf.setText(sc.sRawInput);
                if (sc.isPoint)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    sc.jf2.setText("" + sc.number1);
                } else if (!sc.isPoint)//when there is no bPoint in the result
                {
                    sc.jf.setText("" + (long) sc.number1);
                }
            } else if (sc.isOperation && sc.operation != '=') {
                sc.number2 = Double.parseDouble(sc.sDisplay);

                if (sc.operation == '+') {
                    result = sc.number1 + sc.number2;
                } else if (sc.operation == '-') {
                    result = sc.number1 - sc.number2;
                } else if (sc.operation == '*') {
                    result = sc.number1 * sc.number2;
                } else if (sc.operation == '/') {

                    result = sc.number1 / sc.number2;
                } else if (sc.operation == '%') {
                    result = sc.number1 % sc.number2;
                } else {
                    result = sc.number2;
                }
                String temp = "";
                if (sc.isPoint || sc.operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    sc.jf2.setText("" + result);
                    temp = "" + result;
                } else if (!sc.isPoint)//when there is no bPoint in the result
                {
                    sc.jf2.setText("" + (long) result);
                    temp = "" + (long) result;
                }
                sc.operation = '*';
                sc.sDisplay = "";
                sc.number1 = result;
                sc.isPlus = true;
                sc.isPoint = false;
                sc.isOperation = true;
                sc.sRawInput += " \u00D7 ";
                sc.jf.setText(sc.sRawInput);
                sc.sRawInput = temp + " \u00D7 ";
            } else if (sc.operation == '=') {
                sc.sDisplay = "";
                sc.operation = '*';
                sc.isPlus = true;
                sc.isOperation = true;
                sc.sRawInput += " \u00D7 ";
                sc.jf.setText(sc.sRawInput);
            }
            sc.isOperation = true;
        } else if (e.getSource() == sc.Obtn[3] && (!sc.sDisplay.equals("") || sc.operation == '='))  // bDivision button is clicked and input is not empty
        {

            if (!sc.isOperation)//to check if plus without number1
            {

                sc.number1 = Double.parseDouble(sc.sDisplay);
                sc.sDisplay = "";
                sc.operation = '/';
                sc.isPlus = true;
                sc.sRawInput += " / ";
                sc.jf.setText(sc.sRawInput);
                if (sc.isPoint)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    sc.jf2.setText("" + sc.number1);
                } else if (!sc.isPoint)//when there is no bPoint in the result
                {
                    sc.jf2.setText("" + (long) sc.number1);
                }
            } else if (sc.isOperation && sc.operation != '=') {
                sc.number2 = Double.parseDouble(sc.sDisplay);
                try {


                if (sc.operation == '+') {
                    result = sc.number1 + sc.number2;
                } else if (sc.operation == '-') {
                    result = sc.number1 - sc.number2;
                } else if (sc.operation == '*') {
                    result = sc.number1 * sc.number2;
                } else if (sc.operation == '/') {

                    result = sc.number1 / sc.number2;

                } else if (sc.operation == '%') {
                    result = sc.number1 % sc.number2;
                } else {
                    result = sc.number2;
                }
                String temp = "";
                if (sc.isPoint || sc.operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    sc.jf2.setText("" + result);
                    temp = "" + result;
                } else if (!sc.isPoint)//when there is no bPoint in the result
                {
                    sc.jf2.setText("" + (long) result);
                    temp = "" + (long) result;
                }

                sc.operation = '*';
                sc.sDisplay = "";
                sc.number1 = result;
                sc.isPlus = true;
                sc.isPoint = false;
                sc.isOperation = true;
                sc.sRawInput += " / ";
                sc.jf.setText(sc.sRawInput);
                sc.sRawInput = temp + " / ";}catch (Exception z){
                    sc.jf2.setText(z.getMessage());
                }
            } else if (sc.operation == '=') {
                sc.sDisplay = "";
                sc.operation = '/';
                sc.isPlus = true;
                sc.isOperation = true;
                sc.sRawInput += " / ";
                sc.jf.setText(sc.sRawInput);
            }
            sc.isOperation = true;
        } else if (e.getSource() == sc.Obtn[5] && !sc.sDisplay.equals(""))//when bEqual button is clicked and the input is not empty
        {
            sc.number2 = Double.parseDouble(sc.sDisplay);
            try {


            if (sc.operation == '+') {
                result = sc.number1 + sc.number2;
            } else if (sc.operation == '-') {
                result = sc.number1 - sc.number2;
            } else if (sc.operation == '*') {
                result = sc.number1 * sc.number2;
            } else if (sc.operation == '/') {

                if(sc.number2==0){
                    throw new Exception();
                }
                result = sc.number1 / sc.number2;
            } else if (sc.operation == '%') {
                result = sc.number1 % sc.number2;
            } else {
                result = sc.number2;
            }
            String temp = "";
            if (sc.isPoint || sc.operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
            {
                sc.jf2.setText("" + result);
                temp = "" + result;
            } else if (!sc.isPoint)//when there is no bPoint in the result
            {
                sc.jf2.setText("" + (long) result);
                temp = "" + (long) result;
            }
            sc.sDisplay = "";
            sc.number1 = result;
            sc.isPlus = true;
            sc.isPoint = false;
            sc.isOperation = true;
            sc.sRawInput += " = ";
            sc.jf.setText(sc.sRawInput);
            sc.sRawInput = temp;
            sc.operation = '=';}catch (Exception z){
                sc.jf2.setText("MATH ERROR");

            }
        } else if (e.getSource() == sc.Obtn[4] && !sc.sDisplay.equals(""))//DE button

        {
            sc.sDisplay = sc.sDisplay.substring(0, sc.sDisplay.length() - 1);
            sc.sRawInput = sc.sRawInput.substring(0, sc.sRawInput.length() - 1);
            if (sc.sRawInput.equals(""))//after deleting the last digit
            {
                //tfDisplay.setText("0");
                sc.jf.setText("0");
            } else {
                //tfDisplay.setText(sDisplay);
                sc.jf.setText(sc.sRawInput);
            }
        } else if (e.getSource() == sc.Obtn[6])//Clear button

        {
            sc.number1 = sc.number2 = result = 0;
            sc.sDisplay = "";
            sc.operation = ' ';
            sc.jf2.setText("0");
            sc.isPoint = false;
            sc.isPlus = true;
            sc.isOperation = false;
            sc.sRawInput = "";
            sc.jf.setText("0");
        } else if (e.getSource() == sc.Sbtn[12] && !sc.sDisplay.equals(""))//Square button

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.pow(sc.number1, 2);
            String temp = "";
            if (!sc.isPoint) {
                sc.jf2.setText("" + (long) result);
                temp = "" + (long) result;
            } else {
                sc.jf2.setText("" + result);
                temp = "" + result;
            }
            sc.sRawInput += "^2 = ";
            sc.jf.setText(sc.sRawInput);
            sc.sRawInput = temp;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = false;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[0]) {
//             (sc.operation == '=') {
            sc.sDisplay = "";
            sc.sRawInput = String.valueOf(Math.PI);
            sc.jf2.setText(sc.sRawInput);
            sc.jf.setText(sc.sRawInput);
            sc.operation = ' ';

        }//Square button
        else if (e.getSource() == sc.Sbtn[15]) {
//             (sc.operation == '=') {
            sc.sDisplay = "";
            Random rand = new Random();

            sc.sRawInput = String.valueOf(Math.round(rand.nextDouble() * 10));
            sc.jf2.setText(sc.sRawInput);
            sc.jf.setText("Rnd");
            sc.operation = ' ';

        } else if (e.getSource() == sc.Sbtn[1]) {
//             (sc.operation == '=') {
            sc.sDisplay = "";
            sc.sRawInput = String.valueOf(Math.E);
            sc.jf2.setText(sc.sRawInput);
            sc.jf.setText(sc.sRawInput);
            sc.operation = ' ';

        } else if (e.getSource() == sc.Sbtn[3]) {
//             (sc.operation == '=') {
            sc.sDisplay = "";
            sc.sRawInput = String.valueOf(Math.TAU);
            sc.jf2.setText(sc.sRawInput);
            sc.jf.setText(sc.sRawInput);
            sc.operation = ' ';

        } else if (e.getSource() == sc.Sbtn[11] && !sc.sDisplay.equals(""))//root button

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.sqrt(sc.number1);
            sc.sRawInput = "\u221A" + sc.sRawInput;
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[13] && !sc.sDisplay.equals("")) //Cube button

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.pow(sc.number1, 3);
            String temp = "";
            if (!sc.isPoint) {
                sc.jf2.setText("" + (long) result);
                temp = "" + (long) result;
            } else {
                sc.jf2.setText("" + result);
                temp = "" + result;
            }
            sc.sRawInput += "^3 = ";
            sc.jf.setText(sc.sRawInput);
            sc.sRawInput = temp;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = false;
            sc.isOperation = true;
            sc.isPlus = true;

        } else if (e.getSource() == sc.Sbtn[14] && !sc.sDisplay.equals("")) //Cube button

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            int j = 1, fact = 1;
            for (int i = 1; i <= (int) sc.number1; i++) {
                fact = fact * i;
            }


            if (sc.number1 < 0) {
                sc.jf2.setText("ERROR");
            }
            if (sc.number1 == 0) {
                fact = 1;
            }
//            sc.sRawInput += sc.number1+"! = ";
            sc.jf.setText(sc.number1 + "! = ");
            sc.jf2.setText(String.valueOf(fact));
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = false;
            sc.isOperation = true;
            sc.isPlus = true;

        } else if (e.getSource() == sc.Sbtn[3] && !sc.sDisplay.equals("") && sc.operation == '*')// % button is pressed

        {
            sc.number2 = Double.parseDouble(sc.sDisplay);
            result = sc.number1 * (sc.number2 / 100);
            sc.sRawInput = sc.number1 + " \u00D7 " + sc.number2 + "%";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPlus = true;
            sc.isOperation = true;
            sc.isPoint = true;
            sc.sRawInput = "" + result;
        } else if (e.getSource() == sc.Sbtn[4] && !sc.sDisplay.equals(""))//sin function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            if (sc.number1 == 30) {
                result = Math.sin(Math.toRadians(sc.number1)) + 0.0000000000000001;
            } else {
                result = Math.sin(Math.toRadians(sc.number1));
            }
            sc.sRawInput = "sin(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[5] && !sc.sDisplay.equals(""))//cosine function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            if (sc.number1 == 60) {
                result = Math.cos(Math.toRadians(sc.number1)) - 0.0000000000000001;
            } else if (sc.number1 == 90) {
                result = 0;
            } else {
                result = Math.cos(Math.toRadians(sc.number1));
            }
            sc.sRawInput = "cos(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[6] && !sc.sDisplay.equals(""))//tan function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            if (sc.number1 == 45) {
                result = Math.tan(Math.toRadians(sc.number1)) + 0.0000000000000001;
            } else if (sc.number1 == 90) {
                result = 0;
                sc.jf2.setText("Invalid");
            } else {
                result = Math.tan(Math.toRadians(sc.number1));
            }
            sc.sRawInput = "tan(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            if (sc.number1 != 90) {
                sc.jf2.setText("" + result);
            }
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[7] && !sc.sDisplay.equals(""))//sinh function
        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = 1 / Math.sin(Math.toRadians(sc.number1));
            sc.sRawInput = "csc(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[8] && !sc.sDisplay.equals(""))//sinh function
        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = 1 / Math.cos(Math.toRadians(sc.number1));
            sc.sRawInput = "sec(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[9] && !sc.sDisplay.equals(""))//sinh function
        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = 1 / Math.tan(Math.toRadians(sc.number1));
            sc.sRawInput = "cot(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[0] && !sc.sDisplay.equals(""))//tanh function
        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.PI;
            sc.sRawInput = String.valueOf(result);
            // sc.sRawInput =  "π("+sc.sRawInput+")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[19] && !sc.sDisplay.equals(""))//asin function
        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.asin(Math.toRadians(sc.number1));
            sc.sRawInput = "asin(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[20] && !sc.sDisplay.equals(""))//acos function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.acos(Math.toRadians(sc.number1));
            sc.sRawInput = "acos(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[18] && !sc.sDisplay.equals(""))//atan function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.atan(Math.toRadians(sc.number1));
            sc.sRawInput = "atan(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[23] && !sc.sDisplay.equals(""))//atan function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = 1 / Math.atan(Math.toRadians(sc.number1));
            sc.sRawInput = "acot(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[22] && !sc.sDisplay.equals(""))//atan function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = 1 / Math.acos(Math.toRadians(sc.number1));
            sc.sRawInput = "asec(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[21] && !sc.sDisplay.equals(""))//atan function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = 1 / Math.asin(Math.toRadians(sc.number1));
            sc.sRawInput = "acsc(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[10] && !sc.sDisplay.equals(""))//log function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.log10(sc.number1);
            sc.sRawInput = "log" + sc.sRawInput;
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[16] && !sc.sDisplay.equals(""))//ln function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.log(sc.number1);//Math.log(sc.number1);Math
            sc.sRawInput = "ln" + sc.sRawInput;
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[10] && !sc.sDisplay.equals(""))//ln function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.log10(sc.number1);
            sc.sRawInput = "log" + sc.sRawInput;
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[17] && !sc.sDisplay.equals(""))//abs function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.abs(sc.number1);
            sc.sRawInput = "abs(" + sc.sRawInput + ")";
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[2] && !sc.sDisplay.equals(""))//power of ten function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.pow(10, sc.number1);
            sc.sRawInput = "10^" + sc.sRawInput;
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        } else if (e.getSource() == sc.Sbtn[24] && !sc.sDisplay.equals(""))//power of ten function

        {
            sc.number1 = Double.parseDouble(sc.sDisplay);
            result = Math.pow(Math.E, sc.number1);
            sc.sRawInput = "e^" + sc.sRawInput;
            sc.jf.setText(sc.sRawInput);
            sc.jf2.setText("" + result);
            sc.sRawInput = "" + result;
            sc.sDisplay = "";
            sc.number1 = result;
            sc.operation = '=';
            sc.isPoint = true;
            sc.isOperation = true;
            sc.isPlus = true;
        }}catch (Exception z){
            sc.jf2.setText("MATH ERROR");
        }
    }

}

class Tempc implements  ActionListener{
    try3 t;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public Tempc(try3 t2){
        t=t2;

        t.x = (int) ((screenSize.getWidth() - this.t.getWidth()) / 2);
        t.y = (int) ((screenSize.getHeight() - this.t.getHeight()) / 2);}
    @Override
    public void actionPerformed(ActionEvent e) {
        t.setSize(1000, 600);
        t.setLocation(t.x - 200, t.y - 40);
        t.setBackground(Color.orange);
        t.remove(t.jf);
        t.remove(t.jp);
        t.remove(t.jp2);
        t.remove(t.jf2);
        t.remove(t.jp3);
        t.remove(t.jp5);
        String scales[] ={"°C Celsius","°F Fahernite","K Kelvin"};


        t.jp4.setLayout(null);
        t.jp4.setBackground(new Color(0, 128, 128));
        t.jp4.setBounds(0, 210, 1000, 120);
        //t.add(t.jp3);
        t.jf3 = new JTextField();
        t.jcombo= new  JComboBox<>(scales);
        t.jcombo2= new  JComboBox<>(scales);

        t.draw = new JButton("Convert");

        t.graph.setEnabled(true);
        t.sci.setEnabled(true);
        t.stc.setEnabled(true);
        t.temp.setEnabled(false);
        t.len.setEnabled(true);


        t.ymx = new JLabel("Original Scale");
        t.ymx.setForeground(Color.white);
        t.ymx.setBounds(40, 25, 180, 40);
        t.ymx.setFont(new Font("Monaco", Font.BOLD, 16));
        t.jp4.add(t.ymx);

        t.Qf = new JLabel("Convert To");
        t.Qf.setForeground(Color.white);
        t.Qf.setBounds(360, 25, 180, 40);
        t.Qf.setFont(new Font("Monaco", Font.BOLD, 16));
        t.jp4.add(t.Qf);

        t.jcombo.setBounds(90, 65, 120, 20);
        t.jcombo.setFont(new Font("Monaco", Font.PLAIN, 15));
        t.jcombo.setBackground(new Color(255, 165, 0));
        t.jcombo.setForeground(Color.BLACK);
        //t.b.setForeground(Color.white);
        t.jf3.setBounds(40, 65, 50, 20);
        t.jf3.setFont(new Font("Monaco", Font.BOLD, 18));
        t.jp4.add(t.jf3);
        t.jp4.add(t.jcombo);

        t.fx2 = new JLabel("Ans: ");
        t.fx2.setFont(new Font("Monaco", Font.BOLD, 18));
        t.fx2.setBounds(580, 62, 180, 20);
        t.fx2.setForeground(Color.white);

        t.jcombo2.setBounds(360, 65, 120, 20);
        t.jcombo2.setFont(new Font("Monaco", Font.PLAIN, 15));
        t.jcombo2.setForeground(Color.BLACK);
        t.jcombo2.setBackground(new Color(255, 165, 0));
        t.jcombo.setSelectedItem(scales[0]);
        t.jcombo2.setSelectedItem(scales[0]);

        t.draw.setBounds(730, 35, 150, 50);
        t.draw.setFont(new Font("Monaco", Font.BOLD, 18));
        t.draw.setBackground(new Color(64, 224, 208));
        t.draw.setBorderPainted(false);
        t.draw.setFocusPainted(false);
        t.draw.addActionListener(e1 -> {
            try{
            double num1=Double.parseDouble(t.jf3.getText()); double result;
            if(t.jcombo.getSelectedItem()==scales[0] && t.jcombo2.getSelectedIndex()!=(-1)){
                System.out.println(t.jcombo2.getSelectedIndex());
                if(t.jcombo2.getSelectedItem()==scales[1]){
                    result= ((9/5)*num1)+32;
                    t.fx2.setText("Ans: "+String.valueOf(result)+"°F");
                }else if (t.jcombo.getSelectedIndex()==t.jcombo2.getSelectedIndex()) {
                    t.fx2.setText("Ans: "+String.valueOf(num1));}
                else {
                    result=(num1+273.15);
                    t.fx2.setText("Ans: "+result+"K");
                }
            }

            else if(t.jcombo.getSelectedItem()==scales[1] && t.jcombo2.getSelectedIndex()!=(-1)){
                if(t.jcombo2.getSelectedItem()==scales[0]){
                    result= ((5/9)*((num1-32)));
                    t.fx2.setText("Ans: "+String.valueOf(result)+"°C");
                }
                 else {
                    result=( ((5/9)*((num1-32)))+273.15);
                    t.fx2.setText("Ans: "+result+"K");
                }
            }
            else if(t.jcombo.getSelectedItem()==scales[2] && t.jcombo2.getSelectedIndex()!=(-1)){
                if(t.jcombo2.getSelectedItem()==scales[0]){
                    result= num1-272.15;
                    t.fx2.setText("Ans: "+String.valueOf(result)+"°C");
                }
                else {
                    result=((9/5)*(num1-273.15))+32;
                    t.fx2.setText("Ans: "+result+"°F");
                }
            }

            }catch (Exception d){
                t.fx2.setText("Error");
                t.jf3.setText("");
            }
        });


        t.jp4.add(t.jcombo2);
        t.jp4.add(t.draw);
        t.jp4.add(t.fx2);
        t.add(t.jp4);



    }}

class Len implements  ActionListener{
    try3 t;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public Len(try3 t2){
        t=t2;

        t.x = (int) ((screenSize.getWidth() - this.t.getWidth()) / 2);
        t.y = (int) ((screenSize.getHeight() - this.t.getHeight()) / 2);}
    @Override
    public void actionPerformed(ActionEvent e) {
        t.setSize(1000, 600);
        t.setLocation(t.x - 200, t.y - 40);
        t.setBackground(Color.orange);
        t.remove(t.jf);
        t.remove(t.jp);
        t.remove(t.jp2);
        t.remove(t.jf2);
        t.remove(t.jp3);
        t.remove(t.jp4);
        String scales[] ={"Meter","Kilometer","milimeter","centimeter","feet","inch"};

        t.graph.setEnabled(true);
        t.sci.setEnabled(true);
        t.stc.setEnabled(true);
        t.temp.setEnabled(true);
        t.len.setEnabled(false);

        t.jp5.setLayout(null);
        t.jp5.setBackground(new Color(0, 128, 128));
        t.jp5.setBounds(0, 210, 1000, 120);

        t.jf3 = new JTextField();
        t.jcombo= new  JComboBox<>(scales);
        t.jcombo2= new  JComboBox<>(scales);

        t.draw = new JButton("Convert");

        t.ymx = new JLabel("Original Scale");
        t.ymx.setForeground(Color.white);
        t.ymx.setBounds(40, 25, 180, 40);
        t.ymx.setFont(new Font("Monaco", Font.BOLD, 16));
        t.jp5.add(t.ymx);

        t.Qf = new JLabel("Convert To");
        t.Qf.setForeground(Color.white);
        t.Qf.setBounds(360, 25, 180, 40);
        t.Qf.setFont(new Font("Monaco", Font.BOLD, 16));
        t.jp5.add(t.Qf);

        t.jcombo.setBounds(90, 65, 120, 20);
        t.jcombo.setFont(new Font("Monaco", Font.PLAIN, 15));
        t.jcombo.setBackground(new Color(255, 165, 0));
        t.jcombo.setForeground(Color.BLACK);
        //t.b.setForeground(Color.white);
        t.jf3.setBounds(40, 65, 50, 20);
        t.jf3.setFont(new Font("Monaco", Font.BOLD, 18));
        t.jp5.add(t.jf3);
        t.jp5.add(t.jcombo);

        t.fx2 = new JLabel("Ans: ");
        t.fx2.setFont(new Font("Monaco", Font.BOLD, 18));
        t.fx2.setBounds(580, 62, 180, 20);
        t.fx2.setForeground(Color.white);

        t.jcombo2.setBounds(360, 65, 120, 20);
        t.jcombo2.setFont(new Font("Monaco", Font.PLAIN, 15));
        t.jcombo2.setForeground(Color.BLACK);
        t.jcombo2.setBackground(new Color(255, 165, 0));
        t.jcombo.setSelectedItem(scales[0]);
        t.jcombo2.setSelectedItem(scales[0]);

        t.draw.setBounds(770, 35, 150, 50);
        t.draw.setFont(new Font("Monaco", Font.BOLD, 18));
        t.draw.setBackground(new Color(64, 224, 208));
        t.draw.setBorderPainted(false);
        t.draw.setFocusPainted(false);
        t.draw.addActionListener(e1 -> {
            try{
                double num1=Double.parseDouble(t.jf3.getText()); double result;
                if(t.jcombo.getSelectedItem()==scales[0] ){

                    if(t.jcombo2.getSelectedItem()==scales[1]){
                        result= num1/1000;
                        t.fx2.setText("Ans: "+String.valueOf(result)+"Km");
                    }else if (t.jcombo.getSelectedIndex()==t.jcombo2.getSelectedIndex()) {
                        t.fx2.setText("Ans: "+String.valueOf(num1));}
                    else if(t.jcombo2.getSelectedItem()==scales[2]){
                        result=(num1*1000);
                        t.fx2.setText("Ans: "+result+"mm");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[3]){
                        result=(num1*100);
                        t.fx2.setText("Ans: "+result+"cm");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[4]){
                        result=(num1*3.28);
                        t.fx2.setText("Ans: "+result+"feet");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[5]){
                        result=(num1*39.7);
                        t.fx2.setText("Ans: "+result+"inch");
                    }
                }

                else if(t.jcombo.getSelectedItem()==scales[1] ){
                    if(t.jcombo2.getSelectedItem()==scales[0]){
                        result= num1*1000;
                        t.fx2.setText("Ans: "+String.valueOf(result)+"m");
                    }else if (t.jcombo.getSelectedIndex()==t.jcombo2.getSelectedIndex()) {
                        t.fx2.setText("Ans: "+String.valueOf(num1));}
                    else if(t.jcombo2.getSelectedItem()==scales[2]){
                        result=(num1*1000*1000);
                        t.fx2.setText("Ans: "+result+"mm");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[3]){
                        result=(num1*1000*100);
                        t.fx2.setText("Ans: "+result+"cm");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[4]){
                        result=(num1*1000*3.28);
                        t.fx2.setText("Ans: "+result+"feet");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[5]){
                        result=(num1*39.7*100);
                        t.fx2.setText("Ans: "+result+"inch");
                    }
                }
                else if(t.jcombo.getSelectedItem()==scales[2] ){
                    if(t.jcombo2.getSelectedItem()==scales[0]){
                        result= num1/1000;
                        t.fx2.setText("Ans: "+String.valueOf(result)+"m");
                    }else if (t.jcombo.getSelectedIndex()==t.jcombo2.getSelectedIndex()) {
                        t.fx2.setText("Ans: "+String.valueOf(num1));}
                    else if(t.jcombo2.getSelectedItem()==scales[1]){
                        result=(num1/1_000_000);
                        t.fx2.setText("Ans: "+result+"km");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[2]){
                        result=(num1/100);
                        t.fx2.setText("Ans: "+result+"cm");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[4]){
                        result=(num1/1000)/3.28;
                        t.fx2.setText("Ans: "+result+"feet");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[5]){
                        result=(num1/1000)/39.7;
                        t.fx2.setText("Ans: "+result+"inch");
                    }
                }
                else if(t.jcombo.getSelectedItem()==scales[3] ){
                    if(t.jcombo2.getSelectedItem()==scales[0]){
                        result= num1/100;
                        t.fx2.setText("Ans: "+String.valueOf(result)+"m");
                    }else if (t.jcombo.getSelectedIndex()==t.jcombo2.getSelectedIndex()) {
                        t.fx2.setText("Ans: "+String.valueOf(num1));}
                    else if(t.jcombo2.getSelectedItem()==scales[1]){
                        result=(num1/1_00_000);
                        t.fx2.setText("Ans: "+result+"km");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[2]){
                        result=(num1*100);
                        t.fx2.setText("Ans: "+result+"mm");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[4]){
                        result=(num1/100)/3.28;
                        t.fx2.setText("Ans: "+result+"feet");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[5]){
                        result=(num1/1000)/39.7;
                        t.fx2.setText("Ans: "+result+"inch");
                    }
                }
                else if(t.jcombo.getSelectedItem()==scales[4] ){
                    if(t.jcombo2.getSelectedItem()==scales[0]){
                        result= num1*3.28;
                        t.fx2.setText("Ans: "+String.valueOf(result)+"m");
                    }else if (t.jcombo.getSelectedIndex()==t.jcombo2.getSelectedIndex()) {
                        t.fx2.setText("Ans: "+String.valueOf(num1));}
                    else if(t.jcombo2.getSelectedItem()==scales[1]){
                        result=((num1*3.28)/1000);
                        t.fx2.setText("Ans: "+result+"km");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[2]){
                        result=(num1*3.28*1000);
                        t.fx2.setText("Ans: "+result+"mm");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[3]){
                        result=(num1*100)*3.28;
                        t.fx2.setText("Ans: "+result+"feet");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[5]){
                        result=(num1*3.28)/39.7;
                        t.fx2.setText("Ans: "+result+"inch");
                    }
                }
                else if(t.jcombo.getSelectedItem()==scales[5] ){
                    if(t.jcombo2.getSelectedItem()==scales[0]){
                        result= num1*39.7;
                        t.fx2.setText("Ans: "+String.valueOf(result)+"m");
                    }else if (t.jcombo.getSelectedIndex()==t.jcombo2.getSelectedIndex()) {
                        t.fx2.setText("Ans: "+String.valueOf(num1));}
                    else if(t.jcombo2.getSelectedItem()==scales[1]){
                        result=((num1*39.7)/1000);
                        t.fx2.setText("Ans: "+result+"km");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[2]){
                        result=(num1*39.7*1000);
                        t.fx2.setText("Ans: "+result+"mm");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[3]){
                        result=(num1*100)*39.7;
                        t.fx2.setText("Ans: "+result+"cm");
                    }
                    else if(t.jcombo2.getSelectedItem()==scales[4]){
                        result=(num1*39.7)*3.28;
                        t.fx2.setText("Ans: "+result+"feet");
                    }
                }

            }catch (Exception d){
                t.fx2.setText("Error");
                t.jf3.setText("");
            }
        });


        t.jp5.add(t.jcombo2);
        t.jp5.add(t.draw);
        t.jp5.add(t.fx2);
        t.add(t.jp5);


    }}