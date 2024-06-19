package springAdvanced.startingLesson.consumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import springAdvanced.startingLesson.consumer.dtos.ProductCriteria;
import springAdvanced.startingLesson.consumer.dtos.ProductDTO;

import java.util.List;

@Service
public class WebClientProductService implements ConsumerService {

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

    public WebClientProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    @Override
    public ProductDTO createConsumer(ProductDTO productDTO) {
        return webClient.post()
                .uri(createProductURL)
                .body(BodyInserters.fromValue(productDTO))
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

    @Override
    public Void updateConsumer(ProductDTO productDTO) {
        return null;
    }

 /*   @Override
    public Void updateConsumer(ProductDTO productDTO) {
        webClient.put()
                .uri(updateProductURL)
                .body(BodyInserters.fromValue(productDTO))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }*/

    @Override
    public void deleteConsumer(Integer id) {
        webClient.delete()
                .uri(deleteProductURL.replace("{id}", id.toString()))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Override
    public ProductDTO getConsumer(Integer id) {
        return webClient.get()
                .uri(getProductURL.replace("{id}", id.toString()))
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

    @Override
    public List<ProductDTO> listProducts(ProductCriteria criteria) {
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
package springAdvanced.startingLesson.consumer.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import springAdvanced.startingLesson.consumer.dtos.ProductCriteria;
import springAdvanced.startingLesson.consumer.dtos.ProductDTO;
import springAdvanced.startingLesson.consumer.resources.ProductResource;

import java.util.List;

@Service
public class WebClientProductService implements ConsumerService {
    private final WebClient webClient;
    private final ProductResource productResource;

    public WebClientProductService(WebClient webClient, ProductResource productResource) {
        this.webClient = webClient;
        this.productResource = productResource;
    }

    @Override
    public ProductDTO createConsumer(ProductDTO consumerDTO) {
        return webClient.post()
                .uri(productResource.getCreateProductURL())
                .body(consumerDTO, ProductDTO.class)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

    @Override
    public ProductDTO updateConsumer(ProductDTO productDTO) {
        return webClient.put()
                .uri(productResource.getUpdateProductURL())
                .body(productDTO, ProductDTO.class)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

    @Override
    public void deleteConsumer(Integer id) {
        webClient
                .delete()
                .uri(productResource.getDeleteProductURL())
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Override
    public ProductDTO getConsumer(Integer id) {
        return webClient
                .get()
                .uri(productResource.getGetProductURL(), id)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

    @Override
    public List<ProductDTO> listProducts(ProductCriteria criteria) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/list")
                        .queryParam("page", criteria.getPage())
                        .queryParam("size", criteria.getSize())
                        .build())
                .retrieve()
                .bodyToFlux(ProductDTO.class)
                .collectList()
                .block();
    }
}
*/
