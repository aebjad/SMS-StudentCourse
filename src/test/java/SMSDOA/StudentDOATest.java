package SMSDOA;

import jpa.entitymodels.Student;
import jpa.service.StudentService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

public class StudentDOATest {

    private static StudentService studentService;

    @BeforeClass
    public static void beforeAll(){
        // create a new instance of student service class to be tested
        studentService = new StudentService();

    }

    @Test
    public void getStudentByEmailTest(){
        Student student = studentService.getStudentByEmail("aiannitti7@is.gd");
        Assert.assertEquals("Checks if can get a student using his/her email: ", student.getsName(),"Alexandra Iannitti");

    }

    @Test
    public void getStudentByEmailTest2(){
        Student student = studentService.getStudentByEmail("qllorens2@howstuffworks.com");
        Assert.assertEquals("Checks if can get a student using his/her email: ",student.getsName(),"Quillan Llorens");

    }

    @Test
    public void getAllStudentsTest(){
        List<Student> allStudents = studentService.getAllStudents();
        Assert.assertEquals(allStudents.size(), 10);
    }

    @Test
    public void validateStudentTest() {
        Boolean student = studentService.validateStudent("aiannitti7@is.gd", "TWP4hf5j");
        Assert.assertTrue(student);
    }

}
