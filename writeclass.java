package HW1;
import java.io.FileWriter;
import java.io.IOException;
public class writeclass 
{
	public static void main(String[] args) throws IOException
    {
        String str = "File Handling in Java using "+
                     " FileWriter and FileReader";
        FileWriter fw=new FileWriter("test write class");
        for (int i = 0; i < str.length(); i++)
            fw.write(str.charAt(i));
        fw.close();
    }
}
