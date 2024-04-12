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
    private Long lg_id;

    private String mb_id;
    private String lg_title;
    private double lg_price;

    @Column(columnDefinition = "TEXT")
    private String lg_des;

    @Column(nullable = false,updatable = false)
    private LocalDateTime lg_upload_time;

    @Column(columnDefinition = "TEXT")
    private String lg_img_path;
    private String mb_nickname;
}
