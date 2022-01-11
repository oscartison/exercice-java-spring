package webg5.webg555315.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import webg5.webg555315.business.Musique;
import webg5.webg555315.model.Track;


@Controller
public class ArtistController {
    @Autowired
    private Musique musique;
    

    @GetMapping("/")
    public String home() {
    
        return "home";
    }

    @GetMapping("/artists")
    public String artists(Model model) {
        model.addAttribute("artists", musique.getArtists());
        return "artists";
    }

    @GetMapping("/artists/{id}")
    public String showDetail(@PathVariable("id") String artistId, Model model) {
        model.addAttribute("artist", musique.getArtist(artistId));
        model.addAttribute("songToAdd", new Track());
        return "artistdetail";
    }

    @PostMapping("/artists/add")
    public String addCourse(@ModelAttribute("courseToAdd") @Valid Track track, Errors errors, Long songId, String artistId) {
        if (errors.hasErrors()) {
            return "redirect:/artists/" + artistId;
        } else {
            musique.addStream(songId, track.getStream());
            return "redirect:/artists/" + artistId;
        }
    }

}
