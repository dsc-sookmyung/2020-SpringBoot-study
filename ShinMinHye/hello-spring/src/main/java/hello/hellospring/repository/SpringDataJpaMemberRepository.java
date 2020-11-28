package hello.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.Member;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    //select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
