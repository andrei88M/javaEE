package dao;

import entity.People;

public interface PeopleDAO extends DAO<People>{
    People get(int id);
}
