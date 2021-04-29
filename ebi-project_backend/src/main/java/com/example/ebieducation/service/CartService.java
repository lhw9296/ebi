package com.example.ebieducation.service;


import com.example.ebieducation.domain.Cart;
import com.example.ebieducation.domain.Dto.CartPrdInfoDto;
import com.example.ebieducation.repositories.CartRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Data
@RequiredArgsConstructor
public class CartService implements CartImp {

    // DB 관련
    private final CartRepository cartRepository;

    // API URL
    private String Url = "https://pbf.lotteon.com/product/v1/detail/productDetailList?dataType=LIGHT2";

    // WebClient 빌드
    private final WebClient webClient = WebClient.builder().build();
    // Query 문 사용
    private ObjectMapper mapper = new ObjectMapper();
    // 임의 데이터 입력
    private String mbNo = "11";
    private int odQty = 1;

    // 장바구니 등록
    @Override // 수량 나머지는 상품정보 호출 후 하는 방식으로
    public Mono<Cart> register(Cart cart) {
        //
        cart.setMbNo(mbNo);
        cart.setOdQty(odQty);

        return cartRepository.save(cart);
    }

    // 장바구니 조회
    @Override
    public Flux<CartPrdInfoDto> retrieveByCartList() {
        //
        Flux<Cart> cart = cartRepository.retrieveByCartList();

//       return    webClient.mutate()
//                .build()
//                .post()
//                .uri(Url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromPublisher(cart, Cart.class))
//                .retrieve()
//                .bodyToMono(JsonNode.class)
//                .map(r -> r.path("data"))
//                .flatMapMany(Flux::fromIterable)
//                .map(r -> mapper.convertValue(r, CartPrdInfoDto.class));


        Flux<CartPrdInfoDto> cartPrdInfo = webClient.mutate()
                .build()
                .post()
                .uri(Url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(cart, Cart.class))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(r -> r.path("data"))
                .flatMapMany(Flux::fromIterable)
                .map(r -> mapper.convertValue(r, CartPrdInfoDto.class));

        // cartSn, odQty, mbNo 추가
        // concatMap 리펙토링 필요 부분
        return cartPrdInfo.zipWith(cart, (cartPrd, cartProduct) -> {
            cartPrd.setCartSn(cartProduct.getCartSn());
            cartPrd.setOdQty(cartProduct.getOdQty());
            cartPrd.setMbNo(cartProduct.getMbNo());
            cartPrd.setRegDttm(cartProduct.getRegDttm());

            return cartPrd;
        }).log();
    }
    // 장바구니 수정

    @Override
    public Mono<Cart> modifyCart(Cart cart) {
        //
        return cartRepository.save(cart);
    }

    //  장바구니 삭제
    @Override
    public Flux<Cart> remove(String spdNo) {
        //
        // WebFlux 관련함수 사용 시 subscribe(구독) 작업 필요
        cartRepository.removeCart(spdNo).subscribe();
        Flux<Cart> removeInfo = cartRepository.retrieveByCartList();
        System.out.println("Service" + spdNo);
        System.out.println("Service" + removeInfo);

        return removeInfo;
    }
}
