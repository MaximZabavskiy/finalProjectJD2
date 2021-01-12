package by.zabavskiy.repository;

/*Generic interface for CRUD operations
* @params K - primary key of object
*         V - object type*/
public interface CrudRepository<K,V> {

    V update(V object);

    V findById(K key);
}
