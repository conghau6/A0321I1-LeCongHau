package codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static Map<String,String> dictionary;
    static {
        dictionary = new HashMap<>();
        dictionary.put("Hello","Xin chào");
        dictionary.put("Cat","Con mèo");
        dictionary.put("Chicken","Con gà");
    }
    @GetMapping("/")
    public String showForm(){
        return "home";
    }

    @GetMapping("/result")
    public String resultForm(@RequestParam String eng, Model model){
        String result = dictionary.get(eng);
        model.addAttribute("eng",eng);
        model.addAttribute("vie",result);
        return "result";
    }
}
