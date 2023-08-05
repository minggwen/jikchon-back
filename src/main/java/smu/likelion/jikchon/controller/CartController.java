package smu.likelion.jikchon.controller;


import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import smu.likelion.jikchon.base.BaseResponse;
import smu.likelion.jikchon.base.PageResult;
import smu.likelion.jikchon.dto.cart.CartReturnDto;
import smu.likelion.jikchon.service.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    @GetMapping("/members")
    public BaseResponse<PageResult<CartReturnDto>> getMemberCartList(@PageableDefault(size=12) Pageable pageable){
        return BaseResponse.ok(cartService.getMemberCartList(pageable));
    }
    @PostMapping("products/{productId}")
    public BaseResponse<?> addProductToCart(@PathVariable("productId") Long id){
        cartService.addProductToCart(id);
        return BaseResponse.ok(null);
    }
    @DeleteMapping("/{cartId}")
    public BaseResponse<?> deleteProductInCart(@PathVariable("cartId") Long id){
        cartService.deleteProductInCart(id);
        return BaseResponse.ok(null);
    }
}
