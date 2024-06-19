
package springAdvanced.startingLesson.consumer.resources;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import springAdvanced.startingLesson.consumer.dtos.ProductCriteria;
import springAdvanced.startingLesson.consumer.dtos.ProductDTO;

import java.util.List;

@Service
@Getter
public class ProductResource {

    @Value("${products.url.createProduct}")
    private String createProductURL;

    @Value("${products.url.updateProduct}")
    private String updateProductURL;

    @Value("${products.url.deleteProduct}")
    private String deleteProductURL;

    @Value("${products.url.getProduct}")
    private String getProductURL;

    @Value("${products.url.listProducts}")
    private String listProductsURL;

    private final WebClient webClient;

    public ProductResource(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public List<ProductDTO> getAllProducts() {
        return webClient.get()
                .uri(listProductsURL)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductDTO>>() {})
                .block();
    }

    public void saveAllProducts(List<ProductDTO> productCreateDTO) {
        webClient.post()
                .uri(createProductURL)
                .body(BodyInserters.fromValue(productCreateDTO))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public void deleteProduct(Integer productId) {
        webClient.delete()
                .uri(deleteProductURL.replace("{id}", productId.toString()))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public ProductDTO getProductById(@NonNull Integer id) {
        return webClient.get()
                .uri(getProductURL.replace("{id}", id.toString()))
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

    public void updateProduct(ProductDTO productDTO) {
        webClient.put()
                .uri(updateProductURL)
                .body(BodyInserters.fromValue(productDTO))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public List<ProductDTO> listOfProducts(ProductCriteria criteria) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(listProductsURL)
                        .queryParam("page", criteria.getPage())
                        .queryParam("size", criteria.getSize())
                        .build())
                .retrieve()
                .bodyToFlux(ProductDTO.class)
                .collectList()
                .block();
    }
}



/*
package springAdvanced.startingLesson.consumer.resources;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import springAdvanced.startingLesson.consumer.dtos.ProductCreateDTO;
import springAdvanced.startingLesson.consumer.dtos.ProductCriteria;
import springAdvanced.startingLesson.consumer.dtos.ProductDTO;

import java.util.List;

@Service
public class ProductResource {

    @Value("${products.url.createProduct}")
    private String createProductURL;

    @Value("${products.url.updateProduct}")
    private String updateProductURL;

    @Value("${products.url.deleteProduct}")
    private String deleteProductURL;

    @Value("${products.url.getProduct}")
    private String getProductURL;

    @Value("${products.url.listProducts}")
    private String listProductsURL;


    private final WebClient webClient;


    public ProductResource(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<ProductDTO> getAllProducts() {
        return webClient.get()
                .uri(listProductsURL)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductDTO>>() {
                })
                .block();
    }

    public void saveAllProducts(List<ProductCreateDTO> productCreateDTO) {
        webClient.post()
                .uri(createProductURL)
                .body(BodyInserters.fromValue(productCreateDTO))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public void deleteProduct(Integer productId) {
        webClient.delete()
                .uri(deleteProductURL.replace("{id}", productId.toString()))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public ProductDTO getProductById(@NonNull Integer id) {
        return webClient
                .get()
                .uri(getProductURL.replace("{id}", id.toString()))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ProductDTO>() {
                })
                .block();
    }

    public void updateProduct(ProductDTO productDTO) {
        if (productDTO != null) {
            webClient.put()
                    .uri(updateProductURL)
                    .body(BodyInserters.fromValue(productDTO))
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();
        }
    }

    public List<ProductDTO> listOfProducts(ProductCriteria criteria) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(listProductsURL)
                        .queryParam("page", criteria.getPage())
                        .queryParam("size", criteria.getSize())
                        .build())
                .retrieve()
                .bodyToFlux(ProductDTO.class)
                .collectList()
                .block();
    }
    public List<ProductDTO> getProductsByConsumerId(@NonNull Integer consumerId) {
        String url = getProductURL + "?consumerId=" + consumerId;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductDTO>>() {})
                .block();
    }

}
*/
