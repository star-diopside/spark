package jp.gr.java_conf.stardiopside.ark.web.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import jp.gr.java_conf.stardiopside.ark.core.config.AppConfig;
import jp.gr.java_conf.stardiopside.ark.test.config.TestConfig;
import jp.gr.java_conf.stardiopside.silver.commons.test.support.DatabaseTestSupport;
import jp.gr.java_conf.stardiopside.silver.commons.test.support.SimpleDatabaseTestSupport;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AppConfig.class, TestConfig.class })
@Transactional
@Rollback
public class FilesControllerTest {

    @Inject
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Inject
    @Named("dbunitDataSource")
    private DataSource dataSource;

    private DatabaseTestSupport databaseTestSupport;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()).build();
        databaseTestSupport = new SimpleDatabaseTestSupport(this, dataSource);
        databaseTestSupport.setCsvDataSet("dataset");
        databaseTestSupport.onSetup();
    }

    @After
    public void after() {
        databaseTestSupport.onTearDown();
    }

    @Test
    @WithMockUser
    public void showOkTest() throws Exception {
        mockMvc.perform(get("/files/1")).andExpect(status().isOk()).andExpect(view().name("files/show"))
                .andExpect(model().hasNoErrors());
    }

    @Test
    @WithMockUser
    public void showNotFoundTest() throws Exception {
        mockMvc.perform(get("/files/99")).andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    public void createTest() throws Exception {
        mockMvc.perform(get("/files/create")).andExpect(status().isOk()).andExpect(view().name("files/create"))
                .andExpect(model().hasNoErrors());
    }
}
