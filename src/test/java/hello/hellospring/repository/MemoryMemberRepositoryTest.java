package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //Test는 임의의 순서로 시행됨 그래서 test 끝나면 데이터 비워줘야함
    //메서드 끝날때마다 실행하는 콜백 메서드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //get으로 꺼냄.. 헷갈린다
        //System.out.println("result = " + (result == member));
        //같으면 true라고 뜬다. 글자로 계속 볼 수 없기땜에 assert
        //Assertions.assertEquals(member, result);
        //일치한다면 아무것도 출력되지 않지만, tests passed라고 밑에 뜬다.
        //Assetions도 종류가 여러개 있다. 아래 assert j 유닛이 아니라면 asserThat()을 못사용함
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findbyName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result= repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);


    }



}

