package service.impl;

import entity.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void addProduct(Integer id, String name, String type, String desc, Double price, String urlImage) throws Exception {
        if(id==null||name==""||desc==""||type==""||price==null||urlImage=="") {
            throw new Exception("Vui lòng nhập đủ thông tin !!");
        }
        if(findById(id)!=null) throw new Exception("ID đã tồn tại");
        this.productRepository.addProduct(id,name,type,desc,price,urlImage);
    }


    @Override
    public void updateProduct(Integer id, String name, String type, String desc, Double price, String urlImage) throws Exception {
        this.productRepository.updateProduct(id,name,type,desc,price,urlImage);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productRepository.deleteProduct(id);
    }
}
