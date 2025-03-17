package Repos;

import Domain.ID;
import Exceptions.RepoException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneralRepo<T extends ID> {
    List<T> data = new ArrayList<T>();

    public void add(T t) {
        data.add(t);
    }


    public void remove(int id) throws RepoException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id)
                data.remove(i);
        }
        throw new RepoException("No such ID");
    }


    public int size() {
        return data.size();
    }

    public T getT(int id) throws RepoException {
        for (T t : data) {
            if (t.getId() == id)
                return t;
        }
        throw new RepoException("No such ID");
    }

    @Override
    public String toString() {
        return "GeneralRepo: " + data;
    }
}
