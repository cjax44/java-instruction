package business;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    
    private int artistID;
    private String name;
    private List<Album> albums;
    
    public Artist() {}
    
    public Artist(int artistID, String name) {
        this.artistID = artistID;
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Album> getAlbums() {
        return this.albums;
    }    
    
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }    
    
}