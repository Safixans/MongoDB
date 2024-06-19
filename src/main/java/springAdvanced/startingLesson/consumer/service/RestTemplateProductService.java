package springAdvanced.startingLesson.consumer.service;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springAdvanced.startingLesson.consumer.dtos.ProductCriteria;
import springAdvanced.startingLesson.consumer.dtos.ProductDTO;
import springAdvanced.startingLesson.consumer.resources.ProductResource;

import java.util.Arrays;
import java.util.List;

@Service
public class RestTemplateProductService implements ConsumerService {
    private final ProductResource productResource;
    private final RestTemplate restTemplate;

    public RestTemplateProductService(ProductResource productResource, RestTemplate restTemplate) {
        this.productResource = productResource;
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductDTO createConsumer(ProductDTO productDTO) {
        return restTemplate
                .postForObject(productResource.getCreateProductURL(), productDTO, ProductDTO.class);

    }

    @Override
    public Void updateConsumer(ProductDTO productDTO) {
        return null;
    }

    /* @Override
     public Void updateConsumer(ProductDTO productDTO) {
         restTemplate.put(productResource.getUpdateProductURL(), productDTO);
     }
 */
    @Override
    public void deleteConsumer(@NonNull Integer id) {
        restTemplate.delete(productResource.getGetProductURL() + id);
    }

    @Override
    public ProductDTO getConsumer(Integer id) {
        return restTemplate
                .getForObject(productResource.getGetProductURL() + id, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> listProducts(ProductCriteria criteria) {
        ResponseEntity<ProductDTO[]> response =
                restTemplate
                        .getForEntity(productResource.getListProductsURL(), ProductDTO[].class);
        ProductDTO[] products = response.getBody();

        // Convert array to List and return
        return Arrays.asList(products);
    }
}
