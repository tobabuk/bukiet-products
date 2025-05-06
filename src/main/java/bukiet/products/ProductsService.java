package bukiet.products;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ProductsService {
    @GET("/products")
    Single<ProductsResponse> getProducts();


}
