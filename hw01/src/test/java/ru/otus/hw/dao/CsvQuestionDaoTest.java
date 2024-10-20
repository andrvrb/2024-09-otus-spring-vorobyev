package ru.otus.hw.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

import java.util.ArrayList;
import java.util.List;

class CsvQuestionDaoTest {

    @Test
    void readCardQuestionTest(){
        TestFileNameProvider fileNameProvider = () -> "questionsTest.csv";
        QuestionDao dao = new CsvQuestionDao(fileNameProvider);

        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Science doesn't know this yet", true));
        answerList.add(new Answer("Certainly. The red UFO is from Mars. And green is from Venus", false));
        answerList.add(new Answer("Absolutely not", false));
        Question expectedQuestion = new Question("Is there life on Mars?", answerList);
        var testQuestion = dao.findAll().get(0);

        Assertions.assertEquals(expectedQuestion.text(), testQuestion.text());
        Assertions.assertEquals(expectedQuestion.answers(), testQuestion.answers());
    }

}