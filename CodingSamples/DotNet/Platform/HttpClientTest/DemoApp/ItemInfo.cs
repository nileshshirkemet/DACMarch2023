//a value type record is mutable unless declared with
//readonly keyword
readonly record struct ItemInfo(double Rate, int Stock)
{
    public static ItemInfo Parse(string text)
    {
        string[] segments = text.Split(',');
        double rate = double.Parse(segments[0][5..]);
        int stock = int.Parse(segments[1][6..]);
        return new ItemInfo(rate, stock);
    }
}