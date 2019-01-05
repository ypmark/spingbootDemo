package com.ypmai.blog.repository;

import com.ypmai.blog.domain.User;

import java.util.List;

public interface UserRepository {

    /**
     * @Description:创建或修改用户
     */
    User saveOrUpdateUser(User user);

    /**
     * @Description:根据id获取user
     */
    User getUserById(Long id);

    /**
     * @Description:根据id删除user
     */
    void deleteUser(Long id);

    /**
     * @Description:返回所有用户
     */
    List<User> listUsers();
}
