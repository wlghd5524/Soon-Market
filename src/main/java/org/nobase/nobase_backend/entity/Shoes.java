package org.nobase.nobase_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shId;

    private String mbId;
    private String shTitle;
    private String shSize;
    private double shPrice;

    @Column(columnDefinition = "TEXT")
    private String shDes;

    @Column(nullable = false,updatable = false)
    private LocalDateTime shUploadTime;

    @Column(columnDefinition = "TEXT")
    private String shImgPath;
    private boolean shSelling;
    private String mbUsername;
}
