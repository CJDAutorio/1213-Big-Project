package dautoriocjproject;
import java.util.*;
import java.io.*;

/**
 *
 * @author CJ D'Autorio
 */
public class FileManager {
	private ArrayList<File> directoryFiles = new ArrayList();
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
	public ArrayList<File> getDirectoryFiles() {
		return directoryFiles;
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
	 * Populates file list
	 */
	public void populateFileList() {
		
	}
	
	/**
	 * Sorts files in listing alphabetically
	 */
	public void sortAlphabet() {
		
	}
	
	/**
	 * Sorts files in listing reverse alphabetically
	 */
	public void sortRevAlphabet() {
		
	}
	
	/**
	 * Sorts files in listing by file size, increasing
	 */
	public void sortSizeIncreasing() {
		
	}
	
	/**
	 * Sorts files in listing by file size, decreasing
	 */
	public void sortSizeDecreasing() {
		
	}
	
	/**
	 * Exports file names
	 */
	public void exportFiles() {
		
	}
	
	
}
