package com.sum.hr.client.employee;

import com.gwtext.client.core.Connection;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.RowSelectionModel;
import com.gwtext.client.widgets.grid.event.RowSelectionListener;
import com.gwtext.client.widgets.grid.event.RowSelectionListenerAdapter;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.sum.hr.shared.ModelColumn;
import com.sum.hr.shared.ServiceUrls;

public class EmployeeDetail extends Panel{

	private EmployeeForm employeeForm = new EmployeeForm();
	private EmployeeGrid employeeGrid = new EmployeeGrid();
	private RowSelectionModel sm;
	public EmployeeDetail(){
		setLayout(new VerticalLayout());
		
		sm = new RowSelectionModel();
		sm.addListener(new RowSelectionListenerAdapter() {
			@Override
			public void onRowSelect(RowSelectionModel sm, int rowIndex, Record record) {
				UrlParam[] urlParams = new UrlParam[]{
					new UrlParam(ModelColumn.EMPLOYEE_ID, record.getAsString(ModelColumn.EMPLOYEE_ID))	
				};
				getEmployeeForm().getFormPanel().getForm().load(ServiceUrls.GET_EMPLOYEE, urlParams, Connection.GET, ModelColumn.MESSAGE_LOAD);
			}
			
		});
		employeeGrid.getEmployeeGrid().setSelectionModel(sm);
		employeeGrid.doOnRender(new Function() {
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				sm.selectFirstRow();
			}
		},10);
		add(employeeGrid);
		add(employeeForm);
	}
	public EmployeeForm getEmployeeForm() {
		return employeeForm;
	}
	public void setEmployeeForm(EmployeeForm employeeForm) {
		this.employeeForm = employeeForm;
	}
	public EmployeeGrid getEmployeeGrid() {
		return employeeGrid;
	}
	public void setEmployeeGrid(EmployeeGrid employeeGrid) {
		this.employeeGrid = employeeGrid;
	}
}
