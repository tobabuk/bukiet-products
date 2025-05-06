package bukiet.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsServiceTest {

    @Test
    void getProducts(){
        ProductsService service = new ProductsServiceFactory().create();
        ProductsResponse products = service.getProducts().blockingGet();
            assertTrue(products.products.length > 0);
    }
}