package pt.upskill.projeto2.financemanager;

import pt.upskill.projeto2.financemanager.accounts.Account;

import java.io.File;

/**
 * @author upSkill 2020
 * <p>
 * ...
 */

public class Main {

    public static void main(String[] args) {

        PersonalFinanceManager personalFinanceManager = new PersonalFinanceManager();
        PersonalFinanceManagerUserInterface gui = new PersonalFinanceManagerUserInterface(personalFinanceManager);

        gui.execute();

        Account.newAccount(new File("src/pt/upskill/projeto2/statements/1234567890985.csv"));


    }

}
