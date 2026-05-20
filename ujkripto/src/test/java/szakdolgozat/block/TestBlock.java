package szakdolgozat.block;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import szakdolgozat.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TestBlock {
    private Block block;

    @Mock
    Transaction t1;

    @Mock
    Transaction t2;

    @BeforeEach
    public void setUp() {
        block = new Block();
    }

    @Test
    public void testSetGetTimestamp() {
        block.setTimeStamp(12312312);
        assertEquals(block.getTimeStamp(), 12312312);

        block.setTimeStamp(45645645);
        assertEquals(block.getTimeStamp(),45645645);
    }

    @Test
    public void testSetGetPreviousBlockHash() {
        block.setPreviousBlockHash("Alma");
        assertEquals(block.getPreviousBlockHash(), "Alma");

        block.setPreviousBlockHash("Barack");
        assertEquals(block.getPreviousBlockHash(), "Barack");
    }

    @Test
    public void testSetGetResolver() {
        block.setResolver("Mandula");
        assertEquals(block.getResolver(), "Mandula");

        block.setResolver("Bodza");
        assertEquals(block.getResolver(), "Bodza");
    }

    @Test
    public void testSetGetResolution(){
        block.setResolution("Bab");
        assertEquals(block.getResolution(), "Bab");

        block.setResolution("Zeller");
        assertEquals(block.getResolution(), "Zeller");
    }

    @Test
    public void testSetGetTransactions() {
        ArrayList<Transaction> transactions1 = new ArrayList<>();
        transactions1.add(t1);

        ArrayList<Transaction> transactions2 = new ArrayList<>();
        transactions2.add(t1);
        transactions2.add(t2);

        block.setTransactions(transactions1);
        assertEquals(block.getTransactions(), transactions1);

        block.setTransactions(transactions2);
        assertEquals(block.getTransactions(), transactions2);
    }

    @Test
    public void testEquals() {
        ArrayList<Transaction> transactions1 = new ArrayList<>();
        transactions1.add(t1);

        ArrayList<Transaction> transactions2 = new ArrayList<>();
        transactions2.add(t1);
        transactions2.add(t2);

        Block b2 = new Block();
        Block b3 = new Block();

        block.setTransactions(transactions1);
        b2.setTransactions(transactions2);
        b3.setTransactions(transactions1);

        block.setResolver("Alma");
        b2.setResolver("Mandula");
        b3.setResolver("Alma");

        block.setResolution("Zeller");
        b2.setResolution("Bab");
        b3.setResolution("Zeller");

        block.setPreviousBlockHash("Cica");
        b2.setPreviousBlockHash("Kutya");
        b3.setPreviousBlockHash("Cica");

        block.setTimeStamp(123456);
        b2.setTimeStamp(234567);
        b3.setTimeStamp(123456);

        assertEquals(block,b3);
        assertNotEquals(block,b2);
        assertEquals(b3,block);
        assertNotEquals(b2,block);
        assertNotEquals(b2,b3);
        assertNotEquals(b3,b2);
    }

    @Test
    public void testHashCode() {
        ArrayList<Transaction> transactions1 = new ArrayList<>();
        transactions1.add(t1);

        ArrayList<Transaction> transactions2 = new ArrayList<>();
        transactions2.add(t1);
        transactions2.add(t2);

        Block b2 = new Block();
        Block b3 = new Block();

        block.setTransactions(transactions1);
        b2.setTransactions(transactions2);
        b3.setTransactions(transactions1);

        block.setResolver("Alma");
        b2.setResolver("Mandula");
        b3.setResolver("Alma");

        block.setResolution("Zeller");
        b2.setResolution("Bab");
        b3.setResolution("Zeller");

        block.setPreviousBlockHash("Cica");
        b2.setPreviousBlockHash("Kutya");
        b3.setPreviousBlockHash("Cica");

        block.setTimeStamp(123456);
        b2.setTimeStamp(234567);
        b3.setTimeStamp(123456);

        assertEquals(block.hashCode(),b3.hashCode());
        assertNotEquals(block.hashCode(),b2.hashCode());
        assertEquals(b3.hashCode(),block.hashCode());
        assertNotEquals(b2.hashCode(),block.hashCode());
        assertNotEquals(b2.hashCode(),b3.hashCode());
        assertNotEquals(b3.hashCode(),b2.hashCode());
    }

    @Test
    public void testParseDataAsStringList() {
        ArrayList<Transaction> transactions1 = new ArrayList<>();
        transactions1.add(t1);
        transactions1.add(t2);


        block.setTransactions(transactions1);
        block.setResolver("Alma");
        block.setResolution("Zeller");
        block.setPreviousBlockHash("Cica");
        block.setTimeStamp(123456);
        ArrayList<String> al = new ArrayList<>(List.of(String.valueOf(123456), "Cica", "Alma", "Zeller", "BLOKK_VEGE_TOKEN"));
        assertEquals(block.parseDataAsStringList(), al);

        block.setTransactions(transactions1);
        block.setResolver("Alma2");
        block.setResolution("Zeller2");
        block.setPreviousBlockHash("Cica2");
        block.setTimeStamp(1234562);
        al = new ArrayList<>(List.of(String.valueOf(1234562), "Cica2", "Alma2", "Zeller2", "BLOKK_VEGE_TOKEN"));
        assertEquals(block.parseDataAsStringList(), al);
    }

    @Test
    public void testOneParameterConstructor() {
        ArrayList<Transaction> transactions1 = new ArrayList<>();
        transactions1.add(t1);
        transactions1.add(t2);


        block.setTransactions(transactions1);
        block.setResolver("Alma");
        block.setResolution("Zeller");
        block.setPreviousBlockHash("Cica");
        block.setTimeStamp(123456);
        ArrayList<String> al = new ArrayList<>(List.of(String.valueOf(123456), "Cica", "Alma", "Zeller", "BLOKK_VEGE_TOKEN"));
        Block b2 = new Block(al);

        assertEquals(block.parseDataAsStringList(),b2.parseDataAsStringList());
        assertEquals(block.parseDataAsStringList(), al);


        block.setTransactions(transactions1);
        block.setResolver("Alma2");
        block.setResolution("Zeller2");
        block.setPreviousBlockHash("Cica2");
        block.setTimeStamp(1234562);
        al = new ArrayList<>(List.of(String.valueOf(1234562), "Cica2", "Alma2", "Zeller2", "BLOKK_VEGE_TOKEN"));
        b2 = new Block(al);
        assertEquals(block.parseDataAsStringList(),b2.parseDataAsStringList());
        assertEquals(block.parseDataAsStringList(), al);

        al = new ArrayList<>(List.of(String.valueOf(1234562), "Cica2", "Alma2", "Zeller2", "2313213", "Laci", "Norbi", "1.3232", "Szignao", "BLOKK_VEGE_TOKEN"));
        b2 = new Block(al);
        assertEquals(b2.parseDataAsStringList(), al);

    }
}
