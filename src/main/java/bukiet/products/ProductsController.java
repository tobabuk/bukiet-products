package bukiet.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class ProductsController {
    private ProductsService service;
    private JLabel[] imageLabels;

    public ProductsController(ProductsService service, JLabel[] imageLabels) {
        this.imageLabels = imageLabels;
        this.service = service;
    }

    public void display() {

        ProductsResponse products = service.getProducts().blockingGet();

        for (int i = 0; i < imageLabels.length; i++) {

            Product product = products.products[i];
            try {
                URL url = new URL(product.thumbnail);
                String imageUrl = product.images[0];

                URL url2 = new URL(imageUrl);
                //downloads the image from the internet
                Image image = ImageIO.read(url);

                String title = product.title;
                double price = product.price;
                String description = product.description;

                ImageIcon thumbnailImage = new ImageIcon(image);
                imageLabels[i].setIcon(thumbnailImage);


                imageLabels[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Image image2 = null;
                        try {
                            image2 = ImageIO.read(url2);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        ImageIcon fullImage = new ImageIcon(image2);
                        final ImageIcon fullImageIconFinal = fullImage;
                        SwingUtilities.invokeLater(()
                                -> new ProductsPopUp(fullImageIconFinal, title, price, description));

                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        }
    }
}

