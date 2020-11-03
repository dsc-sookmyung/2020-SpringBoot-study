package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import javax.persistence.EntityManager;
//import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /*
    private final DataSource dataSource;
    private final EntityManager em;

    @Autowired 생성자 하나라 생략해도 됨
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
     */

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        //return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

    /* 컴포넌트스캔쓰지않고 스프링빈에 직접 등록
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
     */

    /*
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
     */

}
