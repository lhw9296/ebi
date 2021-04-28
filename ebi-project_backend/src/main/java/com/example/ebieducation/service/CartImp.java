package com.example.ebieducation.service;


import com.example.ebieducation.domain.Cart;
import com.example.ebieducation.domain.Dto.CartPrdInfoDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartImp {

    // 상품등록
    Mono<Cart>  register(Cart cart);
    // 상품조회
    Flux<CartPrdInfoDto> retrieveByCartList();
    // 상품수정
    Mono<Cart> modifyCart(Cart cart);
    // 상품삭제
    Flux<Cart> remove(String spdNo);
}
