package connectFile;


import model.Machine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileMachineCSV {
    public static List<Machine> readFromFile() throws IOException {
        List<Machine> machineList = new ArrayList<>();
        FileReader fr = new FileReader("/home/thien/IdeaProjects/caseMdTwo/src/data/dataMachine.csv");
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] arr = line.split(",");
            Machine machine = new Machine(arr[1]);
            machineList.add(machine);
        }
        return machineList;
    }
    public void writeToFile(List<Machine> machineList) throws IOException {
       FileWriter fw = new FileWriter("/home/thien/IdeaProjects/caseMdTwo/src/data/dataMachine.csv");
       BufferedWriter bw = new BufferedWriter(fw);
        for (Machine machine : machineList) {
            bw.write(machine.toString());
            bw.newLine();
        }
        bw.close();
        fw.close();
    }


}
