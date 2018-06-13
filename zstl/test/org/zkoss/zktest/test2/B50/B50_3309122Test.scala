/* B50_3309122Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 16:57:36 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug 3309122
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3309122.zul,A,E,Grid,Model,onCreate,ROD")
class B50_3309122Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

			<zk>
			If you can see 10 and Western in the content, the bug has been fixed.
			<zscript><![CDATA[
			public class Employee {
			protected int id;
			protected String lastName;
			
			public Employee(int id, String lastName) {
			this.id = id;
			this.lastName = lastName;
			}
			public int getId() {
			return id;
			}
			public void setId(int id) {
			this.id = id;
			}
			public String getLastName() {
			return lastName;
			}
			
			public void setLastName(String lastName) {
			this.lastName = lastName;
			}
			
			}
			public class EmployeeService2 {
			public ArrayList getEmployees() {
			return EMPLOYEE_POOL;
			}
			
			protected static ArrayList EMPLOYEE_POOL = new ArrayList(3000);
			public EmployeeService2(){
			for(int i=0;i!=500;i++){
			EMPLOYEE_POOL.add(new Employee(10, "Western"));
			}
			}
			}
			
			public class MyRowRenderer implements RowRenderer{
			public void render(Row row, java.lang.Object data, int index) {
			Employee emp = (Employee)data;
			new Label(Integer.toString(emp.getId())).setParent(row);
			new Label(emp.getLastName()).setParent(row);
			}
			}
			
			public class MyGrid2 extends Grid{
			protected static EmployeeService2 provider;
			public ArrayList getEmployees(){
			return provider.getEmployees();
			}
			public SimpleListModel getMyModel(){
			return new SimpleListModel(getEmployees());
			}
			public MyRowRenderer getMyRenderer(){
			return new MyRowRenderer();
			}
			public void onCreate(){
			setModel(getMyModel());
			setRowRenderer(getMyRenderer());
			}
			public MyGrid2() {
			provider = new EmployeeService2();
			}
			}
			]]></zscript>
			
			<grid id="grid" use="MyGrid2" height="300px">
			<columns>
			<column label="Author"/>
			<column label="Title"/>
			</columns>
			</grid>
			</zk>

    """

    def executor = () => {
      var grid: Widget = engine.$f("grid");
      waitResponse();

      var $body: JQuery = jq(grid.$n("body"));

      var $rows: JQuery = $body.find(".z-rows");
      for (i <- 0 until 10) {
        var $row: JQuery = jq($rows.find(".z-row").get(i));
        verifyTrue($row.find(".z-label").get(0).get("innerHTML").contains("10"));
        verifyTrue($row.find(".z-label").get(1).get("innerHTML").contains("Western"));
      }
    }

    runZTL(zscript, executor);
  }
}