package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
//    //이방법은 필드 주입 - 않좋다.
//    @Autowired private MemberService memberService;
//    //이방식은 세터 방식
//    @Autowired
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }


    //권장하는 방법 생성자를 이용하는 방식
    private final MemberService memberService;
    //의존관계 주입
    @Autowired //memberService를 스프링이 service의 memberservice와 연결시켜준다.
    public MemberController(MemberService memberService) {
        //오류가 뜨는데 memverservice는 순수 자바 클래스여서
        this.memberService = memberService;
    }
}
