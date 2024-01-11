import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Note{
    private String title ;
    private String content;
    private int currentNoteId;

    

    //constructor
    public Note(String title , String content ){
        this.title = title ; 
        this.content = content;
        this.currentNoteId = generateNoteId();
        saveNote();
        // Print/save title , content and the return of generate note id
    }


    private int generateNoteId(){
        //find a means to extract the last note ID from the storage 
        int lastNoteId = 1;
        return lastNoteId++;
    }


    private void saveNote(){
    

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/data/SavedNotes.txt", true))) {
            writer.write(String.format("%d %s %s%n" , currentNoteId , title , content));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void editNote(){

    }
    
    public static void loadNotes(){

    }

    @Override
    public String toString(){
        return "Title: " + title + "\n" + "Content: " + content;
    }
}