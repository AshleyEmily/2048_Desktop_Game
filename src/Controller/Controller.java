package Controller;


import Model.Model;
import View.View;


public class controller {
    private Model model;
    private View view;

    public static void main(String[] args) {
        new controller();
    }

    public controller(){
        model = new Model();
        view = new View();
        view.display();
    }
}
