package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.LoginTicketMapper;
import com.nowcoder.community.dao.MessageMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.Message;
import com.nowcoder.community.util.CommunityUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.standard.inline.StandardTextInliner;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10,0);
        for (DiscussPost post : list){
            System.out.println(post);
        }
    }

    @Test
    public void testSelectByTicket(){

        LoginTicket loginTicket = loginTicketMapper.selectByTicket("hahaha");
        System.out.println(loginTicket.toString());
    }

    @Test
    public void testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(1);
        loginTicket.setTicket("hahaha");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date());
        int index = loginTicketMapper.insertLoginTicket(loginTicket);
        System.out.println(index);
    }

    /**
     * 验证md5加密后的密码
     */
    @Test
    public void getPassword(){
        String password = CommunityUtil.md5("12345613937");
        System.out.println("密码："+password);

    }


    @Test
    public void testSelectLetters(){
        List<Message> list = messageMapper.selectConversations(111,0,20);

        for (Message message : list){
            System.out.println(message);
        }

        int count = messageMapper.selectConversationCount(111);
        System.out.println(count);

        list = messageMapper.selectLetters("111_112",0,10);
        for (Message message : list){
            System.out.println(message);
        }

        count = messageMapper.selectLetterCount("111_112");
        System.out.println(count);

    }

}
