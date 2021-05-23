package com.homework.operations;

import com.homework.model.ShortUser;
import com.homework.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class UserOperations {

    public static void add(User user) {
        try (FileWriter writer = new FileWriter("UserFile.txt", true)) {
            String text = user.toString();
            writer.write(text);
            writer.append('\n');

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User find(ShortUser shortUser) {
        File f = new File("UserFile.txt");
        Scanner scannedFile;
        try {
            scannedFile = new Scanner(f);

            while (scannedFile.hasNext()) {
                String search = scannedFile.next();
                String[] buffer = search.split("\\|");
                if (buffer[0].equals(shortUser.getFirstName()) && buffer[1].equals(shortUser.getLastName())) {
                    User user = new User();
                    user.setParams(buffer);
                    return user;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean addFromFile(Path path) throws IOException {
        Scanner scanner = new Scanner(path);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String[] buffer = nextLine.split("\\|");
            if (buffer.length == 7) {
                User user = new User();
                user.setParams(buffer);
                add(user);
            } else {
                return false;
            }
        }
        return true;
    }
}
