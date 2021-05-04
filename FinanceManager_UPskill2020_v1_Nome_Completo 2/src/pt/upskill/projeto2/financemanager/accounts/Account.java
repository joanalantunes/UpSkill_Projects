package pt.upskill.projeto2.financemanager.accounts;

import pt.upskill.projeto2.financemanager.categories.Category;
import pt.upskill.projeto2.financemanager.date.Date;
import pt.upskill.projeto2.financemanager.filters.BeforeDateSelector;
import pt.upskill.projeto2.financemanager.filters.Filter;

import javax.print.attribute.IntegerSyntax;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {

    private long id;
    private String name;
    private String additionalInfo;
    private double currentBalance;
    private double estimatedAverageBalance;
    private Date startDate;
    private Date endDate;
    private double interestRate;
    private String typeAccount;
    private List<StatementLine> statementLineList;


    public Account(long id, String name) {
        this.id = id;
        this.name = name;
        this.additionalInfo = "";
        this.interestRate = BanksConstants.normalInterestRate();
        this.statementLineList = new ArrayList<>();
    }

    public Account(long id, String name, String typeAccount, String additionalInfo, Date startDate, Date endDate, List<StatementLine> statementLineList) {
        this.id = id;
        this.name=name;
        this.typeAccount = typeAccount;
        this.additionalInfo = additionalInfo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statementLineList=statementLineList;
    }


    public static Account newAccount(File file) {
        Account account = null;
        long id = 0;
        String typeAccount = null;
        String name = null;
        String additionalInfo = " ";
        Date startDate = null;
        Date endDate = null;
        List<StatementLine> statementLineList= new ArrayList<>();



        try {
            Scanner s = new Scanner(file);
            while(s.hasNextLine()) {
                String linha = s.nextLine();
                if(linha.startsWith("Account Info ")){
                    String[] tokens = linha.split("- ");
                    String[] dates = tokens [1].split("-");
                    Date date = new Date(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
               }
                if(linha.startsWith("Account  ;")){
                    String[] tokens = linha.split(" ;");
                    id = Long.parseLong(tokens[1]);
                    typeAccount = tokens[2];
                    name = tokens[3];
                    additionalInfo = tokens[4];
                }
                if(linha.startsWith("Start Date")){
                    String[] tokens = linha.split(";");
                    String [] startDateStr = tokens[1].split("-");
                    startDate = new Date(Integer.parseInt(startDateStr[0]), Integer.parseInt(startDateStr[1]), Integer.parseInt(startDateStr[2]));
                }
                if(linha.startsWith("End Date")){
                    String[] tokens = linha.split(";");
                    String [] endDateStr = tokens[1].split("-");
                    endDate = new Date(Integer.parseInt(endDateStr[0]), Integer.parseInt(endDateStr[1]), Integer.parseInt(endDateStr[2]));
                }
                if(linha.length() > 0 && Character.isDigit(linha.charAt(0))){
                    String[] tokens = linha.split((" ;"));


                    String [] dateStr = tokens[0].split("-");
                    Date date = new Date(Integer.parseInt(dateStr[0]), Integer.parseInt(dateStr[1]), Integer.parseInt(dateStr[2]));


                    String [] valueDateStr = tokens[1].split("-");
                    Date valueDate = new Date(Integer.parseInt(valueDateStr[0]), Integer.parseInt(valueDateStr[1]), Integer.parseInt(valueDateStr[2]));

                    String description = tokens[2];

                    statementLineList.add(new StatementLine(date, valueDate, description, Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), Double.parseDouble(tokens[6]), null));
                }
            }

            account = new Account(id, name, typeAccount, additionalInfo, startDate, endDate, statementLineList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return account;



    }


    public double estimatedAverageBalance() {
        return estimatedAverageBalance;
    }

    public void removeStatementLinesBefore(Date date) {/*
        BeforeDateSelector selector = new BeforeDateSelector(date);
        Filter<StatementLine,BeforeDateSelector> filter = new Filter <> (selector);
        statementLines = (List <StatementLine>) filter.apply(statementLines);*/
    }

    public double totalDraftsForCategorySince(Category category, Date date) {
        double sum = 0.0;

        for (StatementLine statementLine: statementLineList) {
            if (category.equals(statementLine.getCategory()) && statementLine.getDate().compareTo(date) >= 0) {
                sum+=statementLine.getDraft();
            }
        }

        return sum;
    }

    public void autoCategorizeStatements(List<Category> categories) {
        for (StatementLine statementLine: statementLineList) {
            for (Category category: categories) {
                if (category.hasDescription(statementLine.getDescription())){
                    statementLine.setCategory(category);
                    break;
                }
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double totalForMonth(int i, int i1) {
        double sum = 0;
        for (StatementLine statementLine: statementLineList) {
            if (statementLine.getDate().getMonth().ordinal() == i && statementLine.getDate().getYear() == i1) {
                sum+= statementLine.getDraft();
            }
        }

        return sum;
    }

    public double currentBalance() {
        return currentBalance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String additionalInfo() {
        return additionalInfo;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void addStatementLine(StatementLine statementLine) {
        statementLineList.add(statementLine);
        currentBalance = statementLine.getAvailableBalance();

        if (startDate == null) {
            startDate = statementLine.getDate();
        } else if (startDate.after(statementLine.getDate())) {
            startDate = statementLine.getDate();
        }

        if (endDate == null) {
            endDate = statementLine.getDate();
        } else if (endDate.before(statementLine.getDate())) {
            endDate = statementLine.getDate();
        }

        double estimatedAverageBalance1 = 0.0;
        for (StatementLine statementLine1: statementLineList) {
            estimatedAverageBalance1+=statementLine1.getAvailableBalance();
        }
        this.estimatedAverageBalance = estimatedAverageBalance1/statementLineList.size();
    }

    public long getId() {
        return id;
    }

    public List<StatementLine> getStatementLineList() {
        return statementLineList;
    }
}
