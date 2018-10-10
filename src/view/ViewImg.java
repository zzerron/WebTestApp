package view;

import beans.BeanOfURL;
import connection.ConnectionUtils;
import controller.MyController;
import utils.DBUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/images/*")
public class ViewImg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageName = req.getPathInfo().substring(1);
        System.out.println(imageName);
        try (Connection connection = ConnectionUtils.getConnection()){
            if (imageName.equals("0"))
                imageName = "1";
            BeanOfURL beenOfURL = DBUtils.findURLOfImage(connection, imageName);
            System.out.println(beenOfURL.getId() + " " + beenOfURL.getUrlOfImg() + " " + beenOfURL.getNumberOfImg());

            String imgurl = beenOfURL.getUrlOfImg();
            BufferedImage bImage = ImageIO.read(new File(imgurl));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            byte[] content = bos.toByteArray();
            resp.setContentType(getServletContext().getMimeType(imgurl));
            resp.setContentLength(content.length);
            OutputStream ous = resp.getOutputStream();
            BufferedOutputStream bus = new BufferedOutputStream(ous);
            bus.write(content);

            bos.close();
            ous.close();
            bus.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
