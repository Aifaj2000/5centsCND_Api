package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.configuration.JwtRequestFilter;
import com.ecommerce.dao.CartDao;
import com.ecommerce.dao.UserProductDao;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserProduct;

@Service
public class UserProductService {

    @Autowired
    private UserProductDao userproductDao;

    @Autowired
    private CartDao cartDao;

    public UserProduct addNewProduct(UserProduct userproduct) {
        return userproductDao.save(userproduct);
    }
    
    public List<UserProduct> getAllUserProducts()
    {
    	return (List<UserProduct>) userproductDao.findAll();
    }
    
    public void deleteProductDetails(Integer userproductId) {
    	userproductDao.deleteById(userproductId);
    }
    
    public UserProduct getProductDetailsById(Integer userproductId) {
        return userproductDao.findById(userproductId).get();
    }

//    public List<Product> getAllProducts(int pageNumber, String searchKey) {
//        Pageable pageable = PageRequest.of(pageNumber,12);
//
//        if(searchKey.equals("")) {
//            return (List<Product>) userproductDao.findAll(pageable);
//        } else {
//            return (List<Product>) userproductDao.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
//                    searchKey, searchKey, pageable
//            );
//        }
//
//    }

//    public UserProduct getProductDetailsById(Integer userproductId) {
//        return userproductDao.findById(userproductId).get();
//    }

   

//    public List<UserProduct> getProductDetails(boolean isSingleProductCheckout, Integer userproductId) {
//        if(isSingleProductCheckout && userproductId != 0) {
//            // we are going to buy a single product
//
//            List<UserProduct> list = new ArrayList<>();
//            UserProduct userproduct = userproductDao.findById(userproductId).get();
//            list.add(userproduct);
//            return list;
//        } else {
//            // we are going to checkout entire cart
//            String username = JwtRequestFilter.CURRENT_USER;
//            UserProduct userproduct = userproductDao.findById(username).get();
//            List<Cart> carts = cartDao.findByUser(user);
//
//            return carts.stream().map(x -> x.getProduct()).collect(Collectors.toList());
//        }
//    }
}
