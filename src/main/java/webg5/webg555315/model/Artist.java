package webg5.webg555315.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@ToString
public class Artist {
    @Id
    @Getter @Setter private String login;

    @Getter @Setter private String name;

    @JsonIgnore
    @OneToMany(mappedBy="author", fetch=FetchType.LAZY)
    private Set<Track> tracks;
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Artist)) {
            return false;
        }
        Artist artist = (Artist) o;
        return Objects.equals(login, artist.login) && Objects.equals(name, artist.name) && Objects.equals(tracks, artist.tracks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name);
    }

    @Override
    public String toString() {
        return "{" +
            " login='" + getLogin() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }



}