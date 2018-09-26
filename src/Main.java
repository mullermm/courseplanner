
public static void main(String[] args) throws IOException 
{
    Scanner inputReader = new Scanner(System.in);

    System.out.println("Enter a path");
    String inputPath = inputReader.nextLine();
    System.out.println("Enter the word");
    String targetWord = inputReader.nextLine();

    File file = new File(inputPath);



    if(file.isFile() && file.getName().endsWith(".txt")){

        numOccurances = toLineStreamFromFile(file)
                            .flatMap(str -> Arrays.stream(str.split("\\s")))
                            .filter(str -> str.equals(targetWord))
                            .count();

    }else if(file.isDirectory()){

        numOccurances = Arrays.stream(file.listFiles(pathname -> pathname.toString().endsWith(".txt")))
                              .flatMap(Main::toLineStreamFromFile)
                              .flatMap(str -> Arrays.stream(str.split("\\s")))
                              .filter(str -> str.equals(targetWord))
                              .count();
    }

    System.out.println(numOccurances);
}

public static Stream<String> toLineStreamFromFile(File file){
    try 
	{
        return Files.lines(file.toPath());	
	} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    return Stream.empty();
}	

