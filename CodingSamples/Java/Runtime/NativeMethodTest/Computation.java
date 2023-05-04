class Computation {

	public static native long gcdOf(long first, long second);

	public static native double sumOfSquares(double[] values);

	static {
		//load platform-specific library which exports the
		//functions called by the native methods of this class
		System.loadLibrary("computation");
	}
}

