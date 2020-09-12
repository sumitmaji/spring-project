package com.sum.hr.client;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.gwtext.client.core.Connection;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.HttpProxy;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.data.XmlReader;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.PagingToolbar;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.grid.CellMetadata;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtext.client.widgets.layout.FitLayout;

public class EmployeeGridPanel extends Panel{
	private Store store;
	private Renderer dateRenderer = new Renderer() {
		
		public String render(Object value, CellMetadata cellMetadata,
				Record record, int rowIndex, int colNum, Store store) {
			// TODO Auto-generated method stub
			Date dt = (Date)value;
			 
			return DateTimeFormat.getFormat("yy/dd/MM").format(dt);
		}
	};
	
	public EmployeeGridPanel(){
		setLayout(new FitLayout());

		HttpProxy proxy = new HttpProxy("../xml/data/employee/getEmployees", Connection.GET);
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new IntegerFieldDef("id"),
				new StringFieldDef("firstName"),
				new StringFieldDef("lastName"),
				new DateFieldDef("hireDate","Y-m-d"),
				new StringFieldDef("jobTitle","job/jobTitle"),
				new StringFieldDef("deptName","deptId/deptName")				
				});
		XmlReader reader = new XmlReader("employee", recordDef);
		reader.setTotalRecords("count/totalCount");
		UrlParam[] urlParam = new UrlParam[]{
		};
		store = new Store(proxy, reader);
		store.setBaseParams(urlParam);
		ColumnConfig[] columns = new ColumnConfig[] {
				new ColumnConfig("Employee Id", "id", 80, true, null,
						"id"),
				new ColumnConfig("First Name", "firstName", 80),
				new ColumnConfig("Last Name", "lastName", 80),
				new ColumnConfig("Hire Date", "hireDate", 80,true, dateRenderer),
				new ColumnConfig("Job Title", "jobTitle", 80),
				new ColumnConfig("Department Name", "deptName", 80,true),
				
				};
		ColumnModel columnModel = new ColumnModel(columns);
		
		GridPanel employeeGrid = new GridPanel(store, columnModel);
		employeeGrid.setLayout(new FitLayout());
		employeeGrid.setLoadMask(true); 
		
		PagingToolbar pagingToolbar = new PagingToolbar(store);  
        pagingToolbar.setPageSize(10);  
        pagingToolbar.setDisplayInfo(true);
        pagingToolbar.setDisplayMsg("Displaying records {0} - {1} of {2}");  
        pagingToolbar.setEmptyMsg("No records to display");  
        employeeGrid.setBottomToolbar(pagingToolbar);
        
        employeeGrid.addListener(new PanelListenerAdapter() {  
            public void onRender(Component component) {  
                store.load(0, 10);  
            }  
        });  
        
		add(employeeGrid);
	}
}
