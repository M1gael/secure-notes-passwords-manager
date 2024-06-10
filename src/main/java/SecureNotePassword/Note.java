/* 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

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
        //attempt to retrieve last note ID
     /*    try {
            String idString = Files.readString(Path.of("resources/data/LastAssignedId.txt"));
            return Integer.parseInt(idString.trim());
        } catch (IOException | NumberFormatException e) {
            return 0; // Default to 0 if there's an issue reading the file
        } */ /* 
        int lastNoteId = 1;
        return lastNoteId++;
    }

   
    private void saveNote(){
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/data/SavedNotes.txt", true))) {
            writer.write("<id" + currentNoteId + "id>" + "\n" + "<title" + title + "title>" + "\n" + "<content" + content + "content>" + "\n" +"END");             //String.format("%d %s %s%n" ,currentNoteId  , title , content)
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
} */