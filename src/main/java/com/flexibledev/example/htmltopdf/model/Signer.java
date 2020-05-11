package com.flexibledev.example.htmltopdf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by seonhyeonmin on 2020/05/08 5:47 오후
 */
@Getter
@Setter
@AllArgsConstructor
public class Signer {

    private String name;
    private String phone;
    private String address;
    private String juminNumber;
    private String lessorNumber;
    private String signature;

}
