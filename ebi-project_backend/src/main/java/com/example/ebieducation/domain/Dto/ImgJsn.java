package com.example.ebieducation.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImgJsn {

    private String epsrTypCd;
    private String epsrTypDtlCd;
    private String origImgFileNm;
    private String imgFileNm;
    private String imgRteNm;
    private String imgCrtYn;
    private String rprtImgYn;
}
