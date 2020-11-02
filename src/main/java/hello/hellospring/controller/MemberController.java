package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//컨트롤러 붙어있으면 시작될때 스프링이 관리함
@Controller
public class MemberController {

    /*spring container로부터 받아서 쓰도록 바꿔야함 왜? new하면 다른 컨트롤러들이 가져다 쓸수 있음
    private final MemberService memberService = new MemberService();
    spring container에 딱 하나만 등록해서 쓰면 됨*/
    private final MemberService memberService;

    //생성자 호출하면 스프링이  memberService를 스프링 컨테이너에 가져와서 연결?
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";


    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

//POST 는 폼같은데 넣어서 전달할때
//GET은 데이터 조회할때 유알엘 딱 칠때

//setter 주입은 열려있음.. public 요즘 잘 안쓴다. 생성후 변경 못하게해야함 생성자주입이좋다.