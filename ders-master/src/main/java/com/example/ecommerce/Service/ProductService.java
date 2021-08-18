package com.example.ecommerce.Service;

import com.example.ecommerce.Core.Image.ImageService;
import com.example.ecommerce.Dto.Converter.ProductDtoConverter;
import com.example.ecommerce.Dto.ProductDto;
import com.example.ecommerce.Exception.CustomException.ProductCustomException;
import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;
    private final ImageService imageService;
    private final  static  String PRODUCT_NOT_FOUND = "product not found";
    private final static  String PRODUCT_INVALID = "product ınvalid";

    public ProductService(ProductRepository productRepository, ProductDtoConverter productDtoConverter, ImageService imageService) {
        this.productRepository = productRepository;
        this.productDtoConverter = productDtoConverter;
        this.imageService = imageService;
    }

    public ProductDto addProductData(Product product) {






        if ((product.getProductPrice().intValue() <= 0 || product.getProductPrice().intValue() >= 999 || product.getProductName().isEmpty())) {
            throw new ProductCustomException(String.format(PRODUCT_INVALID));

        }
       else if(productRepository.getProductByCode(product.getCode()).stream().count() != 0){
            throw new ProductCustomException("product code already use");
        }
       else if(!product.getCode().matches("[a-zA-Z0-9]*")){
            throw new ProductCustomException("code format invalid");

        }
        return this.productDtoConverter.convertToProduct(productRepository.save(product));

    }
    public List<ProductDto> getProductData(){

        return this.productRepository.findAll()
                .stream()
                .map(productDtoConverter::convertToProduct) //lambda function
        .collect(Collectors.toList());


    }


    // DELETE METHODU API YE AÇILMAZ
    public   void deleteProduct(int id){
        if (productRepository.existsById(id)){
            this.productRepository.deleteById(id);
        }else{
            throw new ProductCustomException(String.format(PRODUCT_NOT_FOUND,id));

        }

    }

    public Product searchProductData(String keyword){
        return  this.productRepository.getProductByProductName(keyword)
                .orElseThrow(
                        ()-> new ProductCustomException(String.format(PRODUCT_NOT_FOUND))
                );
    }

    public Product searchProductId(int id){
        return this.productRepository.findById(id)
                .orElseThrow(
                        ()-> new ProductCustomException(String.format(PRODUCT_NOT_FOUND, id))
                );
    }

    public String uploadImage(MultipartFile multipartFile , int productId){
        Product product = productRepository.getById(productId);
         String url = imageService.upload(multipartFile);
        product.setProductImage(url);
        productRepository.save(product);
        return "işlem başarılı" + url;
                //INSTANCE
    }








}
