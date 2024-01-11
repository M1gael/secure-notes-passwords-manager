import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Note{
    private String title ;
    private String content;
    private int currentNoteId = generateNoteId();

    

    //constructor
    public Note(String title , String content , int currentnoteId){
        this.title = title ; 
        this.content = content;
        this.currentNoteId ;
        // Print/save title , content and the return of generate note id
    }


    public int generateNoteId(int lastNoteId){
        //find a means to extract the note ID from the storage 
        lastNoteId = 1;
        return lastNoteId++;
    }
    
    @Override
    public String toString(){
        return "Title: " + title + "\n" + "Content: " + content;
    }
}