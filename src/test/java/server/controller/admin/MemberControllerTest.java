package server.controller.admin;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import server.service.MemberService;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MemberService memberService;
    @Mock
    private Model model;

    @Autowired
    MemberController underTest;

    @Test
    void testSelectMember() throws Exception {
        mockMvc.perform(get("/member/selMember"))
                .andExpect(status().isOk())
                .andExpect(view().name("selectMember"))
                .andExpect(model().attributeExists("memberList"));
    }

    @Test
    void testSelectByCardId() throws Exception {
        mockMvc.perform(get("/member/selByCard"))
                .andExpect(status().isOk())
                .andExpect(view().name("selectByMemberAccount"))
                .andExpect(model().attributeExists("memberList"));
    }

    @Test
    void testToAddMember() throws Exception {
        mockMvc.perform(get("/member/toAddMember"))
                .andExpect(status().isOk())
                .andExpect(view().name("addMember"));
    }

    @Test
    void testToSelectByCardId() throws Exception {
        mockMvc.perform(get("/member/toSelByCard"))
                .andExpect(status().isOk())
                .andExpect(view().name("selectByMemberAccount"));
    }

    @Test
    void testToUpdateMember() throws Exception {
        mockMvc.perform(get("/member/toUpdateMember"))
                .andExpect(status().isOk())
                .andExpect(view().name("updateMember"))
                .andExpect(model().attributeExists("memberList"));
    }
}
