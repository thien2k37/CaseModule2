package generalManage;

import check.InputCheck;
import connectFile.FileServiceCSV;
import model.Service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ServiceManage implements General<Service> {
    Scanner sc = new Scanner(System.in);

    InputCheck inputCheck = new InputCheck();

    List<Service> serviceList;
    FileServiceCSV serviceCSV = new FileServiceCSV();
    public ServiceManage() throws IOException {
        serviceList = FileServiceCSV.readFileService();
    }
    public List<Service> getServiceList() {
        return serviceList;
    }

    @Override
    public void add() throws IOException {
        getServiceList().add(ipService());
        serviceCSV.writeToFileService(getServiceList());
    }

    @Override
    public void edit() {
        System.out.println("Nhập id để sử thực đơn");
        int id = inputCheck.checkInteger();
        if (findIndexById(id) == 0) {
            System.out.println(id + " Không có trong danh sách");
        }else {
            getServiceList().set(findIndexById(id), ipService());
        }
    }

    @Override
    public void delete() throws IOException {
        System.out.println("Nhập id để xóa");
        int id = inputCheck.checkInteger();
        if(findIndexById(id) != 1) {
            System.out.println(id + " Không có trong thực đơn");
        }else {
            getServiceList().remove(findIndexById(id));
            serviceCSV.writeToFileService(getServiceList());
        }
    }

    @Override
    public void display() throws IOException {
        for (Service service: getServiceList()) {
            System.out.println(service);
            serviceCSV.writeToFileService(getServiceList());
        }
    }

    @Override
    public int findIndexById(int id) {
        for (Service service : serviceList) {
            if (service.getIdService() == id) {
                return 1;
            }
        }
        return 0;
    }
    public void findService() {
        System.out.println("Nhập id");
        int id = inputCheck.checkInteger();
        if (findIndexById(id) != 0) {
            System.out.println(getServiceList().get(id));
        }else {
            System.out.println(id + " Không có trong danh sách");
        }
    }

    public Service ipService() {
        System.out.println("NHập tên đồ ăn!");
        String nameService = sc.nextLine();
        System.out.println("Nhâp số lương");
        int quantity = Integer.parseInt(String.valueOf(inputCheck.checkInteger()));
        System.out.println("Nhập id");
        int idService = Integer.parseInt(String.valueOf(inputCheck.checkInteger()));
        return new Service(nameService, quantity, idService);
    }
}
