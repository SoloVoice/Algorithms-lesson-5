import java.util.List;

public class FindMostExpensiveSet {
    private int backpackVolume = 15;
    private List<Item> resultSet;
    private int resultWeight = 0;

    public void findSet(List<Item> entrySet) {
        if (entrySet.isEmpty()) {
            return;
        }

        isMostExpensive(entrySet);

        for (int i = 0; i <entrySet.size(); i++) {
            List<Item> temp = entrySet;
            temp.remove(i);
            findSet(temp);
        }
    }

    private int overallSum(List<Item> itemList) {
        int sum =0;
        for (Item i: itemList) {
            sum += i.cost;
        }
        return sum;
    }

    private int overallWeight(List<Item> itemList) {
        int weight = 0;
        for (Item i: itemList) {
            weight += i.weight;
        }
        return weight;
    }

    private void isMostExpensive(List<Item> itemList) {
        int cost = overallSum(itemList);
        int weight = overallWeight(itemList);
        if (weight <= backpackVolume && (resultSet == null || cost > overallSum(resultSet))) {
            resultSet = itemList;
            resultWeight = weight;
        }
    }

    public List<Item> getResultSet() {
        return resultSet;
    }

    private void change(List<Item> itemList, int a, int b) {
        Item x = itemList.get(b);
        itemList.set(b, itemList.get(a));
        itemList.set(a, x);
    }
}
