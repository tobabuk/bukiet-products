package bukiet.products;

import javax.swing.*;
import java.awt.*;

public class ProductsPopUp extends JFrame {
    public ProductsPopUp(ImageIcon fullImage, String title, double price, String description) {

        setTitle("Product Details");

        setSize(400, 600);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Image img = fullImage.getImage();
        Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel imageLabel = new JLabel(scaledIcon);
        JLabel titleLabel = new JLabel(title);
        JLabel priceLabel = new JLabel("$" + price);
        JLabel descriptionLabel = new JLabel("Product Description" + description);

        panel.add(titleLabel);
        panel.add(descriptionLabel);
        panel.add(priceLabel);

        add(imageLabel, BorderLayout.CENTER);

        add(panel, BorderLayout.NORTH);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);

        setLocationRelativeTo(null);
    }
}
