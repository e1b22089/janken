package oit.is.z2495.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oit.is.z2495.kaizi.janken.model.Janken;

@Controller
public class JankenController {

    @GetMapping("/janken")
    public String janken(@RequestParam(value = "username", required = false) String username, Model model) {
        model.addAttribute("username", username);
        return "janken";
    }

    @GetMapping("/jankengame")
    public String jankenBattle(@RequestParam(value = "username") String username,
                               @RequestParam(value = "playerHand") String playerHand, Model model) {
        String cpuHand = "ぐー";
        String result = Janken.judge(playerHand, cpuHand);

        model.addAttribute("username", username);
        model.addAttribute("playerHand", playerHand);
        model.addAttribute("cpuHand", cpuHand);
        model.addAttribute("result", result);

        return "janken";
    }
}
