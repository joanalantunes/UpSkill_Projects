package pt.upskill.projeto2.financemanager.accounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.upskill.projeto2.financemanager.categories.Category;
import pt.upskill.projeto2.financemanager.date.Date;


public class StatementLine {

	protected Date date;
	protected Date valueDate;
	protected String description;
	protected double draft;
	protected double credit;
	protected double accountingBalance;
	protected double availableBalance;
	protected Category category;
	protected List <StatementLine> listStatements = new ArrayList<>();


	public StatementLine(Date date, Date valueDate, String description, double draft, double credit, double accountingBalance, double availableBalance, Category category) {

		if(date == null || description == "" || description == null || draft > 0 || credit < 0){
			throw new IllegalArgumentException();
		}


		this.date = date;
		this.valueDate = valueDate;
		this.description = description;
		this.draft = draft;
		this.credit = credit;
		this.accountingBalance = accountingBalance;
		this.availableBalance = availableBalance;
		this.category = category;

	}

	public Date getDate() {
		return date;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public String getDescription() {
		return description;
	}

	public double getDraft() {
		return draft;
	}

	public double getCredit() {
		return credit;
	}

	public double getAccountingBalance() {
		return accountingBalance;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public static StatementLine newStatementLine(Scanner s) {
		try {
			while (s.hasNextLine()) {
				String line = s.nextLine();
				//if (Character.isDigit(line.charAt(0))) {
					String[] tokens = line.split(" ;");
					String[] dates = tokens[0].split("-");
					Date date = new Date(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
					String[] valueDates = tokens[1].split("-");
					Date valueDate = new Date(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
					String description = tokens[2];
					double draft = Double.parseDouble(tokens[3]);
					double credit = Double.parseDouble(tokens[4]);
					double accountingBalance = Double.parseDouble(tokens[5]);
					double availableBalance = Double.parseDouble(tokens[6]);
					Category category = new Category("");
					StatementLine statementLine = new StatementLine(date, valueDate, description, draft, credit, accountingBalance, availableBalance, category);

					return statementLine;

				//}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}
}


