package examples.assignment.ex_dookdak.controller;

import examples.assignment.ex_dookdak.model.dao.ProductDao;
import examples.assignment.ex_dookdak.model.dto.ProductDto;

import java.util.ArrayList;

public class ProductController {
    private ProductController() {}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance() {
        return instance;
    }
    private ProductDao dao = ProductDao.getInstance();

    public void addProduct(String pUser, String pName, String pDesc, int pPrice, String pPw) {
        ProductDto dto = new ProductDto(0, pPrice, pUser, pName, pDesc, pPw, null, false);
        dao.addProduct(dto);
    }

    public ArrayList<ProductDto> viewProduct() {
        return dao.viewProduct();
    }

    public ProductDto viewProduct(int pId) {
        return dao.viewProduct(pId);
    }

    public boolean checkProduct(int pId) {
        return dao.checkProduct(pId);
    }

    public int checkProduct(int pId, String pPw) {
        return dao.checkProduct(pId, pPw);
    }

    public void updateProduct(int pId) {
        dao.updateProduct(pId);
    }

    public void updateProduct(int pId, String pName, String pDesc, int pPrice) {
        ProductDto dto = new ProductDto(pId, pName, pDesc, pPrice);
        dao.updateProduct(dto);
    }

    public void deleteProduct(int pId) {
        dao.deleteProduct(pId);
    }

    public ArrayList<ProductDto> viewRanking() {
        return dao.viewRanking();
    }

    public ArrayList<ProductDto> searchProduct(String search) {
        return dao.searchProduct(search);
    }
}
