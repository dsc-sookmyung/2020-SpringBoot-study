package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","DSC Sookmyung!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    /*html 바디 태그 얘기하는게 아니라 http 통신 프로토콜에서 body부에 데이터를 직접 넣어주겠다.
     * 페이지 소스 보기 했을때 html로 안나오고 데이터 그대로 나옴 */
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //"hello spring" String name에 spring넣으면
    }

    /*json 형식으로 key-value 형태로 나옴, 요즘에 이거 많이 쓰인다!*/
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; /*처음으로 객체를 넘김*/
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
