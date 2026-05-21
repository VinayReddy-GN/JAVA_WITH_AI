package com.student;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {

                // ── LIST ──────────────────────────────
                case "list": {
                    List<Student> students = null;
					try {
						students = dao.getAllStudents();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("/student-list.jsp").forward(req, res);
                    break;
                }

                // ── SHOW ADD FORM ─────────────────────
                case "new":
                    req.getRequestDispatcher("/student-form.jsp").forward(req, res);
                    break;

                // ── SHOW EDIT FORM ────────────────────
                case "edit": {
                    int id = Integer.parseInt(req.getParameter("id"));
                    Student s = null;
					try {
						s = dao.getStudentById(id);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    req.setAttribute("student", s);
                    req.getRequestDispatcher("/student-form.jsp").forward(req, res);
                    break;
                }

                // ── DELETE ────────────────────────────
                case "delete": {
                    int id = Integer.parseInt(req.getParameter("id"));
                    try {
						dao.deleteStudent(id);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    res.sendRedirect("student?action=list");
                    break;
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req,
                           HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        String name   = req.getParameter("name").trim();
        String email  = req.getParameter("email").trim();
        double marks  = Double.parseDouble(req.getParameter("marks"));

        try {
            if ("insert".equals(action)) {
                // ── CREATE ────────────────────────────
                try {
					dao.insertStudent(new Student(0, name, email, marks));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            } else if ("update".equals(action)) {
                // ── UPDATE ────────────────────────────
                int id = Integer.parseInt(req.getParameter("id"));
                try {
					dao.updateStudent(new Student(id, name, email, marks));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            res.sendRedirect("student?action=list");

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}