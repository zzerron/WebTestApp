package beans;

/*
Данный класс соответствует фотографиям которые необходимо показать.
их id в базе, их url в файловой системе или в другом месте, и number - последняя это фотография или нет.
 */
public class BeanOfURL {
    private String urlOfImg;
    private int numberOfImg;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlOfImg() {
        return urlOfImg;
    }

    public void setUrlOfImg(String urlOfImg) {
        this.urlOfImg = urlOfImg;
    }

    public int getNumberOfImg() {
        return numberOfImg;
    }

    public void setNumberOfImg(int numberOfImg) {
        this.numberOfImg = numberOfImg;
    }
}
