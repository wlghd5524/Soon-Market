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
    private Long cl_id;

    private String mb_id;
    private String cl_title;
    private double cl_price;
    private String cl_size;

    @Column(columnDefinition = "TEXT")
    private String cl_des;

    @Column(nullable = false,updatable = false)
    private LocalDateTime cl_upload_time;

    @Column(columnDefinition = "TEXT")
    private String cl_img_path;

    private boolean cl_selling;
    private String mb_nickname;
}
