package org.nobase.nobase_backend.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {
    @Id
    private String mb_id;
    private String mb_email;
    private String mb_name;
    private String mb_img_path;
    private String mb_address;
    private String mb_sendId;
    private String mb_receive_id;
    private String mb_tel;
    private String mb_passwd;
    private String mb_nickname;
    private String cookie;


}
