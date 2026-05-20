package szakdolgozat.balancer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import szakdolgozat.block.chain.BlockChain;
import szakdolgozat.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBalancer {
    Balancer balancer;

    @BeforeEach
    public void setUp() {
        balancer = Balancer.getInstance();
    }

    @Test
    public void testSingleton() {
        assertEquals(Balancer.getInstance(), balancer);
    }

    @Test
    public void testGetBalance() {
        ArrayList<String> al = new ArrayList<>(List.of(String.valueOf(1234562), "Cica2", "Alma2", "Zeller2", "2313213", "Laci", "Norbi", "1.3232", "Szignao", "BLOKK_VEGE_TOKEN", String.valueOf(12345622), "Cica22", "Alma22", "Zeller22", "23132132", "Laci2", "Norbi2", "1.32322", "Szignao2", "BLOKK_VEGE_TOKEN"));
        BlockChain bc = new BlockChain(al);
        assertEquals(balancer.getBalance(bc, "Laci2"), -1.32322, 0.00001);
        assertEquals(balancer.getBalance(bc, "Norbi2"), 1.32322, 0.00001);
        assertEquals(balancer.getBalance(bc, "Laci"), -1.3232, 0.0001);
        assertEquals(balancer.getBalance(bc, "Norbi"), 1.3232, 0.0001);
    }
}
