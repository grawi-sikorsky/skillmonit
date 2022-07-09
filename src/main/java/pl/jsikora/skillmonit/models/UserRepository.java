package pl.jsikora.skillmonit.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
    User findByUsername(String username);
    User findByUUID(String uuid);
    
    @Transactional
    void deleteByUUID(String uuid);
}