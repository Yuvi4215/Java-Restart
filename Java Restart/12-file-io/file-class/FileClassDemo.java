import java.io.File;
import java.io.IOException;

/**
 * JAVA FILE CLASS (java.io.File)
 * -------------------------------
 * The File class is used to:
 *  - Create files and directories
 *  - Check if file/directory exists
 *  - Read file information (size, name, path)
 *  - Delete files and directories
 *  - List directory contents
 *
 * NOTE:
 * File class does NOT read/write data (use FileReader/FileWriter for that).
 */

public class FileClassDemo {

    /** ==========================================
     *  1. Create and Check File
     * ========================================== */
    static void createFileDemo() {
        System.out.println("----------------------------------------");
        System.out.println("* 1. Create and Check File *");

        File file = new File("testfile.txt");

        try {
            if (file.exists()) {
                System.out.println("File already exists: " + file.getAbsolutePath());
            } else {
                file.createNewFile();
                System.out.println("File created: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    /** ==========================================
     *  2. Create Directory
     * ========================================== */
    static void createDirectoryDemo() {
        System.out.println("\n----------------------------------------");
        System.out.println("* 2. Create Directory *");

        File dir = new File("myFolder");

        if (dir.exists()) {
            System.out.println("Directory already exists: " + dir.getAbsolutePath());
        } else {
            if (dir.mkdir())
                System.out.println("Directory created: " + dir.getAbsolutePath());
            else
                System.out.println("Failed to create directory!");
        }
    }

    /** ==========================================
     *  3. File Information (Name, Size, Path)
     * ========================================== */
    static void fileInfoDemo() {
        System.out.println("\n----------------------------------------");
        System.out.println("* 3. File Information *");

        File file = new File("testfile.txt");

        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("Readable? " + file.canRead());
            System.out.println("Writable? " + file.canWrite());
            System.out.println("Executable? " + file.canExecute());
        } else {
            System.out.println("File does not exist.");
        }
    }

    /** ==========================================
     *  4. List files in a directory
     * ========================================== */
    static void listDirectoryDemo() {
        System.out.println("\n----------------------------------------");
        System.out.println("* 4. List Directory Contents *");

        File dir = new File(".");

        String[] contents = dir.list();

        if (contents != null) {
            System.out.println("Current folder contents:");
            for (String item : contents) {
                System.out.println(" - " + item);
            }
        } else {
            System.out.println("Directory not found or empty.");
        }
    }

    /** ==========================================
     *  5. Delete File or Folder
     * ========================================== */
    static void deleteDemo() {
        System.out.println("\n----------------------------------------");
        System.out.println("* 5. Delete File *");

        File file = new File("testfile.txt");

        if (file.exists()) {
            if (file.delete())
                System.out.println("File deleted successfully.");
            else
                System.out.println("Failed to delete file.");
        } else {
            System.out.println("File does not exist.");
        }
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {

        System.out.println("=== Java File Class Demo ===\n");

        createFileDemo();
        createDirectoryDemo();
        fileInfoDemo();
        listDirectoryDemo();
        deleteDemo();

        System.out.println("\n----------------------------------------");
        System.out.println("* Key Takeaways *");
        System.out.println("- File class is used for file/directory operations.");
        System.out.println("- createNewFile() creates empty files.");
        System.out.println("- mkdir() creates a directory.");
        System.out.println("- Use exists(), canRead(), length(), delete() for file details.");
        System.out.println("- File class does NOT read/write data (use streams for that).");
    }
}
