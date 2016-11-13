package com.mygaienko.controller;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by enda1n on 13.11.2016.
 */

@Transactional(transactionManager = "transactionManager")
@DatabaseSetup(
        value = "/com/mygaienko/dao/UserDaoIntegrationTest.xml",
        type = DatabaseOperation.CLEAN_INSERT)
public class UserControllerIntegrationTest extends BaseControllerIntegrationTest{

    @Test
    @WithMockUser(username = "email@test.com", roles = "MASTER")
    public void testFindByFirstNameAsMaster() throws Exception {
        doFindByFirstName();
    }

    @Test(expected = /*AccessDeniedException*/NestedServletException.class)
    @WithMockUser(username = "email@test.com", roles = "CLIENT")
    public void testFindByFirstNameAsClient() throws Exception {
        doFindByFirstName();
    }

    private ResultActions doFindByFirstName() throws Exception {
        return mockMvc.perform(get("/user/find/byFirstName/FirstName"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}