public class Note{
    private String title ;
    private String content;

    public Note(String title , String content){
        this.title = title ; 
        this.content = content;
    }
    
    @Override
    public String toString(){
        return "Title: " + title + "\n" + "Content: " + content;
    }
}