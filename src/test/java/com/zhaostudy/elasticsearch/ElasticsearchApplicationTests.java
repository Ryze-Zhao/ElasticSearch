package com.zhaostudy.elasticsearch;

import com.zhaostudy.elasticsearch.repository.domain.Book;
import com.zhaostudy.elasticsearch.service.BookService;
import com.zhaostudy.elasticsearch.service.EsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {
    @Autowired
    private EsService esService;

    @Test
    public void createIndex() {
        esService.createIndex(Book.class);
    }
    @Test
    public void deleteIndex() {
        //删除,是根据ID删除的，所以要保证id正确
        esService.deleteIndex(Book.class);
    }


    @Autowired
    private BookService bookService;
    @Test
    public void saveBookList() {
        //一个创建 List<Book>的方法
        List<Book> list = createList();
        bookService.saveBookList(list);
    }

    @Test
    public void findAll() {
        List<Book> list = bookService.findAll();
        for (Book book : list) {
            System.out.println(book.toString());
        }
    }

    @Test
    public void findAllByBookNameLike() {
        List<Book> list = bookService.findAllByBookNameLike("论法");
        for (Book book : list) {
            System.out.println(book.toString());
        }
    }
    @Test
    public void deleteAll() {
        //一个创建 List<Book>的方法
        List<Book> list = createList();
        bookService.deleteAll(list);
    }

    public List<Book> createList() {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setId("book");
        book.setBookName("论法的精神");
        book.setContent("《论法的精神》主要内容：公认的十八世纪最伟大的、最深远地影响了历史的作品是哪几部？人们可以很轻易地说出亚当•史密斯的《国富论》、卢梭的《社会契约论》和孟德斯鸠的《论法的精神》。《论法的精神》是法学发展史上为数不多的鸿篇巨制。它以法律为中心，又遍涉经济、政治、宗教、历史、地理等领域，内容极为丰富。《论法的精神》中提出的“追求自由”、“主张法制”、“三权分立”等理论，极大地影响了人类社会的发展进程，成为了美、英、法等国的立国之本。");
        bookList.add(book);
        Book book1 = new Book();
        book1.setId("book1");
        book1.setBookName("西方的没落");
        book1.setContent("奥斯瓦尔德·斯宾格勒（1880-1936年）是德国著名的历史学家和历史哲学家。他出生于德国哈茨山巴的布兰肯堡，曾就读于哈雷大学、慕尼黑大学和柏林大学。青年时代除了研究历史和艺术之外，他还对数学和博物学有浓厚的兴趣，所有这些使他的作品具有一种奇特的风格。1904年，斯宾格勒在哈雷大学获得博士学位，之后成为了一名中学教师。第一次世界大战爆发时，他因健康原因未能被征召入伍。在这期间，他隐居在慕尼黑的一所贫民窟里，在烛光下完成了《西方的没落》一书。此书的出版给斯宾格勒带来了巨大的声誉，许多大学以正式或非正式的方式邀请他执掌教席，可都被他拒绝。此后他一直过着一种近乎于隐居的生活，以历史研究和政论写作自适。1936年5月8日凌晨，斯宾格勒因心脏病突发逝世，他的妹妹们将其埋葬，但未举行任何的吊唁形式。斯宾格勒一生写下大量著作，其中重要的有：《普鲁士人民和社会主义》");
        bookList.add(book1);
        Book book2 = new Book();
        book2.setId("book2");
        book2.setBookName("玩偶之家");
        book2.setContent("《玩偶之家》是对于资本主义私有制下的婚姻关系、对于资产阶级的男权中心思想的一篇义正辞严的控诉书。女主人娜拉表面上是一个未经世故开凿的青年妇女，一贯被人唤作“小鸟儿”、“小松鼠儿”，实际上上她性格善良而坚强，为了丈夫和家庭不惜忍辱负重，甚至准备牺牲自己的名誉。她因挽救丈夫的生命，曾经瞒着他向人借了一笔债；同时想给垂危的父亲省却烦恼，又冒名签了一个字。就是由于这件合情合理的行为，资产阶级的“不讲理的法律”却逼得她走投无路。更令她痛心的是，真相大白之后，最需要丈夫和她同舟共济、承担危局的时刻，她却发现自己为之作出牺牲的丈夫竟是一个虚伪而卑劣的市侩。她终于觉醒过来，认识到自己婚前不过是父亲的玩偶，婚后不过是丈夫的玩偶，从来就没有独立的人格。于是，她毅然决然抛弃丈夫和孩子，从囚笼似的家庭出走了。");
        bookList.add(book2);
        return bookList;
    }
}
