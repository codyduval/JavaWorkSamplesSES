import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import static java.nio.file.StandardOpenOption.*;

public class Dictonary {
		public ArrayList<String> dictionary = new ArrayList<String>();
		
		public ArrayList<String> loadDictionary() {
			Path textPath = Paths.get("/Users/CodyD/Dropbox/DB-Downloads/words.txt");
		
			try {
				OutputStream out = new BufferedOutputStream(Files.newOutputStream(textPath, CREATE));
				InputStream in = Files.newInputStream(textPath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
					dictionary.add(line); 
				}
				in.close();
			} catch (IOException x) {
					System.err.println(x);
			}
			return dictionary;
		}	
}