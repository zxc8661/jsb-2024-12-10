package  com.mysql.sbb.question;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import com.mysql.sbb.DataNotFoundException;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class QuestionService{
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> oq = this.questionRepository.findById(id);
        if(oq.isPresent()){
            return oq.get();
        }else {
            throw new DataNotFoundException("question not found");
        }
    }
}