package server.controller;

import static org.assertj.core.api.Assertions.assertThat;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import server.pojo.Admin;
import server.pojo.Member;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LoginController underTest;

    @Mock
    private Model model;
    @Mock
    private HttpSession session;
    @Mock
    private RedirectAttributes redirectAttributes;

    @Test
    void testAdminLoginSuccess() throws Exception {
        // given
        Admin admin = new Admin();
        admin.setAdminAccount("1001");
        admin.setAdminPassword("123456");
        // when
        String expected = underTest.adminMain(admin, model, session, redirectAttributes);
        // then
        assertThat(expected).isEqualTo("adminMain");
    }

    @Test
    void testAdminLoginFailed() {
        // given
        Admin admin = new Admin();
        admin.setAdminAccount("1");
        admin.setAdminPassword("admin");
        // when
        String expected = underTest.adminMain(admin, model, session, redirectAttributes);
        // then
        assertThat(expected).isEqualTo("redirect:/toAdminLogin");
    }

    @Test
    void testUserLoginSuccess() {
        // given
        Member member = new Member();
        member.setMemberAccount("202153468");
        member.setMemberPassword("123456");
        // when
        String expected = underTest.userMain(member, model, session, redirectAttributes);
        // then
        assertThat(expected).isEqualTo("userMain");
    }

    @Test
    void testUserLoginFailed() {
        // given
        Member member = new Member();
        member.setMemberAccount("202153468");
        member.setMemberPassword("123455");
        // when
        String expected = underTest.userMain(member, model, session, redirectAttributes);
        // then
        assertThat(expected).isEqualTo("redirect:/");
    }
}
