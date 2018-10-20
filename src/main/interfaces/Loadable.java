package interfaces;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface Loadable {
    public void load(String name) throws FileNotFoundException;
}
