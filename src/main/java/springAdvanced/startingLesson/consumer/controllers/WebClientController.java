package springAdvanced.startingLesson.consumer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.startingLesson.consumer.dtos.ProductCriteria;
import springAdvanced.startingLesson.consumer.dtos.ProductDTO;
import springAdvanced.startingLesson.consumer.service.WebClientProductService;

import java.util.List;

@RestController
@RequestMapping("/webclient")
public class WebClientController {
    private final WebClientProductService webClientProductService;

    public WebClientController(WebClientProductService webClientProductService) {
        this.webClientProductService = webClientProductService;
    }


    @GetMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(ProductDTO productDTO) {
        return ResponseEntity.ok(webClientProductService.createConsumer(productDTO));
    }

    @GetMapping("/update")
    public ResponseEntity<Void> updateProduct(ProductDTO productDTO) {
        return ResponseEntity.ok(webClientProductService.updateConsumer(productDTO));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        webClientProductService.deleteConsumer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(webClientProductService.getConsumer(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getProduct(@RequestBody ProductCriteria productCriteria) {
        return ResponseEntity.ok(webClientProductService.listProducts(productCriteria));
    }


}
