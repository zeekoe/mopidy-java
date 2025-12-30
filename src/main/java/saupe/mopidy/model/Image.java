package saupe.mopidy.model;

/*
 * See: https://github.com/mopidy/mopidy/blob/develop/mopidy/models/__init__.py
 */

public class Image extends Base {
	private String uri;
	private int width;
	private int height;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Image[" + uri + "]";
	}
}