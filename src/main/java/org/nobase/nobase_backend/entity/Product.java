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

    private String mb_id;
    private String pd_title;
    private String pd_des;
    private double pd_price;
    private String sh_size;
    private String categories;

    @Column(nullable = false, updatable = false)
    private LocalDateTime pd_upload_time;

    @Column(columnDefinition = "TEXT")
    private String pd_img_path;

    private boolean pd_selling;
    private String mb_nickname;
}
