package service.Impl;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Bút", "Bút cho học sinh"));
        products.put(2, new Product(2, "Chuột máy tính", "Chuột cho người làm văn phòng"));
        products.put(3, new Product(3, "Laptop", "Laptop gaming"));
        products.put(4, new Product(4, "Camera", "Máy ảnh gia đình"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product searchProductByName(String name) {
        List<Product> productList = findAll();
        for (Product product:productList) {
            if (product.getName().equals(name)) return product;
        }
        return null;
    }
}
