package interfaces;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface Saveable {
    public void save(String name) throws FileNotFoundException, UnsupportedEncodingException;
}
