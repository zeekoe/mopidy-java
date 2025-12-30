package saupe.mopidy.model;

/*
 * See: https://github.com/mopidy/mopidy/blob/develop/mopidy/models/__init__.py
 */

public class Album extends Base {
	private String uri;
	private String name;
	private Artist[] artists;
	private Integer numTracks;
	private Integer numDiscs;
	private String date;			// Release date (YYYY or YYYY-MM-DD)
	private String musicbrainzId;

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

	public Integer getNumTracks() {
		return numTracks;
	}

	public void setNumTracks(Integer numTracks) {
		this.numTracks = numTracks;
	}

	public Integer getNumDiscs() {
		return numDiscs;
	}

	public void setNumDiscs(Integer numDiscs) {
		this.numDiscs = numDiscs;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMusicbrainzId() {
		return musicbrainzId;
	}

	public void setMusicbrainzId(String musicbrainzId) {
		this.musicbrainzId = musicbrainzId;
	}
}