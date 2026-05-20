package szakdolgozat.block.chain.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlockChainController {

    BlockChainController blockChainController;

    @BeforeEach
    public void setUp() {
        blockChainController = BlockChainController.getInstance();
    }

    @Test
    public void testSingleton() {
        assertEquals(BlockChainController.getInstance(), blockChainController);
    }
}
