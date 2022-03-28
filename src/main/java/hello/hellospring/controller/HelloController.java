package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HelloController {
    //기본적인 get 요청
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    //get요청에서 url 쿼리스트링 하는 것
    @GetMapping("hello-mvc")
    public  String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http통신시 들어온 요청의 바디 부분에 아래 내용을 삽입후 전달히겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public  Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); //작성하다 ctrl + shift + enter 누르면 자동 완성
        hello.setName(name);
        return  hello; //이렇게 하면 json 방식이 가능 ex {"name": "spring"}
    }

    static class Hello {
        private String name;
        //자바 getter setter 자동 완성 Alt + insert => 자바빈 규격 or 프로퍼티 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
