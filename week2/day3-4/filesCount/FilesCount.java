package filesCount;

import java.io.File;
/*import java.nio.file.*;
import java.nio.file.attribute.*;*/
import org.apache.commons.io.FilenameUtils;
import java.util.*;

/*class FileVisitor extends SimpleFileVisitor<Path>{

  Map<String,Integer> fileCount = new HashMap<String,Integer>();
  

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
      throws IOException {
    String fileName = file.toString();
    String ext = FilenameUtils.getExtension(fileName);
    Integer count = fileCount.get(ext);
 	fileCount.put(ext,(count == null)? 1 : count +1 );
    
    return FileVisitResult.CONTINUE;
  }

  public void display(){
  	System.out.println(fileCount);
  }

}*/


class FileVisitor{

    public void getFilesCount(File file, HashMap<String,Integer> fileCount){

        if (file.isDirectory()) {
          File childNodes[] = file.listFiles();
          for (File childNode : childNodes) {
              getFilesCount(childNode,fileCount);
          }
          // return fileCount;
        }else {
          String fileExt = FilenameUtils.getExtension(file.getName());
          Integer count = fileCount.get(fileExt);
          fileCount.put(fileExt,(count == null)? 1 : count +1 );
        }

        // return fileCount;  
    }

}


public class FilesCount{
	
	public static void main(String args[]){ //thorws exception I should add.
    
		/*Path rootPath = Paths.get("/Users/cb-bhuvana/Documents/CB-Training-JAVA/CB-Training");
		FileVisitor visitor = new FileVisitor();
		Files.walkFileTree(rootPath,visitor);
		visitor.display();*/

    File file = new File("/Users/cb-bhuvana/Documents/CB-Training-JAVA/CB-Training");
    FileVisitor visitor = new FileVisitor();
    HashMap<String,Integer> fileCount= new HashMap<String,Integer>();
    visitor.getFilesCount(file,fileCount);
    System.out.println(fileCount);    
	}
}


