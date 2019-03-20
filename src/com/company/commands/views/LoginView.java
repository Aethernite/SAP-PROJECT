package com.company.commands.views;

import com.company.commands.Command;
import com.company.commands.misc.LoadAccountFile;
import com.company.utils.storage.StorageManager;
import com.company.objects.Account;

import java.util.Scanner;

import static com.company.utils.frontend.AnsiColorCodes.*;

public class LoginView implements Command {
    private Command parent;
    private static Scanner sc = new Scanner(System.in);

    public LoginView(Command parent){
    this.parent = parent;
    }

    @Override
    public Command execute(){
        System.out.println(ANSI_YELLOW +"=========================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Login form:" + ANSI_RESET);
        System.out.print("Enter username:");
        String username = sc.nextLine();
        System.out.print("Enter password:");
        String password = sc.nextLine();
        Account user = new Account(username, password);
        if (StorageManager.checkLogin(user)){
            StorageManager.setUser(user);
            System.out.println(ANSI_GREEN + "LOGIN SUCCESSFUL!" + ANSI_RESET);
            return new LoadAccountFile(this);
        }
        System.out.println(ANSI_RED + "Wrong password/User doesn't exist" + ANSI_RESET);
        return this;

    }
}