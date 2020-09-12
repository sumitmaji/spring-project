package com.sum.hr.client.employee;

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
import com.sum.hr.shared.ModelColumn;
import com.sum.hr.shared.ServiceUrls;

public class EmployeeGrid extends Panel{
	private Store store;
	private GridPanel employeeGrid;
	private Renderer dateRenderer = new Renderer() {
		
		public String render(Object value, CellMetadata cellMetadata,
				Record record, int rowIndex, int colNum, Store store) {
			// TODO Auto-generated method stub
			Date dt = (Date)value;
			 
			return DateTimeFormat.getFormat("yy/dd/MM").format(dt);
		}
	};
	
	public EmployeeGrid(){
		setLayout(new FitLayout());
		setHeight(300);

		HttpProxy proxy = new HttpProxy(ServiceUrls.GET_EMPLOYEE_LIST, Connection.GET);
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new IntegerFieldDef(ModelColumn.EMPLOYEE_ID),
				new StringFieldDef(ModelColumn.EMPLOYEE_FIRST_NAME),
				new StringFieldDef(ModelColumn.EMPLOYEE_LAST_NAME),
				new DateFieldDef(ModelColumn.EMPLOYEE_HIRE_DATE,"Y-m-d"),
				new StringFieldDef(ModelColumn.EMPLOYEE_JOB_TITLE,ModelColumn.MAP_EMPLOYEE_JOB_TITLE),
				new StringFieldDef(ModelColumn.EMPLOYEE_DEPARTMENT_NAME,ModelColumn.MAP_EMPLOYEE_DEPARTMENT_NAME),
				new IntegerFieldDef(ModelColumn.EMPLOYEE_DEPARTMENT_ID,ModelColumn.MAP_EMPLOYEE_DEPARTMENT_ID)
				});
		XmlReader reader = new XmlReader(ModelColumn.EMPLOYEE_XML_READER, recordDef);
		reader.setTotalRecords(ModelColumn.COUNT_XML_READER);
		UrlParam[] urlParam = new UrlParam[]{
		};
		store = new Store(proxy, reader);
		store.setBaseParams(urlParam);
		ColumnConfig[] columns = new ColumnConfig[] {
				new ColumnConfig("Employee Id", "id", 80, true, null,
						"id"),
				new ColumnConfig("First Name", ModelColumn.EMPLOYEE_FIRST_NAME, 80),
				new ColumnConfig("Last Name", ModelColumn.EMPLOYEE_LAST_NAME, 80),
				new ColumnConfig("Hire Date", ModelColumn.EMPLOYEE_HIRE_DATE, 80,true, dateRenderer),
				new ColumnConfig("Job Title", ModelColumn.EMPLOYEE_JOB_TITLE, 80),
				new ColumnConfig("Department Name", ModelColumn.EMPLOYEE_DEPARTMENT_NAME, 80,true),
				new ColumnConfig("Department Name", ModelColumn.EMPLOYEE_DEPARTMENT_ID, 80,true),
				
				};
		ColumnModel columnModel = new ColumnModel(columns);
		
		employeeGrid = new GridPanel(store, columnModel);
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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public GridPanel getEmployeeGrid() {
		return employeeGrid;
	}

	public void setEmployeeGrid(GridPanel employeeGrid) {
		this.employeeGrid = employeeGrid;
	}
}
