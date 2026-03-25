package za.ac.cput.repository;

public interface IRepositry<T,ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);

}
