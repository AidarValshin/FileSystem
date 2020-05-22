package Structure.FileSystemStructure;

import java.io.Serializable;
import java.util.Arrays;

public class DataInfo implements Serializable{
    public static int fileNameLengthLimit = 63;     // Ограничение на длину имени файла (в символах)
    private int[] date;          // Дата создания файла [число, месяц, год] - массив int
    private String nameFile;     // Имя файла String, 1 <= length() <= fileNameLengthLimit
    private int size;            // Размер файла, > 0, Байт
    private int typeNote;        // Тип записи [временно стоит 1 - файл существует, 0 - файл удален (<=> "пустое место")]
    //public int typeFile;       // Тип файла [поле временно убрано]

    public DataInfo(int[] date, String fileName, int fileSize) { //, int typeNote, int typeFile) {
        this.date = date;
        this.nameFile = fileName;
        this.size = fileSize;
        this.typeNote = 1; // Потом ИСПРАВИТЬ установлено по ДЕФОЛТУ.
        //this.typeFile = typeFile;
    }

    public DataInfo() {
    }

    public int[] getDate() {
        return date;
    }

    public void setDate(int[] date) {
        this.date = date;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addSize(int size) {
        this.size += size;
    }

    public int getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(int typeNote) {
        this.typeNote = typeNote;
    }

    @Override
    public String  toString (){
        return "date:"+ Arrays.toString(date)+"\nnameFile:"+nameFile+"\nsize:"+size+"\ntypeNote:"+typeNote;
    }
}
