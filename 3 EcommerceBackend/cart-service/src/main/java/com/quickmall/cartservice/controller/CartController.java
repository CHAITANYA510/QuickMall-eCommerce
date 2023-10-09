package com.quickmall.cartservice.controller;

import com.quickmall.cartservice.constant.JWTConstant;
import com.quickmall.cartservice.constant.RedisConstant;
import com.quickmall.cartservice.entity.CartItem;
import com.quickmall.cartservice.service.CartService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import javax.xml.bind.DatatypeConverter;
import java.util.List;

@RestController
@RequestMapping("/api/cart/v1/carts")
@Log4j2
@Api(tags = "CartInfo")

public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * get cartItemList
     * @return
     */
    @GetMapping
    @ApiOperation("get cartItemList")
    public ResponseEntity<List<CartItem>> getItemsByCartId(@RequestHeader(value = "Authorization") String authHeader) {

        // get token:
        String token = authHeader.replace("Bearer ", "");
        log.info("Token: " + token);
        // decode JWT
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(JWTConstant.JWT_SECRET_KEY))
                .parseClaimsJws(token)
                .getBody();
        log.info("claims: " + claims);
        String cartId = claims.get("sub", String.class);

        String cartKey = RedisConstant.CART_PREFIX + cartId;
        List<CartItem> cartItemResponse = cartService.getItemsByCartId(cartKey);
        log.info("successfully get cart info!");

        return new ResponseEntity<>(cartItemResponse, HttpStatus.OK);
    }

}
