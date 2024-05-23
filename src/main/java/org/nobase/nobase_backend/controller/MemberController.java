package org.nobase.nobase_backend.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nobase.nobase_backend.entity.Member;
import org.nobase.nobase_backend.security.JWT.test.JwtToken;
import org.nobase.nobase_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private MemberService memberService;

    @PostMapping("/register")
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

    @PostMapping("/sign-in")
    public JwtToken signIn(@RequestBody SignInDto signInDto) {
        String mb_id = signInDto.getMb_id();
        String mb_passwd = signInDto.getMb_passwd();
        JwtToken jwtToken = memberService.signIn(mb_id, mb_passwd);
        log.info("request username = {}, password = {}", mb_id, mb_passwd);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return jwtToken;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
