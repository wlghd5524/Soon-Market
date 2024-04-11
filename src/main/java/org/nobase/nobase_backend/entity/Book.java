package org.nobase.nobase_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bkId;

    private String mbId;
    private String bkTitle;
    private double bkPrice;

    @Column(columnDefinition = "TEXT")
    private String bkDes;

    @Column(nullable = false,updatable = false)
    private LocalDateTime bkUploadTime;

    @Column(columnDefinition = "TEXT")
    private String bkImgPath;

    private String mbNickname;
}
