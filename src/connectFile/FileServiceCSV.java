package connectFile;
import model.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServiceCSV {
    public static List<Service> readFileService() throws IOException {
        List<Service> serviceList = new ArrayList<>();
        FileReader fr = new FileReader("/home/thien/IdeaProjects/caseMdTwo/src/data/dataService.csv");
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] arr = line.split(",");
            Service service = new Service(arr[0],Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            serviceList.add(service);
        }
        return serviceList;
    }
    public void writeToFileService(List<Service> serviceList) throws IOException {
        FileWriter writer = new FileWriter("/home/thien/IdeaProjects/caseMdTwo/src/data/dataService.csv");
        BufferedWriter bw = new BufferedWriter(writer);
        for (Service service: serviceList) {
            bw.write(service.toString());
            bw.newLine();
        }
        bw.close();
        writer.close();
    }
}
