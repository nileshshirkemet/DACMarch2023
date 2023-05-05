class Transformer {

	public static void transform(byte[] bytes, int count) {
		for(int i = 0; i < count; ++i){
			bytes[i] = (byte)(bytes[i] ^ '#');
		}
	}
}

