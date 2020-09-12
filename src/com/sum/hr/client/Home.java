package com.sum.hr.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.BoxComponent;
import com.gwtext.client.widgets.HTMLPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.grid.PropertyGridPanel;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.sum.hr.client.employee.EmployeeDetail;

public class Home implements EntryPoint {
	public void onModuleLoad() {
		 Panel panel = new Panel();  
	        panel.setBorder(false);  
	        panel.setPaddings(15);  
	        panel.setLayout(new FitLayout());  
	  
	        Panel borderPanel = new Panel();  
	        borderPanel.setLayout(new BorderLayout());  
	  
	        //add north panel  
	        //raw html  
	        BoxComponent northPanel = new BoxComponent();  
	        northPanel.setEl(new HTML("<p>north - generally for menus, toolbars" +  
	                " and/or advertisements</p>").getElement());  
	        northPanel.setHeight(32);  
	        borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));  
	  
	        //add south panel  
	        Panel southPanel = new HTMLPanel("<p>south - generally for informational stuff," +  
	                " also could be for status bar</p>");  
	        southPanel.setHeight(100);  
	        southPanel.setCollapsible(true);  
	        southPanel.setTitle("South");  
	  
	        BorderLayoutData southData = new BorderLayoutData(RegionPosition.SOUTH);  
	        southData.setMinSize(100);  
	        southData.setMaxSize(200);  
	        southData.setMargins(new Margins(0, 0, 0, 0));  
	        southData.setSplit(true);  
	        borderPanel.add(southPanel, southData);  
	  
	        //add east panel  
	        Panel eastPanel = new Panel();  
	        eastPanel.setTitle("East Side");  
	        eastPanel.setCollapsible(true);  
	        eastPanel.setWidth(225);  
	        eastPanel.setLayout(new FitLayout());  
	  
	        BorderLayoutData eastData = new BorderLayoutData(RegionPosition.EAST);  
	        eastData.setSplit(true);  
	        eastData.setMinSize(175);  
	        eastData.setMaxSize(400);  
	        eastData.setMargins(new Margins(0, 0, 5, 0));  
	  
	        borderPanel.add(eastPanel, eastData);  
	  
	        TabPanel tabPanel = new TabPanel();  
	        tabPanel.setBorder(false);  
	        tabPanel.setActiveTab(1);  
	  
	        Panel tabOne = new Panel();  
	        tabOne.setHtml("<p>A TabPanel component can be a region.</p>");  
	        tabOne.setTitle("A Tab");  
	        tabOne.setAutoScroll(true);  
	        tabPanel.add(tabOne);  
	  
	        PropertyGridPanel propertyGrid = new PropertyGridPanel();  
	        propertyGrid.setTitle("Property Grid");  
	  
	        Map<String, Object> source = new HashMap<String, Object>();  
	        source.put("(name)", "Properties Grid");  
	        source.put("grouping", Boolean.FALSE);  
	        source.put("autoFitColumns", Boolean.TRUE);  
	        source.put("productionQuality", Boolean.FALSE);  
	        source.put("created", new Date());  
	        source.put("tested", Boolean.FALSE);  
	        source.put("version", new Float(0.1f));  
	        source.put("borderWidth", new Integer(1));  
	  
	        propertyGrid.setSource(source);  
	  
	        tabPanel.add(propertyGrid);  
	        eastPanel.add(tabPanel);  
	  
	        final AccordionLayout accordion = new AccordionLayout(true);  
	  
	        Panel westPanel = new Panel();  
	        westPanel.setTitle("West");  
	        westPanel.setCollapsible(true);  
	        westPanel.setWidth(200);  
	        westPanel.setLayout(accordion);  
	  
	        Panel navPanel = new Panel();  
	        navPanel.setHtml("<p>Hi. I'm the west panel.</p>");  
	        navPanel.setTitle("Navigation");  
	        navPanel.setBorder(false);  
	        navPanel.setIconCls("forlder-icon");  
	        westPanel.add(navPanel);  
	  
	        Panel settingsPanel = new Panel();  
	        settingsPanel.setHtml("<p>Some settings in here.</p>");  
	        settingsPanel.setTitle("Settings");  
	        settingsPanel.setBorder(false);  
	        settingsPanel.setIconCls("settings-icon");  
	        westPanel.add(settingsPanel);  
	  
	        BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);  
	        westData.setSplit(true);  
	        westData.setMinSize(175);  
	        westData.setMaxSize(400);  
	        westData.setMargins(new Margins(0, 5, 0, 0));  
	  
	        borderPanel.add(westPanel, westData);  
	  
	        TabPanel centerPanel = new TabPanel(); 
	        centerPanel.setDeferredRender(false);  
	        centerPanel.setActiveTab(0);  
	  
	        EmployeeDetail centerPanelOne = new EmployeeDetail();
	        centerPanelOne.setHeight("500");
	        centerPanelOne.setWidth("500");
	        centerPanelOne.setTitle("Close Me");  
	        centerPanelOne.setAutoScroll(true);  
	        centerPanelOne.setClosable(true);  
	  
	        centerPanel.add(centerPanelOne);  
	  
	        Panel centerPanelTwo = new HTMLPanel();  
	        centerPanelTwo.setHtml(  
	                "<p>My closable attribute is set to false so you can't close me. The other center panels " +  
	                        "can be closed.</p>\n" +  
	                        "<p>The center panel automatically grows to fit the remaining space in the container " +  
	                        "that isn't taken up by the border regions.</p>\n" +  
	                        "<hr>\n" +  
	                        "<p>" + getShortBogusMarkup() + "</p>\n" +  
	                        "<p>" + getShortBogusMarkup() + "</p>\n" +  
	                        "<p>" + getShortBogusMarkup() + "</p>\n" +  
	                        "<p>" + getShortBogusMarkup() + "</p>\n");  
	        centerPanelTwo.setTitle("Center Panel");  
	        centerPanelTwo.setAutoScroll(true);  
	  
	        centerPanel.add(centerPanelTwo);  
	        borderPanel.add(centerPanel, new BorderLayoutData(RegionPosition.CENTER));  
	  
	        panel.add(borderPanel);  
	  
	        new Viewport(panel);  
	}
	
	 private static String getShortBogusMarkup() {  
	        return "<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +  
	                "Sed metus nibh, sodales a, porta at, vulputate eget, dui.  " +  
	                "In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, " +  
	                "cursus a, fringilla vel, urna.";  
	    }  
	
}
