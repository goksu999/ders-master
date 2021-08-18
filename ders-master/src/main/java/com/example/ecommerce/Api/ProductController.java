package com.example.ecommerce.Api;


import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/product/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("addproduct")
    public ResponseEntity<?> addProductData(@RequestBody Product product){
        return ResponseEntity.ok(
                this.productService.addProductData(product)
        );

    }

    @GetMapping("getproductData")
    public ResponseEntity<?> getProductData(){
        return ResponseEntity.ok(
                this.productService.getProductData()
        );
    }

    @GetMapping("{keyword}")
    public ResponseEntity<?> searchProductData(@PathVariable String keyword) {
        return ResponseEntity.ok(
                this.productService.searchProductData(keyword)
        );
    }

    @PostMapping("uploadImage")
    public ResponseEntity<?> uploadImage(MultipartFile multipartFile , int productId){
        return ResponseEntity.ok(this.productService.uploadImage(multipartFile, productId));
    }

    @GetMapping("serachproductId")
    public ResponseEntity<?> searchProductId(int id){
        return ResponseEntity.ok(this.productService.searchProductId(id));
    }

    @DeleteMapping("deleteproduct")
    public   void deleteProduct(int id){
       this.productService.deleteProduct(id);
    }


}
