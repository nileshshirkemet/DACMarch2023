class Transformer {

	public static void transform(java.nio.ByteBuffer bytes) {
		for(int i = 0, j = bytes.capacity() - 1; i < j; ++i, --j) {
			byte ib = bytes.get(i);
			byte jb = bytes.get(j);
			bytes.put(i, jb);
			bytes.put(j, ib);
		}
	}
}

