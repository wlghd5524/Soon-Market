package org.nobase.nobase_backend.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String mb_id;
    private String pd_title;
    private String pd_des;
    private double pd_price;
    private String category;
    private String sh_size;
    private String mb_nickname;
}
