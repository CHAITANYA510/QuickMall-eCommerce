package com.quickmall.orderservice.service.impl;

import com.quickmall.orderservice.entity.OmsOrderItem;
import com.quickmall.orderservice.model.OmsOrderItemRequest;
import com.quickmall.orderservice.model.OmsOrderItemResponse;
import com.quickmall.orderservice.repository.OrderItemRepository;
import com.quickmall.orderservice.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OmsOrderItemResponse saveOrderItem(OmsOrderItemRequest request) {

        OmsOrderItem orderItem = OmsOrderItem.builder()
                .orderId(request.getOrderId())
                .orderSn(request.getOrderSn())
                .categoryId(request.getCategoryId())
                .spuId(request.getSpuId())
                .spuName(request.getSpuName())
                .spuBrand(request.getSpuBrand())
                .skuId(request.getSkuId())
                .skuPrice(request.getSkuPrice())
                .skuQuantity(request.getSkuQuantity())
                .attributeValueList("[{\"key\":\"color\",\"value\":\"pink\"},{\"key\":\"size\",\"value\":\"XS\"}]")
                .build();

        orderItemRepository.save(orderItem);

        OmsOrderItemResponse response = new OmsOrderItemResponse();
        copyProperties(orderItem, response);

        return response;
    }

    @Override
    public List<OmsOrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OmsOrderItemResponse getOrderItemById(Long orderItemId) {

        OmsOrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException());

        OmsOrderItemResponse response = new OmsOrderItemResponse();
        copyProperties(orderItem, response);

        return response;
    }
}
