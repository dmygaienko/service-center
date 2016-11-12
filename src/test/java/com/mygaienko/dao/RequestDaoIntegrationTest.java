package com.mygaienko.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.mygaienko.app.Application;
import com.mygaienko.model.*;
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

import java.util.List;

import static junit.framework.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
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
        User user = new User();
        /*user.setId(1L);*/
        user.setAddress("Address");
        user.setContactNumber("ContactNumber");
        user.setFirstName("FirstName");
        user.setSurname("Surname");

        userDao.createUser(user);

        User referencedUser = userDao.load(1);

        Request request = new Request();
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
    public void testCreateRequestWithAlreadySavedUser() throws Exception {
       /* Session session = userDao.getEntityManager().unwrap(Session.class);
        session.load(User.class, 1L);*/

        Request request = new Request();
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
        User user = new User();
        /*user.setId(1L);*/
        user.setAddress("Address");
        user.setContactNumber("ContactNumber");
        user.setFirstName("FirstName");
        user.setSurname("Surname");

        userDao.load(1);
        userDao.createUser(user);
        userDao.getByFirstName("FirstName");
    }

    @Test
    public void testFindByAttributes() throws Exception {
        Request request = new Request();
        request.setStatus(RequestStatus.CREATED);
        request.setProduct(new Product(null, new Maker(null, "maker1"), "product1"));
        List<Request> actuals = requestDao.findByAttributes(request);

        assertEquals("maker1", actuals.get(0).getMakerName());
        assertEquals("product1", actuals.get(0).getProductName());
    }

    @Test
    public void testFindByAttributesWithMaker() throws Exception {
        Request request = new Request();
        request.setStatus(RequestStatus.CREATED);
        request.setProduct(new Product(null, new Maker(null, "maker1"), null));
        List<Request> actuals = requestDao.findByAttributes(request);

        assertEquals("maker1", actuals.get(0).getMakerName());
        assertEquals("product1", actuals.get(0).getProductName());
    }

    @Test
    public void testGetAll() throws Exception {
        List<Request> actuals = requestDao.getAll();

        assertEquals("maker1", actuals.get(0).getMakerName());
        assertEquals("product1", actuals.get(0).getProductName());
    }

}
