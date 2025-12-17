package me.jgy.dao;

import me.jgy.w2.dao.TodoDAO;
import me.jgy.w2.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws SQLException {
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws SQLException {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws SQLException {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws SQLException {

        Long tno = 2L;

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);
    }

    @Test
    public void testUpdateOne() throws SQLException {
        TodoVO todoVO = TodoVO.builder()
                .tno(2L)
                .title("Sample Title....")
                .dueDate(LocalDate.of(2021, 12, 31))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }
}
