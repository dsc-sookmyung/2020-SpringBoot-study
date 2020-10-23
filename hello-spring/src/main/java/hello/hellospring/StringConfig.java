package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    //나중에 DB가 결정되면 DBMemberRepository로 바꾸면 됨
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
