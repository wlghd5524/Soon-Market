package org.nobase.nobase_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clId;

    private String mbId;
    private String clTitle;
    private double clPrice;
    private String clSize;

    @Column(columnDefinition = "TEXT")
    private String clDes;

    @Column(nullable = false,updatable = false)
    private LocalDateTime clUploadTime;

    @Column(columnDefinition = "TEXT")
    private String clImgPath;

    private boolean selling;
    private String mbNickname;
}
