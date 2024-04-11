package org.nobase.nobase_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mbId;
    private String pdTitle;
    private String pdDes;
    private double pdPrice;
    private String pdSize;
    private String categories;

    @Column(nullable = false, updatable = false)
    private LocalDateTime pdUploadTime;

    @Column(columnDefinition = "TEXT")
    private String pdImgPath;

    private boolean pdSelling;
    private String mbNickname;
}
