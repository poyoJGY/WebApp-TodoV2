package me.jgy.service;

import lombok.extern.log4j.Log4j2;
import me.jgy.w2.dto.TodoDTO;
import me.jgy.w2.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws SQLException {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("JDBC Test Title")
                .dueDate(LocalDate.now())
                .build();

        log.info("---------------------------"); // 테스트 코드의 Log4j2 설정 확인
        log.info(todoDTO);

        todoService.register(todoDTO);
    }
}
