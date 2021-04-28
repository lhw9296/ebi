package com.example.ebieducation.repositories;

import com.example.ebieducation.domain.Cart;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CartRepository extends ReactiveCrudRepository<Cart, Integer> {
    
    // * @Query 사용 시 DB 컬럼 명과 동일하게 해야함
    
    @Query("SELECT * FROM om_cart ORDER BY REG_DTTM DESC")
    public Flux<Cart> retrieveByCartList();

    @Query("DELETE FROM om_cart where spd_No = :spd_No")
    public Flux<Cart> removeCart(String spdNo);

}
