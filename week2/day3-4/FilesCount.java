
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;
import org.apache.commons.io.FilenameUtils;
import java.util.*;

class FileVisitor extends SimpleFileVisitor<Path>{

  Map<String,Integer> fileCount = new HashMap<String,Integer>();
  PathMatcher matcher;

  /*public TextFileVisitor(){
    matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
  }*/

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
      throws IOException {
    String fileName = file.toString();
    //if ( matcher.matches(fileName)){
   	//System.out.println("Found: "+ file);
    //}
    String ext = FilenameUtils.getExtension(fileName);
    Integer count = fileCount.get(ext);
 	fileCount.put(ext,(count == null)? 1 : count +1 );
    
    return FileVisitResult.CONTINUE;
  }

  public void display(){
  	System.out.println(fileCount);
  }

}

public class FilesCount{
	
	public static void main(String args[]) throws IOException{
		Path rootPath = Paths.get("/Users/cb-bhuvana/Documents/CB-Training-JAVA/CB-Training");
		FileVisitor visitor = new FileVisitor();
		Files.walkFileTree(rootPath,visitor);
		visitor.display();
	}
}


