package dev.leandrocardoso.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PortfolioController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Leandro Cardoso {DEV}");
        model.addAttribute("h1", "Leandro Cardoso");
        model.addAttribute("header", "modules/header");
        model.addAttribute("divH1", "modules/h1");
        model.addAttribute("footer", "modules/footer");
        return "index";
    }

    @GetMapping("/contatos")
    public String contatos(Model model) {
        model.addAttribute("title", "Leandro Cardoso {DEV}");
        model.addAttribute("h1", "Contatos");
        model.addAttribute("header", "modules/header");
        model.addAttribute("divH1", "modules/h1");
        model.addAttribute("footer", "modules/footer");
        return "contacts";
    }

}
