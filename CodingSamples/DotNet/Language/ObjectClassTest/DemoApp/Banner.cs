struct Banner
{
    public float Width { get; set; }

    public float Height { get; set; }

    public Banner(float w, float h)
    {
        Width = w;
        Height = h;
    }

    public double Area()
    {
        return Width * Height;
    }

    public override string ToString()
    {
        return $"{Width} x {Height}";
    }
}