package com.example.ebieducation.domain.Dto;

import com.example.ebieducation.domain.Cart;
import lombok.Data;


@Data
public class CartDto {
    //
    private String trNo; // 거래처번호 (장바구니 배송그룹 기준
    private String spdNo; // 상품번호
    private String sitmNo; // 단품번호
    private String lrtrNo; // 하위거래처번호
    private String brdNm; //브랜드명
    private int slPrc; // 상품가격
    private String imgFullUrl; // 이미지경로
    private String estmtDlvTxt; // 배송문구



    // 등록에 필요한  DTO
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
