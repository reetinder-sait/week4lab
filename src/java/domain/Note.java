
package domain;

public class Note {

    private String title;
    private String content;

    public Note() {
        this.title = "";
        this.content = "";
    }
    public Note(String title, String contents) {
        this.title = title;
        this.content = contents;
    }
    public String getTitle() {
        return title;
    }
    
    public String getContent() {
        return content;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
