package com.mygaienko.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.mygaienko.app.Application;
import com.mygaienko.model.RequestEntity;
import com.mygaienko.model.RequestStatus;
import com.mygaienko.model.RequestType;
import com.mygaienko.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@TestExecutionListeners(
        {DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
@Transactional(transactionManager = "transactionManager")
@Commit
@DatabaseSetup(
        value = "/com/mygaienko/dao/RequestDaoIntegrationTest.xml",
        type = DatabaseOperation.CLEAN_INSERT)
public class RequestDaoIntegrationTest {

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private UserDao userDao;

    @Test
    @ExpectedDatabase(
            value = "/com/mygaienko/dao/RequestDaoIntegrationTest.testCreateUserAndRequest.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testCreateRequest() throws Exception {
        UserEntity user = new UserEntity();
        /*user.setId(1L);*/
        user.setAddress("Address");
        user.setContactNumber("ContactNumber");
        user.setFirstName("FirstName");
        user.setSurname("Surname");

        userDao.createUser(user);

        UserEntity referencedUser = userDao.load(1);

        RequestEntity request = new RequestEntity();
        request.setClient(referencedUser);
        request.setPaid(false);
        request.setStatus(RequestStatus.CREATED);
        request.setType(RequestType.REPAIR);

        requestDao.createRequest(request);
    }

    @Test
    @ExpectedDatabase(
            value = "/com/mygaienko/dao/RequestDaoIntegrationTest.testCreateUserAndRequest.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testCreateRequestWithAlreadeaSavedUser() throws Exception {
        RequestEntity request = new RequestEntity();
        request.setClient(userDao.load(1));
        request.setPaid(false);
        request.setStatus(RequestStatus.CREATED);
        request.setType(RequestType.REPAIR);

        requestDao.createRequest(request);
    }

    @Test
    @ExpectedDatabase(
            value = "/com/mygaienko/dao/RequestDaoIntegrationTest.testCreateUserAndRequest.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testCreateUser() throws Exception {
        UserEntity user = new UserEntity();
        /*user.setId(1L);*/
        user.setAddress("Address");
        user.setContactNumber("ContactNumber");
        user.setFirstName("FirstName");
        user.setSurname("Surname");


        userDao.load(1);
        userDao.createUser(user);
        userDao.getByFirstName("FirstName");
    }
}
