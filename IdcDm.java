import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class IdcDm {
    public static void main(String[] args) {
        String url = args[0]; // the first argument is the url/list of urls
        int numOfConnections =  args.length > 1 ? Integer.parseInt(args[1]) : 1;

        Manager manager = new Manager(url, numOfConnections);
        manager.initURL();
    }
}