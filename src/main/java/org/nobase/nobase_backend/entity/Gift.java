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
    private Long gfId;

    private String mbId;
    private String gfTitle;
    private double gfPrice;

    @Column(columnDefinition = "TEXT")
    private String gfDes;

    @Column(nullable = false,updatable = false)
    private LocalDateTime gfUploadTime;

    @Column(columnDefinition = "TEXT")
    private String gfImgPath;
    private boolean gfSelling;
    private String mbNickname;
}
