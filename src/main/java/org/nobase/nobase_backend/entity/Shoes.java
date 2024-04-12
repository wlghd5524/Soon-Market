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
    private Long sh_id;

    private String mb_id;
    private String sh_title;
    private String sh_size;
    private double sh_price;

    @Column(columnDefinition = "TEXT")
    private String sh_des;

    @Column(nullable = false,updatable = false)
    private LocalDateTime sh_upload_time;

    @Column(columnDefinition = "TEXT")
    private String sh_img_path;
    private boolean sh_selling;
    private String mb_nickname;
}
