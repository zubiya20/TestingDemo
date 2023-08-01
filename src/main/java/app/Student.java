package app;

public class Student {
	
	int marks;
	
	public Student(int marks)
	{
		this.marks=marks;
	}
	
	public String printGrade()
	{
		if(marks<=40)
			return "D";
		else if(41<=marks && marks<=60)
			return "c";
		else if(61<=marks && marks<=80)
			return "B";
		else
			return "A";
	}

}
