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
        model.addAttribute("data", "spring");
        return "hello"; // templates/hello.html
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template"; //
    }

    @GetMapping("hello-string")
    @ResponseBody//http에 데이터를 직접 얻을 것.
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;//이케 하면 url값 그대로 가져옴.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }//json형태로 나옴.

    static class Hello {
        private String name; //command n 누르면 단축키로 생성 가능

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }

}
