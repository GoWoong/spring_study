package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    //의존관계 주입
    @Autowired //memberService를 스프링이 service의 memberservice와 연결시켜준다.
    public MemberController(MemberService memberService) {
        //오류가 뜨는데 memverservice는 순수 자바 클래스여서
        this.memberService = memberService;
    }
}
