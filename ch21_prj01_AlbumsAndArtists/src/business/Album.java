package business;

public class Album {
    private int albumID;
    private int artistID;
    private String name;
    
    public Album() {}
    
    public Album(int albumID, int artistID, String name) {
        this.albumID = albumID;
        this.artistID = artistID;
        this.name = name;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
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
}