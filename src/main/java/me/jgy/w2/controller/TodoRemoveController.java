package me.jgy.w2.controller;

import lombok.extern.log4j.Log4j2;
import me.jgy.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "todoRemoveController", value = "/todo/remove")
@Log4j2
public class TodoRemoveController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long tno = Long.parseLong(req.getParameter("tno"));
        log.info("tno: " + tno);

        try {
            todoService.remove(tno);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ServletException("read error");
        }

        resp.sendRedirect("/todo/list");
    }
}
