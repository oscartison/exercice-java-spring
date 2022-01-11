package webg5.webg555315.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webg5.webg555315.model.Artist;


public interface ArtistDB extends CrudRepository<Artist,String>{


 }
