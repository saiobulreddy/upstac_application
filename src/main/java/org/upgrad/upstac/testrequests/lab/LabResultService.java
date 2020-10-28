package org.upgrad.upstac.testrequests.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Validated
public class LabResultService {


    @Autowired
    private LabResultRepository labResultRepository;


    private static Logger logger = LoggerFactory.getLogger(LabResultService.class);


    private LabResult createLabResult(User tester, TestRequest testRequest) {
        LabResult labResult = new LabResult();
        labResult.setTester(tester);
        labResult.setRequest(testRequest);
        return saveLabResult(labResult);
    }

    @Transactional
    LabResult saveLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }


    public LabResult assignForLabTest(TestRequest testRequest, User tester) {
        return createLabResult(tester, testRequest);
    }


    public LabResult updateLabTest(TestRequest testRequest, CreateLabResult createLabResult) {
        LabResult labResult = new LabResult();
        labResult.setBloodPressure(createLabResult.getBloodPressure());
        labResult.setComments(createLabResult.getComments());
        labResult.setOxygenLevel(createLabResult.getOxygenLevel());
        labResult.setTemperature(createLabResult.getTemperature());
        labResult.setHeartBeat(createLabResult.getHeartBeat());
        labResult.setResult(createLabResult.getResult());
        labResult.setRequest(testRequest);
        labResult.setUpdatedOn(LocalDate.now());
        labResult.setTester(testRequest.getCreatedBy());
        return saveLabResult(labResult);
    }


}
