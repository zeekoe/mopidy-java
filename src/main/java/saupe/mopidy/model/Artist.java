package saupe.mopidy.model;


/*
 * See: https://github.com/mopidy/mopidy/blob/develop/mopidy/models/__init__.py
 */

public class Artist extends Base {
	private String uri;
	private String name;
	private String sortname;
	private String musicbrainz_id;

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

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getMusicbrainz_id() {
		return musicbrainz_id;
	}

	public void setMusicbrainz_id(String musicbrainz_id) {
		this.musicbrainz_id = musicbrainz_id;
	}
}