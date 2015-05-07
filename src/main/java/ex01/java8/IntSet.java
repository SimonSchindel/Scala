package ex01.java8;

public abstract class IntSet {
	public abstract IntSet incl(int x);

	public abstract boolean contains(int x);

	public abstract void foreach(IntOp f);

	public IntSet filter(IntBoolFunc p) {
		// TODO: implement this
		return null;
	}

	public IntSet intersect(final IntSet that) {
		// TODO: implement this
		return null;
	}
	

	@Override
	public String toString() {
		// TODO: implement this
		return "";
	}

	// Alternative toString implementation
	public String toString2() {
		// TODO: implement this
		return "";
	}
}

// We could make this a singleton
class Empty extends IntSet {
	public boolean contains(int x) {
		// TODO: implement this
		return true;
	}

	public IntSet incl(int x) {
		// TODO: implement this
		return null;
	}

	public void foreach(IntOp f) {
		// TODO: implement this
	}
}

class NonEmpty extends IntSet {
	public NonEmpty(int elem, IntSet left, IntSet right) {
		// TODO: implement this
	}

	public boolean contains(int x) {
		// TODO: implement this
		return true;
	}

	public IntSet incl(int x) {
		// TODO: implement this
		return null;
	}

	public void foreach(IntOp f) {
		// TODO: implement this
	}
}

interface IntOp {
	void apply(int i);
}

interface IntBoolFunc {
	boolean apply(int i);
}