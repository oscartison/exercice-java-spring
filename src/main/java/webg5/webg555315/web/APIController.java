package webg5.webg555315.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webg5.webg555315.business.Musique;
import webg5.webg555315.model.Track;


@RestController 
@CrossOrigin(origins="*") 
@RequestMapping("/api") 
public class APIController {
    @Autowired 
    Musique musique;



    @GetMapping("/tracksbigger/{bigger}") 
    public List<Track> getTracksBigger(@PathVariable("bigger") int bigger) {
        return musique.getTracksBigger(bigger); 
    }
}
    