package oit.is.z2495.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oit.is.z2495.kaizi.janken.model.Janken;
import oit.is.z2495.kaizi.janken.model.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class JankenController {

  @Autowired
  Entry entry; // EntryクラスをDependency Injectionで利用

  private static final Logger logger = LoggerFactory.getLogger(JankenController.class);

  @GetMapping("/janken")
  public String janken(Principal prin, Model model) {
    String username = prin.getName(); // ログインユーザー名を取得
    entry.addUser(username); // ユーザ名をエントリーに追加
    model.addAttribute("username", username);
    model.addAttribute("users", entry.getUsers()); // エントリー中のユーザ一覧を追加
    return "janken";
  }

  @GetMapping("/jankenBattle")
  public String jankenBattle(@RequestParam(value = "username") String username,
      @RequestParam(value = "playerHand") String playerHand, Model model) {
    String cpuHand = "Gu";
    String result = Janken.judge(playerHand, cpuHand);

    model.addAttribute("username", username);
    model.addAttribute("playerHand", playerHand);
    model.addAttribute("cpuHand", cpuHand);
    model.addAttribute("result", result);
    model.addAttribute("users", entry.getUsers()); // エントリー中のユーザ一覧を追加

    logger.info("エントリー中のユーザ: " + entry.getUsers()); // ログでユーザリストを確認

    return "janken";
  }
}
