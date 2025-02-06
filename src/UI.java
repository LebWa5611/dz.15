import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UI extends JFrame {
    private DrawingPanel panel;
    private Color color = Color.BLACK;

    public UI() {
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 500, 100);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel1);

        JButton button1 = new JButton("Red");
        button1.setBackground(Color.RED);
        button1.addActionListener((e) -> panel.setColor(Color.RED));
        panel1.add(button1);

        JButton button3 = new JButton("Blue");
        button3.setBackground(Color.BLUE);
        button3.addActionListener((e) -> panel.setColor(Color.BLUE));
        panel1.add(button3);

        JButton button2 = new JButton("Clear");
        button2.setBackground(Color.GRAY);
        button2.addActionListener(e -> panel.clear()); // Тепер правильно очищає
        panel1.add(button2);

        panel = new DrawingPanel();
        panel.setBounds(0, 100, 500, 600);
        panel.setBackground(Color.WHITE);
        add(panel);

        setVisible(true);
    }

    private class DrawingPanel extends JPanel implements MouseMotionListener {
        private int x, y;

        public DrawingPanel() {
            addMouseMotionListener(this);
        }

        public void setColor(Color newColor) {
            color = newColor;
        }

        public void clear() {
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UI::new);
    }
}


