// Codigo de Java Structures: Data Structures for the Principled Programmer
import java.util.Map;

public class Association <K, V> implements Map.Entry
{
    //public boolean equals(Object other)
    // pre: other is non-null Association
// post: returns true iff the keys are equal

    protected Object theKey; // the key of the key-value pair
    protected Object theValue; // the value of the key-value pair
    public Association(K key, V value)
// pre: key is non-null
// post: constructs a key-value pair
    {
        theKey = key;
        theValue = value;
    }
    public Object getValue()
// post: returns value from association
    {
        return theValue;
    }
    public Object getKey()
// post: returns key from association
    {
        return theKey;
    }
    public Object setValue(Object value)
// post: sets association's value to value
    {
        Object oldValue = theValue;
        theValue = value;
        return oldValue;
    }
}