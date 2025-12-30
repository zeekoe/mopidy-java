package saupe.mopidy.model;

/*
 * Model to represent URI references with a human friendly name and type attached.
 * This is intended for use a lightweight object "free" of metadata that can be passed around instead of using full
 * blown models.
 *
 * See: https://github.com/mopidy/mopidy/blob/develop/mopidy/models/__init__.py
 */

public class Ref extends Base {
	public static final String TYPE_ALBUM 		= "album";
	public static final String TYPE_ARTIST 		= "artist";
	public static final String TYPE_DIRECTORY 	= "directory";
	public static final String TYPE_PLAYLIST 	= "playlist";
	public static final String TYPE_TRACK 		= "track";

	private String uri;
	private String name;
	private String type;

	public Ref(String uri, String name, String type) {
		super();

		this.uri = uri;
		this.name = name;
		this.type = type;
	}

	public static Ref directory(String uri, String name) {
		return new Ref(uri, name, TYPE_DIRECTORY);
	}

	public static Ref track(String name, String uri) {
		return new Ref(uri, name, TYPE_TRACK);
	}

	public static Ref playlist(String uri, String name) {
		return new Ref(uri, name, TYPE_PLAYLIST);
	}

	public static Ref album(String uri, String name) {
		return new Ref(uri, name, TYPE_ALBUM);
	}

	public static Ref artist(String uri, String name) {
		return new Ref(uri, name, TYPE_ARTIST);
	}

	@Override
	public String toString() {
		return "Ref[" + type + ":" + name + ":<" + uri + ">]";
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}