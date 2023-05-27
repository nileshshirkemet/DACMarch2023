class Transformer
{
    public static void Transform(UnmanagedMemoryAccessor data)
    {
        for(long i = 0, j = data.Capacity - 1; i < j; ++i, --j)
        {
            byte ib = data.ReadByte(i);
            byte jb = data.ReadByte(j);
            data.Write(i, jb);
            data.Write(j, ib);
        }
    }
}