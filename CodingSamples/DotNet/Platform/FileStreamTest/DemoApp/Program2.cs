int sz = args.Length > 2 ? int.Parse(args[2]) : 80;
using FileStream input = new FileStream(args[0], FileMode.Open);
using FileStream output = new FileStream(args[1], FileMode.CreateNew);
Span<byte> buffer = sz > 128 ? new byte[sz] : stackalloc byte[sz];
while(input.Position < input.Length)
{
    int n = input.Read(buffer);
    Transformer.Transform(buffer[0..n]);
    output.Write(buffer[..n]);
}
