package springAdvanced.startingLesson.consumer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.startingLesson.consumer.dtos.ProductCriteria;
import springAdvanced.startingLesson.consumer.dtos.ProductDTO;
import springAdvanced.startingLesson.consumer.service.RestTemplateProductService;

import java.util.List;

@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {
    private final RestTemplateProductService restTemplateProductService;

    public RestTemplateController(RestTemplateProductService restTemplateProductService) {
        this.restTemplateProductService = restTemplateProductService;
    }

    @GetMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(ProductDTO productDTO) {
        return ResponseEntity.ok(restTemplateProductService.createConsumer(productDTO));
    }
/*

    @GetMapping("/update")
    public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO) {
        return ResponseEntity.ok(restTemplateProductService.updateConsumer(productDTO));
    }
*/

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        restTemplateProductService.deleteConsumer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(restTemplateProductService.getConsumer(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getProduct(@RequestBody ProductCriteria productCriteria) {
        return ResponseEntity.ok(restTemplateProductService.listProducts(productCriteria));
    }


}
