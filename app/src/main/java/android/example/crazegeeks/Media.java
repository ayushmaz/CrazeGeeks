package android.example.crazegeeks;

public class Media {
    private String heading;
    private String content;

    Media(String heading, String content) {
        this.heading = heading;
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public String getHeading() {
        return heading;
    }
}
