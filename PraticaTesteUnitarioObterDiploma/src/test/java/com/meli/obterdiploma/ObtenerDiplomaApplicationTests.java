package com.meli.obterdiploma;
import com.meli.obterdiploma.exception.StudentNotFoundException;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.service.ObterDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ObetenerDiplomaApplicationTests {

	@Mock
	private IStudentDAO studentDAO;

	@InjectMocks
	private ObterDiplomaService obterDiplomaService;

	@InjectMocks
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
		studentDTO.setId(1L);
		studentDTO.setStudentName("Aaa");
		studentDTO.setSubjects(Arrays.asList(subjectDTO, subjectDTO2));
	}

	@Test
	public void testWhenStudentIdIsFound(){
		subjectDTO.setScore(10.0);
		subjectDTO2.setScore(6.0);

		Mockito.when(studentDAO.findById(any())).thenReturn(studentDTO);
		StudentDTO studentDTO1 = obterDiplomaService.analyzeScores(1L);

		assertEquals("Aaa", studentDTO1.getStudentName());
		assertEquals(8, studentDTO1.getAverageScore());
		assertEquals("O aluno Aaa obteve uma média de 8. Você pode melhorar.", studentDTO1.getMessage());
	}

	@Test
	public void testWhenStudentIdIsNotFound(){

		Mockito.when(studentDAO.findById(any())).thenThrow(new StudentNotFoundException(3L));
		try {
			obterDiplomaService.analyzeScores(3L);
			fail("Exception not thrown");
		} catch (StudentNotFoundException e) {
			assertEquals("O aluno com Id 3 não está registrado.", e.getError().getDescription());
		}
	}


	@Test
	public void testWhenAverageAbove9(){
		subjectDTO.setScore(10.0);
		subjectDTO2.setScore(9.0);

		Mockito.when(studentDAO.findById(any())).thenReturn(studentDTO);
		StudentDTO studentDTO1 = obterDiplomaService.analyzeScores(1L);

		assertEquals(9.5, studentDTO1.getAverageScore());
		assertEquals("O aluno Aaa obteve uma média de 9,5. Parabéns!", studentDTO1.getMessage());
	}

	@Test
	public void testWhenAverageEquals9(){
		subjectDTO.setScore(9.0);
		subjectDTO2.setScore(9.0);

		Mockito.when(studentDAO.findById(any())).thenReturn(studentDTO);
		StudentDTO studentDTO1 = obterDiplomaService.analyzeScores(1L);

		assertEquals(9, studentDTO1.getAverageScore());
		assertEquals("O aluno Aaa obteve uma média de 9. Você pode melhorar.", studentDTO1.getMessage());
	}

	@Test
	public void testWhenAverageBelow9(){
		subjectDTO.setScore(8.0);
		subjectDTO2.setScore(7.0);

		Mockito.when(studentDAO.findById(any())).thenReturn(studentDTO);
		StudentDTO studentDTO1 = obterDiplomaService.analyzeScores(1L);

		assertEquals(7.5, studentDTO1.getAverageScore());
		assertEquals("O aluno Aaa obteve uma média de 7,5. Você pode melhorar.", studentDTO1.getMessage());
	}


}