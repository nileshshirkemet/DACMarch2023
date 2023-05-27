class Transformer
{
    //Span<T> provides a common abstraction for high-performance
    //and safe access to a contiguous region of CLR managed memory 
    //containing elements of type T
    public static void Transform(Span<byte> data)
    {
        for(int i = 0; i < data.Length; ++i)
        {
            data[i] = (byte)(data[i] ^ '#');
        }
    }
}