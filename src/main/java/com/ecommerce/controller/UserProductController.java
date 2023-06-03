package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserProduct;
import com.ecommerce.service.UserProductService;

@RestController
@RequestMapping(value="/userproduct")
public class UserProductController {

    @Autowired
    private UserProductService userproductService;
    
    
    @PostMapping({"/addNewProduct"})
    public UserProduct addNewProduct(@RequestBody UserProduct userproduct)
    {
    	return userproductService.addNewProduct(userproduct); 
   }
    
    @GetMapping({"/getAllProducts"})
    public List<UserProduct> getAllUserProducts()
    {
    	return userproductService.getAllUserProducts();
    }
    
 // @PreAuthorize("hasRole('SuperAdmin')")
    @DeleteMapping({"/deleteUserProductDetails/{userproductId}"})
    public void deleteProductDetails(@PathVariable("userproductId") Integer userproductId) {
        userproductService.deleteProductDetails(userproductId);
    }
    
    @GetMapping({"/getProductDetailsById/{productId}"})
    public UserProduct getProductDetailsById(@PathVariable("productId") Integer userproductId) {
        return userproductService.getProductDetailsById(userproductId);
    }
   
    

//    @PreAuthorize("hasRole('User')")
//    @PostMapping(value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public UserProduct addNewProduct(@RequestPart("userproduct") UserProduct userproduct,
//                                 @RequestPart("imageFile") MultipartFile[] file) {
//        try {
//            Set<ImageModel> images = uploadImage(file);
//            userproduct.setProductImages(images);
//            return userproductService.addNewProduct(userproduct);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//    }
//
//    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
//        Set<ImageModel> imageModels = new HashSet<>();
//
//        for (MultipartFile file: multipartFiles) {
//            ImageModel imageModel = new ImageModel(
//                    file.getOriginalFilename(),
//                    file.getContentType(),
//                    file.getBytes()
//            );
//            imageModels.add(imageModel);
//        }
//
//        return imageModels;
//    }
//
//    @GetMapping({"/getAllProducts"})
//    @PreAuthorize("hasRole('User')")
//    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber,
//                                        @RequestParam(defaultValue = "") String searchKey) {
//        List<Product> result = userproductService.getAllProducts(pageNumber, searchKey);
//        System.out.println("Result size is "+ result.size());
//        return result;
//    }
//
//    @GetMapping({"/getProductDetailsById/{productId}"})
//    public UserProduct getProductDetailsById(@PathVariable("productId") Integer productId) {
//        return userproductService.getProductDetailsById(productId);
//    }
//
//    @PreAuthorize("hasRole('SuperAdmin')")
//    @DeleteMapping({"/deleteProductDetails/{productId}"})
//    public void deleteProductDetails(@PathVariable("productId") Integer productId) {
//        userproductService.deleteProductDetails(productId);
//    }

//    @PreAuthorize("hasRole('User')")
//    @GetMapping({"/getProductDetails/{isSingleProductCheckout}/{productId}"})
//    public List<UserProduct> getProductDetails(@PathVariable(name = "isSingleProductCheckout" ) boolean isSingleProductCheckout,
//                                           @PathVariable(name = "userproductId")  Integer userproductId) {
//        return userproductService.getProductDetails(isSingleProductCheckout, userproductId);
//    }
}
