package org.nobase.nobase_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
public class Etc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long et_id;

    private String mb_id;
    private String et_title;
    private double et_price;

    @Column(columnDefinition = "TEXT")
    private String et_des;

    @Column(nullable = false,updatable = false)
    private LocalDateTime et_upload_time;

    @Column(columnDefinition = "TEXT")
    private String et_img_path;
    private String mb_nickname;
}
