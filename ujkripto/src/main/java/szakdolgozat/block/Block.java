package szakdolgozat.block;

import szakdolgozat.transaction.Transaction;

import java.util.ArrayList;
import java.util.Objects;

import static szakdolgozat.block.chain.BlockChain.BLOCK_END_TOKEN;

public class Block {

    private long timeStamp;
    private String previousBlockHash;
    private String resolver;
    private String resolution;
    private ArrayList<Transaction> transactions;

    public Block() {
    }

    public Block(ArrayList<String> blockDataAsStringList) {
        super();
        timeStamp = Long.parseLong(blockDataAsStringList.get(0));
        previousBlockHash = blockDataAsStringList.get(1);
        resolver = blockDataAsStringList.get(2);
        resolution = blockDataAsStringList.get(3);
        transactions = new ArrayList<>();
        for (int index = 4; index < blockDataAsStringList.size(); index += 5){
            if(blockDataAsStringList.get(index).equals(BLOCK_END_TOKEN)) {
                break;
            }
            Transaction transaction = new Transaction();
            transaction.setTimeStamp(Long.parseLong(blockDataAsStringList.get(index)));
            transaction.setSender(blockDataAsStringList.get(index + 1));
            transaction.setReceiver(blockDataAsStringList.get(index + 2));
            transaction.setAmount(Double.parseDouble(blockDataAsStringList.get(index + 3)));
            transaction.setSignature(blockDataAsStringList.get(index + 4));
            transactions.add(transaction);
        }
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public String getResolver() {
        return resolver;
    }

    public void setResolver(String resolver) {
        this.resolver = resolver;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return getTimeStamp() == block.getTimeStamp() &&
                getPreviousBlockHash().equals(block.getPreviousBlockHash()) &&
                getResolver().equals(block.getResolver()) &&
                getResolution().equals(block.getResolution()) &&
                getTransactions().equals(block.getTransactions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimeStamp(), getPreviousBlockHash(), getResolver(), getResolution(), getTransactions());
    }

    public ArrayList<String> parseDataAsStringList() {
        ArrayList<String> dataAsStringList = new ArrayList<>();
        dataAsStringList.add(String.valueOf(timeStamp));
        dataAsStringList.add(previousBlockHash);
        dataAsStringList.add(resolver);
        dataAsStringList.add(resolution);
        transactions.forEach(transaction -> dataAsStringList.addAll(transaction.oarseDataAsStringList()));
        dataAsStringList.add(BLOCK_END_TOKEN);
        return dataAsStringList;
    }
}
