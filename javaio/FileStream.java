package javaio;

import java.io.*;

public class FileStream {
  class UsingFileIoStream {
    static String digitInputStream = "digitStream";
    static String digitsStream = "digitsStream";

    static void digitInputStream() {
      try {
        FileOutputStream fout = new FileOutputStream(digitInputStream);
        fout.write(65);
        fout.close();
        System.out.println("Success");
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    static void digitsInputStream() {
      try {
        FileOutputStream fout = new FileOutputStream(digitsStream);
        String str = "Hello I am Islam \n";
        byte[] bytes = str.getBytes();
        fout.write(bytes);
        fout.close();
        System.out.println("Success..");
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    static void digitOutputStream() {
      try {
        FileInputStream fin = new FileInputStream(digitInputStream);
        int input = fin.read();
        fin.close();
        System.out.println((char) input);
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    static void digitsOutputStream() {
      try {
        FileInputStream fin = new FileInputStream(digitsStream);
        int input = 0;
        while ((input = fin.read()) != -1)
          System.out.print((char) input);
        fin.close();
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    static void writeDigits() {
      try {
        byte[] data = { (byte) 0xe0, 0x2f, (byte) 0xa3, (byte) '\n' };
        OutputStream fout = new FileOutputStream(digitsStream);
        fout.write(data);
        fout.close();
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }

  class UsingFileWriterReader {
    static String fileName = "fileStream";

    static void write() {
      try {
        Writer w = new FileWriter(fileName);
        String text = "Using FileWriter class";
        w.write(text);
        w.close();
        System.out.println("Done");
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    /**
     * Java FileReader class is used to read data from the file. It returns data in
     * byte format like FileInputStream class.
     */
    static void read() {
      try {
        Reader r = new FileReader(fileName);
        int i;

        while ((i = r.read()) != -1)
          System.out.print((char) i);
        System.out.println();
        r.close();
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }

  class UsingConsoleClass {
    static void readText() {
      System.out.println("Enter your name");
      String text = System.console().readLine();
      System.out.println("Welcome " + text);
    }

    static void readPassword() {
      Console c = System.console();

      System.out.print("Enter your password: \t");
      char[] pass = c.readPassword();

      System.out.print("You Entered: \t");
      for (char ch : pass)
        System.out.print(ch);
      System.out.println();
    }
  }

  /**
   * *Java BufferedWriter class is used to provide buffering for Writer instances.
   * It makes the performance fast. It inherits Writer class. The buffering
   * characters are used for providing the efficient writing of single arrays,
   * characters, and strings.
   * 
   * *Java BufferedReader class is used to read the text from a character-based
   * input stream. It can be used to read data line by line by readLine() method.
   * It makes the performance fast. It inherits Reader class.
   */
  class UsingBufferWriterReaderClass {
    static String fileName = "usingBuffer";

    static void write() {
      try {
        Writer w = new FileWriter(fileName);
        BufferedWriter buffer = new BufferedWriter(w);

        buffer.write("Hello user, How is it going");

        buffer.close();
        w.close();
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    static void read() {
      try {
        Reader r = new FileReader(fileName);
        BufferedReader buffer = new BufferedReader(r);
        String text = buffer.readLine();

        System.out.println("Reading this output from " + fileName + "\n Output: " + text);

        buffer.close();
      } catch (Exception e) {
        System.out.println(e);
      }

    }
  }

  public static void main(String[] args) {
    UsingFileIoStream.digitInputStream();
    UsingFileIoStream.digitsInputStream();
    System.out.println();

    UsingFileIoStream.writeDigits();
    System.out.println();

    UsingFileIoStream.digitOutputStream();
    UsingFileIoStream.digitsOutputStream();
    System.out.println();

    UsingFileWriterReader.write();
    UsingFileWriterReader.read();
    System.err.println();

    // UsingConsoleClass.readText();
    // UsingConsoleClass.readPassword();

    UsingBufferWriterReaderClass.write();
    UsingBufferWriterReaderClass.read();
  }
}
