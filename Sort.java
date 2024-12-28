import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;

public class Sort {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.print("Nhap day so: ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner = new Scanner(data);

        while (scanner.hasNext()) {
            int key = scanner.nextInt();
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }

        TreeMap<Integer,Integer> clonedMap = new TreeMap<>();
        clonedMap.putAll(map);
        System.out.println("a)");
        int n = 0;
        for (int key : clonedMap.keySet()) {
            if(clonedMap.get(key) > n) n = clonedMap.get(key);
        }
        while(n != 0) {
            for (int key : clonedMap.keySet()) {
                if(clonedMap.get(key) > 0) {
                    System.out.print(key + " ");
                    int value = clonedMap.get(key);
                    clonedMap.put(key, value-1);
                } else System.out.print("  ");
            }
            System.out.println();
            n--;
        }
        
        TreeMap<Integer,Integer> clonedMapp = new TreeMap<>();
        clonedMapp.putAll(map);
        System.out.println("b)");
        for (int key : clonedMapp.keySet()) {
            for(int i = 0; i < clonedMapp.get(key); i++) {
                System.out.print(key+ " ");
            }
            System.out.println();
        }
    }
}
