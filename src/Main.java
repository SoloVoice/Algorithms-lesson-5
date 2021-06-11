import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(elevate(5, 5));

        Item item1 = new Item("книга", 1, 600);
        Item item2 = new Item("бинокль", 2, 5000);
        Item item3 = new Item("аптечка", 4, 1500);
        Item item4 = new Item("ноутбук", 12, 40000);
        Item item5 = new Item("котелок", 1, 500);
        List itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
         FindMostExpensiveSet findMostExpensiveSet = new FindMostExpensiveSet();
         findMostExpensiveSet.findSet(itemList);
        for (Item i: findMostExpensiveSet.getResultSet()) {
            System.out.println(i.name +" "+ i.cost +" "+ i.weight);
        }
    }

    public static double elevate(int arg, int elv) {
        if (elv == 0) {
            return (double) 0;
        } else if (elv > 0) {
            if (elv <= 1) {
                return arg;
            }
            return (double) (arg * elevate(arg, --elv));
        } else {
            return (double) (1 / elevate(arg, Math.abs(elv)));
        }
    }
}
