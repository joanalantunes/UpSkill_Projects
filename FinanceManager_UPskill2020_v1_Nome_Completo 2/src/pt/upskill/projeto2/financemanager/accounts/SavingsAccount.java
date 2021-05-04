package pt.upskill.projeto2.financemanager.accounts;

import pt.upskill.projeto2.financemanager.categories.Category;
import pt.upskill.projeto2.financemanager.date.Date;

public class SavingsAccount extends Account {

    public static Category savingsCategory;
    static {
        savingsCategory = new Category("SAVINGS");
        savingsCategory.addDescription("TRANSF");
        savingsCategory.addDescription("description");
    };

    public SavingsAccount(int id, String name) {
        super(id, name);
    }

    @Override
    public void addStatementLine(StatementLine statementLine) {
        super.addStatementLine(statementLine);
    }

    @Override
    public double estimatedAverageBalance() {
        return super.estimatedAverageBalance();
    }

    @Override
    public double getInterestRate() {
        return BanksConstants.savingsInterestRate();
    }
}
