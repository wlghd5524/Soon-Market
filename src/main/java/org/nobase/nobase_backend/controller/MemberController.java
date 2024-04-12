package org.nobase.nobase_backend.controller;

import org.nobase.nobase_backend.entity.Member;
import org.nobase.nobase_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(
            @ModelAttribute MemberDTO memberDTO
    ) throws IOException {
        try {
            String mb_id = memberDTO.getMb_id();
            String mb_email = memberDTO.getMb_email();
            String mb_name = memberDTO.getMb_name();
            String mb_address = memberDTO.getMb_address();
            String mb_tel = memberDTO.getMb_tel();
            String mb_passwd = memberDTO.getMb_passwd();
            String mb_nickname = memberDTO.getMb_nickname();
            Member member = memberService.createMember(mb_id, mb_address, mb_email, mb_name, mb_passwd, mb_tel, mb_nickname);
            return new ResponseEntity<>(member, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
