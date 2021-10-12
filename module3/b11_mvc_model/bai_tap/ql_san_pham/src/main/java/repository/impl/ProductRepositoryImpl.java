package repository.impl;

import entity.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(453,"iPhone 6","Điện thoại", "Hàng mới về", (double) 1200000, "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_6s_plus_1.jpg"));
        productList.add(new Product(468,"iPhone 6","Điện thoại", "Hàng cũ", (double) 1267400, "https://cdn.cellphones.com.vn/media/catalog/product/i/p/iphone_13-_pro-5_4_1_1_1_1.jpg"));
        productList.add(new Product(567,"iPhone X","Điện thoại", "Hàng mới về", (double) 7776631, "https://cdn.cellphones.com.vn/media/catalog/product/i/p/iphone_x_64gb_3.jpg"));
        productList.add(new Product(654,"iPhone 13","Điện thoại", "Hàng mới về", (double) 7664887,"https://cdn.cellphones.com.vn/media/catalog/product/i/p/iphone-13-02_2.jpg"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        for(Product product : productList) {
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Integer id, String name, String type, String desc, Double price, String urlImage) {
        productList.add(new Product(id,name,type,desc,price,urlImage));
    }

    @Override
    public void updateProduct(Integer id, String name, String type, String desc, Double price, String urlImage) {
        for(Product product : productList) {
            if(product.getId().equals(id)) {
                product.setName(name);
                product.setType(type);
                product.setDesc(desc);
                product.setPrice(price);
                product.setUrlImage(urlImage);
            }
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId().equals(id)){
                productList.remove(i);
            }
        }
    }
}
