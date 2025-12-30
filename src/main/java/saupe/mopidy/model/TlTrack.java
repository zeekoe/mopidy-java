package saupe.mopidy.model;


/*
 * A tracklist track. Wraps a regular track and it's tracklist ID. It allows the same track to appear multiple times
 * in the tracklist.
 *
 * See: https://github.com/mopidy/mopidy/blob/develop/mopidy/models/__init__.py
 */

public class TlTrack extends Base {
	private Track track;
	private int tlId;

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public int getTlId() {
		return tlId;
	}

	public void setTlId(int tlId) {
		this.tlId = tlId;
	}

	@Override
	public String toString() {
		return "TlTrack[" + tlId + "," + track + "]";
	}
}