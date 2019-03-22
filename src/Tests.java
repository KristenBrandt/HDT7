import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @org.junit.Test
    public void insert() {
        Node<Association<String,String>> palabrasNuevas = new Node<>();
        String part1 = "hello";
        String part2 = "hola";
        Association palabrota = new Association(part1,part2);
        palabrasNuevas.insert(palabrota);
        assertEquals(palabrota,palabrota);
    }

    @Test
    public void getValue() {
        Node<Association<String,String>> palabrasNuevas = new Node<>();
        String part1 = "hello";
        String part2 = "hola";
        Association palabrota = new Association(part1,part2);
        String listo = palabrota.toString();
        Object palab = palabrota.theKey;
        Object pelab =  palabrota.theValue;
        assertEquals(listo," " + palab + " " + pelab);
    }

    @Test
    public void getKey() {
        Node<Association<String,String>> palabrasNuevas = new Node<>();
        String part1 = "hello";
        String part2 = "hola";
        Association palabrota = new Association(part1,part2);
        String listo = palabrota.toString();
        Object palab = palabrota.theKey;
        Object pelab =  palabrota.theValue;
        assertEquals(listo," " + palab + " " + pelab);
    }
}