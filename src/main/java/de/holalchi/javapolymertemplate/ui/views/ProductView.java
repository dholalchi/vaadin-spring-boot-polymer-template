package de.holalchi.javapolymertemplate.ui.views;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.Arrays;
import java.util.List;

@Tag("product-view")
@HtmlImport("src/views/product-view.html")
@Route(value = "products", layout = MainView.class)
@PageTitle("Products")
public class ProductView extends PolymerTemplate<TemplateModel> {

    @Id("combo1")
    private ComboBox<String> comboBox1;

    @Id("combo2")
    private ComboBox<String> comboBox2;

    public ProductView() {
        List<String> items = Arrays.asList("Box1", "Box2", "Box3", "Box4");
        comboBox1.setItems(items);
        comboBox2.setItems(items);
    }

}
