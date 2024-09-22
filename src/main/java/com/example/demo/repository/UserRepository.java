package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepository {
    public void create(User user) {
        if (user.getId() == null) {
            System.out.println("Save - recebendo o usuario na camada de repositorio");
            System.out.println(user);

        } else {
            System.out.println("UPDATE - recebendo o usuário na camada de repositório");

        }
    }

    public void deleteById(Integer id) {
        System.out.println("List - recebendo o id: %d para deletar");
        System.out.println("id");
    }

    public List<User> findAll() {
        System.out.println("List - listando os usuarios do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("Vitorio", "password"));
        users.add(new User("Leticia", "password"));
        return users;

    }

    public User findByUsername(String username) {
        System.out.println(String.format("Find/username - recebendo o username: %s!", username));
        return new User(username, "password");
    }
}
