class Interval
{
    //read-only property can only be set in a constructor
    public int Minutes { get; }

    public int Seconds { get; }

    public Interval(int min, int sec)
    {
        Minutes = min + sec / 60;
        Seconds = sec % 60;
    }

    public int Time()
    {
        return 60 * Minutes + Seconds;
    }

    public override string ToString()
    {
        if(Seconds < 10)
            return Minutes + ":0" + Seconds;
        return Minutes + ":" + Seconds;
    }

    public static Interval operator+(Interval lhs, Interval rhs)
    {
        return new Interval(lhs.Minutes + rhs.Minutes, lhs.Seconds + rhs.Seconds);
    }

    public override int GetHashCode()
    {
        return Minutes + Seconds;
    }

    public override bool Equals(object obj)
    {
        if(obj is Interval that)
        {
            return (Minutes == that.Minutes) && (Seconds == that.Seconds);
        }
        return false;
    }
}