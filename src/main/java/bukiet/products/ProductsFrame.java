package bukiet.products;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductsFrame extends JFrame {
    private ProductsController controller;
    private JLabel[] labels = new JLabel[9];

    public ProductsFrame() {
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            add(labels[i]);

        }
        controller = new ProductsController(new ProductsServiceFactory().create(), labels);
        controller.display();

        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new ProductsFrame().setVisible(true);
    }
}
