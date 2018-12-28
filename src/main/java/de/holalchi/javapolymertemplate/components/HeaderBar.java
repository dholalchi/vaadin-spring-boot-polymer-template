package de.holalchi.javapolymertemplate.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.templatemodel.TemplateModel;
import de.holalchi.javapolymertemplate.ui.model.PanelMetaData;

import java.util.ArrayList;
import java.util.List;

@Tag("header-bar")
@HtmlImport("src/components/header-bar.html")
public class HeaderBar extends PolymerTemplate<TemplateModel> implements AfterNavigationObserver {

    private static final String VAADIN = "vaadin";
    private final List<String> links = new ArrayList<>();
    private String defaultPage;

    @Id("tabs")
    private Tabs tabs;


    public void init(List<PanelMetaData> panelMetaData, String defaultPage) {
        this.defaultPage = defaultPage;

        for (PanelMetaData metaData : panelMetaData) {
            IronIcon icon = new IronIcon(VAADIN, metaData.getIcon());
            Tab tab = new Tab(icon, new Span(metaData.getTitle()));
            tab.getElement().setAttribute("theme", "icon-on-top");
            links.add(metaData.getLink());
            tabs.add(tab);
        }
        tabs.addSelectedChangeListener(e -> navigate());
    }

    private void navigate() {
        int index = tabs.getSelectedIndex();
        if (index >= 0 && index < links.size()) {
            String page = links.get(index);
            UI.getCurrent().navigate(page);
        }
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        String link = event.getLocation().getFirstSegment().isEmpty() ? defaultPage :
                event.getLocation().getFirstSegment();
        tabs.setSelectedIndex(links.indexOf(link));
        UI.getCurrent().navigate(link);
    }
}
