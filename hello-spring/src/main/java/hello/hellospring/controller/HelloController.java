package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // templates/hello.html로 가라..
    }

    @GetMapping("hello-mvc")
    // 위에 hello!! 랑 다르게 parameter 받아오
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody  //응답 바디부에 값을 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //hello spring
    }
    // hello-string 은 잘 쓰진 않음 이 아래가 진짜
    @GetMapping("hello-api")
    @ResponseBody // 객체를 넘기면 json으로 반환하는게 기본... xml로 바꿀 수 있지만 굳이..
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
// json으로 던져줌 json : key-value 형
    }
    static class Hello {
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }

}

