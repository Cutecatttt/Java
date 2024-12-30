import java.util.LinkedList;
//Tính kế thừa cho phép bạn tạo ra các lớp mới bằng cách sử dụng thông tin và hành vi từ các lớp đã tồn tại.
//Tính đa hình cho phép bạn thực hiện cùng một hành động trên các đối tượng khác nhau mà không cần quan tâm đến loại đối tượng cụ thể.

//super: Biến tham chiếu đến lớp cha gần nhất
//super(): Gọi trực tiếp contructor của lớp cha
//this: Biến tham chiếu đến đối tượng hiện tại
//this(): Goi contructor của lớp hiện tại - chỉ được khai báo ở dòng lệnh đầu kiên của contructor

//final variable: Hằng số không thể thay đổi
//final method: Phương thức không thể bị ghi đè
//final class: Lớp không thể được kế thừa

//static variable: Biến dùng cho tất cả đối tượng trong lớp có thể gọi trực tiếp mà không cần khởi tạo đối tượng. Thường được dùng để tạo các hằng số hoặc đếm số lượng các đối tượng được tạo.
//static method: Có thể gọi trực tiếp mà không cần khởi tạo đối tượng. Không thể sự dụng các từ khoá như this và supper, không thể bị ghi đè.
//static block: Được thực thi 1 lần duy nhất khi lớp được tải, nó được thực thi trước cả phương thức main và contuctor lúc tải lớp.
//Các thuộc tính static được cung cấp 1 vùng nhớ cố định

//Lớp trừu tượng - không thể tạo đối tượng
abstract class Animal {
    protected String name;
    //Phương thức trừu tượng phải trong 1 lớp trừu tượng, lớp con phải ghi đề tất cả phương thức trừu tượng của lớp cha.
    public abstract void getInfo();
}

//Lớp Human kế thừa từ lớp animal
class Human extends Animal {
    Human (String name) {
        this.name = name;
    }
    public void getInfo() {
        System.out.println("Name: " + name);
    }
  
    //Phương thức không thể ghi đè từ lớp con
    public final void display() {
        System.out.println("This is a final method");
    }
}

//Lớp Studen kế thừa từ lớp Human
class Student extends Human {
    private String mssv;
    static int count = 0;

    Student(String name, String mssv) {
        //Gọi trực tiếp contructor của lớp cha
        super(name);
        this.mssv = mssv;
        count++;
    }
    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("MSSV: " + mssv);
    }
    //Static block được thực thi duy nhất 1 lần khi lớp được tải
    static {
        System.out.println("This static block is executed automatically and only when the class Student is loaded");
    }
}

//Lớp Clazz kết tập từ Student
class Clazz {
    private LinkedList<Student> a = new LinkedList<>();
    public void addStudent(Student student) {
        a.add(student);
        System.out.println("Student " + student.name + " has been added to the class.");
    }
    public void remoteStudent(Student student) {
        if(a.contains(student)) {
            a.remove(student);
            System.out.println("Student " + student.name + " has been removed to the class.");
        } else {
            System.out.println("There is no student " + student.name + " in the class.");
        }
    }
    public void getInfo() {
        for(int i = 0; i < a.size(); i++) {
            a.get(i).getInfo();
        }
    }
    //Anonymous block được thực thi đầu tiên mỗi khi lớp được khởi tạo
    static {
        System.out.println("This anonymous block is executed automatically when the class Clazz is loaded");
    }
}

public class Inheritance {
        public static void main(String[] args) {
            //Lớp Integer được kế thừa từ lớp Object nên đã có phương thức equals
            Integer i1 = new Integer(47);
            Integer i2 = new Integer(47);
            //Toán tử == kiểm tra xem hai đối tượng có đồng nhất hay không
            System.out.println(i1 == i2);
            //Phương thức equals kiểm tra xem hai đối tượng có giống nhau hay không
            System.out.println(i1.equals(i2));
            
            Human human1 = new Human("XXXX XXXX");
            human1.getInfo();
            Human human2 = new Human("XXXX XXXX");
            human1.getInfo();
            System.out.println(human1.equals(human2));

            Student student1 = new Student("Nguyen Van A", "20231111");
            student1.getInfo();
            Student student2 = new Student("Nguyen Van B", "20232222");
            Student student3 = new Student("Nguyen Van C", "20233333");
            Student student4 = new Student("Nguyen Van D", "20234444");
            Student student5 = new Student("Nguyen Van E", "20235555");
            System.out.println("Number off Student initialized: " + Student.count); //Không cần tạo đối tượng
            Clazz clazz = new Clazz();
            clazz.addStudent(student1);
            clazz.addStudent(student2);
            clazz.addStudent(student3);
            clazz.addStudent(student4);
            clazz.remoteStudent(student3);
            clazz.remoteStudent(student5);
            clazz.getInfo();
        }
}