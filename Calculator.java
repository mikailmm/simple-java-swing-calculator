import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField text;
    JButton c, div, mul, sub, adr, eq, pm, dec;
    JButton o1, t2, t3, f4, f5, s6, s7, e8, n9, z0;
    JButton[] jb = {o1, t2, t3, f4, f5, s6, s7, e8, n9, z0, pm, dec, div, mul, sub, adr};
    ArrayList<JButton> jbut;

    Calculator() {
        super("Calculator");
        setLayout(new FlowLayout());

        c = new JButton("C");
        c.setPreferredSize(new Dimension(155, 40));
        eq = new JButton("=");
        eq.setPreferredSize(new Dimension(155, 40));
        s7 = new JButton("7");
        s7.setPreferredSize(new Dimension(75, 35));
        e8 = new JButton("8");
        e8.setPreferredSize(new Dimension(75, 35));
        n9 = new JButton("9");
        n9.setPreferredSize(new Dimension(75, 35));
        div = new JButton("/");
        div.setPreferredSize(new Dimension(75, 35));
        f4 = new JButton("4");
        f5 = new JButton("5");
        s6 = new JButton("6");
        mul = new JButton("*");
        o1 = new JButton("1");
        t2 = new JButton("2");
        t3 = new JButton("3");
        sub = new JButton("-");
        z0 = new JButton("0");
        pm = new JButton("±");
        dec = new JButton(".");
        adr = new JButton("+");

        jbut = new ArrayList<>(Arrays.asList(o1, t2, t3, f4, f5, s6, s7, e8, n9, z0, pm, dec, div, mul, sub, adr));
        for (JButton jButton : jbut) {
            jButton.setPreferredSize(new Dimension(75, 35));
        }

        text = new JTextField("0", 15);
        text.setEditable(false);
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 21);
        text.setFont(f);


        add(text);
        add(c); add(eq);
        add(s7); add(e8); add(n9); add(div);
        add(f4); add(f5); add(s6); add(mul);
        add(o1); add(t2); add(t3); add(sub);
        add(z0); add(pm); add(dec); add(adr);

        for (JButton jButton : jbut) {
            jButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
            jButton.addActionListener(this);
        }

        c.addActionListener(this);
        c.setActionCommand("clear");
        c.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        eq.addActionListener(this);
        eq.setActionCommand("=");
        eq.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

        z0.setActionCommand("0");
        o1.setActionCommand("1");
        t2.setActionCommand("2");
        adr.setActionCommand("+");
        dec.setActionCommand(".");


        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        Dimension dim = new Dimension(320, 280);
        Calculator calc = new Calculator();
        int height = dim.height, width = dim.width;
        calc.setVisible(true);
        calc.setMinimumSize(dim);
        calc.setMaximumSize(dim);
        calc.setSize(dim);
        calc.setBounds(100, 100, width, height);
    }

    long temp1 = 0, temp2 = 0, temp3 = 0;
    boolean isOperatorOn = false;
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "clear":
                text.setText("0");
                temp1 = 0;
                break;

            case "0":
                if (!text.getText().equals("0"))
                text.setText(text.getText() + "0" );
                break;

            case "1":
                if (!text.getText().equals("0"))
                text.setText(text.getText() + "1" );
                else text.setText("1");
                break;

            case "2":
                if (!text.getText().equals("0"))
                text.setText(text.getText() + "2" );
                else text.setText("2");
                break;

            case "fskmfks": // case "."
                if (!text.getText().contains(".")) {
                    text.setText(text.getText() + ".");
                    String temp = text.getText();
                    text.setText("");
                    text.setText(temp);
                }
                break;

            case "+":
                temp1 += Long.parseLong(text.getText());
                text.setText("0");
                isOperatorOn = true;
                break;

            case "=":
                temp1 += Long.parseLong(text.getText());
                text.setText("" + temp1);
                break;
        
            default:
                break;
        }
    }
}
