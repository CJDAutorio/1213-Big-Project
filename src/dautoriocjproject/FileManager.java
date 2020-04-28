package dautoriocjproject;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

/**
 *
 * @author CJ D'Autorio
 */
public class FileManager {
	private ArrayList<File> fileList = new ArrayList();
	private String filePrefix;
	private String fileSuffix;
	private boolean recursive;
	private boolean numberFiles;

	public FileManager() {}

	/**
	 * Returns entire file array
	 * @return 
	 */
	public ArrayList<File> getFileList() {
		return fileList;
	}

	/**
	 * Gets file prefix
	 * @return 
	 */
	public String getFilePrefix() {
		return filePrefix;
	}

	/**
	 * Sets file prefix
	 * @param filePrefix 
	 */
	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	/**
	 * Returns file suffix
	 * @return 
	 */
	public String getFileSuffix() {
		return fileSuffix;
	}

	/**
	 * Sets file suffix
	 * @param fileSuffix 
	 */
	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	/**
	 * Returns recursive status
	 * @return 
	 */
	public boolean isRecursive() {
		return recursive;
	}

	/**
	 * Sets recursive status
	 * @param recursive 
	 */
	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}

	/**
	 * Returns number file status
	 * @return 
	 */
	public boolean isNumberFiles() {
		return numberFiles;
	}

	/**
	 * Sets number file status
	 * @param numberFiles 
	 */
	public void setNumberFiles(boolean numberFiles) {
		this.numberFiles = numberFiles;
	}
	
	/**
	 * Adds a file to the file arraylist
	 * @param file 
	 */
	public void addFile(File file) {
		fileList.add(file);
	}
	
	/**
	 * Returns array of files without recursion
	 * @param directory
	 * @return
	 */
	public ArrayList<File> listFiles(File directory) {
		fileList = new ArrayList();
		try {
			Collections.addAll(fileList, directory.listFiles());
			for (int i = 0; i < fileList.size(); i++) {
				logFile(fileList.get(i));
			}
		} catch (NullPointerException e) {
			System.out.println("No files in directory.");
		}
		
		return fileList;
	}
	
	/**
	 * Returns array of files with recursion
	 * @param directory
	 * @return 
	 */
	public ArrayList<File> listFilesRecursive(File directory) {
		fileList = new ArrayList();
		Collections.addAll(fileList, directory.listFiles());
		
		for (int i = 0; i < fileList.size(); i++) {
			if (fileList.get(i).isDirectory()) {
				Collections.addAll(fileList, fileList.get(i).listFiles());
				logFile(fileList.get(i));
			} else {
				logFile(fileList.get(i));
			}
		}
		
		return fileList;
	}
	
	/**
	 * Logs file passed to console. Used mainly for debugging.
	 * @param file 
	 */
	public void logFile(File file) {
		System.out.println("File added: " + file.getName());
	}
	
	/**
	 * Sends directories to the back of the arraylist to prevent logic errors when sorting
	 */
	public void sendDirectoriesBack() {
		for (int i = 0; i < fileList.size(); i++) {
			if (fileList.get(i).isDirectory()) {
				fileList.add(fileList.get(i));
				fileList.remove(i);
			}
		}
	}
	
	/**
	 * Sorts files in listing alphabetically (IS CAP SENSITIVE)
	 */
	public ArrayList<File> sortAlphabet() {
		sendDirectoriesBack();
		fileList.sort(compareNames);
		return fileList;
	}
	
	/**
	 * Sorts files in listing reverse alphabetically (IS CAP SENSITIVE)
	 * @return 
	 */
	public ArrayList<File> sortRevAlphabet() {
		sendDirectoriesBack();
		fileList.sort(Collections.reverseOrder(compareNames));
		return fileList;
	}
	
	/**
	 * Sorts files in listing by file size, increasing
	 * @return 
	 */
	public ArrayList<File> sortSizeIncreasing() {
		sendDirectoriesBack();
		fileList.sort(compareSize);
		return fileList;
	}
	
	/**
	 * Sorts files in listing by file size, decreasing
	 * @return 
	 */
	public ArrayList<File> sortSizeDecreasing() {
		sendDirectoriesBack();
		fileList.sort(Collections.reverseOrder(compareSize));
		
		return fileList;
	}
	
	/**
	 * Compares file sizes
	 */
	Comparator<File> compareSize = new Comparator<File>(){
		@Override
		public int compare(File file1, File file2) {
			double size1 = file1.length();
			double size2 = file2.length();
			
			if (size1 > size2) {
				return 1;
			} else if (size1 < size2) {
				return -1;
			} else {
				return 0;
			}
		}
	};
	
	/**
	 * Compares names
	 */
	Comparator<File> compareNames = new Comparator<File>(){
		@Override
		public int compare(File file1, File file2) {
			char name1 = file1.getName().charAt(0);
			char name2 = file2.getName().charAt(0);
			
			return name1 - name2;
		}
	};
		
	/**
	 * Returns file name without file extension
	 * @param file
	 * @return 
	 */
	public String getFileName(File file) {
		return file.getName().substring(0, file.getName().lastIndexOf("."));
	}
	
	/**
	 * Returns file extension
	 * @param file
	 * @return 
	 */
	public String getFileExtension(File file) {
		return file.getName().substring(file.getName().lastIndexOf("."));
	}
	
	/**
	 * Renames file
	 * @param name
	 * @param file
	 * @param destination
	 */
	public void renameFile(String name, File file, File destination) {
		if (!file.isDirectory()) {
			Path source = Paths.get(file.getAbsolutePath());
			File destFile = new File(destination.getAbsolutePath() + "/" + name);
			Path destPath = Paths.get(destFile.getAbsolutePath());
			try {
				Files.move(source, destPath, StandardCopyOption.REPLACE_EXISTING);
				System.out.println(destFile.getName() + " successfully renamed. Output location: " + destFile.getAbsolutePath());
			} catch (FileAlreadyExistsException e) {
				System.out.println("File " + destination.getName() + " already exists.");
			} catch (IOException e) {
				System.out.println("IOException when processing file " + file.getName() + "\n" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception when processing file " + file.getName() + "\n" + e.getMessage());
			}
		}
	}
}
