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
    private Long bk_id;

    private String mb_id;
    private String bk_title;
    private double bk_price;

    @Column(columnDefinition = "TEXT")
    private String bk_des;

    @Column(nullable = false,updatable = false)
    private LocalDateTime bk_upload_time;

    @Column(columnDefinition = "TEXT")
    private String bk_img_path;

    private String mb_nickname;
}
