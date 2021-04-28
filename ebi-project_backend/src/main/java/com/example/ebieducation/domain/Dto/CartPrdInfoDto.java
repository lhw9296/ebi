package com.example.ebieducation.domain.Dto;

import com.example.ebieducation.domain.Cart;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // 컬럼에 없는 속성에 대한 내용을 무시한다.
public class CartPrdInfoDto {

    private String cartSn; // 장바구니 순번
    private String trNo; // 거래처번호 (장바구니 배송그룹 기준)
    private String spdNo; // 상품번호
    private String sitmNo; // 단품번호
    private String lrtrNo; // 하위거래처번호
    private String brdNm; //브랜드명
    private int slPrc; // 상품가격
    private ImgJsn[] ImgJsn; // 이미지경로
    private String estmtDlvTxt; // 배송문구
    //

    private int odQty;
    private String spdNm;
    private String mbNo;
    private LocalDateTime regDttm;  // 수정날짜



    public Cart toCart() {
        // new Cart 인스턴스 생성 시 파라미터는  domain.Cart에서 생성자 사용
        Cart result = new Cart(trNo, spdNo, sitmNo, lrtrNo);
        // frontData -> Controller -> Dto
        result.setTrNo(trNo);
        result.setSpdNo(spdNo);
        result.setLrtrNo(lrtrNo);
        result.setSitmNo(sitmNo);

        return result;
    }

}
