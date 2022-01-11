package webg5.webg555315.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import webg5.webg555315.business.Artists;


@Controller
public class ArtistController {
    @Autowired
    private Artists artists;
    

    @GetMapping("/")
    public String home() {
    
        return "home";
    }

    @GetMapping("/artists")
    public String artists(Model model) {
        model.addAttribute("artists", artists.getArtists());
        return "artists";
    }

    @GetMapping("/artists/{id}")
    public String showDetail(@PathVariable("id") String artistId, Model model) {
        model.addAttribute("artist", artists.getArtist(artistId));
        return "artistdetail";
    }

}
