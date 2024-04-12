package org.nobase.nobase_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gf_id;

    private String mb_id;
    private String gf_title;
    private double gf_price;

    @Column(columnDefinition = "TEXT")
    private String gf_des;

    @Column(nullable = false,updatable = false)
    private LocalDateTime gf_upload_time;

    @Column(columnDefinition = "TEXT")
    private String gf_img_path;
    private boolean gf_selling;
    private String mb_nickname;
}
