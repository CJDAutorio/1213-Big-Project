package dautoriocjproject;
import java.util.*;
import java.io.*;
import java.nio.*;

/**
 *
 * @author CJ D'Autorio
 */
public class FileManager {
	private ArrayList<File> fileList = new ArrayList();
	private String sourceDirectory;
	private String destDirectory;
	private String filePrefix;
	private String fileSuffix;
	private boolean recursive;
	private boolean numberFiles;

	public FileManager() {}
	
	public FileManager(String sourceDirectory) {
		this.sourceDirectory = sourceDirectory;
	}

	public FileManager(String sourceDirectory, String destDirectory) {
		this.sourceDirectory = sourceDirectory;
		this.destDirectory = destDirectory;
	}

	public FileManager(String sourceDirectory, String destDirectory, String filePrefix, String fileSuffix, boolean recursive, boolean numberFiles) {
		this.sourceDirectory = sourceDirectory;
		this.destDirectory = destDirectory;
		this.filePrefix = filePrefix;
		this.fileSuffix = fileSuffix;
		this.recursive = recursive;
		this.numberFiles = numberFiles;
	}

	/**
	 * Returns entire file array
	 * @return 
	 */
	public ArrayList<File> getFileList() {
		return fileList;
	}

	/**
	 * Returns source directory
	 * @return 
	 */
	public String getSourceDirectory() {
		return sourceDirectory;
	}

	/**
	 * Sets source directory
	 * @param sourceDirectory 
	 */
	public void setSourceDirectory(String sourceDirectory) {
		this.sourceDirectory = sourceDirectory;
	}

	/**
	 * Returns file destination directory
	 * @return 
	 */
	public String getDestDirectory() {
		return destDirectory;
	}

	/**
	 * Sets file destination directory
	 * @param destDirectory 
	 */
	public void setDestDirectory(String destDirectory) {
		this.destDirectory = destDirectory;
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
	 * Sorts files in listing alphabetically
	 */
	public ArrayList<File> sortAlphabet() {
		// TODO This
		return fileList;
	}
	
	/**
	 * Sorts files in listing reverse alphabetically
	 */
	public ArrayList<File> sortRevAlphabet() {
		// TODO This
		return fileList;
	}
	
	/**
	 * Sorts files in listing by file size, increasing
	 */
	public ArrayList<File> sortSizeIncreasing() {
		int tempIndex = 0;
		File tempFile = fileList.get(0);
		for (int i = 1; i < fileList.size(); i++) {
			if (fileList.get(i).length() < fileList.get(i-1).length()) {
				fileList.set(i - 1, fileList.get(i));
				fileList.set(i, tempFile);
				tempFile = fileList.get(i);
				tempIndex = i;
			} else {
				fileList.get(i).length();
			}
		}
		
		return fileList;
	}
	
	/**
	 * Sorts files in listing by file size, decreasing
	 */
	public ArrayList<File> sortSizeDecreasing() {
		
		return fileList;
	}
	
	/**
	 * Exports file names
	 */
	public void exportFiles() {
		
	}
}
