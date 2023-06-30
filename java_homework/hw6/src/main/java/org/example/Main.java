package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Notebook> set = new HashSet<>();
        set.add(new Notebook("Notebook 1", 8, "Windows10", 5800, "HP"));
        set.add(new Notebook("Notebook 2", 16, "Windows11", 62000, "Lenovo"));
        set.add(new Notebook("Notebook 3", 32, "linux", 8300, "Xiaomi"));
        set.add(new Notebook("Notebook 4", 64, "linux", 9700, "Lenovo"));

        OperationWithNotebook operation = new OperationWithNotebook(set);
        operation.start();



    }
}