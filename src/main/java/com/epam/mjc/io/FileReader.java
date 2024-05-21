package com.epam.mjc.io;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;



public class FileReader {
    public Profile getDataFromFile(File file) {
    	  
        Profile profile = new Profile();
        StringBuilder contentBuilder = new StringBuilder();
        
       

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = contentBuilder.toString();
        String[] lines = content.split("\n");

        for (String line : lines) {
            String[] keyValue = line.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "Name":
                        profile.setName(value);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email":
                        profile.setEmail(value);
                        break;
                    case "Phone":
                    	 profile.setPhone(Long.parseLong(value));  // Convertir a long
                        break;
                    default :
                    	System.out.println("There is no information");
                    	break;
					
                }
            }
        }

        return profile;
    }



	public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        File file = new File("src/main/resources/Profile.txt");
        Profile profile = fileReader.getDataFromFile(file);
        System.out.println(profile);
        
    }
}

