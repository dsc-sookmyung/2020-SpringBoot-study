package hello.hellospring;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;

    }
   /* private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }*/

    /*private DataSource dataSource;

    @Autowired
    public SpringConfig( DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
    /*@Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSoure);
        //return new JpaMemberRepository(em);

    }*/
    /*@Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/
}

//memberService()랑 memberRepository()를 스프링빈에 등록
//스프링빈에 등록된 memberRepository()를 MemberService()에 넣어줌
