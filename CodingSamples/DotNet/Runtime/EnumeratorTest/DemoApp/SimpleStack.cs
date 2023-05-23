class SimpleStack<V>
{
    class Node
    {
        internal V Element;
        internal Node Below;

        internal Node Pick(int skip)
        {
            Node n = this;
            for(int i = 0; i < skip; ++i)
                n = n.Below;
            return n;
        }
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

    //to support standard enumeration (foreach iteration)
    //a class must include a public definition of GetEnumerator()
    //instance method whose return type exposes MoveNext() method
    //and Current property as declared in IEnumerator<E> interface
    public IEnumerator<V> GetEnumerator()
    {
        for(Node n = top; n != null; n = n.Below)
        {
            //using yield statement to return multiple values
            //one-by-one from a method through an auto-generated
            //implementation of IEnumerator<E>/IEnumerable<E> 
            //declared as the return type of this method
            yield return n.Element;
        }
    }

    //an indexer is a special parameterized property which
    //exposes data in an object using array-like syntax 
    public V this[int index]
    {
        get {return top.Pick(index).Element; }
        set {top.Pick(index).Element = value; }
    }
}