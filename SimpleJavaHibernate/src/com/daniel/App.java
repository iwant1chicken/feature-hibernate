package com.daniel;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.daniel.dao.UserDao;
import com.daniel.model.User;

public class App {

    public static void main(String[] args) {
        UserDao dao = new UserDao();
        final int v_userid;
        final String v_firstName;
        final String v_lastName;
        final Date v_dob;
        final String v_email;
        // Add new user
        User user = new User();
        User testoutput = new User();
        user.setFirstName("Cody");
        user.setLastName("Delpozzo");
        try {
            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("1989-12-14");
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail("iwant1chicken@gmail.com");
        //dao.addUser(user);
//
//        // Update user
        user.setEmail("iwant1chicken@live.com");
        //not setting an id since the id column is serialized
        //user.setUserid(2);
        //dao.updateUser(user);

        // Delete user
        //dao.deleteUser(2);

        // Get all users
        for (User iter : dao.getAllUsers()) {
            System.out.println(iter);
        }

        // Get user by id
        System.out.println(dao.getUserById(1));
        testoutput = dao.getUserById(1);
        v_userid = testoutput.getUserid();
        v_firstName = testoutput.getFirstName();
        v_lastName = testoutput.getLastName();
        v_dob = testoutput.getDob();
        v_email = testoutput.getEmail();
        System.out.println(v_userid + "userid " + "name: " + v_firstName  + v_lastName + " date:" + v_dob + " email:" + v_email);
    }

}