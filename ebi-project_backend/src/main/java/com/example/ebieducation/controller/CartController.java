package com.example.ebieducation.controller;

import com.example.ebieducation.domain.Cart;
import com.example.ebieducation.domain.Dto.CartDto;
import com.example.ebieducation.domain.Dto.CartPrdInfoDto;
import com.example.ebieducation.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
    @RequestMapping("/cart")
    public class CartController {

        private final CartService cartService;

        //front 카트 등록 작업 관련
        @PostMapping("/register")
        public Mono<Cart> register(@RequestBody CartDto cart){
            //
            Cart result = cart.toCart();
            return cartService.register(result);
        }

        @PostMapping("/retrieveByCartList")
        public Flux<CartPrdInfoDto> retrieveByCartList(){
            //
            return cartService.retrieveByCartList();
        }

        @PutMapping("/modifyCart")
        public Mono<Cart> modifyOdQty(@RequestBody Cart cart){
            //
            return cartService.modifyCart(cart);
        }

        @GetMapping("/removeCart")
        public Flux<Cart> removeCart(@RequestParam String spdNo){
                //
            return cartService.remove(spdNo);
        }




























//    // 장바구니 정보 조회 test
//    @PostMapping("/test")
//    public Mono<String> test(){
//
//        // cart instance 생성
//        Cart cart = new Cart();
//
//        // 해당 값 주입
//        cart.setSpdNo("LE1206952921");
//        cart.setSitmNo("LE1206952921_1238021703");
//
//        return webClient.mutate().build().post().uri(Url).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).body(Flux.just(cart), Cart.class).retrieve().bodyToMono(String.class);
//    }
}


