/**
 * @Description: lớp mô tả các Khóa học 
  * @Author: Tran Duy Bao
 * @Version: 1.0
 * @Created:02-Sep-2025 06:07:00 PM
 */
package iuh_cntt_khmt;

public class Course {
	  private String id;
	    private String title;
	    private String department;
	    private int credit;

	    public Course(String id, String title, String department, int credit) {
	        setId(id);
	        setTitle(title);
	        setDepartment(department);
	        setCredit(credit);
	    }

	    // ================== Getter / Setter có kiểm tra ==================
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        if (id == null || id.trim().length() < 3) {
	            throw new IllegalArgumentException("ID must have at least 3 characters");
	        }
	        if (!id.matches("[a-zA-Z0-9]+")) {
	            throw new IllegalArgumentException("ID must contain only letters or digits");
	        }
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        if (title == null || title.trim().isEmpty()) {
	            throw new IllegalArgumentException("Title must not be empty");
	        }
	        this.title = title;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    public void setDepartment(String department) {
	        if (department == null || department.trim().isEmpty()) {
	            department = "Unknown"; // cho mặc định
	        }
	        this.department = department;
	    }

	    public int getCredit() {
	        return credit;
	    }

	    public void setCredit(int credit) {
	        if (credit <= 0) {
	            throw new IllegalArgumentException("Credit must be greater than 0");
	        }
	        this.credit = credit;
	    }

	    // ================== Hiển thị ==================
	    @Override
	    public String toString() {
	        return String.format("Course[id=%s, title=%s, dept=%s, credit=%d]",
	                id, title, department, credit);
	    }
}
