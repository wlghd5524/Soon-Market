package org.nobase.nobase_backend.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String userId;
    private String title;
    private String content;
    private double price;
    private String category;
    private String size;
    private String Nickname;
}
