package webg5.webg555315.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webg5.webg555315.db.ArtistDB;
import webg5.webg555315.db.TrackDB;
import webg5.webg555315.model.Artist;
import webg5.webg555315.model.Track;


@Service
public class Musique  {

    @Autowired
    private ArtistDB artistDB;

    @Autowired
    private TrackDB trackDB;


    public List<Track> getTracks() {        
        List<Track> result = new ArrayList<>();
        trackDB.findAll().forEach(result::add);
        return result;
    }

    public List<Artist> getArtists() {
        List<Artist> result = new ArrayList<>();
        artistDB.findAll().forEach(result::add);
        return result;
    }

    public Artist getArtist(String $id) {     
        if (artistDB.findById($id).isPresent() ) {
            return artistDB.findById($id).get();
        }else return null;
    }

        public Track getTrack(Long $id) {     
            if (trackDB.findById($id).isPresent() ) {
                return trackDB.findById($id).get();
            }else return null;
        }

    public void addStream(Long songId, int stream) {
        Track track = getTrack(songId);
        int streams = track.getStream();
        track.setStream(streams + stream);
        trackDB.save(track);
    }

    public List<Track> getTracksBigger(int bigger) {
        return trackDB.findTracksBiggerThen(bigger);
    }
}
