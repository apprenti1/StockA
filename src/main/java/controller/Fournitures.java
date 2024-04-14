package controller;

import entity.Fourniture;

import repo.FournitureRepository;

public class Fournitures extends Default {
    public Fournitures(Fourniture fourniture) {
        super(fourniture);
    }
    private FournitureRepository fournitureRepository;

}
