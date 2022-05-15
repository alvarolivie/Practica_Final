package Peroli.Practica_Final.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepoUserTest{

    @Autowired
    private RepositoryUser repoUser;

    @Autowired
    private RepositoryRole repoRole;

    @Test
    public void manyToManyTest(){
        repoUser.findAll().forEach(b->System.err.println(b));

    }
}
