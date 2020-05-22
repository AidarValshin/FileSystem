package Structure.Main;

import Functions.AddInfo.AddInfoCommand;
import Functions.CreateFile.CreateFileCommand;
import Functions.DeleteFile.DeleteFileCommand;
import Functions.ParameterReaders.ReadParameters;
import Structure.FileSystemStructure.FileSystem;
import Structure.FileSystemStructure.IMessageWriter;


public class tester {

    public static void main(String[] args) {
        // Отладка создания ФС
        FileSystem newFileSystem = new FileSystem(4, "MyFileSystem", "Igor", 2, 3);

        // Отладка создания файла (создание файла в пустой ФС)
        CreateFileCommand fileCommand = new CreateFileCommand();
        IMessageWriter imw = new IMessageWriter() {
            String message1 ="заглушка";
            @Override
            public void write(String message) {
                System.out.println(message1);
            }
        };
        ReadParameters fileCreationParameters = new ReadParameters();
        fileCommand.Execute(newFileSystem, fileCreationParameters, imw);

        // Отладка создания файла (создание файла в непустой ФС, вставка в непустой сегмент)
        for (int i = 0; i < 4; i++) {
            fileCommand.Execute(newFileSystem, fileCreationParameters, imw);
        }

        // Отладка удаления файла
        IMessageWriter imw1 = new IMessageWriter() {
            @Override
            public void write(String message) {
                System.out.println(message);
            }
        };
        DeleteFileCommand delFileCommand = new DeleteFileCommand();
        ReadParameters delFileParameters = new ReadParameters();
        for (int i = 0; i < 4; i++) {
            delFileCommand.Execute(newFileSystem, delFileParameters, imw1);
        }
        delFileCommand.Execute(newFileSystem, delFileParameters, imw1);

        // Отладка создания файла (текущий сегмент полон, создаём новый, добавляем в него, прерасчитываем head)
        fileCommand.Execute(newFileSystem, fileCreationParameters, imw);

        //  Отладка создания файла (один из сегментов полон, второй полон частично)
        for (int i = 0; i < 2; i++) {
            fileCommand.Execute(newFileSystem, fileCreationParameters, imw);
        }

        // Отладка добавления информации в файл. Ввод информации прекращается после того как размер информации
        //превысит или станет равным вводимому размеру. Не нужно нажимать ctrl+D как в прошлой версии!!!
        AddInfoCommand addInfoCommand = new AddInfoCommand();
        ReadParameters addInfoParameters = new ReadParameters();
        addInfoCommand.Execute(newFileSystem, addInfoParameters, imw);

    }

}