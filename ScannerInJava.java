import java.util.Scanner;
import java.util.TreeMap;
//Scanner(System.in): Nhập dữ liệu từ bàn phím
//Scanner(File("file.txt")): Nhập dữ liệu từ bàn file
//Scanner(String): Nhập dữ liệu từ chuỗi
//scanner.next() Sẽ đọc từ một từ tiếp theo trong luồng đầu vào và sẽ bỏ qua các khoảng trắng, tab, xuống dòng trước và sau nó. Dừng lại khi gặp khoảng trắng, tab, xuống dòng.      
//scanner.nextLine() Sẽ đọc toàn bộ dòng văn bản cho đến khi gặp dấu phân cách dòng
//scanner.nextInt()/.nextDouble()/.nextBoolean(): Sẽ bỏ qua khoảng trắng trước đó và dừng lại khi gặp khoảng trắng. Sau khi đọc con trỏ chỉ ngay kí tự tiếp theo không phải là một phần của số nguyên.
//Khi sử dụng nextLine() ngay sau nextInt() phải xử lý dòng trống còn lại bằng 1 lệnh scaner.nextLine() trước đó.
//scanner.hasNext()/.hasNextLine()/hasNextInt/.hasNextDouble: Kiểm tra loại dữ liệu tiếp theo

public class ScannerInJava {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        System.out.print("Nhap day so: ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner = new Scanner(data);
        scanner.useDelimiter("[,; ]+"); //Đặt lại các dấu ',' và ';' thành khoảng trắng

        //Kiểm tra xem còn token nào tiếp theo không
        while (scanner.hasNext()) {
            //Bỏ qua dữ liệu không phải là số
            if(!scanner.hasNextInt()) {
                //Đọc từ một từ tiếp theo trong luồng đầu vào và sẽ bỏ qua các khoảng trắng, tab, xuống dòng trước và sau nó. Dừng lại khi gặp khoảng trắng, tab, xuống dòng và đặt con trỏ tại token ngay sau các dấu phân cách.
                scanner.next();
                continue;
            }
            //Đọc số nguyên và bỏ qua khoảng trắng trước đó và dừng lại khi gặp khoảng trắng. Sau khi đọc con trỏ chỉ ngay kí tự tiếp theo không phải là một phần của số nguyên.
            int key = scanner.nextInt();
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        scanner.close();

        TreeMap<Integer,Integer> clonedMap = new TreeMap<>();
        clonedMap.putAll(map);
        System.out.println("Type 1:");
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
        
        System.out.println("Type 2:");
        for (int key : map.keySet()) {
            for(int i = 0; i < map.get(key); i++) {
                System.out.print(key+ " ");
            }
            System.out.println();
        }
    }
}