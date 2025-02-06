import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UI extends JFrame implements MouseMotionListener {

    private JPanel panel;
    private int x = 0, y = 0;
    private Color color = Color.BLACK;

    public UI() {
        setSize(500, 700);
        setVisible(true);
        setLayout(null);


        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 500, 100);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel1);


        JButton button1 = new JButton("Red");
        button1.setBackground(Color.RED);
        button1.addActionListener((e) -> color = Color.RED);
        panel1.add(button1);


        JButton button2 = new JButton("Clear");
        button2.setBackground(Color.GRAY);
        button2.addActionListener(e -> panel.repaint());
        panel1.add(button2);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (color == Color.WHITE) {
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        panel.setBounds(0, 100, 500, 600);
        panel.setBackground(Color.GRAY);
        panel.addMouseMotionListener(this);
        add(panel);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.drawLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public static void main(String[] args) {
        new UI();
    }
}

