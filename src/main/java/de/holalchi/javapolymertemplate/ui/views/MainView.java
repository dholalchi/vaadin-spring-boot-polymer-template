package de.holalchi.javapolymertemplate.ui.views;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.templatemodel.TemplateModel;
import de.holalchi.javapolymertemplate.components.HeaderBar;
import de.holalchi.javapolymertemplate.ui.model.PanelMetaData;

import java.util.ArrayList;
import java.util.List;

@Tag("main-view")
@HtmlImport("src/views/main-view.html")
@Route(value = "")
@PageTitle("Application")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes")
public class MainView extends PolymerTemplate<TemplateModel>
        implements RouterLayout {

    private static final String FORM = "form";
    private static final String PRODUCTS = "products";
    private static final String FORM_TITLE = "Form";
    private static final String PRODUCTS_TITLE = "Products";

    @Id("header")
    private HeaderBar headerBar;

    public MainView() {
        final List<PanelMetaData> panelMetaData = new ArrayList<>();
        panelMetaData.add(new PanelMetaData(FORM, VaadinIcon.INPUT.name().toLowerCase(), FORM_TITLE));
        panelMetaData.add(new PanelMetaData(PRODUCTS, VaadinIcon.PACKAGE.name().toLowerCase(), PRODUCTS_TITLE));
        headerBar.init(panelMetaData, FORM);
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        if (content != null) {
            getElement().appendChild(content.getElement());
        }
    }
}
