import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;


/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(this.students==null)
		{
			throw new IllegalArgumentException("IllegalArgument");
		}	
		this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index < 0 || index>=this.students.length)
		{
			throw new IllegalArgumentException("IllegalArgument");
		}
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		this.getStudents()[index] = student;
		if(this.students==null)
		{
			throw new IllegalArgumentException("IllegalArgument");
		}
		if(index < 0 || index>=this.students.length)
		{
			throw new IllegalArgumentException("IllegalArgument");
		}
		
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		Student[] s1 = new Student[this.students.length+1];
		 s1[0] = student;
		 for(int i = 1; i< s1.length; i++)
			 s1[i] = this.students[i-1];
		this.students = s1;
		if(this.students==null)
		{
			throw new IllegalArgumentException("IllegalArgument");
		}
		
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		Student[] s1 = new Student[this.getStudents().length+1];
		 for(int i = 0; i < this.students.length; i++)
			 s1[i] = this.students[i];
		 s1[s1.length - 1] = student;
		 this.students = s1;
		if(this.students==null)
		{
			throw new IllegalArgumentException("IllegalArgument");
		}
		
	}

	@Override
	public void add(Student student, int index) {
	
	Student[] s1 = new Student[this.students.length+1];
		 for(int i = 0; i < index; i++)
			 s1[i] = this.students[i];
		 s1[index] = student;
		 for(int i = index; i < this.students.length; i++)
			 s1[i+1] = this.students[i];
		 this.students = s1;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		Student[] s1 = new Student[this.getStudents().length+1];
		int count=0;
		for(int i = 0; i < this.students.length; i++)
			 if(i != index) s1[count++] = this.students[i];
		 this.students = s1;
		if(index < 0 || index>=this.students.length)
		{
			throw new IllegalArgumentException("IllegalArgument");
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		Student[] s1 = new Student[this.students.length-1]; 
		 int count = 0;
		 for(int i = 0; i < this.students.length; i++)
			 if(this.students[i] != student) s1[count++] = this.students[i];
		 this.students = s1;
		
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		Student[] s1 = new Student[index]; 
		 for(int i = 0; i < index; i++)
			 s1[i] = this.students[i];
		 this.students = s1; 
		 if(index < 0 || index>=this.students.length)
		{
			throw new IllegalArgumentException("IllegalArgument");
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		Student[] s1 = new Student[this.students.length-index]; 
		 int count = 0;
		 for(int i = index; i < this.students.length; i++)
			 s1[i-index] = this.students[i];
		 this.students = s1;
		 if(this.students==null)
		 {
			 throw new IllegalArgumentException("IllegalArgument");
		 }
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		
		for(int i = 0; i < this.students.length; i++)
		  {
	          for(int j = 0; j < this.students.length-i-1; j++)
			  {
                   if(this.students[j].getId() > this.students[j+1].getId())
				   {
					   Student s1 = this.students[j];
					   this.students[j] = this.students[j+1];
					   this.students[j+1] = s1;
				   }
			  }	   
		  }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		ArrayList<Student> s1 = new ArrayList<>();
		   for(Student s : this.students)
		   {
		       if(s.getBirthDate().compareTo(date) == 0)
				   s1.add(s);
		   }
		   if(date==null)
		   {
			   throw new IllegalArgumentException("IllegalArgument");
		   }
		   return  s1.toArray(new Student[s1.size()]);
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		
		this.bubbleSort();
		int i;
		   for( i = 0; i < this.students.length; i++)
			   if(this.students[i].equals(student)) break;
		   if(this.students==null)
		   {
			   throw new IllegalArgumentException("IllegalArgument");
		   }
		   return this.students[i+1];
	}
}
