package saupe.mopidy.model;

public abstract class Base {
	private transient Object extra;	// Extra field attaching non-JSON derived data

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}
}