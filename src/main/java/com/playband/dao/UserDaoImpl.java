package com.playband.dao;

import com.playband.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User findById(int id) {
        User user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }

    public User findByEmail(String email) {
        logger.info("Email: {}", email);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        User user = (User) crit.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getRoles());
		}*/
        return (List<User>) criteria.list();
    }

    public void save(User user) {
        persist(user);
    }

    public void deleteByEmail(String email) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        User user = (User) crit.uniqueResult();
        delete(user);
    }

}
