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
    private Long el_id;

    private String mb_id;
    private String el_title;
    private double el_price;

    @Column(columnDefinition = "TEXT")
    private String el_des;

    @Column(nullable = false,updatable = false)
    private LocalDateTime el_upload_time;

    @Column(columnDefinition = "TEXT")
    private String el_img_path;
    private boolean el_selling;
    private String mb_nickname;
}
