package org.nobase.nobase_backend.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO {
    private String mbId;
    private String mbEmail;
    private String mbName;
    private String mbImgPath;
    private String mbAddress;
    private String mbTel;
    private String mbPasswd;
    private String mbNickname;
}
