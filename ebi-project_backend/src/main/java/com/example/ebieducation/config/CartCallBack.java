package com.example.ebieducation.config;

import com.example.ebieducation.domain.Cart;
import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.mapping.event.BeforeConvertCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CartCallBack implements BeforeConvertCallback<Cart> {

    private static AtomicInteger cartSeq = new AtomicInteger();

    @Override
    public Publisher<Cart> onBeforeConvert(Cart cart, SqlIdentifier table) {
        //
        if(cart.getCartSn() == null){
            return Mono.just(setCartSnAndGet(cart));
        }
            return Mono.just(cart);
        }


    public Cart setCartSnAndGet(Cart cart) {
        //
        cart.setCartSn(getToday()+getCartSeq());
        return cart;

    }

    private String getToday(){
        //
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm/"));
    }

    private static String getCartSeq(){
        //
        int generatedSeq = cartSeq.incrementAndGet();
        return String.format("%01d", generatedSeq);
    }
}

