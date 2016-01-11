package moveFiles;

//import java.nio.file;
import java.nio.file.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;

public class MoveFiles{

	
	public void moveFilesDirtoDir(File fromDir,File toDir) throws IOException{
		if(fromDir.isDirectory()){
			File[] subFiles =fromDir.listFiles();
			for(File file : subFiles){
				moveFilesDirtoDir(file,toDir);
			}
		}
		if(fromDir.isFile()){
			File dir = toDir;
			Path source = fromDir.toPath();
			Path destination = dir.toPath();

			destination = destination.resolve(fromDir.getName());

			if(Files.notExists(destination)){
				Files.move(source,destination);
			}else{

				Integer count = 1;
				String fileName = FilenameUtils.removeExtension(fromDir.getName());
				String fileExt = FilenameUtils.getExtension(fromDir.getName());

				File[] files = toDir.listFiles();
				for(File file : files){
					if(file.getName().contains(fileName) && file.getName().contains(fileExt)){ 
            			count++;	
        			}	
				}
        		fileName = dir+"/" + fileName + "-" + count + "." + fileExt;
        		System.out.println(fileName);
        		//destination = dir.toPath().resolve(fileName);
        		destination = Paths.get(fileName);
        		
        		try{
        			Path newPath = Files.move(source,destination);	
        		}catch(AccessDeniedException accessDenied){
        			System.out.println(accessDenied);
        		}
			}
			
		}

	}

	public static void main(String args[])throws IOException{

		File source = new File("/Users/cb-bhuvana/Documents/CB-Training-JAVA/CB-Training/week1/day2");
		File destination = new File("/Users/cb-bhuvana/Documents/CB-Training-JAVA/CB-Training/week2/day3-4/moveFiles");

		MoveFiles move = new MoveFiles();

		
		move.moveFilesDirtoDir(source,destination);		
		
		
		

		

	}
}