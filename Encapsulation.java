import java.util.LinkedList;
import java.util.Random;
//Tinh trừu tượng Là quá trình loại bỏ đi các thông tin ít quan trọng và giữ lại những thông tin quan trọng, có ý nghĩa.
//Tính đóng gói là việc che giấu thông tin và hành vi bên trong đối tượng, chỉ tiết lộ những gì cần thiết và quy định cách truy cập thông qua các phương thức công khai.

//public: Không giới hạn phạm vi truy cập.
//private: Không thể truy cập từ bất kì lớp nào khác.
//protected: Chỉ được truy cập từ các lớp cùng gói và tất cả các lớp con (kể cả khác gói).
//default: Chỉ được truy cập từ các lớp trong cùng 1 gói.

class NhanVien {
    private String tenNhanVien;
    private double heSoLuong;
    private double luongCoBan = 750000;
    public final double LUONG_MAX = 20000000;

    //Phương thức khởi tạo(Constructor): Được gọi tự động khi một đối tượng được tạo ra
    public NhanVien(String tenNhanVien, double heSoLuong) {
        this.tenNhanVien = tenNhanVien;
        this.heSoLuong = heSoLuong;
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
        pb.inTTin();
    }
}
