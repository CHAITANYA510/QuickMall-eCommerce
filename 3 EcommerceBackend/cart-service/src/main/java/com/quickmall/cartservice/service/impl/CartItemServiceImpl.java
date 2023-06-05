package com.quickmall.cartservice.service.impl;

import com.alibaba.fastjson.JSON;

import com.quickmall.cartservice.entity.CartItem;
import com.quickmall.cartservice.external.ProductFeignService;
import com.quickmall.cartservice.model.CartItemResponse;
import com.quickmall.cartservice.service.CartItemService;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2

public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private StringRedisTemplate strRedisTemp;

    @Autowired
    private ProductFeignService productFeignService;

    /**
     * list all the items in a Cart
     * @param cartKey
     * @return
     */
    @Override
    public List<CartItem> getItemsByCartId(String cartKey) {
        List<CartItem> cartItemList = strRedisTemp.boundHashOps(cartKey).values()
                .stream()
                .map(String::valueOf)
                .map(json -> JSON.parseObject(json, CartItem.class))
                .collect(Collectors.toList());

        log.info("cartItemList:" + cartItemList);

        return cartItemList;
    }

    @Override
    public void saveCartItem(CartItemResponse cartItemResponse, String cartKey) {
        var skuId = cartItemResponse.getSkuId();
        Integer count = cartItemResponse.getCount();
        var skuResponse = productFeignService.getSkuById(skuId).getBody();
        var attributes = "{color: pink; size: X}";
        var stock = skuResponse.getSkuStock();
        BigDecimal price = skuResponse.getPrice();
        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(count));

        CartItem cartItem = CartItem.builder()
                .skuId(skuId)
                .count(count)
                .price(price)
                .attributes(attributes)
                .isChecked(true)
                .skuStock(stock)
                .totalPrice(totalPrice)
                .build();

        CartItemResponse cartItemResp = new CartItemResponse();
        copyProperties(cartItem, cartItemResp);

        strRedisTemp.boundHashOps(cartKey).put(
                cartItemResp.getSkuId().toString(),
                JSON.toJSONString(cartItemResp)
        );

        log.info("cartKey:" + cartKey + " cartItem: " + cartItem);
    }

    @Override
    public List<CartItem> getSelectedItems(String cartKey) {

        List<CartItem> selectedCartItemList = strRedisTemp.boundHashOps(cartKey)
                .values()
                .stream()
                .map(String::valueOf)
                .map(json -> JSON.parseObject(json, CartItem.class))
                .filter(CartItem::isChecked)
                .collect(Collectors.toList());

        return selectedCartItemList;
    }
}
