package org.nobase.nobase_backend.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO {
    private String mb_id;
    private String mb_email;
    private String mb_name;
    private String mb_imgPath;
    private String mb_address;
    private String mb_tel;
    private String mb_passwd;
    private String mb_nickname;
}
