package webg5.webg555315.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webg5.webg555315.business.Artists;
import webg5.webg555315.model.Track;


@RestController 
@CrossOrigin(origins="*") 
@RequestMapping("/api") 
public class APIController {
    @Autowired 
    Artists artists;



    @GetMapping("/tracksbigger/{bigger}") 
    public List<Track> getCourseDetail(@PathVariable("bigger") int bigger) {
        return artists.getTracksBigger(bigger); 
    }
}
    