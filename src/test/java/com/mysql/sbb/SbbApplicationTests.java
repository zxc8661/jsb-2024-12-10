package com.mysql.sbb;


import com.mysql.sbb.answer.Answer;
import com.mysql.sbb.answer.AnswerRepository;
import com.mysql.sbb.question.Question;
import com.mysql.sbb.question.QuestionRepository;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SbbApplicationTests{

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	public void testjpa() {
		Question q = this.questionRepository.findBySubjectAndContent("sbb 가 무엇인지 알고 싶어요","sbb에 대해서 알고 싶습니다.");
		assertEquals(1,q.getId());
	}

	@Test
	public void test(){
		List<Question> o= this.questionRepository.findByCreateDateLessThan(LocalDateTime.now());
		assertEquals(1,o.get(0).getId());
	}

	@Test
	public void test2(){
		List<Question> list = this.questionRepository.findBySubjectLike("%무엇%");
		assertEquals(1,list.get(0).getId());
	}

	@Test
	public void test3(){
		Optional<Question> q = this.questionRepository.findById(1);
		assertTrue(q.isPresent());
		Question qu = q.get();
		qu.setSubject("수정된 제목");
		this.questionRepository.save(qu);

		Optional<Question> o = this.questionRepository.findById(1);
		if(o.isPresent()){
			Question q2 =o.get();
			assertEquals("수정된 제목", q2.getSubject());
		}
	}
	@Test
	public void test4(){
		assertEquals(2,this.questionRepository.count());
		Optional<Question> o = this.questionRepository.findById(1);
		assertTrue(o.isPresent());
		Question q = o.get();
		this.questionRepository.delete(q);
		assertEquals(1,this.questionRepository.count());
	}

	@Test
	public void test5(){
		Optional<Question> op = this.questionRepository.findById(2);
		assertTrue(op.isPresent());
		Question q = op.get();

		Answer a = new Answer();
		a.setQuestion(q);
		a.setContent("네 자동으로 생성됩니다.");
		a.setCreatedDate(LocalDateTime.now());
		this.answerRepository.save(a);
	}

	@Test
	public void test6(){
		Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a= oa.get();
		assertEquals(2,a.getQuestion().getId());
	}

	@Transactional
	@Test
	public void test7(){
		Optional <Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> aList = q.getAnswerList();

		assertEquals(1,aList.size());
		assertEquals("네 자동으로 생성됩니다.",aList.get(0).getContent());
	}
}
