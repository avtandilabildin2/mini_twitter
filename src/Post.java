public class Post extends MiniTwitterApplication {
    int id;
    String date;
    String tema;
    String text;
    String tags;

    public Post(int id, String date,  String tags, String tema, String text) {
        this.id = id;
        this.date = date;
        this.tags = tags;
        this.tema = tema;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + pribor+ '\'' +
                    ", date='" + date + '\'' +
                    ", tema='" + tema + '\'' +
                    ", text='" + text + '\'' +
                    ", tags='" + tags + '\'' +
                    '}';
    }

}
