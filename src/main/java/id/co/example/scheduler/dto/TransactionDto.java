package id.co.example.scheduler.dto;

import java.util.Date;

public class TransactionDto {

    private String transactionName;
    private double value;
    private Date craetedDate;


    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getCraetedDate() {
        return craetedDate;
    }

    public void setCraetedDate(Date craetedDate) {
        this.craetedDate = craetedDate;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "transactionName='" + transactionName + '\'' +
                ", value=" + value +
                ", craetedDate=" + craetedDate +
                '}';
    }
}
