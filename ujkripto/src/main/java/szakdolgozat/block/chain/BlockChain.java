package szakdolgozat.block.chain;

import szakdolgozat.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockChain extends ArrayList<Block> {

    public static final String BLOCK_END_TOKEN = "BLOKK_VEGE_TOKEN";

    public BlockChain() {
    }

    public BlockChain(List<String> dataAsStringList) {
        super();
        final ArrayList<String>[] blockDataAsStringList = new ArrayList[]{new ArrayList<>()};
        dataAsStringList.forEach(data -> {
            if(data.equals(BLOCK_END_TOKEN)) {
                add(new Block(blockDataAsStringList[0]));
                blockDataAsStringList[0] = new ArrayList<>();
            }
            else blockDataAsStringList[0].add(data);
        });
    }

    public Block getLast() {
        if (size()==0) {
            return null;
        }
        return get(size() - 1);
    }

    public ArrayList<String> parseDataAsStringList() {
        ArrayList<String> dataAsStringList = new ArrayList<>();
        forEach(block -> dataAsStringList.addAll(block.parseDataAsStringList()));
        return dataAsStringList;
    }
}
