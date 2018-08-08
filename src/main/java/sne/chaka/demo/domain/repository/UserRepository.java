package sne.chaka.demo.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sne.chaka.demo.domain.User;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	List<User> findByLastName(@Param("name") String lastName);
}
