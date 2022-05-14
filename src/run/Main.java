package run;
import check.InputCheck;
import connectFile.FileAccountCSV;
import generalManage.AccountManage;
import generalManage.ManageMachine;
import generalManage.ServiceManage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputCheck inputCheck = new InputCheck();
        try {
            Scanner sc = new Scanner(System.in);
            ManageMachine machine = new ManageMachine();
            AccountManage accountManage = new AccountManage();
            ServiceManage serviceManage = new ServiceManage();
            FileAccountCSV accountCSV = new FileAccountCSV();
            int select = -1;
            while (select != 0) {

                System.out.println("Menu Đăng Nhập máy chủ ");
                System.out.println("1. Đăng Nhập");
                System.out.println("2. Đăng Ký");
                System.out.println("Vui lòng nhập!");
                select = inputCheck.checkInteger();
                switch (select) {
                    case 1 -> {
                        System.out.println("____Đăng Nhập----");
                        System.out.println("Tên tài khoản:");
                        String acName = sc.nextLine();
                        System.out.println("Mật khẩu");
                        String acPass = sc.nextLine();
                        if (accountManage.login(acName, acPass) != 0) {
                            if (AccountManage.currentName.getAccountName().equals("admin")) {
                                int selectAd = -1;
                                while (selectAd != 0) {
                                    System.out.println("Xin Chào Big Boss");
                                    System.out.println("====================Menu===================");
                                    System.out.println(
                                            """
                                                    |*| 1.             Quản lý PC             |*|         \s
                                                    |*| 2.    Quản lý Tài Khoản Khách Hàng    |*|
                                                    |*| 3.      Quản Lý Dịch vu Quán Net      |*|
                                                    |*|=========* Thoát Nhấn 0 * =========|*|
                                                    """
                                    );
                                    selectAd = inputCheck.checkInteger();
                                    switch (selectAd) {
                                        case 1 -> {
                                            System.out.println("|*|===============Máy Tính=============|*|");
                                            System.out.println(
                                                    """
                                                            |*| 1.      Hiễn Thị Tất Cả Máy         |*|
                                                            |*| 2.  Thêm 1 máy mới vào danh sách    |*|
                                                            |*| 3.    Sửa đổi thông tin của máy     |*|
                                                            |*| 4.     Xóa 1 máy khỏi danh sách     |*|
                                                          
                                                            |*|=======* Vui lòng nhập tiếp * =======|*|
                                                            """
                                            );
                                            int selectPc = -1;
                                            while (selectPc != 0) {
                                                System.out.println("Tiếp tục nhập để chức năng \n Nhập 0 để trở lạị");
                                                selectPc = inputCheck.checkInteger();
                                                switch (selectPc) {
                                                    case 1 -> {
                                                        System.out.println("Hiễn Thị Tất Cả Máy");
                                                        machine.display();
                                                    }
                                                    case 2 -> {
                                                        System.out.println("Thêm 1 máy mới vào danh sách");
                                                        machine.add();
                                                    }
                                                    case 3 -> {
                                                        System.out.println("Sửa đổi thông tin của máy");
                                                        machine.edit();
                                                    }
                                                    case 4 -> {
                                                        System.out.println("Xóa 1 máy khỏi danh sách");
                                                        machine.delete();
                                                    }
                                                    default -> System.out.println("Nhập lại boss ơi !");
                                                }
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("|*|========Tài Khoản khách Hàng=========");
                                            System.out.println(
                                                    """
                                                            |*| 1.    Hiển thị các Tài Khoản       |*|
                                                            |*| 2.Thêm tải một tài khoản khách hàng|*|
                                                            |*| 3.     Sửa tài khoản khách hàng    |*|
                                                            |*| 4.     Xóa tải khoản khách hàng    |*|
                                                            |*| 5.  Tim kiem tai khoản khách hàng  |*|
                                                            |*|<<<<<< * Vui lòng nhập tiếp * >>>>>>|*|
                                                            """
                                            );
                                            int selectAc = -1;
                                            while (selectAc != 0) {
                                                System.out.println("Tiếp tục nhập để chức năng \n Nhập 0 để trở lạị");
                                                selectAc = inputCheck.checkInteger();
                                                switch (selectAc) {
                                                    case 1 -> {
                                                        System.out.println("Hiển thị các Tài Khoản");
                                                        accountManage.display();
                                                    }
                                                    case 2 -> {
                                                        System.out.println("Thêm tải một tài khoản khách hàng");
                                                        accountManage.add();
                                                    }
                                                    case 3 -> {
                                                        System.out.println("Sửa tài khoản khách hàng");
                                                        accountManage.edit();
                                                    }
                                                    case 4 -> {
                                                        System.out.println("Xóa tải khoản khách hàng");
                                                        accountManage.delete();
                                                    }
                                                    case 5 -> {
                                                        System.out.println("Tìm kiếm theo tên Tài Khoản");
                                                        accountManage.searchAccount(AccountManage.currentName.getAccountName());
                                                    }
                                                    default -> System.out.println("Nhập lại đi Bro");
                                                }
                                            }
                                        }
                                        case 3 -> {
                                            System.out.println("*********|Quản lý dịch vụ|*********");
                                            System.out.println(
                                                    """
                                                            |*| 1. Hiển Thị dịch vụ Quán net|*|
                                                            |*| 2.    Thêm dịch vụ mới      |*|
                                                            |*| 3. Sửa một dịch vụ nào đó   |*|
                                                            |*| 4.    Xóa một dich vụ       |*|
                                                            |*| 5. Tìm kiêm dịch vụ theo id |*|
                                                            |*|>>>* Vui lòng nhập tiếp * <<<|*|
                                                            """
                                            );
                                            int selectSv = -1;
                                            while (selectSv != 0) {
                                                System.out.println("Tiếp tục nhập để chức năng \n Nhập 0 để trở lạị");
                                                selectSv = inputCheck.checkInteger();
                                                switch (selectSv) {
                                                    case 1 -> {
                                                        System.out.println("Hiển Thị dịch vụ Quán net");
                                                        serviceManage.display();
                                                    }
                                                    case 2 -> {
                                                        System.out.println("Thêm dịch vụ mới");
                                                        serviceManage.add();
                                                    }
                                                    case 3 -> {
                                                        System.out.println("Sửa một dịch vụ nào đó");
                                                        serviceManage.add();
                                                    }
                                                    case 4 -> {
                                                        System.out.println("Xóa một dich vụ");
                                                        serviceManage.delete();
                                                    }
                                                    case 5 -> {
                                                        System.out.println("tìm kiêm dịch vụ theo id");
                                                        serviceManage.findService();
                                                    }
                                                    default -> System.out.println("Chọn lại dịch vụ xếp ơi!");
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                int select1 = -1;
                                while (select1 != 0) {
                                    System.out.println("Menu Customer");
                                    System.out.println("0. Đăng xuất");
                                    System.out.println("1. Xem Thông tin");
                                    System.out.println("2. Đổi Mật khẩu");
                                    System.out.println("3. Dịch vụ");
                                    System.out.println("Nhâp lựa lựa chọn!");
                                    select1 = inputCheck.checkInteger();
                                    switch (select1) {
                                        case 1 -> {
                                            System.out.println("Xem Thông tin");
                                            accountManage.searchAccount(AccountManage.currentName.getAccountName());
                                        }
                                        case 2 -> {
                                            System.out.println("Đổi Mật Khẩu mới!");
                                            String newPass = sc.nextLine();
                                            AccountManage.currentName.setPassWord(newPass);
                                            accountCSV.writeToFile(accountManage.getList());
                                        }
                                        case 3 -> {
                                            System.out.println(">>>>>>>>>Dịch Vụ<<<<<<<<<<");
                                            System.out.println("Hệ thống đang nâng cấp");
                                            machine.showPc();
                                        }
                                        case 0 -> AccountManage.currentName = null;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Tài khoản hoặc mật khẩu không chính xác!");
                        }
                    }
                    case 2 -> {
                        System.out.println("----Đăng Ký----");
                        accountManage.add();
                    }
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nhập Lại!");
        }
    }
}
