package com.flexibledev.example.htmltopdf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by seonhyeonmin on 2020/05/07 4:22 오후
 */
@Getter
@Setter
@AllArgsConstructor
public class Contract {

    private String contractNumber;

    private Signer lessor;
    private Signer lessee;
    private Agent agent;

}
