package org.com.lessons.delete_relation_objects;

public class AuthorDaoImpl {
    AdDaoImpl adDao;

    public void deleteById(int id) {
        adDao.deleteAllByAuthorId(id);
        //delete author by id
    }
}
