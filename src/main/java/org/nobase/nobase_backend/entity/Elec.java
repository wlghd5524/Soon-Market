package org.nobase.nobase_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
public class Elec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elId;

    private String mbId;
    private String elTitle;
    private double elPrice;

    @Column(columnDefinition = "TEXT")
    private String elDes;

    @Column(nullable = false,updatable = false)
    private LocalDateTime elUploadTime;

    @Column(columnDefinition = "TEXT")
    private String elImgPath;
    private boolean elSelling;
    private String mbNickname;
}
