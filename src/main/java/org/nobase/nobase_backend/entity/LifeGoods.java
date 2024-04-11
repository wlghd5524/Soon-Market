package org.nobase.nobase_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
public class LifeGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lgId;

    private String mbId;
    private String lgTitle;
    private double lgPrice;

    @Column(columnDefinition = "TEXT")
    private String lgDes;

    @Column(nullable = false,updatable = false)
    private LocalDateTime lgUploadTime;

    @Column(columnDefinition = "TEXT")
    private String lgImgPath;
    private String mbNickname;
}
