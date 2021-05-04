package pt.upskill.projeto2.financemanager.filters;

import pt.upskill.projeto2.financemanager.accounts.StatementLine;

public class NoCategorySelector {

    public boolean isSelected(StatementLine stt2) {
        if(stt2.getCategory() == null) {
            return true;
        }
        else {
            return false;
        }

    }
}
