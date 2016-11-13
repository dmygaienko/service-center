package com.mygaienko.dao;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.mygaienko.model.User;
import com.mygaienko.model.UserAuthority;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


@DatabaseSetup(
        value = "/com/mygaienko/dao/UserDaoIntegrationTest.xml",
        type = DatabaseOperation.CLEAN_INSERT)
public class UserDaoIntegrationTest extends BaseDaoIntegrationTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetByEmail() throws Exception {
        User user = userDao.getByEmail("email@test.com");
        assertEquals(1L, user.getId());
        assertThat(user.getAuthorities(), containsInAnyOrder(UserAuthority.ROLE_MASTER, UserAuthority.ROLE_CLIENT));
    }

}
