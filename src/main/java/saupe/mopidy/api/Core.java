package saupe.mopidy.api;

import saupe.mopidy.MopidyClient;

/*
 * See: https://github.com/mopidy/mopidy/blob/develop/mopidy/core/actor.py
 */

public class Core extends Api {
	private final Library 	library 	= new Library(this);
	private final History 	history 	= new History(this);
	private final Mixer 	mixer 		= new Mixer(this);
	private final Playback 	playback 	= new Playback(this);
	private final Tracklist tracklist 	= new Tracklist(this);
	private final Playlists	playlists	= new Playlists(this);

	public Core(MopidyClient client) {
		super(client, "core.");
	}

	/**
	 * Get list of URI schemes that can be handled.
	 *
	 * @return Array of String
	 */
	public Call<String[]> getUriSchemes() {
		return createCall("get_uri_schemes", String[].class);
	}

	/**
	 * Get version of the Mopidy core API.
	 *
	 * @return String
	 */
	public Call<String> getVersion() {
		return createCall("get_version", String.class);
	}

	public Library getLibrary() {
		return library;
	}

	public History getHistory() {
		return history;
	}

	public Mixer getMixer() {
		return mixer;
	}

	public Playback getPlayback() {
		return playback;
	}

	public Tracklist getTracklist() {
		return tracklist;
	}

	public Playlists getPlaylists() {
		return playlists;
	}
}