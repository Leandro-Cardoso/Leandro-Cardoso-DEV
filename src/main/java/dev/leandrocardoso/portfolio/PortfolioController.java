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
        model.addAttribute("title", "Leandro Carodoso {DEV}");
        model.addAttribute("h1", "Leandro Carodoso");
        model.addAttribute("header", "modules/header");
        model.addAttribute("divH1", "modules/h1");
        model.addAttribute("aboutShort", "modules/about-short");
        model.addAttribute("projectsShort", "modules/projects-short");
        model.addAttribute("blogShort", "modules/blog-short");
        model.addAttribute("footer", "modules/footer");
        return "index";
    }

}
