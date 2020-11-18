package registration;
import java.util.ArrayList;

/**
 * represnts a list of courses offered to students
 * @author Nicho
 *
 */
public class CourseCatalogue {
	
	private ArrayList <Course> courseList;
	
	public CourseCatalogue () {
		loadFromDataBase();
	}
	
	@SuppressWarnings("unchecked")
	private void loadFromDataBase() {
		// TODO Auto-generated method stub
		DBManager db = new DBManager();
		setCourseList(db.readFromDataBase());
	}
	
	/**
	 * adds course to the catalog
	 * @param c
	 * @param secNum
	 * @param secCap
	 */
	public void createCourseOffering (Course c, int secNum, int secCap) {
		if (c!= null) {
			CourseOffering theOffering = new CourseOffering (secNum, secCap);
			c.addOffering(theOffering);
		}
	}
	
	/**
	 * searches coursecatalog for a course
	 * @param courseName
	 * @param courseNum
	 * @return
	 */
	public Course searchCat (String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) &&
					courseNum == c.getCourseNum()) {
				return c;
			}	
		}
		displayCourseNotFoundError();
		return null;
	}
	//Typically, methods that are called from other methods of the class
	//are private and are not exposed for use by other classes.
	//These methods are refereed to as helper methods or utility methods
	private void displayCourseNotFoundError() {
		// TODO Auto-generated method stub
		System.err.println("Course was not found!");
		
	}
	public ArrayList <Course> getCourseList() {
		return courseList;
	}


	public void setCourseList(ArrayList <Course> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString () {
		String st = "All courses in the catalogue: \n";
		for (Course c : courseList) {
			st += c;  //This line invokes the toString() method of Course
			st += "\n";
		}
		st += "\0";
		return st;
	}

}