package webg5.webg555315.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ArtistController {
    

    @GetMapping("/")
    public String home() {
    
        return "home";
    }

    @GetMapping("/artists")
    public String artists() {
        return "artists";
    }

}
