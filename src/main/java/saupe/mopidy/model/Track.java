package saupe.mopidy.model;

/*
 * See: https://github.com/mopidy/mopidy/blob/develop/mopidy/models/__init__.py
 */

public class Track extends Base {
    private String uri;
    private String name;
    private Artist[] artists;
    private Album album;
    private Artist[] composers;
    private Artist[] performers;
    private String genre;
    private Integer trackNo;
    private Integer discNo;
    private String date;            // Release date (YYYY or YYYY-MM-DD)
    private Long length;            // In milliseconds
    private Integer bitrate;        // In kBit/s
    private String comment;
    private String musicbrainzId;
    private Long lastModified;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public void setArtists(Artist[] artists) {
        this.artists = artists;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist[] getComposers() {
        return composers;
    }

    public void setComposers(Artist[] composers) {
        this.composers = composers;
    }

    public Artist[] getPerformers() {
        return performers;
    }

    public void setPerformers(Artist[] performers) {
        this.performers = performers;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
    }

    public Integer getDiscNo() {
        return discNo;
    }

    public void setDiscNo(Integer discNo) {
        this.discNo = discNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Integer getBitrate() {
        return bitrate;
    }

    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMusicbrainzId() {
        return musicbrainzId;
    }

    public void setMusicbrainzId(String musicbrainzId) {
        this.musicbrainzId = musicbrainzId;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "Track[" + "name=" + name + " uri=" + uri + "]";
    }
}