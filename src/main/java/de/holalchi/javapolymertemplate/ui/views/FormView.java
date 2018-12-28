package de.holalchi.javapolymertemplate.ui.views;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.Optional;

@Tag("form-view")
@HtmlImport("src/views/form-view.html")
@Route(value = "form", layout = MainView.class)
@PageTitle("Form")
public class FormView extends PolymerTemplate<FormView.InputFormModel> {
    private static final String EMPTY_NAME_GREETING = "Please enter your name";

    @Id("inputId")
    private TextField textField;

    @Id("buttonId")
    private Button button;

    @EventHandler
    private void sayHello() {
        getModel().setGreeting(Optional.ofNullable(getModel().getUserInput())
                .filter(userInput -> !userInput.isEmpty())
                .map(greeting -> String.format("Hello %s!", greeting))
                .orElse(EMPTY_NAME_GREETING));
    }


    public interface InputFormModel extends TemplateModel {

        String getUserInput();

        void setGreeting(String greeting);
    }
}
