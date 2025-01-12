package domain.controllers;

import domain.model.UserEntity;
import domain.repository.IRepository;
import presentation.admin.AdminViewEvent;
import presentation.admin.AdminViewState;

public class AdminController {
    private IRepository repository;
    private AdminViewState state;

    public AdminController(IRepository repository, AdminViewState state) {
        this.repository = repository;
        this.state = state;
    }

    public void registerUser(UserEntity user) {
        repository.addUser(user);
    }

    public void loginUser(UserEntity user) {
//        UserEntity existingUser = repository.getUserById(user.getId());
//        if (existingUser != null) {
            // Set user as logged in (assuming a `setLoggedIn` method exists)
//            existingUser.setLoggedIn(true);
//            repository.updateUser(existingUser);
//        }
    }

    public void handleEvent(AdminViewEvent event) {
        // Handle the event logic here
    }

    public void updateState(AdminViewState newState) {
        this.state = newState;
    }

    public void handleLoginClick() {
        // Logic to handle login click
    }

    public void handleRegisterClick() {
        // Logic to handle register click
    }

    public void handleForgotPasswordClick() {
        // Logic to handle forgot password functionality
    }
}
