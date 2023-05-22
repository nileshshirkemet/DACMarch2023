class SimpleStack<V>
{
    class Node
    {
        internal V Element;
        internal Node Below;
    }

    private Node top;

    public void Push(V item)
    {
        top = new Node { Element = item, Below = top };
    }

    public V Pop()
    {
        V item = top.Element;
        top = top.Below;
        return item;
    }

    public bool Empty()
    {
        return top is null;
    }
}