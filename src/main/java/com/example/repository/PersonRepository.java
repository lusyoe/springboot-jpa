package com.example.repository;

import com.example.bean.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by luhaoyuan on 2017/2/9.
 */

@SuppressWarnings("JpaQlInspection")
public interface PersonRepository extends JpaRepository<Person, Long>{

    /**
     * 通过名字相等查询，参数为name
     * 相当于JPQL: SELECT p FROM Person p WHERE p.name=?1
     */
    List<Person> findByName(String name);


    /**
     * 通过名字Like查询，参数为name
     * 相当于JPQL：SELECT p FROM Person p WHERE p.name LIKE ?1
     */
    List<Person> findByNameLike(String name);

    /**
     * 通过名字和地址查询，参数为name和address
     * 相当于JPQL: SELECT p FROM Person p WHERE p.name=?1 AND p.address=?2
     */
    List<Person> findByNameAndAddress(String name, String address);


    /**
     * 获得符合查询条件的前10条数据
     */
    List<Person> findFirst10ByName(String name);


    /**
     * 获得符合查询条件的前30条数据
     */
    List<Person> findTop30ByName(String name);


    /**
     * @Query注解的使用
     */
    @Query("select p from Person p where p.address=?1")
    List<Person> findByAddress(String address);


    /**
     * 更新语句
     * @param name
     * @return 更新语言影响的行数
     */
    @Modifying
    @Transactional
    @Query("update Person p set p.name=?1")
    int setName(String name);


    //=========分页和排序============
    // 调用personRepository.findByName("xx", new Sort(Direction.ASC, "age"));
    List<Person> findByName(String name, Sort sort);

    // 调用 personRepository.findByName("xx", new PageRequest(0, 10));
    Page<Person> findByName(String name, Pageable pageable);



    Person findOneByName(String name);


}
