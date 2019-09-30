package id.co.example.scheduler.factory;

import id.co.example.scheduler.dto.TransactionDto;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerFactory {

    public TransactionDto createTransactionDto(final String transactionName, final double value){
        final TransactionDto transactionDto = new TransactionDto();
        transactionDto.setTransactionName(transactionName);
        transactionDto.setValue(value);
        transactionDto.setCraetedDate(new Date());
        return transactionDto;
    }

}
