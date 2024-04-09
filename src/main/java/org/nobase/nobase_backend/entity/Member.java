package org.nobase.nobase_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {
    @Id
    private String mbId;

    private String mbEmail;
    private String mbName;
    private String mbImgPath;
    private String Addr;
    private String mbSendId;
    private String mbReceiveId;
    private String mbTel;
    private String mbPasswd;
    private String mbUsername;
}
