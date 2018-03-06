package me.shouheng.guava;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IOExample {

    public static void main(String...args) {

    }

    private List<String> readFile(File file) throws IOException {
        if (!file.exists()){
            return ImmutableList.of(); // 避免返回null
        }
        return Files.readLines(file, Charsets.UTF_8);
    }


    private void copyFile(File from, File to) throws IOException {
        if (!from.exists()){
            return;
        }
        if (!to.exists()){
            to.createNewFile();
        }
        Files.copy(from,to);
    }
}
