package pt.upskill.projeto2.financemanager.accounts.formats;

import pt.upskill.projeto2.financemanager.accounts.Account;
import pt.upskill.projeto2.financemanager.accounts.StatementLine;
import pt.upskill.projeto2.financemanager.date.Date;

public class FileAccountFormat {

    public String format(Account a1) {
        LongStatementFormat longStatementFormat = new LongStatementFormat();
        String nl = System.getProperty("line.separator");
        String s2 = "Account Info - " + new Date().toString() + nl
                + "Account  ;"+ a1.getId() +" ; EUR  ;"+ a1.getName() + " ;SavingsAccount ;" + nl
                + "Start Date ;"+ a1.getStartDate() + "" + nl
                + "End Date ;" + a1.getEndDate() + nl
                + longStatementFormat.fields().replaceAll("\t", ";").trim() + nl; //colocar for da lista de statements
        for (StatementLine statementLine: a1.getStatementLineList()) {
            s2+=longStatementFormat.format(statementLine).replaceAll("\t", ";").trim() + nl;
        }

        return s2;

    }
}
