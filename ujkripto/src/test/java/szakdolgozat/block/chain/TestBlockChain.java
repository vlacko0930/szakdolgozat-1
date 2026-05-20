package szakdolgozat.block.chain;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestBlockChain {
    private BlockChain blockchain;

    @BeforeEach
    public void setUp() {
        blockchain = new BlockChain();
    }

    @Test
    public void testOneParameterConstructor() {
        ArrayList<String> al = new ArrayList<>(List.of(String.valueOf(1234562), "Cica2", "Alma2", "Zeller2", "2313213", "Laci", "Norbi", "1.3232", "Szignao", "BLOKK_VEGE_TOKEN"));

        blockchain = new BlockChain(al);

        assertEquals(blockchain.parseDataAsStringList(), al);

        al = new ArrayList<>(List.of(String.valueOf(1234562), "Cica2", "Alma2", "Zeller2", "2313213", "Laci", "Norbi", "1.3232", "Szignao", "BLOKK_VEGE_TOKEN", String.valueOf(12345622), "Cica22", "Alma22", "Zeller22", "23132132", "Laci2", "Norbi2", "1.32322", "Szignao2", "BLOKK_VEGE_TOKEN"));
        blockchain = new BlockChain(al);
        assertEquals(blockchain.parseDataAsStringList(),al);

    }
    @Test
    public void testGetLast() {
        assertNull(blockchain.getLast());
        ArrayList<String> al = new ArrayList<>(List.of(String.valueOf(1234562), "Cica2", "Alma2", "Zeller2", "2313213", "Laci", "Norbi", "1.3232", "Szignao", "BLOKK_VEGE_TOKEN", String.valueOf(12345622), "Cica22", "Alma22", "Zeller22", "23132132", "Laci2", "Norbi2", "1.32322", "Szignao2", "BLOKK_VEGE_TOKEN"));
        blockchain = new BlockChain(al);
        ArrayList<String> last = new ArrayList<>(List.of(String.valueOf(12345622), "Cica22", "Alma22", "Zeller22", "23132132", "Laci2", "Norbi2", "1.32322", "Szignao2", "BLOKK_VEGE_TOKEN"));
        assertEquals(blockchain.getLast().parseDataAsStringList(), last);

    }

}
