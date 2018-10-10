package controller;

import beans.BeanOfSession;
import beans.BeanOfURL;
import model.MyModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mycontroller")
public class MyController extends HttpServlet {
    MyModel myModel = new MyModel();

    /*
    1) В зависимости от состояния сессии forward`им на разные jsp
    2) В зависимости от нажатой кнопки создаем разные бины фотографий, обновляем состояние сессии

     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BeanOfSession beenOfSession = (BeanOfSession) req.getSession().getAttribute("beanOfSession");
        BeanOfURL beenOfURL;
        if (beenOfSession != null) {
            if (beenOfSession.getNumber() == 1) {
                if (req.getParameter("no") != null) {
                    beenOfURL = myModel.getBeenOfUrlIfNo(beenOfSession);
                    req.setAttribute("BeanOfUrl", beenOfURL);
                    beenOfSession = myModel.getBeenOfSession(beenOfSession, beenOfURL);
                }
                if (req.getParameter("yes") != null){
                    beenOfURL = myModel.getBeenOfUrlIfYes(beenOfSession);
                    req.setAttribute("BeanOfUrl", beenOfURL);
                    beenOfSession = myModel.getBeenOfSession(beenOfSession, beenOfURL);
                }

                req.getSession().setAttribute("beanOfSession", beenOfSession);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(req, resp);
            }
            if (beenOfSession.getNumber() == 2){
                req.getSession().setAttribute("beanOfSession", beenOfSession);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/result.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
        else {
            beenOfURL = myModel.getFirstBeenOfUrlOnSession();
            req.setAttribute("BeanOfUrl", beenOfURL);

            beenOfSession = myModel.getBeenOfSession(beenOfSession, beenOfURL);
            req.getSession().setAttribute("beanOfSession", beenOfSession);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
