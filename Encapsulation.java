import java.util.LinkedList;
import java.util.Random;
//public: Không giới hạn phạm vi truy cập.
//private: Không thể truy cập từ bất kì lớp nào khác.
//protected: Chỉ được truy cập từ các lớp cùng gói và tất cả các lớp con (kể cả khác gói).
//default: Chỉ được truy cập từ các lớp trong cùng 1 gói.
//static variable: Biến dùng cho tất cả đối tượng trong lớp có thể gọi trực tiếp mà không cần khởi tạo đối tượng. Thường được dùng để tạo các hằng số hoặc đếm số lượng các đối tượng được tạo.
//static method: Có thể gọi trực tiếp mà không cần khởi tạo đối tượng. Không thể sự dụng các từ khoá như this và supper, không thể ghi đè.
//static block: Được thực thi 1 lần duy nhất khi lớp được tải.



class NhanVien {
    private String tenNhanVien;
    private double heSoLuong;
    private double luongCoBan = 750000;
    public final double LUONG_MAX = 20000000;
    static int count = 0;

    public NhanVien(String tenNhanVien, double heSoLuong) {
        this.tenNhanVien = tenNhanVien;
        this.heSoLuong = heSoLuong;
        count ++;
    }
    

    static {
        System.out.println("This static block is executed automatically when the class NhanVien is loaded");
    }

    public boolean tangLuong(double heSo) {
        if ((heSoLuong + heSo) * luongCoBan < LUONG_MAX) {
            this.heSoLuong += heSo;
            System.out.println("salary increase successful");
            return true;
        }
        System.out.println("salary increase failed");
        return false;
    }

    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }

    public void inTTin() {
        System.out.print("Employee name: " + tenNhanVien);
        System.out.print(", salary coeficient: " + heSoLuong);
        System.out.printf(", salary: %.0f %s", tinhLuong(), "VND\n");
    }
}

class PhongBan {
    private String tenPhongBan;
    private byte soNhanVien;
    public int SO_NV_MAX = 100;
    private LinkedList<NhanVien> nhanVien = new LinkedList<>();

    public PhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public boolean themNV(NhanVien nv) {
        if (soNhanVien < SO_NV_MAX) {
            nhanVien.add(nv);
            soNhanVien++;
            return true;
        }
        return false;
    }

    public NhanVien xoaNV() {
        if (soNhanVien > 0) {
            soNhanVien--;
            return nhanVien.removeLast();
        }
        return null;
    }

    public double tongLuong() {
        double sum = 0;
        for (NhanVien nv : nhanVien) {
            sum += nv.tinhLuong();
        }
        return sum;
    }

    public void inTTin() {
        System.out.println("Department name: " + tenPhongBan);
        System.out.println("Number off employee: " + soNhanVien);
        System.out.println("Employee list:");
        for (NhanVien nv : nhanVien) {
            nv.inTTin();
        }
        System.out.printf("Total salary: %.0f VND\n", tongLuong());
    }
}

public class Encapsulation {
    //JVM tự động tìm và thực thi phương thức Encapsulation.main() ngay sau khi chạy chương trình
    public static void main(String[] args) {
        Random random = new Random();
        PhongBan pb = new PhongBan("HR");
        for (int i = 0; i < 10; i++) {
            String ten = "NV" + (i + 1);
            NhanVien nv = new NhanVien(ten, 5 + Math.round(random.nextInt(50))/10.0);
            pb.themNV(nv);
        }
        System.out.println("Number off NhanVien initialized: " + NhanVien.count); //Không cần tạo đối tượng
        pb.inTTin();
    }
}
