package com.ss.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Scanner;

public class Count_char {

    private static Path  filepath;
    
    public static int char_count(char character) throws IOException{
        int count;
        count=0;
        String str;
        BufferedReader reader = null;
        try{
            filepath=Paths.get("C:/Users/santosha/git/skotha-private-repo/file-handling-mini-module/input_file.txt");
            Charset charset = Charset.forName("US-ASCII");
            reader = Files.newBufferedReader(filepath, charset);
            while((str = reader.readLine()) != null){
                for (int i = 0; i < str.length(); i++) {
                    if (character == str.charAt(i)) {
                        count++;
                    }
                }
            }
        }
        catch(IOException E){
            System.out.println("Error in opening the file");
        }
        finally{
            reader.close();
        }
        System.out.println(count);
        return count;
    }
    
    public static void main(String[] args) throws IOException {
      
        // TODO Auto-generated method stub
        Count_char obj= new Count_char();
        int count;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter char to search");
        char c = scanner.next().charAt(0);
        count=obj.char_count(c);
        System.out.println("Character "+c+" occured:"+count);
        scanner.close();
    }

}
