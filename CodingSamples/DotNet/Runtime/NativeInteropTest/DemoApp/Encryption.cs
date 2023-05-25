using System.Text;
using System.Runtime.InteropServices;

unsafe class Encryption
{
    [DllImport("encbuf", EntryPoint="encrypt_buffer")]
    extern static long EncryptBuffer(byte[] bytes, int count, string key, delegate*<byte, byte, int> transform);

    static int Join(byte a, byte b) => a ^ b;

    public static string EncryptString(string text, string password = "#")
    {
        byte[] bytes = Encoding.UTF8.GetBytes(text);
        EncryptBuffer(bytes, bytes.Length, password, &Join);
        return Encoding.UTF8.GetString(bytes);
    }
}