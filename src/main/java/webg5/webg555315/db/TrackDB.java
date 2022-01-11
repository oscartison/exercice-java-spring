package webg5.webg555315.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webg5.webg555315.model.Track;



public interface TrackDB extends CrudRepository<Track,Long>{
    @Query("SELECT t FROM Track t WHERE stream > :number")
    List<Track> findTracksBiggerThen(int number);
 }
