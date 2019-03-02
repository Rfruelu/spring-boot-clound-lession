package springboot.lujia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :lujia
 * @date :2018/11/13  15:32
 */
@Controller
public class IndexController {

    @RequestMapping("/index/{args}")
    public String index(@PathVariable("args") String args, Model model){
        model.addAttribute("name",args);
        return "index";
    }

    @RequestMapping("/index/error")
    public String index(Model model)throws Exception{
        throw  new Exception("error");
    }
    @RequestMapping("/index/null")
    public String nullTest(Model model)throws NullPointerException{
        throw  new NullPointerException("null");
    }
}
