/**
 * @Description: TODO
  * @Author: Tran Duy Bao
 * @Version: 1.0
 * @Created:02-Sep-2025 07:40:00 PM
 */
package iuh_cntt_khmt;
import java.util.*;

public class TestCourse {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList list = new CourseList(100);

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm khóa học");
            System.out.println("2. Hiển thị tất cả khóa học");
            System.out.println("3. Xóa khóa học theo mã");
            System.out.println("4. Tìm khóa học theo mã");
            System.out.println("5. Tìm khóa học theo tên");
            System.out.println("6. Tìm khóa học theo khoa");
            System.out.println("7. Sắp xếp khóa học theo tên");
            System.out.println("8. Tìm khóa học có số tín chỉ lớn nhất");
            System.out.println("9. Tìm khoa có nhiều khóa học nhất");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Nhập ID: ");
                        String id = sc.nextLine();
                        System.out.print("Nhập tên khóa học: ");
                        String title = sc.nextLine();
                        System.out.print("Nhập số tín chỉ: ");
                        int credit = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nhập khoa phụ trách: ");
                        String dept = sc.nextLine();
                        Course c = new Course(id, title, dept, credit);
                        list.addCourse(c);
                    } catch (Exception e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                }
                case 2 -> list.printCourses(list.getCourses());
                case 3 -> {
                    System.out.print("Nhập ID cần xóa: ");
                    String id = sc.nextLine();
                    if (list.removeCourse(id)) System.out.println("Xóa thành công!");
                }
                case 4 -> {
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    Course c = list.searchCourseById(id);
                    if (c != null) System.out.println(c);
                    else System.out.println("Không tìm thấy!");
                }
                case 5 -> {
                    System.out.print("Nhập từ khóa tên: ");
                    String key = sc.nextLine();
                    list.printCourses(list.searchCourseByTitle(key));
                }
                case 6 -> {
                    System.out.print("Nhập tên khoa: ");
                    String dept = sc.nextLine();
                    list.printCourses(list.searchCourseByDepartment(dept));
                }
                case 7 -> list.printCourses(list.sortCoursesByTitle());
                case 8 -> list.printCourses(list.findMaxCreditCourses());
                case 9 -> System.out.println("Khoa có nhiều khóa học nhất: " + list.findDepartmentWithMostCourses());
                case 0 -> System.out.println("Thoát chương trình!");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        sc.close();
    }
}
