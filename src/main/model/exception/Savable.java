package main.model.exception;

import java.io.IOException;

public interface Savable {
    public void save() throws IOException;
}