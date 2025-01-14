package domain.controllers;

import data.repository.Repository;
import domain.model.RaportEntity;
import domain.repository.IRepository;
import presentation.raport.RaportViewEvent;
import presentation.raport.RaportViewState;

import java.util.List;

public class RaportController {
    private IRepository repository;
    private RaportViewState state;

    public RaportController(IRepository repository, RaportViewState state) {
        this.repository = repository;
        this.state = state;
    }

    public List<RaportEntity> getReport() {
        return repository.getAllRaports();
    }

    public void handleEvent(RaportViewEvent event) {
        // Handle the event logic here
    }

    public void updateState(RaportViewState newState) {
        this.state = newState;
    }

    public void handleCreateClick() {
        // Logic to handle creating a report
    }

    public void handleCloseClick() {
        // Logic to handle closing the report view
    }

    public void handleUpdateClick() {
        // Logic to handle updating a report
    }
}