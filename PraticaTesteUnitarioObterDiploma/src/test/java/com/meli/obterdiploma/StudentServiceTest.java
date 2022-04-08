package com.meli.obterdiploma;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.StudentDAO;
import com.meli.obterdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;

    @Mock
    StudentDTO studentDTO = new StudentDTO();;
    @InjectMocks
    SubjectDTO subjectDTO = new SubjectDTO();
    @InjectMocks
    SubjectDTO subjectDTO2 = new SubjectDTO();;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        subjectDTO.setName("Matematica");
        subjectDTO2.setName("Portugues");
        subjectDTO.setScore(10.0);
        subjectDTO2.setScore(9.0);
        studentDTO.setId(1L);
        studentDTO.setStudentName("Aaa");
        studentDTO.setSubjects(Arrays.asList(subjectDTO, subjectDTO2));
    }

    @Test
    public void testIfStudentCanBeSaved(){
        Mockito.doNothing().when(studentDAO).save(studentDTO);
        Mockito.verify(studentDTO).getId();
    }
}
