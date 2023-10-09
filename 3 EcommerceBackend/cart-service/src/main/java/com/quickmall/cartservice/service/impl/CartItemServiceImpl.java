package com.quickmall.cartservice.service.impl;

import com.alibaba.fastjson.JSON;

import com.quickmall.cartservice.entity.CartItem;
import com.quickmall.cartservice.external.ProductFeignService;
import com.quickmall.cartservice.model.CartItemResponse;
import com.quickmall.cartservice.service.CartItemService;
import com.quickmall.cartservice.service.CartService;
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

    /**
     * save new item in a Cart
     * @param cartItemResponse
     * @param cartKey
     */
    @Override
    public void saveCartItem(CartItemResponse cartItemResponse, String cartKey) {
        // get skuId
        var skuId = cartItemResponse.getSkuId();

        // get the update amount
        Integer updateAmount = cartItemResponse.getCount();

        // check if cart is empty
        List<CartItem> cartItemList = getItemsByCartId(cartKey);

        if (cartItemList != null) {
            // check if the item exist in cartList
            Integer previousCartItemcount = cartItemList.stream()
                    .filter(item -> item.getSkuId().equals(skuId))
                    .map(CartItem::getCount)
                    .findFirst()
                    .orElse(0);  // if not, set previousCartItemcount == 0

            updateAmount += previousCartItemcount;
        }

        // get product info by skuId using ProductFeignService
        var skuResponse = productFeignService.getSkuById(skuId).getBody();
        var attributes = "{color: pink; size: X}";
        var isChecked = false;
        var stock = skuResponse.getSkuStock();
        BigDecimal price = skuResponse.getPrice();
        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(updateAmount));

        CartItem cartItem = CartItem.builder()
                .skuId(skuId)
                .count(updateAmount)
                .price(price)
                .attributes(attributes)
                .isChecked(isChecked)
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

    /**
     * list the selected items in the cart
     * @param cartKey
     * @return
     */
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

    /**
     * delete items by skuId in a Cart
     * @param skuId
     * @param cartKey
     */
    @Override
    public void deleteCartItem(Long skuId, String cartKey) {
        strRedisTemp.boundHashOps(cartKey).delete(skuId.toString());
        log.info("Successfully Delete!");
    }

    /**
     * save the updates of cartItem
     * ATTENTION: isChecked in the HTML is "checked" in json
     * exp:
     * {
     *     "skuId": 1,
     *     "checked": true,
     *     "count": 99
     * }
     * @param cartItemResponse
     * @param cartKey
     */
    @Override
    public void updateCartItem(CartItemResponse cartItemResponse, String cartKey) {

        // get skuId by cartKey
        String skuId = cartItemResponse.getSkuId().toString();

        // get CartItem by skuId
        String json = (String) strRedisTemp.boundHashOps(cartKey).get(skuId);
        CartItem cartItem = JSON.parseObject(json, CartItem.class);

        // update isChecked status & count nums of sku
        cartItem.setChecked(cartItemResponse.isChecked());
        cartItem.setCount(cartItemResponse.getCount());

        // save updated cartItem
        strRedisTemp.boundHashOps(cartKey).put(
                cartItem.getSkuId().toString(),
                JSON.toJSONString(cartItem)
        );

        log.info("successfully updated cartItem:" + cartItem);
    }
}
