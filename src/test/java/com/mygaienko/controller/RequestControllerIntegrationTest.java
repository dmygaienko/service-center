package com.mygaienko.controller;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.util.NestedServletException;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by enda1n on 13.11.2016.
 */
/*@DatabaseSetup(
        value = "/com/mygaienko/dao/RequestDaoIntegrationTest.xml",
        type = DatabaseOperation.CLEAN_INSERT)*/
public class RequestControllerIntegrationTest extends BaseControllerIntegrationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testBackup() throws Exception {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("BACKUP TO 'myFile.zip'").execute();
    }

    @Test
    @WithMockUser(username = "email@test.com", roles = "MASTER")
    public void testFindByFirstNameAsMaster() throws Exception {
        doFindById(1);
    }

    @Test
    @WithMockUser(username = "email@test.com", roles = "CLIENT")
    public void testFindByFirstNameAsOwnerClient() throws Exception {
        doFindById(1);
    }

    @Test
    @WithMockUser(username = "email@test.com", roles = "CLIENT")
    public void testGetLatest() throws Exception {
        mockMvc.perform(get("/api/request/latest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test(expected = NestedServletException.class)
    @WithMockUser(username = "email@test.com", roles = "CLIENT")
    public void testFindByFirstNameAsNotOwnerClient() throws Exception {
        doFindById(2);
    }

    private void doFindById(final int id) throws Exception {
        mockMvc.perform(get("/api/request/byId/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
