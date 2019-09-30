package id.co.example.scheduler.service.impl;

import id.co.example.scheduler.dto.TransactionDto;
import id.co.example.scheduler.factory.SchedulerFactory;
import id.co.example.scheduler.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private SchedulerFactory schedulerFactory;

    @Override
    public void generateTransaction(final String requestId) {
        double value = ThreadLocalRandom.current().nextDouble();
        final TransactionDto transactionDto = schedulerFactory.createTransactionDto("transactionName", value);
        log.info("TransactionServiceImpl.generateTransaction requestId : {}, transactionDto : {}", requestId, transactionDto);
    }

}
