class Computation {

	public static native long gcdOf(long first, long second);

	static {
		//load platform-specific library which exports the
		//functions called by the native methods of this class
		System.loadLibrary("computation");
	}
}

