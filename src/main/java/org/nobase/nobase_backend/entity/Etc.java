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
    private Long etId;

    private String mbId;
    private String etTitle;
    private double etPrice;

    @Column(columnDefinition = "TEXT")
    private String etDes;

    @Column(nullable = false,updatable = false)
    private LocalDateTime etUploadTime;

    @Column(columnDefinition = "TEXT")
    private String etImgPath;
    private String mbUsername;
}
