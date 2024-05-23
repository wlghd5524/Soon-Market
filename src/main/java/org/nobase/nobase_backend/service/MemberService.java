package org.nobase.nobase_backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nobase.nobase_backend.security.JWT.test.JwtToken;
import org.nobase.nobase_backend.security.JWT.test.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.nobase.nobase_backend.entity.Member;
import org.nobase.nobase_backend.repository.MemberRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public abstract class MemberService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Value("${memberFile.upload-dir}")
    private String path;
    private Path rootLocation;
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public Member createMember(String mb_id, String mb_address, String mb_email, String mb_name, String mb_passwd, String mb_tel, String mb_nickname) throws IOException {
        Member member = new Member();
        member.setMb_id(mb_id);
        member.setMb_address(mb_address);
        member.setMb_email(mb_email);
        member.setMb_name(mb_name);
        member.setMb_passwd(mb_passwd);
        member.setMb_tel(mb_tel);
        member.setMb_nickname(mb_nickname);
        return memberRepository.save(member);
    }

    public String storeFile(MultipartFile file, String mbId) throws IOException {
        String filename = generateFileName(file, mbId);  //파일 이름 생성(userID_20240401_133340.png)
        Files.createDirectories(rootLocation);
        Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    public String generateFileName(MultipartFile file, String mbId) {
        String filename = file.getOriginalFilename();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        int dotIndex = filename.lastIndexOf('.');  //파일 확장자 파싱
        if (dotIndex < 0) {
            return null;
        }
        String extension = filename.substring(dotIndex);
        filename = mbId + "_" + formattedDateTime + extension;
        return filename;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findById(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 회원을 찾을 수 없습니다."));
    }
    public UserDetails createUserDetails(Member member) {
        return User.builder()
                .username(member.getMb_name())
                .password(bCryptPasswordEncoder.encode(member.getMb_passwd()))
                .build();
    }

    @Transactional
    public JwtToken signIn(String mb_id, String mb_passwd) {
        // 1. username + password 를 기반으로 Authentication 객체 생성
        // 이때 authentication 은 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(mb_id, mb_passwd);

        // 2. 실제 검증. authenticate() 메서드를 통해 요청된 Member 에 대한 검증 진행
        // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성

        return jwtTokenProvider.generateToken(authentication);
    }
}
