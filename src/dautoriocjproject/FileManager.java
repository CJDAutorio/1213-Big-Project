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

	public ArrayList<File> getDirectoryFiles() {
		return directoryFiles;
	}

	public void setDirectoryFiles(ArrayList<File> directoryFiles) {
		this.directoryFiles = directoryFiles;
	}

	public String getSourceDirectory() {
		return sourceDirectory;
	}

	public void setSourceDirectory(String sourceDirectory) {
		this.sourceDirectory = sourceDirectory;
	}

	public String getDestDirectory() {
		return destDirectory;
	}

	public void setDestDirectory(String destDirectory) {
		this.destDirectory = destDirectory;
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public boolean isRecursive() {
		return recursive;
	}

	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}

	public boolean isNumberFiles() {
		return numberFiles;
	}

	public void setNumberFiles(boolean numberFiles) {
		this.numberFiles = numberFiles;
	}
	
	public void sortAlphabet() {
		
	}
	
	public void sortRevAlphabet() {
		
	}
	
	public void sortSizeIncreasing() {
		
	}
	
	public void sortSizeDecreasing() {
		
	}
	
	public void exportFiles() {
		
	}
}
