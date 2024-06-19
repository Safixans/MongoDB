package springAdvanced.startingLesson.consumer.service;

import springAdvanced.startingLesson.consumer.dtos.*;

import java.util.List;

public interface ConsumerService {
    ProductDTO createConsumer(ProductDTO productDTO);

    Void updateConsumer(ProductDTO productDTO);

    void deleteConsumer(Integer id);

    ProductDTO getConsumer(Integer id);

    List<ProductDTO> listProducts(ProductCriteria criteria);

}
