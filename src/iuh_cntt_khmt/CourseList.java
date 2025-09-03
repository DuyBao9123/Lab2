/**
 * @Description: TODO
  * @Author: Tran Duy Bao
 * @Version: 1.0
 * @Created:02-Sep-2025 07:00:00 PM
 */
package iuh_cntt_khmt;

import java.util.*;

public class CourseList {
	 private List<Course> courses;

	    public CourseList(int capacity) {
	    	if (capacity <= 0) {
	            throw new IllegalArgumentException("Length of the array must be greater than 0");
	        }
	        courses = new ArrayList<>(capacity);
	    }

	    public CourseList() {
	        courses = new ArrayList<>();
	    }

	    // ================== Thêm / Xóa ==================
	    public void addCourse(Course c) {
	        courses.add(c);
	    }

	    public boolean removeCourse(String id) {
	        return courses.removeIf(c -> c.getId().equalsIgnoreCase(id));
	    }

	    public List<Course> getCourses() {
	        return courses;
	    }

	    public void printCourses(List<Course> courses) {
	        if (courses == null || courses.isEmpty()) {
	            System.out.println("Danh sách rỗng!");
	            return;
	        }
	        for (Course c : courses) {
	            System.out.println(c);
	        }
	    }

	    // ================== Các hàm tìm kiếm ==================
	    public Course searchCourseById(String id) {
	        for (Course c : courses) {
	            if (c.getId().equalsIgnoreCase(id)) {
	                return c;
	            }
	        }
	        return null;
	    }

	    public List<Course> searchCourseByTitle(String title) {
	        List<Course> result = new ArrayList<>();
	        for (Course c : courses) {
	            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
	                result.add(c);
	            }
	        }
	        return result;
	    }

	    public List<Course> searchCourseByDepartment(String department) {
	        List<Course> result = new ArrayList<>();
	        for (Course c : courses) {
	            if (c.getDepartment().equalsIgnoreCase(department)) {
	                result.add(c);
	            }
	        }
	        return result;
	    }

	    // ================== Sắp xếp ==================
	    public List<Course> sortCoursesByTitle() {
	        courses.sort(Comparator.comparing(Course::getTitle, String.CASE_INSENSITIVE_ORDER));
	        return courses;
	    }

	    // ================== Tìm môn nhiều tín chỉ nhất ==================
	    public List<Course> findMaxCreditCourses() {
	        List<Course> result = new ArrayList<>();
	        if (courses.isEmpty()) return result;

	        int maxCredit = courses.stream().mapToInt(Course::getCredit).max().orElse(0);
	        for (Course c : courses) {
	            if (c.getCredit() == maxCredit) {
	                result.add(c);
	            }
	        }
	        return result;
	    }

	    // ================== Tìm khoa có nhiều môn nhất ==================
	    public String findDepartmentWithMostCourses() {
	        if (courses.isEmpty()) return null;

	        Map<String, Integer> countMap = new HashMap<>();
	        for (Course c : courses) {
	            countMap.put(c.getDepartment(), countMap.getOrDefault(c.getDepartment(), 0) + 1);
	        }

	        String maxDept = null;
	        int maxCount = 0;
	        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
	            if (entry.getValue() > maxCount) {
	                maxDept = entry.getKey();
	                maxCount = entry.getValue();
	            }
	        }
	        return maxDept;
	    }
    }
