package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NimSaver implements Loadable<List<String>>{

	List<String> list;
	
	private String path = new File("").getAbsolutePath() + "/src/app/";
	
	@Override
	public List<String> loadFromFile(String file) {
		Scanner in;
		list = new ArrayList();
        try
        {
            in = new Scanner(new FileReader(path + file));
             
            while(in.hasNext()){
                String line = in.nextLine();
                list.add(line);
            }
             
            in.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: file 'test.txt' could not be opened. Does it exist?");
            System.exit(1);
        }
        return list;
	}

	@Override
	public void saveToFile(List<String> list, String file) {
		try
        {
            PrintWriter outFile = new PrintWriter(path + file);
            for (int i = 0; i < list.size(); i++) {
				String str = list.get(i);
            	outFile.println(str);
			}
            outFile.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: file 'test.txt' could not be opened for writing.");
            System.exit(1);
        }
	}
	

}
