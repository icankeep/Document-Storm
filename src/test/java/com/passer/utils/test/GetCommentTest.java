package com.passer.utils.test;

import com.passer.domain.Comment;
import com.passer.utils.crawl.CommentsCrawl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: passer
 * @Date: 19-6-1 上午9:18
 * @Version 1.0
 */
public class GetCommentTest {

    @Test
    public void testGetComment() throws Exception{
        Comment comment = CommentsCrawl.getComment();
        Assert.assertNotNull(comment);
    }
}
