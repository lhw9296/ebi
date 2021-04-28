package com.example.ebieducation.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("om_cart")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart  {
    //

    private static final long seriaVersionUID = -5793348114310316331L;

    @Id
    @Column("cart_sn")
    private String cartSn; // 단품번호
    @Column("tr_no")
    private String trNo; // 거래처번호 (장바구니 배송그룹 기준)
    @Column("lrtr_no")
    private String lrtrNo; // 하위거래처번호
    @Column("mb_no")
    private String mbNo; // 회원번호
    @Column("spd_no")
    private String spdNo; // 상품번호
    @Column("sitm_no")
    private String sitmNo; // 단품번호
    @Column("od_qty")
    private int odQty; // 주문수량


    @Column("reg_dttm")
    @CreatedDate
    private LocalDateTime regDttm;

    @Column("mod_dttm")
    @LastModifiedDate
    private LocalDateTime modDttm;

    // Cart register Dto
    public Cart(String trNo, String spdNo, String sitmNo, String lrtrNo) {
    }

    public Cart(String cartSn, String trNo, String lrtrNo, String mbNo, String spdNo, String sitmNo, int odQty, LocalDateTime regDttm) {
    }
    // Cart 목록조회






}

